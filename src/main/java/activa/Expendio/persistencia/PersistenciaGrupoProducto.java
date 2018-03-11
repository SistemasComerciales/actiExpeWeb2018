package activa.Expendio.persistencia;

import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import java.util.*;
import org.springframework.stereotype.*;

/**
 *
 * @author Usuario
 */
@Service
public class PersistenciaGrupoProducto implements PersistenciaGrupoProductoInt {

    private ArrayList<GrupoProducto> listaGrupoProductos = new ArrayList<>();

    /**
     * constructor
     */
    public PersistenciaGrupoProducto() {
        listaGrupoProductos = new ArrayList<>();
    }

    /**
     * @return the listaGrupoProductos
     */
    @Override
    public ArrayList<GrupoProducto> getListaGrupoProductos() {
        return listaGrupoProductos;
    }

    /**
     * @param listaGrupoProductos the listaGrupoProductos to set
     */
    @Override
    public void setListaGrupoProductos(ArrayList<GrupoProducto> listaGrupoProductos) {
        this.listaGrupoProductos = listaGrupoProductos;
    }

    /**
     * metodo que permite adicionar una grupoProducto a la persistencia;
     *
     * @param grupoProducto
     * @return grupoProducto
     */
    @Override
    public GrupoProducto adicionar(GrupoProducto grupoProducto) {
        listaGrupoProductos.add(grupoProducto);
        return grupoProducto;
    }

    /**
     * metodo que modifica una grupoProducto
     *
     * @param grupoProducto
     * @return grupoProducto
     */
    @Override
    public GrupoProducto modificar(GrupoProducto grupoProducto) {
        Long id = grupoProducto.getId();
        for (int i = 0; i <= listaGrupoProductos.size(); i++) {
            if (Objects.equals(id, listaGrupoProductos.get(i).getId())) {
                listaGrupoProductos.set(i, grupoProducto);
                return grupoProducto;

            }
        }
        return null;
    }

    /**
     * metodo que cambia el estado a borrado true de una grupoProducto
     *
     * @param grupoProducto
     * @return grupoProducto borrada o null
     */
    @Override
    public GrupoProducto eliminar(GrupoProducto grupoProducto) {
        Long id = grupoProducto.getId();
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (Objects.equals(id, listaGrupoProductos.get(i).getId())) {
                listaGrupoProductos.get(i).setEliminado(true);
                return grupoProducto;
            }
        }
        return null;
    }

    /**
     * metodo que valida si existe o no por codigo
     *
     * @param grupoProducto
     * @return true: existe , false: no existe
     */
    @Override
    public boolean validarExiste(GrupoProducto grupoProducto) {
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (grupoProducto.getCodigo().equalsIgnoreCase(listaGrupoProductos.get(i).getCodigo())) {
                if (!listaGrupoProductos.get(i).isEliminado()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * metodo que consulta todas las GrupoProducto que no esten eliminadas
     *
     * @return GrupoProducto que no esten eliminadas
     */
    @Override
    public ArrayList<GrupoProducto> consultarTodos() {
        ArrayList<GrupoProducto> grupoProducto = new ArrayList<>();
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (!listaGrupoProductos.get(i).isEliminado()) {
                grupoProducto.add(listaGrupoProductos.get(i));
            }
        }
        return grupoProducto;
    }

    /**
     * Metodo encargado de traer todos los grupos activos que no estan
     * eliminados
     *
     * @return
     */
    @Override
    public ArrayList<GrupoProducto> consultarActivosNoEliminados() {
        ArrayList<GrupoProducto> grupos = new ArrayList<>();
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (!listaGrupoProductos.get(i).isEliminado() && listaGrupoProductos.get(i).getEstado()) {
                grupos.add(listaGrupoProductos.get(i));
            }
        }
        return grupos;
    }

    /**
     * metodo que consulta una GrupoProducto por id
     *
     * @param id
     * @return null si no hay conincidencia o la GrupoProducto encontrada
     */
    @Override
    public GrupoProducto consultarPorId(String id) {
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (!listaGrupoProductos.get(i).isEliminado()) {
                Long idGrupoProducto = Long.parseLong(id);
                if (idGrupoProducto.equals(listaGrupoProductos.get(i).getId())) {
                    return listaGrupoProductos.get(i);
                }
            }
        }
        return null;
    }

    /**
     * metodo que consulta una GrupoProducto por codigo
     *
     * @param codigo
     * @return null si no hay conincidencia o la GrupoProducto encontrada
     */
    @Override
    public GrupoProducto consultarPorCodigo(String codigo) {
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (!listaGrupoProductos.get(i).isEliminado()) {
                if (codigo.equals(listaGrupoProductos.get(i).getCodigo())) {
                    return listaGrupoProductos.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public boolean existeID(GrupoProducto grupoProducto) {
        for (int i = 0; i < listaGrupoProductos.size(); i++) {
            if (Objects.equals(grupoProducto.getId(), listaGrupoProductos.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

}
