/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

import java.util.Date;

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
    private long valor;
    private long cajasEspeciales;
    private String observaciones;
    private boolean eliminado;
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
    public long getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(long valor) {
        this.valor = valor;
    }

    /**
     * @return the cajasEspeciales
     */
    public long getCajasEspeciales() {
        return cajasEspeciales;
    }

    /**
     * @param cajasEspeciales the cajasEspeciales to set
     */
    public void setCajasEspeciales(long cajasEspeciales) {
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
    
    
}
