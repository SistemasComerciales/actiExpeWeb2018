/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;

import activa.Expendio.modelo.GrupoProducto;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PersistenciaGrupoProducto {
    
    private ArrayList<GrupoProducto> listaGrupoProductos = new ArrayList<>();
    
    /**
     * constructor
     */
    public PersistenciaGrupoProducto(){
        listaGrupoProductos = new ArrayList<>();
    }

    /**
     * @return the listaGrupoProductos
     */
    public ArrayList<GrupoProducto> getListaGrupoProductos() {
        return listaGrupoProductos;
    }

    /**
     * @param listaGrupoProductos the listaGrupoProductos to set
     */
    public void setListaGrupoProductos(ArrayList<GrupoProducto> listaGrupoProductos) {
        this.listaGrupoProductos = listaGrupoProductos;
    }
    
        /**
     * metodo que permite adicionar una grupoProducto a la persistencia;
     * @param grupoProducto
     * @return grupoProducto
     */
    public GrupoProducto adicionar(GrupoProducto grupoProducto){
        grupoProducto.setId(listaGrupoProductos.size()+1);
        listaGrupoProductos.add(grupoProducto);
        return grupoProducto;
    }
    
        /**
     * metodo que modifica una grupoProducto
     * @param grupoProducto
     * @return grupoProducto
     */
    public GrupoProducto modificar(GrupoProducto grupoProducto){
        Long id = grupoProducto.getId();
        for (int i = 0; i <= listaGrupoProductos.size(); i++) {
            if (id == listaGrupoProductos.get(i).getId()) {
               listaGrupoProductos.set(i, grupoProducto);
            return grupoProducto;

            }
        }
        return  null;
    }
    
    /**
     * metodo que cambia el estado a borrado true de una grupoProducto 
     * @param grupoProducto
     * @return grupoProducto borrada o null
     */
    public GrupoProducto borrar(GrupoProducto grupoProducto){
        Long id = grupoProducto.getId();
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (id.equals(listaGrupoProductos.get(i).getId())) {
                listaGrupoProductos.get(i).setEliminado(true);
                return grupoProducto;
            }
        }
        return null;
    }
    
        /**
     * metodo que valida si existe o no por codigo
     * @param grupoProducto
     * @return true: existe , false: no existe
     */
    public boolean validarExiste(GrupoProducto grupoProducto){
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (grupoProducto.getCodigo().equals(listaGrupoProductos.get(i).getCodigo())) {
                if (!listaGrupoProductos.get(i).isEliminado()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * metodo que consulta todas las GrupoProducto que no esten eliminadas
     * @return GrupoProducto que no esten eliminadas
     */
    public ArrayList<GrupoProducto> consultarTodos(){
        ArrayList<GrupoProducto> grupoProducto = new ArrayList<>();
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (!listaGrupoProductos.get(i).isEliminado()) {
                grupoProducto.add(listaGrupoProductos.get(i));
            }
        }
        return grupoProducto;
    }
    
        /**
     * metodo que consulta una GrupoProducto por id
     * @param id
     * @return null si no hay conincidencia o la GrupoProducto encontrada
     */
    public GrupoProducto colsultarPorId(String id){
        for (int i = 0; i < listaGrupoProductos.size() ; i++) {
            if (!listaGrupoProductos.get(i).isEliminado()) {
                if (id.equals( listaGrupoProductos.get(i).getId() ) ) {
                    return listaGrupoProductos.get(i);
                }
            }
        }
        return null;
    }
    
         /**
     * metodo que consulta una GrupoProducto por codigo
     * @param codigo
     * @return null si no hay conincidencia o la GrupoProducto encontrada
     */
    public GrupoProducto colsultarPorCodigo(String codigo){
        for (int i = 0; i < listaGrupoProductos.size() ; i++) {
            if (!listaGrupoProductos.get(i).isEliminado()) {
                if (codigo.equals( listaGrupoProductos.get(i).getCodigo() ) ) {
                    return listaGrupoProductos.get(i);
                }
            }
        }
        return null;
    }
    
}
