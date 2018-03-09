/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
public class DocumentoFuente {
    private long id;
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
    private int idBodega;
    private boolean estado;
    private Usuario usuario;
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
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the accion
     */
    public String getAccion() {
        return accion;
    }

    /**
     * @param accion the accion to set
     */
    public void setAccion(String accion) {
        this.accion = accion;
    }

    /**
     * @return the aplica
     */
    public String getAplica() {
        return aplica;
    }

    /**
     * @param aplica the aplica to set
     */
    public void setAplica(String aplica) {
        this.aplica = aplica;
    }

    /**
     * @return the numera
     */
    public boolean isNumera() {
        return numera;
    }

    /**
     * @param numera the numera to set
     */
    public void setNumera(boolean numera) {
        this.numera = numera;
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
     * @return the controlExistencia
     */
    public boolean isControlExistencia() {
        return controlExistencia;
    }

    /**
     * @param controlExistencia the controlExistencia to set
     */
    public void setControlExistencia(boolean controlExistencia) {
        this.controlExistencia = controlExistencia;
    }

    /**
     * @return the docBase
     */
    public boolean isDocBase() {
        return docBase;
    }

    /**
     * @param docBase the docBase to set
     */
    public void setDocBase(boolean docBase) {
        this.docBase = docBase;
    }

    /**
     * @return the precioFijo
     */
    public boolean isPrecioFijo() {
        return precioFijo;
    }

    /**
     * @param precioFijo the precioFijo to set
     */
    public void setPrecioFijo(boolean precioFijo) {
        this.precioFijo = precioFijo;
    }

    /**
     * @return the listaPrecio
     */
    public boolean isListaPrecio() {
        return listaPrecio;
    }

    /**
     * @param listaPrecio the listaPrecio to set
     */
    public void setListaPrecio(boolean listaPrecio) {
        this.listaPrecio = listaPrecio;
    }

    /**
     * @return the costeoInventario
     */
    public boolean isCosteoInventario() {
        return costeoInventario;
    }

    /**
     * @param costeoInventario the costeoInventario to set
     */
    public void setCosteoInventario(boolean costeoInventario) {
        this.costeoInventario = costeoInventario;
    }

    /**
     * @return the idBodega
     */
    public int getIdBodega() {
        return idBodega;
    }

    /**
     * @param idBodega the idBodega to set
     */
    public void setIdBodega(int idBodega) {
        this.idBodega = idBodega;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
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
