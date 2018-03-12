/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.utils.Boton;
import activa.Expendio.vista.utils.CajaDeTexto;
import activa.Expendio.vista.utils.CajaDeTextoConFormato;
import activa.Expendio.vista.utils.CampoLabel;
import activa.Expendio.vista.utils.Tabla;
import activa.Expendio.vista.utils.TablaNoEditable;
import java.awt.Dimension;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import utils.CargaImagenes;
import utils.Imagenes;
import utils.NombreImagenes;

/**
 *
 * @author diego
 */
public class GUITransaccion extends ClaseGeneral {
    
    public CampoLabel lbl_nombreDocFuente;
    
    private CampoLabel lbl_documento , lbl_numero, lbl_fecha , lbl_nit, lbl_condiciones , lbl_nombre , lbl_nombreDin, lbl_direccion, lbl_direccionDin, lbl_ciudad , lbl_ciudadDin , lbl_telefono , lbl_telefonoDin , lbl_numDocumentoTercero;
    private CajaDeTexto txt_fechaAntigua, txt_idDocumentoFuente, txt_documento, txt_documentoAntiguo, txt_numeracion, txt_numeroFijo ,txt_documentoCierre, txt_numero, txt_estado ,  txt_idTercero, txt_nit ,txt_nitAntiguo, txt_idTipoRegimen ,txt_nombreTipoRegimen , txt_codigoTipoRegimen , txt_asumeReteIvaTipoRegimen,  txt_condiciones, txt_numDocumento,  txt_idVendedor, txt_vendedor, txt_llevaVendedor, txt_TipoClienteDocFuente , txt_descuentoDocFuente , txt_TipoDescuentoDOcFuente, txt_aplicaRetenciones, txt_aplicaIvaDocFuente, txt_llevaBodegaDocFuente, txt_idBodegaDocFuente, txt_accionSobreInventario, txt_costeKardex, txt_interfaceDocFuente, txt_llevaClienteFijo, txt_listaPrecioDoc, txt_listaPrecioTercero , txt_ControlExistenciaDocFuente, txt_preCostoDocFuente,txt_cuentasPorCobrar, txt_cuentasPorPagar, txt_idTransaccionOriginal, txt_esAutoRete, txt_ControlExistenciaProducto;
    private CajaDeTextoConFormato txt_fecha;
    
        ////////////panel REGISTRO2 MVTRANSACCION///////////
    private CampoLabel lbl_codigo, lbl_descripcion, lbl_empaque, lbl_bodega , lbl_cantidad , lbl_valorUnitario  , lbl_valorTolal; 	
    private CajaDeTexto txt_idCodigo, txt_codigo,  txt_descripcion, txt_empaque, txt_idBodega , txt_bodega , txt_idTransaccion;
    private CajaDeTexto txt_cantidad , txt_ValorUnitario , txt_valorTotal;

    //////////////////PANEL BOTONES 2////////////////////
    public CampoLabel lbl_adicionar , lbl_borrar , lbl_insertar  , lbl_modificar, lbl_repetir , lbl_cancelarMV , lbl_guardarMv , lbl_costoProducto ,lbl_costoProductoTotal, lbl_NombreExistencia, lbl_ResultadoExistencia;
    public Boton       btn_adicionar ,btn_borrar2,	btn_insertar , btn_modificar , btn_repetir, btn_cancelarMv , btn_guardarMv;
    
    ///////////////////PANEL PREPARA TABLA PRINCIPAL///////////////////////
    public JPanel panel_tablaPrincipal;
    public DefaultTableModel dtmTablaPrincipal;
    public JTable tablaPrincipal;
    public JScrollPane scrollpanePrincipal;
    public String DatosTablaPrincipal[];
    public TableRowSorter<DefaultTableModel> trsFiltrotablaPrincipal;
    
    public static int columnaCodigo =0;
    public static int columnaDescripcion =1;
    public static int columnaEmpaque =2;
    public static int columnaBodega =3;
    public static int columnaCantidad =4;
    public static int columnaVunitario =5;
    public static int columnaVtotal =6;
    public static int columnaidBodega =7;
  
    
    public GUITransaccion(Usuario usuario ){
        super(usuario);
        prepareElementos();
        prepareElementosInfo();
        preparaElementosTablaPrincipal();
        prepararElementosRegistro2();
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "".toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);

    }  

        /**
     * Método encargado del diseño del frame, tamaño, fondo.
     */
    protected void prepareElementos() {
        this.setTitle("Transacciones");
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
    }
    
    /**
     * 
     */
    private void prepareElementosInfo(){

            int posicionXTxt = CargaImagenes.ANCHO_PANTALLA/100*13 ;
            int posicionYtxt = CargaImagenes.ALTO_PANTALLA/100*4-5;
            int posicionXLbl = CargaImagenes.ANCHO_PANTALLA/100*6;
            int posicionYLbl = CargaImagenes.ALTO_PANTALLA/100;
		
		
		/////////////////////////LABEL/////////////////////

        lbl_nombreDocFuente =new CampoLabel("" ,"V");
        lbl_nombreDocFuente.alinearIzquierda();
        lbl_nombreDocFuente.setBounds(posicionXLbl, posicionYLbl, CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_nombreDocFuente);

        lbl_documento = new CampoLabel("Documento:  ", "E");
        lbl_documento.alinearIzquierda();
        lbl_documento.setBounds(posicionXLbl, lbl_nombreDocFuente.getY()+lbl_nombreDocFuente.getHeight(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_documento);


        lbl_numero = new CampoLabel("Número:  ", "E");
        lbl_numero.alinearIzquierda();
        lbl_numero.setBounds(posicionXLbl, lbl_documento.getY()+lbl_documento.getHeight()+5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_numero);

        lbl_fecha = new CampoLabel("Fecha:  ", "E");
        lbl_fecha.alinearIzquierda();
        lbl_fecha.setBounds(posicionXLbl, lbl_numero.getY()+lbl_numero.getHeight()+5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_fecha);


        lbl_nit = new CampoLabel("NIT/c.c:  ", "E");
        lbl_nit.alinearIzquierda();
        lbl_nit.setBounds(posicionXLbl, lbl_fecha.getY()+lbl_fecha.getHeight()+5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_nit);


        lbl_condiciones = new CampoLabel("Condiciones:  ", "E");
        lbl_condiciones.alinearIzquierda();
        lbl_condiciones.setBounds(posicionXLbl, lbl_nit.getY()+lbl_nit.getHeight()+5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_condiciones);


        lbl_nombre = new CampoLabel("Tercero:  ", "E");
        lbl_nombre.alinearIzquierda();
        lbl_nombre.setBounds(lbl_documento.getX()*7/2+lbl_documento.getWidth(), lbl_documento.getY(), CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_nombre);


        lbl_nombreDin = new CampoLabel("", "V");
        lbl_nombreDin.alinearIzquierda();
        lbl_nombreDin.setBounds(lbl_nombre.getX()+lbl_nombre.getWidth(), lbl_nombre.getY(), CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_nombreDin);


        lbl_direccion = new CampoLabel("Direccion:  ", "E");
        lbl_direccion.alinearIzquierda();
        lbl_direccion.setBounds(lbl_nombre.getX(), lbl_nombre.getY()+lbl_nombre.getHeight()+5, CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_direccion);


        lbl_direccionDin = new CampoLabel("", "V");
        lbl_direccionDin.alinearIzquierda();
        lbl_direccionDin.setBounds(lbl_nombreDin.getX(), lbl_nombre.getY()+lbl_nombre.getHeight()+5, CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_direccionDin);


        lbl_ciudad = new CampoLabel("Ciudad:  ", "E");
        lbl_ciudad.alinearIzquierda();
        lbl_ciudad.setBounds(lbl_nombre.getX(), lbl_direccion.getY()+lbl_direccion.getHeight()+5, CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_ciudad);


        lbl_ciudadDin = new CampoLabel("", "V");
        lbl_ciudadDin.alinearIzquierda();
        lbl_ciudadDin.setBounds(lbl_direccionDin.getX(), lbl_direccion.getY()+lbl_direccion.getHeight()+5, CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_ciudadDin);


        lbl_telefono = new CampoLabel("Teléfono:  ", "E");
        lbl_telefono.alinearIzquierda();
        lbl_telefono.setBounds(lbl_nombre.getX(), lbl_ciudad.getY()+lbl_ciudad.getHeight()+5, CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_telefono);

        lbl_telefonoDin = new CampoLabel("", "V");
        lbl_telefonoDin.alinearIzquierda();
        lbl_telefonoDin.setBounds(lbl_ciudadDin.getX(), lbl_ciudad.getY()+lbl_ciudad.getHeight()+5, CargaImagenes.anchoBotonGeneral*2, CargaImagenes.altoBotonGeneral/2);
        this.add(lbl_telefonoDin);





                //////////////////JTEXTFIELD////////////////////////////


        txt_idDocumentoFuente = new CajaDeTexto("G"); 

        
        txt_documento = new CajaDeTexto("G",15);
        txt_documento.setBounds(posicionXTxt, posicionYtxt, CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_documento);

        txt_TipoClienteDocFuente = new CajaDeTexto("G");
        txt_numeracion = new CajaDeTexto("G");
        txt_numeroFijo = new CajaDeTexto("G");
        txt_documentoCierre = new CajaDeTexto("G");
        txt_documentoAntiguo = new CajaDeTexto("G");

        txt_numero = new CajaDeTexto("G",15);
        txt_numero.setBounds(posicionXTxt, lbl_numero.getY(), CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_numero);

        txt_fecha = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fecha.setBounds(posicionXTxt, lbl_fecha.getY(), CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_fecha);
 
        txt_idTercero = new CajaDeTexto("G");
        txt_nitAntiguo = new CajaDeTexto("G");
        txt_ControlExistenciaProducto = new CajaDeTexto("G");
        
        
        txt_nit = new CajaDeTexto("G",50);
        txt_nit.setBounds(posicionXTxt, lbl_nit.getY(), CargaImagenes.anchoBotonGeneral, 20);
        this.add(txt_nit);

        txt_condiciones = new CajaDeTexto("G",500);
        txt_condiciones.setBounds(posicionXTxt, lbl_condiciones.getY(), CargaImagenes.anchoBotonGeneral+CargaImagenes.anchoBotonGeneral/2, 20);
        this.add(txt_condiciones);


    }
    
    	/**
	 * @param metodo que prepara los elementos de registro 2 
	 */
	public void prepararElementosRegistro2(){

		int posicionXTxt = panel_tablaPrincipal.getX();
		int posicionYTxt = CargaImagenes.ALTO_PANTALLA/100*27;
		int posicionYlbl = CargaImagenes.ALTO_PANTALLA/100*23;
		
		lbl_codigo = new CampoLabel("Código", "E");
		lbl_codigo.alinearCentro();
		lbl_codigo.setBounds(posicionXTxt, posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaCodigo).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_codigo);
		

		lbl_descripcion = new CampoLabel("Descripción  ", "E");
		lbl_descripcion.alinearCentro();
		lbl_descripcion.setBounds(lbl_codigo.getX()+lbl_codigo.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_descripcion);
		
		
		lbl_empaque = new CampoLabel("Empaque", "E");
		lbl_empaque.alinearCentro();
		lbl_empaque.setBounds(lbl_descripcion.getX()+lbl_descripcion.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_empaque);
		
		lbl_bodega = new CampoLabel("Bodega", "E");
		lbl_bodega.alinearCentro();
		lbl_bodega.setBounds(lbl_empaque.getX()+lbl_empaque.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaBodega).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_bodega);
		
		
		lbl_cantidad = new CampoLabel("Cantidad", "E");
		lbl_cantidad.alinearCentro();
		lbl_cantidad.setBounds(lbl_bodega.getX()+lbl_bodega.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaCantidad).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_cantidad);
		
		lbl_valorUnitario = new CampoLabel("Valor Unitario  ", "E");
		lbl_valorUnitario.alinearCentro();
		lbl_valorUnitario.setBounds(lbl_cantidad.getX()+lbl_cantidad.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaVunitario).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_valorUnitario);
		
		
		lbl_valorTolal = new CampoLabel("Valor Total  ", "E");
		lbl_valorTolal.alinearCentro();
		lbl_valorTolal.setBounds(lbl_valorUnitario.getX()+lbl_valorUnitario.getWidth(), posicionYlbl, tablaPrincipal.getColumnModel().getColumn(columnaVtotal).getMaxWidth(), CargaImagenes.altoBotonGeneral/5*4);
		this.add(lbl_valorTolal);

		
		txt_idTransaccion = new CajaDeTexto("G");
		txt_idCodigo = new CajaDeTexto("G");
		
		
		txt_codigo = new CajaDeTexto("G", 20);
		txt_codigo.setBounds(posicionXTxt, posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaCodigo).getMaxWidth(), 20);
		this.add(txt_codigo);
		
		txt_descripcion = new CajaDeTexto("G", 20);
		txt_descripcion.setBounds(txt_codigo.getX()+txt_codigo.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).getMaxWidth(), 20);
		this.add(txt_descripcion);
		txt_descripcion.setEnabled(false);
		
		txt_empaque = new CajaDeTexto("G", 20);
		txt_empaque.setBounds(txt_descripcion.getX()+txt_descripcion.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).getMaxWidth(), 20);
		this.add(txt_empaque);
		txt_empaque.setEnabled(false);
		
		txt_idBodega = new CajaDeTexto("G", 20);
		txt_bodega = new CajaDeTexto("G", 20);
                txt_bodega.setBounds(txt_empaque.getX()+txt_empaque.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaBodega).getMaxWidth(), 20);
		this.add(txt_bodega);
	
		txt_cantidad = new CajaDeTexto("D", 20);
		txt_cantidad.setBounds(txt_bodega.getX()+txt_bodega.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaCantidad).getMaxWidth(), 20);
		this.add(txt_cantidad);

		txt_ValorUnitario = new CajaDeTexto("M", 20);
		txt_ValorUnitario.setBounds(txt_cantidad.getX()+txt_cantidad.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaVunitario).getMaxWidth(), 20);
		this.add(txt_ValorUnitario);
		
		txt_valorTotal = new CajaDeTexto("M", 20);
		txt_valorTotal.setBounds(txt_ValorUnitario.getX()+txt_ValorUnitario.getWidth(), posicionYTxt, tablaPrincipal.getColumnModel().getColumn(columnaVtotal).getMaxWidth(), 20);
		txt_valorTotal.setEnabled(false);
		this.add(txt_valorTotal);
	}

    
    	/**
	 *  metodo que prepara la tabla de principal 
	 */
	private void preparaElementosTablaPrincipal() {

		panel_tablaPrincipal = new JPanel();
		panel_tablaPrincipal.setBounds(CargaImagenes.ANCHO_PANTALLA/40, CargaImagenes.ALTO_PANTALLA/40*12 , (CargaImagenes.ANCHO_PANTALLA / 40)*38, CargaImagenes.ALTO_PANTALLA / 40*12);
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
                
		tablaPrincipal.setPreferredScrollableViewportSize(new Dimension(CargaImagenes.ANCHO_PANTALLA - 80,(CargaImagenes.ALTO_PANTALLA - (CargaImagenes.ALTO_PANTALLA / 6) - (CargaImagenes.ALTO_PANTALLA / 4)) - 80));
		scrollpanePrincipal = new JScrollPane(tablaPrincipal);
		tablaPrincipal.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		panel_tablaPrincipal.add(scrollpanePrincipal);
		scrollpanePrincipal.setSize(panel_tablaPrincipal.getWidth(), panel_tablaPrincipal.getHeight());
		scrollpanePrincipal.setLocation(0, 0);
		tablaPrincipal.getTableHeader().setReorderingAllowed(false);

		tablaPrincipal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaPrincipal.setDefaultRenderer(Object.class,new Tabla.MiRender());
		tablaPrincipal.setShowHorizontalLines(false);
		tablaPrincipal.setBorder(null);
		tablaPrincipal.setOpaque(false);
		scrollpanePrincipal.setOpaque(false);
		scrollpanePrincipal.getViewport().setOpaque(false);
		scrollpanePrincipal.setBorder(null);
		tablaPrincipal.getTableHeader().setPreferredSize(new Dimension(10000, 32));



		//int columna1=ANCHO_PANTALLA/130;
		int columna1=CargaImagenes.ANCHO_PANTALLA/24;
        
        tablaPrincipal.getColumnModel().getColumn(columnaidBodega).setMaxWidth(0);
        tablaPrincipal.getColumnModel().getColumn(columnaidBodega).setMinWidth(0);
        tablaPrincipal.getColumnModel().getColumn(columnaidBodega).setPreferredWidth(0);
                
        tablaPrincipal.getColumnModel().getColumn(columnaCodigo).setMaxWidth(columna1*3);
        tablaPrincipal.getColumnModel().getColumn(columnaCodigo).setMinWidth(columna1*1);
        tablaPrincipal.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(columna1*3);
        
        tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).setMaxWidth(columna1*8);
        tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).setMinWidth(columna1*4);
        tablaPrincipal.getColumnModel().getColumn(columnaDescripcion).setPreferredWidth(columna1*8);
        
        tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).setMaxWidth(columna1*3/2);
        tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).setMinWidth(columna1/2);
        tablaPrincipal.getColumnModel().getColumn(columnaEmpaque).setPreferredWidth(columna1*3/2);
        
        tablaPrincipal.getColumnModel().getColumn(columnaBodega).setMaxWidth(columna1*3/2);
        tablaPrincipal.getColumnModel().getColumn(columnaBodega).setMinWidth(columna1/2);
        tablaPrincipal.getColumnModel().getColumn(columnaBodega).setPreferredWidth(columna1*3/2);
        
        tablaPrincipal.getColumnModel().getColumn(columnaCantidad).setMaxWidth(columna1*2);
        tablaPrincipal.getColumnModel().getColumn(columnaCantidad).setMinWidth(columna1);
        tablaPrincipal.getColumnModel().getColumn(columnaCantidad).setPreferredWidth(columna1*2);
        
        tablaPrincipal.getColumnModel().getColumn(columnaVunitario).setMaxWidth(columna1*3);
        tablaPrincipal.getColumnModel().getColumn(columnaVunitario).setMinWidth(columna1);
        tablaPrincipal.getColumnModel().getColumn(columnaVunitario).setPreferredWidth(columna1*3);
        
        tablaPrincipal.getColumnModel().getColumn(columnaVtotal).setMaxWidth(columna1*4);
        tablaPrincipal.getColumnModel().getColumn(columnaVtotal).setMinWidth(columna1*2);
        tablaPrincipal.getColumnModel().getColumn(columnaVtotal).setPreferredWidth(columna1*4);
        
        
	}
        
        	/**
	 *  metodo que prepara los botones secundarios 
	 */
	public void preparaElementosBotones2(){
		
		int anchoBotonB = CargaImagenes.anchoBotonMini;
		int altoBotonB =  CargaImagenes.altoBotonMini;
		
		int posicionXBtn = CargaImagenes.ANCHO_PANTALLA/100;
		int posicionYBtn = CargaImagenes.ALTO_PANTALLA/100*63;
		
		int posicionXLbl = CargaImagenes.ANCHO_PANTALLA/100;
		int posicionYLbl = CargaImagenes.ALTO_PANTALLA/100*67;
		
		lbl_adicionar = new CampoLabel("Adicionar", "E");
		lbl_adicionar.alinearDerecha();
		lbl_adicionar.setBounds(posicionXLbl, posicionYLbl, CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		this.add(lbl_adicionar);
		
		lbl_guardarMv = new CampoLabel("Guardar", "E");
		lbl_guardarMv.alinearDerecha();
		lbl_guardarMv.setBounds(posicionXLbl-5, posicionYLbl, CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		lbl_guardarMv.setVisible(false);
		this.add(lbl_guardarMv);
		
		lbl_borrar = new CampoLabel("Borrar", "E");
		lbl_borrar.alinearCentro();
		lbl_borrar.setBounds(lbl_adicionar.getX()+lbl_adicionar.getWidth(),lbl_adicionar.getY(), CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		this.add(lbl_borrar);

		lbl_insertar = new CampoLabel("Insertar", "E");
		lbl_insertar.alinearIzquierda();
		lbl_insertar.setBounds(lbl_borrar.getX()+lbl_borrar.getWidth(), lbl_borrar.getY(), CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		this.add(lbl_insertar);
		
		lbl_modificar = new CampoLabel("Modificar", "E");
		lbl_modificar.alinearIzquierda();
		lbl_modificar.setBounds(lbl_insertar.getX()+lbl_insertar.getWidth()-5, lbl_insertar.getY(), CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		this.add(lbl_modificar);
		
		lbl_cancelarMV = new CampoLabel("Cancelar", "E");
		lbl_cancelarMV.alinearIzquierda();
		lbl_cancelarMV.setBounds(lbl_insertar.getX()+lbl_insertar.getWidth()-5, lbl_modificar.getY(), CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		lbl_cancelarMV.setVisible(false);
		this.add(lbl_cancelarMV);
		
		lbl_repetir = new CampoLabel("Repetir", "E");
		lbl_repetir.alinearIzquierda();
		lbl_repetir.setBounds(lbl_modificar.getX()+lbl_modificar.getWidth()-5, lbl_cancelarMV.getY(), CargaImagenes.anchoBotonGeneral/2, CargaImagenes.altoBotonGeneral/5*2);
		this.add(lbl_repetir);
		

		
		btn_adicionar = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "A");
		this.add(btn_adicionar);
		btn_adicionar.setToolTipText("adicionar");
		btn_adicionar.setLocation(posicionXBtn, posicionYBtn);
		btn_adicionar.setSize(anchoBotonB,altoBotonB);
		
		btn_guardarMv = new Boton(NombreImagenes.imBGeneralMini1,NombreImagenes.imBGeneralMini2 , "G");
		this.add(btn_guardarMv);
		btn_guardarMv.setToolTipText("adicionar");
		btn_guardarMv.setLocation(posicionXBtn, posicionYBtn);
		btn_guardarMv.setSize(anchoBotonB,altoBotonB);
		btn_guardarMv.setVisible(false);
		
		btn_borrar2 = new Boton(NombreImagenes.imBGeneralMini1,NombreImagenes.imBGeneralMini2 , "B");
		this.add(btn_borrar2);
		btn_borrar2.setToolTipText("borrar2");
		btn_borrar2.setLocation(btn_adicionar.getX()+btn_adicionar.getWidth(), btn_adicionar.getY());
		btn_borrar2.setSize(anchoBotonB,altoBotonB);
		
		btn_insertar = new Boton(NombreImagenes.imBGeneralMini1,NombreImagenes.imBGeneralMini2 , "I");
		this.add(btn_insertar);
		btn_insertar.setToolTipText("insertar");
		btn_insertar.setLocation(btn_borrar2.getX()+btn_borrar2.getWidth()	, btn_borrar2.getY());
		btn_insertar.setSize(anchoBotonB,altoBotonB);


		btn_modificar = new Boton(NombreImagenes.imBGeneralMini1,NombreImagenes.imBGeneralMini2 , "M");
		this.add(btn_modificar);
		btn_modificar.setToolTipText("Modificar");
		btn_modificar.setLocation(btn_insertar.getX()+btn_insertar.getWidth(), btn_insertar.getY());
		btn_modificar.setSize(anchoBotonB,altoBotonB);
		
		btn_cancelarMv = new Boton(NombreImagenes.imBGeneralMini1,NombreImagenes.imBGeneralMini2 , "C");
		this.add(btn_cancelarMv);
		btn_cancelarMv.setToolTipText("Cancelar");
		btn_cancelarMv.setLocation(btn_insertar.getX()+btn_insertar.getWidth(), btn_modificar.getY());
		btn_cancelarMv.setSize(anchoBotonB,altoBotonB);
		btn_cancelarMv.setVisible(false);
		
		btn_repetir = new Boton(NombreImagenes.imBGeneralMini1, NombreImagenes.imBGeneralMini2, "R");
		this.add(btn_repetir);
		btn_repetir.setToolTipText("Repetir");
		btn_repetir.setLocation(btn_modificar.getX()+btn_modificar.getWidth()	, btn_cancelarMv.getY());
		btn_repetir.setSize(anchoBotonB,altoBotonB);
	}
    
    @Override
    public void actualizarFrame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarReferencia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPermisos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
