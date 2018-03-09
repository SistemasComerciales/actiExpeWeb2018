/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;


import activa.Expendio.modelo.Producto;
import activa.Expendio.persistencia.Interface.PersistenciaProductoInt;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class PersistenciaProducto implements PersistenciaProductoInt{
    private ArrayList<Producto> productos;
    
    public PersistenciaProducto(){
        productos = new ArrayList<>();
    }
    /**
     * Traer todos los productos
     * @return 
     */
    @Override
    public ArrayList<Producto> getProductos(){
        return productos;
    }
    /**
     * Metodo encargado de adiionar el nuevo producto
     * @param producto
     * @return 
     */
    @Override
    public Producto adicionar(Producto producto){
        producto.setId((productos.size()+1));
        productos.add(producto);
        return producto;
    }
    
    /**
     * Metodo encargado de eliminar el producto
     * @param producto 
     */
    @Override
    public void eliminar(Producto producto){
        producto.eliminar();
        for(int i=0; i<productos.size(); i++){
            if(producto.getId()== productos.get(i).getId()){
                productos.set(i, producto);
                break;
            }
        }
    }
    /**
     * Metodo encargado de traer todos los productos que no estan eliminados
     * @return 
     */
    @Override
    public ArrayList<Producto> getProductosActivos(){
        ArrayList<Producto> productosRetorno = new ArrayList<>();
        for(int i=0; i<productos.size(); i++){
            if(!productos.get(i).estaEliminado()){
                productosRetorno.add(productos.get(i));
            }
        }
        return productosRetorno;
    }
    
    /**
     * Metodo encargado de modificar el producto
     * @param producto
     * @return 
     */
    @Override
    public Producto modificar(Producto producto){
        for(int i=0; i<productos.size(); i++){
            if(producto.getId()== productos.get(i).getId()){
                productos.set(i, producto);
                return producto;
            }
        }
        return null;
    }
    
    /**
     * Metodo encargado de validar el producto
     * @param producto
     * @return boolean <br>
     * <b>false</b>: Si no existe el codigo<br>
     * <b>true</b>: Si existe el codigo<br>
     */
    @Override
    public boolean existeCodigo(Producto producto){
        for(int i=0; i<productos.size(); i++){
            if(producto.getCodigo().trim().equalsIgnoreCase(productos.get(i).getCodigo())){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Metodo encargado de consultar el producto por el codigo
     * @param codigo
     * @return 
     * <b>null</b>: Si no existe el producto con el código<br>
     * <b>Producto</b>: dlc<br>
     */
    @Override
    public Producto consultarPorCodigo(String codigo){
        for(int i=0; i<productos.size(); i++){
            if(codigo.trim().equalsIgnoreCase(productos.get(i).getCodigo())){
                return productos.get(i);
            }
        }
        return null;
    }
    
    /**
     * Metodo encargado de consultar el producto por el Id
     * @param id
     * @return 
     * <b>null</b>: Si no existe el producto con el código<br>
     * <b>Producto</b>: dlc<br>
     */
    @Override
    public Producto consultarPorId(long id){
        for(int i=0; i<productos.size(); i++){
            if(id == productos.get(i).getId()){
                return productos.get(i);
            }
        }
        return null;
    }
}
