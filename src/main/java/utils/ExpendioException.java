package utils;

import java.io.*;

public class ExpendioException extends Exception {

    private static final long serialVersionUID = -1365259993247057314L;

    private static final String mensajeErrorBaseDatos = "Ha ocurrido un error con la base de datos. Por favor  inténtelo de nuevo";
    private static final String mensajeErrorInterfaz = "Ha ocurrido un error con la interfaz.";
    private static final String mensajeErrorSistema = "Ha ocurrido un error en el sistema. Por favor inténtelo de nuevo";
    private static final String mensajeErrorAbrirArchivo = "No se ha podido abrir el archivo.";
    private static final String mensajeErrorImportar = "No se ha podido importar el archivo.";
    private static final String mensajeErrorExportar = "No se ha podido exportar el archivo.";

    public static final String mensajeErrorCopiarArchivo = "Ha ocurrido un error al momento de copiar un archivo.";
    public static final String mensajeReintentar = "Int�ntelo de nuevo.";

    public ExpendioException(String mensaje) {
        super(mensaje);
    }

    public ExpendioException(Throwable ex) {
        super(ex);
    }

    public ExpendioException(String mensaje, Throwable ex) {
        super(mensaje, ex);
    }

    public static String getMensajeErrorBaseDatos() {
        return mensajeErrorBaseDatos;
    }

    public static String getMensajeErrorInterfaz() {
        return mensajeErrorInterfaz;
    }

    public static String getMensajeErrorSistema() {
        return mensajeErrorSistema;
    }

    public static String getMensajeErrorAbrirArchivo() {
        return mensajeErrorAbrirArchivo;
    }

    public static String getMensajeErrorExportar() {
        return mensajeErrorExportar;
    }

    public static String getMensajeErrorImportar() {
        return mensajeErrorImportar;
    }

    public static String getStackTrace(Exception ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

}
