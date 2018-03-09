/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Transaccion {
    private DocumentoFuente documento;
    private String numero;
    private Date fecha;
    private Interno interno;
    private String condicion;
    private Producto producto;
    private Bodega bodega;
    private double cantidad;
    private double valorUnitario;
    private Usuario usuario;
    private Timestamp creacion;
    private Timestamp modificacion;
    
    
    /**
     * @return the documento
     */
    public DocumentoFuente getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(DocumentoFuente documento) {
        this.documento = documento;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
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
     * @return the condicion
     */
    public String getCondicion() {
        return condicion;
    }

    /**
     * @param condicion the condicion to set
     */
    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    /**
     * @return the producto
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    /**
     * @return the bodega
     */
    public Bodega getBodega() {
        return bodega;
    }

    /**
     * @param bodega the bodega to set
     */
    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the valorUnitario
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * @param valorUnitario the valorUnitario to set
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
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
    
    
    
}
