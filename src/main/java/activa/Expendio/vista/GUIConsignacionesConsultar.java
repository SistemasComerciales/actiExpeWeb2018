/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.Consignacion;
import activa.Expendio.modelo.Usuario;
import utils.CargaImagenes;

/**
 *
 * @author Administrador
 */
public class GUIConsignacionesConsultar extends GUIConsignacionesInterfaz{
    
    public GUIConsignacionesConsultar(Usuario usuario, Consignacion consignacion) {
        super(usuario);
        
//     super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "Consulta " +nombreClase.toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
    
        super.GUIConsignacionesInterfaz(usuario, "Consultar "+nombreClase.toUpperCase());
        this.consignacion = consignacion;
        asignarAplicacionesAPresentacion();
        ocultarPanelAuxiliar();
        deshabilitarCamposConsultar();
    }

    @Override
    public void actualizarFrame() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void ocultarPanelAuxiliar(){
        panelTablaInternos.setVisible(false);
    }
    
}
