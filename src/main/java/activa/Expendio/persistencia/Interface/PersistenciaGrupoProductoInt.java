package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public interface PersistenciaGrupoProductoInt {

    public ArrayList<GrupoProducto> getListaGrupoProductos();

    public void setListaGrupoProductos(ArrayList<GrupoProducto> listaGrupoProductos);

    public GrupoProducto adicionar(GrupoProducto grupoProducto);

    public GrupoProducto modificar(GrupoProducto grupoProducto);

    public GrupoProducto eliminar(GrupoProducto grupoProducto);

    public boolean validarExiste(GrupoProducto grupoProducto);

    public ArrayList<GrupoProducto> consultarTodos();
    
    public ArrayList<GrupoProducto> consultarActivosNoEliminados();

    public GrupoProducto consultarPorId(String id);

    public GrupoProducto consultarPorCodigo(String codigo);

    public boolean existeID(GrupoProducto grupoProducto);

}
