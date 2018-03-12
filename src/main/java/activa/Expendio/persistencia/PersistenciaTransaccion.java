/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;

import activa.Expendio.controllers.Servicios;
import activa.Expendio.modelo.Bodega;
import activa.Expendio.modelo.Producto;
import activa.Expendio.modelo.Transaccion;
import activa.Expendio.modelo.TransaccionItem;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.persistencia.Interface.PersistenciaTransaccionInt;
import activa.Expendio.vista.GUITransaccion;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;

/**
 *
 * @author Usuario
 */
@Service
public class PersistenciaTransaccion implements  PersistenciaTransaccionInt{
    private ArrayList<Transaccion> listaTransacciones;
    
    public PersistenciaTransaccion(){
        listaTransacciones = new ArrayList<>();
    }

    
    /**
     * @return the listaTransacciones
     */
    @Override
    public ArrayList<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    /**
     * @param listaTransacciones the listaTransacciones to set
     */
    @Override
    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }
    
     /**
     * metodo que permite adicionar una transaccion a la persistencia;
     * @param transaccion
     * @return transaccion
     */
    @Override
    public Transaccion adicionar(Transaccion transaccion){
        transaccion.setId(listaTransacciones.size()+1);
        listaTransacciones.add(transaccion);
        return transaccion;
    } 
    
        /**
     * metodo que modifica una transaccion
     * @param transaccion
     * @return transaccion
     */
    @Override
    public Transaccion modificar(Transaccion transaccion){
        Long id = transaccion.getId();
        for (int i = 0; i <= listaTransacciones.size(); i++) {
            if (id == listaTransacciones.get(i).getId()) {
               listaTransacciones.set(i, transaccion);
            return transaccion;

            }
        }
        return  null;
    }

     /**
     * metodo que valida si existe o no por numero
     * @param transaccion
     * @return true: existe , false: no existe
     */
    @Override
    public boolean validarExiste(Transaccion transaccion){
        for (int i = 0; i < listaTransacciones.size(); i++) {
            if (transaccion.getNumero().equals(listaTransacciones.get(i).getNumero())) {
                    return true;
            }
        }
        return false;
    }
    
        /**
     * metodo que consulta una transaccion por id
     * @param id
     * @return null si no hay conincidencia o la transaccion encontrada
     */
    @Override
    public Transaccion colsultarPorId(String id){
        for (int i = 0; i < listaTransacciones.size() ; i++) {
            if (id.equals( listaTransacciones.get(i).getId() ) ) {
                return listaTransacciones.get(i);
            }
        }
        return null;
    }
    
         /**
     * metodo que consulta una transaccion por codigo
     * @param codigo
     * @return null si no hay conincidencia o la transaccion encontrada
     */
    @Override
    public Transaccion colsultarPorCodigo(String codigo){
        for (int i = 0; i < listaTransacciones.size() ; i++) {
            if (codigo.equals( listaTransacciones.get(i).getNumero() ) ) {
                return listaTransacciones.get(i);
            }
        }
        return null;
    }
    
    
    
    
    //////////////// METODOS PARA ITEM ////////////////////////
    
         /**
     * metodo que permite adicionar una item a transaccion y  la persistencia;
     * @param transaccionItem
     * @param transaccion
     * @return transaccion
     */
    public Transaccion adicionar(TransaccionItem transaccionItem, Transaccion transaccion){
        ArrayList<TransaccionItem> items;
        items = transaccion.getListItem();
        items.add(transaccionItem);
        transaccion.setListItem(items);
        return transaccion;
    }
    
        /**
     * metodo que modifica una bodega
     * @param transaccionItem
     * @param transaccion
     * @return transaccion
     */
    public Transaccion modificar(TransaccionItem transaccionItem, Transaccion transaccion){
        ArrayList<TransaccionItem> items;
        items = transaccion.getListItem();
        
        Producto producto = transaccionItem.getProducto();
        String codigoProducto = producto.getCodigo();
        
        for (int i = 0; i <= items.size(); i++) {
            if (codigoProducto.equals( items.get(i).getProducto().getCodigo() ) ) {
                items.set(i, transaccionItem);
                transaccion.setListItem(items);
            return transaccion;
            }
        }
        return  null;
    }
    
         /**
     * metodo que valida si existe o no codigo producto
     * @param transaccion
     * @param transaccionItem
     * @return true: existe , false: no existe
     */
    public boolean validarExisteItem(Transaccion transaccion, TransaccionItem transaccionItem){
        ArrayList<TransaccionItem> items;
        items = transaccion.getListItem();
        
        Producto producto = transaccionItem.getProducto();
        String codigoProducto = producto.getCodigo();
        
        for (int i = 0; i < items.size(); i++) {
            if (codigoProducto.equals( items.get(i).getProducto().getCodigo() ) ) {
                    return true;
            }
        }
        return false;
    }
    
    @Override
        public ArrayList<TransaccionItem> consultarTodoItems(Transaccion transaccion) {
        return transaccion.getListItem();
    }
    
            /**
         * metodo que inserta una transaccion 
         * @param td
         * @param CodDocumentoFuente
         * @param fecha
         * @param codProduco
         * @param valorUni 
         */
        public String insertarTransaccion(String td,  Date fecha, double valorUni, String condicion, Usuario usuario){
            String numero = GUITransaccion.asignarNumeroConsecutivo(usuario);
            Transaccion transaccion = new Transaccion();
            transaccion.setDocumento(Servicios.documentosController.documentosRepository.consultarPorId("RI"));
            transaccion.setNumero(numero);
            transaccion.setFecha(fecha);
            transaccion.setCreacion(new Timestamp(System.currentTimeMillis()));
            transaccion.setModificacion(new Timestamp(System.currentTimeMillis()));
            transaccion.setCondicion(condicion);
            ArrayList<TransaccionItem> items = new ArrayList<>();
            TransaccionItem item = new TransaccionItem();
            item.setCantidad(1);
            item.setProducto(Servicios.productosController.productosRepository.consultarPorId("RE"));
            item.setValorUnitario(valorUni);
            transaccion.setListItem(items);
            listaTransacciones.add(transaccion);
            return numero;
        }    
        
}
