package activa.Expendio.modelo;

import activa.Expendio.controllers.*;
import activa.Expendio.persistencia.Interface.*;
import java.sql.*;
import utils.*;

/**
 *
 * @author Administrador
 */
public class GrupoProducto {

    private Long id;
    private String codigo;
    private String nombre;
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
        PersistenciaGrupoProductoInt persistencia = Servicios.gruposController.gruposRepository;

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
        PersistenciaGrupoProductoInt persistencia = Servicios.gruposController.gruposRepository;

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
        PersistenciaGrupoProductoInt persistencia = Servicios.gruposController.gruposRepository;

        eliminado = false;
        accionUsuario = DatosBaseDatos.accionUsuarioModificar;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        return persistencia.modificar(this) != null;
    }

    public boolean borrar(Usuario usuario) {
        PersistenciaGrupoProductoInt persistencia = Servicios.gruposController.gruposRepository;

        eliminado = true;
        accionUsuario = DatosBaseDatos.accionUsuarioEliminado;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        persistencia.eliminar(this);
        return true;
    }

}
