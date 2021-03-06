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
public class PersistenciaInterno implements PersistenciaInternoInt {

    ArrayList<Interno> internos;

    /**
     * Constructor
     */
    public PersistenciaInterno() {
        internos = new ArrayList<>();
        crearMock();

    }

    public void crearMock() {
        Interno interno = new Interno();
        interno.setAccionUsuario(DatosBaseDatos.accionUsuarioInsertar);
        interno.setDelito("ROBO");
        interno.setEliminado(false);
        interno.setEstado(true);
        interno.setFechaIngreso(new Date(1181500200));
        interno.setId(1L);
        interno.setNacionalidad("COLOMBIA");
        interno.setNui("10205556");
        interno.setPrimerApellido("PRIETO");
        interno.setPrimerNombre("ALEJANDRO");
        interno.setSaldoDiarioActualGastado(0);
        interno.setSaldoDisponible(0);
        interno.setSaldoMensualActualGastado(0);
        interno.setSegundoApellido("GUEVARA");
        interno.setSegundoNombre("PABLO");
        interno.setSituacionJuridica("IMPUTADO");
        interno.setTd("302131");
        internos.add(interno);

        Interno interno2 = new Interno();
        interno2.setAccionUsuario(DatosBaseDatos.accionUsuarioInsertar);
        interno2.setDelito("HOMICIDIO");
        interno2.setEliminado(false);
        interno2.setEstado(true);
        interno2.setFechaIngreso(new Date(1181500200));
        interno2.setId(2L);
        interno2.setNacionalidad("COLOMBIA");
        interno2.setNui("45871239");
        interno2.setPrimerApellido("HERNANDEZ");
        interno2.setPrimerNombre("JOSE");
        interno2.setSaldoDiarioActualGastado(0);
        interno2.setSaldoDisponible(0);
        interno2.setSaldoMensualActualGastado(0);
        interno2.setSegundoApellido("ORTEGA");
        interno2.setSegundoNombre("MIGUEL");
        interno2.setSituacionJuridica("IMPUTADO");
        interno2.setTd("40963");
        internos.add(interno2);

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
            if (internos.get(i).getEstado()) {
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
            if (!internos.get(i).getEstado()) {
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
        for (int i = 0; i < internos.size(); i++) {
            if (Objects.equals(interno.getId(), internos.get(i).getId())) {
                internos.get(i).setEliminado(true);
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
            if (internos.get(i).isEliminado()) {
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
            if (!internos.get(i).isEliminado()) {
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
            if (!internos.get(i).isEliminado() && internos.get(i).getEstado()) {
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
            if (Objects.equals(interno.getId(), internos.get(i).getId())) {
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
            if (!internos.get(i).isEliminado()) {
                if (interno.getNui().equalsIgnoreCase(internos.get(i).getNui())) {
                    return true;
                }
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
            if (!internos.get(i).isEliminado()) {
                if (interno.getTd().equalsIgnoreCase(internos.get(i).getTd())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean existeID(Interno interno) {
        for (int i = 0; i < internos.size(); i++) {
            if (Objects.equals(interno.getId(), internos.get(i).getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Interno consultarPorTd(String TD) {
        for (int i = 0; i < internos.size(); i++) {
            if (!internos.get(i).isEliminado()) {
                if (TD.equals(internos.get(i).getTd())) {
                    return internos.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public Interno consultarPorNui(String Nui) {
        for (int i = 0; i < internos.size(); i++) {
            if (!internos.get(i).isEliminado()) {
                if (Nui.equals(internos.get(i).getNui())) {
                    return internos.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public Interno consultarPorId(Long id) {
        for (int i = 0; i < internos.size(); i++) {
            if (!internos.get(i).isEliminado()) {
                if (id.equals(internos.get(i).getId())) {
                    return internos.get(i);
                }
            }
        }
        return null;
    }
}
