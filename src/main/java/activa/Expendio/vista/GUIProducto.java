/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.expendio.vista;

import activa.Expendio.modelo.Usuario;
import utils.Imagenes;
import utils.NombreImagenes;

/**
 *
 * @author Administrador
 */
public class GUIProducto extends ClaseGeneral{
    private int anchoBotonesPanel1, altoBotonesPanel1;
    
    
    
    public GUIProducto(Usuario usuario) {
        super(usuario);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
        anchoBotonesPanel1 = 2 * this.getWidth() / 7;
        altoBotonesPanel1 = 2 * this.getHeight() / 25;
        super.tituloFrame(0, altoBotonesPanel1/100*2, "PRODUCTOS",this.getWidth(), 50);
		
    }

    @Override
    public void actualizarFrame() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarReferencia() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPermisos() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
