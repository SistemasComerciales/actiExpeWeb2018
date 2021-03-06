package activa.Expendio.vista;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import activa.Expendio.persistencia.*;
import static activa.Expendio.vista.ClaseGeneral.*;
import activa.Expendio.vista.tablas.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import javax.swing.*;
import javax.swing.table.*;
import utils.*;

/**
 *
 * @author diego
 */
public class GUITransaccion extends ClaseGeneral {

    public CampoLabel lbl_nombreDocFuente;

    private CampoLabel lbl_documento, lbl_numero, lbl_fecha, lbl_nit, lbl_condiciones, lbl_nombre, lbl_nombreDin, lbl_cupoDiario, lbl_cupoDiarioDin, lbl_ciudad, lbl_ciudadDin, lbl_cupoMensual, lbl_cupoMensualDin, lbl_cupoTotal, lbl_cupoTotalDin;
    private CajaDeTexto txt_fechaAntigua, txt_idDocumentoFuente, txt_documento, txt_documentoAntiguo, txt_numeracion, txt_numeroFijo, txt_documentoCierre, txt_numero, txt_estado, txt_idTercero, txt_nit, txt_nitAntiguo, txt_condiciones, txt_TipoClienteDocFuente, txt_llevaBodegaDocFuente, txt_idBodegaDocFuente, txt_accionSobreInventario, txt_costeKardex, txt_interfaceDocFuente, txt_llevaClienteFijo, txt_listaPrecioDoc, txt_ControlExistenciaDocFuente, txt_preCostoDocFuente, txt_cuentasPorCobrar, txt_cuentasPorPagar, txt_idTransaccionOriginal, txt_esAutoRete;
    private CajaDeTextoConFormato txt_fecha;

    ////////////panel REGISTRO2 MVTRANSACCION///////////
    private CampoLabel lbl_codigo, lbl_descripcion, lbl_empaque, lbl_bodega, lbl_cantidad, lbl_valorUnitario, lbl_valorTolal;
    private CajaDeTexto txt_idCodigo, txt_codigo, txt_descripcion, txt_empaque, txt_idBodega, txt_bodega, txt_idTransaccion;
    private CajaDeTexto txt_cantidad, txt_ValorUnitario, txt_valorTotal;

    //////////////////PANEL BOTONES 2////////////////////
    public CampoLabel lbl_adicionar, lbl_borrar, lbl_insertar, lbl_modificar, lbl_repetir, lbl_cancelarMV, lbl_guardarMv, lbl_NombreExistencia, lbl_ResultadoExistencia;
    public Boton btn_adicionar, btn_borrar2, btn_insertar, btn_modificar, btn_repetir, btn_cancelarMv, btn_guardarMv;

    //////////////////PANEL BOTONES 1/////////////////////
    private CampoLabel lbl_subtotal, lbl_descuento, lbl_retenciones, lbl_iva, lbl_total, lbl_subtotalResultado, lbl_totalResultados, lbl_descripcionItem, lbl_observaciones, lbl_grupoProducto, lbl_grupoContable, lbl_grupoContableResultado, lbl_grupoProductoResultado, lbl_numeroItems, lbl_numeroItemsResultado, lbl_numeroArticulos, lbl_numeroArticuloResultados, lbl_ivaResultado, lbl_retencionesResul;
    public CajaDeTexto txt_descripcionItem;
    public Boton btn_salir, btn_otros, btn_plantilla, btn_grabar, btn_borrar, btn_imprimir, btn_inicial, btn_buscar, btn_cancelar;
    private CampoLabel lbl_descuentoPorcentaje, lbl_descuentoValor;
    public CajaDeTexto txt_observaciones;

///////////////////PANEL PREPARA TABLA PRINCIPAL///////////////////////
    public JPanel panel_tablaPrincipal;
    public DefaultTableModel dtmTablaPrincipal;
    public JTable tablaPrincipal;
    public JScrollPane scrollpanePrincipal;
    public TableRowSorter<DefaultTableModel> trsFiltrotablaPrincipal;

///////////////////PANEL PREPARA DOCUMENTO FUENTE///////////////////////
    private GUITablaDocumentos tablaDocumentos;
///////////////////PANEL PREPARA TERCEROS///////////////////////
    private GUITablaInternos tablaTerceros;
///////////////////PANEL PREPARA PRODUCTO///////////////////////
    private GUITablaProductos tablaProductos;
///////////////////PANEL PREPARA BODEGA///////////////////////
    private GUITablaBodegas tablaBodegas;

    public static final int columnaCodigo = 0;
    public static final int columnaDescripcion = 1;
    public static final int columnaEmpaque = 2;
    public static final int columnaBodega = 3;
    public static final int columnaCantidad = 4;
    public static final int columnaVunitario = 5;
    public static final int columnaVtotal = 6;
    public static final int columnaidBodega = 7;

    Transaccion transaccion;

    public GUITransaccion(Usuario usuario) {
        super(usuario);
        prepareElementos();
        prepareElementosInfo();
        preparaElementosTablaPrincipal();
        prepararElementosRegistro2();
        preparaElementosBotones();
        preparaElementosBotones2();
        preparaElementosDocumentosFuente();
        prepareElementosTablaTerceros();
        prepareElementosTablaProducto();
        preparaElementosTablaBodega();
        cargarBodegas();
        cargarDatosDocFuente();
        cargarTerceros();
        cargarDatosProductos();
        accionBotones();
        accionCajaTexto();
        accionTablas();

        ocultarPaneles();
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "".toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);

    }

    /**
     * Método encargado del diseño del frame, tamaño, fondo.
     */
    protected void prepareElementos() {
        this.setTitle("Transacciones");
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
        transaccion = new Transaccion();
        transaccion.setListItem(new ArrayList<>());
    }

    /**
     *
     */
    private void prepareElementosInfo() {

        int posicionXTxt = CargaImagenes.ANCHO_PANTALLA / 100 * 13;
        int posicionYtxt = CargaImagenes.ALTO_PANTALLA / 100 * 4 - 5;
        int posicionXLbl = CargaImagenes.ANCHO_PANTALLA / 100 * 6;
        int posicionYLbl = CargaImagenes.ALTO_PANTALLA / 100;

        /////////////////////////LABEL/////////////////////
        lbl_nombreDocFuente = new CampoLabel("", "V");
        lbl_nombreDocFuente.alinearIzquierda();
        lbl_nombreDocFuente.setBounds(posicionXLbl, posicionYLbl, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_nombreDocFuente);

        lbl_documento = new CampoLabel("Documento:  ", "E");
        lbl_documento.alinearIzquierda();
        lbl_documento.setBounds(posicionXLbl, lbl_nombreDocFuente.getY() + lbl_nombreDocFuente.getHeight(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_documento);

        lbl_numero = new CampoLabel("Número:  ", "E");
        lbl_numero.alinearIzquierda();
        lbl_numero.setBounds(posicionXLbl, lbl_documento.getY() + lbl_documento.getHeight() + 5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_numero);

        lbl_fecha = new CampoLabel("Fecha:  ", "E");
        lbl_fecha.alinearIzquierda();
        lbl_fecha.setBounds(posicionXLbl, lbl_numero.getY() + lbl_numero.getHeight() + 5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_fecha);

        lbl_nit = new CampoLabel("TD:  ", "E");
        lbl_nit.alinearIzquierda();
        lbl_nit.setBounds(posicionXLbl, lbl_fecha.getY() + lbl_fecha.getHeight() + 5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_nit);

        lbl_condiciones = new CampoLabel("Condiciones:  ", "E");
        lbl_condiciones.alinearIzquierda();
        lbl_condiciones.setBounds(posicionXLbl, lbl_nit.getY() + lbl_nit.getHeight() + 5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_condiciones);

        lbl_nombre = new CampoLabel("Tercero:  ", "E");
        lbl_nombre.alinearIzquierda();
        lbl_nombre.setBounds(lbl_documento.getX() * 7 / 2 + lbl_documento.getWidth(), lbl_documento.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_nombre);

        lbl_nombreDin = new CampoLabel("", "V");
        lbl_nombreDin.alinearIzquierda();
        lbl_nombreDin.setBounds(lbl_nombre.getX() + lbl_nombre.getWidth(), lbl_nombre.getY(), CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_nombreDin);

        lbl_ciudad = new CampoLabel("Ciudad:  ", "E");
        lbl_ciudad.alinearIzquierda();
        lbl_ciudad.setBounds(lbl_nombre.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_ciudad);

        lbl_ciudadDin = new CampoLabel("", "V");
        lbl_ciudadDin.alinearIzquierda();
        lbl_ciudadDin.setBounds(lbl_nombreDin.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_ciudadDin);

        lbl_cupoDiario = new CampoLabel("C. Diario:  ", "E");
        lbl_cupoDiario.alinearIzquierda();
        lbl_cupoDiario.setBounds(lbl_nombre.getX(), lbl_ciudad.getY() + lbl_ciudad.getHeight() + 5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_cupoDiario);

        lbl_cupoDiarioDin = new CampoLabel("", "V");
        lbl_cupoDiarioDin.alinearIzquierda();
        lbl_cupoDiarioDin.setBounds(lbl_nombreDin.getX(), lbl_ciudad.getY() + lbl_ciudad.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_cupoDiarioDin);

        lbl_cupoMensual = new CampoLabel("C. Mensual:  ", "E");
        lbl_cupoMensual.alinearIzquierda();
        lbl_cupoMensual.setBounds(lbl_nombre.getX(), lbl_cupoDiario.getY() + lbl_cupoDiario.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_cupoMensual);

        lbl_cupoMensualDin = new CampoLabel("", "V");
        lbl_cupoMensualDin.alinearIzquierda();
        lbl_cupoMensualDin.setBounds(lbl_cupoDiarioDin.getX(), lbl_cupoDiario.getY() + lbl_cupoDiario.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_cupoMensualDin);

        lbl_cupoTotal = new CampoLabel("C. Total:  ", "E");
        lbl_cupoTotal.alinearIzquierda();
        lbl_cupoTotal.setBounds(lbl_nombre.getX(), lbl_cupoMensual.getY() + lbl_cupoMensual.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_cupoTotal);

        lbl_cupoTotalDin = new CampoLabel("", "V");
        lbl_cupoTotalDin.alinearIzquierda();
        lbl_cupoTotalDin.setBounds(lbl_cupoMensualDin.getX(), lbl_cupoMensual.getY() + lbl_cupoMensual.getHeight() + 5, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 2);
        this.add(lbl_cupoTotalDin);

        //////////////////JTEXTFIELD////////////////////////////
        txt_idDocumentoFuente = new CajaDeTexto("G");

        txt_documento = new CajaDeTexto("G", 15);
        txt_documento.setBounds(posicionXTxt, posicionYtxt, CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_documento);

        txt_TipoClienteDocFuente = new CajaDeTexto("G");
        txt_numeracion = new CajaDeTexto("G");
        txt_numeroFijo = new CajaDeTexto("G");
        txt_documentoCierre = new CajaDeTexto("G");
        txt_documentoAntiguo = new CajaDeTexto("G");

        txt_numero = new CajaDeTexto("G", 15);
        txt_numero.setBounds(posicionXTxt, lbl_numero.getY(), CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_numero);

        txt_fecha = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fecha.setBounds(posicionXTxt, lbl_fecha.getY(), CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_fecha);

        txt_idTercero = new CajaDeTexto("G");
        txt_nitAntiguo = new CajaDeTexto("G");

        txt_nit = new CajaDeTexto("G", 50);
        txt_nit.setBounds(posicionXTxt, lbl_nit.getY(), CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_nit);

        txt_condiciones = new CajaDeTexto("G", 500);
        txt_condiciones.setBounds(posicionXTxt, lbl_condiciones.getY(), CargaImagenes.anchoBotonGeneral + CargaImagenes.anchoBotonGeneral / 2, 20);
        this.add(txt_condiciones);

    }

    /**
     * @param metodo que prepara los elementos de registro 2
     */
    public void prepararElementosRegistro2() {

        int posicionXTxt = panel_tablaPrincipal.getX();
        int posicionYTxt = CargaImagenes.ALTO_PANTALLA / 100 * 27;
        int posicionYlbl = CargaImagenes.ALTO_PANTALLA / 100 * 23;

        lbl_codigo = new CampoLabel("Código", "E");
        lbl_codigo.alinearCentro();
        lbl_codigo.setBounds(posicionXTxt, posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaCodigo).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_codigo);

        lbl_descripcion = new CampoLabel("Descripción  ", "E");
        lbl_descripcion.alinearCentro();
        lbl_descripcion.setBounds(lbl_codigo.getX() + lbl_codigo.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_descripcion);

        lbl_empaque = new CampoLabel("Empaque", "E");
        lbl_empaque.alinearCentro();
        lbl_empaque.setBounds(lbl_descripcion.getX() + lbl_descripcion.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_empaque);

        lbl_bodega = new CampoLabel("Bodega", "E");
        lbl_bodega.alinearCentro();
        lbl_bodega.setBounds(lbl_empaque.getX() + lbl_empaque.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaBodega).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_bodega);

        lbl_cantidad = new CampoLabel("Cantidad", "E");
        lbl_cantidad.alinearCentro();
        lbl_cantidad.setBounds(lbl_bodega.getX() + lbl_bodega.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaCantidad).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_cantidad);

        lbl_valorUnitario = new CampoLabel("Valor Unitario  ", "E");
        lbl_valorUnitario.alinearCentro();
        lbl_valorUnitario.setBounds(lbl_cantidad.getX() + lbl_cantidad.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaVunitario).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_valorUnitario);

        lbl_valorTolal = new CampoLabel("Valor Total  ", "E");
        lbl_valorTolal.alinearCentro();
        lbl_valorTolal.setBounds(lbl_valorUnitario.getX() + lbl_valorUnitario.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaVtotal).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_valorTolal);

        txt_idTransaccion = new CajaDeTexto("G");
        txt_idCodigo = new CajaDeTexto("G");

        txt_codigo = new CajaDeTexto("G", 20);
        txt_codigo.setBounds(posicionXTxt, posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaCodigo).getMaxWidth(), 20);
        this.add(txt_codigo);

        txt_descripcion = new CajaDeTexto("G", 20);
        txt_descripcion.setBounds(txt_codigo.getX() + txt_codigo.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).getMaxWidth(), 20);
        this.add(txt_descripcion);
        txt_descripcion.setEnabled(false);

        txt_empaque = new CajaDeTexto("G", 20);
        txt_empaque.setBounds(txt_descripcion.getX() + txt_descripcion.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).getMaxWidth(), 20);
        this.add(txt_empaque);
        txt_empaque.setEnabled(false);

        txt_idBodega = new CajaDeTexto("G", 20);
        txt_bodega = new CajaDeTexto("G", 20);
        txt_bodega.setBounds(txt_empaque.getX() + txt_empaque.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaBodega).getMaxWidth(), 20);
        this.add(txt_bodega);

        txt_cantidad = new CajaDeTexto("N", 20);
        txt_cantidad.setBounds(txt_bodega.getX() + txt_bodega.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaCantidad).getMaxWidth(), 20);
        this.add(txt_cantidad);

        txt_ValorUnitario = new CajaDeTexto("M", 20);
        txt_ValorUnitario.setBounds(txt_cantidad.getX() + txt_cantidad.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaVunitario).getMaxWidth(), 20);
        this.add(txt_ValorUnitario);

        txt_valorTotal = new CajaDeTexto("M", 20);
        txt_valorTotal.setBounds(txt_ValorUnitario.getX() + txt_ValorUnitario.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaVtotal).getMaxWidth(), 20);
        txt_valorTotal.setEnabled(false);
        this.add(txt_valorTotal);
    }

    /**
     * metodo que prepara la tabla de principal
     */
    private void preparaElementosTablaPrincipal() {

        panel_tablaPrincipal = new JPanel();
        panel_tablaPrincipal.setBounds(CargaImagenes.ANCHO_PANTALLA / 40, CargaImagenes.ALTO_PANTALLA / 40 * 12, (CargaImagenes.ANCHO_PANTALLA / 40) * 38, CargaImagenes.ALTO_PANTALLA / 40 * 12);
        panel_tablaPrincipal.setLayout(null);
        panel_tablaPrincipal.setBorder(null);
        panel_tablaPrincipal.setOpaque(false);
        //panel_tablaPrincipal.setBackground(Color.red);
        this.add(panel_tablaPrincipal);

        dtmTablaPrincipal = new TablaNoEditable();
        tablaPrincipal = new JTable(dtmTablaPrincipal);
        dtmTablaPrincipal.addColumn("Código");//0
        dtmTablaPrincipal.addColumn("Descripción");//1
        dtmTablaPrincipal.addColumn("Empaque");//2
        dtmTablaPrincipal.addColumn("Bodega");//3
        dtmTablaPrincipal.addColumn("Cantidad");//4
        dtmTablaPrincipal.addColumn("Valor Unitario");//5
        dtmTablaPrincipal.addColumn("Valor Total");//6
        dtmTablaPrincipal.addColumn("idBodega");//7

        tablaPrincipal.setPreferredScrollableViewportSize(new Dimension(CargaImagenes.ANCHO_PANTALLA - 80, (CargaImagenes.ALTO_PANTALLA - (CargaImagenes.ALTO_PANTALLA / 6) - (CargaImagenes.ALTO_PANTALLA / 4)) - 80));
        scrollpanePrincipal = new JScrollPane(tablaPrincipal);
        tablaPrincipal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        panel_tablaPrincipal.add(scrollpanePrincipal);
        scrollpanePrincipal.setSize(panel_tablaPrincipal.getWidth(), panel_tablaPrincipal.getHeight());
        scrollpanePrincipal.setLocation(0, 0);
        tablaPrincipal.getTableHeader().setReorderingAllowed(false);

        tablaPrincipal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaPrincipal.setDefaultRenderer(Object.class, new Tabla.MiRender());
        tablaPrincipal.setShowHorizontalLines(false);
        tablaPrincipal.setBorder(null);
        tablaPrincipal.setOpaque(false);
        scrollpanePrincipal.setOpaque(false);
        scrollpanePrincipal.getViewport().setOpaque(false);
        scrollpanePrincipal.setBorder(null);
        tablaPrincipal.getTableHeader().setPreferredSize(new Dimension(10000, 32));

        //int columna1=ANCHO_PANTALLA/130;
        int columna1 = CargaImagenes.ANCHO_PANTALLA / 24;

        tablaPrincipal.getColumnModel().getColumn(columnaidBodega).setMaxWidth(0);
        tablaPrincipal.getColumnModel().getColumn(columnaidBodega).setMinWidth(0);
        tablaPrincipal.getColumnModel().getColumn(columnaidBodega).setPreferredWidth(0);

        tablaPrincipal.getColumnModel().getColumn(columnaCodigo).setMaxWidth(columna1 * 3);
        tablaPrincipal.getColumnModel().getColumn(columnaCodigo).setMinWidth(columna1 * 1);
        tablaPrincipal.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(columna1 * 3);

        tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).setMaxWidth(columna1 * 8);
        tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).setMinWidth(columna1 * 4);
        tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).setPreferredWidth(columna1 * 8);

        tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).setMaxWidth(columna1 * 3 / 2);
        tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).setMinWidth(columna1 / 2);
        tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).setPreferredWidth(columna1 * 3 / 2);

        tablaPrincipal.getColumnModel().getColumn(columnaBodega).setMaxWidth(columna1 * 3 / 2);
        tablaPrincipal.getColumnModel().getColumn(columnaBodega).setMinWidth(columna1 / 2);
        tablaPrincipal.getColumnModel().getColumn(columnaBodega).setPreferredWidth(columna1 * 3 / 2);

        tablaPrincipal.getColumnModel().getColumn(columnaCantidad).setMaxWidth(columna1 * 2);
        tablaPrincipal.getColumnModel().getColumn(columnaCantidad).setMinWidth(columna1);
        tablaPrincipal.getColumnModel().getColumn(columnaCantidad).setPreferredWidth(columna1 * 2);

        tablaPrincipal.getColumnModel().getColumn(columnaVunitario).setMaxWidth(columna1 * 3);
        tablaPrincipal.getColumnModel().getColumn(columnaVunitario).setMinWidth(columna1);
        tablaPrincipal.getColumnModel().getColumn(columnaVunitario).setPreferredWidth(columna1 * 3);

        tablaPrincipal.getColumnModel().getColumn(columnaVtotal).setMaxWidth(columna1 * 4);
        tablaPrincipal.getColumnModel().getColumn(columnaVtotal).setMinWidth(columna1 * 2);
        tablaPrincipal.getColumnModel().getColumn(columnaVtotal).setPreferredWidth(columna1 * 4);

    }

    /**
     * metodo que prepara los botones secundarios
     */
    public void preparaElementosBotones2() {

        int anchoBotonB = CargaImagenes.anchoBotonMini;
        int altoBotonB = CargaImagenes.altoBotonMini;

        int posicionXBtn = CargaImagenes.ANCHO_PANTALLA / 100;
        int posicionYBtn = CargaImagenes.ALTO_PANTALLA / 100 * 63;

        int posicionXLbl = CargaImagenes.ANCHO_PANTALLA / 150;
        int posicionYLbl = CargaImagenes.ALTO_PANTALLA / 100 * 68;

        lbl_adicionar = new CampoLabel("Adicionar", "E");
        lbl_adicionar.alinearIzquierda();
        lbl_adicionar.setBounds(posicionXLbl, posicionYLbl, CargaImagenes.anchoBotonGeneral * 2 / 3, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_adicionar);

        lbl_guardarMv = new CampoLabel("Guardar", "E");
        lbl_guardarMv.alinearDerecha();
        lbl_guardarMv.setBounds(posicionXLbl - 5, posicionYLbl, CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        lbl_guardarMv.setVisible(false);
        this.add(lbl_guardarMv);

        lbl_borrar = new CampoLabel("Borrar", "E");
        lbl_borrar.alinearCentro();
        lbl_borrar.setBounds(lbl_adicionar.getX() + lbl_adicionar.getWidth() - 13, lbl_adicionar.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_borrar);

        lbl_insertar = new CampoLabel("Insertar", "E");
        lbl_insertar.alinearIzquierda();
        lbl_insertar.setBounds(lbl_borrar.getX() + lbl_borrar.getWidth() + 10, lbl_borrar.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_insertar);

        lbl_modificar = new CampoLabel("Modificar", "E");
        lbl_modificar.alinearIzquierda();
        lbl_modificar.setBounds(lbl_insertar.getX() + lbl_insertar.getWidth(), lbl_insertar.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_modificar);

        lbl_cancelarMV = new CampoLabel("Cancelar", "E");
        lbl_cancelarMV.alinearIzquierda();
        lbl_cancelarMV.setBounds(lbl_insertar.getX() + lbl_insertar.getWidth(), lbl_modificar.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        lbl_cancelarMV.setVisible(false);
        this.add(lbl_cancelarMV);

        lbl_repetir = new CampoLabel("Repetir", "E");
        lbl_repetir.alinearIzquierda();
        lbl_repetir.setBounds(lbl_modificar.getX() + lbl_modificar.getWidth(), lbl_cancelarMV.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_repetir);
        lbl_repetir.setVisible(false);

        btn_adicionar = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "A");
        this.add(btn_adicionar);
        btn_adicionar.setToolTipText("adicionar");
        btn_adicionar.setLocation(posicionXBtn, posicionYBtn);
        btn_adicionar.setSize(anchoBotonB, altoBotonB);

        btn_guardarMv = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "G");
        this.add(btn_guardarMv);
        btn_guardarMv.setToolTipText("adicionar");
        btn_guardarMv.setLocation(posicionXBtn, posicionYBtn);
        btn_guardarMv.setSize(anchoBotonB, altoBotonB);
        btn_guardarMv.setVisible(false);

        btn_borrar2 = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "B");
        this.add(btn_borrar2);
        btn_borrar2.setToolTipText("borrar2");
        btn_borrar2.setLocation(btn_adicionar.getX() + btn_adicionar.getWidth() + 10, btn_adicionar.getY());
        btn_borrar2.setSize(anchoBotonB, altoBotonB);

        btn_insertar = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "I");
        this.add(btn_insertar);
        btn_insertar.setToolTipText("insertar");
        btn_insertar.setLocation(btn_borrar2.getX() + btn_borrar2.getWidth() + 10, btn_borrar2.getY());
        btn_insertar.setSize(anchoBotonB, altoBotonB);

        btn_modificar = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "M");
        this.add(btn_modificar);
        btn_modificar.setToolTipText("Modificar");
        btn_modificar.setLocation(btn_insertar.getX() + btn_insertar.getWidth() + 10, btn_insertar.getY());
        btn_modificar.setSize(anchoBotonB, altoBotonB);

        btn_cancelarMv = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "C");
        this.add(btn_cancelarMv);
        btn_cancelarMv.setToolTipText("Cancelar");
        btn_cancelarMv.setLocation(btn_insertar.getX() + btn_insertar.getWidth() + 10, btn_modificar.getY());
        btn_cancelarMv.setSize(anchoBotonB, altoBotonB);
        btn_cancelarMv.setVisible(false);

        btn_repetir = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "R");
        this.add(btn_repetir);
        btn_repetir.setToolTipText("Repetir");
        btn_repetir.setLocation(btn_modificar.getX() + btn_modificar.getWidth() + 10, btn_cancelarMv.getY());
        btn_repetir.setSize(anchoBotonB, altoBotonB);
        btn_repetir.setVisible(false);

    }

    /**
     * metod que prepara los objetos del total
     */
    public void preparaElementosBotones() {

        int posicionXLbl = CargaImagenes.ANCHO_PANTALLA / 100 * 53;
        int posicionYLbl = CargaImagenes.ALTO_PANTALLA / 100 * 65;
        int anchoBotonA = CargaImagenes.anchoBotonGeneral;
        int altoBotonA = CargaImagenes.altoBotonGeneral;
        int posicionXbtn = CargaImagenes.ANCHO_PANTALLA / 100 * 57;
        int posicionYbtn = CargaImagenes.ALTO_PANTALLA / 100 * 87;

        lbl_descripcionItem = new CampoLabel("Descripciòn de Item: ", "E");
        lbl_descripcionItem.alinearIzquierda();
        lbl_descripcionItem.setBounds(posicionXLbl, posicionYLbl, CargaImagenes.anchoBotonGeneral * 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_descripcionItem);

        lbl_observaciones = new CampoLabel("Observaciones: ", "E");
        lbl_observaciones.alinearIzquierda();
        lbl_observaciones.setBounds(posicionXLbl, lbl_descripcionItem.getY() + lbl_descripcionItem.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_observaciones);

        lbl_grupoProducto = new CampoLabel("Grupo Producto:  ", "E");
        lbl_grupoProducto.alinearIzquierda();
        lbl_grupoProducto.setBounds(posicionXLbl, lbl_observaciones.getY() + lbl_observaciones.getHeight() * 2, CargaImagenes.anchoBotonGeneral * 3 / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_grupoProducto);
        lbl_grupoProducto.setVisible(false);

        lbl_grupoProductoResultado = new CampoLabel("", "V");
        lbl_grupoProductoResultado.alinearIzquierda();
        lbl_grupoProductoResultado.setBounds(lbl_grupoProducto.getX() + lbl_grupoProducto.getWidth(), lbl_grupoProducto.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_grupoProductoResultado);

        lbl_numeroItems = new CampoLabel("Numero Items:  ", "E");
        lbl_numeroItems.alinearIzquierda();;
        lbl_numeroItems.setBounds(posicionXLbl, lbl_grupoProducto.getY() + lbl_grupoProducto.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_numeroItems);
        lbl_numeroItems.setVisible(false);

        lbl_numeroItemsResultado = new CampoLabel("", "V");
        lbl_numeroItemsResultado.alinearIzquierda();
        lbl_numeroItemsResultado.setBounds(lbl_grupoProductoResultado.getX(), lbl_numeroItems.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_numeroItemsResultado);

        lbl_numeroArticulos = new CampoLabel("Numero de Articulos:  ", "E");
        lbl_numeroArticulos.alinearIzquierda();
        lbl_numeroArticulos.setBounds(posicionXLbl, lbl_numeroItems.getY() + lbl_numeroItems.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_numeroArticulos);
        lbl_numeroArticulos.setVisible(false);

        lbl_numeroArticuloResultados = new CampoLabel("", "V");
        lbl_numeroArticuloResultados.alinearIzquierda();
        lbl_numeroArticuloResultados.setBounds(lbl_grupoProductoResultado.getX(), lbl_numeroArticulos.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_numeroArticuloResultados);

        lbl_grupoContable = new CampoLabel("Grupo Contable:  ", "E");
        lbl_grupoContable.alinearIzquierda();
        lbl_grupoContable.setBounds(posicionXLbl, lbl_numeroArticulos.getY() + lbl_numeroArticulos.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_grupoContable);
        lbl_grupoContable.setVisible(false);

        lbl_grupoContableResultado = new CampoLabel("", "V");
        lbl_grupoContableResultado.alinearIzquierda();
        lbl_grupoContableResultado.setBounds(lbl_grupoProductoResultado.getX(), lbl_grupoContable.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_grupoContableResultado);

        lbl_descuento = new CampoLabel("Descuento:", "E");
        lbl_descuento.alinearIzquierda();
        lbl_descuento.setBounds(lbl_descripcionItem.getX() * 3 / 2 + lbl_descripcionItem.getWidth() / 3, posicionYLbl, 555, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_descuento);
        lbl_descuento.setVisible(false);

        lbl_subtotal = new CampoLabel("Subtotal:", "E");
        lbl_subtotal.alinearIzquierda();
        lbl_subtotal.setBounds(lbl_descuento.getX(), lbl_descuento.getY() + lbl_descuento.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_subtotal);
        lbl_subtotal.setVisible(false);

        lbl_iva = new CampoLabel("I.V.A.:", "E");
        lbl_iva.alinearIzquierda();
        lbl_iva.setBounds(lbl_subtotal.getX(), lbl_subtotal.getY() + lbl_subtotal.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_iva);
        lbl_iva.setVisible(false);

        lbl_retenciones = new CampoLabel("Retenciones:", "E");
        lbl_retenciones.alinearIzquierda();
        lbl_retenciones.setBounds(lbl_iva.getX(), lbl_iva.getY() + lbl_iva.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_retenciones);
        lbl_retenciones.setVisible(false);

        lbl_total = new CampoLabel("Total:", "E");
        lbl_total.alinearIzquierda();
        lbl_total.setBounds(lbl_retenciones.getX(), lbl_retenciones.getY() + lbl_retenciones.getHeight() + 6, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_total);

        lbl_descuentoPorcentaje = new CampoLabel("", "V");
        lbl_descuentoPorcentaje.setBounds(lbl_descuento.getX() + CargaImagenes.anchoBotonGeneral / 4, lbl_descuento.getY(), CargaImagenes.anchoBotonGeneral / 5 * 4, 20);
        lbl_descuentoPorcentaje.alinearIzquierda();
        this.add(lbl_descuentoPorcentaje);

        lbl_descuentoValor = new CampoLabel("", "V");
        lbl_descuentoValor.setBounds(lbl_descuento.getX() + lbl_descuento.getWidth() / 5, lbl_descuento.getY(), CargaImagenes.anchoBotonGeneral / 5 * 4, 20);
        lbl_descuentoValor.alinearDerecha();
        this.add(lbl_descuentoValor);

        lbl_subtotalResultado = new CampoLabel("", "V");
        lbl_subtotalResultado.alinearIzquierda();
        lbl_subtotalResultado.setBounds(lbl_descuentoValor.getX(), lbl_subtotal.getY(), CargaImagenes.anchoBotonGeneral / 5 * 4, 20);
        this.add(lbl_subtotalResultado);

        lbl_ivaResultado = new CampoLabel("", "V");
        lbl_ivaResultado.setBounds(lbl_subtotalResultado.getX(), lbl_iva.getY(), CargaImagenes.anchoBotonGeneral / 5 * 4, 20);
        lbl_ivaResultado.alinearIzquierda();
        this.add(lbl_ivaResultado);

        lbl_retencionesResul = new CampoLabel("", "V");
        lbl_retencionesResul.setBounds(lbl_ivaResultado.getX(), lbl_retenciones.getY(), CargaImagenes.anchoBotonGeneral / 5 * 4, 20);
        lbl_retencionesResul.alinearDerecha();
        this.add(lbl_retencionesResul);

        lbl_totalResultados = new CampoLabel("", "V");
        lbl_totalResultados.alinearDerecha();
        lbl_totalResultados.setBounds(lbl_retencionesResul.getX(), lbl_total.getY(), CargaImagenes.anchoBotonGeneral / 5 * 4, 20);
        this.add(lbl_totalResultados);

        txt_descripcionItem = new CajaDeTexto("G", 500);
        txt_descripcionItem.setBounds(lbl_grupoProductoResultado.getX(), lbl_descripcionItem.getY(), CargaImagenes.anchoBotonGeneral / 5 * 7, 20);
        this.add(txt_descripcionItem);
        txt_descripcionItem.setEnabled(false);

        txt_observaciones = new CajaDeTexto("G", 500);
        txt_observaciones.setBounds(lbl_grupoProductoResultado.getX(), lbl_observaciones.getY(), CargaImagenes.anchoBotonGeneral / 5 * 7, 20);
        this.add(txt_observaciones);

        btn_grabar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Expendio");
        btn_grabar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_grabar);
        btn_grabar.setToolTipText("Expendio");
        btn_grabar.setLocation(posicionXbtn, posicionYbtn);
        btn_grabar.setSize(anchoBotonA, altoBotonA);

        btn_borrar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Borrar");
        btn_borrar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_borrar);
        btn_borrar.setToolTipText("borrar");
        btn_borrar.setLocation(btn_grabar.getX() + btn_grabar.getWidth() + 5, btn_grabar.getY());
        btn_borrar.setSize(anchoBotonA, altoBotonA);
        btn_borrar.setVisible(false);

        btn_buscar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Buscar");
        btn_buscar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_buscar);
        btn_buscar.setToolTipText("buscar");
        btn_buscar.setLocation(btn_borrar.getX() + btn_borrar.getWidth() + 5, btn_borrar.getY());
        btn_buscar.setSize(anchoBotonA, altoBotonA);
        btn_buscar.setVisible(false);

        btn_cancelar = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Cancelar");
        btn_cancelar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_cancelar);
        btn_cancelar.setToolTipText("cancelar");
        btn_cancelar.setLocation(btn_borrar.getX() + btn_borrar.getWidth() + 5, btn_buscar.getY());
        btn_cancelar.setSize(anchoBotonA, altoBotonA);
        btn_cancelar.setVisible(false);

        btn_plantilla = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Plantilla");
        btn_plantilla.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_plantilla);
        btn_plantilla.setToolTipText("plantilla");
        btn_plantilla.setLocation(btn_cancelar.getX() + btn_cancelar.getWidth(), btn_cancelar.getY());
        btn_plantilla.setSize(anchoBotonA, altoBotonA);
        btn_plantilla.setVisible(false);

        btn_otros = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Otro");
        btn_otros.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_otros);
        btn_otros.setToolTipText("Otro");
        btn_otros.setLocation(btn_grabar.getX(), btn_grabar.getY() + btn_grabar.getHeight() + 5);
        btn_otros.setSize(anchoBotonA, altoBotonA);
        btn_otros.setEnabled(false);
        btn_otros.setVisible(false);

        btn_imprimir = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Reporte");
        btn_imprimir.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_imprimir);
        btn_imprimir.setToolTipText("imprimir");
        btn_imprimir.setLocation(btn_borrar.getX(), btn_borrar.getY() + btn_borrar.getHeight() + 5);
        btn_imprimir.setSize(anchoBotonA, altoBotonA);
        btn_imprimir.setEnabled(false);
        btn_imprimir.setVisible(false);

        btn_inicial = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Inicial");
        btn_inicial.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_inicial);
        btn_inicial.setToolTipText("inicial");
        btn_inicial.setLocation(btn_buscar.getX(), btn_buscar.getY() + btn_buscar.getHeight() + 5);
        btn_inicial.setSize(anchoBotonA, altoBotonA);
        btn_inicial.setVisible(false);

        btn_salir = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Salir");
        btn_salir.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_salir);
        btn_salir.setToolTipText("Salir");
//		btn_salir.setLocation(btn_plantilla.getX(), btn_plantilla.getY()+btn_plantilla.getHeight()+5);  
        btn_salir.setLocation(btn_borrar.getX(), btn_borrar.getY());
        btn_salir.setSize(anchoBotonA, altoBotonA);

    }

    /**
     * metodo que prepara la tabla de documentos fuente
     */
    public void preparaElementosDocumentosFuente() {
        tablaDocumentos = new GUITablaDocumentos(CargaImagenes.ANCHO_PANTALLA / 40, (CargaImagenes.ALTO_PANTALLA / 25) * 17, CargaImagenes.ANCHO_PANTALLA / 2 - (CargaImagenes.ANCHO_PANTALLA / 17), CargaImagenes.ALTO_PANTALLA / 4);
        this.add(tablaDocumentos);
    }

    /**
     */
    public void prepareElementosTablaTerceros() {
        tablaTerceros = new GUITablaInternos(CargaImagenes.ANCHO_PANTALLA / 40, (CargaImagenes.ALTO_PANTALLA / 25) * 17, CargaImagenes.ANCHO_PANTALLA / 2 - (CargaImagenes.ANCHO_PANTALLA / 17), CargaImagenes.ALTO_PANTALLA / 4);
        this.add(tablaTerceros);
    }

    /**
     */
    public void prepareElementosTablaProducto() {
        tablaProductos = new GUITablaProductos(CargaImagenes.ANCHO_PANTALLA / 40, (CargaImagenes.ALTO_PANTALLA / 25) * 17, CargaImagenes.ANCHO_PANTALLA / 2 - (CargaImagenes.ANCHO_PANTALLA / 17), CargaImagenes.ALTO_PANTALLA / 4);
        this.add(tablaProductos);
    }

    /**
     * metodo que prepara la tabla de Bodega
     */
    public void preparaElementosTablaBodega() {
        tablaBodegas = new GUITablaBodegas(CargaImagenes.ANCHO_PANTALLA / 40, (CargaImagenes.ALTO_PANTALLA / 25) * 17, CargaImagenes.ANCHO_PANTALLA / 2 - (CargaImagenes.ANCHO_PANTALLA / 17), CargaImagenes.ALTO_PANTALLA / 4);
        this.add(tablaBodegas);
    }

    /**
     * metodo que carga las bodegas
     */
    private void cargarBodegas() {
        tablaBodegas.cargarDatosBasicos(usuario);
    }

    private void cargarDatosDocFuente() {
        tablaDocumentos.cargarDatosBasicos(usuario);
    }

    private void cargarTerceros() {
        tablaTerceros.cargarDatosBasicos(usuario);
    }

    private void cargarDatosProductos() {
        tablaProductos.cargarDatosBasicos(usuario);
    }

    private void cargarDatosPrincipal() {
        deshacerFiltroPrincipal();
        Tabla.eliminarFilasTabla(dtmTablaPrincipal);

        PersistenciaTransaccionInt persistencia = Servicios.transaccionController.transaccionRepository;

        ArrayList<TransaccionItem> items = persistencia.consultarTodoItems(transaccion);

        for (TransaccionItem item : items) {
            System.out.println("ENtro");
            String[] datosFila = new String[dtmTablaPrincipal.getColumnCount()];

            datosFila[0] = String.valueOf(item.getProducto().getCodigo());

            datosFila[1] = item.getProducto().getNombre();
            datosFila[2] = item.getProducto().getPresentacion();
            String codigoBodega = "";
            if (item.getBodega() != null) {
                codigoBodega = item.getBodega().getCodigo();
            }
            datosFila[3] = codigoBodega;
            datosFila[4] = Formatos.formatearNumeroAgregaDecimalesString(String.valueOf(item.getCantidad()));
            datosFila[5] = Formatos.formatearValorString(String.valueOf(item.getValorUnitario()));
            datosFila[6] = Formatos.formatearValorString(String.valueOf(item.getValorUnitario() * item.getCantidad()));
            long idBodega = 0;
            if (item.getBodega() != null) {
                idBodega = item.getBodega().getId();
            }
            datosFila[7] = String.valueOf(idBodega);

            dtmTablaPrincipal.addRow(datosFila);
        }
    }

    /**
     * metodo que limpia los campos del registro MV
     */
    public void limpiarCamposRegistroMv(boolean limpiarCodigo) {
        txt_descripcionItem.setEnabled(false);
        if (limpiarCodigo) {
            txt_codigo.setText("");
        }
        txt_idCodigo.setText("");
        txt_descripcion.setText("");
        txt_empaque.setText("");
        txt_bodega.setText("");
        txt_idBodega.setText("");
        txt_cantidad.setText("");
        txt_ValorUnitario.setText("");
        txt_valorTotal.setText("");
        txt_descripcionItem.setText("");
        tablaPrincipal.updateUI();
    }

    /**
     * metodo que limpia los campos enlazados al doc fuente
     */
    public void limpiarValoresDocumentoFuente() {
        txt_documento.setText("");
        txt_documentoCierre.setText("");
        txt_documentoAntiguo.setText("");
        txt_idDocumentoFuente.setText("");
        txt_numeracion.setText("");
        txt_numero.setText("");
        txt_numeroFijo.setText("");
        lbl_nombreDocFuente.setText("");
        txt_fecha.setEnabled(true);

    }

    /**
     * limpia los campos de la transaccion general
     */
    public void limpiarValoresTransaccionTemporal() {
        limpiarValoresDocumentoFuente();
        txt_fecha.setValue("");
        txt_nit.setText("");
        txt_nitAntiguo.setText("");
        txt_idTercero.setText("");
        lbl_nombreDin.setText("");
        lbl_cupoDiarioDin.setText("");
        lbl_cupoMensualDin.setText("");
        lbl_ciudadDin.setText("");
        lbl_cupoTotalDin.setText("");
        txt_condiciones.setText("");
        txt_numero.setText("");
//		txt_numero.setEnabled(true);
//		validarEnabletxtNumerFijo();
        lbl_numeroItemsResultado.setText("");
        lbl_numeroArticuloResultados.setText("");

        lbl_subtotalResultado.setText("");
        lbl_totalResultados.setText("");
        lbl_descuentoPorcentaje.setText("");
        lbl_descuentoValor.setText("");
        txt_observaciones.setText("");
        lbl_ivaResultado.setText("");
        lbl_retencionesResul.setText("");
        lbl_grupoProductoResultado.setText("");
        lbl_grupoContableResultado.setText("");
        //lbl_creePorcentajeReten.setText("");
        //lbl_creeValorReten.setText("");

        txt_idTransaccion.setText("");
    }

    /**
     *
     */
    private String validarDocumentoFuente(String parametro) {
        PersistenciaDocFuenteInt persistencia = Servicios.documentosController.documentosRepository;

        DocumentoFuente documento;

        documento = persistencia.consultarPorCodigo(parametro);
        if (documento == null) {
            documento = persistencia.consultarPorNombre(parametro);
        }
        if (documento == null) {
            return "NOEXISTE";
        } else {
            txt_documento.setText(documento.getCodigo());
            txt_idDocumentoFuente.setText(documento.getId().toString());
            lbl_nombreDocFuente.setText(documento.getNombre());
            return "VALIDO";
        }
    }

    private String validarBodega(String parametro) {
        PersistenciaBodegaInt persistencia = Servicios.bodegasController.bodegasRepository;

        Bodega bodega;

        bodega = persistencia.consultarPorCodigo(parametro);
        if (bodega == null) {
            bodega = persistencia.consultarPorNombre(parametro);
        }
        if (bodega == null) {
            return "NOEXISTE";
        } else {
            txt_bodega.setText(bodega.getCodigo());
            txt_idBodega.setText(bodega.getId().toString());
            return "VALIDO";
        }
    }

    private String validarTercero(String parametro) {
        PersistenciaInternoInt persistencia = Servicios.internosController.internosRepository;

        Interno interno;

        interno = persistencia.consultarPorTd(parametro);
        if (interno == null) {
            interno = persistencia.consultarPorNui(parametro);
        }
        if (interno == null) {
            return "NOEXISTE";
        } else {
            txt_nit.setText(interno.getTd());
            txt_idTercero.setText(interno.getId().toString());
            lbl_nombreDin.setText(interno.getPrimerApellido() + " " + interno.getSegundoApellido() + " " + interno.getPrimerNombre() + " " + interno.getSegundoNombre());
            lbl_ciudadDin.setText(interno.getNacionalidad());
            lbl_cupoDiarioDin.setText(Formatos.formatearValorDecimalesString(interno.traerSaldoDiarioDisponibleValidado() + "", DatosGeneralesPrograma.cantidadDecimalesMoneda));
            lbl_cupoMensualDin.setText(Formatos.formatearValorDecimalesString(interno.traerSaldoMensualDisponibleValidado() + "", DatosGeneralesPrograma.cantidadDecimalesMoneda));
            lbl_cupoTotalDin.setText(Formatos.formatearValorDecimalesString(interno.getSaldoDisponible() + "", DatosGeneralesPrograma.cantidadDecimalesMoneda));
            return "VALIDO";
        }
    }

    private String validarProducto(String parametro) {
        PersistenciaProductoInt persistencia = Servicios.productosController.productosRepository;

        Producto producto;

        producto = persistencia.consultarPorCodigo(parametro);
        if (producto == null) {
            producto = persistencia.consultarPorNombre(parametro);
        }
        if (producto == null) {
            return "NOEXISTE";
        } else {
            txt_codigo.setText(producto.getCodigo());
            txt_idCodigo.setText(producto.getId().toString());
            return "VALIDO";
        }
    }

    /**
     * metodo que contiene la accion del boton borrar
     */
    private void accionBotonBorrar() {
        limpiarCamposRegistroMv(true);
        limpiarValoresDocumentoFuente();
        Tabla.eliminarFilasTabla(dtmTablaPrincipal);
        limpiarValoresTransaccionTemporal();
        ocultarPaneles();
        txt_documento.grabFocus();

    }

    /**
     * metodo que contiene la accion de los botones
     */
    private void accionBotones() {
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonSalir();
            }
        });

        btn_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonBorrar();
            }
        });

        btn_adicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionAdicionarItem();
            }
        });

        btn_grabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionGrabar();
            }
        });
    }

    /**
     *
     */
    private void accionCajaTexto() {
        txt_documento.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (tablaDocumentos.tabla.getRowCount() >= 1) {
                            tablaDocumentos.grabFocus();
                        } else {
                            txt_documento.setText("");
                            txt_idDocumentoFuente.setText("");
                            lbl_nombreDocFuente.setText("");
                            deshacerFiltroDocFuente();
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El documento fuente no existe.", "Inténtelo de nuevo.");
                            txt_documento.grabFocus();
                        }
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        lbl_nombreDocFuente.setText("");
                        txt_nit.setText("");
                        /////////pendiente
                        txt_llevaBodegaDocFuente.setText("");
                        txt_idBodegaDocFuente.setText("");
                        txt_accionSobreInventario.setText("");
                        limpiarCamposRegistroMv(true);
                        txt_nit.setEnabled(false);
                        txt_ValorUnitario.setEnabled(true);
                        txt_listaPrecioDoc.setText("");
                        txt_interfaceDocFuente.setText("");
                        txt_cuentasPorCobrar.setText("");
                        txt_cuentasPorPagar.setText("");
                        txt_esAutoRete.setText("");
                        txt_fecha.setText("");
                        tablaDocumentos.aplicarFiltro(txt_documento);
                        break;
                    case KeyEvent.VK_ENTER:
                        if (!txt_numero.isEnabled()) {
                            txt_fecha.grabFocus();
                        } else {
                            txt_numero.grabFocus();
                        }
                        break;
                    default:
                        tablaDocumentos.aplicarFiltro(txt_documento);
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        txt_documento.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!txt_documento.getText().trim().isEmpty()) {
                    if (txt_documento.getText().trim().equalsIgnoreCase(txt_documentoAntiguo.getText().trim())) {
                    } else if (!tablaDocumentos.tabla.isRowSelected(tablaDocumentos.tabla.getSelectedRow())) {
                        String valido = validarDocumentoFuente(txt_documento.getText());
                        if (valido.equalsIgnoreCase("NOEXISTE")) {
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El documento fuente no existe o este usuario no tiene permiso para usarlo.", "Inténtelo de nuevo.");
                            txt_documento.setText("");
                            txt_idDocumentoFuente.setText("");
                            lbl_nombreDocFuente.setText("");
                            deshacerFiltroDocFuente();
                            txt_documento.grabFocus();
                        } else if (valido.equalsIgnoreCase("VALIDO")) {
                            txt_numero.setText(asignarNumeroConsecutivo(usuario, false));
                            if (txt_numero.isEnabled()) {
                                txt_numero.grabFocus();
                            } else {
                                txt_fecha.grabFocus();
                            }
                            calcularValorTotalTabla();
                        }
                    }
                } else {
                    limpiarValoresDocumentoFuente();
                    txt_numero.setEnabled(true);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                ocultarPaneles();
                tablaDocumentos.setVisible(true);
                if (!txt_documento.getText().trim().isEmpty()) {
                    tablaDocumentos.aplicarFiltro(txt_documento);
                }

            }
        });

        ValidacionCampos.asignarTeclasDireccion2(txt_numero, txt_documento, txt_fecha, null, null);
        ValidacionCampos.asignarTeclasDireccion2(txt_fecha, txt_numero, txt_nit, null, null);

        txt_nit.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        txt_fecha.grabFocus();
                        break;
                    case KeyEvent.VK_ENTER:
                        txt_condiciones.grabFocus();
                        break;
                    case KeyEvent.VK_DOWN:
                        if (tablaTerceros.tabla.getRowCount() >= 1) {
                            tablaTerceros.grabFocus();
                        } else {
                            txt_nit.setText("");
                            txt_idTercero.setText("");
                            lbl_nombreDin.setText("");
                            lbl_cupoDiarioDin.setText("");
                            lbl_ciudadDin.setText("");
                            lbl_cupoDiarioDin.setText("");
                            lbl_cupoMensualDin.setText("");
                            lbl_cupoTotalDin.setText("");
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El tercero no existe.", "Inténtelo de nuevo.");
                            txt_nit.grabFocus();
                        }
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        limpiarCamposRegistroMv(true);
                        txt_idTercero.setText("");
                        lbl_nombreDin.setText("");
                        lbl_cupoDiarioDin.setText("");
                        lbl_cupoMensualDin.setText("");
                        lbl_cupoTotalDin.setText("");
                        lbl_ciudadDin.setText("");
                        tablaTerceros.aplicarFiltro(txt_nit);
                        break;
                    default:
                        tablaTerceros.aplicarFiltro(txt_nit);
                        break;
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        txt_nit.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!txt_nit.getText().trim().isEmpty()) {
                    if (txt_nit.getText().trim().equalsIgnoreCase(txt_nitAntiguo.getText().trim())) {
                    } else if (!tablaTerceros.tabla.isRowSelected(tablaTerceros.tabla.getSelectedRow())) {
                        String valido = validarTercero(txt_nit.getText().trim());
                        if (valido.equalsIgnoreCase("NOEXISTE")) {
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El tercero no existe.", "Inténtelo de nuevo.");
                            txt_nit.setText("");
                            txt_idTercero.setText("");
                            lbl_nombreDin.setText("");
                            lbl_ciudadDin.setText("");
                            lbl_cupoDiarioDin.setText("");
                            lbl_cupoMensualDin.setText("");
                            lbl_cupoTotalDin.setText("");
                            txt_nit.grabFocus();
                            deshacerFiltroTercero();
                        } else if (valido.equalsIgnoreCase("ERROR2")) {
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Ha ocurrido un error.", "Inténtelo de nuevo.");
                            txt_nit.setText("");
                            txt_idTercero.setText("");
                            lbl_nombreDin.setText("");
                            lbl_cupoDiarioDin.setText("");
                            lbl_cupoMensualDin.setText("");
                            lbl_cupoTotalDin.setText("");
                            lbl_ciudadDin.setText("");
                            deshacerFiltroTercero();
                            txt_nit.grabFocus();
                        } else {
                            deshacerFiltroTercero();
                        }
                    }
                } else {
                    txt_nitAntiguo.setText("");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                ocultarPaneles();
                tablaTerceros.setVisible(true);
                if (!txt_nit.getText().trim().isEmpty()) {
                    tablaTerceros.aplicarFiltro(txt_nit);
                }
            }
        });

        ValidacionCampos.asignarTeclasDireccion2(txt_condiciones, txt_nit, txt_codigo, null, null);

        txt_codigo.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (!btn_cancelar.isVisible()) {
                            if (tablaProductos.tabla.getRowCount() >= 1) {
                                tablaProductos.grabFocus();
                            } else {
                                txt_idCodigo.setText("");
                                txt_codigo.setText("");
                                txt_descripcion.setText("");
                                txt_empaque.setText("");
                                deshacerFiltroProducto();
                                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El producto no existe.", "Inténtelo de nuevo.");
                                txt_codigo.grabFocus();
                            }
                        } else if (tablaPrincipal.getRowCount() >= 1) {
                            tablaPrincipal.grabFocus();
                            tablaPrincipal.getSelectionModel().setSelectionInterval(0, 0);
                        }
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        txt_idCodigo.setText("");
                        txt_descripcion.setText("");
                        txt_empaque.setText("");
                        txt_ValorUnitario.setText("");
                        limpiarCamposRegistroMv(false);
                        tablaProductos.aplicarFiltro(txt_codigo);
                        break;
                    case KeyEvent.VK_ENTER:
                        txt_bodega.grabFocus();
                        break;
                }
                if (!btn_cancelar.isVisible()) {
                    tablaProductos.aplicarFiltro(txt_codigo);
                } else {
                    Filtro.filtroUnaColumna(txt_codigo.getText().trim().toUpperCase(), trsFiltrotablaPrincipal, 1, dtmTablaPrincipal, tablaPrincipal);
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        txt_codigo.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!btn_cancelar.isVisible()) {
                    if (!txt_codigo.getText().trim().isEmpty()) {
                        String valido = validarProducto(txt_codigo.getText().trim());
                        if (!tablaProductos.tabla.isRowSelected(tablaProductos.tabla.getSelectedRow())) {
                            if (valido.equalsIgnoreCase("NOEXISTE")) {
                                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El producto no existe.", "Inténtelo de nuevo.");
                                txt_idCodigo.setText("");
                                txt_codigo.setText("");
                                txt_descripcion.setText("");
                                txt_empaque.setText("");
                                txt_descripcionItem.setEnabled(false);
                                deshacerFiltroProducto();
                                txt_codigo.grabFocus();
                            } else if (valido.equalsIgnoreCase("VALIDO")) {
                                txt_descripcionItem.setEnabled(true);
                            } else {

                            }
                        }
                    } else {
                        limpiarCamposRegistroMv(true);
                    }
                } else {

                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (!btn_cancelar.isVisible()) {
                    ocultarPaneles();
                    tablaProductos.setVisible(true);
                    if (!txt_codigo.getText().trim().isEmpty()) {
                        tablaProductos.aplicarFiltro(txt_codigo);
                    } else {
                    }
                } else if (!txt_codigo.getText().trim().isEmpty()) {
                    Filtro.filtroUnaColumna(txt_codigo.getText().trim().toUpperCase(), trsFiltrotablaPrincipal, 1, dtmTablaPrincipal, tablaPrincipal);
                }
            }
        });

        txt_bodega.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if (!btn_cancelar.isVisible()) {
                            if (tablaBodegas.tabla.getRowCount() >= 1) {
                                tablaBodegas.grabFocus();
                            } else {
                                txt_idBodega.setText("");
                                txt_bodega.setText("");
                                deshacerFiltroProducto();
                                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "La bodega no existe.", "Inténtelo de nuevo.");
                                txt_bodega.grabFocus();
                            }
                        } else if (tablaPrincipal.getRowCount() >= 1) {
                            tablaPrincipal.grabFocus();
                            tablaPrincipal.getSelectionModel().setSelectionInterval(0, 0);
                        }
                        break;
                    case KeyEvent.VK_BACK_SPACE:
                        txt_idBodega.setText("");
                        tablaBodegas.aplicarFiltro(txt_bodega);
                        break;
                    case KeyEvent.VK_ENTER:
                        txt_cantidad.grabFocus();
                        break;
                }
                if (!btn_cancelar.isVisible()) {
                    tablaBodegas.aplicarFiltro(txt_bodega);
                } else {
                    Filtro.filtroUnaColumna(txt_bodega.getText().trim().toUpperCase(), trsFiltrotablaPrincipal, 4, dtmTablaPrincipal, tablaPrincipal);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        txt_bodega.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!btn_cancelar.isVisible()) {
                    if (!txt_bodega.getText().trim().isEmpty()) {
                        String valido = validarBodega(txt_bodega.getText().trim());
                        if (!tablaBodegas.tabla.isRowSelected(tablaBodegas.tabla.getSelectedRow())) {
                            if (valido.equalsIgnoreCase("NOEXISTE")) {
                                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "La bodega no existe.", "Inténtelo de nuevo.");
                                txt_idBodega.setText("");
                                txt_bodega.setText("");
                                deshacerFiltroBodega();
                                txt_codigo.grabFocus();
                            } else {
                            }
                        }
                    } else {
                        deshacerFiltroBodega();
                        txt_idBodega.setText("");
                    }
                } else {

                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (!btn_cancelar.isVisible()) {
                    ocultarPaneles();
                    tablaBodegas.setVisible(true);
                    if (!txt_bodega.getText().trim().isEmpty()) {
                        tablaBodegas.aplicarFiltro(txt_bodega);
                    }
                } else if (!txt_bodega.getText().trim().isEmpty()) {
                    Filtro.filtroUnaColumna(txt_bodega.getText().trim().toUpperCase(), trsFiltrotablaPrincipal, 4, dtmTablaPrincipal, tablaPrincipal);
                }
            }
        });

        txt_cantidad.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                txt_cantidad.setText(Formatos.formatearNumeroAgregaDecimalesString(txt_cantidad.getText().trim()));
            }

            @Override
            public void focusGained(FocusEvent e) {

                ocultarPaneles();
                txt_cantidad.setText(Formatos.quitarFormatoDecimalesString(txt_cantidad.getText().trim()));
                calculoValorTotalJtextValorTotal();

                if (!txt_cantidad.getText().isEmpty()) {
                    txt_cantidad.setSelectionStart(0);
                    txt_cantidad.setSelectionEnd(txt_cantidad.getText().length());
                }

            }
        });

        txt_cantidad.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ENTER:
                        txt_ValorUnitario.grabFocus();
                        break;
                }
            }
        });

        txt_ValorUnitario.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                        validar.inicializarSiEstaSeleccionadoNumero(txt_ValorUnitario, e);
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (!btn_cancelar.isVisible()) {

                    } else if (tablaPrincipal.getRowCount() >= 1) {
                        tablaPrincipal.grabFocus();
                        tablaPrincipal.getSelectionModel().setSelectionInterval(0, 0);
                    }
                } else if (e.getKeyCode() == KeyEvent.VK_C) {
//                                String fecha = txt_fecha.getText();
//                                if (fecha.replace(" ", "").replace("/", "").isEmpty()) {
//                                        fecha = "";
//                                }
//                                String preCosto = traerCostoProducto(txt_idCodigo.getText(), fecha);
//                                if (!preCosto.equals("") && !preCosto.equals("ERROR")) {
//                                        txt_ValorUnitario.setText(preCosto);
//                                }

                }
                if (e.getKeyCode() == KeyEvent.VK_N) {
//                                txt_ValorUnitario.setText( Formatos.cambiarValorPesosANegativo(txt_ValorUnitario.getText().trim()));
                } else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btn_adicionar.grabFocus();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
//                        validar.teclasDireccion(e, null, null, ProximoFocoMv(), ProximoFocoMvIzquierda(), txt_ValorUnitario);
            }
        });

        txt_ValorUnitario.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                txt_ValorUnitario.setText(Formatos.formatearValorString(txt_ValorUnitario.getText().trim()));
                calculoValorTotalJtextValorTotal();
            }

            @Override
            public void focusGained(FocusEvent e) {
                ocultarPaneles();
                txt_ValorUnitario.setText(Formatos.quitarFormatoValorString(txt_ValorUnitario.getText().trim()));
                calculoValorTotalJtextValorTotal();

                if (!txt_ValorUnitario.getText().isEmpty()) {
                    txt_ValorUnitario.setSelectionStart(0);
                    txt_ValorUnitario.setSelectionEnd(txt_ValorUnitario.getText().length());
                }
            }
        });

    }

    private void accionTablas() {
        tablaDocumentos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.isMetaDown()) {
                    int fila = tablaDocumentos.tabla.getSelectedRow();

                    if (fila != -1) {
                        txt_documento.setText((String) tablaDocumentos.tabla.getValueAt(fila, GUITablaDocumentos.columnaCodigo));
                        txt_idDocumentoFuente.setText((String) tablaDocumentos.tabla.getValueAt(fila, GUITablaDocumentos.columnaId));
                        lbl_nombreDocFuente.setText((String) tablaDocumentos.tabla.getValueAt(fila, GUITablaDocumentos.columnaNombre));
                        if (!txt_numero.isEnabled()) {
                            txt_numero.grabFocus();
                        } else {
                            txt_fecha.grabFocus();
                        }
                    }
                }

            }

        });

        tablaDocumentos.tabla.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int fila = tablaDocumentos.tabla.getSelectedRow();

                    if (fila != -1) {
                        if (txt_numero.isEnabled()) {
                            txt_numero.grabFocus();
                        } else {
                            txt_fecha.grabFocus();
                        }
                    }

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    int fila = tablaDocumentos.tabla.getSelectedRow();
                    if (fila != -1) {
                        txt_documento.setText((String) tablaDocumentos.tabla.getValueAt(fila, GUITablaDocumentos.columnaCodigo));
                        txt_idDocumentoFuente.setText((String) tablaDocumentos.tabla.getValueAt(fila, GUITablaDocumentos.columnaId));
                        lbl_nombreDocFuente.setText((String) tablaDocumentos.tabla.getValueAt(fila, GUITablaDocumentos.columnaNombre));
                    }
                }

            }
        });

        tablaDocumentos.tabla.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {

                if (!txt_documento.getText().trim().isEmpty()) {
                    if (txt_documento.getText().trim().equalsIgnoreCase(txt_documentoAntiguo.getText().trim())) {
                        //accionCambioDeTerceroDocFuenteEnRetnciones();
                    } else {
                        String valido = validarDocumentoFuente(txt_documento.getText());
                        if (valido.equalsIgnoreCase("NOEXISTE")) {
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El documento fuente no existe o este usuario no tiene permiso para usarlo.", "Inténtelo de nuevo.");
                            txt_documento.setText("");
                            txt_idDocumentoFuente.setText("");
                            lbl_nombreDocFuente.setText("");
                            deshacerFiltroDocFuente();
                            limpiarValoresDocumentoFuente();
                        } else if (valido.equalsIgnoreCase("VALIDO")) {
                            txt_numero.setText(asignarNumeroConsecutivo(usuario, false));
                            if (txt_numero.isEnabled()) {
                                txt_numero.grabFocus();
                            } else {
                                txt_fecha.grabFocus();
                            }
                        }
                    }
                } else {
                    limpiarValoresDocumentoFuente();
                    txt_numero.setEnabled(true);
                }

            }

            @Override
            public void focusGained(FocusEvent e) {

            }
        });

        tablaTerceros.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.isMetaDown()) {
                    int fila = tablaTerceros.tabla.getSelectedRow();

                    if (fila != -1) {
                        txt_nit.setText((String) tablaTerceros.tabla.getValueAt(fila, GUITablaInternos.columnaTD));
                        txt_idTercero.setText((String) tablaTerceros.tabla.getValueAt(fila, GUITablaInternos.columnaId));
                        lbl_nombreDin.setText((String) tablaTerceros.tabla.getValueAt(fila, GUITablaInternos.columnaNombre));
                        txt_condiciones.grabFocus();
                    }
                }
            }
        });
        tablaTerceros.tabla.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int fila = tablaTerceros.tabla.getSelectedRow();

                    if (fila != -1) {
                        txt_nit.setText((String) tablaTerceros.tabla.getValueAt(fila, GUITablaInternos.columnaTD));
                        txt_idTercero.setText((String) tablaTerceros.tabla.getValueAt(fila, GUITablaInternos.columnaId));
                        lbl_nombreDin.setText((String) tablaTerceros.tabla.getValueAt(fila, GUITablaInternos.columnaNombre));
                        txt_condiciones.grabFocus();
                    }
                }
            }
        });

        tablaTerceros.tabla.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {

                if (!txt_nit.getText().trim().isEmpty()) {
                    if (txt_nit.getText().trim().equalsIgnoreCase(txt_nitAntiguo.getText().trim())) {

                    } else {
                        String valido = validarTercero(txt_nit.getText().trim());
                        if (valido.equalsIgnoreCase("NOEXISTE")) {
                            option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El tercero no existe.", "Inténtelo de nuevo.");
                            txt_nit.setText("");
                            txt_idTercero.setText("");
                            lbl_nombreDin.setText("");
                            lbl_cupoDiarioDin.setText("");
                            lbl_cupoMensualDin.setText("");
                            lbl_cupoTotalDin.setText("");
                            lbl_ciudadDin.setText("");
                            txt_nit.grabFocus();
                        } else {
                        }
                    }
                } else {
                    txt_nitAntiguo.setText("");
                }

            }

            @Override
            public void focusGained(FocusEvent e) {

            }
        });

        tablaProductos.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isMetaDown()) {
                    int fila = tablaProductos.tabla.getSelectedRow();
                    if (fila != -1) {
                        txt_codigo.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaCodigo));
                        txt_idCodigo.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaId));
                        txt_descripcion.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaNombre));
                        txt_empaque.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaEmpaque));
                        txt_bodega.grabFocus();
                    }
                }
            }
        });

        tablaProductos.tabla.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int fila = tablaProductos.tabla.getSelectedRow();

                    if (fila != -1) {

                        txt_codigo.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaCodigo));
                        txt_idCodigo.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaId));
                        txt_descripcion.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaNombre));
                        txt_empaque.setText((String) tablaProductos.tabla.getValueAt(fila, GUITablaProductos.columnaEmpaque));
                        txt_bodega.grabFocus();
                    }

                }

            }
        });

        tablaProductos.tabla.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
//				System.out.println("entrosssssdasdasd");
                if (!txt_codigo.getText().trim().isEmpty()) {
                    String valido = validarProducto(txt_codigo.getText().trim());
                    if (valido.equalsIgnoreCase("NOEXISTE")) {
                        option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "El producto no existe.", "Inténtelo de nuevo.");
                        txt_idCodigo.setText("");
                        txt_codigo.setText("");
                        txt_descripcion.setText("");
                        txt_empaque.setText("");
                        txt_descripcionItem.setEnabled(false);
                        deshacerFiltroProducto();
                        txt_codigo.grabFocus();
                    } else if (valido.equalsIgnoreCase("VALIDO")) {
                        txt_descripcionItem.setEnabled(true);
                    } else {
                    }
                }

            }

            @Override
            public void focusGained(FocusEvent e) {

            }
        });

        tablaBodegas.tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.isMetaDown()) {
                    int fila = tablaBodegas.tabla.getSelectedRow();

                    if (fila != -1) {
                        txt_bodega.setText((String) tablaBodegas.tabla.getValueAt(fila, GUITablaBodegas.columnaCodigo));
                        txt_idBodega.setText((String) tablaBodegas.tabla.getValueAt(fila, GUITablaBodegas.columnaId));
                    }
                }

            }
        });

        tablaBodegas.tabla.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    int fila = tablaBodegas.tabla.getSelectedRow();

                    if (fila != -1) {
                        txt_bodega.setText((String) tablaBodegas.tabla.getValueAt(fila, GUITablaBodegas.columnaCodigo));
                        txt_idBodega.setText((String) tablaBodegas.tabla.getValueAt(fila, GUITablaBodegas.columnaId));
                    }

                }

            }
        });

        tablaBodegas.tabla.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                if (!txt_bodega.getText().trim().isEmpty()) {
                    String valido = validarBodega(txt_bodega.getText().trim());
                    if (valido.equalsIgnoreCase("NOEXISTE")) {
                        option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "La bodega no existe.", "Inténtelo de nuevo.");
                        txt_idBodega.setText("");
                        txt_bodega.setText("");
                        deshacerFiltroBodega();
                    } else if (valido.equalsIgnoreCase("ERROR2")) {
                        option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Ha ocurrido un error.", "Inténtelo de nuevo.");
                        txt_idBodega.setText("");
                        txt_bodega.setText("");
                        deshacerFiltroBodega();
                    } else {

                    }
                }

            }

            @Override
            public void focusGained(FocusEvent e) {

            }
        });
    }

    private void deshacerFiltroBodega() {
        tablaBodegas.deshacerFiltro();
    }

    private void deshacerFiltroProducto() {
        tablaProductos.deshacerFiltro();
    }

    private void deshacerFiltroDocFuente() {
        tablaDocumentos.deshacerFiltro();
    }

    private void deshacerFiltroTercero() {
        tablaTerceros.deshacerFiltro();
    }

    private void deshacerFiltroPrincipal() {
        Filtro.deshacerFiltro(trsFiltrotablaPrincipal, dtmTablaPrincipal, tablaPrincipal);
    }

    /**
     *
     */
    private void ocultarPaneles() {
        tablaBodegas.setVisible(false);
        tablaProductos.setVisible(false);
        tablaDocumentos.setVisible(false);
        tablaTerceros.setVisible(false);
    }

    public static String asignarNumeroConsecutivo(Usuario usuario, boolean esPorVRi) {
        String ultimoNumero = Transaccion.traerUltimoNumerotransaccion(usuario, esPorVRi);
        System.out.println("1:  " + ultimoNumero);
        if (ultimoNumero.equals("ERROR")) {
            if (!esPorVRi) {
                option.tipoMensaje(GUIJOption.mensajeAdvertencia, "141", "No se ha podido traer el último número de la base de datos.", "Inténtelo de nuevo.");
            }
        } else {
            ultimoNumero = NumeroConsecutivo.numeroConsecutivoPrefijo(ultimoNumero, usuario);
            System.out.println("2:  " + ultimoNumero);
            if (ultimoNumero.equalsIgnoreCase("")) {
                if (!esPorVRi) {
                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "142", "No se ha podido convertir la numeración.", "Inténtelo de nuevo.");
                }
            } else if (ultimoNumero.equalsIgnoreCase("NOHAYCUPO")) {
                if (!esPorVRi) {
                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "143", "No hay cupo en la numeración actual.", "Inténtelo de nuevo.");
                }
            } else {
                return ultimoNumero;
            }
        }
        return ultimoNumero;
    }

    @Override
    public void actualizarFrame() {
        //To change body of generated methods, choose Tools | Templates.
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
        //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * metodo calcula calcula y muestra el valor total formateado en moneda al
     * campo valor toal
     */
    public void calculoValorTotalJtextValorTotal() {

        if (!txt_cantidad.getText().replace(" ", "").trim().equalsIgnoreCase("")) {
            if (!txt_ValorUnitario.getText().replace(" ", "").trim().equalsIgnoreCase("")) {
                double cantidad = 0;
                if (!txt_cantidad.getText().replace(",", "").isEmpty()) {
                    cantidad = Double.parseDouble(txt_cantidad.getText().replace(",", ""));
                }
                double valorUnitario = 0;
                if (!txt_ValorUnitario.getText().replace("$", "").replace(",", "").replace(" ", "").isEmpty()) {
                    valorUnitario = Double.parseDouble(Formatos.quitarFormatoValorString(txt_ValorUnitario.getText().replace(" ", "")));
                }

                txt_valorTotal.setText(String.valueOf(calculoValorTotal(cantidad, valorUnitario, 0)));
                txt_valorTotal.setText(Formatos.formatearValorString(txt_valorTotal.getText().trim()));
            } else {
                txt_valorTotal.setText(Formatos.formatearValorString("0"));
            }
        } else {
            txt_valorTotal.setText(Formatos.formatearValorString("0"));
        }
    }

    /**
     * metodo calcula el valor total dos parametros
     *
     * @param cantidad
     * @param valorUnitario
     */
    public double calculoValorTotal(double cantidad, double valorUnitario, double descuento) {
        double valorTotal = (cantidad * valorUnitario) - descuento;
        return Formatos.truncarDecimales(valorTotal, 2);
    }

    /**
     *
     */
    private void calcularValorTotalTabla() {
        double total = 0.0;
        for (int i = 0; i < tablaPrincipal.getRowCount(); i++) {
            total = total + Double.parseDouble(Formatos.quitarFormatoValorString(tablaPrincipal.getValueAt(i, columnaVtotal).toString()));
        }
        lbl_totalResultados.setText(Formatos.formatearValorString(String.valueOf(total)));
    }

    /**
     * metodo que adiciona unitem
     */
    private void accionAdicionarItem() {
        String vacios = validarObligatoriosMv();
        if (vacios.isEmpty()) {
            PersistenciaTransaccion pTransaccion = new PersistenciaTransaccion();
            TransaccionItem item = setValoresItemTransaccion();
            int cantidadItemsAntes = transaccion.getListItem().size();
            pTransaccion.adicionar(item, transaccion);
            int cnatidadItemsDespues = transaccion.getListItem().size();

            if (cantidadItemsAntes < cnatidadItemsDespues) {
                cargarDatosPrincipal();
                calcularValorTotalTabla();
                limpiarCamposRegistroMv(true);
                System.out.println("Bien");
            } else {
                System.out.println("mal");
            }
            txt_codigo.grabFocus();

        } else {
            JOptionPane.showOptionDialog(frame, "Los siguientes campos no pueden estar vacios: \n\n " + vacios, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, "aceptar");
            txt_codigo.grabFocus();
        }
    }

    private TransaccionItem setValoresItemTransaccion() {
        TransaccionItem item = new TransaccionItem();
        item.setBodega(Servicios.bodegasController.bodegasRepository.consultarPorId(txt_idBodega.getText()));
        item.setCantidad(Double.parseDouble(Formatos.quitarFormatoDecimalesString(txt_cantidad.getText())));
        item.setDescripcionItem(txt_descripcionItem.getText().trim());
        item.setProducto(Servicios.productosController.productosRepository.consultarPorId(txt_idCodigo.getText()));
        String valUni = "";
        if (txt_ValorUnitario.getText().trim().isEmpty()) {
            valUni = "0";
        } else {
            valUni = txt_ValorUnitario.getText();
        }

        item.setValorUnitario(Double.parseDouble(Formatos.quitarFormatoValorString(valUni)));

        return item;
    }

    private String validarObligatoriosMv() {
        String vacios = "";
        if (txt_codigo.getText().trim().isEmpty()) {
            vacios = vacios + "- Código \n";
        }

        if (txt_cantidad.getText().trim().isEmpty()) {
            vacios = vacios + "- Cantidad \n";
        } else if (Double.parseDouble(txt_cantidad.getText().replace(",", "").trim()) <= 0.00) {
            vacios = vacios + "- Cantidad diferente a 0\n";
        }
        return vacios;
    }

    /**
     * metodo que valida vacios en
     */
    public String validarValidarVaciosGeneral() {
        String vacios = "";
        if (txt_documento.getText().trim().isEmpty()) {
            vacios = vacios + "- Documento \n";
        }
        if (txt_fecha.getText().replace("/", "").replace(" ", "").trim().isEmpty()) {
            vacios = vacios + "- Fecha \n";
        }
        if (txt_nit.getText().trim().isEmpty()) {
            vacios = vacios + "- Tercero \n";
        }
        if (tablaPrincipal.getRowCount() < 1) {
            vacios = vacios + "- items  \n";
        }
        return vacios;
    }

    /**
     * metodo que graba la transaccion
     */
    private void acionBotonGrabar() {
        String vacios = validarValidarVaciosGeneral();
        if (vacios.isEmpty()) {

        } else {
            JOptionPane.showOptionDialog(frame, "Los siguientes campos no pueden estar vacios: \n\n " + vacios, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, "aceptar");
            txt_codigo.grabFocus();
        }
    }

    private Transaccion setValoresTransaccion() {
        transaccion.setCondicion(txt_condiciones.getText());
        transaccion.setCreacion(new Timestamp(System.currentTimeMillis()));
        transaccion.setDocumento(Servicios.documentosController.documentosRepository.consultarPorId(txt_idDocumentoFuente.getText()));
//        transaccion.setFecha(new Date(txt_fecha.getText()));
        transaccion.setFecha(Fecha.getDate(txt_fecha.getText()));
        transaccion.setInterno(Servicios.internosController.internosRepository.consultarPorTd(txt_nit.getText()));
        transaccion.setModificacion(new Timestamp(System.currentTimeMillis()));
        transaccion.setNumero(txt_numero.getText());
        transaccion.setUsuario(usuario);
        return transaccion;
    }

    private void accionGrabar() {
        String vacios = validarValidarVaciosGeneral();
        if (vacios.isEmpty()) {
            PersistenciaTransaccionInt pTransaccion = Servicios.transaccionController.transaccionRepository;
            setValoresTransaccion();
            int cantidadItemsAntes = pTransaccion.getListaTransacciones().size();
            pTransaccion.adicionar(transaccion);
            Interno interno = Servicios.internosController.internosRepository.consultarPorTd(txt_nit.getText());
            interno.registrarGasto(Valor.convertirValorStringALong(Formatos.quitarFormatoDecimalesString(lbl_totalResultados.getText())));
            int cnatidadItemsDespues = pTransaccion.getListaTransacciones().size();

            if (cantidadItemsAntes < cnatidadItemsDespues) {
                bloquearCamposGrabar();
                System.out.println("Bien");
            } else {
                System.out.println("mal");
            }

            System.out.println(cantidadItemsAntes);
            System.out.println(cnatidadItemsDespues);

        } else {
            JOptionPane.showOptionDialog(frame, "Los siguientes campos no pueden estar vacios: \n\n " + vacios, "Advertencia", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, null, "aceptar");
            txt_codigo.grabFocus();
        }
    }

    /**
     *
     * @return
     */
    private void accionBotonOtro() {

    }

    /**
     * bloquea los campos al grabar el documento
     */
    public void bloquearCamposGrabar() {
        btn_otros.setEnabled(true);
        btn_adicionar.setEnabled(false);
        btn_borrar.setEnabled(false);
        btn_borrar2.setEnabled(false);
        btn_cancelar.setEnabled(false);
        btn_cancelarMv.setEnabled(false);
        btn_grabar.setEnabled(false);
        btn_guardarMv.setEnabled(false);
        btn_imprimir.setEnabled(true);
        btn_insertar.setEnabled(false);
        btn_modificar.setEnabled(false);
        btn_plantilla.setEnabled(false);
        btn_repetir.setEnabled(false);

        txt_bodega.setEnabled(false);
        txt_cantidad.setEnabled(false);
        txt_codigo.setEnabled(false);
        txt_condiciones.setEnabled(false);
        txt_condiciones.setEnabled(false);
        txt_descripcion.setEnabled(false);
        txt_descripcionItem.setEnabled(false);
        txt_documento.setEnabled(false);
        txt_documentoAntiguo.setEnabled(false);
        txt_documentoCierre.setEnabled(false);
        txt_empaque.setEnabled(false);
        txt_fecha.setEnabled(false);
        txt_idBodega.setEnabled(false);
        txt_idCodigo.setEnabled(false);
        txt_idDocumentoFuente.setEnabled(false);
        txt_idTercero.setEnabled(false);
        txt_idTransaccion.setEnabled(false);
        txt_nit.setEnabled(false);
        txt_nitAntiguo.setEnabled(false);
        txt_numeracion.setEnabled(false);
        txt_numero.setEnabled(false);
        txt_numeroFijo.setEnabled(false);
        txt_observaciones.setEnabled(false);
        txt_TipoClienteDocFuente.setEnabled(false);
        txt_valorTotal.setEnabled(false);
        txt_ValorUnitario.setEnabled(false);

    }

}
