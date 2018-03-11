package activa.Expendio.vista;

import activa.Expendio.controllers.*;
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
public class GUIRegistroConsignaciones extends ClaseGeneral {

    // Campos Informacion
    private CampoLabel lbl_numeroTransaccion, lbl_fecha;
    private CampoLabel lbl_td, lbl_nombre, lbl_saldoActual, lbl_estado;
    private Long idInterno;
    private CajaDeTexto txt_numeroTransaccion;
    private CajaDeTextoConFormato txt_fecha;
    private CajaDeTexto txt_td;
    private CampoLabel txt_nombre, txt_saldoActual, txt_estado;
    private JLabel lbl_imagenFoto;

    // Campos Movimiento
    private CampoLabel lbl_concepto, lbl_numeroRecibo, lbl_valor, lbl_cajasEspeciales, lbl_observaciones;
    private CampoCombo<String> combo_concepto;
    private CajaDeTexto txt_numeroRecibo, txt_valor, txt_cajasEspeciales;
    private CajaTextoArea txt_observaciones;
    private JScrollPane scroll_observaciones;

    // Botones
    private JPanel panel_botones;
    private Boton btn_registrar, btn_reporte, btn_otro, btn_borrar, btn_salir;

    // Utilitarios
    private static final String nombreClase = "Registro de Consignaciones y Traslados";
    public static final int limiteCaracteresNumero = 15;
    public static final int limiteCaracteresTD = String.valueOf(Configuracion.codigoEstablecimiento).length() + 6;

    public GUIRegistroConsignaciones(Usuario usuario) {
        super(usuario);

        prepareElementos();
        prepareElementosInformacion();
        prepareElementosMovimiento();
        prepareBotones();

        definaAccionesInformacion();
        definaAccionesMovimiento();
        definaAccionesBotones();

        inicializar();
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, nombreClase.toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
    }

    /**
     * Método encargado del diseño del frame, tamaño, fondo.
     */
    private void prepareElementos() {
        this.setTitle(nombreClase);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
    }

    private void prepareElementosInformacion() {
        int posicionX = CargaImagenes.ANCHO_PANTALLA / 100 * 4;
        int posicionY = CargaImagenes.ALTO_PANTALLA / 100 * 10;
        int altoObjetos = 25;
        int anchoTxt = CargaImagenes.ANCHO_PANTALLA / 10;
        int anchoLabel = CargaImagenes.ANCHO_PANTALLA / 18;
        int var = 10;

        lbl_numeroTransaccion = new CampoLabel("Transacción #:", CampoLabel.labelEstatico);
        lbl_numeroTransaccion.alinearIzquierda();
        lbl_numeroTransaccion.setLocation(posicionX, posicionY);
        lbl_numeroTransaccion.setSize(anchoLabel + anchoTxt, altoObjetos);
        this.add(lbl_numeroTransaccion);

        txt_numeroTransaccion = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresNumero);
        txt_numeroTransaccion.setLocation(lbl_numeroTransaccion.getX() + (lbl_numeroTransaccion.getWidth() / 2) + var, lbl_numeroTransaccion.getY());
        txt_numeroTransaccion.setSize(anchoTxt, altoObjetos);
        this.add(txt_numeroTransaccion);

        lbl_fecha = new CampoLabel("Fecha:", CampoLabel.labelEstatico);
        lbl_fecha.alinearIzquierda();
        lbl_fecha.setLocation(lbl_numeroTransaccion.getX(), lbl_numeroTransaccion.getY() + lbl_numeroTransaccion.getHeight() + var * 2);
        lbl_fecha.setSize(lbl_numeroTransaccion.getWidth(), lbl_numeroTransaccion.getHeight());
        this.add(lbl_fecha);

        txt_fecha = new CajaDeTextoConFormato(CajaDeTexto.textoFecha, usuario);
        txt_fecha.setLocation(txt_numeroTransaccion.getX(), lbl_fecha.getY());
        txt_fecha.setSize(txt_numeroTransaccion.getWidth(), txt_numeroTransaccion.getHeight());
        this.add(txt_fecha);

        lbl_td = new CampoLabel("TD:", CampoLabel.labelEstatico);
        lbl_td.setLocation(lbl_fecha.getX(), lbl_fecha.getY() + lbl_fecha.getHeight() + var * 2);
        lbl_td.setSize(lbl_fecha.getWidth(), lbl_fecha.getHeight());
        lbl_td.alinearIzquierda();
        this.add(lbl_td);

        txt_td = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresTD);
        txt_td.setLocation(txt_fecha.getX(), lbl_td.getY());
        txt_td.setSize(txt_fecha.getWidth(), txt_fecha.getHeight());
        this.add(txt_td);

        lbl_nombre = new CampoLabel("Nombre Completo:", CampoLabel.labelEstatico);
        lbl_nombre.setLocation(txt_td.getX(), lbl_td.getY() + lbl_td.getHeight() + var * 2);
        lbl_nombre.setSize(txt_td.getWidth(), lbl_td.getHeight());
        lbl_nombre.alinearIzquierda();
        this.add(lbl_nombre);

        txt_nombre = new CampoLabel("", CampoLabel.labelVariable);
        txt_nombre.setLocation(lbl_nombre.getX() + lbl_nombre.getWidth() + var, lbl_nombre.getY());
        txt_nombre.setSize(txt_td.getWidth() * 3, txt_td.getHeight());
        this.add(txt_nombre);

        lbl_saldoActual = new CampoLabel("Saldo Actual:", CampoLabel.labelEstatico);
        lbl_saldoActual.setLocation(lbl_nombre.getX(), lbl_nombre.getY() + lbl_nombre.getHeight() + var * 2);
        lbl_saldoActual.setSize(lbl_nombre.getWidth(), lbl_nombre.getHeight());
        lbl_saldoActual.alinearIzquierda();
        this.add(lbl_saldoActual);

        txt_saldoActual = new CampoLabel("", CampoLabel.labelVariable);
        txt_saldoActual.setLocation(txt_nombre.getX(), lbl_saldoActual.getY());
        txt_saldoActual.setSize(txt_td.getWidth(), txt_td.getHeight());
        this.add(txt_saldoActual);

        lbl_estado = new CampoLabel("Estado:", CampoLabel.labelEstatico);
        lbl_estado.setLocation(txt_saldoActual.getX() + txt_saldoActual.getWidth() + var * 2, txt_saldoActual.getY());
        lbl_estado.setSize(lbl_saldoActual.getWidth() * 2 / 3, lbl_saldoActual.getHeight());
        lbl_estado.alinearIzquierda();
        this.add(lbl_estado);

        txt_estado = new CampoLabel("", CampoLabel.labelVariable);
        txt_estado.setLocation(lbl_estado.getX() + lbl_estado.getWidth() + var, lbl_estado.getY());
        txt_estado.setSize(txt_saldoActual.getWidth(), txt_saldoActual.getHeight());
        this.add(txt_estado);

        int anchoImg = this.getWidth() / 8;
        int altoImg = this.getHeight() / 5;

        lbl_imagenFoto = new JLabel();
        lbl_imagenFoto.setLocation(txt_nombre.getX() + txt_nombre.getWidth() / 2, txt_fecha.getY() - var * 2);
        lbl_imagenFoto.setSize(anchoImg / 2, altoImg * 2 / 3);
        lbl_imagenFoto.setBorder(new PanelBorde(""));
        this.add(lbl_imagenFoto);
    }

    private void prepareElementosMovimiento() {// Elementos MV
        int var = 10;

        lbl_concepto = new CampoLabel("Concepto:", CampoLabel.labelEstatico);
        lbl_concepto.setLocation(txt_saldoActual.getX() + txt_saldoActual.getWidth() / 2, lbl_saldoActual.getY() + lbl_saldoActual.getHeight() + var * 6);
        lbl_concepto.setSize(lbl_td.getWidth() / 2, lbl_td.getHeight());
        lbl_concepto.alinearIzquierda();
        this.add(lbl_concepto);

        combo_concepto = new CampoCombo<String>();
        combo_concepto.setLocation(lbl_concepto.getX() + lbl_concepto.getWidth() + var, lbl_concepto.getY());
        combo_concepto.setSize(txt_nombre.getWidth(), txt_nombre.getHeight());
        this.add(combo_concepto);

        lbl_numeroRecibo = new CampoLabel("Recibo #:", CampoLabel.labelEstatico);
        lbl_numeroRecibo.setLocation(lbl_concepto.getX(), lbl_concepto.getY() + lbl_concepto.getHeight() + var * 2);
        lbl_numeroRecibo.setSize(lbl_concepto.getWidth() * 2 / 3, lbl_concepto.getHeight());
        lbl_numeroRecibo.alinearIzquierda();
        this.add(lbl_numeroRecibo);

        txt_numeroRecibo = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, limiteCaracteresNumero);
        txt_numeroRecibo.setLocation(combo_concepto.getX(), lbl_numeroRecibo.getY());
        txt_numeroRecibo.setSize(txt_numeroTransaccion.getWidth() * 3 / 2, txt_numeroTransaccion.getHeight());
        this.add(txt_numeroRecibo);

        lbl_valor = new CampoLabel("Valor:", CampoLabel.labelEstatico);
        lbl_valor.setLocation(lbl_numeroRecibo.getX(), lbl_numeroRecibo.getY() + lbl_numeroRecibo.getHeight() + var * 2);
        lbl_valor.setSize(lbl_numeroRecibo.getWidth(), lbl_numeroRecibo.getHeight());
        lbl_valor.alinearIzquierda();
        this.add(lbl_valor);

        txt_valor = new CajaDeTexto(CajaDeTexto.textoMoneda);
        txt_valor.setLocation(txt_numeroRecibo.getX(), lbl_valor.getY());
        txt_valor.setSize(txt_numeroRecibo.getWidth() * 2 / 3, txt_numeroRecibo.getHeight());
        this.add(txt_valor);

        lbl_cajasEspeciales = new CampoLabel("Cajas Especiales:", CampoLabel.labelEstatico);
        lbl_cajasEspeciales.setLocation(txt_valor.getX() + txt_valor.getWidth() + var * 2, txt_valor.getY());
        lbl_cajasEspeciales.setSize(lbl_valor.getWidth() * 2, lbl_valor.getHeight());
        lbl_cajasEspeciales.alinearIzquierda();
        this.add(lbl_cajasEspeciales);

        txt_cajasEspeciales = new CajaDeTexto(CajaDeTexto.textoMoneda);
        txt_cajasEspeciales.setLocation(lbl_cajasEspeciales.getX() + lbl_cajasEspeciales.getWidth() + var, lbl_cajasEspeciales.getY());
        txt_cajasEspeciales.setSize(txt_valor.getWidth(), txt_valor.getHeight());
        this.add(txt_cajasEspeciales);

        lbl_observaciones = new CampoLabel("Observaciones:", CampoLabel.labelEstatico);
        lbl_observaciones.setLocation(lbl_valor.getX(), lbl_valor.getY() + lbl_valor.getHeight() + var * 2);
        lbl_observaciones.setSize(lbl_valor.getWidth() * 3 / 2, lbl_valor.getHeight());
        lbl_observaciones.alinearIzquierda();
        this.add(lbl_observaciones);

        txt_observaciones = new CajaTextoArea(CajaDeTexto.textoLetrasNumeros);
        txt_observaciones.setLocation(lbl_observaciones.getX() + lbl_observaciones.getWidth() + var, lbl_observaciones.getY());
        txt_observaciones.setSize(combo_concepto.getWidth(), (combo_concepto.getHeight() + var) * 2);

        scroll_observaciones = new JScrollPane(txt_observaciones);
        scroll_observaciones.setLocation(txt_observaciones.getX(), txt_observaciones.getY());
        scroll_observaciones.setSize(txt_observaciones.getWidth(), txt_observaciones.getHeight());
        scroll_observaciones.setOpaque(false);
        scroll_observaciones.getViewport().setOpaque(false);
        this.add(scroll_observaciones);
    }

    private void prepareBotones() {
        int var = 10;

        btn_registrar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Grabar");
        btn_registrar.setLocation(lbl_cajasEspeciales.getX() + lbl_cajasEspeciales.getWidth() / 2, txt_observaciones.getY() + txt_observaciones.getHeight() + var * 9);
        btn_registrar.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_registrar);
        btn_registrar.setToolTipText("Grabar");

        btn_otro = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Otro");
        btn_otro.setLocation(btn_registrar.getX() + btn_registrar.getWidth() + 5, btn_registrar.getY());
        btn_otro.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_otro);
        btn_otro.setToolTipText("Otro");

        btn_borrar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Borrar");
        btn_borrar.setLocation(btn_otro.getX() + btn_otro.getWidth() + 5, btn_otro.getY());
        btn_borrar.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_borrar);
        btn_borrar.setToolTipText("Borrar");

        btn_reporte = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Reporte");
        btn_reporte.setLocation(btn_borrar.getX() + btn_borrar.getWidth() + 5, btn_borrar.getY());
        btn_reporte.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_reporte);
        btn_reporte.setToolTipText("Reporte");

        btn_salir = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Salir");
        btn_salir.setLocation(btn_reporte.getX() + btn_reporte.getWidth() + 5, btn_reporte.getY());
        btn_salir.setSize(CargaImagenes.anchoBotonGeneral, CargaImagenes.altoBotonGeneral);
        this.add(btn_salir);
        btn_salir.setToolTipText("Salir");
    }

    private void definaAccionesInformacion() {// Definiendo acciones
        ValidacionCampos.asignarTeclasDireccion(txt_numeroTransaccion, null, txt_fecha, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_fecha, txt_numeroTransaccion, txt_td, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_td, txt_fecha, combo_concepto, null, null);
    }

    private void definaAccionesMovimiento() {
        ValidacionCampos.asignarTeclasDireccion(combo_concepto, txt_td, txt_numeroRecibo, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_numeroRecibo, combo_concepto, txt_valor, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_valor, txt_numeroRecibo, txt_cajasEspeciales, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_cajasEspeciales, txt_valor, txt_observaciones, null, null);
        ValidacionCampos.asignarTeclasDireccion(txt_observaciones, txt_cajasEspeciales, btn_registrar, null, null);
    }

    private void definaAccionesBotones() {
        btn_registrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonRegistrar();
            }
        });

        btn_otro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonOtro();
            }
        });

        btn_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonBorrar();
            }
        });

        btn_reporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonReporte();
            }
        });

        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonSalir();
            }
        });
    }

    private void accionBotonRegistrar() {
        //
    }

    private void accionBotonOtro() {
        //
    }

    private void accionBotonBorrar() {
        //
    }

    private void accionBotonReporte() {
        //
    }

    @Override
    public void actualizarFrame() {
        txt_numeroTransaccion.setText("");
        txt_fecha.setText("");

        idInterno = null;
        txt_td.setText("");
        txt_nombre.setText("");
        txt_saldoActual.setText("");
        txt_estado.setText("");
        lbl_imagenFoto.setIcon(null);

        combo_concepto.setSelectedIndex(-1);
        txt_numeroRecibo.setText("");
        txt_valor.setText("");
        txt_cajasEspeciales.setText("");
        txt_observaciones.setText("");

        btn_otro.setEnabled(false);
        btn_reporte.setEnabled(false);
    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        txt_numeroTransaccion.grabFocus();
    }

    @Override
    public void asignarPermisos() {
        //To change body of generated methods, choose Tools | Templates.
    }

}
