package activa.Expendio;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.vista.*;
import javax.swing.*;
import org.springframework.boot.autoconfigure.*;
import utils.*;

@SpringBootApplication
public class ExpendioApplication {

    public static final ValidacionApertura control = ValidacionApertura.getInstance("imagenes\\Activa");

    public static void main(String[] args) {
        try {
            /// estas dos lineas suavisan el dibujado del los textos del las ventanas no quitar
            System.setProperty("awt.useSystemAAFontSettings", "on");
            System.setProperty("swing.aatext", "true");
            @SuppressWarnings("rawtypes")
            final SwingWorker work = new SwingWorker() {
                GUISplashScreen a = new GUISplashScreen();

                @Override
                protected Object doInBackground() throws Exception {
                    Usuario usuario = new Usuario();
                    String retorno = Configuracion.cargarConfiguracion(usuario);
                    if (retorno.trim().equalsIgnoreCase("BIEN")) {
                        if (!"N".equals(Configuracion.validacionApertura)) {
                            if (!control.comprobar()) {
                                control.cerrarApp();
                            }
                        }

                        Servicios.iniciarServicios(args);
                        new GUIInicio(usuario);
                        a.dispose();
                    } else {
                        if (retorno.trim().equalsIgnoreCase("ERRORBD")) {
                            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeError, "Base de datos no configurada", "Error! Base de datos no configurada!", "");
                        } else if (retorno.trim().equalsIgnoreCase("ERRORDIR")) {
                            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeError, "Servidor no configurado", "Error! Servidor no configurado!", "");
                        } else if (retorno.trim().equalsIgnoreCase("ERRORPUERTO")) {
                            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeError, "Puerto no configurado", "Error! Puerto no configurado!", "");
                        } else if (retorno.trim().equalsIgnoreCase("ERROR")) {
                            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeError, "Archivo de configuraci�n no encontrado o da�ado", "Error! Archivo de configuraci�n no encontrado o da�ado!", "");
                        }
                        control.cerrarApp();
                    }

                    return null;
                }
            };
            work.execute();
        } catch (Exception e) {
            e.printStackTrace();
            control.cerrarApp();
        }
    }

}
