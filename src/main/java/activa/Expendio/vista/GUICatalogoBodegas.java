/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author USUARIO
 */
public class GUICatalogoBodegas extends GUIInterfazCatalogos {

        private int anchoBotonesPanel1, altoBotonesPanel1;
        
   /*public GUICatalogoBodegas(Usuario usuario, Establecimiento establecimiento, boolean botonAdicional) {
        super(usuario, establecimiento, false);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondo, this.getWidth(), this.getHeight(), this);
        anchoBotonesPanel1 = 2 * this.getWidth() / 7;
        altoBotonesPanel1 = 2 * this.getHeight() / 25;
    }*/

    public GUICatalogoBodegas(Usuario usuario, Establecimiento establecimiento) {
        super(usuario, establecimiento, false);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoD, this.getWidth(), this.getHeight(), this);
        anchoBotonesPanel1 = 2 * this.getWidth() / 7;
        altoBotonesPanel1 = 2 * this.getHeight() / 25;
    }

    @Override
    protected void prepareElementosTablaGeneral() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void activarModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void desactivarModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void activarBusqueda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void desactivarBusqueda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void inicializarInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void definaAccionesInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void prepareElementosInformacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonAgregar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonAgregarModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonModificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonBorrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonCancelarModificacion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonCancelarBusqueda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonBusqueda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonReporte() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonAdicional() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNombreClase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarReferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPermisos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
