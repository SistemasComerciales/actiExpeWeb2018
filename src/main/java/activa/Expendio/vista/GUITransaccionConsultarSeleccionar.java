package activa.Expendio.vista;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITransaccionConsultarSeleccionar extends ClaseGeneral {

    private CampoLabel lbl_numeroTransaccion;
    private CajaDeTexto txt_numeroTransaccion;

    private Boton btn_aceptar, btn_atras;

    //Tabla Internos
    private JPanel panelTablaTransacciones;
    private DefaultTableModel dtmTablaTransacciones;
    private JTable tablaTransacciones;
    private JScrollPane scrollPaneTablaTransacciones;
    private TableRowSorter<DefaultTableModel> trsFiltroTransacciones;

    // Indices de la tabla general
    private static final int columnaNumero = 0;
    private static final int columnaTD = columnaNumero + 1;
    private static final int columnaFecha = columnaTD + 1;
    private static final int columnaCondicion = columnaFecha + 1;
    private static final int columnaValorTotal = columnaCondicion + 1;
    private static final int columnaID = columnaValorTotal + 1;

    // Utilitarios
    private static String nombreClase = "Consulta de transacciones";
    public static final int limiteCaracteresNumero = 15;

    public GUITransaccionConsultarSeleccionar(Usuario usuario) {
        super(usuario);
        prepareElementos();
        prepareElementosInformacion();
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, nombreClase.toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
        prepareTablaTransacciones();
        prepareBotones();
        accionBotones();
        definaAcciones();
        accionTabla();
        inicializar();
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
        this.setTitle(nombreClase);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void actualizarFrame() {
        cargarTransacciones();
    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_numeroTransaccion.grabFocus();
    }

    @Override
    public void asignarPermisos() {
        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     */
    private void prepareTablaTransacciones() {

        panelTablaTransacciones = new JPanel();
        panelTablaTransacciones.setOpaque(false);
        panelTablaTransacciones.setBounds(CargaImagenes.ANCHO_PANTALLA / 40, (CargaImagenes.ALTO_PANTALLA / 25) * 6, 20 * CargaImagenes.ANCHO_PANTALLA / 20 - (2 * (CargaImagenes.ANCHO_PANTALLA / 40)), CargaImagenes.ALTO_PANTALLA / 2);
        this.add(panelTablaTransacciones);

        dtmTablaTransacciones = new TablaNoEditable();
        tablaTransacciones = new JTable(dtmTablaTransacciones);
        dtmTablaTransacciones.addColumn("Número");
        dtmTablaTransacciones.addColumn("TD");
        dtmTablaTransacciones.addColumn("Fecha");
        dtmTablaTransacciones.addColumn("Condición");
        dtmTablaTransacciones.addColumn("Valor Total");
        dtmTablaTransacciones.addColumn("ID");

        tablaTransacciones.setPreferredScrollableViewportSize(new Dimension(panelTablaTransacciones.getWidth() - 25, panelTablaTransacciones.getHeight() - 50));
        scrollPaneTablaTransacciones = new JScrollPane(tablaTransacciones);
        panelTablaTransacciones.add(scrollPaneTablaTransacciones);
        scrollPaneTablaTransacciones.setSize(panelTablaTransacciones.getWidth(), panelTablaTransacciones.getHeight());
        scrollPaneTablaTransacciones.setLocation(0, 0);

        tablaTransacciones.getTableHeader().setReorderingAllowed(false);
        tablaTransacciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaTransacciones.setDefaultRenderer(Object.class, new Tabla.MiRender());
        tablaTransacciones.setShowHorizontalLines(false);
        tablaTransacciones.setBorder(null);
        tablaTransacciones.setOpaque(false);
        scrollPaneTablaTransacciones.setOpaque(false);
        scrollPaneTablaTransacciones.getViewport().setOpaque(false);
        scrollPaneTablaTransacciones.setBorder(null);

        int columna = (panelTablaTransacciones.getWidth()) / 6;

        tablaTransacciones.getColumnModel().getColumn(columnaNumero).setPreferredWidth(columna * 1);
        tablaTransacciones.getColumnModel().getColumn(columnaTD).setPreferredWidth(columna * 1);
        tablaTransacciones.getColumnModel().getColumn(columnaFecha).setPreferredWidth(columna * 1);
        tablaTransacciones.getColumnModel().getColumn(columnaCondicion).setPreferredWidth(columna * 2);
        tablaTransacciones.getColumnModel().getColumn(columnaValorTotal).setPreferredWidth(columna * 1);

        tablaTransacciones.getColumnModel().getColumn(columnaID).setMinWidth(0);
        tablaTransacciones.getColumnModel().getColumn(columnaID).setPreferredWidth(0);
        tablaTransacciones.getColumnModel().getColumn(columnaID).setMaxWidth(0);
    }

    private void prepareBotones() {
        int espacioBotones = CargaImagenes.ANCHO_PANTALLA / 30;
        int posicionX = (CargaImagenes.ANCHO_PANTALLA - (CargaImagenes.anchoBotonGeneral * 2 - espacioBotones)) / 2;
        int posicionY = panelTablaTransacciones.getY() + panelTablaTransacciones.getHeight() + CargaImagenes.ALTO_PANTALLA / 20;

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

    private void accionBotones() {
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

    private void cargarTransacciones() {
        deshacerFiltro();
        Tabla.eliminarFilasTabla(dtmTablaTransacciones);

        PersistenciaTransaccionInt persistencia = Servicios.transaccionController.transaccionRepository;

        ArrayList<Transaccion> transacciones = persistencia.getListaTransacciones();

        for (Transaccion transaccion : transacciones) {
            Object[] datosFila = new Object[dtmTablaTransacciones.getColumnCount()];

            datosFila[columnaNumero] = transaccion.getNumero();
            datosFila[columnaTD] = transaccion.getInterno().getTd();
            datosFila[columnaFecha] = Fecha.obtenerFechaString(transaccion.getFecha());
            datosFila[columnaCondicion] = transaccion.getCondicion();

            double valorTotal = 0.0;
            ArrayList<TransaccionItem> movimientos = transaccion.getListItem();
            for (TransaccionItem mv : movimientos) {
                double cantidad = mv.getCantidad();
                double valor = mv.getValorUnitario();
                valorTotal += cantidad * valor;
            }
            datosFila[columnaValorTotal] = Formatos.formatearValorDecimalesString(String.valueOf(valorTotal), DatosGeneralesPrograma.cantidadDecimalesMoneda);

            datosFila[columnaID] = transaccion;

            dtmTablaTransacciones.addRow(datosFila);
        }

        if (tablaTransacciones.getRowCount() >= 1) {
            tablaTransacciones.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    private void deshacerFiltro() {
        Filtro.deshacerFiltro(trsFiltroTransacciones, dtmTablaTransacciones, tablaTransacciones);
    }

    private void definaAcciones() {
        txt_numeroTransaccion.addKeyListener(new KeyAdapter() {
            int fila = 0;

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        fila = tablaTransacciones.getSelectedRow();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (tablaTransacciones.getRowCount() > tablaTransacciones.getSelectedRow() + 1) {
                            tablaTransacciones.setRowSelectionInterval(tablaTransacciones.getSelectedRow() + 1, tablaTransacciones.getSelectedRow() + 1);
                            tablaTransacciones.scrollRectToVisible(new Rectangle(tablaTransacciones.getCellRect(tablaTransacciones.getSelectedRow(), columnaNumero, true)));
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (0 <= tablaTransacciones.getSelectedRow() - 1) {
                            tablaTransacciones.setRowSelectionInterval(tablaTransacciones.getSelectedRow() - 1, tablaTransacciones.getSelectedRow() - 1);
                            tablaTransacciones.scrollRectToVisible(new Rectangle(tablaTransacciones.getCellRect(tablaTransacciones.getSelectedRow(), columnaNumero, true)));
                        }
                        break;
                    case KeyEvent.VK_ENTER:
                        if (tablaTransacciones.getRowCount() >= 1) {
                            tablaTransacciones.getSelectionModel().setSelectionInterval(0, 0);
                            seleccionarTransaccion((Transaccion) tablaTransacciones.getValueAt(tablaTransacciones.getSelectedRow(), columnaID));
//                            combo_concepto.grabFocus();
                        }
                        break;
                    default:
                        Filtro.filtroDosColumnasQueContenga(txt_numeroTransaccion.getText(), trsFiltroTransacciones, columnaNumero, columnaTD, dtmTablaTransacciones, tablaTransacciones);
                        if (tablaTransacciones.getRowCount() >= 1) {
                            tablaTransacciones.getSelectionModel().setSelectionInterval(0, 0);
                        }
                        break;
                }
            }
        });
    }

    private void accionTabla() {
        tablaTransacciones.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent arg0) {
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                if (arg0.getKeyCode() == (KeyEvent.VK_F1) || arg0.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    if (tablaTransacciones.getRowCount() >= 1) {
                        tablaTransacciones.getSelectionModel().setSelectionInterval(0, 0);
                        seleccionarTransaccion((Transaccion) tablaTransacciones.getValueAt(tablaTransacciones.getSelectedRow(), columnaID));
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
    private void seleccionarTransaccion(Transaccion transaccion) {
//        new TransaccionConsultar(usuario, transaccion);
//        frame.setVisible(false);
    }

    private void accionBotonAceptar() {
        int fila = 0;
        if (tablaTransacciones.getSelectedRow() != -1) {
            fila = tablaTransacciones.getSelectedRow();
            seleccionarTransaccion((Transaccion) tablaTransacciones.getValueAt(fila, columnaID));
        } else if (tablaTransacciones.getRowCount() >= 1) {
            fila = 0;
            seleccionarTransaccion((Transaccion) tablaTransacciones.getValueAt(fila, columnaID));
        }
    }

}
