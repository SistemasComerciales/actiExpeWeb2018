package utils;

import java.io.*;
import java.util.*;

import javax.swing.*;

public class Log implements Serializable {

    private static final long serialVersionUID = -7797748227390316289L;

    private static final String NAME_LOGFILE = "Log.log";
    private static final File LOG_FILE = new File(NAME_LOGFILE);

    public static void adicionar(Exception excepcion) {
        try {
            FileWriter out = new FileWriter(LOG_FILE, true);
            PrintWriter log = new PrintWriter(out);
            log.println("---------------------------------------- INICIO ---------------------------------------");
            log.println("---------------------------------- Datos Principales ----------------------------------");
            log.println("Fecha :" + new Date().toString());
            log.println("---------------------------------------- Error ----------------------------------------");
            excepcion.printStackTrace(log);
            log.println("---------------------------------------------------------------------------------------");
            log.println("----------------------------------------- FIN -----------------------------------------");
            log.close();
            out.close();
        } catch (IOException e) {
            JOptionPane.showOptionDialog(null, "Ha ocurrido un error con el archivo Log.", "Error (2897)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
        }
    }

    public static void adicionar(Exception excepcion, String codigoError, String mensajePantalla) {
        try {
            FileWriter out = new FileWriter(LOG_FILE, true);
            PrintWriter log = new PrintWriter(out);
            log.println("---------------------------------------- INICIO ---------------------------------------");
            log.println("---------------------------------- Datos Principales ----------------------------------");
            log.println("Fecha :" + new Date().toString().trim());
            log.println("Codigo del error :" + codigoError.trim());

            log.println("Mensaje pantalla : " + mensajePantalla.trim());
            log.println("---------------------------------------- Error ----------------------------------------");
            if (excepcion != null) {
                excepcion.printStackTrace(log);
            } else {
                log.println("----------------------------Exception is null--------------------------------");
            }
            log.println("---------------------------------------------------------------------------------------");
            log.println("----------------------------------------- FIN -----------------------------------------");
            log.println("");
            log.println("");
            log.close();
            out.close();
        } catch (IOException e) {
            JOptionPane.showOptionDialog(null, "Ha ocurrido un error con el archivo Log.", "Error (2898)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
        }
    }

    public static void adicionarCS(Exception excepcion, String codigoError, String sentencia, String mensajePantalla) {
        try {
            FileWriter out = new FileWriter(LOG_FILE, true);
            PrintWriter log = new PrintWriter(out);
            log.println("---------------------------------------- INICIO ---------------------------------------");
            log.println("---------------------------------- Datos Principales ----------------------------------");
            log.println("Fecha : " + new Date().toString().trim());
            log.println("Codigo del error : " + codigoError.trim());

            log.println("Sentencia : " + sentencia);
            log.println("Mensaje pantalla : " + mensajePantalla);
            log.println("---------------------------------------- Error ----------------------------------------");
            if (excepcion != null) {
                excepcion.printStackTrace(log);
            } else {
                log.println("----------------------------Exception is null--------------------------------");
            }
            log.println("---------------------------------------------------------------------------------------");
            log.println("----------------------------------------- FIN -----------------------------------------");
            log.close();
            out.close();
        } catch (IOException e) {
            JOptionPane.showOptionDialog(null, "Ha ocurrido un error con el archivo Log.", "Error (2899)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
        }
    }

    /**
     * Metodo encargado de adicionar un mensaje respecto a la apertura de libros
     *
     * @param mensaje
     */
    public static void addMensajeAperturaLibros(String mensaje, String sql) {
        try {

            FileWriter out = new FileWriter(LOG_FILE, true);
            PrintWriter log = new PrintWriter(out);
            log.println("---------------------------------------- INICIO ---------------------------------------");
            log.println("---------------------------------- Datos Principales ----------------------------------");
            log.println("----------------------------------  Apertura Libros  ----------------------------------");
            log.println("Fecha :" + new Date().toString());
            log.println("---------------------------------------- Error ----------------------------------------");
            log.println("Sentencia: " + sql);
            log.println(mensaje);
            log.println("---------------------------------------------------------------------------------------");
            log.println("----------------------------------------- FIN -----------------------------------------");
            log.close();
            out.close();
        } catch (IOException e) {
            JOptionPane.showOptionDialog(null, "Ha ocurrido un error con el archivo Log.", "Error (10206)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
        }
    }
}
