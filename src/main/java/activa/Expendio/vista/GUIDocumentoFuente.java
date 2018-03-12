package activa.Expendio.vista;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import utils.*;

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
//        ValidacionCampos.asignarTeclasDireccion(txt_codigo, null, txt_nombre, null, null);
//        ValidacionCampos.asignarTeclasDireccion(txt_nombre, txt_codigo, combo_accionInv, null, null);
//        ValidacionCampos.asignarTeclasDireccion(combo_accionInv, txt_nombre, combo_aplica, null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//        ValidacionCampos.asignarTeclasDireccion(, , , null, null);
//    private CajaDeTexto txt_codigo, txt_nombre, txt_numero, txt_bodega;
//    private CasillaVerificacion chk_numera, chk_controlExistencia, chk_docBase, chk_precioFijo, chk_listaPrecio, chk_costeoInv;
//        ValidacionCampos.asignarTeclasDireccion(combo_estado, , btn_agregar, null, null);
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
