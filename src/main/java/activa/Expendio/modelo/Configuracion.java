package activa.Expendio.modelo;

import java.io.*;
import javax.swing.JFrame;
import utils.*;

/**
 *
 * @author Avuunita
 */
public class Configuracion {

    /**
     * Direccion donde se encuentra el servidor.
     */
    public static String direccionServidor;

    /**
     * Nombre de la BD.
     */
    public static String baseDatos;

    /**
     * Puerto de conexion al servidor.
     */
    public static String puerto;

    /**
     * Ruta donde se encuentran los reportes personalizados.
     */
    public static String direccionReportes;

    /**
     * Direccion URL.
     */
    public static String direccionUrl;

    /**
     * Anio del periodo contable actual.
     */
    public static String periodoContable;

    /**
     * Validacion de abrir mas de un programa.
     */
    public static String validacionApertura = "";

    /**
     * Codigo identificador del establecimiento - solo digitos.
     */
    public static int codigoEstablecimiento;

    /**
     * Nombre del establecimiento.
     */
    public static String nombreEstablecimiento;

    /**
     * NIT del establecimiento.
     */
    public static String nitEstablecimiento;

    /**
     * Tipo del establecimiento.
     */
    public static String tipoEstablecimiento;

    /**
     * 0 = Direccion Servidor<br>
     * 1 = Base Datos<br>
     * 2 = Puerto<br>
     * 3 = Direccion Archivos<br>
     * 4 = Direccion URL<br>
     * 5 = Periodo Contable<br>
     * 6 = Validacion de Apertura<br>
     * 7 = Codigo Establecimiento<br>
     * 8 = Nombre Establecimiento<br>
     * 9 = NIT Establecimiento<br>
     * 10 = Tipo Establecimiento<br>
     */
    public static final String direccionamientoConfiguracion = "config.txt";
    private static final File LOG_FILECONFIGURACION = new File(direccionamientoConfiguracion);

    /**
     * Metodo encargado de guardar la configuracion.
     *
     * @return
     */
    public static String guardarConfiguracion() {

        try {
            FileWriter out = new FileWriter(LOG_FILECONFIGURACION, false);
            PrintWriter log = new PrintWriter(out);

            log.println(direccionServidor);
            log.println(baseDatos);
            log.println(puerto);
            log.println(direccionReportes);
            log.println(direccionUrl);
            log.println(periodoContable);
            log.println(validacionApertura);
            log.println(codigoEstablecimiento);
            log.println(nombreEstablecimiento);
            log.println(nitEstablecimiento);
            log.println(tipoEstablecimiento);

            log.close();
            out.close();
            return "GUARDO";
        } catch (IOException ex) {
            Log.adicionar(ex, "4227", null, "Ha ocurrido un error con el archivo.");
            return "ERROR";
        } catch (Exception exp) {
            Log.adicionar(exp, "4228", null, "Ha ocurrido un error con el archivo.");
            return "ERROR";
        }
    }

    /**
     * Metodo encargado de crear la configuracion.
     *
     * @return ERROR, ARCHIVONO, BIEN, ERRORBD = NO esta configurado el nombre
     * de la base de datos ERRORDIR = NO hay direccion de servidor ERRORPUERTO =
     * NO hay puerto
     */
    public static String cargarConfiguracion(Usuario usuario) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(direccionamientoConfiguracion);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String linea;
            int fila = 0;

            validacionApertura = "S";

            while ((linea = br.readLine()) != null) {
                switch (fila) {
                    case 0:
                        direccionServidor = linea;
                        break;
                    case 1:
                        baseDatos = linea;
                        break;
                    case 2:
                        puerto = linea;
                        break;
                    case 3:
                        direccionReportes = linea;
                        break;
                    case 4:
                        direccionUrl = linea;
                        break;
                    case 5:
                        periodoContable = linea;
                        break;
                    case 6:
                        validacionApertura = linea;
                        break;
                    case 7:
                        codigoEstablecimiento = Integer.parseInt(linea);
                        break;
                    case 8:
                        nombreEstablecimiento = linea;
                        break;
                    case 9:
                        nitEstablecimiento = linea;
                        break;
                    case 10:
                        tipoEstablecimiento = linea;
                        break;
                    default:
                        break;
                }
                fila++;
            }

            if (baseDatos.trim().isEmpty()) {
                return "ERRORBD";
            } else if (direccionServidor.trim().isEmpty()) {
                return "ERRORDIR";
            } else if (puerto.trim().isEmpty()) {
                return "ERRORPUERTO";
            }
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            Log.adicionar(ex, "cargarConfiguracion()", null, "El codigo del establecimiento debe ser un numero entero.");
            return "ERROR";
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Log.adicionar(ex, "cargarConfiguracion()", null, "No se encuentra el archivo de direccionamiento al reporte o esta dañado.");
            return "ERROR";
        } catch (Exception ex) {
            ex.printStackTrace();
            Log.adicionar(ex, "4230", null, "No se encuentra el archivo de direccionamiento al reporte o esta dañado.");
            return "ERROR";
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                Log.adicionar(ex, "4231", null, "Ha ocurrido un error con el direccionamiento 2");
                return "ERROR";
            }
        }
        return "BIEN";
    }
}
