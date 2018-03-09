/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

/**
 *
 * @author Usuario
 */
public class TransaccionItem {
    private Producto producto;
    private Bodega bodega;
    private double cantidad;
    private double valorUnitario;
    private String descripcionItem; 

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
     * @return the descripcionItem
     */
    public String getDescripcionItem() {
        return descripcionItem;
    }

    /**
     * @param descripcionItem the descripcionItem to set
     */
    public void setDescripcionItem(String descripcionItem) {
        this.descripcionItem = descripcionItem;
    }
}
