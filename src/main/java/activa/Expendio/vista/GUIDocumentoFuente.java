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
import utils.Tabla;
import utils.TablaNoEditable;

/**
 *
 * @author diego
 */
public class GUIDocumentoFuente extends GUIInterfazCatalogos {

    private CampoLabel lbl_codigo , lbl_nombre, lbl_accion, lbl_aplica, lbl_numera, lbl_numero, lbl_controlExiistencia, lbl_docBase, lbl_precioFijo, lbl_listaPrecio, lbl_costeoInv, lbl_bodega, lbl_estado, lbl_eliminado; 
    private CajaDeTexto txt_codigo, txt_nombre, txt_numero, txt_idBodega, txt_bodega;
    private CampoCombo<String> combo_accionInv, combo_aplica, combo_numera, combo_controlExis, combo_docBase, combo_precioFijo, combo_listaPrecio, combo_costeoInv, combo_estado, combo_eliminado;
    
    public static int columnaCodigo = 0 ;
    public static int columnaNombre = 1 ;
    public static int columnaAccionInv = 2 ;
    public static int columnaAplica = 3 ;
    public static int columnaNumera = 4 ;
    public static int columnaNumero = 5 ;
    public static int columnaControlExitencia = 6 ;
    public static int columnaDocBase = 7 ;
    public static int columnaPrecioFijo = 8 ;
    public static int columnaListaPrecio = 9 ;
    public static int columnaCosteoInv = 10 ;
    public static int columnaBodega = 11 ;
    public static int columnaIdBodega = 12 ;
    public static int columnaEstado = 13 ;
    public static int columnaEliminado = 14 ;
    public static int columnaId = 15 ;
    
    /**
     * constructor
     * @param usuario
     * @param establecimiento 
     */
    public GUIDocumentoFuente(Usuario usuario, Establecimiento establecimiento) {
        super(usuario, establecimiento, false);
    }

    @Override
    protected void prepareElementosTablaGeneral() {
        int margenIzquierda = 0;
        int margenSuperior = CargaImagenes.ALTO_PANTALLA/4+CargaImagenes.ALTO_PANTALLA/6;
        int anchoPanel = 80*(CargaImagenes.ANCHO_PANTALLA/100);
        int altoPanel = ((CargaImagenes.ALTO_PANTALLA/2));

        margenIzquierda = (CargaImagenes.ANCHO_PANTALLA - anchoPanel)/2;
        dtmTablaGeneral= new TablaNoEditable();
        tablaGeneral = new JTable(dtmTablaGeneral);
        panel_tablaGeneral=new JPanel();
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBounds(margenIzquierda,margenSuperior, anchoPanel,altoPanel) ;
        dtmTablaGeneral.addColumn("Código");//1
        dtmTablaGeneral.addColumn("Nombre");//2
        dtmTablaGeneral.addColumn("Accion inventario");//3
        dtmTablaGeneral.addColumn("Aplica a");//4
        dtmTablaGeneral.addColumn("Numera");//5
        dtmTablaGeneral.addColumn("Numero");//6
        dtmTablaGeneral.addColumn("C. existencia");//7
        dtmTablaGeneral.addColumn("Doc Base");//8
        dtmTablaGeneral.addColumn("Precio fijo");//9
        dtmTablaGeneral.addColumn("lista precio");//10
        dtmTablaGeneral.addColumn("Costeo inv");//11
        dtmTablaGeneral.addColumn("Bodega");//12
        dtmTablaGeneral.addColumn("idBodega");//13
        dtmTablaGeneral.addColumn("Estado");//14
        dtmTablaGeneral.addColumn("Eliminado");//15
        dtmTablaGeneral.addColumn("Id");//16

        
        tablaGeneral.setPreferredScrollableViewportSize(new Dimension(anchoPanel-25,altoPanel-27));
        scrollPaneTablaGeneral= new JScrollPane(tablaGeneral);
        panel_tablaGeneral.add(scrollPaneTablaGeneral);
        scrollPaneTablaGeneral.setBounds(0,0 , anchoPanel-25,altoPanel-27);
        this.add(panel_tablaGeneral);



        tablaGeneral.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaGeneral.getTableHeader().setReorderingAllowed(false);
        tablaGeneral.setDefaultRenderer(Object.class, new Tabla.MiRender());
        tablaGeneral.setShowHorizontalLines(false);
        tablaGeneral.setBorder(null);
        tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBorder(null);
        scrollPaneTablaGeneral.setOpaque(false);
        scrollPaneTablaGeneral.getViewport().setOpaque(false);
        scrollPaneTablaGeneral.setBorder(null);      

        int anchoTotal = anchoPanel/20;
        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaNombre).setPreferredWidth(3*anchoTotal);
        
        tablaGeneral.getColumnModel().getColumn(columnaIdBodega).setMaxWidth(0);
        tablaGeneral.getColumnModel().getColumn(columnaIdBodega).setMinWidth(0);
        tablaGeneral.getColumnModel().getColumn(columnaIdBodega).setPreferredWidth(0);
        
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
        lbl_codigo.setLocation(CargaImagenes.ANCHO_PANTALLA/100*10, CargaImagenes.ALTO_PANTALLA/100*10);
        this.add(lbl_codigo);
        
        txt_codigo = new CajaDeTexto("G",15);
        txt_codigo.setLocation(lbl_codigo.getX()+lbl_codigo.getWidth()*5/4, lbl_codigo.getY());
        txt_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_codigo);
        
        lbl_nombre =new CampoLabel("Nombre" ,"E");
        lbl_nombre.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_nombre.alinearDerecha();
        lbl_nombre.setLocation(CargaImagenes.ANCHO_PANTALLA/100*27, CargaImagenes.ALTO_PANTALLA/100*10);
        this.add(lbl_nombre);
        
        txt_nombre = new CajaDeTexto("G",15);
        txt_nombre.setLocation(lbl_nombre.getX()+lbl_nombre.getWidth()*5/4, lbl_nombre.getY());
        txt_nombre.setSize(CargaImagenes.anchoBotonCatalogos*2/3 , 30);
        this.add(txt_nombre);
        
        lbl_accion =new CampoLabel("accion Inv." ,"E");
        lbl_accion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_accion.alinearDerecha();
        lbl_accion.setLocation(CargaImagenes.ANCHO_PANTALLA/100*50, CargaImagenes.ALTO_PANTALLA/100*10);
        this.add(lbl_accion);
        
        combo_accionInv = new CampoCombo<String>(DatosBaseDatos.varEntrada, DatosBaseDatos.varSalida);
        combo_accionInv.setLocation(lbl_accion.getX()+lbl_accion.getWidth()*5/4, lbl_accion.getY());
        combo_accionInv.setSize(lbl_accion.getWidth() * 8 / 9, lbl_accion.getHeight());
        this.add(combo_accionInv);
        
        lbl_aplica =new CampoLabel("Aplica a" ,"E");
        lbl_aplica.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_aplica.alinearDerecha();
        lbl_aplica.setLocation(CargaImagenes.ANCHO_PANTALLA/100*10, CargaImagenes.ALTO_PANTALLA/100*15);
        this.add(lbl_aplica);
        
        combo_aplica = new CampoCombo<String>(DatosBaseDatos.varAplicaCliente, DatosBaseDatos.varAplicaProveedor);
        combo_aplica.setLocation(lbl_aplica.getX()+lbl_aplica.getWidth()*5/4, lbl_aplica.getY());
        combo_aplica.setSize(lbl_aplica.getWidth() * 8 / 9, lbl_aplica.getHeight());
        this.add(combo_aplica);
        
        lbl_numera =new CampoLabel("Numera" ,"E");
        lbl_numera.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_numera.alinearDerecha();
        lbl_numera.setLocation(lbl_nombre.getX(), lbl_aplica.getY());
        this.add(lbl_numera);
        
        combo_numera = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_numera.setLocation(lbl_numera.getX()+lbl_numera.getWidth()*5/4, lbl_numera.getY());
        combo_numera.setSize(lbl_numera.getWidth() * 8 / 9, lbl_numera.getHeight());
        this.add(combo_numera);
        
        lbl_numero =new CampoLabel("Numero" ,"E");
        lbl_numero.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_numero.alinearDerecha();
        lbl_numero.setLocation(lbl_accion.getX(), lbl_numera.getY());
        this.add(lbl_numero);
        
        txt_numero = new CajaDeTexto("G",15);
        txt_numero.setLocation(lbl_numero.getX()+lbl_numero.getWidth()*5/4, lbl_numero.getY());
        txt_numero.setSize(CargaImagenes.anchoBotonCatalogos*2/3 , 30);
        this.add(txt_numero);
        
        lbl_controlExiistencia =new CampoLabel("C. existencia" ,"E");
        lbl_controlExiistencia.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_controlExiistencia.alinearDerecha();
        lbl_controlExiistencia.setLocation(lbl_codigo.getX(), CargaImagenes.ALTO_PANTALLA/100*20);
        this.add(lbl_controlExiistencia);
        
        combo_controlExis = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_controlExis.setLocation(lbl_controlExiistencia.getX()+lbl_controlExiistencia.getWidth()*5/4, lbl_controlExiistencia.getY());
        combo_controlExis.setSize(lbl_controlExiistencia.getWidth() * 8 / 9, lbl_controlExiistencia.getHeight());
        this.add(combo_controlExis);
        
        lbl_docBase =new CampoLabel("Doc. base" ,"E");
        lbl_docBase.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_docBase.alinearDerecha();
        lbl_docBase.setLocation(lbl_nombre.getX(), lbl_controlExiistencia.getY());
        this.add(lbl_docBase);
        
        combo_docBase = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_docBase.setLocation(lbl_docBase.getX()+lbl_docBase.getWidth()*5/4, lbl_docBase.getY());
        combo_docBase.setSize(lbl_docBase.getWidth() * 8 / 9, lbl_docBase.getHeight());
        this.add(combo_docBase);
        
        lbl_precioFijo =new CampoLabel("P. fijo" ,"E");
        lbl_precioFijo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_precioFijo.alinearDerecha();
        lbl_precioFijo.setLocation(lbl_numero.getX(), lbl_controlExiistencia.getY());
        this.add(lbl_precioFijo);
        
        combo_precioFijo = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_precioFijo.setLocation(lbl_precioFijo.getX()+lbl_precioFijo.getWidth()*5/4, lbl_precioFijo.getY());
        combo_precioFijo.setSize(lbl_precioFijo.getWidth() * 8 / 9, lbl_precioFijo.getHeight());
        this.add(combo_precioFijo);
        
        lbl_listaPrecio =new CampoLabel("Lista precio" ,"E");
        lbl_listaPrecio.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_listaPrecio.alinearDerecha();
        lbl_listaPrecio.setLocation(lbl_codigo.getX(), CargaImagenes.ALTO_PANTALLA/100*25);
        this.add(lbl_listaPrecio);
        
        combo_listaPrecio = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_listaPrecio.setLocation(lbl_listaPrecio.getX()+lbl_listaPrecio.getWidth()*5/4, lbl_listaPrecio.getY());
        combo_listaPrecio.setSize(lbl_listaPrecio.getWidth() * 8 / 9, lbl_listaPrecio.getHeight());
        this.add(combo_listaPrecio);
        
        lbl_costeoInv =new CampoLabel("Coste inv." ,"E");
        lbl_costeoInv.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_costeoInv.alinearDerecha();
        lbl_costeoInv.setLocation(lbl_docBase.getX(), lbl_listaPrecio.getY());
        this.add(lbl_costeoInv);
        
        combo_costeoInv = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_costeoInv.setLocation(lbl_costeoInv.getX()+lbl_costeoInv.getWidth()*5/4, lbl_costeoInv.getY());
        combo_costeoInv.setSize(lbl_costeoInv.getWidth() * 8 / 9, lbl_costeoInv.getHeight());
        this.add(combo_costeoInv);
        
        lbl_bodega =new CampoLabel("Bodega" ,"E");
        lbl_bodega.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_bodega.alinearDerecha();
        lbl_bodega.setLocation(lbl_precioFijo.getX(), lbl_listaPrecio.getY());
        this.add(lbl_bodega);
        
        txt_idBodega = new CajaDeTexto("");
        txt_bodega = new CajaDeTexto("G",15);
        txt_bodega.setLocation(lbl_bodega.getX()+lbl_bodega.getWidth()*5/4, lbl_bodega.getY());
        txt_bodega.setSize(CargaImagenes.anchoBotonCatalogos*2/3 , 30);
        this.add(txt_bodega);
        
        lbl_estado =new CampoLabel("Estado" ,"E");
        lbl_estado.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_estado.alinearDerecha();
        lbl_estado.setLocation(lbl_listaPrecio.getX() , CargaImagenes.ALTO_PANTALLA/100*30);
        this.add(lbl_estado);
        
        combo_estado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_estado.setLocation(lbl_estado.getX()+lbl_estado.getWidth()*5/4, lbl_estado.getY());
        combo_estado.setSize(lbl_estado.getWidth() * 8 / 9, lbl_estado.getHeight());
        this.add(combo_estado);
        
        lbl_eliminado  =new CampoLabel("Eliminado" ,"E");
        lbl_eliminado.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_eliminado.alinearDerecha();
        lbl_eliminado.setLocation(lbl_costeoInv.getX() , CargaImagenes.ALTO_PANTALLA/100*30);
        this.add(lbl_eliminado);
        
        combo_eliminado = new CampoCombo<String>(DatosBaseDatos.varSi, DatosBaseDatos.varNo);
        combo_eliminado.setLocation(lbl_eliminado.getX()+lbl_eliminado.getWidth()*5/4, lbl_eliminado.getY());
        combo_eliminado.setSize(lbl_eliminado.getWidth() * 8 / 9, lbl_eliminado.getHeight());
        this.add(combo_eliminado);

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
