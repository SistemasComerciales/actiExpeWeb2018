package activa.Expendio.modelo;

import activa.Expendio.controllers.*;
import activa.Expendio.persistencia.Interface.*;
import java.sql.*;
import utils.*;

/**
 *
 * @author Administrador
 */
public class Producto {

    private Long id;
    private String codigo;
    private String nombre;
    private String presentacion;
    private GrupoProducto grupo;
    private boolean controlExistencia;
    private boolean afectaCupo;
    private boolean controlSerial;
    private boolean precio10Porciento;
    private String codigoBarras;
    private String observaciones;
    private Boolean estado;
    private Usuario usuario;
    private String accionUsuario;
    private boolean eliminado;
    private Timestamp creacion;
    private Timestamp modificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public GrupoProducto getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoProducto grupo) {
        this.grupo = grupo;
    }

    public boolean isControlExistencia() {
        return controlExistencia;
    }

    public void setControlExistencia(boolean controlExistencia) {
        this.controlExistencia = controlExistencia;
    }

    public boolean isAfectaCupo() {
        return afectaCupo;
    }

    public void setAfectaCupo(boolean afectaCupo) {
        this.afectaCupo = afectaCupo;
    }

    public boolean isControlSerial() {
        return controlSerial;
    }

    public void setControlSerial(boolean controlSerial) {
        this.controlSerial = controlSerial;
    }

    public boolean isPrecio10Porciento() {
        return precio10Porciento;
    }

    public void setPrecio10Porciento(boolean precio10Porciento) {
        this.precio10Porciento = precio10Porciento;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
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

    public String getAccionUsuario() {
        return accionUsuario;
    }

    public void setAccionUsuario(String accionUsuario) {
        this.accionUsuario = accionUsuario;
    }

    public String validarCamposObligatorios(boolean esModificar) {
        if (codigo == null || (codigo != null && codigo.trim().isEmpty())) {
            return "CODIGO";
        }
        if (nombre == null || (nombre != null && nombre.trim().isEmpty())) {
            return "NOMBRE";
        }
        if (presentacion == null || (presentacion != null && presentacion.trim().isEmpty())) {
            return "PRESENTACION";
        }
        if (codigoBarras == null || (codigoBarras != null && codigoBarras.trim().isEmpty())) {
            return "CODIGOBARRAS";
        }
//        if (grupo == null) {
//            return "GRUPO";
//        }
//        if (observaciones == null || (observaciones != null && observaciones.trim().isEmpty())) {
//            return "OBSERVACIONES";
//        }
        if (estado == null) {
            return "ESTADO";
        }
        if (esModificar && id == null) {
            return "ID";
        }
        return null;
    }

    public boolean validarExiste(boolean esModificar) throws ExpendioException {
        PersistenciaProductoInt persistencia = Servicios.productosController.productosRepository;

        try {
            boolean existe = false;
            if (persistencia.validarExiste(this) && !persistencia.existeID(this)) {
                existe = true;
            }

            return existe;
        } catch (Exception ex) {
            Log.adicionar(ex, "26", usuario, ExpendioException.getMensajeErrorBaseDatos());
            throw new ExpendioException(ex);
        }
    }

    public boolean insertar(Usuario usuario) {
        PersistenciaProductoInt persistencia = Servicios.productosController.productosRepository;

        long ultimoId = persistencia.consultarTodos().size();
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
        PersistenciaProductoInt persistencia = Servicios.productosController.productosRepository;

        eliminado = false;
        accionUsuario = DatosBaseDatos.accionUsuarioModificar;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        return persistencia.modificar(this) != null;
    }

    public boolean borrar(Usuario usuario) {
        PersistenciaProductoInt persistencia = Servicios.productosController.productosRepository;

        eliminado = true;
        accionUsuario = DatosBaseDatos.accionUsuarioEliminado;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        persistencia.eliminar(this);
        return true;
    }

}
