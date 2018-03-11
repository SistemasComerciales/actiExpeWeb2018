package activa.Expendio.vista;

import activa.Expendio.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUICatalogoBodegas extends GUIInterfazCatalogos {

    // Panel de informacion
    private JPanel panel_informacion;
    private CampoLabel lbl_codigo, lbl_nombre, lbl_estado;
    private Long idBodega;
    private CajaDeTexto txt_codigo, txt_nombre;
    private CampoCombo<String> combo_estado;

    // Utilitarios
    private static String nombreClase = "Bodegas";
    private static final int limiteCaracteresCampoSoloLetras = 100;

    // Indices de la tabla general
    public static final int columnaCodigo = 0;
    public static final int columnaNombre = columnaCodigo + 1;
    public static final int columnaEstado = columnaNombre + 1;
    public static final int columnaId = columnaEstado + 1;

    public GUICatalogoBodegas(Usuario usuario) {
        super(usuario, false);
    }

    @Override
    protected String getNombreClase() {
        return nombreClase;
    }

    @Override
    protected void prepareElementosInformacion() {// panel de informacion
        panel_informacion = new JPanel();
        panel_informacion.setLocation(0, 0);
        panel_informacion.setSize(CargaImagenes.ANCHO_PANTALLA, 4 * CargaImagenes.ALTO_PANTALLA / 12);
        panel_informacion.setLayout(null);
        panel_informacion.setOpaque(false);
        this.add(panel_informacion);

        int filas = (4 * CargaImagenes.ALTO_PANTALLA / 18) / 6;
        int columnas = (CargaImagenes.ANCHO_PANTALLA - 10) / 7;
        int ncolumnas = CargaImagenes.ANCHO_PANTALLA / 8;
        int posicionX = this.getWidth() / 5;
        int posicionY = this.getHeight() / 7;
        int var = 10;

        lbl_codigo = new CampoLabel("Código:", CampoLabel.labelEstatico);
        lbl_codigo.setLocation(posicionX, posicionY);
        lbl_codigo.setSize(55, filas);
        panel_informacion.add(lbl_codigo);

        txt_codigo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoSoloLetras);
        txt_codigo.setLocation(lbl_codigo.getX() + lbl_codigo.getWidth(), lbl_codigo.getY());
        txt_codigo.setSize(columnas - 55, lbl_codigo.getHeight());
        panel_informacion.add(txt_codigo);

        lbl_nombre = new CampoLabel("Nombre:", CampoLabel.labelEstatico);
        lbl_nombre.setLocation(txt_codigo.getX() + txt_codigo.getWidth() + var * 4, txt_codigo.getY());
        lbl_nombre.setSize(lbl_codigo.getWidth(), txt_codigo.getHeight());
        panel_informacion.add(lbl_nombre);

        txt_nombre = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresCampoSoloLetras);
        txt_nombre.setLocation(lbl_nombre.getX() + lbl_nombre.getWidth() + var, lbl_nombre.getY());
        txt_nombre.setSize(2 * columnas - 62, txt_codigo.getHeight());
        panel_informacion.add(txt_nombre);

        lbl_estado = new CampoLabel("Estado:", CampoLabel.labelEstatico);
        lbl_estado.setLocation(txt_nombre.getX() + txt_nombre.getWidth() + var * 4, txt_nombre.getY());
        lbl_estado.setSize(lbl_nombre.getWidth() * 2, lbl_nombre.getHeight());
        panel_informacion.add(lbl_estado);

        combo_estado = new CampoCombo<String>(DatosBaseDatos.estadoActivo, DatosBaseDatos.estadoInactivo);
        combo_estado.setLocation(lbl_estado.getX() + lbl_estado.getWidth(), lbl_estado.getY());
        combo_estado.setSize(txt_codigo.getWidth(), txt_codigo.getHeight());
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
        dtmTablaGeneral.addColumn("Estado");
        dtmTablaGeneral.addColumn("ID");

        int anchoTotal = anchoPanel / 6;

        for (int i = 0; i < tablaGeneral.getColumnCount(); i++) {
            tablaGeneral.getColumnModel().getColumn(i).setMaxWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setMinWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setPreferredWidth(0);
        }

        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(anchoTotal);

        tablaGeneral.getColumnModel().getColumn(columnaNombre).setMaxWidth(anchoTotal * 3);
        tablaGeneral.getColumnModel().getColumn(columnaNombre).setMinWidth(anchoTotal * 3);
        tablaGeneral.getColumnModel().getColumn(columnaNombre).setPreferredWidth(anchoTotal * 3);

        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMaxWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setMinWidth(anchoTotal);
        tablaGeneral.getColumnModel().getColumn(columnaEstado).setPreferredWidth(anchoTotal);
    }

    private void cargarDatosGeneral() {
        deshacerFiltroTablaGeneral();
        Tabla.eliminarFilasTabla(dtmTablaGeneral);

        PersistenciaBodegaInt persistencia = ExpendioApplication.bodegasController.bodegasRepository;

        ArrayList<Bodega> bodegas = persistencia.consultarTodos();

        for (Bodega bodega : bodegas) {
            String[] datosFila = new String[dtmTablaGeneral.getColumnCount()];

            datosFila[columnaId] = String.valueOf(bodega.getId());

            datosFila[columnaCodigo] = bodega.getCodigo();
            datosFila[columnaNombre] = bodega.getNombre();

            boolean estado = bodega.isEstado();
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
        ValidacionCampos.asignarTeclasDireccion(txt_nombre, txt_codigo, combo_estado, null, null);
        ValidacionCampos.asignarTeclasDireccion(combo_estado, txt_nombre, btn_agregar, null, null);
    }

    @Override
    protected void accionBotonAgregar() {// Insertando nueva bodega
        try {
            Bodega bodega = setValoresBodega();

            boolean valido = puedeInsertarOModificar(false, bodega);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = bodega.insertar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha insertado satisfactoriamente la bodega.";
                    titulo = "Insertado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido insertar la bodega. Por favor inténtelo de nuevo.";
                    titulo = "Error (123)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(bodega.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, ExpendioException.getStackTrace(ex), "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    @Override
    protected void accionBotonAgregarModificar() {// Editando bodega seleccionada de la tabla
        try {
            Bodega bodega = setValoresBodega();

            boolean valido = puedeInsertarOModificar(true, bodega);
            if (valido) {
                deshacerFiltroTablaGeneral();

                boolean accion = bodega.modificar(usuario);
                cargarDatosGeneral();

                String mensaje = null, titulo = null, tipo = null;
                if (accion) {
                    mensaje = "Se ha modificado satisfactoriamente la bodega.";
                    titulo = "Modificado";
                    tipo = GUIJOption.mensajeInformacion;
                } else {
                    mensaje = "Ha ocurrido un error y no se ha podido modificar la bodega. Por favor inténtelo de nuevo.";
                    titulo = "Error (124)";
                    tipo = GUIJOption.mensajeAdvertencia;
                }
                option.tipoMensaje(tipo, "", titulo, mensaje);

                if (accion) {
                    iniciarBusqueda();
                    ocultarTxtBuscar();
                    desactivarModificar();

                    inicializarInformacion();
                    seleccionarFila(String.valueOf(bodega.getId()), columnaId);
                }
            }
        } catch (ExpendioException ex) {
            option.tipoMensaje(GUIJOption.mensajeError, "", "Error (35)", ExpendioException.getMensajeErrorBaseDatos());
            ex.printStackTrace();
        }
    }

    private Bodega setValoresBodega() {
        Bodega bodega = new Bodega();

        bodega.setId(idBodega);

        bodega.setCodigo(txt_codigo.getText().trim());
        bodega.setNombre(txt_nombre.getText().trim());

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
        bodega.setEstado(est);

        return bodega;
    }

    private boolean puedeInsertarOModificar(boolean esModificar, Bodega bodega) throws ExpendioException {
        String campos = bodega.validarCamposObligatorios(esModificar);

        boolean correcto = true;

        if (campos != null) {
            correcto = correcto && validarCampo(campos, "ID", "Por favor seleccione una bodega.", txt_codigo);
            correcto = correcto && validarCampo(campos, "CODIGO", "Por favor ingrese el código.", txt_codigo);
            correcto = correcto && validarCampo(campos, "NOMBRE", "Por favor ingrese el nombre.", txt_nombre);
            correcto = correcto && validarCampo(campos, "ESTADO", "Por favor ingrese el estado.", combo_estado);
        }

        correcto = correcto && validarExiste(esModificar, bodega);

        return correcto;
    }

    private boolean validarExiste(boolean esModificar, Bodega bodega) throws ExpendioException {
        boolean valido = !bodega.validarExiste(esModificar);
        if (!valido) {
            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "", "Ya existe un código asociado a esta bodega.");
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

            idBodega = Long.parseLong((String) dtmTablaGeneral.getValueAt(model, columnaId));

            txt_codigo.setText((String) dtmTablaGeneral.getValueAt(model, columnaCodigo));
            txt_nombre.setText((String) dtmTablaGeneral.getValueAt(model, columnaNombre));

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
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "No ha seleccionado ninguna bodega para modificar.");
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
            option.tipoMensaje(GUIJOption.mensajeInformacion, "", "Error", "Por favor seleccione la bodega que desea eliminar.");
        } else {
            int fila = tablaGeneral.convertRowIndexToModel(selected);

            long id = Long.parseLong((String) dtmTablaGeneral.getValueAt(fila, columnaId));

            int respuesta = option.tipoMensaje(GUIJOption.mensajePregunta, "", "", "¿Está seguro que desea eliminar la bodega seleccionada?");
            if (respuesta == JOptionPane.YES_OPTION) {
                try {
                    deshacerFiltroTablaGeneral();

                    Bodega bodega = new Bodega();
                    bodega.setId(id);

                    boolean accion = bodega.borrar(usuario);
                    cargarDatosGeneral();

                    String mensaje = null, titulo = null, tipo = null;
                    if (accion) {
                        mensaje = "Se ha eliminado satisfactoriamente la bodega.";
                        titulo = "Eliminado";
                        tipo = GUIJOption.mensajeInformacion;
                    } else {
                        mensaje = "Ha ocurrido un error y no se ha podido eliminar la bodega. Por favor inténtelo de nuevo.";
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
        idBodega = null;

        txt_codigo.setText("");
        txt_nombre.setText("");

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
