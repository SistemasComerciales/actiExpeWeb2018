package activa.Expendio.modelo;

import activa.Expendio.controllers.*;
import activa.Expendio.persistencia.Interface.*;
import java.sql.*;
import utils.ExpendioException;
import utils.Log;

/**
 *
 * @author Usuario
 */
public class Bodega {

    private Long id;
    private String codigo;
    private String nombre;
    private Boolean estado;
    private Usuario usuario;
    private String accionUsuario;
    private boolean eliminado;
    private Timestamp creacion;
    private Timestamp modificacion;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the estado
     */
    public Boolean isEstado() {
        return estado;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the creacion
     */
    public Timestamp getCreacion() {
        return creacion;
    }

    /**
     * @param creacion the creacion to set
     */
    public void setCreacion(Timestamp creacion) {
        this.creacion = creacion;
    }

    /**
     * @return the modificacion
     */
    public Timestamp getModificacion() {
        return modificacion;
    }

    /**
     * @param modificacion the modificacion to set
     */
    public void setModificacion(Timestamp modificacion) {
        this.modificacion = modificacion;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the eliminado
     */
    public boolean isEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
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
        if (estado == null) {
            return "ESTADO";
        }
        if (esModificar && id == null) {
            return "ID";
        }
        return null;
    }

    public boolean validarExiste(boolean esModificar) throws ExpendioException {
        PersistenciaBodegaInt persistencia = Servicios.bodegasController.bodegasRepository;

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
        PersistenciaBodegaInt persistencia = Servicios.bodegasController.bodegasRepository;

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
        PersistenciaBodegaInt persistencia = Servicios.bodegasController.bodegasRepository;

        eliminado = false;
        accionUsuario = DatosBaseDatos.accionUsuarioModificar;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        return persistencia.modificar(this) != null;
    }

    public boolean borrar(Usuario usuario) {
        PersistenciaBodegaInt persistencia = Servicios.bodegasController.bodegasRepository;

        eliminado = true;
        accionUsuario = DatosBaseDatos.accionUsuarioEliminado;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        persistencia.eliminar(this);
        return true;
    }

}
