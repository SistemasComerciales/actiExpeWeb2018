/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.Bodega;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaBoddegaInt {
    
    public ArrayList<Bodega> getListaBodegas();
    
    public void setListaBodegas(ArrayList<Bodega> listaBodegas);
    
    public Bodega adicionar(Bodega bodega);
    
    public Bodega modificar(Bodega bodega);
    
    public Bodega borrar(Bodega bodega);
    
    public boolean validarExiste(Bodega bodega);
    
    public ArrayList<Bodega> consultarTodos();
    
    public Bodega colsultarPorId(String id);
    
    public Bodega colsultarPorCodigo(String codigo);
}
