package activa.Expendio.vista;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import javax.swing.*;

import utils.*;
import activa.Expendio.controllers.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.tablas.*;
import java.awt.event.*;
import java.util.*;

/**
 *
 * @author Administrador
 */
public class GUIProducto extends GUIInterfazCatalogos {

    // Panel de informacion
    private JPanel panel_informacion;
    private CampoLabel lbl_codigo, lbl_nombre, lbl_presentacion, lbl_codigoBarras, lbl_grupo;
    private CampoLabel lbl_observaciones, lbl_estado;
    private Long idProducto, idGrupo;
    private CasillaVerificacion chk_controlExistencia, chk_afectaCupo, chk_controlSerial, chk_precio10PorCiento;
    private CajaDeTexto txt_codigo, txt_nombre, txt_presentacion, txt_codigoBarras, txt_grupo;
    private CajaTextoArea txt_observaciones;
    private JScrollPane scroll_observaciones;
    private CampoCombo<String> combo_estado;
    private GUITablaGrupos tablaGrupos;

    // Utilitarios
    private static String nombreClase = "Productos";
    public static final int limiteCaracteresCampoCodigo = 15;
    public static final int limiteCaracteresCampoSoloLetras = 100;

    // Indices de la tabla general
    private static int columnaCodigo = 0;
    private static int columnaNombre = columnaCodigo + 1;
    private static int columnaPresentacion = columnaNombre + 1;
    private static int columnaCodigoBarras = columnaPresentacion + 1;
    private static int columnaGrupo = columnaCodigoBarras + 1;
    private static int columnaIdGrupo = columnaGrupo + 1;
    private static int columnaControlExistencia = columnaIdGrupo + 1;
    private static int columnaAfectaCupo = columnaControlExistencia + 1;
    private static int columnaControlSerial = columnaAfectaCupo + 1;
    private static int columnaPrecio10 = columnaControlSerial + 1;
    private static int columnaObservaciones = columnaPrecio10 + 1;
    private static int columnaEstado = columnaObservaciones + 1;
    private static int columnaId = columnaEstado + 1;

    public GUIProducto(Usuario usuario) {
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

        int posicionX = panel_informacion.getWidth() / 30;
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

        lbl_presentacion = new CampoLabel("Presentación:", CampoLabel.labelEstatico);
        lbl_presentacion.setLocation(lbl_nombre.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + var * 2);
        lbl_presentacion.setSize(lbl_nombre.getWidth(), lbl_nombre.getHeight());
        panel_informacion.add(lbl_presentacion);

        txt_presentacion = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoCodigo);
        txt_presentacion.setLocation(lbl_presentacion.getX() + lbl_presentacion.getWidth() + var * 2, lbl_presentacion.getY());
        txt_presentacion.setSize(txt_nombre.getWidth(), txt_nombre.getHeight());
        panel_informacion.add(txt_presentacion);

        lbl_codigoBarras = new CampoLabel("Cód. Barras:", CampoLabel.labelEstatico);
        lbl_codigoBarras.setLocation(lbl_presentacion.getX(), lbl_presentacion.getY() + lbl_presentacion.getHeight() + var * 2);
        lbl_codigoBarras.setSize(lbl_presentacion.getWidth(), lbl_presentacion.getHeight());
        panel_informacion.add(lbl_codigoBarras);

        txt_codigoBarras = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoCodigo);
        txt_codigoBarras.setLocation(lbl_codigoBarras.getX() + lbl_codigoBarras.getWidth() + var * 2, lbl_codigoBarras.getY());
        txt_codigoBarras.setSize(txt_presentacion.getWidth(), txt_presentacion.getHeight());
        panel_informacion.add(txt_codigoBarras);

        chk_controlExistencia = new CasillaVerificacion("Control de Existencias");
        chk_controlExistencia.setLocation(txt_codigo.getX() + txt_codigo.getWidth() + var * 4, txt_codigo.getY());
        chk_controlExistencia.setSize(txt_codigo.getWidth() * 2, txt_codigo.getHeight());
        panel_informacion.add(chk_controlExistencia);

        chk_afectaCupo = new CasillaVerificacion("Afecta cupo");
        chk_afectaCupo.setLocation(chk_controlExistencia.getX(), txt_nombre.getY());
        chk_afectaCupo.setSize(chk_controlExistencia.getWidth(), chk_controlExistencia.getHeight());
        panel_informacion.add(chk_afectaCupo);

        chk_controlSerial = new CasillaVerificacion("Control de Seriales");
        chk_controlSerial.setLocation(chk_afectaCupo.getX(), txt_presentacion.getY());
        chk_controlSerial.setSize(chk_afectaCupo.getWidth(), chk_afectaCupo.getHeight());
        panel_informacion.add(chk_controlSerial);

        chk_precio10PorCiento = new CasillaVerificacion("Aplica Precio 10%");
        chk_precio10PorCiento.setLocation(chk_controlSerial.getX(), txt_codigoBarras.getY());
        chk_precio10PorCiento.setSize(chk_controlSerial.getWidth(), chk_controlSerial.getHeight());
        panel_informacion.add(chk_precio10PorCiento);

        lbl_observaciones = new CampoLabel("Observaciones:", CampoLabel.labelEstatico);
        lbl_observaciones.setLocation(chk_controlExistencia.getX() + chk_controlExistencia.getWidth() + var, chk_controlExistencia.getY());
        lbl_observaciones.setSize(lbl_codigoBarras.getWidth() * 2 / 3, lbl_codigoBarras.getHeight());
        panel_informacion.add(lbl_observaciones);

        txt_observaciones = new CajaTextoArea(CajaDeTexto.textoLetrasNumeros);
        txt_observaciones.setLocation(lbl_observaciones.getX() + lbl_observaciones.getWidth() + var * 2, lbl_observaciones.getY());
        txt_observaciones.setSize(txt_codigoBarras.getWidth(), (txt_codigoBarras.getHeight() + var) * 2);

        scroll_observaciones = new JScrollPane(txt_observaciones);
        scroll_observaciones.setLocation(txt_observaciones.getX(), txt_observaciones.getY());
        scroll_observaciones.setSize(txt_observaciones.getWidth(), txt_observaciones.getHeight());
        scroll_observaciones.setOpaque(false);
        scroll_observaciones.getViewport().setOpaque(false);
        panel_informacion.add(scroll_observaciones);

        lbl_grupo = new CampoLabel("Grupo:", CampoLabel.labelEstatico);
        lbl_grupo.setLocation(lbl_observaciones.getX(), chk_controlSerial.getY());
        lbl_grupo.setSize(lbl_observaciones.getWidth(), lbl_observaciones.getHeight());
        panel_informacion.add(lbl_grupo);

        txt_grupo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoCodigo);
        txt_grupo.setLocation(lbl_grupo.getX() + lbl_grupo.getWidth() + var * 2, lbl_grupo.getY());
        txt_grupo.setSize(txt_codigoBarras.getWidth(), txt_codigoBarras.getHeight());
        panel_informacion.add(txt_grupo);

        lbl_estado = new CampoLabel("Estado:", CampoLabel.labelEstatico);
        lbl_estado.setLocation(lbl_grupo.getX(), chk_precio10PorCiento.getY());
        lbl_estado.setSize(lbl_grupo.getWidth(), lbl_grupo.getHeight());
        panel_informacion.add(lbl_estado);

        combo_estado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_estado.setLocation(lbl_estado.getX() + lbl_estado.getWidth() + var * 2, lbl_estado.getY());
        combo_estado.setSize(txt_grupo.getWidth(), txt_grupo.getHeight());
        panel_informacion.add(combo_estado);

        int posX = txt_observaciones.getX() + txt_observaciones.getWidth() + var * 2;
        int posY = txt_observaciones.getY();
        int anchoPanel = this.getWidth() / 100 * 37;
        int altoPanel = this.getHeight() / 100 * 25;
        tablaGrupos = new GUITablaGrupos(posX, posY, anchoPanel, altoPanel);
        panel_informacion.add(tablaGrupos);
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
        dtmTablaGeneral.addColumn("Presentación");
        dtmTablaGeneral.addColumn("Cód. Barras");
        dtmTablaGeneral.addColumn("Grupo");
        dtmTablaGeneral.addColumn("idGrupo");
        dtmTablaGeneral.addColumn("C. existencia");
        dtmTablaGeneral.addColumn("Afecta cupo");
        dtmTablaGeneral.addColumn("Control Seriales");
        dtmTablaGeneral.addColumn("Precio 10%");
        dtmTablaGeneral.addColumn("Nota");
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

        tablaGeneral.getColumnModel().getColumn(columnaPresentacion).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaPresentacion).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaPresentacion).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaCodigoBarras).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaCodigoBarras).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaCodigoBarras).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaGrupo).setMaxWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaGrupo).setMinWidth(anchoTotal / 2);
        tablaGeneral.getColumnModel().getColumn(columnaGrupo).setPreferredWidth(anchoTotal / 2);

        tablaGeneral.getColumnModel().getColumn(columnaControlExistencia).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaControlExistencia).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaControlExistencia).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaAfectaCupo).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaAfectaCupo).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaAfectaCupo).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaControlSerial).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaControlSerial).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaControlSerial).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaPrecio10).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaPrecio10).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaPrecio10).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaObservaciones).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaObservaciones).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaObservaciones).setPreferredWidth(anchoTotal / 3);

        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMaxWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMinWidth(anchoTotal / 3);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setPreferredWidth(anchoTotal / 3);
    }

    private void cargarDatosGeneral() {
        deshacerFiltroTablaGeneral();
        Tabla.eliminarFilasTabla(dtmTablaGeneral);

        PersistenciaProductoInt persistencia = Servicios.productosController.productosRepository;

        ArrayList<Producto> productos = persistencia.consultarTodos();

        for (Producto producto : productos) {
            String[] datosFila = new String[dtmTablaGeneral.getColumnCount()];

            datosFila[columnaId] = String.valueOf(producto.getId());

            datosFila[columnaCodigo] = producto.getCodigo();
            datosFila[columnaNombre] = producto.getNombre();
            datosFila[columnaPresentacion] = producto.getPresentacion();
            datosFila[columnaCodigoBarras] = producto.getCodigoBarras();

            boolean controlExistencias = producto.isControlExistencia();
            if (controlExistencias) {
                datosFila[columnaControlExistencia] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaControlExistencia] = DatosBaseDatos.varNo;
            }

            boolean docBase = producto.isAfectaCupo();
            if (docBase) {
                datosFila[columnaAfectaCupo] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaAfectaCupo] = DatosBaseDatos.varNo;
            }

            boolean precioFijo = producto.isControlSerial();
            if (precioFijo) {
                datosFila[columnaControlSerial] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaControlSerial] = DatosBaseDatos.varNo;
            }

            boolean listaPrecio = producto.isPrecio10Porciento();
            if (listaPrecio) {
                datosFila[columnaPrecio10] = DatosBaseDatos.varSi;
            } else {
                datosFila[columnaPrecio10] = DatosBaseDatos.varNo;
            }

            GrupoProducto grupo = producto.getGrupo();
            if (grupo != null) {
                datosFila[columnaGrupo] = grupo.getCodigo();
                datosFila[columnaIdGrupo] = String.valueOf(grupo.getId());
            }

            datosFila[columnaObservaciones] = producto.getObservaciones();

            boolean estado = producto.getEstado();
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
        ValidacionCampos.asignarTeclasDireccion(txt_nombre, txt_codigo, txt_presentacion, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_presentacion, txt_nombre, txt_codigoBarras, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_codigoBarras, txt_presentacion, chk_controlExistencia, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_controlExistencia, txt_codigoBarras, chk_afectaCupo, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_afectaCupo, chk_controlExistencia, chk_controlSerial, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_controlSerial, chk_afectaCupo, chk_precio10PorCiento, null, null);
        ValidacionCampos.asignarTeclasDireccion(chk_precio10PorCiento, chk_controlSerial, txt_observaciones, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_observaciones, chk_precio10PorCiento, txt_grupo, null, null);

        txt_grupo.addFocusListener(new FocusAdapter() {

            @Override
            public void focusLost(FocusEvent e) {
                String dato = txt_grupo.getText().trim();
                if (dato.isEmpty()) {
                    inicializarGrupo();
                } else if (!tablaGrupos.tabla.isRowSelected(tablaGrupos.tabla.getSelectedRow())) {
                    GrupoProducto grupo = Servicios.gruposController.gruposRepository.consultarPorCodigo(dato);
                    if (grupo == null) {
                        option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El grupo no existe.", "Por favor inténtelo de nuevo.");
                        inicializarGrupo();
                        txt_grupo.grabFocus();
                    } else {
                        seleccionarGrupo(grupo);
                    }
                }
            }
        });
        txt_grupo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() != KeyEvent.VK_UP && e.getKeyCode() != KeyEvent.VK_DOWN) {
                    ValidacionCampos.teclasDireccion(e, txt_observaciones, combo_estado, null, null, txt_grupo);
                } else {
                    tablaGrupos.aplicarFiltro(txt_grupo);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    tablaGrupos.grabFocus();
                }
            }
        });
        realizarAccionesTablaGrupos();

        ValidacionCampos.asignarTeclasDireccion(combo_estado, txt_grupo, btn_agregar, null, null);
    }

    private void realizarAccionesTablaGrupos() {
        tablaGrupos.tabla.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isMetaDown()) {
                    seleccionarDatosGrupo();
                    combo_estado.grabFocus();
                }
            }
        });
        tablaGrupos.tabla.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    seleccionarDatosGrupo();
                    combo_estado.grabFocus();
                }
            }
        });
    }

    private void seleccionarDatosGrupo() {
        int fila = tablaGrupos.tabla.getSelectedRow();
        if (fila != -1) {
            txt_grupo.setText(tablaGrupos.tabla.getValueAt(fila, GUITablaGrupos.columnaCodigo).toString());
            idGrupo = Long.parseLong(tablaGrupos.tabla.getValueAt(fila, GUITablaGrupos.columnaId).toString());
        }
    }

    private void seleccionarGrupo(GrupoProducto grupo) {
        txt_grupo.setText(grupo.getCodigo());
        idGrupo = grupo.getId();
    }

    @Override
    protected void accionBotonAgregar() {// Insertando nuevo producto
        try {
            Producto producto = setValoresProducto();

            boolean valido = puedeInsertarOModificar(false, producto);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = producto.insertar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha insertado satisfactoriamente el producto.";
                    titulo = "Insertado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido insertar el producto. Por favor inténtelo de nuevo.";
                    titulo = "Error (123)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(producto.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, ExpendioException.getStackTrace(ex), "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    @Override
    protected void accionBotonAgregarModificar() {// Editando producto seleccionado de la tabla
        try {
            Producto producto = setValoresProducto();

            boolean valido = puedeInsertarOModificar(true, producto);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = producto.modificar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha modificado satisfactoriamente el producto.";
                    titulo = "Modificado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido modificar el producto. Por favor inténtelo de nuevo.";
                    titulo = "Error (124)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(producto.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, "", "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    private Producto setValoresProducto() {
        Producto producto = new Producto();

        producto.setId(idProducto);

        producto.setCodigo(txt_codigo.getText().trim());
        producto.setNombre(txt_nombre.getText().trim());
        producto.setPresentacion(txt_presentacion.getText().trim());
        producto.setCodigoBarras(txt_codigoBarras.getText().trim());

        producto.setControlExistencia(chk_controlExistencia.isSelected());
        producto.setAfectaCupo(chk_afectaCupo.isSelected());
        producto.setControlSerial(chk_controlSerial.isSelected());
        producto.setPrecio10Porciento(chk_precio10PorCiento.isSelected());

        GrupoProducto grupo = null;
        if (idGrupo != null) {
            grupo = Servicios.gruposController.gruposRepository.consultarPorId(String.valueOf(idGrupo));
        }
        producto.setGrupo(grupo);

        producto.setObservaciones(txt_observaciones.getText().trim());

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
        producto.setEstado(est);

        return producto;
    }

    private boolean puedeInsertarOModificar(boolean esModificar, Producto producto) throws ExpendioException {
        String campos = producto.validarCamposObligatorios(esModificar);

        boolean correcto = true;

        if (campos != null) {
            correcto = correcto && validarCampo(campos, "ID", "Por favor seleccione un producto.", txt_codigo);
            correcto = correcto && validarCampo(campos, "CODIGO", "Por favor ingrese el código.", txt_codigo);
            correcto = correcto && validarCampo(campos, "NOMBRE", "Por favor ingrese el nombre.", txt_nombre);
            correcto = correcto && validarCampo(campos, "PRESENTACION", "Por favor ingrese la presentación.", txt_presentacion);
            correcto = correcto && validarCampo(campos, "CODIGOBARRAS", "Por favor ingrese el código de barras.", txt_codigoBarras);
//            correcto = correcto && validarCampo(campos, "GRUPO", "Por favor ingrese el grupo.", txt_grupo);
//            correcto = correcto && validarCampo(campos, "OBSERVACIONES", "Por favor ingrese las observaciones.", txt_observaciones);
            correcto = correcto && validarCampo(campos, "ESTADO", "Por favor ingrese el estado.", combo_estado);
        }

        correcto = correcto && validarExiste(esModificar, producto);

        return correcto;
    }

    private boolean validarExiste(boolean esModificar, Producto producto) throws ExpendioException {
        boolean valido = !producto.validarExiste(esModificar);
        if (!valido) {
            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "", "Ya existe un código asociado a este producto.");
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

            idProducto = Long.parseLong((String) dtmTablaGeneral.getValueAt(model, columnaId));

            txt_codigo.setText((String) dtmTablaGeneral.getValueAt(model, columnaCodigo));
            txt_nombre.setText((String) dtmTablaGeneral.getValueAt(model, columnaNombre));
            txt_presentacion.setText((String) dtmTablaGeneral.getValueAt(model, columnaPresentacion));
            txt_codigoBarras.setText((String) dtmTablaGeneral.getValueAt(model, columnaCodigoBarras));

            chk_controlExistencia.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaControlExistencia)));
            chk_afectaCupo.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaAfectaCupo)));
            chk_controlSerial.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaControlSerial)));
            chk_precio10PorCiento.setSelected(DatosBaseDatos.varSi.equals((String) dtmTablaGeneral.getValueAt(model, columnaPrecio10)));

            txt_grupo.setText((String) dtmTablaGeneral.getValueAt(model, columnaGrupo));

            String idGrp = (String) dtmTablaGeneral.getValueAt(model, columnaIdGrupo);
            if (idGrp != null) {
                idGrupo = Long.parseLong(idGrp);
            }

            txt_observaciones.setText((String) dtmTablaGeneral.getValueAt(model, columnaObservaciones));

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
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "No ha seleccionado ningún producto para modificar.");
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
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "Por favor seleccione el producto que desea eliminar.");
        } else {
            int fila = tablaGeneral.convertRowIndexToModel(selected);

            long id = Long.parseLong((String) dtmTablaGeneral.getValueAt(fila, columnaId));

            int respuesta = option.tipoMensaje(GUIJOption.mensajePregunta, "", "", "¿Está seguro que desea eliminar el producto seleccionado?");
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    deshacerFiltroTablaGeneral();

                    Producto producto = new Producto();
                    producto.setId(id);

                    boolean accion = producto.borrar(usuario);
                    cargarDatosGeneral();

                    String mensaje = null, titulo = null, tipo = null;
                    if (accion) {
                        mensaje = "Se ha eliminado satisfactoriamente el producto.";
                        titulo = "Eliminado";
                        tipo = GUIJOption.mensajeInformacion;
                    } else {
                        mensaje = "Ha ocurrido un error y no se ha podido eliminar el producto. Por favor inténtelo de nuevo.";
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
        idProducto = null;

        txt_codigo.setText("");
        txt_nombre.setText("");
        txt_presentacion.setText("");
        txt_codigoBarras.setText("");

        chk_controlExistencia.setSelected(false);
        chk_afectaCupo.setSelected(false);
        chk_controlSerial.setSelected(false);
        chk_precio10PorCiento.setSelected(false);

        inicializarGrupo();

        txt_observaciones.setText("");

        combo_estado.setSelectedIndex(0);// Estado activo por defecto

        tablaGrupos.deshacerFiltro();
    }

    private void inicializarGrupo() {
        idGrupo = null;
        txt_grupo.setText("");
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

        tablaGrupos.cargarDatosBasicos(usuario);
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
