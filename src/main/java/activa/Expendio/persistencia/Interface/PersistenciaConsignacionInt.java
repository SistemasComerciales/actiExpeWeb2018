/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.persistencia.Interface;

import activa.Expendio.modelo.Consignacion;
import activa.Expendio.modelo.Interno;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public interface PersistenciaConsignacionInt {
    
    public ArrayList<Consignacion> getConsignaciones();

    public ArrayList<Consignacion> getConsignacionesInterno(Interno interno);

    public Consignacion adicionar(Consignacion consignacion);

    public Consignacion modificar(Consignacion consignacion);

    public Consignacion eliminar(Consignacion consignacion);
    
    public ArrayList<Consignacion> consultarActivosNoEliminados();

    public Consignacion consultarPorId(int id);
    
    public Consignacion consultarPorNumero(String numero);

    public ArrayList<Consignacion> consultarPorFecha(Date fecha);
}
