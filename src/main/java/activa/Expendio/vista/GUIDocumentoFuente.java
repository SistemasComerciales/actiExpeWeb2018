package activa.Expendio.vista;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import javax.swing.*;

import utils.*;
import activa.Expendio.controllers.*;
import activa.Expendio.persistencia.Interface.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author diego
 */
public class GUIDocumentoFuente extends GUIInterfazCatalogos {

    // Panel de informacion
    private JPanel panel_informacion;
    private CampoLabel lbl_codigo, lbl_nombre, lbl_accion, lbl_aplica;
    private CampoLabel lbl_numero, lbl_bodega, lbl_estado;
    private Long idDocFuente, idBodega;
    private CajaDeTexto txt_codigo, txt_nombre, txt_numero, txt_bodega;
    private CasillaVerificacion chk_numera, chk_controlExistencia, chk_docBase, chk_precioFijo, chk_listaPrecio, chk_costeoInv;
    private CampoCombo<String> combo_accionInv, combo_aplica, combo_estado;

    // Utilitarios
    private static String nombreClase = "Documentos Fuente";
    public static final int limiteCaracteresCampoCodigo = 15;
    public static final int limiteCaracteresCampoSoloLetras = 100;

    // Indices de la tabla general
    public static final int columnaCodigo = 0;
    public static final int columnaNombre = columnaCodigo + 1;
    public static final int columnaAccionInv = columnaNombre + 1;
    public static final int columnaAplica = columnaAccionInv + 1;
    public static final int columnaNumera = columnaAplica + 1;
    public static final int columnaNumero = columnaNumera + 1;
    public static final int columnaControlExitencia = columnaNumero + 1;
    public static final int columnaDocBase = columnaControlExitencia + 1;
    public static final int columnaPrecioFijo = columnaDocBase + 1;
    public static final int columnaListaPrecio = columnaPrecioFijo + 1;
    public static final int columnaCosteoInv = columnaListaPrecio + 1;
    public static final int columnaBodega = columnaCosteoInv + 1;
    public static final int columnaIdBodega = columnaBodega + 1;
    public static final int columnaEstado = columnaIdBodega + 1;
    public static final int columnaId = columnaEstado + 1;

    /**
     * constructor
     *
     * @param usuario
     */
    public GUIDocumentoFuente(Usuario usuario) {
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

        int posicionX = panel_informacion.getWidth() / 9;
        int posicionY = panel_informacion.getHeight() / 10;
        int var = 5;
        int labelWidth = CargaImagenes.ANCHO_PANTALLA / 18, labelHeight = CargaImagenes.ALTO_PANTALLA / 30;
        int txtWidth = CargaImagenes.ANCHO_PANTALLA / 12;

        lbl_codigo = new CampoLabel("Código:", CampoLabel.labelEstatico);
        lbl_codigo.setLocation(posicionX, posicionY);
        lbl_codigo.setSize(labelWidth * 2, labelHeight);
        panel_informacion.add(lbl_codigo);

        txt_codigo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoCodigo);
        txt_codigo.setLocation(lbl_codigo.getX() + lbl_codigo.getWidth() + var * 2, lbl_codigo.getY());
        txt_codigo.setSize(txtWidth, lbl_codigo.getHeight());
        panel_informacion.add(txt_codigo);

        lbl_nombre = new CampoLabel("Nombre:", CampoLabel.labelEstatico);
        lbl_nombre.setLocation(lbl_codigo.getX(), lbl_codigo.getY() + lbl_codigo.getHeight() + var * 2);
        lbl_nombre.setSize(lbl_codigo.getWidth(), lbl_codigo.getHeight());
        panel_informacion.add(lbl_nombre);

        txt_nombre = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoCodigo);
        txt_nombre.setLocation(lbl_nombre.getX() + lbl_nombre.getWidth() + var * 2, lbl_nombre.getY());
        txt_nombre.setSize(txt_codigo.getWidth(), txt_codigo.getHeight());
        panel_informacion.add(txt_nombre);

        lbl_accion = new CampoLabel("Acción Inventario:", CampoLabel.labelEstatico);
        lbl_accion.setLocation(lbl_nombre.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + var * 2);
        lbl_accion.setSize(lbl_nombre.getWidth(), lbl_nombre.getHeight());
        panel_informacion.add(lbl_accion);

        combo_accionInv = new CampoCombo<String>(DatosBaseDatos.varEntrada, DatosBaseDatos.varSalida);
        combo_accionInv.setLocation(lbl_accion.getX() + lbl_accion.getWidth() + var * 2, lbl_accion.getY());
        combo_accionInv.setSize(txt_nombre.getWidth(), txt_nombre.getHeight());
        panel_informacion.add(combo_accionInv);

        lbl_aplica = new CampoLabel("Aplica a:", CampoLabel.labelEstatico);
        lbl_aplica.setLocation(lbl_accion.getX(), lbl_accion.getY() + lbl_accion.getHeight() + var * 2);
        lbl_aplica.setSize(lbl_accion.getWidth(), lbl_accion.getHeight());
        panel_informacion.add(lbl_aplica);

        combo_aplica = new CampoCombo<String>(DatosBaseDatos.varAplicaCliente, DatosBaseDatos.varAplicaProveedor);
        combo_aplica.setLocation(lbl_aplica.getX() + lbl_aplica.getWidth() + var * 2, lbl_aplica.getY());
        combo_aplica.setSize(combo_accionInv.getWidth(), combo_accionInv.getHeight());
        panel_informacion.add(combo_aplica);

        lbl_numero = new CampoLabel("Número:", CampoLabel.labelEstatico);
        lbl_numero.setLocation(txt_nombre.getX() + txt_nombre.getWidth() + var * 4, txt_nombre.getY());
        lbl_numero.setSize(txt_codigo.getWidth(), txt_codigo.getHeight());
        panel_informacion.add(lbl_numero);

        txt_numero = new CajaDeTexto(CajaDeTexto.textoNumeroEntero, limiteCaracteresCampoCodigo);
        txt_numero.setLocation(lbl_numero.getX() + lbl_numero.getWidth() + var * 2, lbl_numero.getY());
        txt_numero.setSize(txt_codigo.getWidth(), txt_codigo.getHeight());
        panel_informacion.add(txt_numero);

        chk_numera = new CasillaVerificacion("Numera");
        chk_numera.setLocation(txt_codigo.getX() + txt_codigo.getWidth() + var * 4, txt_codigo.getY());
        chk_numera.setSize(txt_numero.getWidth() * 2, txt_numero.getHeight());
        panel_informacion.add(chk_numera);

        chk_controlExistencia = new CasillaVerificacion("Control de Existencias");
        chk_controlExistencia.setLocation(chk_numera.getX(), combo_accionInv.getY());
        chk_controlExistencia.setSize(chk_numera.getWidth(), chk_numera.getHeight());
        panel_informacion.add(chk_controlExistencia);

        chk_docBase = new CasillaVerificacion("Documento Base");
        chk_docBase.setLocation(chk_controlExistencia.getX(), combo_aplica.getY());
        chk_docBase.setSize(chk_controlExistencia.getWidth(), chk_controlExistencia.getHeight());
        panel_informacion.add(chk_docBase);

        chk_precioFijo = new CasillaVerificacion("Precio Fijo");
        chk_precioFijo.setLocation(txt_numero.getX() + txt_numero.getWidth() + var * 4, chk_numera.getY());
        chk_precioFijo.setSize(chk_docBase.getWidth(), chk_docBase.getHeight());
        panel_informacion.add(chk_precioFijo);

        chk_listaPrecio = new CasillaVerificacion("Lista de precios");
        chk_listaPrecio.setLocation(chk_precioFijo.getX(), txt_numero.getY());
        chk_listaPrecio.setSize(chk_precioFijo.getWidth(), chk_precioFijo.getHeight());
        panel_informacion.add(chk_listaPrecio);

        chk_costeoInv = new CasillaVerificacion("Costeo de Inventario");
        chk_costeoInv.setLocation(chk_listaPrecio.getX(), chk_controlExistencia.getY());
        chk_costeoInv.setSize(chk_listaPrecio.getWidth(), chk_listaPrecio.getHeight());
        panel_informacion.add(chk_costeoInv);

        lbl_bodega = new CampoLabel("Bodega:", CampoLabel.labelEstatico);
        lbl_bodega.setLocation(chk_costeoInv.getX(), chk_docBase.getY());
        lbl_bodega.setSize(lbl_numero.getWidth(), lbl_numero.getHeight());
        panel_informacion.add(lbl_bodega);

        txt_bodega = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoCodigo);
        txt_bodega.setLocation(lbl_bodega.getX() + lbl_bodega.getWidth() + var * 2, lbl_bodega.getY());
        txt_bodega.setSize(lbl_bodega.getWidth(), lbl_bodega.getHeight());
        panel_informacion.add(txt_bodega);

        lbl_estado = new CampoLabel("Estado:", CampoLabel.labelEstatico);
        lbl_estado.setLocation(chk_docBase.getX(), chk_docBase.getY() + chk_docBase.getHeight() + var * 2);
        lbl_estado.setSize(lbl_bodega.getWidth(), lbl_bodega.getHeight());
        panel_informacion.add(lbl_estado);

        combo_estado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_estado.setLocation(lbl_estado.getX() + lbl_estado.getWidth() * 5 / 4, lbl_estado.getY());
        combo_estado.setSize(lbl_estado.getWidth() * 8 / 9, lbl_estado.getHeight());
        panel_informacion.add(combo_estado);
    }

    @Override
    protected void prepareElementosTablaGeneral() {// panel de tabla general
        int margenSuperior = CargaImagenes.ALTO_PANTALLA / 4 + CargaImagenes.ALTO_PANTALLA / 6;
        int anchoPanel = 2 * CargaImagenes.ANCHO_PANTALLA / 3;
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

        dtmTablaGeneral.addColumn("Código");
        dtmTablaGeneral.addColumn("Nombre");
        dtmTablaGeneral.addColumn("Accion Inv.");
        dtmTablaGeneral.addColumn("Aplica a");
        dtmTablaGeneral.addColumn("Numera");
        dtmTablaGeneral.addColumn("Número");
        dtmTablaGeneral.addColumn("C. existencia");
        dtmTablaGeneral.addColumn("Doc Base");
        dtmTablaGeneral.addColumn("Precio fijo");
        dtmTablaGeneral.addColumn("Lista precio");
        dtmTablaGeneral.addColumn("Costeo Inv.");
        dtmTablaGeneral.addColumn("Bodega");
        dtmTablaGeneral.addColumn("idBodega");
        dtmTablaGeneral.addColumn("Estado");
        dtmTablaGeneral.addColumn("Id");

        int anchoTotal = anchoPanel / 5;

        for (int i = 0; i < tablaGeneral.getColumnCount(); i++) {
            tablaGeneral.getColumnModel().getColumn(i).setMaxWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setMinWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setPreferredWidth(0);
        }

        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaNombre).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaNombre).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaNombre).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaAccionInv).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaAccionInv).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaAccionInv).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaAplica).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaAplica).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaAplica).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaNumera).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaNumera).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaNumera).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaNumero).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaNumero).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaNumero).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaControlExitencia).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaControlExitencia).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaControlExitencia).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaDocBase).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaDocBase).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaDocBase).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaPrecioFijo).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaPrecioFijo).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaPrecioFijo).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaListaPrecio).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaListaPrecio).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaListaPrecio).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaCosteoInv).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaCosteoInv).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaCosteoInv).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaBodega).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaBodega).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaBodega).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setPreferredWidth(anchoTotal / 3);
    }

    private void cargarDatosGeneral() {
        deshacerFiltroTablaGeneral();
        Tabla.eliminarFilasTabla(dtmTablaGeneral);

        PersistenciaDocFuenteInt persistencia = Servicios.documentosController.documentosRepository;

        ArrayList<DocumentoFuente> documentos = persistencia.consultarTodos();

        for (DocumentoFuente doc : documentos) {
            String[] datosFila = new String[dtmTablaGeneral.getColumnCount()];

            datosFila[columnaId] = String.valueOf(doc.getId());

            datosFila[columnaCodigo] = doc.getCodigo();
            datosFila[columnaNombre] = doc.getNombre();

            String accionInv = doc.getAccion();
            switch (accionInv) {
                case DatosBaseDatos.varEntradaBD:
                    datosFila[columnaAccionInv] = DatosBaseDatos.varEntrada;
                    break;
                case DatosBaseDatos.varSalidaBD:
                    datosFila[columnaAccionInv] = DatosBaseDatos.varSalida;
                    break;
                default:
                    break;
            }

            String aplica = doc.getAplica();
            switch (aplica) {
                case DatosBaseDatos.varAplicaClienteBD:
                    datosFila[columnaAplica] = DatosBaseDatos.varAplicaCliente;
                    break;
                case DatosBaseDatos.varAplicaProveedorBD:
                    datosFila[columnaAplica] = DatosBaseDatos.varAplicaProveedor;
                    break;
                default:
                    break;
            }

            boolean numera = doc.isNumera();
            if (numera) {
                datosFila[columnaNumera] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaNumera] = DatosBaseDatos.varNo;
            }

            datosFila[columnaNumero] = doc.getNumero();

            boolean controlExistencias = doc.isControlExistencia();
            if (controlExistencias) {
                datosFila[columnaControlExitencia] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaControlExitencia] = DatosBaseDatos.varNo;
            }

            boolean docBase = doc.isDocBase();
            if (docBase) {
                datosFila[columnaDocBase] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaDocBase] = DatosBaseDatos.varNo;
            }

            boolean precioFijo = doc.isPrecioFijo();
            if (precioFijo) {
                datosFila[columnaPrecioFijo] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaPrecioFijo] = DatosBaseDatos.varNo;
            }

            boolean listaPrecio = doc.isListaPrecio();
            if (listaPrecio) {
                datosFila[columnaListaPrecio] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaListaPrecio] = DatosBaseDatos.varNo;
            }

            boolean costeoInv = doc.isCosteoInventario();
            if (costeoInv) {
                datosFila[columnaCosteoInv] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaCosteoInv] = DatosBaseDatos.varNo;
            }

            Bodega bodega = doc.getBodega();
            if (bodega != null) {
                datosFila[columnaBodega] = bodega.getCodigo();
                datosFila[columnaIdBodega] = String.valueOf(bodega.getId());
            }

            boolean estado = doc.getEstado();
            String est;
            if (estado) {
                est = DatosBaseDatos.estadoActivo;
            } else {
                est = DatosBaseDatos.estadoInactivo;
            }
            datosFila[columnaEstado] = est;

            dtmTablaGeneral.addRow(datosFila);
        }
    }

    private void deshacerFiltroTablaGeneral() {
        Filtro.deshacerFiltro(trsFiltroGeneral, dtmTablaGeneral, tablaGeneral);
    }

    @Override
    protected void definaAccionesInformacion() {// Definiendo acciones
        ValidacionCampos.asignarTeclasDireccion(txt_codigo, null, txt_nombre, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_nombre, txt_codigo, combo_accionInv, null, null);
        ValidacionCampos.asignarTeclasDireccion(combo_accionInv, txt_nombre, combo_aplica, null, null);
        ValidacionCampos.asignarTeclasDireccion(combo_aplica, combo_accionInv, txt_numero, null, null);

        ValidacionCampos.asignarTeclasDireccion(chk_numera, combo_aplica, txt_numero, null, null);
        chk_numera.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                boolean estado = chk_numera.isSelected();
                if (estado) {
                    txt_numero.setEnabled(true);
                } else {
                    txt_numero.setEnabled(false);
                    txt_numero.setText("");
                }
            }
        });

        ValidacionCampos.asignarTeclasDireccion(txt_numero, chk_numera, chk_controlExistencia, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_controlExistencia, chk_numera, chk_docBase, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_docBase, chk_controlExistencia, chk_precioFijo, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_precioFijo, chk_docBase, chk_listaPrecio, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_listaPrecio, chk_precioFijo, chk_costeoInv, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_costeoInv, chk_listaPrecio, txt_bodega, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_bodega, chk_costeoInv, combo_estado, null, null);
        ValidacionCampos.asignarTeclasDireccion(combo_estado, txt_bodega, btn_agregar, null, null);
    }

    @Override
    protected void accionBotonAgregar() {// Insertando nuevo documento
        try {
            DocumentoFuente documento = setValoresDocumento();

            boolean valido = puedeInsertarOModificar(false, documento);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = documento.insertar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha insertado satisfactoriamente el documento.";
                    titulo = "Insertado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido insertar el documento. Por favor inténtelo de nuevo.";
                    titulo = "Error (123)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(documento.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, ExpendioException.getStackTrace(ex), "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    @Override
    protected void accionBotonAgregarModificar() {// Editando documento seleccionado de la tabla
        try {
            DocumentoFuente documento = setValoresDocumento();

            boolean valido = puedeInsertarOModificar(true, documento);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = documento.modificar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha modificado satisfactoriamente el documento.";
                    titulo = "Modificado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido modificar el documento. Por favor inténtelo de nuevo.";
                    titulo = "Error (124)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(documento.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, "", "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    private DocumentoFuente setValoresDocumento() {
        DocumentoFuente documento = new DocumentoFuente();

        documento.setId(idDocFuente);

        documento.setCodigo(txt_codigo.getText().trim());
        documento.setNombre(txt_nombre.getText().trim());

        String accionInv = (String) combo_accionInv.getSelectedItem();
        if (accionInv != null) {
            switch (accionInv) {
                case DatosBaseDatos.varEntrada:
                    accionInv = DatosBaseDatos.varEntradaBD;
                    break;
                case DatosBaseDatos.varSalida:
                    accionInv = DatosBaseDatos.varSalidaBD;
                    break;
                default:
                    break;
            }
        }
        documento.setAccion(accionInv);

        String aplica = (String) combo_aplica.getSelectedItem();
        if (aplica != null) {
            switch (aplica) {
                case DatosBaseDatos.varAplicaCliente:
                    aplica = DatosBaseDatos.varAplicaClienteBD;
                    break;
                case DatosBaseDatos.varAplicaProveedor:
                    aplica = DatosBaseDatos.varAplicaProveedorBD;
                    break;
                default:
                    break;
            }
        }
        documento.setAplica(aplica);

        documento.setNumera(chk_numera.isSelected());
        documento.setNumero(txt_numero.getText().trim());
        documento.setControlExistencia(chk_controlExistencia.isSelected());
        documento.setDocBase(chk_docBase.isSelected());
        documento.setPrecioFijo(chk_precioFijo.isSelected());
        documento.setListaPrecio(chk_listaPrecio.isSelected());
        documento.setCosteoInventario(chk_costeoInv.isSelected());

        Bodega bodega = null;
        if (idBodega != null) {
            bodega = Servicios.bodegasController.bodegasRepository.consultarPorId(String.valueOf(idBodega));
        }
        documento.setBodega(bodega);

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
        documento.setEstado(est);

        return documento;
    }

    private boolean puedeInsertarOModificar(boolean esModificar, DocumentoFuente documento) throws ExpendioException {
        String campos = documento.validarCamposObligatorios(esModificar);

        boolean correcto = true;

        if (campos != null) {
            correcto = correcto && validarCampo(campos, "ID", "Por favor seleccione un documento.", txt_codigo);
            correcto = correcto && validarCampo(campos, "CODIGO", "Por favor ingrese el código.", txt_codigo);
            correcto = correcto && validarCampo(campos, "NOMBRE", "Por favor ingrese el nombre.", txt_nombre);
            correcto = correcto && validarCampo(campos, "ACCION", "Por favor ingrese la acción.", combo_accionInv);
            correcto = correcto && validarCampo(campos, "APLICA", "Por favor ingrese a qué aplica.", combo_aplica);
            correcto = correcto && validarCampo(campos, "NUMERO", "Por favor ingrese el número.", txt_numero);
//            correcto = correcto && validarCampo(campos, "BODEGA", "Por favor ingrese la bodega.", txt_bodega);
            correcto = correcto && validarCampo(campos, "ESTADO", "Por favor ingrese el estado.", combo_estado);
        }

        correcto = correcto && validarExiste(esModificar, documento);

        return correcto;
    }

    private boolean validarExiste(boolean esModificar, DocumentoFuente documento) throws ExpendioException {
        boolean valido = !documento.validarExiste(esModificar);
        if (!valido) {
            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "", "Ya existe un código asociado a este documento.");
            txt_codigo.grabFocus();
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

            idDocFuente = Long.parseLong((String) dtmTablaGeneral.getValueAt(model, columnaId));

            txt_codigo.setText((String) dtmTablaGeneral.getValueAt(model, columnaCodigo));
            txt_nombre.setText((String) dtmTablaGeneral.getValueAt(model, columnaNombre));

            CampoCombo.setValueCombo(combo_accionInv, (String) dtmTablaGeneral.getValueAt(model, columnaAccionInv));
            CampoCombo.setValueCombo(combo_aplica, (String) dtmTablaGeneral.getValueAt(model, columnaAplica));

            boolean numera = DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaNumera));
            chk_numera.setSelected(numera);
            txt_numero.setText((String) dtmTablaGeneral.getValueAt(model, columnaNumero));
            if (!numera) {
                txt_numero.setEnabled(false);
            } else {
                txt_numero.setEnabled(true);
            }

            chk_controlExistencia.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaControlExitencia)));
            chk_docBase.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaDocBase)));
            chk_precioFijo.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaPrecioFijo)));
            chk_listaPrecio.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaListaPrecio)));
            chk_costeoInv.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaCosteoInv)));

            txt_bodega.setText((String) dtmTablaGeneral.getValueAt(model, columnaBodega));

            String idBod = (String) dtmTablaGeneral.getValueAt(model, columnaIdBodega);
            if (idBod != null) {
                idBodega = Long.parseLong(idBod);
            }

            CampoCombo.setValueCombo(combo_estado, (String) dtmTablaGeneral.getValueAt(model, columnaEstado));

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
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "No ha seleccionado ningún documento para modificar.");
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
        Filtro.filtroDosColumnasQueContenga(txt_buscar.getText().trim(), trsFiltroGeneral, columnaCodigo, columnaNombre, dtmTablaGeneral, tablaGeneral);
    }

    @Override
    protected void accionBotonBorrar() {// Boton Borrar
        int selected = tablaGeneral.getSelectedRow();
        if (selected == -1) {
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "Por favor seleccione el documento que desea eliminar.");
        } else {
            int fila = tablaGeneral.convertRowIndexToModel(selected);

            long id = Long.parseLong((String) dtmTablaGeneral.getValueAt(fila, columnaId));

            int respuesta = option.tipoMensaje(GUIJOption.mensajePregunta, "", "", "¿Está seguro que desea eliminar el documento seleccionado?");
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    deshacerFiltroTablaGeneral();

                    DocumentoFuente documento = new DocumentoFuente();
                    documento.setId(id);

                    boolean accion = documento.borrar(usuario);
                    cargarDatosGeneral();

                    String mensaje = null, titulo = null, tipo = null;
                    if (accion) {
                        mensaje = "Se ha eliminado satisfactoriamente el documento.";
                        titulo = "Eliminado";
                        tipo = GUIJOption.mensajeInformacion;
                    } else {
                        mensaje = "Ha ocurrido un error y no se ha podido eliminar el documento. Por favor inténtelo de nuevo.";
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
        idDocFuente = null;

        txt_codigo.setText("");
        txt_nombre.setText("");

        combo_accionInv.setSelectedIndex(-1);
        combo_aplica.setSelectedIndex(-1);

        chk_numera.setSelected(false);
        txt_numero.setText("");
        txt_numero.setEnabled(false);

        chk_controlExistencia.setSelected(false);
        chk_docBase.setSelected(false);
        chk_precioFijo.setSelected(false);
        chk_listaPrecio.setSelected(false);
        chk_costeoInv.setSelected(false);

        idBodega = null;
        txt_bodega.setText("");

        combo_estado.setSelectedIndex(0);// Estado activo por defecto
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
        txt_codigo.grabFocus();
    }

    @Override
    public void asignarPermisos() {
//        Permisos.asignarPermisosAdicionarModificarBorrar(btn_agregar, btn_modificar, btn_borrar, estaEditando, Permisos.catalogosCargos, usuario);
    }

}
