package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.*;
import java.util.*;

/**
 *
 * @author Usuario
 */
public interface PersistenciaInternoInt {

    public Interno adicionar(Interno interno);

    public ArrayList<Interno> getInternos();

    public ArrayList<Interno> getActivos();

    public ArrayList<Interno> getInactivos();

    public void eliminar(Interno interno);

    public ArrayList<Interno> getEliminados();

    public ArrayList<Interno> getNoEliminados();

    public ArrayList<Interno> getNoEliminadosYActivos();

    public Interno modificar(Interno interno);

    public boolean existeNUI(Interno interno);

    public boolean existeTD(Interno interno);

    public boolean existeID(Interno interno);
    
    public Interno consultarPorTd(String TD);
    
    public Interno consultarPorNui(String Nui);
    

}
