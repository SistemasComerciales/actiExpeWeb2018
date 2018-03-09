/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.GrupoProducto;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.utils.CajaDeTexto;
import activa.Expendio.vista.utils.CampoLabel;
import utils.CampoCombo;
import utils.CargaImagenes;
/**
 *
 * @author Administrador
 */
public class GUIProducto extends GUIInterfazCatalogos{
    
    
    private CampoLabel lbl_codigo, lbl_nombre, lbl_presentacion , _lbl_grupo, lbl_controlExistencia, lbl_afectaGrupo, lbl_controlSerial, lbl_precio10Porciento, lbl_codigoBarras, lbl_observacion,lbl_estado, lbl_eliminado;
    private CajaDeTexto txt_codigo, txt_nombre, txt_presentacion, txt_grupo, txt_idGrupo, txt_codigoBarras, txt_observaciones;
    private CampoCombo<String> combo_controlExistencia, combo_afectaCupo, combo_controlSerial, combo_precio10Porciento, combo_estado, combo_eliminado;
    
    public GUIProducto(Usuario usuario, Establecimiento establecimiento ) {
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
        
        lbl_presentacion =new CampoLabel("Presentación" ,"E");
        lbl_presentacion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_presentacion.alinearDerecha();
        lbl_presentacion.setLocation(CargaImagenes.ANCHO_PANTALLA/100*50, CargaImagenes.ALTO_PANTALLA/100*14);
        this.add(lbl_presentacion);
        
        txt_presentacion = new CajaDeTexto("G",15);
        txt_presentacion.setLocation(lbl_presentacion.getX()+lbl_presentacion.getWidth()*5/4, lbl_presentacion.getY());
        txt_presentacion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_presentacion);
        
        lbl_controlExistencia =new CampoLabel("Control Existencia" ,"E");
        lbl_controlExistencia.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_controlExistencia.alinearDerecha();
        lbl_controlExistencia.setLocation(CargaImagenes.ANCHO_PANTALLA/100*10, CargaImagenes.ALTO_PANTALLA/100*14);
        this.add(lbl_controlExistencia);
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
            return "Productos";
    }

    @Override
    public void actualizarFrame() {
    }

    @Override
    public void eliminarReferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_codigo.grabFocus();
    }

    @Override
    public void asignarPermisos() {
    }


    
}
