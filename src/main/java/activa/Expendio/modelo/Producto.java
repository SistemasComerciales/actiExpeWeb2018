/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

import java.sql.Timestamp;

/**
 *
 * @author Administrador
 */
public class Producto {
    private long id;
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
    private String estado;
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
     * @return the presentacion
     */
    public String getPresentacion() {
        return presentacion;
    }

    /**
     * @param presentacion the presentacion to set
     */
    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    /**
     * @return the grupo
     */
    public GrupoProducto getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(GrupoProducto grupo) {
        this.grupo = grupo;
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
     * @return the afectaCupo
     */
    public boolean isAfectaCupo() {
        return afectaCupo;
    }

    /**
     * @param afectaCupo the afectaCupo to set
     */
    public void setAfectaCupo(boolean afectaCupo) {
        this.afectaCupo = afectaCupo;
    }

    /**
     * @return the controlSerial
     */
    public boolean isControlSerial() {
        return controlSerial;
    }

    /**
     * @param controlSerial the controlSerial to set
     */
    public void setControlSerial(boolean controlSerial) {
        this.controlSerial = controlSerial;
    }

    /**
     * @return the precio10Porciento
     */
    public boolean isPrecio10Porciento() {
        return precio10Porciento;
    }

    /**
     * @param precio10Porciento the precio10Porciento to set
     */
    public void setPrecio10Porciento(boolean precio10Porciento) {
        this.precio10Porciento = precio10Porciento;
    }

    /**
     * @return the codigoBarras
     */
    public String getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * @param codigoBarras the codigoBarras to set
     */
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
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
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
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
     * @return the eliminado
     */
    public boolean getEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
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
    
    
    public void eliminar(){
        this.eliminado = true;
    }
    
    public boolean estaEliminado(){
        return eliminado;
    }
    
}
