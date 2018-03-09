package activa.Expendio;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import utils.*;

@SpringBootApplication
public class ExpendioApplication {

    public static final ValidacionApertura control = ValidacionApertura.getInstance("imagenes\\Activa");

    public static void main(String[] args) {
        try {
            Establecimiento establecimiento = new Establecimiento();
            establecimiento.setCodigo("530");
            establecimiento.setNombre("QUIBDÓ");
            establecimiento.setNit("");
            establecimiento.setTipo("P");

            Usuario usuario = new Usuario();
            usuario.setPeriodoContable("2018");
            usuario.setLogin("SUPERVISOR");
            usuario.setNombres("Supervisor");
            new GUIInicio(usuario, establecimiento);
            SpringApplication.run(ExpendioApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
            control.cerrarApp();
        }

    }
}
