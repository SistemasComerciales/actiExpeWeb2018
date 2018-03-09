/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;

import activa.Expendio.modelo.Bodega;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class PersistenciaBodega {

    private ArrayList<Bodega> listaBodegas;

    public PersistenciaBodega() {
        listaBodegas = new ArrayList<>();
    }

    /**
     * @return the listaBodegas
     */
    public ArrayList<Bodega> getListaBodegas() {
        return listaBodegas;
    }

    /**
     * @param listaBodegas the listaBodegas to set
     */
    public void setListaBodegas(ArrayList<Bodega> listaBodegas) {
        this.listaBodegas = listaBodegas;
    }

    /**
     * metodo que permite adicionar una bodega a la persistencia;
     * @param bodega
     * @return bodega
     */
    public Bodega adicionar(Bodega bodega){
        bodega.setId(listaBodegas.size()+1);
        listaBodegas.add(bodega);
        return bodega;
    } 
    
    /**
     * metodo que modifica una bodega
     * @param bodega
     * @return bodega
     */
    public Bodega modificar(Bodega bodega){
        Long id = bodega.getId();
        for (int i = 0; i <= listaBodegas.size(); i++) {
            if (id == listaBodegas.get(i).getId()) {
               listaBodegas.set(i, bodega);
            return bodega;

            }
        }
        return  null;
    }
    
    /**
     * metodo que cambia el estado a borrado true de una bodega 
     * @param bodega
     * @return bodega borrada o null
     */
    public Bodega borrar(Bodega bodega){
        Long id = bodega.getId();
        for (int i = 0; i < listaBodegas.size(); i++) {
            if (id.equals(listaBodegas.get(i).getId())) {
                listaBodegas.get(i).setEliminado(true);
                return bodega;
            }
        }
        return null;
    }
        
    /**
     * metodo que valida si existe o no por codigo
     * @param bodega
     * @return true: existe , false: no existe
     */
    public boolean validarExiste(Bodega bodega){
        for (int i = 0; i < listaBodegas.size(); i++) {
            if (bodega.getCodigo().equals(listaBodegas.get(i).getCodigo())) {
                if (!listaBodegas.get(i).isEliminado()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * metodo que consulta todas las bodegas que no esten eliminadas
     * @return bodegas que no esten eliminadas
     */
    public ArrayList<Bodega> consultarTodos(){
        ArrayList<Bodega> bodegas = new ArrayList<>();
        for (int i = 0; i < listaBodegas.size(); i++) {
            if (!listaBodegas.get(i).isEliminado()) {
                bodegas.add(listaBodegas.get(i));
            }
        }
        return bodegas;
    }
    
    /**
     * metodo que consulta una bodega por id
     * @param id
     * @return null si no hay conincidencia o la bodega encontrada
     */
    public Bodega colsultarPorId(String id){
        for (int i = 0; i < listaBodegas.size() ; i++) {
            if (!listaBodegas.get(i).isEliminado()) {
                if (id.equals( listaBodegas.get(i).getId() ) ) {
                    return listaBodegas.get(i);
                }
            }
        }
        return null;
    }
    
     /**
     * metodo que consulta una bodega por codigo
     * @param codigo
     * @return null si no hay conincidencia o la bodega encontrada
     */
    public Bodega colsultarPorCodigo(String codigo){
        for (int i = 0; i < listaBodegas.size() ; i++) {
            if (!listaBodegas.get(i).isEliminado()) {
                if (codigo.equals( listaBodegas.get(i).getCodigo() ) ) {
                    return listaBodegas.get(i);
                }
            }
        }
        return null;
    }
    
    
}
