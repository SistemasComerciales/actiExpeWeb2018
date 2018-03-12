package activa.Expendio.vista.reportes;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import static activa.Expendio.vista.ClaseGeneral.*;
import activa.Expendio.vista.*;
import activa.Expendio.vista.tablas.*;
import activa.Expendio.vista.utils.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUIReporteMovimientosInterno extends GUIReportesConTabla {

    // Campos
    private CampoLabel lbl_interno, lbl_fechaInicial, lbl_fechaFinal;
    private CampoLabel txt_nombreInterno;
    private Long idInterno;
    private CajaDeTexto txt_interno;
    private CajaDeTextoConFormato txt_fechaInicial, txt_fechaFinal;
    private GUITablaInternos tablaInternos;

    // Botones
    private Boton btn_buscar, btn_exportar, btn_reporte;

    // Utilitarios
    private static String nombreClase = "Detalle de Movimientos";

    // Indices de la tabla
    public static final int columnaFecha = 0;
    public static final int columnaRecibo = columnaFecha + 1;
    public static final int columnaDescripcion = columnaRecibo + 1;
    public static final int columnaDebito = columnaDescripcion + 1;
    public static final int columnaCredito = columnaDebito + 1;
    public static final int columnaSaldo = columnaCredito + 1;
    public static final int columnaUsuario = columnaSaldo + 1;
    public static final int columnaUltimaActualizacion = columnaUsuario + 1;
    public static final int columnaSaldoTiquete = columnaUltimaActualizacion + 1;

    public GUIReporteMovimientosInterno(Usuario usuario) {
        super(usuario);

        inicializar();
    }

    @Override
    protected String getNombreClase() {
        return nombreClase;
    }

    @Override
    protected void elementosInformacion() {// XXX Panel de Informacion
        int posicionX = CargaImagenes.ANCHO_PANTALLA / 100 * 2;
        int posicionY = CargaImagenes.ALTO_PANTALLA / 100 * 10;
        int altoTxt = (4 * (CargaImagenes.ALTO_PANTALLA / 18)) / 6;
        int anchoTxt = CargaImagenes.ANCHO_PANTALLA / 10;
        int anchoLabel = CargaImagenes.ANCHO_PANTALLA / 18;
        int var = 10;

        lbl_interno = new CampoLabel("Interno:", CampoLabel.labelEstatico);
        lbl_interno.setLocation(posicionX, posicionY);
        lbl_interno.setSize(anchoLabel * 3 / 2, altoTxt);
        lbl_interno.alinearIzquierda();
        panel_informacion.add(lbl_interno);

        txt_interno = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_interno.setLocation(lbl_interno.getX() + lbl_interno.getWidth() + var, lbl_interno.getY());
        txt_interno.setSize(anchoTxt, lbl_interno.getHeight());
        panel_informacion.add(txt_interno);

        txt_nombreInterno = new CampoLabel("", CampoLabel.labelVariable);
        txt_nombreInterno.setLocation(txt_interno.getX() + txt_interno.getWidth() + var, txt_interno.getY());
        txt_nombreInterno.setSize(lbl_interno.getWidth() * 3, lbl_interno.getHeight());
        panel_informacion.add(txt_nombreInterno);

        lbl_fechaInicial = new CampoLabel("Fecha Inicial:", CampoLabel.labelEstatico);
        lbl_fechaInicial.setLocation(lbl_interno.getX(), lbl_interno.getY() + lbl_interno.getHeight() + var * 2);
        lbl_fechaInicial.setSize(lbl_interno.getWidth(), lbl_interno.getHeight());
        lbl_fechaInicial.alinearIzquierda();
        panel_informacion.add(lbl_fechaInicial);

        txt_fechaInicial = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fechaInicial.setLocation(lbl_fechaInicial.getX() + lbl_fechaInicial.getWidth() + var, lbl_fechaInicial.getY());
        txt_fechaInicial.setSize(txt_interno.getWidth(), txt_interno.getHeight());
        panel_informacion.add(txt_fechaInicial);

        lbl_fechaFinal = new CampoLabel("Fecha Final:", CampoLabel.labelEstatico);
        lbl_fechaFinal.setLocation(txt_fechaInicial.getX() + txt_fechaInicial.getWidth() + var * 2, txt_fechaInicial.getY());
        lbl_fechaFinal.setSize(lbl_fechaInicial.getWidth(), lbl_fechaInicial.getHeight());
        lbl_fechaFinal.alinearIzquierda();
        panel_informacion.add(lbl_fechaFinal);

        txt_fechaFinal = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fechaFinal.setLocation(lbl_fechaFinal.getX() + lbl_fechaFinal.getWidth() + var, lbl_fechaFinal.getY());
        txt_fechaFinal.setSize(txt_fechaInicial.getWidth(), txt_fechaInicial.getHeight());
        panel_informacion.add(txt_fechaFinal);

        int posX = txt_nombreInterno.getX() + txt_nombreInterno.getWidth() + var * 10;
        int posY = txt_nombreInterno.getY();
        int anchoPanel = this.getWidth() / 100 * 37;
        int altoPanel = this.getHeight() / 100 * 25;
        tablaInternos = new GUITablaInternos(posX, posY, anchoPanel, altoPanel);
        panel_informacion.add(tablaInternos);
    }

    @Override
    protected void elementosBotones() {// XXX Panel de botones
        btn_buscar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Buscar");
        panel_botones.add(new PanelBoton(btn_buscar));
        btn_buscar.setToolTipText("F1");

        btn_exportar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Exportar");
        panel_botones.add(new PanelBoton(btn_exportar));
        btn_exportar.setToolTipText("F2");

        btn_reporte = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Reporte");
        panel_botones.add(new PanelBoton(btn_reporte));
        btn_reporte.setToolTipText("F3");
    }

    @Override
    protected void adicionarColumnas() {// XXX Panel de tabla
        dtmTablaGeneral.addColumn("Fecha");
        dtmTablaGeneral.addColumn("# Recibo");
        dtmTablaGeneral.addColumn("Descripción");
        dtmTablaGeneral.addColumn("Débito");
        dtmTablaGeneral.addColumn("Crédito");
        dtmTablaGeneral.addColumn("Saldo");
        dtmTablaGeneral.addColumn("Usuario");
        dtmTablaGeneral.addColumn("Última Actualiz.");
        dtmTablaGeneral.addColumn("Saldo en Tiquete");
    }

    @Override
    protected void cambiarTamanoColumnas() {
        int anchoTotal = panel_tablaGeneral.getWidth() / 5;

        tablaGeneral.getColumnModel().getColumn(columnaFecha).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaFecha).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaFecha).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaRecibo).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaRecibo).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaRecibo).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaDescripcion).setMaxWidth(anchoTotal * 3 / 2);
        tablaGeneral.getColumnModel().getColumn(columnaDescripcion).setMinWidth(anchoTotal * 3 / 2);
        tablaGeneral.getColumnModel().getColumn(columnaDescripcion).setPreferredWidth(anchoTotal * 3 / 2);

        tablaGeneral.getColumnModel().getColumn(columnaDebito).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaDebito).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaDebito).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaCredito).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaCredito).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaCredito).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaSaldo).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaSaldo).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaSaldo).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaUsuario).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaUsuario).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaUsuario).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaUltimaActualizacion).setMaxWidth(anchoTotal * 2 / 3);
        tablaGeneral.getColumnModel().getColumn(columnaUltimaActualizacion).setMinWidth(anchoTotal * 2 / 3);
        tablaGeneral.getColumnModel().getColumn(columnaUltimaActualizacion).setPreferredWidth(anchoTotal * 2 / 3);

        tablaGeneral.getColumnModel().getColumn(columnaSaldoTiquete).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaSaldoTiquete).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaSaldoTiquete).setPreferredWidth(anchoTotal / 3);
    }

    @Override
    protected void definaAccionesInformacion() {
        txt_interno.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                String dato = txt_interno.getText().trim();
                if (dato.isEmpty()) {
                    inicializarInterno();
                } else if (!tablaInternos.tabla.isRowSelected(tablaInternos.tabla.getSelectedRow())) {
                    Interno interno = Servicios.internosController.internosRepository.consultarPorTd(dato);
                    if (interno == null) {
                        option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El interno no existe.", "Por favor inténtelo de nuevo.");
                        inicializarInterno();
                        txt_interno.grabFocus();
                    } else {
                        System.err.println(interno.getTd());
                        seleccionarInterno(interno);
                    }
                }
            }
        });
        txt_interno.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN) {
                    ValidacionCampos.teclasDireccion(e, null, txt_fechaInicial, null, null, txt_interno);
                } else {
                    tablaInternos.aplicarFiltro(txt_interno);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    tablaInternos.grabFocus();
                }
            }
        });
        realizarAccionesTablaInternos();

        ValidacionCampos.asignarTeclasDireccion(txt_fechaInicial, txt_interno, txt_fechaFinal, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_fechaFinal, txt_fechaInicial, btn_buscar, null, null);
    }

    private void realizarAccionesTablaInternos() {// Acciones Tabla Internos
        tablaInternos.tabla.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isMetaDown()) {
                    seleccionarDatosInterno();
                    txt_fechaInicial.grabFocus();
                }
            }
        });
        tablaInternos.tabla.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    seleccionarDatosInterno();
                    txt_fechaInicial.grabFocus();
                }
            }
        });
    }

    private void seleccionarDatosInterno() {
        int fila = tablaInternos.tabla.getSelectedRow();
        if (fila != -1) {
            txt_interno.setText(tablaInternos.tabla.getValueAt(fila, GUITablaInternos.columnaTD).toString());
            idInterno = Long.parseLong(tablaInternos.tabla.getValueAt(fila, GUITablaInternos.columnaId).toString());
            txt_nombreInterno.setText(tablaInternos.tabla.getValueAt(fila, GUITablaInternos.columnaNombre).toString());
        }
    }

    private void seleccionarInterno(Interno interno) {
        txt_interno.setText(interno.getTd());
        idInterno = interno.getId();

        String primerApellido = interno.getPrimerApellido();
        String segundoApellido = interno.getSegundoApellido();
        String primerNombre = interno.getPrimerNombre();
        String segundoNombre = interno.getSegundoNombre();
        String nombre = primerApellido + " " + segundoApellido + " " + primerNombre;
        if (segundoNombre != null && !segundoNombre.trim().isEmpty()) {
            nombre += " " + segundoNombre;
        }
        txt_nombreInterno.setText(nombre);
    }

    @Override
    protected void accionesBotones() {// XXX Acciones Botones
        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                String vacios = validarCampos();
                if (vacios.isEmpty()) {
                    accionBotonBuscar();
                } else {
                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Los Siguientes campos no pueden estar vacíos:", vacios);
                    vacios = "";
                    txt_interno.grabFocus();
                }
            }
        });
        btn_buscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT: {
                        btn_exportar.grabFocus();
                    }
                    break;
                    case KeyEvent.VK_ENTER: {
                        btn_buscar.doClick();
                    }
                    break;
                    case KeyEvent.VK_UP: {
                        txt_fechaFinal.grabFocus();
                    }
                    break;
                }
                setKeysButtonsMiddle(e);
            }
        });

        btn_exportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String vacios = validarCampos();
                if (vacios.isEmpty()) {
                    accionBotonBuscar();
                    accionBotonExcel(tablaGeneral, nombreClase, frame, usuario);
                } else {
                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Los Siguientes campos no pueden estar vacíos:", vacios);
                    vacios = "";
                    txt_interno.grabFocus();
                }
            }
        });
        btn_exportar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT: {
                        btn_reporte.grabFocus();
                    }
                    break;
                    case KeyEvent.VK_LEFT: {
                        btn_buscar.grabFocus();
                    }
                    break;
                    case KeyEvent.VK_ENTER: {
                        btn_exportar.doClick();
                    }
                    break;
                }
                setKeysButtonsMiddle(e);
            }
        });

        btn_reporte.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String vacios = validarCampos();
                if (vacios.isEmpty()) {
                    accionBotonBuscar();
                    accionBotonReporte();
                } else {
                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Los Siguientes campos no pueden estar vacíos:", vacios);
                    vacios = "";
                    txt_interno.grabFocus();
                }
            }
        });
        btn_reporte.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT: {
                        btn_salir.grabFocus();
                    }
                    break;
                    case KeyEvent.VK_LEFT: {
                        btn_exportar.grabFocus();
                    }
                    break;
                    case KeyEvent.VK_ENTER: {
                        btn_reporte.doClick();
                    }
                    break;
                }
                setKeysButtonsMiddle(e);
            }
        });
    }

    @Override
    protected Boton botonAnterior() {
        return btn_reporte;
    }

    @Override
    protected void otrosKeyButtonsMiddle(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_F1:
                btn_buscar.grabFocus();
                btn_buscar.doClick();
                break;
            case KeyEvent.VK_F2:
                btn_exportar.grabFocus();
                btn_exportar.doClick();
                break;
            case KeyEvent.VK_F3:
                btn_reporte.grabFocus();
                btn_reporte.doClick();
                break;
        }
    }

    private String validarCampos() {
        String vacios = "";
        if (txt_interno.getText().trim().isEmpty()) {
            vacios += "-  Interno \n";
        }
        if (idInterno == null) {
            vacios += "-  ID Interno \n";
        }
        if (txt_fechaInicial.getText().replace("/", "").trim().isEmpty()) {
            vacios += "-  Fecha Inicial \n";
        }
        if (txt_fechaFinal.getText().replace("/", "").trim().isEmpty()) {
            vacios += "-  Fecha Final \n";
        }
        return vacios;
    }

    private void accionBotonBuscar() {// Boton Buscar
        setCursor(cursorEspera);

        limpiarTabla();

        String fechaInicial = txt_fechaInicial.getText().trim();
        String fechaFinal = txt_fechaFinal.getText().trim();

        List<Map<String, Object>> lista = reportFinder.traerMovimientosInterno(idInterno, fechaInicial, fechaFinal);
        double saldo = 0.0;
        if (lista != null) {
            for (Map<String, Object> fila : lista) {
                String[] datosTablaGeneral = new String[dtmTablaGeneral.getColumnCount()];

                datosTablaGeneral[columnaFecha] = Fecha.obtenerFechaString((Date) fila.get("fecha"));
                datosTablaGeneral[columnaRecibo] = (String) fila.get("numeroRecibo");
                datosTablaGeneral[columnaDescripcion] = (String) fila.get("descripcion");

                double valor = (double) fila.get("valor");
                boolean esIngreso = (boolean) fila.get("esIngreso");

                double debito = 0.0, credito = 0.0;
                if (esIngreso) {
                    debito = valor;
                } else {
                    credito = valor;
                }

                saldo += debito - credito;

                datosTablaGeneral[columnaDebito] = Formatos.formatearValorString(String.valueOf(debito));
                datosTablaGeneral[columnaCredito] = Formatos.formatearValorString(String.valueOf(credito));
                datosTablaGeneral[columnaSaldo] = Formatos.formatearValorString(String.valueOf(saldo));

                Usuario usuario = (Usuario) fila.get("usuario");
                if (usuario != null) {
                    datosTablaGeneral[columnaUsuario] = usuario.getNombres();
                } else {
                    datosTablaGeneral[columnaUsuario] = "";
                }

                Timestamp modificacion = (Timestamp) fila.get("fechaModificacion");
                if (modificacion != null) {
                    datosTablaGeneral[columnaUltimaActualizacion] = modificacion.toString();
                } else {
                    datosTablaGeneral[columnaUltimaActualizacion] = "";
                }

                datosTablaGeneral[columnaSaldoTiquete] = Formatos.formatearValorString(String.valueOf(0.0));

                dtmTablaGeneral.addRow(datosTablaGeneral);
            }
        }

        setCursor(null);
    }

    private void accionBotonReporte() {// Boton Reporte
        setCursor(cursorEspera);

        String titulo = nombreClase;

        String tdInterno = txt_interno.getText().trim();
        String nombreInterno = txt_nombreInterno.getText().trim();
        String fechaInicial = txt_fechaInicial.getText().trim();
        String fechaFinal = txt_fechaFinal.getText().trim();

//        TesoreriaReportsBuilder report = new TesoreriaReportsBuilder(usuario);
//        report.reporteRecibosCobroFiller(titulo, Integer.parseInt(mes), cobrados, fechaInicial, fechaFinal, dtmTablaGeneral, this);
        setCursor(null);
    }

    private final void limpiarTabla() {
        Tabla.eliminarFilasTabla(dtmTablaGeneral);
    }

    private void inicializarInterno() {
        tablaInternos.deshacerFiltro();
        txt_interno.setText("");
        txt_nombreInterno.setText("");
        idInterno = null;
    }

    @Override
    protected final void inicializarCampos() {
        inicializarInterno();

        txt_fechaInicial.setText("");
        txt_fechaFinal.setText("");

        tablaInternos.deshacerFiltro();
    }

    @Override
    protected void otrasInicializaciones() {
        limpiarTabla();
        tablaInternos.cargarDatosBasicos(usuario);
    }

    @Override
    public void asignarFoco() {
        txt_interno.grabFocus();
    }

}
