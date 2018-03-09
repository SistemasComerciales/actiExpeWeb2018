/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.Interno;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public interface PersistenciaInternoInt {
    
    public Interno adicionar(Interno interno);
    
    public void desactivar(Interno interno);
    
    public ArrayList<Interno> getActivos();
    
    public ArrayList<Interno> getInactivos();
    
    public void eliminar(Interno interno);
    
    public ArrayList<Interno> getEliminados();
    
    public ArrayList<Interno> getNoEliminados();
    
    public ArrayList<Interno> getNoEliminadosYActivos();
    
    public Interno modificar(Interno interno);
    
    public boolean existeNUI(Interno interno);
    
    public boolean existeTD(Interno interno);
            
}
