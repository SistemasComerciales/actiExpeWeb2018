package activa.Expendio.modelo;

import activa.Expendio.ExpendioApplication;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import utils.*;

/**
 *
 * @author Administrador
 */
public class Interno {

    private Long id;
    private String td;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String nui;
    private String nacionalidad;
    private String situacionJuridica;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String delito;
    private String observaciones;
    private Boolean estado;
    private Usuario usuario;
    private String accionUsuario;
    private boolean eliminado;
    private Timestamp creacion;
    private Timestamp modificacion;
    private String rutaImagen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTd() {
        return td;
    }

    public void setTd(String td) {
        this.td = td;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getNui() {
        return nui;
    }

    public void setNui(String nui) {
        this.nui = nui;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getSituacionJuridica() {
        return situacionJuridica;
    }

    public void setSituacionJuridica(String situacionJuridica) {
        this.situacionJuridica = situacionJuridica;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDelito() {
        return delito;
    }

    public void setDelito(String delito) {
        this.delito = delito;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAccionUsuario() {
        return accionUsuario;
    }

    public void setAccionUsuario(String accionUsuario) {
        this.accionUsuario = accionUsuario;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public Timestamp getCreacion() {
        return creacion;
    }

    public void setCreacion(Timestamp creacion) {
        this.creacion = creacion;
    }

    public Timestamp getModificacion() {
        return modificacion;
    }

    public void setModificacion(Timestamp modificacion) {
        this.modificacion = modificacion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String validarCamposObligatorios(boolean esModificar) {
        if (td == null || (td != null && td.trim().isEmpty())) {
            return "TD";
        }
        if (nui == null || (nui != null && nui.trim().isEmpty())) {
            return "NUI";
        }
        if (primerApellido == null || (primerApellido != null && primerApellido.trim().isEmpty())) {
            return "PRIMERAPELLIDO";
        }
        if (segundoApellido == null || (segundoApellido != null && segundoApellido.trim().isEmpty())) {
            return "SEGUNDOAPELLIDO";
        }
        if (primerNombre == null || (primerNombre != null && primerNombre.trim().isEmpty())) {
            return "PRIMERNOMBRE";
        }
//        if (segundoNombre == null || (segundoNombre != null && segundoNombre.trim().isEmpty())) {
//            return "SEGUNDONOMBRE";
//        }
        if (nacionalidad == null || (nacionalidad != null && nacionalidad.trim().isEmpty())) {
            return "NACIONALIDAD";
        }
        if (situacionJuridica == null || (situacionJuridica != null && situacionJuridica.trim().isEmpty())) {
            return "SITUACIONJURIDICA";
        }
        if (fechaIngreso == null) {
            return "FECHAINGRESO";
        }
//        if (fechaSalida == null) {
//            return "FECHASALIDA";
//        }
//        if (delito == null || (delito != null && delito.trim().isEmpty())) {
//            return "DELITO";
//        }
//        if (observaciones == null || (observaciones != null && observaciones.trim().isEmpty())) {
//            return "OBSERVACIONES";
//        }
        if (rutaImagen == null || (rutaImagen != null && rutaImagen.trim().isEmpty())) {
            return "RUTAFOTO";
        }
        if (estado == null) {
            return "ESTADO";
        }
        if (esModificar && id == null) {
            return "ID";
        }
        return null;
    }

    public boolean validarExiste(boolean esModificar) throws ExpendioException {
        PersistenciaInternoInt persistencia = ExpendioApplication.internosController.internosRepository;

        try {
            boolean existe = false;
            if ((persistencia.existeTD(this) || persistencia.existeNUI(this)) && !persistencia.existeID(this)) {
                existe = true;
            }

            return existe;
        } catch (Exception ex) {
            Log.adicionar(ex, "26", usuario, ExpendioException.getMensajeErrorBaseDatos());
            throw new ExpendioException(ex);
        }
    }

    public boolean insertar(Usuario usuario) {
        PersistenciaInternoInt persistencia = ExpendioApplication.internosController.internosRepository;

        long ultimoId = persistencia.getNoEliminados().size();
        if (ultimoId == -1) {
            ultimoId = 0;
        }
        ultimoId++;

        id = ultimoId;

        eliminado = false;
        accionUsuario = DatosBaseDatos.accionUsuarioInsertar;
        this.usuario = usuario;
        creacion = new Timestamp(System.currentTimeMillis());
        modificacion = new Timestamp(System.currentTimeMillis());

        return persistencia.adicionar(this) != null;
    }

    public boolean modificar(Usuario usuario) {
        PersistenciaInternoInt persistencia = ExpendioApplication.internosController.internosRepository;

        eliminado = false;
        accionUsuario = DatosBaseDatos.accionUsuarioModificar;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        return persistencia.modificar(this) != null;
    }

    public boolean borrar(Usuario usuario) {
        PersistenciaInternoInt persistencia = ExpendioApplication.internosController.internosRepository;

        eliminado = true;
        accionUsuario = DatosBaseDatos.accionUsuarioEliminado;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        persistencia.eliminar(this);
        return true;
    }

    public static String traerUltimoNumeroTdInterno(Usuario usuario) {
        PersistenciaInternoInt persistencia = ExpendioApplication.internosController.internosRepository;

        ArrayList<Interno> internos = persistencia.getNoEliminados();

        // Obtener el TD maximo.
        long max = -1;
        for (Interno interno : internos) {
            long td = Long.parseLong(interno.getTd());
            if (td > max) {
                max = td;
            }
        }

        if (max == -1) {// no se encontro un interno en el establecimiento
            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeInformacion, "Numeración actual.", "No se ha encontrado ningún TD en el establecimiento.", " Se reiniciará la numeración.");
            return Configuracion.codigoEstablecimiento + "000000";
        } else {
            return String.valueOf(max);
        }
    }

}
