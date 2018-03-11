/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.Producto;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaProductoInt {
    
    public ArrayList<Producto> getProductos();

    public void setProductos(ArrayList<Producto> productos);
    
    public Producto adicionar(Producto producto);
    
    public Producto modificar(Producto producto);
    
    public void eliminar(Producto producto);
    
    public ArrayList<Producto> consultarTodos();
    
    public ArrayList<Producto> consultarActivosNoEliminados();
    
    public boolean validarExiste(Producto producto);
    
    public Producto consultarPorCodigo(String codigo);
    
    public Producto consultarPorId(String id);

    public boolean existeID(Producto producto);
}
