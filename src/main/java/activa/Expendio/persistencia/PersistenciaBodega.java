package activa.Expendio.persistencia;

import activa.Expendio.modelo.*;
import java.util.*;
import org.springframework.stereotype.*;
import activa.Expendio.persistencia.Interface.*;

/**
 *
 * @author Usuario
 */
@Service
public class PersistenciaBodega implements PersistenciaBodegaInt {

    private ArrayList<Bodega> bodegas;

    public PersistenciaBodega() {
        bodegas = new ArrayList<>();
    }

    /**
     * @return the listaBodegas
     */
    @Override
    public ArrayList<Bodega> getListaBodegas() {
        return bodegas;
    }

    /**
     * @param listaBodegas the listaBodegas to set
     */
    @Override
    public void setListaBodegas(ArrayList<Bodega> listaBodegas) {
        this.bodegas = listaBodegas;
    }

    /**
     * metodo que permite adicionar una bodega a la persistencia;
     *
     * @param bodega
     * @return bodega
     */
    @Override
    public Bodega adicionar(Bodega bodega) {
        bodegas.add(bodega);
        return bodega;
    }

    /**
     * metodo que modifica una bodega
     *
     * @param bodega
     * @return bodega
     */
    @Override
    public Bodega modificar(Bodega bodega) {
        Long id = bodega.getId();
        for (int i = 0; i <= bodegas.size(); i++) {
            if (Objects.equals(id, bodegas.get(i).getId())) {
                bodegas.set(i, bodega);
                return bodega;

            }
        }
        return null;
    }

    /**
     * metodo que cambia el estado a borrado true de una bodega
     *
     * @param bodega
     * @return bodega borrada o null
     */
    @Override
    public Bodega eliminar(Bodega bodega) {
        for (int i = 0; i < bodegas.size(); i++) {
            if (Objects.equals(bodega.getId(), bodegas.get(i).getId())) {
                bodegas.get(i).setEliminado(true);
                return bodega;
            }
        }
        return null;
    }

    /**
     * metodo que valida si existe o no por codigo
     *
     * @param bodega
     * @return true: existe , false: no existe
     */
    @Override
    public boolean validarExiste(Bodega bodega) {
        for (int i = 0; i < bodegas.size(); i++) {
            if (bodega.getCodigo().equalsIgnoreCase(bodegas.get(i).getCodigo())) {
                if (!bodegas.get(i).isEliminado()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo que consulta todas las bodegas que no esten eliminadas
     *
     * @return bodegas que no esten eliminadas
     */
    @Override
    public ArrayList<Bodega> consultarTodos() {
        ArrayList<Bodega> bodegas = new ArrayList<>();
        for (int i = 0; i < this.bodegas.size(); i++) {
            if (!this.bodegas.get(i).isEliminado()) {
                bodegas.add(this.bodegas.get(i));
            }
        }
        return bodegas;
    }

    /**
     * metodo que consulta una bodega por id
     *
     * @param id
     * @return null si no hay conincidencia o la bodega encontrada
     */
    @Override
    public Bodega consultarPorId(String id) {
        for (int i = 0; i < bodegas.size(); i++) {
            if (!bodegas.get(i).isEliminado()) {
                Long idBodega = Long.parseLong(id);
                if (idBodega.equals(bodegas.get(i).getId())) {
                    return bodegas.get(i);
                }
            }
        }
        return null;
    }

    /**
     * metodo que consulta una bodega por codigo
     *
     * @param codigo
     * @return null si no hay conincidencia o la bodega encontrada
     */
    @Override
    public Bodega consultarPorCodigo(String codigo) {
        for (int i = 0; i < bodegas.size(); i++) {
            if (!bodegas.get(i).isEliminado()) {
                if (codigo.equals(bodegas.get(i).getCodigo())) {
                    return bodegas.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public boolean existeID(Bodega bodega) {
        for (int i = 0; i < bodegas.size(); i++) {
            if (Objects.equals(bodega.getId(), bodegas.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

}
