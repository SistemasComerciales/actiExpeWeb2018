/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

import activa.Expendio.controllers.Servicios;
import activa.Expendio.persistencia.Interface.PersistenciaTransaccionInt;
import activa.Expendio.vista.ClaseGeneral;
import activa.Expendio.vista.GUIJOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrador
 */

public class Transaccion  {
    private long id;
    private DocumentoFuente documento;
    private String numero;
    private Date fecha;
    private Interno interno;
    private String condicion;
    private ArrayList<TransaccionItem> listItem;
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
     * @return the listItem
     */
    public ArrayList<TransaccionItem> getListItem() {
        return listItem;
    }

    /**
     * @param listItem the listItem to set
     */
    public void setListItem(ArrayList<TransaccionItem> listItem) {
        this.listItem = listItem;
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
      public static String traerUltimoNumerotransaccion(Usuario usuario) {
        PersistenciaTransaccionInt persistencia = Servicios.transaccionController.transaccionRepository;

        ArrayList<Transaccion> transacciones = persistencia.getListaTransacciones();

        // Obtener el TD maximo.
        long max = -1;
        for (Transaccion transaccion : transacciones) {
            long numero = Long.parseLong(transaccion.getNumero());
            if (numero > max) {
                max = numero;
            }
        }

        if (max == -1) {// no se encontro un interno en el establecimiento
            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeInformacion, "Numeración actual.", "No se ha encontrado ningún numero.", " Se reiniciará la numeración.");
            return  "0";
        } else {
            return String.valueOf(max);
        }
    }
    
}
