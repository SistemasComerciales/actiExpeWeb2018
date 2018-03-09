package activa.Expendio.vista;

import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITransaccionesRegistrar extends ClaseGeneral {

    private static final String nombreClase = "Registro de Documentos";

    private int anchoBoton, altoBoton;

//    private GUIDialogPos manejoPos;
    public static String docPos = "";

    private CampoLabel lbl_formatoFecha;
    ////////////////// PANEL INICIAL////////////////////
    private CampoLabel lbl_nombreDocFuente, lbl_listaDePrecios, lbl_listaDePreciosResult, lbl_trm;
    private CajaDeTexto txt_trm;
    private CasillaVerificacion check_facDOlares;
    //////////// PANEL REGISTRO1 TRANSACCION////////////
    private CampoLabel lbl_documento, lbl_numero, lbl_fecha, lbl_nit, lbl_condiciones, lbl_nombre, lbl_nombreDin, lbl_direccion, lbl_direccionDin, lbl_ciudad, lbl_ciudadDin, lbl_telefono, lbl_telefonoDin, lbl_numDocumentoTercero, lbl_digitoVerificacion, lbl_numeroDocumento, lbl_documentoBase, lbl_documentoBaseDocFuente, lbl_documentoBaseNumero, lbl_vence, lbl_vendedor, lbl_resNombreVendedor, lbl_nombreVendedor;
    public CajaDeTexto txt_fechaAntigua, txt_idDocumentoFuente, txt_documento, txt_documentoAntiguo, txt_numeracion, txt_numeroFijo, txt_documentoCierre, txt_numero, txt_idTercero, txt_nit, txt_nitAntiguo, txt_idTipoRegimen, txt_nombreTipoRegimen, txt_codigoTipoRegimen, txt_asumeReteIvaTipoRegimen, txt_condiciones, txt_numDocumento, txt_idVendedor, txt_vendedor, txt_llevaVendedor, txt_TipoClienteDocFuente, txt_descuentoDocFuente, txt_TipoDescuentoDOcFuente, txt_aplicaRetenciones, txt_aplicaIvaDocFuente, txt_llevaBodegaDocFuente, txt_idBodegaDocFuente, txt_accionSobreInventario, txt_costeKardex, txt_interfaceDocFuente, txt_llevaClienteFijo, txt_listaPrecioDoc, txt_listaPrecioTercero, txt_ControlExistenciaDocFuente, txt_preCostoDocFuente, txt_cuentasPorCobrar, txt_cuentasPorPagar, txt_llevaDocumentoBase, txt_documentoBaseObligatorio, txt_documentoBaseUnico, txt_idDocumentoBaseUnico, txt_DocFuentePos, txt_aplicaIvaTercero, txt_diasVencimientoTercero, txt_esAutoRete;
    public CajaDeTextoConFormato txt_fecha, txt_vence;
    ////////////panel REGISTRO2 MVTRANSACCION///////////
    private CampoLabel lbl_codigo, lbl_descripcion, lbl_empaque, lbl_bodega, lbl_descuento2, lbl_cantidad, lbl_valorUnitario, lbl_valorTolal, lbl_PorcentajeIva;
    public CajaDeTexto txt_idCodigo, txt_codigo, txt_idGrupoContable, txt_descripcion, txt_empaque, txt_idBodega, txt_bodega, txt_focusRepetir, txt_idTransaccionMv, txt_idTransaccion, txt_ControlExistenciaProducto, txt_numeroDeSerieProducto, txt_llevaNUmerodeSerie;
    public CajaDeTexto txt_cantidad, txt_cantidadAntigua, txt_ValorUnitario, txt_descuento2, txt_valorTotal, txt_PorcentajeIvaCliente;
    private Boton btn_edicionRetenciones;
    //////////////////PANEL BOTONES 1/////////////////////
    private CampoLabel lbl_subtotal, lbl_descuento, lbl_retenciones, lbl_iva, lbl_total, lbl_subtotalResultado, lbl_totalResultados, lbl_descripcionItem, lbl_observaciones, lbl_grupoProducto, lbl_grupoContable, lbl_grupoContableResultado, lbl_grupoProductoResultado, lbl_numeroItems, lbl_numeroItemsResultado, lbl_numeroArticulos, lbl_numeroArticuloResultados, lbl_ivaResultado, lbl_retencionesResul;
    public CajaDeTexto txt_descripcionItem;
    public Boton btn_salir, btn_otros, btn_plantilla, btn_grabar, btn_borrar, btn_imprimir, btn_inicial, btn_buscar, btn_cancelar;
    private CampoLabel lbl_descuentoPorcentaje, lbl_descuentoValor;
    public CajaDeTexto txt_observaciones;
    public CasillaVerificacion check_AplicaNiif;
    //////////////////PANEL BOTONES 2////////////////////
    private CampoLabel lbl_adicionar, lbl_borrar, lbl_insertar, lbl_modificar, lbl_repetir, lbl_cancelarMV, lbl_guardarMv, lbl_costoProducto, lbl_costoProductoTotal, lbl_facturaCompra;
    public Boton btn_adicionar, btn_borrar2, btn_insertar, btn_modificar, btn_repetir, btn_cancelarMv, btn_guardarMv;
    private CajaDeTexto txt_facturaCompra;
    ///////////////////PANEL NOTA///////////////////////
    private JPanel panel_notas;
    private CampoLabel lbl_nota;
    public CajaTextoArea txta_notasDocumento;
    public JScrollPane scrollpaneNota;
    ///////////////////PANEL DESCRIPCION ITEM///////////////////////
    private JPanel panelDescripcionItem;
    private CampoLabel lbl_descripcionItem2;
    public CajaTextoArea txta_descripcionItem;
    public JScrollPane scrollpaneDescripcionItem;
    ///////////////////PANEL PREPARA DOCUMENTO FUENTE///////////////////////
    private JPanel panel_documentofuente;
    private DefaultTableModel dtm_documentoFuente;
    public JTable tabla_documentoFuente;
    private JScrollPane scroll_documentoFuente;
    private TableRowSorter<DefaultTableModel> trsFiltro_DocumentoFuente;
    ///////////////////PANEL PREPARA TERCEROS///////////////////////
    private JPanel panelTablaTerceros;
    private DefaultTableModel dtmTablaTerceros;
    public JTable tablaTerceros;
    private JScrollPane scrollPaneTablaTerceros;
    private TableRowSorter<DefaultTableModel> trsFiltroTerceros;
    ///////////////////PANEL PREPARA PRODUCTO///////////////////////
    private JPanel panel_producto;
    private DefaultTableModel dtmTablaProducto;
    public JTable tablaProducto;
    private JScrollPane scrollpaneProducto;
    private TableRowSorter<DefaultTableModel> trsFiltroProducto;
    ///////////////////PANEL PREPARA TABLA PRINCIPAL///////////////////////
    private JPanel panel_tablaPrincipal;
    public DefaultTableModel dtmTablaPrincipal;
    public JTable tablaPrincipal;
    private JScrollPane scrollpanePrincipal;
    private TableRowSorter<DefaultTableModel> trsFiltrotablaPrincipal;
    ///////////////////PANEL PREPARA TABLA RETENCIONES TOTALES///////////////////////
    private JPanel panel_tablaReteTotal;
    public DefaultTableModel dtmTablaReteTotal;
    public JTable tablaReteTotal;
    private JScrollPane scrollpaneReteTotal;

    ///////////////////PANEL PREPARA BODEGA///////////////////////
    private JPanel panel_bodega;
    private DefaultTableModel dtmTablaBodega;
    public JTable tablaBodega;
    private JScrollPane scrollpaneBodega;
    private TableRowSorter<DefaultTableModel> trsFiltroBodega;
    ///////////////////PANEL PREPARA VENDEDOR///////////////////////
    private JPanel panel_vendedor;
    private DefaultTableModel dtmTablaVendedor;
    public JTable tablaVendedor;
    private JScrollPane scrollVendedor;
    private TableRowSorter<DefaultTableModel> trsFiltroVendedor;
    ///////////////////PANEL PREPARA DOCUMENTO FUENTE BASE///////////////////////
    private JPanel panel_documentofuenteBase;
    private DefaultTableModel dtmTablaDocumentoFuenteBase;
    public JTable tablaDocumentoFuenteBase;
    private JScrollPane scrollDocumentofuenteBase;
    private TableRowSorter<DefaultTableModel> trsFiltroDocumentoFuenteBase;
    ///////////////////PANEL PREPARA SERIE///////////////////////
    private DefaultTableModel dtmTablaNumeroSerie;
    public JTable tablaNumeroSerie;
    private JScrollPane scrollpaneNumeroSerie;
    //private TableRowSorter<DefaultTableModel> trsFiltroNumeroSerie;
    ///////////////////PANEL PREPARA SERIE 2///////////////////////
    private DefaultTableModel dtmTablaNumeroSerieSalida;
    public JTable tablaNumeroSerieSalida;
    private JScrollPane scrollpaneNumeroSerieSalida;
    private TableRowSorter<DefaultTableModel> trsFiltroNumeroSerieSalida;
    ///////////////////PANEL PREPARA SERIE 3///////////////////////
    private DefaultTableModel dtmTablaNumeroSerieSalida2;
    public JTable tablaNumeroSerieSalida2;
    private JScrollPane scrollpaneNumeroSerieSalida2;
    //	private TableRowSorter<DefaultTableModel> trsFiltroNumeroSerieSalida2;

    ///////////////////PANEL PREPARA DOCUMENTO NUMERO DIALOG PLANTILLA///////////////////////
    private JPanel panel_numeroDialog;
    private DefaultTableModel dtmTablanumeroDialog;
    public JTable tablanumeroDialog;
    private JScrollPane scrollNumeroDialog;
    private TableRowSorter<DefaultTableModel> trsFiltroNumeroDialog;
    //////////////////DIALOGO PLANTILLA/////////////////
    private JDialog DialogPlantilla;
    private CampoLabel lbl_documentoPlantilla, lbl_numeroPlantilla, lbl_nombreDocPlantilla, lbl_nombreNumeroPlantilla;
    private CajaDeTexto txt_documentoPlantilla, txt_iddocumentoPlantilla, txt_numeroPlantilla, txt_idnumeroPlantilla;
    private CasillaVerificacion check_enBlancoPlantilla;
    private Boton btn_aceptarPlantilla, btn_cancelarPlantilla;
    /////////////////DIALOGO RETENIONES/////////////////
    private JDialog DialogRetencion;
    private CampoLabel lbl_ivaReten, lbl_rentencionFuenteReten, lbl_retencionIcaReten;
    private CampoLabel lbl_FuentePorcentajeReten, lbl_FuenteValorReten, lbl_ivaPorcentajeReten, lbl_ivaValorReten, lbl_icaPorcentajeReten, lbl_icaValorReten, lbl_omitirBasesMinimas;
    private CasillaVerificacion check_omitirBasesMinimas;
    private Boton btn_aceptarReten;
    /////////////////DIALOGO PARA RENUMERAR/////////////
    private JDialog dialogRenumeracion;
    private CampoLabel lbl_dialRen_titulo;
    public Boton btn_dialRen_renumerar, btn_dialRen_cancelar;

    /////////////////DIALOGO PARA NUMEROSERIAL ENTRADA/////////////
    private JDialog dialogNumeroSerial;
    private CampoLabel lbl_dialSerial_NomProducto;
    private Boton btn_dialSerial_Cancelar, btn_dialSerial_Aceptar;

    /////////////////DIALOGO PARA NUMEROSERIAL SALIDA/////////////
    private JDialog dialogNumeroSerialSalida;
    private CampoLabel lbl_dialSerial_NomProductoSalida, lbl_serialSalida;
    private CajaDeTexto txt_buscarSerial;
    private Boton btn_dialSerial_CancelarSalida, btn_dialSerial_AceptarSalida;

    /////////////////DIALOGO PARA MODIFICAR RETENCIONES/////////////
    private JDialog dialogModificRetenciones;
    private CampoLabel lbl_dialogModificReteFuente, lbl_dialogModificReteIca, lbl_dialogModificReteIva, lbl_omitirBasesDetalle;
    private CajaDeTexto txt_dialogModificReteFuente, txt_dialogModificReteIca, txt_dialogModificReteIva;
    private Boton btn_dialRetenModifi_Aceptar;
    private CasillaVerificacion check_omitirBasesDetalle;

    /////////////HASHMAP QUE GUARDA LOS ID DE GRUPO CONTABLE Y SU RESPECTIVO CARACTER DE AGRUPACION PARA LAS RETENCIONES/////////
//    HashMap<String, String> idGrupoContableYSuAGrupacion = new HashMap<String, String>();
//    /////////////Lista QUE GUARDA LOS CARACTERES DE AGRUPACION PARA LAS RETENCIONES SIN REPETIR/////////
//    ArrayList<String> caracteresDeAgrupacion = new ArrayList<String>();
    ////VARIABLES PARA TRAER EL ULTIMO NUMERO ID DE LAS 4 TABLAS DE TRANSACCION Y LAS 4 TABLAS DE MV TRANSACCION
    private long ultimoIdNumerosSerialesTemporal = 0, ultimoIdNUmeroSeriales = 0, ultimoIdCuentasPorPagar = 0, ultimoIdCuentasPorCobrar = 0;
    private long ultimoIdTransaccion = 0, ultimoIdTransaccionHistorial = 0, ultimoIdTransaccionTemporal = 0;
    private long ultimoIdTransaccionMv = 0, ultimoIdTransaccionMvHistorial = 0, ultimoIdTransaccionMvTemporal = 0;

    ////VARIABLES DE IMAGENES DE BOTONES FONDOS DE FRAME DIALOG Y ICONO///////////////////////////////
    ///VARIABLES QUE CONTIENEN LOS VALORES FINALES DE LAS RETENCIONES PARA GRABARLAS/////////	
    ArrayList<String> valoresFinalesReteFuente = new ArrayList<String>();
    ArrayList<String> valoresFinalesReteIca = new ArrayList<String>();
    ArrayList<String> valoresFinalesReteIva = new ArrayList<String>();

    //VARIBLES QUE CONTIENEN EL NUMERO DE REGISTRO Y LOS SALDOS DEL KARDEX//////////////
    ArrayList<Integer> kSumeroRegistro = new ArrayList<Integer>();
    ArrayList<Double> kSaldosCantidad = new ArrayList<Double>();
    ArrayList<Double> kSaldosValores = new ArrayList<Double>();
    ArrayList<String> kListaProductosSinRepetir = new ArrayList<String>();

    //VARIABLES QUE CONTIENEN LOS DATOS DE LOS MOVIMIENTOS PARA ACTUALIZAR
    ArrayList<String> kSumeroRegistroUpdate = new ArrayList<String>();
    ArrayList<String> kSaldosCantidadUpdate = new ArrayList<String>();
    ArrayList<String> kSaldosValoresUpdate = new ArrayList<String>();
    ArrayList<String> kListaProductosUpdate = new ArrayList<String>();
    ArrayList<String> kMvUpdate = new ArrayList<String>();
    ArrayList<String> kAccionSobreInventario = new ArrayList<String>();
    ArrayList<String> kCostoUnitarioUpdate = new ArrayList<String>();
    ArrayList<String> kAjusteUpdate = new ArrayList<String>();
    ArrayList<String> kcantidadKardexUpdate = new ArrayList<String>();
    ArrayList<String> kvalorUnitarioUpdate = new ArrayList<String>();
    ArrayList<String> kdescuentoUpdate = new ArrayList<String>();
    ArrayList<String> kCosteaSI_NOUpdate = new ArrayList<String>();

    //VARIABLES QUE CONTIENEN LOS DATOS DEL COSTO POR PRODUCTO
    HashMap<Integer, String> costoPorProducto = new HashMap<Integer, String>();
    //VARIABLES QUE CONTIENEN LOS DATOS DE NUMERO serial  de ENTRADA
    int contadorModificar = 0;
    ArrayList<String[]> Numeroseriales = new ArrayList<String[]>();
    ArrayList<String[]> NumeroserialesBDTemp = new ArrayList<String[]>();
    ArrayList<String[]> NumeroserialesBDFin = new ArrayList<String[]>();
    ArrayList<String[]> unirHashMap = new ArrayList<String[]>();
    //VARIBLES DE CONTIENEN LOS DATOS DE NUMERO SERIAL DE SALIDAA	
    ArrayList<String[]> NumeroserialesSalida = new ArrayList<String[]>();
    ArrayList<String[]> NumeroserialesBDSalidaTemp = new ArrayList<String[]>();
    ArrayList<String[]> NumeroserialesBDSalida = new ArrayList<String[]>();

    //  NOMBRE COLUMNAS PRINCIPALES
    public static final int columnaIdmvTemporal = 0;
    public static final int columnaCodigo = 1;
    public static final int columnaDescripción = 2;
    public static final int columnaEmpaque = 3;
    public static final int columnaBodega = 4;
    public static final int columnaDescuento = 5;
    public static final int columnaCantidad = 6;
    public static final int columnaValorUnitario = 7;
    public static final int columnaValorTotal = 8;
    public static final int columnaPorcIVA = 9;
    public static final int columnaIdTransaccionTemporal = 10;
    public static final int columnaorden = 11;
    public static final int columnadescuentoPor = 12;
    public static final int columnaidBodega = 13;
    public static final int columnaidProducto = 14;
    public static final int columnaGrupoProducto = 15;
    public static final int columnaDescripcionItem = 16;
    public static final int columnaReteFuentePororigen = 17;
    public static final int columnaReteIcaporOrigen = 18;
    public static final int columnaReteIvaporOrigen = 19;
    public static final int columnaReteCreePorOrigen = 20;
    public static final int columnaReteFuenteValBase = 21;
    public static final int columnaReteIcaValBase = 22;
    public static final int columnaReteIvaValBase = 23;
    public static final int columnaReteCreeValBase = 24;
    public static final int columnaidGrupoContable = 25;
    public static final int columnaNombreGrupoContable = 26;
    public static final int columnaReteFuentePorCliente = 27;
    public static final int columnaReteIcaPorCliente = 28;
    public static final int columnaReteIvaPorCliente = 29;
    public static final int columnaReteCreePorCliente = 30;
    public static final int columnaReteFuenteValCliente = 31;
    public static final int columnaReteIcaValCliente = 32;
    public static final int columnaReteIvaValCliente = 33;
    public static final int columnaReteCreeValCliente = 34;
    public static final int columnavalorIvaOrigen = 35;
    public static final int columnavalorIvaCliente = 36;
    public static final int columnaporcIvaCliente = 37;
    public static final int columnavalorFinalIva = 38;
    public static final int columnavalorFinalReteIca = 39;
    public static final int columnavalorFinalReteFuente = 40;
    public static final int columnavalorFinalReteIva = 41;
    public static final int columnavalorFinalReteCree = 42;
    public static final int columnaaplicaBaseMinimaMv = 43;
    public static final int columnanumeroregistro = 44;
    public static final int columnafecha = 45;
    public static final int columnaiddocumentofuente = 46;
    public static final int columnanumeroconsecutivo = 47;
    public static final int columnaaccionSobreInventario = 48;
    public static final int columnacantidadKardex = 49;
    public static final int columnasaldo = 50;
    public static final int columnacostounitario = 51;
    public static final int columnaajuste = 52;
    public static final int columnasaldocantidad = 53;
    public static final int columnaexistencia = 54;
    public static final int columnaaplicaSerial = 55;
    public static final int columnaidPlantilla = 56;
    public static final int columnaprecioDolar = 57;

    public GUITransaccionesRegistrar(Usuario usuario, Establecimiento establecimiento) {
        super(usuario, establecimiento);

        altoBoton = ((CargaImagenes.ALTO_PANTALLA / 6) / 3);
        anchoBoton = ((CargaImagenes.ANCHO_PANTALLA - 2 * (CargaImagenes.ANCHO_PANTALLA / 10)) / 6) - ((((CargaImagenes.ANCHO_PANTALLA - 2 * (CargaImagenes.ANCHO_PANTALLA / 10)) / 6)) / 6);

        this.setTitle(nombreClase);
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, nombreClase.toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
        //Prepara elementos Principales de interfaz
//        prepararElementosRegistro1();
//
//        preparaElementosBotones();
//        preparaElementosBotones2();
//        preparaElementosNotas();
//        preparaElementosDescripcionItem();
//
//        //Prepara Dialogo De Plantilla y tablas
//        preparaDialogPlantilla();
//        preparaElementosDocumentosFuenteBase();
//        cargarDatosDocumentosFuenteBase();
//        preparaElementosNumeroDialogoPlantilla();
//        cargarDatosNumeroDialogPlantilla();
//        //Prepara Dialogo de retencion
//        prepareDialogRetencion();
//        prepareElementostablaReteTotal();
//        //prepara dialogo de renumeracion
//        prepareElementosDialogoRenumerar();
//        //Prepara tablas y carga de tablas
//        preparaElementosTablaPrincipal();
//        prepararElementosRegistro2();
//        //cargarTablaPrincipalTemporal();
//        //cargarDatosTransaccionPrincipal();
//        preparaElementosDocumentosFuente();
//        cargarDatosDocumentosFuente();
//        prepareElementosTablaTerceros();
//        //cargarDatosTerceros();
//        prepareElementosTablaProducto();
//        cargarDatosProducto();
//        preparaElementosTablaBodega();
//        cargarDatosBodega();
//        preparaElementosTablaVendedor();
//        cargarDatosVendedor();
//
//        //metod para deshacer los Filtro de todas las tablas		
//        deshacerFiltroGeneral();
//        //metodoq que prepara el dialogo para modificar las retenciones	
//        PrepareElementosDialogoModificarRetenciones();
//        //metodo que prepara el dialog para el control de numeros de serie
//        preparaDialogNumeroSerie();
//        preparaElementosTablaNumerosDeSerieEntrada();
//        preparaDialogNumeroSerieSalida();
//        preparaElementosTablaNumerosDeSerieSalida();
//        preparaElementosTablaNumerosDeSerieSalida2();
//
//        //carga las temporales del mv y ñla transaccio
//        cargarTablaPrincipalTemporal();
//        cargarDatosTransaccionPrincipal();
//
//        //metodo que valida si el campo numero fijo es enabled o no
//        validarEnabletxtNumerFijo();
//
//        //metodo que cargar los costos de cada producto
//        actualizarValoresCostoPorProducto();
//
//        // CONTIENE LAS ACCIONES DE LOS DIFERENTES COMPONENTES	
//        //metodo que carga los label de numero articulos e Items
//        accionLblNumeroItemsYArticulos();
//
//        //metoso que carga los label de subtotal y total
//        accionLblTotalYSubtotal();
//
//        //metodos de acciones de los diferentes coomponenetes		
//        accionesJtextMouseListener();
//        accionesJtextFocusListener();
//        accionesJtextKeyListener();
//        accionesTextArea();
//        accionesBotones();
//        accionesTablas();
//        accionJframe(this);
//
//        if (check_facDOlares.isSelected()) {
//            accionLblTotalYSubtotal();
//        }
//
//        // manejo pos
//        manejoPos = new GUIDialogPos(frame, usuario, "R");
//        manejoPos.prepareDialogPos();
//        manejoPos.accionesComponentes();
//        if (!docPos.isEmpty()) {
//            txt_documento.setText(docPos);
//            txt_documento.getFocusListeners()[2].focusLost(new FocusEvent(txt_documento, 1000));
//        }
//
//        inicializar();
    }

    @Override
    public void actualizarFrame() {
        dialogModificRetenciones.setVisible(false);
        panelTablaTerceros.setVisible(false);
        panel_documentofuente.setVisible(false);
        panel_notas.setVisible(false);
        panelDescripcionItem.setVisible(false);
        panel_producto.setVisible(false);
        panel_bodega.setVisible(false);
        panel_vendedor.setVisible(false);
        DialogPlantilla.setVisible(false);
        DialogRetencion.setVisible(false);
        panel_numeroDialog.setVisible(false);
        panel_documentofuenteBase.setVisible(false);
        dialogNumeroSerial.setVisible(false);

//        cargarDatosProducto();
//        cargarDatosTerceros();
//        deshacerFiltroProducto();
    }

    /**
     * @param metodo que prepara los elementos de registro 1
     */
    public void prepararElementosRegistro1() {
        int posicionXTxt = CargaImagenes.ANCHO_PANTALLA / 100 * 13;
        int posicionYtxt = CargaImagenes.ALTO_PANTALLA / 100 * 4;
        int posicionXLbl = CargaImagenes.ANCHO_PANTALLA / 100 * 6;
        int posicionYLbl = CargaImagenes.ALTO_PANTALLA / 100;

        /////////////////////////LABEL/////////////////////
        lbl_nombreDocFuente = new CampoLabel("", CampoLabel.labelVariable);
        lbl_nombreDocFuente.setBounds(posicionXLbl, posicionYLbl, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_nombreDocFuente);

        check_facDOlares = new CasillaVerificacion("Fac. en Dólares");
        check_facDOlares.setBounds(posicionXLbl * 4, posicionYLbl, anchoBoton, altoBoton / 2);
        this.add(check_facDOlares);

        lbl_trm = new CampoLabel("T.R.M.:", CampoLabel.labelEstatico);
        lbl_trm.setBounds(posicionXLbl * 5 + posicionXLbl / 3, posicionYLbl, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_trm);
        lbl_trm.setVisible(false);

        txt_trm = new CajaDeTexto(CajaDeTexto.textoMoneda);
        txt_trm.setBounds(posicionXLbl * 6, posicionYLbl, anchoBoton / 2, 20);
        this.add(txt_trm);
        txt_trm.setVisible(false);

        lbl_documento = new CampoLabel("Documento: ", CampoLabel.labelEstatico);
        lbl_documento.setBounds(posicionXLbl, lbl_nombreDocFuente.getY() + lbl_nombreDocFuente.getHeight(), anchoBoton, altoBoton / 2);
        this.add(lbl_documento);

        lbl_numero = new CampoLabel("Número: ", CampoLabel.labelEstatico);
        lbl_numero.setBounds(posicionXLbl, lbl_documento.getY() + lbl_documento.getHeight() + 5, anchoBoton, altoBoton / 2);
        this.add(lbl_numero);

        lbl_fecha = new CampoLabel("Fecha: ", CampoLabel.labelEstatico);
        lbl_fecha.setBounds(posicionXLbl, lbl_numero.getY() + lbl_numero.getHeight() + 5, anchoBoton, altoBoton / 2);
        this.add(lbl_fecha);

        Font fuenteLabel = new Font("Arial", Font.BOLD, 8);
        lbl_formatoFecha = new CampoLabel("(DD/MM/YYYY)", CampoLabel.labelEstatico);
        lbl_formatoFecha.setFont(fuenteLabel);
        lbl_formatoFecha.setBounds(lbl_fecha.getX() + lbl_fecha.getWidth() / 7, lbl_fecha.getY() + 9, anchoBoton * 2, altoBoton / 2);
//		this.add(lbl_formatoFecha);

        lbl_nit = new CampoLabel("NIT/c.c: ", CampoLabel.labelEstatico);
        lbl_nit.setBounds(posicionXLbl, lbl_fecha.getY() + lbl_fecha.getHeight() + 5, anchoBoton, altoBoton / 2);
        this.add(lbl_nit);

        lbl_condiciones = new CampoLabel("Condiciones: ", CampoLabel.labelEstatico);
        lbl_condiciones.setBounds(posicionXLbl, lbl_nit.getY() + lbl_nit.getHeight() + 5, anchoBoton, altoBoton / 2);
        this.add(lbl_condiciones);

        lbl_nombre = new CampoLabel("Tercero: ", CampoLabel.labelEstatico);
        lbl_nombre.setBounds(lbl_documento.getX() * 7 / 2 + lbl_documento.getWidth(), lbl_documento.getY(), anchoBoton, altoBoton / 2);
        this.add(lbl_nombre);

        lbl_nombreDin = new CampoLabel("", CampoLabel.labelEstatico);
        lbl_nombreDin.setBounds(lbl_nombre.getX() + lbl_nombre.getWidth(), lbl_nombre.getY(), anchoBoton * 2, altoBoton / 2);
        this.add(lbl_nombreDin);

        lbl_direccion = new CampoLabel("Dirección: ", CampoLabel.labelEstatico);
        lbl_direccion.setBounds(lbl_nombre.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_direccion);

        lbl_direccionDin = new CampoLabel("", CampoLabel.labelVariable);
        lbl_direccionDin.setBounds(lbl_nombreDin.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_direccionDin);

        lbl_ciudad = new CampoLabel("Ciudad: ", CampoLabel.labelEstatico);
        lbl_ciudad.setBounds(lbl_nombre.getX(), lbl_direccion.getY() + lbl_direccion.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_ciudad);

        lbl_ciudadDin = new CampoLabel("", CampoLabel.labelVariable);
        lbl_ciudadDin.setBounds(lbl_direccionDin.getX(), lbl_direccion.getY() + lbl_direccion.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_ciudadDin);

        lbl_telefono = new CampoLabel("Teléfono: ", CampoLabel.labelEstatico);
        lbl_telefono.setBounds(lbl_nombre.getX(), lbl_ciudad.getY() + lbl_ciudad.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_telefono);

        lbl_telefonoDin = new CampoLabel("", CampoLabel.labelVariable);
        lbl_telefonoDin.setBounds(lbl_ciudadDin.getX(), lbl_ciudad.getY() + lbl_ciudad.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        this.add(lbl_telefonoDin);

        lbl_numeroDocumento = new CampoLabel("Num. Documento: ", CampoLabel.labelEstatico);
        lbl_numeroDocumento.setBounds(lbl_nombre.getX(), lbl_telefono.getY() + lbl_telefono.getHeight() + 5, anchoBoton * 2, altoBoton / 2);
        lbl_numeroDocumento.setVisible(false);
        this.add(lbl_numeroDocumento);

        lbl_listaDePrecios = new CampoLabel("Lista de Precios:  ", CampoLabel.labelEstatico);
        lbl_listaDePrecios.setBounds(lbl_nombreDocFuente.getX() * 8 + lbl_nombreDocFuente.getWidth(), lbl_nombreDocFuente.getY(), anchoBoton * 2, altoBoton / 2);
        lbl_listaDePrecios.setVisible(false);
        this.add(lbl_listaDePrecios);

        lbl_listaDePreciosResult = new CampoLabel("", CampoLabel.labelVariable);
        lbl_listaDePreciosResult.setBounds(lbl_listaDePrecios.getX() + lbl_listaDePrecios.getWidth() / 2, lbl_listaDePrecios.getY(), anchoBoton, 20);
        lbl_listaDePreciosResult.setVisible(false);
        this.add(lbl_listaDePreciosResult);

        lbl_vence = new CampoLabel("Vence: ", CampoLabel.labelEstatico);
        lbl_vence.setBounds(lbl_listaDePrecios.getX(), lbl_direccion.getY(), anchoBoton, altoBoton / 2);
        this.add(lbl_vence);
        lbl_vence.setVisible(false);

        lbl_vendedor = new CampoLabel("Código vendedor: ", CampoLabel.labelEstatico);
        lbl_vendedor.setBounds(lbl_vence.getX(), lbl_ciudad.getY(), anchoBoton, altoBoton / 2);
        this.add(lbl_vendedor);

        lbl_nombreVendedor = new CampoLabel("Nombre vendedor: ", CampoLabel.labelEstatico);
        lbl_nombreVendedor.setBounds(lbl_vendedor.getX(), lbl_telefono.getY(), anchoBoton, altoBoton / 2);
        this.add(lbl_nombreVendedor);

        lbl_resNombreVendedor = new CampoLabel("", CampoLabel.labelVariable);
        lbl_resNombreVendedor.setBounds(lbl_listaDePrecios.getX() + lbl_listaDePrecios.getWidth() / 2, lbl_nombreVendedor.getY(), anchoBoton * 3, 20);
        this.add(lbl_resNombreVendedor);

        lbl_documentoBase = new CampoLabel("Documento Base: ", CampoLabel.labelEstatico);
        lbl_documentoBase.setBounds(lbl_nombreVendedor.getX(), lbl_numeroDocumento.getY(), anchoBoton * 2, altoBoton / 2);
        this.add(lbl_documentoBase);
        lbl_documentoBase.setVisible(false);

        lbl_documentoBaseDocFuente = new CampoLabel("", CampoLabel.labelVariable);
        lbl_documentoBaseDocFuente.setBounds(lbl_resNombreVendedor.getX(), lbl_documentoBase.getY(), anchoBoton / 2, altoBoton / 2);
        this.add(lbl_documentoBaseDocFuente);
        lbl_documentoBaseDocFuente.setVisible(false);

        lbl_documentoBaseNumero = new CampoLabel("", CampoLabel.labelVariable);
        lbl_documentoBaseNumero.setBounds(lbl_documentoBaseDocFuente.getX() + lbl_documentoBaseDocFuente.getHeight(), lbl_documentoBaseDocFuente.getY(), anchoBoton, altoBoton / 2);
        this.add(lbl_documentoBaseNumero);
        lbl_documentoBaseNumero.setVisible(false);

        //////////////////JTEXTFIELD////////////////////////////
        txt_descuentoDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_TipoDescuentoDOcFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_aplicaRetenciones = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_aplicaIvaDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_llevaBodegaDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_idBodegaDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_accionSobreInventario = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_costeKardex = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_interfaceDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_llevaClienteFijo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_listaPrecioDoc = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_listaPrecioTercero = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_ControlExistenciaDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_preCostoDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_cuentasPorPagar = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_cuentasPorCobrar = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_llevaDocumentoBase = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_documentoBaseObligatorio = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_documentoBaseUnico = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_idDocumentoBaseUnico = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_aplicaIvaTercero = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_diasVencimientoTercero = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        lbl_numDocumentoTercero = new CampoLabel("", CampoLabel.labelVariable);
        lbl_digitoVerificacion = new CampoLabel("", CampoLabel.labelVariable);
        txt_DocFuentePos = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_esAutoRete = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);

        txt_idDocumentoFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_documento = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_documento.setBounds(posicionXTxt, posicionYtxt, anchoBoton, 20);
        this.add(txt_documento);

        txt_TipoClienteDocFuente = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_numeracion = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_numeroFijo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_documentoCierre = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_documentoAntiguo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);

        txt_numero = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros);
        txt_numero.setBounds(posicionXTxt, lbl_numero.getY(), anchoBoton, 20);
        this.add(txt_numero);

//        txt_fecha = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
//        try {
//            mascara = new MaskFormatter("##/##/####");
//            
//            txt_fecha = new JFormattedTextField(mascara);
//            txt_fecha.setFocusLostBehavior(JFormattedTextField.PERSIST);
//            txt_fecha.setBounds(posicionXTxt, lbl_fecha.getY(), anchoBoton, 20);
//            txt_fecha.setFont(Letra.getFuenteTxt());
//            txt_fecha.setForeground(Letra.getColorTxt());
//            txt_fecha.setDisabledTextColor(Letra.getColorTxtDisable());
//            this.add(txt_fecha);
//
//        } catch (ParseException e) {
//            Log.addException(e, "5636", usuario, nombreClase, "Ha ocurrido un error con la mascara de la fecha.");
//            e.printStackTrace();
//            JOptionPane.showOptionDialog(frame, "Ha ocurrido un error con la mascara de la fecha.", "Error (5636)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
//        }
//
//        txt_nombreTipoRegimen = new CajaDeTexto();
//        txt_codigoTipoRegimen = new CajaDeTexto();
//        txt_asumeReteIvaTipoRegimen = new CajaDeTexto();
//        txt_idTipoRegimen = new CajaDeTexto();
//        txt_idTercero = new CajaDeTexto();
//        txt_nitAntiguo = new CajaDeTexto();
//        txt_ControlExistenciaProducto = new CajaDeTexto();
//        txt_numeroDeSerieProducto = new CajaDeTexto();
//        txt_llevaNUmerodeSerie = new CajaDeTexto();
//        txt_nit = new CajaDeTexto();
//        txt_nit.setBounds(posicionXTxt, lbl_nit.getY(), anchoBoton, 20);
//        txt_nit.setFont(Letra.getFuenteTxt());
//        txt_nit.setForeground(Letra.getColorTxt());
//        txt_nit.setDisabledTextColor(Letra.getColorTxtDisable());
//        this.add(txt_nit);
//
//        txt_condiciones = new CajaDeTexto();
//        txt_condiciones.setBounds(posicionXTxt, lbl_condiciones.getY(), anchoBoton + anchoBoton / 2, 20);
//        txt_condiciones.setFont(Letra.getFuenteTxt());
//        txt_condiciones.setForeground(Letra.getColorTxt());
//        txt_condiciones.setDisabledTextColor(Letra.getColorTxtDisable());
//        this.add(txt_condiciones);
//
//        txt_numDocumento = new CajaDeTexto();
//        txt_numDocumento.setBounds(lbl_telefonoDin.getX(), txt_condiciones.getY(), anchoBoton, 20);
//        txt_numDocumento.setFont(Letra.getFuenteTxt());
//        txt_numDocumento.setForeground(Letra.getColorTxt());
//        txt_numDocumento.setDisabledTextColor(Letra.getColorTxtDisable());
//        txt_numDocumento.setVisible(false);
//        this.add(txt_numDocumento);
//
//        try {
//            mascara2 = new MaskFormatter("##/##/####");
//            txt_vence = new JFormattedTextField(mascara2);
//            txt_vence.setFocusLostBehavior(JFormattedTextField.PERSIST);
//            txt_vence.setBounds(lbl_listaDePrecios.getX() + txt_documento.getWidth(), lbl_vence.getY(), anchoBoton, 20);
//            txt_vence.setFont(Letra.getFuenteTxt());
//            txt_vence.setForeground(Letra.getColorTxt());
//            txt_vence.setDisabledTextColor(Letra.getColorTxtDisable());
//            txt_vence.setVisible(false);
//            this.add(txt_vence);
//        } catch (ParseException e) {
//            Log.addException(e, "5675", usuario, nombreClase, "Ha ocurrido un error con la mascara de la fecha.");
//            e.printStackTrace();
//            JOptionPane.showOptionDialog(frame, "Ha ocurrido un error con la mascara de la fecha.", "Error (5675)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
//        }
//
//        txt_llevaVendedor = new CajaDeTexto();
//        txt_idVendedor = new CajaDeTexto();
//        txt_vendedor = new CajaDeTexto();
//        txt_vendedor.setBounds(txt_vence.getX(), lbl_vendedor.getY(), anchoBoton, 20);
//        txt_vendedor.setFont(Letra.getFuenteTxt());
//        txt_vendedor.setForeground(Letra.getColorTxt());
//        txt_vendedor.setDisabledTextColor(Letra.getColorTxtDisable());
//        this.add(txt_vendedor);

    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_documento.grabFocus();
    }

    @Override
    public void asignarPermisos() {
        //To change body of generated methods, choose Tools | Templates.
    }

}
