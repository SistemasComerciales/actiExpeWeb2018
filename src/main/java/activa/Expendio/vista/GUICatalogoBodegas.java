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

    public GUICatalogoBodegas(Usuario usuario, Establecimiento establecimiento, boolean botonAdicional) {
        super(usuario, establecimiento, botonAdicional);
        
        prepareElementos();
        prepareElementosPanelBotones(botonAdicional);
        
    }
    
    protected void prepareElementos() {
        this.setTitle(getNombreClase());
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, getNombreClase().toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoMenu, this.getWidth(), this.getHeight(), this);

        estaEditando = false;
        estaBuscando = false;
    }
     protected void prepareElementosPanelBotones(boolean botonAdicional) {
        panel_subOpciones = new JPanel();
        panel_subOpciones.setSize(CargaImagenes.ANCHO_PANTALLA - 2 * (CargaImagenes.ANCHO_PANTALLA / 10), (CargaImagenes.ALTO_PANTALLA / 6) / 3);
        panel_subOpciones.setLocation((CargaImagenes.ANCHO_PANTALLA / 10), 5 * (CargaImagenes.ALTO_PANTALLA / 16/*13*/) + 15);
        panel_subOpciones.setLayout(new GridLayout(1, 0));
        panel_subOpciones.setOpaque(false);
        this.add(panel_subOpciones);
        btn_agregar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Agregar");
        panel_subOpciones.add(btn_agregar);
        btn_agregar.setToolTipText("F1");

        btn_modificar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Modificar");
        panel_subOpciones.add(btn_modificar);
        btn_modificar.setToolTipText("F2");

        btn_borrar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Borrar");
        panel_subOpciones.add(btn_borrar);
        btn_borrar.setToolTipText("F3");

        btn_buscar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Buscar");
        panel_subOpciones.add(btn_buscar);
        btn_buscar.setToolTipText("F4");

        btn_exportar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Exportar");
        panel_subOpciones.add(btn_exportar);

        btn_reporte = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Reporte");
        panel_subOpciones.add(btn_reporte);

        btn_adicional = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "");
        if (botonAdicional) {
            panel_subOpciones.add(btn_adicional);
        }

        btn_salir = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneralRojo, "Salir");
        panel_subOpciones.add(btn_salir);
        btn_salir.setToolTipText("(ESC)");
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
