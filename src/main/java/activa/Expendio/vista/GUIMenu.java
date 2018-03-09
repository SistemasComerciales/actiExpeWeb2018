/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.expendio.vista;

import activa.Expendio.modelo.Usuario;
import activa.expendio.vista.utils.Boton;
import activa.expendio.vista.utils.CampoLabel;
import javax.swing.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUIMenu extends ClaseGeneral {

    private CampoLabel lbl_fecha, lbl_nombreUsuario, lbl_nombreEmpresa, lbl_periodoContable;

    // Panel Botones Principales 
    private JPanel panel_botonesPrincipales;
    private Boton btn_catalogos, btn_transaccion, btn_reportes, btn_configuracion, btn_salir;

    // Panel Boton Catalogos
    private JPanel panel_BotonCatalogos;
    private Boton btn_catalogoInternos, btn_catalogoDocumentos, btn_catalogoBodegas, btn_catalogoGrupos, btn_catalogoProductos, btn_catalogoProveedores, btn_catalogosEstablecimientos;

    // Panel Boton Transacciones
    private JPanel panel_BotonTransacciones;

    // Panel Boton Reportes
    private JPanel panel_BotonReportes;

    // Panel Boton Configuracion
    private JPanel panel_BotonConfiguracion;
    private Boton btn_configuracionUsuarios, btn_configuracionEditorFormatos, btn_configuracionClaveDelDia, btn_configuracionGeneral, btn_configuracionActualizacionBD, btn_configuracionParametros;

    // Panel Usuarios
    private JPanel panel_configuracionUsuarios;
    private Boton btn_usuarioAdicionar, btn_usuarioDesactivar, btn_usuarioPermisos;

    private int anchoBotonesPanel1, altoBotonesPanel1;

    public GUIMenu(Usuario usuario) {
        super(usuario);

        Imagenes.fondoInternalFrame(NombreImagenes.imFondoMenu, this.getWidth(), this.getHeight(), this);
        anchoBotonesPanel1 = 2 * this.getWidth() / 7;
        altoBotonesPanel1 = 2 * this.getHeight() / 25;
    }

    @Override
    public void actualizarFrame() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPermisos() {
        //To change body of generated methods, choose Tools | Templates.
    }

}
