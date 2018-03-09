/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.GrupoProducto;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaGrupoProductoInt {
    
    public ArrayList<GrupoProducto> getListaGrupoProductos();
    
    public void setListaGrupoProductos(ArrayList<GrupoProducto> listaGrupoProductos);
    
    public GrupoProducto adicionar(GrupoProducto grupoProducto);
    
    public GrupoProducto modificar(GrupoProducto grupoProducto);
    
    public GrupoProducto borrar(GrupoProducto grupoProducto);
    
    public boolean validarExiste(GrupoProducto grupoProducto);
    
    public ArrayList<GrupoProducto> consultarTodos();
    
    public GrupoProducto colsultarPorId(String id);
    
    public GrupoProducto colsultarPorCodigo(String codigo);
    
}
