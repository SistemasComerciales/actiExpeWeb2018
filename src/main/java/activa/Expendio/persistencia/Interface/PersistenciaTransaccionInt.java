/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.Transaccion;
import activa.Expendio.modelo.TransaccionItem;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaTransaccionInt {
 
    public ArrayList<Transaccion> getListaTransacciones();
    
    public void setListaTransacciones(ArrayList<Transaccion> listaTransacciones);
    
    public Transaccion adicionar(Transaccion transaccion);
    
    public Transaccion modificar(Transaccion transaccion);
    
    public boolean validarExiste(Transaccion transaccion);
    
    public Transaccion colsultarPorId(String id);
    
    public Transaccion colsultarPorCodigo(String codigo);
    
    public Transaccion adicionar(TransaccionItem transaccionItem, Transaccion transaccion);
    
    public Transaccion modificar(TransaccionItem transaccionItem, Transaccion transaccion);
    
    public boolean validarExisteItem(Transaccion transaccion, TransaccionItem transaccionItem);
    
    public ArrayList<TransaccionItem> consultarTodoItems(Transaccion transaccion);
    
}
