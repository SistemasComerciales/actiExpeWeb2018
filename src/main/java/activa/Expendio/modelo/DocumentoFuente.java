package activa.Expendio.modelo;

import activa.Expendio.controllers.*;
import activa.Expendio.persistencia.Interface.*;
import java.sql.*;
import utils.*;

/**
 *
 * @author Usuario
 */
public class DocumentoFuente {

    private Long id;
    private String codigo;
    private String nombre;
    private String accion;
    private String aplica;
    private boolean numera;
    private String numero;
    private boolean controlExistencia;
    private boolean docBase;
    private boolean precioFijo;
    private boolean listaPrecio;
    private boolean costeoInventario;
    private Bodega bodega;
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

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getAplica() {
        return aplica;
    }

    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    public boolean isNumera() {
        return numera;
    }

    public void setNumera(boolean numera) {
        this.numera = numera;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isControlExistencia() {
        return controlExistencia;
    }

    public void setControlExistencia(boolean controlExistencia) {
        this.controlExistencia = controlExistencia;
    }

    public boolean isDocBase() {
        return docBase;
    }

    public void setDocBase(boolean docBase) {
        this.docBase = docBase;
    }

    public boolean isPrecioFijo() {
        return precioFijo;
    }

    public void setPrecioFijo(boolean precioFijo) {
        this.precioFijo = precioFijo;
    }

    public boolean isListaPrecio() {
        return listaPrecio;
    }

    public void setListaPrecio(boolean listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    public boolean isCosteoInventario() {
        return costeoInventario;
    }

    public void setCosteoInventario(boolean costeoInventario) {
        this.costeoInventario = costeoInventario;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
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
        if (accion == null || (accion != null && accion.trim().isEmpty())) {
            return "ACCION";
        }
        if (aplica == null || (aplica != null && aplica.trim().isEmpty())) {
            return "APLICA";
        }
        if (numera && (numero == null || (numero != null && numero.trim().isEmpty()))) {
            return "NUMERO";
        }
//        if (bodega == null) {
//            return "BODEGA";
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
        PersistenciaDocFuenteInt persistencia = Servicios.documentosController.documentosRepository;

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
        PersistenciaDocFuenteInt persistencia = Servicios.documentosController.documentosRepository;

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
        PersistenciaDocFuenteInt persistencia = Servicios.documentosController.documentosRepository;

        eliminado = false;
        accionUsuario = DatosBaseDatos.accionUsuarioModificar;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        return persistencia.modificar(this) != null;
    }

    public boolean borrar(Usuario usuario) {
        PersistenciaDocFuenteInt persistencia = Servicios.documentosController.documentosRepository;

        eliminado = true;
        accionUsuario = DatosBaseDatos.accionUsuarioEliminado;
        this.usuario = usuario;
        modificacion = new Timestamp(System.currentTimeMillis());

        persistencia.eliminar(this);
        return true;
    }

}
