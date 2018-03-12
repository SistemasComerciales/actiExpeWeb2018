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
public class GUITransaccionConsultar extends ClaseGeneral {

    private CampoLabel lbl_nombreDocFuente;

    private CampoLabel lbl_documento, lbl_numero, lbl_fecha, lbl_nit, lbl_condiciones, lbl_nombre, lbl_nombreDin, lbl_cupoDiario, lbl_cupoDiarioDin, lbl_ciudad, lbl_ciudadDin, lbl_cupoMensual, lbl_cupoMensualDin, lbl_cupoTotal, lbl_cupoTotalDin;
    private CajaDeTexto txt_fechaAntigua, txt_idDocumentoFuente, txt_documento, txt_documentoAntiguo, txt_numeracion, txt_numeroFijo, txt_documentoCierre, txt_numero, txt_estado, txt_idTercero, txt_nit, txt_nitAntiguo, txt_condiciones, txt_TipoClienteDocFuente, txt_llevaBodegaDocFuente, txt_idBodegaDocFuente, txt_accionSobreInventario, txt_costeKardex, txt_interfaceDocFuente, txt_llevaClienteFijo, txt_listaPrecioDoc, txt_ControlExistenciaDocFuente, txt_preCostoDocFuente, txt_cuentasPorCobrar, txt_cuentasPorPagar, txt_idTransaccionOriginal, txt_esAutoRete;
    private CajaDeTextoConFormato txt_fecha;

    ////////////panel REGISTRO2 MVTRANSACCION///////////
    private CampoLabel lbl_codigo, lbl_descripcion, lbl_empaque, lbl_bodega, lbl_cantidad, lbl_valorUnitario, lbl_valorTolal;
    private CajaDeTexto txt_idCodigo, txt_codigo, txt_descripcion, txt_empaque, txt_idBodega, txt_bodega, txt_idTransaccion;
    private CajaDeTexto txt_cantidad, txt_ValorUnitario, txt_valorTotal;

    //////////////////PANEL BOTONES 2////////////////////
    private CampoLabel lbl_adicionar, lbl_borrar, lbl_insertar, lbl_modificar, lbl_repetir, lbl_cancelarMV, lbl_guardarMv, lbl_NombreExistencia, lbl_ResultadoExistencia;
    private Boton btn_adicionar, btn_borrar2, btn_insertar, btn_modificar, btn_repetir, btn_cancelarMv, btn_guardarMv;

    //////////////////PANEL BOTONES 1/////////////////////
    private CampoLabel lbl_subtotal, lbl_descuento, lbl_retenciones, lbl_iva, lbl_total, lbl_subtotalResultado, lbl_totalResultados, lbl_descripcionItem, lbl_observaciones, lbl_grupoProducto, lbl_grupoContable, lbl_grupoContableResultado, lbl_grupoProductoResultado, lbl_numeroItems, lbl_numeroItemsResultado, lbl_numeroArticulos, lbl_numeroArticuloResultados, lbl_ivaResultado, lbl_retencionesResul;
    private CajaDeTexto txt_descripcionItem;
    private Boton btn_salir, btn_otros, btn_plantilla, btn_grabar, btn_borrar, btn_imprimir, btn_inicial, btn_buscar, btn_cancelar;
    private CampoLabel lbl_descuentoPorcentaje, lbl_descuentoValor;
    private CajaDeTexto txt_observaciones;

///////////////////PANEL PREPARA TABLA PRINCIPAL///////////////////////
    private JPanel panel_tablaPrincipal;
    private DefaultTableModel dtmTablaPrincipal;
    private JTable tablaPrincipal;
    private JScrollPane scrollpanePrincipal;
    private TableRowSorter<DefaultTableModel> trsFiltrotablaPrincipal;

    private Transaccion transaccion;
    private static String nombreClase = "Consultar Transacción";

    public GUITransaccionConsultar(Usuario usuario, Transaccion transaccion) {
        super(usuario);
        this.transaccion = transaccion;

        prepareElementos();
        prepareElementosInfo();
        preparaElementosTablaPrincipal();
        prepararElementosRegistro2();
        preparaElementosBotones();
        preparaElementosBotones2();

        accionBotones();
        inicializar();

        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "".toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
    }

    /**
     * Método encargado del diseño del frame, tamaño, fondo.
     */
    private void prepareElementos() {
        this.setTitle(nombreClase);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
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
    private void prepararElementosRegistro2() {

        int posicionXTxt = panel_tablaPrincipal.getX();
        int posicionYTxt = CargaImagenes.ALTO_PANTALLA / 100 * 27;
        int posicionYlbl = CargaImagenes.ALTO_PANTALLA / 100 * 23;

        lbl_codigo = new CampoLabel("Código", "E");
        lbl_codigo.alinearCentro();
        lbl_codigo.setBounds(posicionXTxt, posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCodigo).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_codigo);

        lbl_descripcion = new CampoLabel("Descripción  ", "E");
        lbl_descripcion.alinearCentro();
        lbl_descripcion.setBounds(lbl_codigo.getX() + lbl_codigo.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaDescripcion).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_descripcion);

        lbl_empaque = new CampoLabel("Empaque", "E");
        lbl_empaque.alinearCentro();
        lbl_empaque.setBounds(lbl_descripcion.getX() + lbl_descripcion.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaEmpaque).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_empaque);

        lbl_bodega = new CampoLabel("Bodega", "E");
        lbl_bodega.alinearCentro();
        lbl_bodega.setBounds(lbl_empaque.getX() + lbl_empaque.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaBodega).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_bodega);

        lbl_cantidad = new CampoLabel("Cantidad", "E");
        lbl_cantidad.alinearCentro();
        lbl_cantidad.setBounds(lbl_bodega.getX() + lbl_bodega.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCantidad).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_cantidad);

        lbl_valorUnitario = new CampoLabel("Valor Unitario  ", "E");
        lbl_valorUnitario.alinearCentro();
        lbl_valorUnitario.setBounds(lbl_cantidad.getX() + lbl_cantidad.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVunitario).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_valorUnitario);

        lbl_valorTolal = new CampoLabel("Valor Total  ", "E");
        lbl_valorTolal.alinearCentro();
        lbl_valorTolal.setBounds(lbl_valorUnitario.getX() + lbl_valorUnitario.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVtotal).getMaxWidth(), CargaImagenes.altoBotonGeneral / 5 * 4);
        this.add(lbl_valorTolal);

        txt_idTransaccion = new CajaDeTexto("G");
        txt_idCodigo = new CajaDeTexto("G");

        txt_codigo = new CajaDeTexto("G", 20);
        txt_codigo.setBounds(posicionXTxt, posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCodigo).getMaxWidth(), 20);
        this.add(txt_codigo);

        txt_descripcion = new CajaDeTexto("G", 20);
        txt_descripcion.setBounds(txt_codigo.getX() + txt_codigo.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaDescripcion).getMaxWidth(), 20);
        this.add(txt_descripcion);
        txt_descripcion.setEnabled(false);

        txt_empaque = new CajaDeTexto("G", 20);
        txt_empaque.setBounds(txt_descripcion.getX() + txt_descripcion.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaEmpaque).getMaxWidth(), 20);
        this.add(txt_empaque);
        txt_empaque.setEnabled(false);

        txt_idBodega = new CajaDeTexto("G", 20);
        txt_bodega = new CajaDeTexto("G", 20);
        txt_bodega.setBounds(txt_empaque.getX() + txt_empaque.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaBodega).getMaxWidth(), 20);
        this.add(txt_bodega);

        txt_cantidad = new CajaDeTexto("N", 20);
        txt_cantidad.setBounds(txt_bodega.getX() + txt_bodega.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCantidad).getMaxWidth(), 20);
        this.add(txt_cantidad);

        txt_ValorUnitario = new CajaDeTexto("M", 20);
        txt_ValorUnitario.setBounds(txt_cantidad.getX() + txt_cantidad.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVunitario).getMaxWidth(), 20);
        this.add(txt_ValorUnitario);

        txt_valorTotal = new CajaDeTexto("M", 20);
        txt_valorTotal.setBounds(txt_ValorUnitario.getX() + txt_ValorUnitario.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVtotal).getMaxWidth(), 20);
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

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaidBodega).setMaxWidth(0);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaidBodega).setMinWidth(0);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaidBodega).setPreferredWidth(0);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCodigo).setMaxWidth(columna1 * 3);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCodigo).setMinWidth(columna1 * 1);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCodigo).setPreferredWidth(columna1 * 3);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaDescripcion).setMaxWidth(columna1 * 8);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaDescripcion).setMinWidth(columna1 * 4);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaDescripcion).setPreferredWidth(columna1 * 8);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaEmpaque).setMaxWidth(columna1 * 3 / 2);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaEmpaque).setMinWidth(columna1 / 2);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaEmpaque).setPreferredWidth(columna1 * 3 / 2);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaBodega).setMaxWidth(columna1 * 3 / 2);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaBodega).setMinWidth(columna1 / 2);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaBodega).setPreferredWidth(columna1 * 3 / 2);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCantidad).setMaxWidth(columna1 * 2);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCantidad).setMinWidth(columna1);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaCantidad).setPreferredWidth(columna1 * 2);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVunitario).setMaxWidth(columna1 * 3);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVunitario).setMinWidth(columna1);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVunitario).setPreferredWidth(columna1 * 3);

        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVtotal).setMaxWidth(columna1 * 4);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVtotal).setMinWidth(columna1 * 2);
        tablaPrincipal.getColumnModel().getColumn(GUITransaccion.columnaVtotal).setPreferredWidth(columna1 * 4);
    }

    /**
     * metodo que prepara los botones secundarios
     */
    private void preparaElementosBotones2() {

        int anchoBotonB = CargaImagenes.anchoBotonMini;
        int altoBotonB = CargaImagenes.altoBotonMini;

        int posicionXBtn = CargaImagenes.ANCHO_PANTALLA / 100;
        int posicionYBtn = CargaImagenes.ALTO_PANTALLA / 100 * 63;

        int posicionXLbl = CargaImagenes.ANCHO_PANTALLA / 100;
        int posicionYLbl = CargaImagenes.ALTO_PANTALLA / 100 * 67;

        lbl_adicionar = new CampoLabel("Adicionar", "E");
        lbl_adicionar.alinearDerecha();
        lbl_adicionar.setBounds(posicionXLbl, posicionYLbl, CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_adicionar);

        lbl_guardarMv = new CampoLabel("Guardar", "E");
        lbl_guardarMv.alinearDerecha();
        lbl_guardarMv.setBounds(posicionXLbl - 5, posicionYLbl, CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        lbl_guardarMv.setVisible(false);
        this.add(lbl_guardarMv);

        lbl_borrar = new CampoLabel("Borrar", "E");
        lbl_borrar.alinearCentro();
        lbl_borrar.setBounds(lbl_adicionar.getX() + lbl_adicionar.getWidth(), lbl_adicionar.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_borrar);

        lbl_insertar = new CampoLabel("Insertar", "E");
        lbl_insertar.alinearIzquierda();
        lbl_insertar.setBounds(lbl_borrar.getX() + lbl_borrar.getWidth() + 10, lbl_borrar.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
        this.add(lbl_insertar);

        lbl_modificar = new CampoLabel("Modificar", "E");
        lbl_modificar.alinearIzquierda();
        lbl_modificar.setBounds(lbl_insertar.getX() + lbl_insertar.getWidth(), lbl_insertar.getY(), CargaImagenes.anchoBotonGeneral / 2, CargaImagenes.altoBotonGeneral / 5 * 2);
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
    private void preparaElementosBotones() {

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

        btn_grabar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Registrar");
        btn_grabar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_grabar);
        btn_grabar.setToolTipText("grabar");
        btn_grabar.setLocation(posicionXbtn, posicionYbtn);
        btn_grabar.setSize(anchoBotonA, altoBotonA);

        btn_borrar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Borrar");
        btn_borrar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_borrar);
        btn_borrar.setToolTipText("borrar");
        btn_borrar.setLocation(btn_grabar.getX() + btn_grabar.getWidth() + 5, btn_grabar.getY());
        btn_borrar.setSize(anchoBotonA, altoBotonA);
//		btn_borrar.setVisible(false);

        btn_buscar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Buscar");
        btn_buscar.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_buscar);
        btn_buscar.setToolTipText("buscar");
        btn_buscar.setLocation(btn_borrar.getX() + btn_borrar.getWidth() + 5, btn_borrar.getY());
        btn_buscar.setSize(anchoBotonA, altoBotonA);

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
//		btn_plantilla.setVisible(false);

        btn_otros = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Otro");
        btn_otros.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_otros);
        btn_otros.setToolTipText("Otro");
        btn_otros.setLocation(btn_grabar.getX(), btn_grabar.getY() + btn_grabar.getHeight() + 5);
        btn_otros.setSize(anchoBotonA, altoBotonA);
        btn_otros.setEnabled(false);

        btn_imprimir = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Reporte");
        btn_imprimir.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_imprimir);
        btn_imprimir.setToolTipText("imprimir");
        btn_imprimir.setLocation(btn_borrar.getX(), btn_borrar.getY() + btn_borrar.getHeight() + 5);
        btn_imprimir.setSize(anchoBotonA, altoBotonA);
        btn_imprimir.setEnabled(false);

        btn_inicial = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Inicial");
        btn_inicial.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_inicial);
        btn_inicial.setToolTipText("inicial");
        btn_inicial.setLocation(btn_buscar.getX(), btn_buscar.getY() + btn_buscar.getHeight() + 5);
        btn_inicial.setSize(anchoBotonA, altoBotonA);

        btn_salir = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Salir");
        btn_salir.cambiarTamanoTexto(CargaImagenes.anchoBotonGeneral / 6f);
        this.add(btn_salir);
        btn_salir.setToolTipText("Salir");
        btn_salir.setLocation(btn_plantilla.getX(), btn_plantilla.getY() + btn_plantilla.getHeight() + 5);
        btn_salir.setSize(anchoBotonA, altoBotonA);

    }

    private void cargarDatosPrincipal() {
        deshacerFiltroPrincipal();
        Tabla.eliminarFilasTabla(dtmTablaPrincipal);

        PersistenciaTransaccionInt persistencia = Servicios.transaccionController.transaccionRepository;

        ArrayList<TransaccionItem> items = persistencia.consultarTodoItems(transaccion);

        double total = 0.0;
        for (TransaccionItem item : items) {
            String[] datosFila = new String[dtmTablaPrincipal.getColumnCount()];

            datosFila[GUITransaccion.columnaCodigo] = String.valueOf(item.getProducto().getCodigo());

            datosFila[GUITransaccion.columnaDescripcion] = item.getProducto().getNombre();
            datosFila[GUITransaccion.columnaEmpaque] = item.getProducto().getPresentacion();
            String codigoBodega = "";
            if (item.getBodega() != null) {
                codigoBodega = item.getBodega().getCodigo();
            }
            datosFila[GUITransaccion.columnaBodega] = codigoBodega;

            double cantidad = item.getCantidad();
            double valorUnitario = item.getValorUnitario();
            double valorTotal = item.getCantidad() * item.getValorUnitario();
            datosFila[GUITransaccion.columnaCantidad] = Formatos.formatearNumeroAgregaDecimalesString(String.valueOf(cantidad));
            datosFila[GUITransaccion.columnaVunitario] = Formatos.formatearValorString(String.valueOf(valorUnitario));
            datosFila[GUITransaccion.columnaVtotal] = Formatos.formatearValorString(String.valueOf(valorTotal));
            total += valorTotal;

            long idBodega = 0;
            if (item.getBodega() != null) {
                idBodega = item.getBodega().getId();
            }
            datosFila[GUITransaccion.columnaidBodega] = String.valueOf(idBodega);

            dtmTablaPrincipal.addRow(datosFila);
        }

        lbl_totalResultados.setText(Formatos.formatearValorString(String.valueOf(total)));
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
    }

    private void deshacerFiltroPrincipal() {
        Filtro.deshacerFiltro(trsFiltrotablaPrincipal, dtmTablaPrincipal, tablaPrincipal);
    }

    /**
     * bloquea los campos al grabar el documento
     */
    private void bloquearCamposGrabar() {
//        btn_otros.setEnabled(true);
        btn_otros.setEnabled(false);
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

        btn_buscar.setEnabled(false);
        btn_inicial.setEnabled(false);

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

    @Override
    public void actualizarFrame() {
        txt_idTercero.setText(String.valueOf(transaccion.getDocumento().getId()));
        txt_documento.setText(transaccion.getDocumento().getCodigo());
        lbl_nombreDocFuente.setText(transaccion.getDocumento().getNombre());

        txt_numero.setText(transaccion.getNumero());
        txt_fecha.setText(Fecha.obtenerFechaString(transaccion.getFecha()));

        txt_idTercero.setText(String.valueOf(transaccion.getInterno().getId()));
        txt_nit.setText(transaccion.getInterno().getTd());
        lbl_nombreDin.setText(transaccion.getInterno().getPrimerApellido() + " " + transaccion.getInterno().getSegundoApellido() + " " + transaccion.getInterno().getPrimerNombre() + " " + transaccion.getInterno().getSegundoNombre());
        lbl_ciudadDin.setText(transaccion.getInterno().getNacionalidad());
        lbl_cupoDiarioDin.setText(Formatos.formatearValorDecimalesString(transaccion.getInterno().traerSaldoDiarioDisponibleValidado() + "", DatosGeneralesPrograma.cantidadDecimalesMoneda));
        lbl_cupoMensualDin.setText(Formatos.formatearValorDecimalesString(transaccion.getInterno().traerSaldoMensualDisponibleValidado() + "", DatosGeneralesPrograma.cantidadDecimalesMoneda));
        lbl_cupoTotalDin.setText(Formatos.formatearValorDecimalesString(transaccion.getInterno().getSaldoDisponible() + "", DatosGeneralesPrograma.cantidadDecimalesMoneda));

        txt_condiciones.setText(transaccion.getCondicion());

        cargarDatosPrincipal();
        bloquearCamposGrabar();
    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        btn_imprimir.grabFocus();
    }

    @Override
    public void asignarPermisos() {
        //To change body of generated methods, choose Tools | Templates.
    }

}
