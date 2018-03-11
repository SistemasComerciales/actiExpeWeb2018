package activa.Expendio.persistencia;

import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import java.util.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Administrador
 */
@Service
public class PersistenciaProducto implements PersistenciaProductoInt {

    private ArrayList<Producto> productos;

    public PersistenciaProducto() {
        productos = new ArrayList<>();
    }

    /**
     * Traer todos los productos
     *
     * @return
     */
    @Override
    public ArrayList<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    @Override
    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    /**
     * Metodo encargado de adiionar el nuevo producto
     *
     * @param producto
     * @return
     */
    @Override
    public Producto adicionar(Producto producto) {
        productos.add(producto);
        return producto;
    }

    /**
     * Metodo encargado de modificar el producto
     *
     * @param producto
     * @return
     */
    @Override
    public Producto modificar(Producto producto) {
        Long id = producto.getId();
        for (int i = 0; i < productos.size(); i++) {
            if (Objects.equals(id, productos.get(i).getId())) {
                productos.set(i, producto);
                return producto;
            }
        }
        return null;
    }

    /**
     * Metodo encargado de eliminar el producto
     *
     * @param producto
     */
    @Override
    public void eliminar(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (Objects.equals(producto.getId(), productos.get(i).getId())) {
                productos.set(i, producto);
                break;
            }
        }
    }

    /**
     * Metodo encargado de traer todos los productos que no estan eliminados
     *
     * @return
     */
    @Override
    public ArrayList<Producto> consultarTodos() {
        ArrayList<Producto> productosRetorno = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (!productos.get(i).isEliminado()) {
                productosRetorno.add(productos.get(i));
            }
        }
        return productosRetorno;
    }

    /**
     * Metodo encargado de traer todos los productos activos que no estan
     * eliminados
     *
     * @return
     */
    @Override
    public ArrayList<Producto> consultarActivosNoEliminados() {
        ArrayList<Producto> productosRetorno = new ArrayList<>();
        for (int i = 0; i < productos.size(); i++) {
            if (!productos.get(i).isEliminado() && productos.get(i).getEstado()) {
                productosRetorno.add(productos.get(i));
            }
        }
        return productosRetorno;
    }

    /**
     * Metodo encargado de validar el producto
     *
     * @param producto
     * @return boolean <br>
     * <b>false</b>: Si no existe el codigo<br>
     * <b>true</b>: Si existe el codigo<br>
     */
    @Override
    public boolean validarExiste(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (producto.getCodigo().equalsIgnoreCase(productos.get(i).getCodigo())) {
                if (!productos.get(i).isEliminado()) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Metodo encargado de consultar el producto por el codigo
     *
     * @param codigo
     * @return
     * <b>null</b>: Si no existe el producto con el código<br>
     * <b>Producto</b>: dlc<br>
     */
    @Override
    public Producto consultarPorCodigo(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (!productos.get(i).isEliminado()) {
                if (codigo.equals(productos.get(i).getCodigo())) {
                    return productos.get(i);
                }
            }
        }
        return null;
    }

    /**
     * Metodo encargado de consultar el producto por el Id
     *
     * @param id
     * @return
     * <b>null</b>: Si no existe el producto con el código<br>
     * <b>Producto</b>: dlc<br>
     */
    @Override
    public Producto consultarPorId(String id) {
        for (int i = 0; i < productos.size(); i++) {
            if (!productos.get(i).isEliminado()) {
                Long idBodega = Long.parseLong(id);
                if (idBodega.equals(productos.get(i).getId())) {
                    return productos.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public boolean existeID(Producto producto) {
        for (int i = 0; i < productos.size(); i++) {
            if (Objects.equals(producto.getId(), productos.get(i).getId())) {
                return true;
            }
        }
        return false;
    }
}
