package activa.Expendio.vista;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUICatalogoInternos extends GUIInterfazCatalogos {

    // Panel de informacion
    private JPanel panel_informacion;
    private CampoLabel lbl_td, lbl_nui, lbl_primerApellido, lbl_segundoApellido, lbl_primerNombre, lbl_segundoNombre;
    private CampoLabel lbl_nacionalidad, lbl_situacionJuridica, lbl_fechaIngreso, lbl_fechaSalida, lbl_delito, lbl_observaciones, lbl_estado, lbl_foto;
    private Long idInterno;
    private CajaDeTexto txt_td, txt_nui, txt_primerApellido, txt_segundoApellido, txt_primerNombre, txt_segundoNombre;
    private CajaDeTexto txt_nacionalidad, txt_situacionJuridica, txt_foto;
    private CajaDeTextoConFormato txt_fechaIngreso, txt_fechaSalida;
    private CajaTextoArea txt_delito, txt_observaciones;
    private JScrollPane scroll_delito, scroll_observaciones;
    private CampoCombo<String> combo_estado;
    private Boton btn_foto;
    private JLabel lbl_imagenFoto;

    public static final int longitudMaximaFoto = 2000;

    // Utilitarios
    private static String nombreClase = "Internos";

    // Indices de la tabla general
    public static final int columnaTd = 0;
    public static final int columnaNui = columnaTd + 1;
    public static final int columnaPrimerApellido = columnaNui + 1;
    public static final int columnaSegundoApellido = columnaPrimerApellido + 1;
    public static final int columnaPrimerNombre = columnaSegundoApellido + 1;
    public static final int columnaSegundoNombre = columnaPrimerNombre + 1;
    public static final int columnaNacionalidad = columnaSegundoNombre + 1;
    public static final int columnaSituacionJuridica = columnaNacionalidad + 1;
    public static final int columnaFechaIngreso = columnaSituacionJuridica + 1;
    public static final int columnaFechaSalida = columnaFechaIngreso + 1;
    public static final int columnaDelito = columnaFechaSalida + 1;
    public static final int columnaObservaciones = columnaDelito + 1;
    public static final int columnaRutaImagen = columnaObservaciones + 1;
    public static final int columnaEstado = columnaRutaImagen + 1;
    public static final int columnaId = columnaEstado + 1;

    public GUICatalogoInternos(Usuario usuario) {
        super(usuario, false);
    }

    @Override
    protected String getNombreClase() {
        return nombreClase;
    }

    @Override
    protected void prepareElementosInformacion() {// panel de Informacion
        int margenSuperior = CargaImagenes.ALTO_PANTALLA / 13;
        int margenPanel = CargaImagenes.ANCHO_PANTALLA / 60;
        int varPanel = 2;

        panel_informacion = new JPanel();
        panel_informacion.setLocation(margenPanel + varPanel, margenSuperior);
        panel_informacion.setSize(CargaImagenes.ANCHO_PANTALLA - margenPanel * 2, CargaImagenes.ALTO_PANTALLA / 4);
        panel_informacion.setLayout(null);
        panel_informacion.setOpaque(false);
        this.add(panel_informacion);

        int var = 4, var2 = var * 2;
        int margen = 2;
        int labelWidth = CargaImagenes.ANCHO_PANTALLA / 18, labelHeight = CargaImagenes.ALTO_PANTALLA / 30;
        int txtWidth = CargaImagenes.ANCHO_PANTALLA / 12;

        lbl_td = new CampoLabel("TD:", CampoLabel.labelEstatico);
        lbl_td.setLocation(margen, margen / 2);
        lbl_td.setSize(labelWidth * 2, labelHeight);
        panel_informacion.add(lbl_td);

        txt_td = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_td.setLocation(lbl_td.getX() + lbl_td.getWidth() + var, lbl_td.getY());
        txt_td.setSize(txtWidth, lbl_td.getHeight());
//        txt_td.setEnabled(false);
        panel_informacion.add(txt_td);

        lbl_nui = new CampoLabel("NUI:", CampoLabel.labelEstatico);
        lbl_nui.setLocation(lbl_td.getX(), lbl_td.getY() + lbl_td.getHeight() + var);
        lbl_nui.setSize(lbl_td.getWidth(), lbl_td.getHeight());
        panel_informacion.add(lbl_nui);

        txt_nui = new CajaDeTexto(CajaDeTexto.textoNumeroEntero);
        txt_nui.setLocation(lbl_nui.getX() + lbl_nui.getWidth() + var, lbl_nui.getY());
        txt_nui.setSize(txt_td.getWidth(), txt_td.getHeight());
        panel_informacion.add(txt_nui);

        lbl_primerApellido = new CampoLabel("Primer Apellido:", CampoLabel.labelEstatico);
        lbl_primerApellido.setLocation(lbl_nui.getX(), lbl_nui.getY() + lbl_nui.getHeight() + var);
        lbl_primerApellido.setSize(lbl_nui.getWidth(), lbl_nui.getHeight());
        panel_informacion.add(lbl_primerApellido);

        txt_primerApellido = new CajaDeTexto(CajaDeTexto.textoSoloLetras);
        txt_primerApellido.setLocation(lbl_primerApellido.getX() + lbl_primerApellido.getWidth() + var, lbl_primerApellido.getY());
        txt_primerApellido.setSize(txt_nui.getWidth() * 2, txt_nui.getHeight());
        panel_informacion.add(txt_primerApellido);

        lbl_segundoApellido = new CampoLabel("Segundo Apellido:", CampoLabel.labelEstatico);
        lbl_segundoApellido.setLocation(lbl_primerApellido.getX(), lbl_primerApellido.getY() + lbl_primerApellido.getHeight() + var);
        lbl_segundoApellido.setSize(lbl_primerApellido.getWidth(), lbl_primerApellido.getHeight());
        panel_informacion.add(lbl_segundoApellido);

        txt_segundoApellido = new CajaDeTexto(CajaDeTexto.textoSoloLetras);
        txt_segundoApellido.setLocation(lbl_segundoApellido.getX() + lbl_segundoApellido.getWidth() + var, lbl_segundoApellido.getY());
        txt_segundoApellido.setSize(txt_primerApellido.getWidth(), txt_primerApellido.getHeight());
        panel_informacion.add(txt_segundoApellido);

        lbl_primerNombre = new CampoLabel("Primer Nombre:", CampoLabel.labelEstatico);
        lbl_primerNombre.setLocation(lbl_segundoApellido.getX(), lbl_segundoApellido.getY() + lbl_segundoApellido.getHeight() + var);
        lbl_primerNombre.setSize(lbl_segundoApellido.getWidth(), lbl_segundoApellido.getHeight());
        panel_informacion.add(lbl_primerNombre);

        txt_primerNombre = new CajaDeTexto(CajaDeTexto.textoSoloLetras);
        txt_primerNombre.setLocation(lbl_primerNombre.getX() + lbl_primerNombre.getWidth() + var, lbl_primerNombre.getY());
        txt_primerNombre.setSize(txt_segundoApellido.getWidth(), txt_segundoApellido.getHeight());
        panel_informacion.add(txt_primerNombre);

        lbl_segundoNombre = new CampoLabel("Segundo Nombre:", CampoLabel.labelEstatico);
        lbl_segundoNombre.setLocation(lbl_primerNombre.getX(), lbl_primerNombre.getY() + lbl_primerNombre.getHeight() + var);
        lbl_segundoNombre.setSize(lbl_primerNombre.getWidth(), lbl_primerNombre.getHeight());
        panel_informacion.add(lbl_segundoNombre);

        txt_segundoNombre = new CajaDeTexto(CajaDeTexto.textoSoloLetras);
        txt_segundoNombre.setLocation(lbl_segundoNombre.getX() + lbl_segundoNombre.getWidth() + var, lbl_segundoNombre.getY());
        txt_segundoNombre.setSize(txt_primerNombre.getWidth(), txt_primerNombre.getHeight());
        panel_informacion.add(txt_segundoNombre);

        lbl_nacionalidad = new CampoLabel("Nacionalidad:", CampoLabel.labelEstatico);
        lbl_nacionalidad.setLocation(txt_nui.getX() + txt_segundoNombre.getWidth() + var * 3, txt_nui.getY());
        lbl_nacionalidad.setSize(lbl_nui.getWidth(), lbl_nui.getHeight());
        panel_informacion.add(lbl_nacionalidad);

        txt_nacionalidad = new CajaDeTexto(CajaDeTexto.textoSoloLetras);
        txt_nacionalidad.setLocation(lbl_nacionalidad.getX() + lbl_nacionalidad.getWidth() + var, lbl_nacionalidad.getY());
        txt_nacionalidad.setSize(txt_nui.getWidth(), txt_nui.getHeight());
        panel_informacion.add(txt_nacionalidad);

        lbl_situacionJuridica = new CampoLabel("Situación Jurídica:", CampoLabel.labelEstatico);
        lbl_situacionJuridica.setLocation(lbl_nacionalidad.getX(), lbl_nacionalidad.getY() + lbl_nacionalidad.getHeight() + var);
        lbl_situacionJuridica.setSize(lbl_nacionalidad.getWidth(), lbl_nacionalidad.getHeight());
        panel_informacion.add(lbl_situacionJuridica);

        txt_situacionJuridica = new CajaDeTexto(CajaDeTexto.textoSoloLetras);
        txt_situacionJuridica.setLocation(lbl_situacionJuridica.getX() + lbl_situacionJuridica.getWidth() + var, lbl_situacionJuridica.getY());
        txt_situacionJuridica.setSize(txt_nacionalidad.getWidth() * 3 / 2, txt_nacionalidad.getHeight());
        panel_informacion.add(txt_situacionJuridica);

        lbl_fechaIngreso = new CampoLabel("Fecha de Ingreso:", CampoLabel.labelEstatico);
        lbl_fechaIngreso.setLocation(lbl_situacionJuridica.getX(), lbl_situacionJuridica.getY() + lbl_situacionJuridica.getHeight() + var);
        lbl_fechaIngreso.setSize(lbl_situacionJuridica.getWidth(), lbl_situacionJuridica.getHeight());
        panel_informacion.add(lbl_fechaIngreso);

        txt_fechaIngreso = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fechaIngreso.setLocation(lbl_fechaIngreso.getX() + lbl_fechaIngreso.getWidth() + var, lbl_fechaIngreso.getY());
        txt_fechaIngreso.setSize(txt_nui.getWidth(), txt_nui.getHeight());
        panel_informacion.add(txt_fechaIngreso);

        lbl_fechaSalida = new CampoLabel("Fecha de Salida:", CampoLabel.labelEstatico);
        lbl_fechaSalida.setLocation(lbl_fechaIngreso.getX(), lbl_fechaIngreso.getY() + lbl_fechaIngreso.getHeight() + var);
        lbl_fechaSalida.setSize(lbl_fechaIngreso.getWidth(), lbl_fechaIngreso.getHeight());
        panel_informacion.add(lbl_fechaSalida);

        txt_fechaSalida = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fechaSalida.setLocation(lbl_fechaSalida.getX() + lbl_fechaSalida.getWidth() + var, lbl_fechaSalida.getY());
        txt_fechaSalida.setSize(txt_fechaIngreso.getWidth(), txt_fechaIngreso.getHeight());
        panel_informacion.add(txt_fechaSalida);

        lbl_estado = new CampoLabel("Estado:", CampoLabel.labelEstatico);
        lbl_estado.setLocation(lbl_fechaSalida.getX(), txt_segundoNombre.getY());
        lbl_estado.setSize(lbl_nui.getWidth(), lbl_nui.getHeight());
        panel_informacion.add(lbl_estado);

        combo_estado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_estado.setLocation(lbl_estado.getX() + lbl_estado.getWidth() + var, lbl_estado.getY());
        combo_estado.setSize(lbl_estado.getWidth() * 8 / 9, lbl_estado.getHeight());
        panel_informacion.add(combo_estado);

        lbl_delito = new CampoLabel("Delito:", CampoLabel.labelEstatico);
        lbl_delito.setLocation(txt_nacionalidad.getX() + txt_situacionJuridica.getWidth() + var * 3, txt_td.getY());
        lbl_delito.setSize(lbl_nui.getWidth(), lbl_nui.getHeight());
        panel_informacion.add(lbl_delito);

        txt_delito = new CajaTextoArea(CajaDeTexto.textoLetrasNumeros);
        txt_delito.setLocation(lbl_delito.getX(), lbl_delito.getY() + lbl_delito.getHeight() + var);
        txt_delito.setSize(txt_primerNombre.getWidth(), (txt_primerNombre.getHeight() + var2) * 3 / 2);

        scroll_delito = new JScrollPane(txt_delito);
        scroll_delito.setLocation(txt_delito.getX(), txt_delito.getY());
        scroll_delito.setSize(txt_delito.getWidth(), txt_delito.getHeight());
        scroll_delito.setOpaque(false);
        scroll_delito.getViewport().setOpaque(false);
        panel_informacion.add(scroll_delito);

        lbl_observaciones = new CampoLabel("Observaciones:", CampoLabel.labelEstatico);
        lbl_observaciones.setLocation(lbl_delito.getX(), txt_fechaIngreso.getY());
        lbl_observaciones.setSize(lbl_delito.getWidth(), lbl_delito.getHeight());
        panel_informacion.add(lbl_observaciones);

        txt_observaciones = new CajaTextoArea(CajaDeTexto.textoLetrasNumeros);
        txt_observaciones.setLocation(lbl_observaciones.getX(), lbl_observaciones.getY() + lbl_observaciones.getHeight() + var);
        txt_observaciones.setSize(txt_delito.getWidth(), (txt_primerNombre.getHeight() + var2) * 2);

        scroll_observaciones = new JScrollPane(txt_observaciones);
        scroll_observaciones.setLocation(txt_observaciones.getX(), txt_observaciones.getY());
        scroll_observaciones.setSize(txt_observaciones.getWidth(), txt_observaciones.getHeight());
        scroll_observaciones.setOpaque(false);
        scroll_observaciones.getViewport().setOpaque(false);
        panel_informacion.add(scroll_observaciones);

        int anchoBoton = this.getWidth() / 35;
        int altoBoton = this.getHeight() / 30;

        lbl_foto = new CampoLabel("Foto:", CampoLabel.labelEstatico);
        lbl_foto.setLocation(txt_delito.getX() + txt_delito.getWidth() + var * 5, txt_delito.getY());
        lbl_foto.setSize(lbl_delito.getWidth() / 2, lbl_delito.getHeight());
        panel_informacion.add(lbl_foto);

        txt_foto = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_foto.setLocation(lbl_foto.getX() + lbl_foto.getWidth() + var, lbl_foto.getY());
        txt_foto.setSize(txt_nui.getWidth() * 3 / 2, txt_nui.getHeight());
        txt_foto.setEnabled(false);
        panel_informacion.add(txt_foto);

        btn_foto = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "...");
        btn_foto.setLocation(txt_foto.getX() + txt_foto.getWidth(), txt_foto.getY());
        btn_foto.cambiarTamanoLabelBoton(anchoBoton, altoBoton);
        btn_foto.setToolTipText("Seleccionar Foto");
        btn_foto.setOpaque(false);
        btn_foto.setContentAreaFilled(false);
        btn_foto.setBorderPainted(false);
        panel_informacion.add(btn_foto);

        int anchoImg = this.getWidth() / 8;
        int altoImg = this.getHeight() / 5;

        lbl_imagenFoto = new JLabel();
        lbl_imagenFoto.setLocation(txt_foto.getX() + anchoImg / 7, lbl_foto.getY() + (lbl_foto.getHeight() + var) * 7 / 2);
        lbl_imagenFoto.setSize(anchoImg / 2, altoImg * 2 / 3);
        lbl_imagenFoto.setBorder(new PanelBorde(""));
        this.add(lbl_imagenFoto);
    }

    @Override
    protected void prepareElementosTablaGeneral() {// panel de tabla general
        int margenSuperior = CargaImagenes.ALTO_PANTALLA / 4 + CargaImagenes.ALTO_PANTALLA / 6;
        int anchoPanel = 20 * CargaImagenes.ANCHO_PANTALLA / 21;
        int altoPanel = CargaImagenes.ALTO_PANTALLA / 2;
        int margenIzquierda = (CargaImagenes.ANCHO_PANTALLA - anchoPanel) / 2;

        panel_tablaGeneral = new JPanel();
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBounds(margenIzquierda, margenSuperior, anchoPanel, altoPanel);

        dtmTablaGeneral = new TablaNoEditable();
        tablaGeneral = new JTable(dtmTablaGeneral);
        scrollPaneTablaGeneral = new JScrollPane(tablaGeneral);

        scrollPaneTablaGeneral.setBounds(0, 0, anchoPanel - 25, altoPanel - 50);
        tablaGeneral.setPreferredScrollableViewportSize(new Dimension(scrollPaneTablaGeneral.getWidth(), scrollPaneTablaGeneral.getHeight()));

        tablaGeneral.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaGeneral.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
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

        panel_tablaGeneral.add(scrollPaneTablaGeneral);
        this.add(panel_tablaGeneral);

        dtmTablaGeneral.addColumn("TD");
        dtmTablaGeneral.addColumn("NUI");
        dtmTablaGeneral.addColumn("Primer Apellido");
        dtmTablaGeneral.addColumn("Segundo Apellido");
        dtmTablaGeneral.addColumn("Primer Nombre");
        dtmTablaGeneral.addColumn("Segundo Nombre");
        dtmTablaGeneral.addColumn("Nacionalidad");
        dtmTablaGeneral.addColumn("Situación Jurídica");
        dtmTablaGeneral.addColumn("Fecha de Ingreso");
        dtmTablaGeneral.addColumn("Fecha de Salida");
        dtmTablaGeneral.addColumn("Delito");
        dtmTablaGeneral.addColumn("Observaciones");
        dtmTablaGeneral.addColumn("Ruta Foto");
        dtmTablaGeneral.addColumn("Estado");
        dtmTablaGeneral.addColumn("ID");

        int anchoTotal = anchoPanel / 6;

        for (int i = 0; i < tablaGeneral.getColumnCount(); i++) {
            tablaGeneral.getColumnModel().getColumn(i).setMaxWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setMinWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setPreferredWidth(0);
        }

        tablaGeneral.getColumnModel().getColumn(columnaTd).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaTd).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaTd).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaNui).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaNui).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaNui).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaPrimerApellido).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaPrimerApellido).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaPrimerApellido).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaSegundoApellido).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaSegundoApellido).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaSegundoApellido).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaPrimerNombre).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaPrimerNombre).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaPrimerNombre).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaSegundoNombre).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaSegundoNombre).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaSegundoNombre).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaNacionalidad).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaNacionalidad).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaNacionalidad).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaSituacionJuridica).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaSituacionJuridica).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaSituacionJuridica).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaFechaIngreso).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaFechaIngreso).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaFechaIngreso).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaFechaSalida).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaFechaSalida).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaFechaSalida).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaDelito).setMaxWidth(anchoTotal * 3 / 2);
        tablaGeneral.getColumnModel().getColumn(columnaDelito).setMinWidth(anchoTotal * 3 / 2);
        tablaGeneral.getColumnModel().getColumn(columnaDelito).setPreferredWidth(anchoTotal * 3 / 2);

        tablaGeneral.getColumnModel().getColumn(columnaObservaciones).setMaxWidth(anchoTotal * 2);
        tablaGeneral.getColumnModel().getColumn(columnaObservaciones).setMinWidth(anchoTotal * 2);
        tablaGeneral.getColumnModel().getColumn(columnaObservaciones).setPreferredWidth(anchoTotal * 2);

        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setPreferredWidth(anchoTotal / 2);
    }

    private void cargarDatosGeneral() {
        deshacerFiltroTablaGeneral();
        Tabla.eliminarFilasTabla(dtmTablaGeneral);

        PersistenciaInternoInt persistencia = Servicios.internosController.internosRepository;

        ArrayList<Interno> internos = persistencia.getNoEliminados();

        for (Interno interno : internos) {
            String[] datosFila = new String[dtmTablaGeneral.getColumnCount()];

            datosFila[columnaId] = String.valueOf(interno.getId());

            datosFila[columnaTd] = interno.getTd();
            datosFila[columnaNui] = interno.getNui();
            datosFila[columnaPrimerApellido] = interno.getPrimerApellido();
            datosFila[columnaSegundoApellido] = interno.getSegundoApellido();
            datosFila[columnaPrimerNombre] = interno.getPrimerNombre();
            datosFila[columnaSegundoNombre] = interno.getSegundoNombre();
            datosFila[columnaNacionalidad] = interno.getNacionalidad();
            datosFila[columnaSituacionJuridica] = interno.getSituacionJuridica();
            datosFila[columnaFechaIngreso] = interno.getFechaIngreso() != null ? Fecha.obtenerFechaString(interno.getFechaIngreso()) : "";
            datosFila[columnaFechaSalida] = interno.getFechaSalida() != null ? Fecha.obtenerFechaString(interno.getFechaSalida()) : "";
            datosFila[columnaDelito] = interno.getDelito();
            datosFila[columnaObservaciones] = interno.getObservaciones();
            datosFila[columnaRutaImagen] = interno.getRutaImagen();

            boolean estado = interno.getEstado();
            String est;
            if (estado) {
                est = DatosBaseDatos.estadoActivo;
            } else {
                est = DatosBaseDatos.estadoInactivo;
            }
            datosFila[columnaEstado] = est;

            dtmTablaGeneral.addRow(datosFila);
        }
//        try {
//        } catch (ExpendioException ex) {
//            ex.printStackTrace();
//            option.tipoMensaje(GUIJOption.mensajeError, ExpendioException.getStackTrace(ex), "Error (13)", ExpendioException.getMensajeErrorBaseDatos());
//        }
    }

    private void deshacerFiltroTablaGeneral() {
        Filtro.deshacerFiltro(trsFiltroGeneral, dtmTablaGeneral, tablaGeneral);
    }

    @Override
    protected void definaAccionesInformacion() {// Definiendo acciones
        ValidacionCampos.asignarTeclasDireccion(txt_nui, null, txt_primerApellido, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_primerApellido, txt_nui, txt_segundoApellido, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_segundoApellido, txt_primerApellido, txt_primerNombre, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_primerNombre, txt_segundoApellido, txt_segundoNombre, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_segundoNombre, txt_primerNombre, txt_nacionalidad, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_nacionalidad, txt_segundoNombre, txt_situacionJuridica, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_situacionJuridica, txt_nacionalidad, txt_fechaIngreso, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_fechaIngreso, txt_situacionJuridica, txt_fechaSalida, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_fechaSalida, txt_fechaIngreso, combo_estado, null, null);
        ValidacionCampos.asignarTeclasDireccion(combo_estado, txt_fechaSalida, txt_delito, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_delito, combo_estado, txt_observaciones, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_observaciones, txt_delito, btn_foto, null, null);

        btn_foto.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    accionBotonFoto();
                } else {
                    ValidacionCampos.teclasDireccion(e, txt_observaciones, btn_agregar, null, null, btn_foto);
                }
            }
        });
        btn_foto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonFoto();
            }
        });
    }

    private void accionBotonFoto() {
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter Filtro = new FileNameExtensionFilter("Archivos de imagen (jpg, jpeg, png)", "jpg", "jpeg", "png");
        fc.setFileFilter(Filtro);

        int seleccion = fc.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            txt_foto.setText(fichero.getAbsolutePath().replace("\\", "/"));
            boolean valido = validarLongitudLogo();
            if (valido) {
                boolean selecciono = seleccionarImagen(txt_foto.getText().trim());
                if (!selecciono) {
                    txt_foto.setText("");
                    btn_foto.grabFocus();
                } else {
                    btn_agregar.grabFocus();
                }
            } else {
                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "¡Error! La ubicación de la foto es demasiado larga.", "(Longitud máxima: " + longitudMaximaFoto + ")");
                txt_foto.setText("");
                btn_foto.grabFocus();
            }
        }
    }

    private boolean validarLongitudLogo() {
        if (txt_foto.getText().trim().length() > longitudMaximaFoto) {
            return false;
        } else {
            return true;
        }
    }

    private boolean seleccionarImagen(String ruta) {
        boolean selecciono = Imagenes.setFondoLabel(ruta, lbl_imagenFoto.getWidth(), lbl_imagenFoto.getHeight(), lbl_imagenFoto);
        if (!selecciono) {
            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "¡Error! La imagen no se ha podido asignar.", "Por favor inténtelo de nuevo.");
        }
        return selecciono;
    }

    @Override
    protected void accionBotonAgregar() {// Insertando nuevo interno
        try {
            Interno interno = setValoresInterno();

            boolean valido = puedeInsertarOModificar(false, interno);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = interno.insertar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha insertado satisfactoriamente el interno.";
                    titulo = "Insertado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido insertar el interno. Por favor inténtelo de nuevo.";
                    titulo = "Error (123)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(interno.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, ExpendioException.getStackTrace(ex), "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    @Override
    protected void accionBotonAgregarModificar() {// Editando interno seleccionado de la tabla
        try {
            Interno interno = setValoresInterno();

            boolean valido = puedeInsertarOModificar(true, interno);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = interno.modificar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha modificado satisfactoriamente el cargo.";
                    titulo = "Modificado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido modificar el cargo. Por favor inténtelo de nuevo.";
                    titulo = "Error (124)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(interno.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, "", "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    private Interno setValoresInterno() {
        Interno interno = new Interno();

        interno.setId(idInterno);

        interno.setTd(txt_td.getText().trim());
        interno.setNui(txt_nui.getText().trim());
        interno.setPrimerApellido(txt_primerApellido.getText().trim());
        interno.setSegundoApellido(txt_segundoApellido.getText().trim());
        interno.setPrimerNombre(txt_primerNombre.getText().trim());
        interno.setSegundoNombre(txt_segundoNombre.getText().trim());
        interno.setNacionalidad(txt_nacionalidad.getText().trim());
        interno.setSituacionJuridica(txt_situacionJuridica.getText().trim());

        String fechaIngreso = txt_fechaIngreso.getText().trim();
        String fechaSalida = txt_fechaSalida.getText().trim();

        Date fechaI = null;
        if (!fechaIngreso.replace("/", "").trim().isEmpty()) {
            fechaI = Fecha.getDate(fechaIngreso);
        }
        interno.setFechaIngreso(fechaI);

        Date fechaF = null;
        if (!fechaSalida.replace("/", "").trim().isEmpty()) {
            fechaF = Fecha.getDate(fechaSalida);
        }
        interno.setFechaSalida(fechaF);

        interno.setDelito(txt_delito.getText().trim());
        interno.setObservaciones(txt_observaciones.getText().trim());
        interno.setRutaImagen(txt_foto.getText().trim());

        Boolean est = null;
        String estado = CampoCombo.getComboValue(combo_estado);
        if (estado != null && !estado.trim().isEmpty()) {
            switch (estado) {
                case DatosBaseDatos.estadoActivo:
                    est = true;
                    break;
                case DatosBaseDatos.estadoInactivo:
                default:
                    est = false;
                    break;
            }
        }
        interno.setEstado(est);

        return interno;
    }

    private boolean puedeInsertarOModificar(boolean esModificar, Interno interno) throws ExpendioException {
        String campos = interno.validarCamposObligatorios(esModificar);

        boolean correcto = true;

        if (campos != null) {
            correcto = correcto && validarCampo(campos, "ID", "Por favor seleccione un interno.", txt_td);
            correcto = correcto && validarCampo(campos, "TD", "Por favor ingrese el TD.", txt_td);
            correcto = correcto && validarCampo(campos, "NUI", "Por favor ingrese el NUI.", txt_nui);
            correcto = correcto && validarCampo(campos, "PRIMERAPELLIDO", "Por favor ingrese el primer apellido.", txt_primerApellido);
            correcto = correcto && validarCampo(campos, "SEGUNDOAPELLIDO", "Por favor ingrese el segundo apellido.", txt_segundoApellido);
            correcto = correcto && validarCampo(campos, "PRIMERNOMBRE", "Por favor ingrese el primer nombre.", txt_primerNombre);
//            correcto = correcto && validarCampo(campos, "SEGUNDONOMBRE", "Por favor ingrese el segundo nombre.", txt_segundoNombre);
            correcto = correcto && validarCampo(campos, "NACIONALIDAD", "Por favor ingrese la nacionalidad.", txt_nacionalidad);
            correcto = correcto && validarCampo(campos, "SITUACIONJURIDICA", "Por favor ingrese la situación jurídica.", txt_situacionJuridica);
            correcto = correcto && validarCampo(campos, "FECHAINGRESO", "Por favor ingrese la fecha de ingreso.", txt_fechaIngreso);
//            correcto = correcto && validarCampo(campos, "FECHASALIDA", "Por favor ingrese la fecha de salida.", txt_fechaSalida);
//            correcto = correcto && validarCampo(campos, "DELITO", "Por favor ingrese el delito.", txt_delito);
//            correcto = correcto && validarCampo(campos, "OBSERVACIONES", "Por favor ingrese las observaciones.", txt_observaciones);
            correcto = correcto && validarCampo(campos, "RUTAFOTO", "Por favor ingrese la foto.", txt_foto);
            correcto = correcto && validarCampo(campos, "ESTADO", "Por favor ingrese el estado.", combo_estado);
        }

        correcto = correcto && validarExiste(esModificar, interno);

        return correcto;
    }

    private boolean validarExiste(boolean esModificar, Interno interno) throws ExpendioException {
        boolean valido = !interno.validarExiste(esModificar);
        if (!valido) {
            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "", "Ya existe un TD o NUI asociado a este interno.");
            txt_nui.grabFocus();
        }
        return valido;
    }

    private boolean validarCampo(String resultado, String campo, String mensaje, JComponent elemento) {
        if (resultado.equals(campo)) {
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "", mensaje);
            elemento.grabFocus();
            return false;
        }
        return true;
    }

    @Override
    protected void activarModificar() {// Boton Modificar
        int selected = tablaGeneral.getSelectedRow();
        if (selected != -1) {
            estaEditando = true;
            btn_borrar.setEnabled(false);
            btn_buscar.setEnabled(false);
            btn_salir.setEnabled(false);

            btn_agregar.setText("Guardar");
            btn_modificar.setText("Cancelar");

            int model = tablaGeneral.convertRowIndexToModel(selected);

            idInterno = Long.parseLong((String) dtmTablaGeneral.getValueAt(model, columnaId));

            txt_td.setText((String) dtmTablaGeneral.getValueAt(model, columnaTd));
//            txt_td.setEnabled(false);

            txt_nui.setText((String) dtmTablaGeneral.getValueAt(model, columnaNui));
            txt_primerApellido.setText((String) dtmTablaGeneral.getValueAt(model, columnaPrimerApellido));

            txt_segundoApellido.setText((String) dtmTablaGeneral.getValueAt(model, columnaSegundoApellido));
            txt_primerNombre.setText((String) dtmTablaGeneral.getValueAt(model, columnaPrimerNombre));
            txt_segundoNombre.setText((String) dtmTablaGeneral.getValueAt(model, columnaSegundoNombre));

            txt_nacionalidad.setText((String) dtmTablaGeneral.getValueAt(model, columnaNacionalidad));
            txt_situacionJuridica.setText((String) dtmTablaGeneral.getValueAt(model, columnaSituacionJuridica));

            txt_fechaIngreso.setText((String) dtmTablaGeneral.getValueAt(model, columnaFechaIngreso));
            txt_fechaSalida.setText((String) dtmTablaGeneral.getValueAt(model, columnaFechaSalida));
            txt_delito.setText((String) dtmTablaGeneral.getValueAt(model, columnaDelito));
            txt_observaciones.setText((String) dtmTablaGeneral.getValueAt(model, columnaObservaciones));

            CampoCombo.setValueCombo(combo_estado, (String) dtmTablaGeneral.getValueAt(model, columnaEstado));

            String rutaImagen = (String) dtmTablaGeneral.getValueAt(model, columnaRutaImagen);
            boolean valido = validarLongitudLogo();
            if (valido) {
                boolean selecciono = seleccionarImagen(rutaImagen);
                if (!selecciono) {
                    txt_foto.setText("");
                } else {
                    txt_foto.setText(rutaImagen);
                }
            }

            tablaGeneral.setEnabled(false);
            btn_agregar.setEnabled(true);
        }
    }

    @Override
    protected void desactivarModificar() {
        estaEditando = false;

        btn_borrar.setEnabled(true);
        btn_buscar.setEnabled(true);
        btn_salir.setEnabled(true);

        btn_agregar.setText("Agregar");
        btn_modificar.setText("Modificar");

        inicializarInformacion();

        tablaGeneral.setEnabled(true);
        asignarPermisos();
    }

    @Override
    protected void accionBotonModificar() {
        if (!tablaGeneral.isRowSelected(tablaGeneral.getSelectedRow())) {
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "No ha seleccionado ningún interno para modificar.");
        } else {
            desactivarBusqueda();
            activarModificar();
        }
    }

    @Override
    protected void accionBotonCancelarModificacion() {
        iniciarBusqueda();
        ocultarTxtBuscar();
        desactivarModificar();

        inicializarInformacion();
        deshacerFiltroTablaGeneral();
        cargarDatosGeneral();

        asignarFoco();
    }

    @Override
    protected void activarBusqueda() {// Boton Buscar
        estaBuscando = true;

        btn_buscar.setText("Cancelar");

        mostrarTxtBuscar();
        iniciarBusqueda();
        txt_buscar.grabFocus();
        ocultarObjetosInformacion();
    }

    @Override
    protected void desactivarBusqueda() {
        estaBuscando = false;

        btn_buscar.setText("Buscar");

        ocultarTxtBuscar();
        mostrarObjetosInformacion();
        asignarPermisos();
    }

    private void ocultarObjetosInformacion() {
        panel_informacion.setVisible(false);

        btn_agregar.setEnabled(false);
        btn_modificar.setEnabled(true);
        btn_borrar.setEnabled(true);
    }

    private void mostrarObjetosInformacion() {
        panel_informacion.setVisible(true);

        btn_agregar.setEnabled(true);
        btn_modificar.setEnabled(true);
        btn_borrar.setEnabled(true);
    }

    @Override
    protected void accionBotonBusqueda() {
        txt_buscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                    case KeyEvent.VK_DOWN:
                        if (tablaGeneral.getRowCount() >= 1) {
                            tablaGeneral.grabFocus();
                            tablaGeneral.getSelectionModel().setSelectionInterval(0, 0);
                        }
                        break;
                    default:
                        filtrarBusqueda();
                        break;
                }
            }
        });

        activarBusqueda();
    }

    @Override
    protected void accionBotonCancelarBusqueda() {
        deshacerFiltroTablaGeneral();
        desactivarBusqueda();
    }

    private void iniciarBusqueda() {
        inicializarTxtBuscar();
        filtrarBusqueda();
    }

    private void filtrarBusqueda() {
        Filtro.filtroSeisColumnasQueContenga(txt_buscar.getText().trim(), trsFiltroGeneral, columnaTd, columnaNui, columnaPrimerApellido, columnaSegundoApellido, columnaPrimerNombre, columnaSegundoNombre, dtmTablaGeneral, tablaGeneral);
    }

    @Override
    protected void accionBotonBorrar() {// Boton Borrar
        int selected = tablaGeneral.getSelectedRow();
        if (selected == -1) {
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "Por favor seleccione el interno que desea eliminar.");
        } else {
            int fila = tablaGeneral.convertRowIndexToModel(selected);

            long id = Long.parseLong((String) dtmTablaGeneral.getValueAt(fila, columnaId));

            int respuesta = option.tipoMensaje(GUIJOption.mensajePregunta, "", "", "¿Está seguro que desea eliminar el interno seleccionado?");
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    deshacerFiltroTablaGeneral();

                    Interno interno = new Interno();
                    interno.setId(id);

                    boolean accion = interno.borrar(usuario);
                    cargarDatosGeneral();

                    String mensaje = null, titulo = null, tipo = null;
                    if (accion) {
                        mensaje = "Se ha eliminado satisfactoriamente el interno.";
                        titulo = "Eliminado";
                        tipo = GUIJOption.mensajeInformacion;
                    } else {
                        mensaje = "Ha ocurrido un error y no se ha podido eliminar el interno. Por favor inténtelo de nuevo.";
                        titulo = "Error (126)";
                        tipo = GUIJOption.mensajeAdvertencia;
                    }
                    option.tipoMensaje(tipo, "", titulo, mensaje);

                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();
                    desactivarBusqueda();

                    inicializarInformacion();
                } catch (Exception ex) {
                    option.tipoMensaje(GUIJOption.mensajeError, "", "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void accionBotonAdicional() {
    }

    @Override
    protected void accionBotonReporte() {// Boton Reporte
        setCursor(cursorEspera);

//        CatalogosReportsBuilder reporte = new CatalogosReportsBuilder(usuario);
//        reporte.catalogoCargosFiller(dtmTablaGeneral, frame);
        setCursor(null);
    }

    @Override
    protected void inicializarInformacion() {
        idInterno = null;

        txt_td.setText("");
        txt_nui.setText("");
        txt_primerApellido.setText("");
        txt_segundoApellido.setText("");
        txt_primerNombre.setText("");
        txt_segundoNombre.setText("");
        txt_nacionalidad.setText("");
        txt_situacionJuridica.setText("");
        txt_fechaIngreso.setText("");
        txt_fechaSalida.setText("");
        txt_delito.setText("");
        txt_observaciones.setText("");

        txt_foto.setText("");
        lbl_imagenFoto.setIcon(null);

        combo_estado.setSelectedIndex(0);// Estado activo por defecto

//        asignarNumeroConsecutivoGeneral();
    }

    private final void asignarNumeroConsecutivoGeneral() {
        String ultimoNumero = Interno.traerUltimoNumeroTdInterno(usuario);
        if (ultimoNumero.equals("ERROR")) {
            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "141", "No se ha podido traer el último número de la base de datos.", "Inténtelo de nuevo.");
        } else {
            ultimoNumero = NumeroConsecutivo.numeroConsecutivoPrefijo(String.valueOf(Configuracion.codigoEstablecimiento - 1).length(), ultimoNumero, usuario);
            if (ultimoNumero.equalsIgnoreCase("")) {
                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "142", "No se ha podido convertir la numeración.", "Inténtelo de nuevo.");
            } else if (ultimoNumero.equalsIgnoreCase("NOHAYCUPO")) {
                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "143", "No hay cupo en la numeración actual.", "Inténtelo de nuevo.");
            } else {
                txt_td.setText(ultimoNumero);
                if (ultimoNumero.endsWith("000001")) {
                    txt_td.setEnabled(true);
                } else {
                    txt_td.setEnabled(false);
                }
            }
        }
    }

    @Override
    public void actualizarFrame() {
        iniciarBusqueda();
        ocultarTxtBuscar();
        desactivarModificar();

        inicializarInformacion();
        cargarDatosGeneral();
        deshacerFiltroTablaGeneral();

        if (tablaGeneral.getRowCount() >= 1) {
            tablaGeneral.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_td.grabFocus();
    }

    @Override
    public void asignarPermisos() {
//        Permisos.asignarPermisosAdicionarModificarBorrar(btn_agregar, btn_modificar, btn_borrar, estaEditando, Permisos.catalogosCargos, usuario);
    }

}
