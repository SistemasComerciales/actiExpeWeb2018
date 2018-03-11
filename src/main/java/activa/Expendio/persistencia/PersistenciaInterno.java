/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia;

import activa.Expendio.modelo.Interno;
import activa.Expendio.persistencia.Interface.PersistenciaInternoInt;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrador
 */
@Service
public class PersistenciaInterno implements PersistenciaInternoInt {

    ArrayList<Interno> internos;

    /**
     * Constructor
     */
    public PersistenciaInterno() {
        internos = new ArrayList<>();
    }

    /**
     * Metodo encargado de adicionar un interno
     *
     * @param interno
     * @return
     */
    @Override
    public Interno adicionar(Interno interno) {
        internos.add(interno);
        return interno;
    }

    /**
     * Metodo encargado de eliminar el interno
     *
     * @param interno
     */
    @Override
    public void desactivar(Interno interno) {
        interno.desactivar();
        for (int i = 0; i < internos.size(); i++) {
            if (interno.getId() == internos.get(i).getId()) {
                internos.set(i, interno);
                break;
            }
        }
    }

    /**
     * Metodo encargado de traer todos los productos que estan activos
     *
     * @return
     */
    @Override
    public ArrayList<Interno> getInternos() {
        ArrayList<Interno> internosRetorno = new ArrayList<>();
        for (int i = 0; i < internos.size(); i++) {
            internosRetorno.add(internos.get(i));
        }
        return internosRetorno;
    }

    /**
     * Metodo encargado de traer todos los productos que estan activos
     *
     * @return
     */
    @Override
    public ArrayList<Interno> getActivos() {
        ArrayList<Interno> internosRetorno = new ArrayList<>();
        for (int i = 0; i < internos.size(); i++) {
            if (internos.get(i).estaActivo()) {
                internosRetorno.add(internos.get(i));
            }
        }
        return internosRetorno;
    }

    /**
     * Metodo encargado de traer todos los productos que estan activos
     *
     * @return
     */
    @Override
    public ArrayList<Interno> getInactivos() {
        ArrayList<Interno> internosRetorno = new ArrayList<>();
        for (int i = 0; i < internos.size(); i++) {
            if (!internos.get(i).estaActivo()) {
                internosRetorno.add(internos.get(i));
            }
        }
        return internosRetorno;
    }

    /**
     * Metodo encargado de eliminar el interno
     *
     * @param interno
     */
    @Override
    public void eliminar(Interno interno) {
        interno.eliminar();
        for (int i = 0; i < internos.size(); i++) {
            if (interno.getId() == internos.get(i).getId()) {
                internos.set(i, interno);
                break;
            }
        }
    }

    /**
     * Metodo encargado de traer todos los productos que estan eliminados
     *
     * @return
     */
    @Override
    public ArrayList<Interno> getEliminados() {
        ArrayList<Interno> internosRetorno = new ArrayList<>();
        for (int i = 0; i < internos.size(); i++) {
            if (internos.get(i).estaEliminado()) {
                internosRetorno.add(internos.get(i));
            }
        }
        return internosRetorno;
    }

    /**
     * Metodo encargado de traer todos los productos que no estan eliminados
     *
     * @return
     */
    @Override
    public ArrayList<Interno> getNoEliminados() {
        ArrayList<Interno> internosRetorno = new ArrayList<>();
        for (int i = 0; i < internos.size(); i++) {
            if (!internos.get(i).estaEliminado()) {
                internosRetorno.add(internos.get(i));
            }
        }
        return internosRetorno;
    }

    /**
     * Metodo encargado de traer todos los productos que no estan eliminados y
     * que estan activos
     *
     * @return
     */
    @Override
    public ArrayList<Interno> getNoEliminadosYActivos() {
        ArrayList<Interno> internosRetorno = new ArrayList<>();
        for (int i = 0; i < internos.size(); i++) {
            if (!internos.get(i).estaEliminado() && internos.get(i).estaActivo()) {
                internosRetorno.add(internos.get(i));
            }
        }
        return internosRetorno;
    }

    /**
     * Metodo encargado de modificar
     *
     * @param interno
     * @return
     */
    @Override
    public Interno modificar(Interno interno) {
        for (int i = 0; i < internos.size(); i++) {
            if (interno.getId() == internos.get(i).getId()) {
                internos.set(i, interno);
                return interno;
            }
        }
        return null;
    }

    /**
     * Metodo encargado de validar el NUI
     *
     * @param interno
     * @return boolean <br>
     * <b>false</b>: Si no existe<br>
     * <b>true</b>: Si existe<br>
     */
    @Override
    public boolean existeNUI(Interno interno) {
        for (int i = 0; i < internos.size(); i++) {
            if (interno.getNui().trim().equalsIgnoreCase(internos.get(i).getNui())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo encargado de validar el TD
     *
     * @param interno
     * @return boolean <br>
     * <b>false</b>: Si no existe<br>
     * <b>true</b>: Si existe<br>
     */
    @Override
    public boolean existeTD(Interno interno) {
        for (int i = 0; i < internos.size(); i++) {
            if (interno.getTd().trim().equalsIgnoreCase(internos.get(i).getTd())) {
                return true;
            }
        }
        return false;
    }
}
