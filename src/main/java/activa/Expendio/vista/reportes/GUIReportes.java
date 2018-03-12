package activa.Expendio.vista.reportes;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.basic.*;
import utils.*;

public abstract class GUIReportes extends ClaseGeneral {

    private static final long serialVersionUID = -940143302784872363L;

    protected JPanel panel_informacion;
    protected JPanel panel_botones;
    protected Boton btn_salir;

    // Utilitarios
    protected int ANCHO_PANTALLA, ALTO_PANTALLA;

//    protected ReportesFinder reportFinder;
    public GUIReportes(Usuario usuario) {
        super(usuario);

        prepareElementos();

        prepareElementosPanelInformacion();
        prepareElementosPanelBotones();

        definaAccionesInformacion();
        definaAccionesBotones();

        super.tituloFrame(0, ALTO_PANTALLA / 100 * 2, getNombreClase().toUpperCase(), ANCHO_PANTALLA, 50);
    }

    /**
     * Obtiene el nombre de la clase actual.
     *
     * @return
     */
    protected abstract String getNombreClase();

    /**
     * Coloca los elementos en el panel de informacion.
     */
    protected abstract void elementosInformacion();

    /**
     * Coloca los botones en el panel correspondiente.
     */
    protected abstract void elementosBotones();

    /**
     * Define las acciones de los elementos de informacion.
     */
    protected abstract void definaAccionesInformacion();

    /**
     * Define las acciones de los botones.
     */
    protected abstract void accionesBotones();

    /**
     * Obtiene el boton anterior al boton de salir.
     *
     * @return
     */
    protected abstract Boton botonAnterior();

    /**
     * Colocar teclas de acceso rapido a los botones.
     *
     * @param e
     */
    protected abstract void otrosKeyButtonsMiddle(KeyEvent evt);

    /**
     * Inicializa todos los campos de los elementos de informacion.
     */
    protected abstract void inicializarCampos();

    /**
     * Realiza otras inicializaciones a la pantalla.
     */
    protected abstract void otrasInicializaciones();

    private void prepareElementos() {
        this.setTitle(getNombreClase());

        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);
    }

    /**
     * Prepara los elementos del panel de informacion.
     */
    protected void prepareElementosPanelInformacion() {// XXX Panel de Informacion
        panel_informacion = new JPanel();
        panel_informacion.setLocation(ANCHO_PANTALLA / 45, ALTO_PANTALLA / 7 - (ALTO_PANTALLA / 7));
        panel_informacion.setSize(ANCHO_PANTALLA, 4 * (ALTO_PANTALLA / 12) + (ALTO_PANTALLA / 10));
        panel_informacion.setLayout(null);
        panel_informacion.setOpaque(false);
        this.add(panel_informacion);

        elementosInformacion();
    }

    /**
     * Prepara los elementos del panel de botones.
     */
    protected void prepareElementosPanelBotones() {// XXX Panel de botones
        panel_botones = new JPanel();

        int filas = (4 * (ALTO_PANTALLA / 18)) / 6;
        panel_botones.setLocation(3 * ANCHO_PANTALLA / 12, 10 * filas);
        panel_botones.setSize(5 * ANCHO_PANTALLA / 10, (ALTO_PANTALLA / 6) / 3);

        panel_botones.setLayout(new GridLayout(1, 0));
        panel_botones.setOpaque(false);
        this.add(panel_botones);

        elementosBotones();

        btn_salir = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Salir");
        panel_botones.add(new PanelBoton(btn_salir));
        btn_salir.setToolTipText("ESC");
    }

    private void definaAccionesBotones() {
        accionesBotones();

        btn_salir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                accionBotonSalir();
            }
        });
        btn_salir.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT: {
                        botonAnterior().grabFocus();
                    }
                    break;
                    case KeyEvent.VK_ENTER: {
                        btn_salir.doClick();
                    }
                    break;
                }
                setKeysButtonsMiddle(e);
            }
        });
    }

    /**
     * Asigna accesos rapidos a los botones del medio.
     *
     * @param e
     */
    protected final void setKeysButtonsMiddle(KeyEvent evt) {
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                btn_salir.grabFocus();
                btn_salir.doClick();
                break;
            default:
                otrosKeyButtonsMiddle(evt);
                break;
        }
    }

    /**
     * Metodo encargado de asignar el siguiente foco.
     *
     * @param objetoPrincipal
     * @param objetoSiguiente
     */
    public static final void asignarSiguiente(JComponent objetoPrincipal, JComponent objetoSiguiente) {
        ValidacionCampos.asignarTeclasDireccion2(objetoPrincipal, null, objetoSiguiente, null, null);
    }

    /**
     * Metodo encargado de asignar el siguiente foco y el anterior tambien.
     *
     * @param objetoPrincipal
     * @param objetoSiguiente
     * @param objetoAnterior
     */
    public static final void asignarSiguienteAnterior(JComponent objetoPrincipal, JComponent objetoSiguiente, JComponent objetoAnterior) {
        ValidacionCampos.asignarTeclasDireccion2(objetoPrincipal, objetoAnterior, objetoSiguiente, null, null);
    }

    @Override
    public final void actualizarFrame() {
//        reportFinder = new ReportesFinder(usuario);

        inicializarCampos();
        otrasInicializaciones();
        asignarFoco();
    }

    @Override
    public final void eliminarReferencia() {
    }

    @Override
    public final void asignarPermisos() {
    }

}
