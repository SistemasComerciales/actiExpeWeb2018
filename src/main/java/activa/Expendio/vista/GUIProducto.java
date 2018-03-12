/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.DatosBaseDatos;
import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.GrupoProducto;
import activa.Expendio.modelo.Usuario;
import static activa.Expendio.vista.GUIDocumentoFuente.columnaCodigo;
import static activa.Expendio.vista.GUIDocumentoFuente.columnaId;
import static activa.Expendio.vista.GUIDocumentoFuente.columnaIdBodega;
import static activa.Expendio.vista.GUIDocumentoFuente.columnaNombre;
import activa.Expendio.vista.utils.CajaDeTexto;
import activa.Expendio.vista.utils.CampoCombo;
import activa.Expendio.vista.utils.CampoLabel;
import activa.Expendio.vista.utils.Tabla;
import activa.Expendio.vista.utils.TablaNoEditable;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import utils.CargaImagenes;
import javax.swing.*;
import utils.*;
/**
 *
 * @author Administrador
 */
public class GUIProducto extends GUIInterfazCatalogos{
    
    
    private CampoLabel lbl_codigo, lbl_nombre, lbl_presentacion , _lbl_grupo, lbl_controlExistencia, lbl_afectaCupo, lbl_controlSerial, lbl_precio10Porciento, lbl_codigoBarras, lbl_observacion,lbl_estado, lbl_eliminado;
    private CajaDeTexto txt_codigo, txt_nombre, txt_presentacion, txt_grupo, txt_idGrupo, txt_codigoBarras, txt_observaciones;
    private CampoCombo<String> combo_controlExistencia, combo_afectaCupo, combo_controlSerial, combo_precio10Porciento, combo_estado, combo_eliminado;
    
    private static int columnaCodigo = 0;
    private static int columnaNombre = 1;
    private static int columnapresentacion = 2;
    private static int columnaGrupoProducto = 3;
    private static int columnaIdGrupoProducto = 4;
    private static int columnaControlExistencia = 5;
    private static int columnaAfectaCupo = 6;
    private static int columnaControlSerial = 7;
    private static int columnaPrecio10 = 8;
    private static int columnaCodigoBarras = 9;
    private static int columnaNota = 10;
    private static int columnaEstado = 11;
    private static int columnaEliminado = 12;
    private static int columnaId = 13;
    
    public GUIProducto(Usuario usuario ) {
	super(usuario, false);
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
        dtmTablaGeneral.addColumn("Código");//0
        dtmTablaGeneral.addColumn("Nombre");//1
        dtmTablaGeneral.addColumn("Presentacion");//2
        dtmTablaGeneral.addColumn("Grupo Prod.");//3
        dtmTablaGeneral.addColumn("idGrupo");//4
        dtmTablaGeneral.addColumn("C. existecia");//5
        dtmTablaGeneral.addColumn("A. cupo");//6
        dtmTablaGeneral.addColumn("Precio 10%");//7
        dtmTablaGeneral.addColumn("Cod. barras");//8
        dtmTablaGeneral.addColumn("Observaciones");//9
        dtmTablaGeneral.addColumn("Estado");//10
        dtmTablaGeneral.addColumn("Eliminado");//11
        dtmTablaGeneral.addColumn("idGrupo");//12
        dtmTablaGeneral.addColumn("id");//13

        
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
        
        tablaGeneral.getColumnModel().getColumn(columnaIdGrupoProducto).setMaxWidth(0);
        tablaGeneral.getColumnModel().getColumn(columnaIdGrupoProducto).setMinWidth(0);
        tablaGeneral.getColumnModel().getColumn(columnaIdGrupoProducto).setPreferredWidth(0);
        
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
        lbl_codigo.setLocation(CargaImagenes.ANCHO_PANTALLA/100*10, CargaImagenes.ALTO_PANTALLA/100*12);
        this.add(lbl_codigo);
        
        txt_codigo = new CajaDeTexto("G",15);
        txt_codigo.setLocation(lbl_codigo.getX()+lbl_codigo.getWidth()*5/4, lbl_codigo.getY());
        txt_codigo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_codigo);
        
        lbl_nombre =new CampoLabel("Nombre" ,"E");
        lbl_nombre.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_nombre.alinearDerecha();
        lbl_nombre.setLocation(CargaImagenes.ANCHO_PANTALLA/100*27, CargaImagenes.ALTO_PANTALLA/100*12);
        this.add(lbl_nombre);
        
        txt_nombre = new CajaDeTexto("G",15);
        txt_nombre.setLocation(lbl_nombre.getX()+lbl_nombre.getWidth()*5/4, lbl_nombre.getY());
        txt_nombre.setSize(CargaImagenes.anchoBotonCatalogos*2/3 , 30);
        this.add(txt_nombre);
        
        lbl_presentacion =new CampoLabel("Presentación" ,"E");
        lbl_presentacion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_presentacion.alinearDerecha();
        lbl_presentacion.setLocation(CargaImagenes.ANCHO_PANTALLA/100*50, CargaImagenes.ALTO_PANTALLA/100*12);
        this.add(lbl_presentacion);
        
        txt_presentacion = new CajaDeTexto("G",15);
        txt_presentacion.setLocation(lbl_presentacion.getX()+lbl_presentacion.getWidth()*5/4, lbl_presentacion.getY());
        txt_presentacion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_presentacion);
        
        lbl_controlExistencia =new CampoLabel("Control Existencia" ,"E");
        lbl_controlExistencia.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_controlExistencia.alinearDerecha();
        lbl_controlExistencia.setLocation(lbl_codigo.getX(), CargaImagenes.ALTO_PANTALLA/100*18);
        this.add(lbl_controlExistencia);
        
        combo_controlExistencia = new CampoCombo<String>(DatosBaseDatos.varNo, DatosBaseDatos.varSi);
        combo_controlExistencia.setLocation(lbl_controlExistencia.getX()+lbl_controlExistencia.getWidth()*5/4, lbl_controlExistencia.getY());
        combo_controlExistencia.setSize(lbl_controlExistencia.getWidth() * 8 / 9, lbl_controlExistencia.getHeight());
        this.add(combo_controlExistencia);
        
        lbl_afectaCupo =new CampoLabel("A. cupo" ,"E");
        lbl_afectaCupo.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_afectaCupo.alinearDerecha();
        lbl_afectaCupo.setLocation(lbl_nombre.getX(), lbl_controlExistencia.getY());
        this.add(lbl_afectaCupo);
        
        combo_afectaCupo = new CampoCombo<String>(DatosBaseDatos.varNo, DatosBaseDatos.varSi);
        combo_afectaCupo.setLocation(lbl_afectaCupo.getX()+lbl_afectaCupo.getWidth()*5/4, lbl_afectaCupo.getY());
        combo_afectaCupo.setSize(lbl_afectaCupo.getWidth() * 8 / 9, lbl_afectaCupo.getHeight());
        this.add(combo_afectaCupo);
        
        lbl_controlSerial =new CampoLabel("Control serial" ,"E");
        lbl_controlSerial.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_controlSerial.alinearDerecha();
        lbl_controlSerial.setLocation(lbl_presentacion.getX(), lbl_controlExistencia.getY());
        this.add(lbl_controlSerial);
        
        combo_controlSerial = new CampoCombo<String>(DatosBaseDatos.varNo, DatosBaseDatos.varSi);
        combo_controlSerial.setLocation(lbl_controlSerial.getX()+lbl_controlSerial.getWidth()*5/4, lbl_controlSerial.getY());
        combo_controlSerial.setSize(lbl_controlSerial.getWidth() * 8 / 9, lbl_controlSerial.getHeight());
        this.add(combo_controlSerial);
        
        lbl_precio10Porciento =new CampoLabel("Precio 10%" ,"E");
        lbl_precio10Porciento.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_precio10Porciento.alinearDerecha();
        lbl_precio10Porciento.setLocation(lbl_controlExistencia.getX(), CargaImagenes.ALTO_PANTALLA/100*24);
        this.add(lbl_precio10Porciento);
        
        combo_precio10Porciento = new CampoCombo<String>(DatosBaseDatos.varNo, DatosBaseDatos.varSi);
        combo_precio10Porciento.setLocation(lbl_precio10Porciento.getX()+lbl_precio10Porciento.getWidth()*5/4, lbl_precio10Porciento.getY());
        combo_precio10Porciento.setSize(lbl_precio10Porciento.getWidth() * 8 / 9, lbl_precio10Porciento.getHeight());
        this.add(combo_precio10Porciento);
        
        lbl_codigoBarras =new CampoLabel("Cod barras" ,"E");
        lbl_codigoBarras.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_codigoBarras.alinearDerecha();
        lbl_codigoBarras.setLocation(lbl_nombre.getX(), lbl_precio10Porciento.getY());
        this.add(lbl_codigoBarras);
        
        txt_codigoBarras = new CajaDeTexto("G",15);
        txt_codigoBarras.setLocation(lbl_codigoBarras.getX()+lbl_codigoBarras.getWidth()*5/4, lbl_codigoBarras.getY());
        txt_codigoBarras.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        this.add(txt_codigoBarras);
        
        lbl_estado =new CampoLabel("Estado" ,"E");
        lbl_estado.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_estado.alinearDerecha();
        lbl_estado.setLocation(lbl_controlSerial.getX(), lbl_precio10Porciento.getY());
        this.add(lbl_estado);
        
        combo_estado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_estado.setLocation(lbl_estado.getX()+lbl_estado.getWidth()*5/4, lbl_estado.getY());
        combo_estado.setSize(lbl_estado.getWidth() * 8 / 9, lbl_estado.getHeight());
        this.add(combo_estado);
        
        lbl_eliminado =new CampoLabel("Eliminado" ,"E");
        lbl_eliminado.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_eliminado.alinearDerecha();
        lbl_eliminado.setLocation(lbl_precio10Porciento.getX(),  CargaImagenes.ALTO_PANTALLA/100*30);
        this.add(lbl_eliminado);
        
        combo_eliminado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_eliminado.setLocation(lbl_eliminado.getX()+lbl_eliminado.getWidth()*5/4, lbl_eliminado.getY());
        combo_eliminado.setSize(lbl_eliminado.getWidth() * 8 / 9, lbl_eliminado.getHeight());
        this.add(combo_eliminado);
        
        lbl_observacion =new CampoLabel("Nota" ,"E");
        lbl_observacion.setSize(CargaImagenes.anchoBotonCatalogos/2 , 30);
        lbl_observacion.alinearDerecha();
        lbl_observacion.setLocation(lbl_codigoBarras.getX(), lbl_eliminado.getY());
        this.add(lbl_observacion);
        
        txt_observaciones = new CajaDeTexto("G",15);
        txt_observaciones.setLocation(lbl_observacion.getX()+lbl_observacion.getWidth()*5/4, lbl_observacion.getY());
        txt_observaciones.setSize(CargaImagenes.anchoBotonCatalogos , 30);
        this.add(txt_observaciones);
        
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
