/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.DatosBaseDatos;
import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.utils.CajaDeTexto;
import activa.Expendio.vista.utils.CampoLabel;
import utils.CampoCombo;
import utils.CargaImagenes;

/**
 *
 * @author diego
 */
public class GUIDocumentoFuente extends GUIInterfazCatalogos {

    private CampoLabel lbl_codigo , lbl_nombre, lbl_accion, lbl_aplica, lbl_numera, lbl_numero, lbl_controlExiistencia, lbl_docBase, lbl_precioFijo, lbl_listaPrecio, lbl_costeoInv, lbl_bodega, lbl_estado, lbl_eliminado; 
    private CajaDeTexto txt_codigo, txt_nombre, txt_numero, txt_idBodega, txt_bodega;
    private CampoCombo<String> combo_accionInv, combo_aplica, combo_numera, combo_controlExis, combo_docBase, combo_precioFijo, combo_listaPrecio, combo_costeoInv, combo_estado, combo_eliminado;
    public GUIDocumentoFuente(Usuario usuario, Establecimiento establecimiento) {
        super(usuario, establecimiento, false);
    }

    @Override
    protected void prepareElementosTablaGeneral() {
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
    }

    @Override
    protected void prepareElementosInformacion() {
        lbl_codigo =new CampoLabel("Codigo" ,"E");
        lbl_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_codigo.alinearDerecha();
        lbl_codigo.setLocation(CargaImagenes.ANCHO_PANTALLA/100*10, CargaImagenes.ALTO_PANTALLA/100*14);
        this.add(lbl_codigo);
        
        txt_codigo = new CajaDeTexto("G",15);
        txt_codigo.setLocation(lbl_codigo.getX()+lbl_codigo.getWidth()*5/4, lbl_codigo.getY());
        txt_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_codigo);
        
        lbl_nombre =new CampoLabel("Nombre" ,"E");
        lbl_nombre.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_nombre.alinearDerecha();
        lbl_nombre.setLocation(CargaImagenes.ANCHO_PANTALLA/100*27, CargaImagenes.ALTO_PANTALLA/100*14);
        this.add(lbl_nombre);
        
        txt_nombre = new CajaDeTexto("G",15);
        txt_nombre.setLocation(lbl_nombre.getX()+lbl_nombre.getWidth()*5/4, lbl_nombre.getY());
        txt_nombre.setSize(CargaImagenes.anchoBotonCatalogos*2/3 , 30);
        this.add(txt_nombre);
        
        lbl_accion =new CampoLabel("accion Inv." ,"E");
        lbl_accion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_accion.alinearDerecha();
        lbl_accion.setLocation(CargaImagenes.ANCHO_PANTALLA/100*50, CargaImagenes.ALTO_PANTALLA/100*14);
        this.add(lbl_accion);
        
        combo_accionInv = new CampoCombo<String>(DatosBaseDatos.varEntrada, DatosBaseDatos.varSalida);
        combo_accionInv.setLocation(lbl_accion.getX()+lbl_accion.getWidth()*5/4, lbl_accion.getY());
        combo_accionInv.setSize(lbl_accion.getWidth() * 8 / 9, lbl_accion.getHeight());
        this.add(combo_accionInv);
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
        return "Documento Fuente";
    }

    @Override
    public void actualizarFrame() {
    }

    @Override
    public void eliminarReferencia() {
    }

    @Override
    public void asignarFoco() {
        
    }

    @Override
    public void asignarPermisos() {
    }
    
}
