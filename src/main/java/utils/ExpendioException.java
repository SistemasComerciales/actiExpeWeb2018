package utils;

import java.io.*;

public class ExpendioException extends Exception {

    private static final long serialVersionUID = -1365259993247057314L;

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

    public static String getStackTrace(Exception ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

}
