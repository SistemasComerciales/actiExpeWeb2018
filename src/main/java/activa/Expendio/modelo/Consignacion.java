package activa.Expendio.modelo;

import java.sql.*;
import java.util.Date;
import utils.*;

/**
 *
 * @author Administrador
 */
public class Consignacion {

    private long id;
    private String numeroTransaccion;
    private Date fecha;
    private Interno interno;
    private String concepto;
    private String numeroRecibo;
    private double valor;
    private double cajasEspeciales;
    private String observaciones;
    private boolean eliminado;
    private String mensajeCampoObligatorio;
    private Usuario usuario;
    private Timestamp creacion;
    private Timestamp modificacion;

    /**
     * @return the numeroTransaccion
     */
    public String getNumeroTransaccion() {
        return numeroTransaccion;
    }

    /**
     * @param numeroTransaccion the numeroTransaccion to set
     */
    public void setNumeroTransaccion(String numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the interno
     */
    public Interno getInterno() {
        return interno;
    }

    /**
     * @param interno the interno to set
     */
    public void setInterno(Interno interno) {
        this.interno = interno;
    }

    /**
     * @return the concepto
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the numeroRecibo
     */
    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    /**
     * @param numeroRecibo the numeroRecibo to set
     */
    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * @return the cajasEspeciales
     */
    public double getCajasEspeciales() {
        return cajasEspeciales;
    }

    /**
     * @param cajasEspeciales the cajasEspeciales to set
     */
    public void setCajasEspeciales(double cajasEspeciales) {
        this.cajasEspeciales = cajasEspeciales;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public String getFechaString() {
        return Fecha.obtenerFechaString(fecha);
    }

    /**
     * Metodo encargado de validar los datos
     *
     * @return
     */
    public boolean validarDatosObligatorios() {
        setMensajeCampoObligatorio("");
        if (numeroTransaccion.trim().isEmpty()) {
            setMensajeCampoObligatorio("El número de la transacción no puede ir vacio");
            return false;
        } else if (fecha == null) {
            setMensajeCampoObligatorio("La fecha no puede ir vacia");
            return false;
        } else if (interno == null) {
            setMensajeCampoObligatorio("Por favor seleccione un interno");
            return false;
        } else if (concepto.trim().isEmpty()) {
            setMensajeCampoObligatorio("Por favor seleccione un concepto");
            return false;
        } else if (numeroRecibo.trim().isEmpty()) {
            setMensajeCampoObligatorio("El número del recibo no puede ir vacio");
            return false;
        } else if (valor == 0) {
            setMensajeCampoObligatorio("El valor no puede ir vacio");
            return false;
        } else {
            return true;
        }
    }

    /**
     * @return the mensajeCampoObligatorio
     */
    public String getMensajeCampoObligatorio() {
        return mensajeCampoObligatorio;
    }

    /**
     * @param mensajeCampoObligatorio the mensajeCampoObligatorio to set
     */
    public void setMensajeCampoObligatorio(String mensajeCampoObligatorio) {
        this.mensajeCampoObligatorio = mensajeCampoObligatorio;
    }

}
