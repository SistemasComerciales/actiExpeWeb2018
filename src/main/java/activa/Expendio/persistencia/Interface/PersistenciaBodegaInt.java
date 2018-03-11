package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public interface PersistenciaBodegaInt {

    public ArrayList<Bodega> getListaBodegas();

    public void setListaBodegas(ArrayList<Bodega> listaBodegas);

    public Bodega adicionar(Bodega bodega);

    public Bodega modificar(Bodega bodega);

    public Bodega eliminar(Bodega bodega);

    public boolean validarExiste(Bodega bodega);

    public ArrayList<Bodega> consultarTodos();

    public Bodega consultarPorId(String id);

    public Bodega consultarPorCodigo(String codigo);

    public boolean existeID(Bodega bodega);
}
