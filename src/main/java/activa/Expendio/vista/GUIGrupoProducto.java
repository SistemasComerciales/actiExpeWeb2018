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
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import utils.CampoCombo;
import utils.CargaImagenes;
import utils.Tabla.MiRender;
import utils.TablaNoEditable;

/**
 *
 * @author Usuario
 */
public class GUIGrupoProducto extends GUIInterfazCatalogos {
    
    private static String nombreClase ="Grupo Producto";
    private CampoLabel lbl_codigo, lbl_nombre, lbl_estado;
    private CajaDeTexto txt_codigo, txt_nombre;
    private CampoCombo<String> comboEstado;
    
    
    private static int columnaCodigo =0;
    private static int columnaNombre =1;
    private static int columnaEstado =2;
    private static int columnaId =3;
    
    
    /**
     * constructor
     */
    public GUIGrupoProducto(Usuario usuario, Establecimiento establecimiento){
        super(usuario, establecimiento, false);
        
    }

    @Override
    protected void prepareElementosTablaGeneral() {
        int margenIzquierda = 0;
        int margenSuperior = CargaImagenes.ALTO_PANTALLA/4+CargaImagenes.ALTO_PANTALLA/6;
        int anchoPanel = 2*(CargaImagenes.ANCHO_PANTALLA/3);
        int altoPanel = ((CargaImagenes.ALTO_PANTALLA/2));

        margenIzquierda = (CargaImagenes.ANCHO_PANTALLA - anchoPanel)/2;
        dtmTablaGeneral= new TablaNoEditable();
        tablaGeneral = new JTable(dtmTablaGeneral);
        panel_tablaGeneral=new JPanel();
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBounds(margenIzquierda,margenSuperior, anchoPanel,altoPanel) ;
        dtmTablaGeneral.addColumn("Código");
        dtmTablaGeneral.addColumn("Nombre");
        dtmTablaGeneral.addColumn("Estado");
        dtmTablaGeneral.addColumn("Id");
        tablaGeneral.setPreferredScrollableViewportSize(new Dimension(anchoPanel-25,altoPanel-27));
        scrollPaneTablaGeneral= new JScrollPane(tablaGeneral);
        panel_tablaGeneral.add(scrollPaneTablaGeneral);
        scrollPaneTablaGeneral.setBounds(0,0 , anchoPanel-25,altoPanel-27);
        this.add(panel_tablaGeneral);



        tablaGeneral.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaGeneral.getTableHeader().setReorderingAllowed(false);
        tablaGeneral.setDefaultRenderer(Object.class, new MiRender());
        tablaGeneral.setShowHorizontalLines(false);
        tablaGeneral.setBorder(null);
        tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBorder(null);
        scrollPaneTablaGeneral.setOpaque(false);
        scrollPaneTablaGeneral.getViewport().setOpaque(false);
        scrollPaneTablaGeneral.setBorder(null);      

        int anchoTotal = anchoPanel/5;
        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaNombre).setPreferredWidth(3*anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaId).setMaxWidth(0);
        tablaGeneral.getColumnModel().getColumn(columnaId).setMinWidth(0);
        tablaGeneral.getColumnModel().getColumn(columnaId).setPreferredWidth(0);
        
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
        lbl_codigo.setLocation(CargaImagenes.ANCHO_PANTALLA/100*15, CargaImagenes.ALTO_PANTALLA/100*20);
        this.add(lbl_codigo);
        
        txt_codigo = new CajaDeTexto("G",15);
        txt_codigo.setLocation(lbl_codigo.getX()+lbl_codigo.getWidth()*5/4, lbl_codigo.getY());
        txt_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_codigo);
        
        lbl_nombre =new CampoLabel("Nombre" ,"E");
        lbl_nombre.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_nombre.alinearDerecha();
        lbl_nombre.setLocation(CargaImagenes.ANCHO_PANTALLA/100*36, CargaImagenes.ALTO_PANTALLA/100*20);
        this.add(lbl_nombre);
        
        txt_nombre = new CajaDeTexto("G",15);
        txt_nombre.setLocation(lbl_nombre.getX()+lbl_nombre.getWidth()*5/4, lbl_nombre.getY());
        txt_nombre.setSize(CargaImagenes.anchoBotonCatalogos*2/3 , 30);
        this.add(txt_nombre);
        
        lbl_estado =new CampoLabel("Estado" ,"E");
        lbl_estado.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_estado.alinearDerecha();
        lbl_estado.setLocation(CargaImagenes.ANCHO_PANTALLA/100*58, CargaImagenes.ALTO_PANTALLA/100*20);
        this.add(lbl_estado);
        
        comboEstado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        comboEstado.setLocation(lbl_estado.getX()+lbl_estado.getWidth()*5/4, lbl_estado.getY());
        comboEstado.setSize(lbl_estado.getWidth() * 8 / 9, lbl_estado.getHeight());
        this.add(comboEstado);
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
        return nombreClase;
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

