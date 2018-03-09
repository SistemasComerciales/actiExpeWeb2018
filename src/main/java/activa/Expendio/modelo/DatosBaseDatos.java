package activa.Expendio.modelo;

public class DatosBaseDatos {
    //Estado

    public static final String estadoActivoBD = "A";
    public static final String estadoInactivoBD = "I";
    public static final String estadoAnuladoBD = "A";
    public static final String estadoNuloBD = "N";
    public static final String estadoRetiradoBD = "R";

    public static final String estadoActivo = "Activo";
    public static final String estadoInactivo = "Inactivo";
    public static final String estadoNulo = "Anulado";
    public static final String estadoRetirado = "Retirado";

    //Accion Usuario
    public static final String accionUsuarioInsertar = "I";
    public static final String accionUsuarioModificar = "M";
    public static final String accionUsuarioEliminado = "E";
    public static final String accionUsuarioGenerado = "G";

    //Si No
    public static final String varSiBD = "S";
    public static final String varNoBD = "N";

    public static final String varSi = "Sí";
    public static final String varNo = "No";

    public static final String fechaActualBD = "SYSDATE()";

    public static final String formatoFechaConsultaBD = "\"%d/%m/%Y\"";

}
