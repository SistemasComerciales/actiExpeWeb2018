/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.DatosBaseDatos;
import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.modelo.Bodega;
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


    // Utilitarios
    private static String nombreClase ="Bodegas";
    private CampoLabel lbl_id, lbl_codigo, lbl_nombre, lbl_estado, lbl_usuario, lbl_eliminado, lbl_creacion, lbl_modificacion;
    private CajaDeTexto txt_codigo;
    
    public GUICatalogoBodegas(Usuario usuario) {
        super(usuario, false);
    }

    @Override
    protected void prepareElementosTablaGeneral() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.    
       
        lbl_id =new CampoLabel("Id" ,"E");
        lbl_id.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_id.alinearDerecha();
        lbl_id.setLocation(CargaImagenes.ANCHO_PANTALLA/100*15, CargaImagenes.ALTO_PANTALLA/100*20);
        this.add(lbl_id);

        lbl_codigo =new CampoLabel("Codigo" ,"E");
        lbl_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 36);
        lbl_codigo.alinearDerecha();
        lbl_codigo.setLocation(lbl_id.getX(), lbl_id.getY()+lbl_id.getHeight()+10);
        this.add(lbl_codigo);

        txt_codigo = new CajaDeTexto("B",15);
        txt_codigo.setLocation(lbl_codigo.getX()+lbl_codigo.getWidth()*5/4, lbl_codigo.getY());
        txt_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_codigo); 
          
    }

    @Override
    protected void activarModificar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void desactivarModificar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void activarBusqueda() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void desactivarBusqueda() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void inicializarInformacion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void definaAccionesInformacion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void prepareElementosInformacion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonAgregar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonAgregarModificar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonModificar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonBorrar() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonCancelarModificacion() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonCancelarBusqueda() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonBusqueda() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonReporte() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void accionBotonAdicional() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getNombreClase() {
        return nombreClase;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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