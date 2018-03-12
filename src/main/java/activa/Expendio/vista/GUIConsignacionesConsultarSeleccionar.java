/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.controllers.Servicios;
import activa.Expendio.modelo.Configuracion;
import activa.Expendio.modelo.Consignacion;
import activa.Expendio.modelo.DatosGeneralesPrograma;
import activa.Expendio.modelo.Interno;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.persistencia.Interface.PersistenciaConsignacionInt;
import activa.Expendio.persistencia.Interface.PersistenciaInternoInt;
import static activa.Expendio.vista.GUIConsignacionesRegistrar.limiteCaracteresNumero;
import static activa.Expendio.vista.GUIConsignacionesRegistrar.limiteCaracteresTD;
import activa.Expendio.vista.utils.Boton;
import activa.Expendio.vista.utils.CajaDeTexto;
import activa.Expendio.vista.utils.CajaDeTextoConFormato;
import activa.Expendio.vista.utils.CampoLabel;
import activa.Expendio.vista.utils.PanelBorde;
import activa.Expendio.vista.utils.Tabla;
import activa.Expendio.vista.utils.TablaNoEditable;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.CargaImagenes;
import utils.Fecha;
import utils.Filtro;
import utils.Formatos;
import utils.Imagenes;
import utils.NombreImagenes;

/**
 *
 * @author Administrador
 */
public class GUIConsignacionesConsultarSeleccionar extends ClaseGeneral{

    private CampoLabel lbl_numeroTransaccion;
    private CajaDeTexto txt_numeroTransaccion;
    
    private Boton btn_aceptar, btn_atras;
    
    //Tabla Internos
    private JPanel panelTablaConsignaciones;
    private DefaultTableModel dtmTablaConsignaciones;
    private JTable tablaConsignaciones;
    private JScrollPane scrollPaneTablaConsignaciones;
    private TableRowSorter<DefaultTableModel> trsFiltroConsignaciones;
    
    public GUIConsignacionesConsultarSeleccionar(Usuario usuario) {
        super(usuario);
        prepareElementos();
        prepareElementosInformacion();
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "Consulta de consignaciones".toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
        prepareTablaConsignaciones();
        prepareBotones();
        accionBotones();
        definaAcciones();
        cargarConsignaciones();
        accionTabla();
        txt_numeroTransaccion.grabFocus();
    }
    
    
    private void prepareElementosInformacion() {
        int posicionX = CargaImagenes.ANCHO_PANTALLA / 100 * 4;
        int posicionY = CargaImagenes.ALTO_PANTALLA / 100 * 15;
        int altoObjetos = 25;
        int anchoTxt = CargaImagenes.ANCHO_PANTALLA / 10;
        int anchoLabel = CargaImagenes.ANCHO_PANTALLA / 18;
        int var = 10;

        lbl_numeroTransaccion = new CampoLabel("Transacción #:", CampoLabel.labelEstatico);
        lbl_numeroTransaccion.alinearIzquierda();
        lbl_numeroTransaccion.setLocation(posicionX, posicionY);
        lbl_numeroTransaccion.setSize(anchoLabel + anchoTxt, altoObjetos);
        this.add(lbl_numeroTransaccion);

        txt_numeroTransaccion = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresNumero);
        txt_numeroTransaccion.setLocation(lbl_numeroTransaccion.getX() + (lbl_numeroTransaccion.getWidth() / 2) + var, lbl_numeroTransaccion.getY());
        txt_numeroTransaccion.setSize(anchoTxt, altoObjetos);
        this.add(txt_numeroTransaccion);
    }
    
    /**
     * Método encargado del diseño del frame, tamaño, fondo.
     */
    private void prepareElementos() {
        this.setTitle("Consulta de consignaciones");
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void actualizarFrame() {
        cargarConsignaciones();
    }

    @Override
    public void eliminarReferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_numeroTransaccion.grabFocus();
    }

    @Override
    public void asignarPermisos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     */
    private void prepareTablaConsignaciones() {

        panelTablaConsignaciones = new JPanel();
        panelTablaConsignaciones.setOpaque(false);
        panelTablaConsignaciones.setBounds(CargaImagenes.ANCHO_PANTALLA / 40, (CargaImagenes.ALTO_PANTALLA / 25) * 6, 20 * CargaImagenes.ANCHO_PANTALLA / 20 - (2*(CargaImagenes.ANCHO_PANTALLA / 40)), CargaImagenes.ALTO_PANTALLA / 2);
        this.add(panelTablaConsignaciones);

        dtmTablaConsignaciones= new TablaNoEditable();
        tablaConsignaciones = new JTable(dtmTablaConsignaciones);
        dtmTablaConsignaciones.addColumn("Número");
        dtmTablaConsignaciones.addColumn("TD");
        dtmTablaConsignaciones.addColumn("Recibo");
        dtmTablaConsignaciones.addColumn("Fecha");
        dtmTablaConsignaciones.addColumn("Concepto");
        dtmTablaConsignaciones.addColumn("Valor");
        dtmTablaConsignaciones.addColumn("Consignación");

        tablaConsignaciones.setPreferredScrollableViewportSize(new Dimension(panelTablaConsignaciones.getWidth() - 25, panelTablaConsignaciones.getHeight() - 50));
        scrollPaneTablaConsignaciones = new JScrollPane(tablaConsignaciones);
        panelTablaConsignaciones.add(scrollPaneTablaConsignaciones);
        scrollPaneTablaConsignaciones.setSize(panelTablaConsignaciones.getWidth(), panelTablaConsignaciones.getHeight());
        scrollPaneTablaConsignaciones.setLocation(0, 0);

        tablaConsignaciones.getTableHeader().setReorderingAllowed(false);
        tablaConsignaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaConsignaciones.setDefaultRenderer(Object.class, new Tabla.MiRender());
        tablaConsignaciones.setShowHorizontalLines(false);
        tablaConsignaciones.setBorder(null);
        tablaConsignaciones.setOpaque(false);
        scrollPaneTablaConsignaciones.setOpaque(false);
        scrollPaneTablaConsignaciones.getViewport().setOpaque(false);
        scrollPaneTablaConsignaciones.setBorder(null);

        int columna = (panelTablaConsignaciones.getWidth()) / 6;

        tablaConsignaciones.getColumnModel().getColumn(0).setPreferredWidth(columna * 1);
        tablaConsignaciones.getColumnModel().getColumn(1).setPreferredWidth(columna * 1);
        tablaConsignaciones.getColumnModel().getColumn(2).setPreferredWidth(columna * 1);
        tablaConsignaciones.getColumnModel().getColumn(3).setPreferredWidth(columna * 1);
        tablaConsignaciones.getColumnModel().getColumn(4).setPreferredWidth(columna * 1);
        tablaConsignaciones.getColumnModel().getColumn(5).setPreferredWidth(columna * 1);

        tablaConsignaciones.getColumnModel().getColumn(6).setMinWidth(0);
        tablaConsignaciones.getColumnModel().getColumn(6).setPreferredWidth(0);
        tablaConsignaciones.getColumnModel().getColumn(6).setMaxWidth(0);

    }
    
    
    private void prepareBotones(){
        int espacioBotones = CargaImagenes.ANCHO_PANTALLA/30; 
        int posicionX = (CargaImagenes.ANCHO_PANTALLA - (CargaImagenes.anchoBotonGeneral*2 - espacioBotones))/2;
        int posicionY = panelTablaConsignaciones.getY() + panelTablaConsignaciones.getHeight() + CargaImagenes.ALTO_PANTALLA/20;
        
        
        
        btn_aceptar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Aceptar");
        btn_aceptar.setLocation(posicionX, posicionY);
        btn_aceptar.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_aceptar);
        btn_aceptar.setToolTipText("Aceptar");

        btn_atras = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Atras");
        btn_atras.setLocation(btn_aceptar.getX() + btn_aceptar.getWidth() + espacioBotones, posicionY);
        btn_atras.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_atras);
        btn_atras.setToolTipText("Atrás");
    }
    
    private void accionBotones(){
        btn_atras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonSalir();
            }
        });
        btn_aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonAceptar();
            }
        });
    }
    
    
    private void cargarConsignaciones(){
        deshacerFiltro();
        Tabla.eliminarFilasTabla(dtmTablaConsignaciones);

        PersistenciaConsignacionInt persistencia = Servicios.consignacionesController.consignacionesRepository;

        ArrayList<Consignacion> consignaciones = persistencia.consultarActivosNoEliminados();

        for (Consignacion consignacion : consignaciones) {
            Object[] datosFila = new Object[dtmTablaConsignaciones.getColumnCount()];

            datosFila[0] = consignacion.getNumeroTransaccion();
            datosFila[1] = consignacion.getInterno().getTd();
            datosFila[2] = consignacion.getNumeroRecibo();
            datosFila[3] = Fecha.obtenerFechaString(consignacion.getFecha());
//            datosFila[3] = consignacion.getFecha();   
            datosFila[4] = consignacion.getConcepto();
            datosFila[5] = Formatos.formatearValorDecimalesString(String.valueOf(consignacion.getValor()), DatosGeneralesPrograma.cantidadDecimalesMoneda);
            datosFila[6] = consignacion;
            dtmTablaConsignaciones.addRow(datosFila);
        }

        if (tablaConsignaciones.getRowCount() >= 1) {
            tablaConsignaciones.getSelectionModel().setSelectionInterval(0, 0);
        }
    }
    
    private void deshacerFiltro() {
        Filtro.deshacerFiltro(trsFiltroConsignaciones, dtmTablaConsignaciones, tablaConsignaciones);
    }
    
    
    private void definaAcciones(){
        txt_numeroTransaccion.addKeyListener(new KeyAdapter() {
            int fila = 0;
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        fila = tablaConsignaciones.getSelectedRow();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (tablaConsignaciones.getRowCount() > tablaConsignaciones.getSelectedRow() + 1) {
                            tablaConsignaciones.setRowSelectionInterval(tablaConsignaciones.getSelectedRow() + 1, tablaConsignaciones.getSelectedRow() + 1);
                            tablaConsignaciones.scrollRectToVisible(new Rectangle(tablaConsignaciones.getCellRect(tablaConsignaciones.getSelectedRow(), 0, true)));
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (0 <= tablaConsignaciones.getSelectedRow() - 1) {
                            tablaConsignaciones.setRowSelectionInterval(tablaConsignaciones.getSelectedRow() - 1, tablaConsignaciones.getSelectedRow() - 1);
                            tablaConsignaciones.scrollRectToVisible(new Rectangle(tablaConsignaciones.getCellRect(tablaConsignaciones.getSelectedRow(), 0, true)));
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if (tablaConsignaciones.getRowCount() >= 1) {
                            tablaConsignaciones.getSelectionModel().setSelectionInterval(0, 0);
                            seleccionarConsignacion((Consignacion) tablaConsignaciones.getValueAt(tablaConsignaciones.getSelectedRow(), 6));
//                            combo_concepto.grabFocus();
                        } 
                        break;
                    default:
                        Filtro.filtroCincoColumnasQueContenga(txt_numeroTransaccion.getText(), trsFiltroConsignaciones, 0, 1, 2, 3, 4, dtmTablaConsignaciones, tablaConsignaciones);
                        if (tablaConsignaciones.getRowCount() >= 1) {
                            tablaConsignaciones.getSelectionModel().setSelectionInterval(0, 0);
                        }
                        break;
                }
            }
        });
    }
    
    private void accionTabla() {
        tablaConsignaciones.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                if (arg0.getKeyCode() == (KeyEvent.VK_F1) || arg0.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    if (tablaConsignaciones.getRowCount() >= 1) {
                        tablaConsignaciones.getSelectionModel().setSelectionInterval(0, 0);
                        seleccionarConsignacion((Consignacion) tablaConsignaciones.getValueAt(tablaConsignaciones.getSelectedRow(), 6));
//                        combo_concepto.grabFocus();
                    } 
                }
            }
        });
    }
    
    /**
     * 
     * @param consignacion 
     */
    private void seleccionarConsignacion(Consignacion consignacion){
        new GUIConsignacionesConsultar(usuario, consignacion);
        frame.setVisible(false);
    }
    
    
    private void accionBotonAceptar(){
        int fila = 0;
        if(tablaConsignaciones.getSelectedRow()!=-1){
            fila = tablaConsignaciones.getSelectedRow();
            seleccionarConsignacion((Consignacion) tablaConsignaciones.getValueAt(fila, 6));
        }
        else if(tablaConsignaciones.getRowCount() >= 1){
            fila = 0;
            seleccionarConsignacion((Consignacion) tablaConsignaciones.getValueAt(fila, 6));
        }
    }
}
