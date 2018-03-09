package activa.Expendio.vista;

import activa.Expendio.modelo.Establecimiento;
import activa.Expendio.modelo.Usuario;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUIMenu extends ClaseGeneral {

    private CampoLabel lbl_fecha, lbl_nombreUsuario, lbl_nombreEmpresa, lbl_periodoContable;

    // Panel Botones Principales 
    private JPanel panel_botonesPrincipales;
    private Boton btn_catalogos, btn_transaccion, btn_reportes, btn_configuracion, btn_salir;

    // Panel Boton Catalogos
    private JPanel panel_BotonCatalogos;
    private Boton btn_catalogoInternos, btn_catalogoDocumentos, btn_catalogoBodegas, btn_catalogoGrupos, btn_catalogoProductos;

    // Panel Boton Transacciones
    private JPanel panel_BotonTransacciones;

    // Panel Boton Reportes
    private JPanel panel_BotonReportes;

    // Panel Boton Configuracion
    private JPanel panel_BotonConfiguracion;
    private Boton btn_configuracionUsuarios, btn_configuracionEditorFormatos, btn_configuracionClaveDelDia, btn_configuracionGeneral, btn_configuracionActualizacionBD, btn_configuracionParametros;

    // Panel Usuarios
    private JPanel panel_configuracionUsuarios;
    private Boton btn_usuarioAdicionar, btn_usuarioDesactivar, btn_usuarioPermisos;

    private int anchoBotonesPanel1, altoBotonesPanel1;

    public GUIMenu(Usuario usuario, Establecimiento establecimiento) {
        super(usuario, establecimiento);

        Imagenes.fondoInternalFrame(NombreImagenes.imFondoMenu, this.getWidth(), this.getHeight(), this);
        anchoBotonesPanel1 = 2 * this.getWidth() / 7;
        altoBotonesPanel1 = 2 * this.getHeight() / 25;

        prepareElementosBotonesPrincipales();
        prepareElementosInformacionPrograma();
        prepareMostrarPanelCatalogos();
        prepareMostrarPanelConfiguracion();
        prepareMostrarPanelConfiguracionUsuarios();
        prepareMostrarPanelTransaccion();
        prepareMostrarPanelReporte();

        definaAccionesBotonesPrincipales();
        accionBotonesPanelCatalogo();
        accionBotonesPanelConfiguracion();
        accionBotonesPanelConfiguracionUsuarios();
        accionBotonesPanelTransaccion();
        accionBotonesPanelReporte();

        inicializar();
    }

    /**
     * Metodo encargado de crear la inforamcion del programa donde esta empresa
     * usuario periodo contable etc.
     */
    private void prepareElementosInformacionPrograma() {
        lbl_fecha = new CampoLabel("", CampoLabel.labelVariable);
        this.add(lbl_fecha);
        lbl_fecha.setLocation(3 * this.getWidth() / 4 + this.getWidth() / 35 + 2, this.getHeight() / 9);
        lbl_fecha.setSize(300, this.getHeight() / 42);
        lbl_fecha.setToolTipText("Fecha");
        lbl_fecha.setForeground(Letra.colorLetraMenu);

        lbl_nombreUsuario = new CampoLabel("", CampoLabel.labelVariable);
        this.add(lbl_nombreUsuario);
        lbl_nombreUsuario.setLocation(3 * this.getWidth() / 4 + this.getWidth() / 35 + 2, this.getHeight() / 9 + this.getHeight() / 26);
        lbl_nombreUsuario.setSize(200, this.getHeight() / 42);
        lbl_nombreUsuario.setToolTipText("Usuario");
        lbl_nombreUsuario.setForeground(Letra.colorLetraMenu);

        lbl_nombreEmpresa = new CampoLabel("", CampoLabel.labelVariable);
        this.add(lbl_nombreEmpresa);
        lbl_nombreEmpresa.setLocation(3 * this.getWidth() / 4 + this.getWidth() / 35 + 2, this.getHeight() / 9 + this.getHeight() / 26 + this.getHeight() / 26);
        lbl_nombreEmpresa.setSize(200, this.getHeight() / 42);
        lbl_nombreEmpresa.setToolTipText("Establecimiento");
        lbl_nombreEmpresa.setForeground(Letra.colorLetraMenu);

        lbl_periodoContable = new CampoLabel("", CampoLabel.labelVariable);
        this.add(lbl_periodoContable);
        lbl_periodoContable.setLocation(3 * this.getWidth() / 4 + this.getWidth() / 35 + 2, this.getHeight() / 9 + this.getHeight() / 26 + this.getHeight() / 26 + this.getHeight() / 26);
        lbl_periodoContable.setSize(200, this.getHeight() / 42);
        lbl_periodoContable.setToolTipText("Periodo contable");
        lbl_periodoContable.setForeground(Letra.colorLetraMenu);
    }

    /**
     * Metodo encargado de crear los botones principales
     */
    private void prepareElementosBotonesPrincipales() {
        panel_botonesPrincipales = new JPanel();
        panel_botonesPrincipales.setLocation(0, 0);
        panel_botonesPrincipales.setSize(this.getWidth(), CargaImagenes.altoBotonesPrincipalesMenu);
        panel_botonesPrincipales.setLayout(new GridLayout(1, 0));
        panel_botonesPrincipales.setOpaque(false);

        btn_catalogos = new Boton(NombreImagenes.imBPrincipalPorDefectoMenu, NombreImagenes.imBPrincipalPorDefectoMenu2, "Catálogos");
        btn_catalogos.cambiarTamanoLabelBoton(CargaImagenes.anchoBotonesPrincipalesMenu, CargaImagenes.altoBotonesPrincipalesMenu);
        btn_catalogos.cambiarTamanoTexto(CargaImagenes.anchoBotonesPrincipalesMenu / 10f);
        panel_botonesPrincipales.add(btn_catalogos);
        btn_catalogos.setToolTipText("Catálogos");

        btn_transaccion = new Boton(NombreImagenes.imBPrincipalPorDefectoMenu, NombreImagenes.imBPrincipalPorDefectoMenu2, "Transacciones");
        btn_transaccion.cambiarTamanoLabelBoton(CargaImagenes.anchoBotonesPrincipalesMenu, CargaImagenes.altoBotonesPrincipalesMenu);
        btn_transaccion.cambiarTamanoTexto(CargaImagenes.anchoBotonesPrincipalesMenu / 10f);
        panel_botonesPrincipales.add(btn_transaccion);
        btn_transaccion.setToolTipText("Consultar");

        btn_reportes = new Boton(NombreImagenes.imBPrincipalPorDefectoMenu, NombreImagenes.imBPrincipalPorDefectoMenu2, "Reportes");
        btn_reportes.cambiarTamanoLabelBoton(CargaImagenes.anchoBotonesPrincipalesMenu, CargaImagenes.altoBotonesPrincipalesMenu);
        btn_reportes.cambiarTamanoTexto(CargaImagenes.anchoBotonesPrincipalesMenu / 10f);
        panel_botonesPrincipales.add(btn_reportes);
        btn_reportes.setToolTipText("Reportes");

        btn_configuracion = new Boton(NombreImagenes.imBPrincipalPorDefectoMenu, NombreImagenes.imBPrincipalPorDefectoMenu2, "Configuración");
        btn_configuracion.cambiarTamanoLabelBoton(CargaImagenes.anchoBotonesPrincipalesMenu, CargaImagenes.altoBotonesPrincipalesMenu);
        btn_configuracion.cambiarTamanoTexto(CargaImagenes.anchoBotonesPrincipalesMenu / 10f);
        panel_botonesPrincipales.add(btn_configuracion);
        btn_configuracion.setToolTipText("Configuración");

        this.add(panel_botonesPrincipales);

        btn_salir = new Boton(NombreImagenes.imBSalirMenu, NombreImagenes.imBSalirMenu2, "");
        this.add(btn_salir);
        btn_salir.setToolTipText("Salir");
        btn_salir.setSize(CargaImagenes.anchoBotonesPanelSalirMenu, CargaImagenes.altoBotonesPanelSalirMenu);
        btn_salir.setLocation(24 * this.getWidth() / 27, 16 * this.getHeight() / 19);
    }

    /**
     * Metodo encargado de dar accion a los botones principales
     */
    private void definaAccionesBotonesPrincipales() {
        btn_catalogos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel_BotonCatalogos.isVisible()) {
                    ocultarPanelesNivel1();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_catalogos);
                    panel_BotonCatalogos.setVisible(false);
                } else {
                    ocultarPanelesNivel1();
                    estadoInicialPanelCatalogos();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_catalogos);
                    panel_BotonCatalogos.setVisible(true);
                }
            }
        });
        btn_catalogos.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (panel_BotonCatalogos.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_catalogos);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_catalogos);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_catalogos);
            }
        });
        btn_catalogos.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (panel_BotonCatalogos.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_catalogos);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_catalogos);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_catalogos);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btn_catalogos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
                    seleccionarSeguienteConClick(panel_botonesPrincipales, btn_catalogos);
                } else if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_catalogos.doClick();
                } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
                    seleccionarAnteriorConClick(panel_botonesPrincipales, btn_catalogos);
                } else if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
                    for (int i = 0; i < panel_BotonCatalogos.getComponentCount(); i++) {
                        if (panel_BotonCatalogos.getComponent(i).isEnabled()) {
                            panel_BotonCatalogos.getComponent(i).requestFocus();
                            ((JButton) panel_BotonCatalogos.getComponent(i)).grabFocus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        //Boton Transacciones
        btn_transaccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel_BotonTransacciones.isVisible()) {
                    ocultarPanelesNivel1();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_transaccion);
                    panel_BotonTransacciones.setVisible(false);
                } else {
                    ocultarPanelesNivel1();
                    estadoInicialPanelTransaccion();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_transaccion);
                    panel_BotonTransacciones.setVisible(true);
                }
            }
        });
        btn_transaccion.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (panel_BotonTransacciones.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_transaccion);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_transaccion);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_transaccion);
            }
        });
        btn_transaccion.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (panel_BotonTransacciones.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_transaccion);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_transaccion);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_transaccion);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btn_transaccion.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
                    seleccionarSeguienteConClick(panel_botonesPrincipales, btn_transaccion);
                } else if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_catalogos.doClick();
                } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
                    seleccionarAnteriorConClick(panel_botonesPrincipales, btn_transaccion);
                } else if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
                    for (int i = 0; i < panel_BotonTransacciones.getComponentCount(); i++) {
                        if (panel_BotonTransacciones.getComponent(i).isEnabled()) {
                            panel_BotonTransacciones.getComponent(i).requestFocus();
                            ((JButton) panel_BotonTransacciones.getComponent(i)).grabFocus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        //Boton Reportes
        btn_reportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel_BotonReportes.isVisible()) {
                    ocultarPanelesNivel1();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_reportes);
                    panel_BotonReportes.setVisible(false);
                } else {
                    ocultarPanelesNivel1();
                    estadoInicialPanelReporte();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_reportes);
                    panel_BotonReportes.setVisible(true);
                }
            }
        });
        btn_reportes.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (panel_BotonReportes.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_reportes);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_reportes);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_reportes);
            }
        });
        btn_reportes.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (panel_BotonReportes.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_reportes);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_reportes);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_reportes);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btn_reportes.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
                    seleccionarSeguienteConClick(panel_botonesPrincipales, btn_reportes);
                } else if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_catalogos.doClick();
                } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
                    seleccionarAnteriorConClick(panel_botonesPrincipales, btn_reportes);
                } else if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
                    for (int i = 0; i < panel_BotonReportes.getComponentCount(); i++) {
                        if (panel_BotonReportes.getComponent(i).isEnabled()) {
                            panel_BotonReportes.getComponent(i).requestFocus();
                            ((JButton) panel_BotonReportes.getComponent(i)).grabFocus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        //Boton Configuracion
        btn_configuracion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel_BotonConfiguracion.isVisible()) {
                    ocultarPanelesNivel1();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_configuracion);
                    panel_BotonConfiguracion.setVisible(false);
                } else {
                    ocultarPanelesNivel1();
                    estadoInicialPanelConfiguracion();
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_configuracion);
                    panel_BotonConfiguracion.setVisible(true);
                }
            }
        });
        btn_configuracion.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (panel_BotonConfiguracion.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_configuracion);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_configuracion);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_configuracion);
            }
        });
        btn_configuracion.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (panel_BotonConfiguracion.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu3, btn_configuracion);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_configuracion);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu2, btn_configuracion);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btn_configuracion.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
                    seleccionarSeguienteConClick(panel_botonesPrincipales, btn_configuracion);
                } else if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_catalogos.doClick();
                } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
                    seleccionarAnteriorConClick(panel_botonesPrincipales, btn_configuracion);
                } else if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
                    for (int i = 0; i < panel_BotonConfiguracion.getComponentCount(); i++) {
                        if (panel_BotonConfiguracion.getComponent(i).isEnabled()) {
                            panel_BotonConfiguracion.getComponent(i).requestFocus();
                            ((JButton) panel_BotonConfiguracion.getComponent(i)).grabFocus();
                            break;
                        }
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });

        //Boton Salir
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int opcion = option.tipoMensaje(GUIJOption.mensajePregunta, "", "Advertencia", "¿Esta seguro que desea salir del programa?");
                if (opcion == JOptionPane.YES_OPTION) {
                    eliminarReferencia();
                    dispose();
//                    MainExpendio.control.cerrarApp();
                }
            }
        });
    }

    /**
     * Metodo encargado de crear los botones del Panel Actualizar
     */
    private void prepareMostrarPanelCatalogos() {
        panel_BotonCatalogos = new JPanel();
        panel_BotonCatalogos.setLayout(new GridLayout(0, 1));
        panel_BotonCatalogos.setLocation(this.getWidth() / 14, (this.getHeight() / 4));
        panel_BotonCatalogos.setOpaque(false);

        btn_catalogoInternos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Internos");
        btn_catalogoInternos.textoParaMenuPrimerNivel();
        panel_BotonCatalogos.add(btn_catalogoInternos);

        btn_catalogoDocumentos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Documentos Fuente");
        btn_catalogoDocumentos.textoParaMenuPrimerNivel();
        panel_BotonCatalogos.add(btn_catalogoDocumentos);

        btn_catalogoGrupos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Grupos de Producto");
        btn_catalogoGrupos.textoParaMenuPrimerNivel();
        panel_BotonCatalogos.add(btn_catalogoGrupos);

        btn_catalogoProductos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Productos");
        btn_catalogoProductos.textoParaMenuPrimerNivel();
        panel_BotonCatalogos.add(btn_catalogoProductos);

        btn_catalogoBodegas = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Bodegas");
        btn_catalogoBodegas.textoParaMenuPrimerNivel();
        panel_BotonCatalogos.add(btn_catalogoBodegas);

        this.add(panel_BotonCatalogos);

        panel_BotonCatalogos.setVisible(false);
        panel_BotonCatalogos.setSize(anchoBotonesPanel1, panel_BotonCatalogos.getComponentCount() * altoBotonesPanel1);
    }

    /**
     * Metodo encargado de dar acciones a los botones del panel del catalogo
     */
    private void accionBotonesPanelCatalogo() {
        btn_catalogoInternos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_catalogoInternos, btn_catalogos, panel_BotonCatalogos, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_catalogoInternos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUICatalogoInternos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });

        btn_catalogoDocumentos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_catalogoDocumentos, btn_catalogos, panel_BotonCatalogos, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_catalogoDocumentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUICatalogoDocumentos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });

        btn_catalogoGrupos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_catalogoGrupos, btn_catalogos, panel_BotonCatalogos, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_catalogoGrupos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUICatalogoGrupos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });

        btn_catalogoProductos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_catalogoProductos, btn_catalogos, panel_BotonCatalogos, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_catalogoProductos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUICatalogoProductos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });

        btn_catalogoBodegas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_catalogoBodegas, btn_catalogos, panel_BotonCatalogos, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_catalogoBodegas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setFrameAnterior(frame);
                new GUICatalogoBodegas(usuario, establecimiento,false);
                frame.setVisible(false);
            }
        });
    }

    /**
     * Metodo encargado de crear los botones del Panel Transacciones
     */
    private void prepareMostrarPanelTransaccion() {
        panel_BotonTransacciones = new JPanel();
        panel_BotonTransacciones.setLayout(new GridLayout(0, 1));
        panel_BotonTransacciones.setLocation(this.getWidth() / 14, (this.getHeight() / 4));
        panel_BotonTransacciones.setOpaque(false);

//        btn_transaPagos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Pagos");
//        btn_transaPagos.textoParaMenuPrimerNivel();
//        panel_BotonTransacciones.add(btn_transaPagos);
//
//        btn_transaGenerarMoras = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Generar Moras");
//        btn_transaGenerarMoras.textoParaMenuPrimerNivel();
//        panel_BotonTransacciones.add(btn_transaGenerarMoras);
        this.add(panel_BotonTransacciones);
        panel_BotonTransacciones.setVisible(false);
        panel_BotonTransacciones.setSize(anchoBotonesPanel1, panel_BotonTransacciones.getComponentCount() * altoBotonesPanel1);
    }

    /**
     * Metodo encargado de dar acciones a los botones del panel del catalogo
     */
    private void accionBotonesPanelTransaccion() {
//        btn_transaPagos.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (panel_trasaccionesPagos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_transaPagos);
//                    panel_trasaccionesPagos.setVisible(false);
//                } else {
//                    estadoInicialPanelTransaccion();
//                    ocultarPanelesNivel2();
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_transaPagos);
//                    panel_trasaccionesPagos.setLocation(panel_BotonTransacciones.getX() + panel_BotonTransacciones.getWidth() + anchoBotonesPanel1 / 14, panel_BotonTransacciones.getY() + btn_transaPagos.getY());
//                    panel_trasaccionesPagos.setVisible(true);
//                }
//            }
//        });
//        btn_transaPagos.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                accionesKeyListenerConClick(btn_transaPagos, btn_transaccion, panel_BotonTransacciones, panel_botonesPrincipales, e, panel_trasaccionesPagos);
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    if (!panel_trasaccionesPagos.isVisible()) {
//                        btn_transaPagos.doClick();
//                        panel_trasaccionesPagos.getComponent(0).requestFocus();
//                        ((JButton) panel_trasaccionesPagos.getComponent(0)).grabFocus();
//                    }
//                }
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//        });
//        btn_transaPagos.addFocusListener(new FocusListener() {
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (!panel_trasaccionesPagos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_transaPagos);
//                } else {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_transaPagos);
//                }
//            }
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (!panel_trasaccionesPagos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu2, btn_transaPagos);
//                }
//            }
//        });
//        btn_transaPagos.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseReleased(MouseEvent arg0) {
//            }
//
//            @Override
//            public void mousePressed(MouseEvent arg0) {
//            }
//
//            @Override
//            public void mouseExited(MouseEvent arg0) {
//                if (!panel_trasaccionesPagos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_transaPagos);
//                } else {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_transaPagos);
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent arg0) {
//                if (!panel_trasaccionesPagos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu2, btn_transaPagos);
//                }
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//            }
//        });
//
//        btn_transaGenerarMoras.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
////                usuario.setFrameAnterior(frame);
////                new GUICatalogoBodegas(usuario, establecimiento);
////                frame.setVisible(false);
//            }
//        });
//        btn_transaGenerarMoras.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                accionesKeyLIstenerConFoco(btn_transaGenerarMoras, btn_transaccion, panel_BotonCatalogos, panel_botonesPrincipales, e);
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//        });
    }

    /**
     * Metodo encargado de crear los botones del Panel Reportes
     */
    private void prepareMostrarPanelReporte() {
        panel_BotonReportes = new JPanel();
        panel_BotonReportes.setLayout(new GridLayout(0, 1));
        panel_BotonReportes.setLocation(this.getWidth() / 14, (this.getHeight() / 4));
        panel_BotonReportes.setOpaque(false);

//        btn_reportesListadoAlumnos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, Imagenes, "Listado de Alumnos");
//        btn_reportesListadoAlumnos.textoParaMenuPrimerNivel();
//        panel_BotonReportes.add(btn_reportesListadoAlumnos);
        this.add(panel_BotonReportes);
        panel_BotonReportes.setVisible(false);
        panel_BotonReportes.setSize(anchoBotonesPanel1, panel_BotonReportes.getComponentCount() * altoBotonesPanel1);
    }

    /**
     * Metodo encargado de dar acciones a los botones del panel de reportes
     */
    private void accionBotonesPanelReporte() {
//        btn_reportesListadoAlumnos.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (panel_reportesListadoAlumnos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_reportesListadoAlumnos);
//                    panel_reportesListadoAlumnos.setVisible(false);
//                } else {
//                    estadoInicialPanelReporte();
//                    ocultarPanelesNivel2();
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_reportesListadoAlumnos);
//                    panel_reportesListadoAlumnos.setLocation(panel_BotonReportes.getX() + panel_BotonReportes.getWidth() + anchoBotonesPanel1 / 14, panel_BotonReportes.getY() + btn_reportesListadoAlumnos.getY());
//                    panel_reportesListadoAlumnos.setVisible(true);
//                }
//            }
//        });
//        btn_reportesListadoAlumnos.addKeyListener(new KeyListener() {
//            @Override
//            public void keyTyped(KeyEvent e) {
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                accionesKeyListenerConClick(btn_reportesListadoAlumnos, btn_reportes, panel_BotonReportes, panel_botonesPrincipales, e, panel_reportesListadoAlumnos);
//                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
//                    if (!panel_reportesListadoAlumnos.isVisible()) {
//                        btn_reportesListadoAlumnos.doClick();
//                        panel_reportesListadoAlumnos.getComponent(0).requestFocus();
//                        ((JButton) panel_reportesListadoAlumnos.getComponent(0)).grabFocus();
//                    }
//                }
//            }
//
//            @Override
//            public void keyPressed(KeyEvent e) {
//            }
//        });
//        btn_reportesListadoAlumnos.addFocusListener(new FocusListener() {
//            @Override
//            public void focusLost(FocusEvent e) {
//                if (!panel_reportesListadoAlumnos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_reportesListadoAlumnos);
//                } else {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_reportesListadoAlumnos);
//                }
//            }
//
//            @Override
//            public void focusGained(FocusEvent e) {
//                if (!panel_reportesListadoAlumnos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu2, btn_reportesListadoAlumnos);
//                }
//            }
//        });
//        btn_reportesListadoAlumnos.addMouseListener(new MouseListener() {
//            @Override
//            public void mouseReleased(MouseEvent arg0) {
//            }
//
//            @Override
//            public void mousePressed(MouseEvent arg0) {
//            }
//
//            @Override
//            public void mouseExited(MouseEvent arg0) {
//                if (!panel_reportesListadoAlumnos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_reportesListadoAlumnos);
//                } else {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_reportesListadoAlumnos);
//                }
//            }
//
//            @Override
//            public void mouseEntered(MouseEvent arg0) {
//                if (!panel_reportesListadoAlumnos.isVisible()) {
//                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu2, btn_reportesListadoAlumnos);
//                }
//            }
//
//            @Override
//            public void mouseClicked(MouseEvent arg0) {
//            }
//        });
    }

    /**
     * Metodo encargado de crear los botones del Panel Actualizar
     */
    private void prepareMostrarPanelConfiguracion() {
        panel_BotonConfiguracion = new JPanel();
        panel_BotonConfiguracion.setLayout(new GridLayout(0, 1));
        panel_BotonConfiguracion.setLocation(this.getWidth() / 14, (this.getHeight() / 4));
        panel_BotonConfiguracion.setOpaque(false);

        btn_configuracionUsuarios = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Usuarios");
        btn_configuracionUsuarios.textoParaMenuPrimerNivel();
        panel_BotonConfiguracion.add(btn_configuracionUsuarios);

        btn_configuracionEditorFormatos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Editor Formatos");
        btn_configuracionEditorFormatos.textoParaMenuPrimerNivel();
        panel_BotonConfiguracion.add(btn_configuracionEditorFormatos);

        btn_configuracionClaveDelDia = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Clave del Día");
        btn_configuracionClaveDelDia.textoParaMenuPrimerNivel();
        panel_BotonConfiguracion.add(btn_configuracionClaveDelDia);

        btn_configuracionGeneral = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Configuración General");
        btn_configuracionGeneral.textoParaMenuPrimerNivel();
        panel_BotonConfiguracion.add(btn_configuracionGeneral);

        btn_configuracionActualizacionBD = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Actualizar Base de Datos");
        btn_configuracionActualizacionBD.textoParaMenuPrimerNivel();
        panel_BotonConfiguracion.add(btn_configuracionActualizacionBD);

        btn_configuracionParametros = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Configurar Parámetros");
        btn_configuracionParametros.textoParaMenuPrimerNivel();
        panel_BotonConfiguracion.add(btn_configuracionParametros);

        panel_BotonConfiguracion.setVisible(false);
        panel_BotonConfiguracion.setSize(anchoBotonesPanel1, panel_BotonConfiguracion.getComponentCount() * altoBotonesPanel1);
        this.add(panel_BotonConfiguracion);
    }

    /**
     * Metodo encargado de dar acciones a los botones del panel de configuracion
     */
    private void accionBotonesPanelConfiguracion() {
        btn_configuracionUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (panel_configuracionUsuarios.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_configuracionUsuarios);
                    panel_configuracionUsuarios.setVisible(false);
                } else {
                    estadoInicialPanelConfiguracion();
                    ocultarPanelesNivel2();
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_configuracionUsuarios);
                    panel_configuracionUsuarios.setLocation(panel_BotonConfiguracion.getX() + panel_BotonConfiguracion.getWidth() + anchoBotonesPanel1 / 14, panel_BotonConfiguracion.getY() + btn_configuracionUsuarios.getY());
                    panel_configuracionUsuarios.setVisible(true);
                }
            }
        });
        btn_configuracionUsuarios.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyListenerConClick(btn_configuracionUsuarios, btn_configuracion, panel_BotonConfiguracion, panel_botonesPrincipales, e, panel_configuracionUsuarios);
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (!panel_configuracionUsuarios.isVisible()) {
                        btn_configuracionUsuarios.doClick();
                        panel_configuracionUsuarios.getComponent(0).requestFocus();
                        ((JButton) panel_configuracionUsuarios.getComponent(0)).grabFocus();
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_configuracionUsuarios.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (!panel_configuracionUsuarios.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_configuracionUsuarios);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_configuracionUsuarios);
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (!panel_configuracionUsuarios.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu2, btn_configuracionUsuarios);
                }
            }
        });
        btn_configuracionUsuarios.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent arg0) {
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                if (!panel_configuracionUsuarios.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_configuracionUsuarios);
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu3, btn_configuracionUsuarios);
                }
            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                if (!panel_configuracionUsuarios.isVisible()) {
                    Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu2, btn_configuracionUsuarios);
                }
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        //Editor Formatos
        btn_configuracionEditorFormatos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_configuracionEditorFormatos, btn_configuracion, panel_BotonConfiguracion, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_configuracionEditorFormatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (usuario.getDireccionArchivos() != null && !usuario.getDireccionArchivos().trim().isEmpty()) {
////                usuario.setFrameAnterior(frame);
////                new GUIEditorFormatos(usuario, establecimiento);
////                frame.setVisible(false);
//                } else {
//                    option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "Error (8660)", AbstractJasperReports.mensajeErrorReportes);
//                }
            }
        });

        // Clave del Dia
        btn_configuracionClaveDelDia.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_configuracionClaveDelDia, btn_configuracion, panel_BotonConfiguracion, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_configuracionClaveDelDia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIEditorFormatos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
        // Configuracion General
        btn_configuracionGeneral.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_configuracionGeneral, btn_configuracion, panel_BotonConfiguracion, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_configuracionGeneral.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIEditorFormatos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
        //Actualizacion BD
        btn_configuracionActualizacionBD.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_configuracionActualizacionBD, btn_configuracion, panel_BotonConfiguracion, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_configuracionActualizacionBD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIEditorFormatos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
        //Configurar parametros
        btn_configuracionParametros.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_configuracionParametros, btn_configuracion, panel_BotonConfiguracion, panel_botonesPrincipales, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_configuracionParametros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIEditorFormatos(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
    }

    /**
     * Metodo encargado de crear el panel de alumnos
     */
    private void prepareMostrarPanelConfiguracionUsuarios() {
        panel_configuracionUsuarios = new JPanel();
        panel_configuracionUsuarios.setLayout(new GridLayout(0, 1));
        panel_configuracionUsuarios.setOpaque(false);

        btn_usuarioAdicionar = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Adicionar");
        btn_usuarioAdicionar.textoParaMenuSegundoNivel();
        panel_configuracionUsuarios.add(btn_usuarioAdicionar);

        btn_usuarioDesactivar = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Desactivar");
        btn_usuarioDesactivar.textoParaMenuSegundoNivel();
        panel_configuracionUsuarios.add(btn_usuarioDesactivar);

        btn_usuarioPermisos = new Boton(NombreImagenes.imBPorDefectoMenu, NombreImagenes.imBPorDefectoMenu2, "Permisos");
        btn_usuarioPermisos.textoParaMenuSegundoNivel();
        panel_configuracionUsuarios.add(btn_usuarioPermisos);

        this.add(panel_configuracionUsuarios);
        panel_configuracionUsuarios.setVisible(false);
        panel_configuracionUsuarios.setSize(CargaImagenes.anchoBotonSegundoNivelMenu, panel_configuracionUsuarios.getComponentCount() * CargaImagenes.altoBotonSegundoNivelMenu + (CargaImagenes.altoBotonSegundoNivelMenu));
    }

    /**
     * Metodo encargado de dar acciones a los botones del panel de transacciones
     * de pago
     */
    private void accionBotonesPanelConfiguracionUsuarios() {
        btn_usuarioAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIUsuarioAdicionar(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
        btn_usuarioDesactivar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIUsuarioDesactivar(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
        btn_usuarioPermisos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                usuario.setFrameAnterior(frame);
//                new GUIPermisosSeleccionar(usuario, establecimiento);
//                frame.setVisible(false);
            }
        });
        btn_usuarioAdicionar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_usuarioAdicionar, btn_configuracionUsuarios, panel_BotonConfiguracion, panel_configuracionUsuarios, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_usuarioDesactivar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_usuarioDesactivar, btn_configuracionUsuarios, panel_BotonConfiguracion, panel_configuracionUsuarios, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_usuarioPermisos.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                accionesKeyLIstenerConFoco(btn_usuarioPermisos, btn_configuracionUsuarios, panel_BotonConfiguracion, panel_configuracionUsuarios, e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }

    /**
     * Metodo encargado de ocultar y dejar en el estado inicial los botones
     * principales
     */
    private void ocultarPanelesNivel3() {
//        if (panel_transInterCartera.isVisible()) {
//            panel_transInterCartera.setVisible(false);
////            estadoInicialPanelTransaccionesInterfaseCartera();
//        }
    }

    /**
     * Metodo encargado de ocultar y dejar en el estado inicial los botones
     * principales
     */
    private void ocultarPanelesNivel2() {
//        if (panel_trasaccionesPagos.isVisible()) {
//            panel_trasaccionesPagos.setVisible(false);
////            estadoInicialPanelTransaccionesPagos();
//        }
//        if (panel_reportesListadoAlumnos.isVisible()) {
//            panel_reportesListadoAlumnos.setVisible(false);
////            estadoInicialPanelReporteListadoAlumnos();
//        }
        if (panel_configuracionUsuarios.isVisible()) {
            panel_configuracionUsuarios.setVisible(false);
//            estadoInicialPanelConfiguracionUsuarios();
        }

        ocultarPanelesNivel3();
    }

    /**
     * Metodo encargado de ocultar y dejar en el estado inicial los botones
     * principales
     */
    private void ocultarPanelesNivel1() {
        estadoInicialBotonesPrincipales();
        if (panel_BotonCatalogos.isVisible()) {
            panel_BotonCatalogos.setVisible(false);
            estadoInicialPanelCatalogos();
        }
        if (panel_BotonConfiguracion.isVisible()) {
            panel_BotonConfiguracion.setVisible(false);
            estadoInicialPanelConfiguracion();
        }
        if (panel_BotonTransacciones.isVisible()) {
            panel_BotonTransacciones.setVisible(false);
            estadoInicialPanelTransaccion();
        }
        if (panel_BotonReportes.isVisible()) {
            panel_BotonReportes.setVisible(false);
            estadoInicialPanelReporte();
        }

        ocultarPanelesNivel2();
    }

    /**
     * Metodo encargado de dejar en estado inicial los botones principales
     */
    private void estadoInicialBotonesPrincipales() {
        Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_catalogos);
        Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_transaccion);
        Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_reportes);
        Imagenes.imagenBoton(NombreImagenes.imBPrincipalPorDefectoMenu, btn_configuracion);
    }

    /**
     * Metodo encargado de dejar en el estado inicial los botones de los
     * catalogos
     */
    private void estadoInicialPanelCatalogos() {
//        Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_catalogoAlumnos);
//        Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_catalogoCargos);
    }

    /**
     * Metodo encargado de dejar en el estado inicial los botones de la
     * configuración
     */
    private void estadoInicialPanelConfiguracion() {
        Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_configuracionUsuarios);
    }

    /**
     * Metodo encargado de dejar en el estado inicial los botones de la
     * configuración
     */
    private void estadoInicialPanelTransaccion() {
//        Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_transaPagos);
    }

    /**
     * Metodo encargado de dejar en el estado inicial los botones de la
     * configuración
     */
    private void estadoInicialPanelReporte() {
//        Imagenes.imagenBoton(NombreImagenes.imBPorDefectoMenu, btn_reportesListadoAlumnos);
    }

    /**
     * Metodo encargado de seleccionar el boton siguiente (Derecha, con click)
     *
     * @param panel
     * @param btn_actual
     */
    private void seleccionarSeguienteConClick(JPanel panel, JButton btn_actual) {
        boolean selecciono = false;
        int orden = panel.getComponentZOrder(btn_actual);
        if (orden + 1 < panel.getComponentCount()) {
            for (int i = orden + 1; i < panel.getComponentCount(); i++) {
                if (panel.getComponent(i).isEnabled()) {
                    panel.getComponent(i).requestFocus();
                    ((JButton) panel.getComponent(i)).doClick();
                    selecciono = true;
                    break;
                }
            }
            if (!selecciono) {
                for (int i = 0; i < panel.getComponentCount(); i++) {
                    if (panel.getComponent(i).isEnabled()) {
                        panel.getComponent(i).requestFocus();
                        ((JButton) panel.getComponent(i)).doClick();
                        break;
                    }
                }
            }

        } else {
            for (int i = 0; i < panel.getComponentCount(); i++) {
                if (panel.getComponent(i).isEnabled()) {
                    panel.getComponent(i).requestFocus();
                    ((JButton) panel.getComponent(i)).doClick();
                    break;
                }
            }
        }
    }

    /**
     * Metodo encargado de seleccionar el boton anterior (Izquierda, con click)
     *
     * @param panel
     * @param btn_actual
     */
    private void seleccionarAnteriorConClick(JPanel panel, JButton btn_actual) {
        boolean selecciono2 = false;
        int orden = panel.getComponentZOrder(btn_actual);
        if (0 <= orden - 1) {
            for (int i = orden - 1; i >= 0; i--) {
                if (panel.getComponent(i).isEnabled()) {
                    panel.getComponent(i).requestFocus();
                    ((JButton) panel.getComponent(i)).doClick();
                    selecciono2 = true;
                    break;
                }
            }
            if (!selecciono2) {
                for (int i = panel.getComponentCount() - 1; i >= 0; i--) {
                    if (panel.getComponent(i).isEnabled()) {
                        panel.getComponent(i).requestFocus();
                        ((JButton) panel.getComponent(i)).doClick();
                        break;
                    }
                }
            }

        } else {
            for (int i = panel.getComponentCount() - 1; i >= 0; i--) {
                if (panel.getComponent(i).isEnabled()) {
                    panel.getComponent(i).requestFocus();
                    ((JButton) panel.getComponent(i)).doClick();
                    break;
                }
            }
        }
    }

    /**
     * Metodo encargado de buscar el siguiente boton ocn foco
     *
     * @param boton
     * @param botonPadre
     * @param panelActual
     * @param panelAnterior
     */
    private void accionesKeyLIstenerConFoco(JButton boton, JButton botonPadre, JPanel panelActual, JPanel panelAnterior, KeyEvent e) {
        boolean selecciono = false;
        if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
            int orden = panelActual.getComponentZOrder(boton);
            if (orden + 1 < panelActual.getComponentCount()) {
                for (int i = orden + 1; i < panelActual.getComponentCount(); i++) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).grabFocus();
                        selecciono = true;
                        break;
                    }
                }
                if (!selecciono) {
                    for (int i = 0; i < panelActual.getComponentCount(); i++) {
                        if (panelActual.getComponent(i).isEnabled()) {
                            panelActual.getComponent(i).requestFocus();
                            ((JButton) panelActual.getComponent(i)).grabFocus();
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < panelActual.getComponentCount(); i++) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).grabFocus();
                        break;
                    }
                }
            }
        } else if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
            boton.doClick();
        } else if (e.getKeyCode() == (KeyEvent.VK_UP)) {
            boolean selecciono2 = false;
            int orden = panelActual.getComponentZOrder(boton);
            if (0 <= orden - 1) {
                for (int i = orden - 1; i >= 0; i--) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).grabFocus();
                        selecciono2 = true;
                        break;
                    }
                }
                if (!selecciono2) {
                    for (int i = panelActual.getComponentCount() - 1; i >= 0; i--) {
                        if (panelActual.getComponent(i).isEnabled()) {
                            panelActual.getComponent(i).requestFocus();
                            ((JButton) panelActual.getComponent(i)).grabFocus();
                            break;
                        }
                    }
                }

            } else {
                for (int i = panelActual.getComponentCount() - 1; i >= 0; i--) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).grabFocus();
                        break;
                    }
                }
            }
        } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
            int orden = panelAnterior.getComponentZOrder(botonPadre);
            panelAnterior.getComponent(orden).requestFocus();
            ((JButton) panelAnterior.getComponent(orden)).doClick();
        } else if (e.getKeyCode() == (KeyEvent.VK_ESCAPE)) {
            int orden = panelAnterior.getComponentZOrder(botonPadre);
            panelAnterior.getComponent(orden).requestFocus();
            ((JButton) panelAnterior.getComponent(orden)).doClick();
        }
    }

    /**
     * Metodo encargado de buscar el siguiente boton click
     *
     * @param boton
     * @param botonPadre
     * @param panelActual
     * @param panelAnterior
     */
    private void accionesKeyListenerConClick(Boton boton, Boton botonPadre, JPanel panelActual, JPanel panelAnterior, KeyEvent e, JPanel panelSiguiente) {
        boolean selecciono = false;
        if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
            int orden = panelActual.getComponentZOrder(boton);
            if (orden + 1 < panelActual.getComponentCount()) {
                for (int i = orden + 1; i < panelActual.getComponentCount(); i++) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).doClick();
                        selecciono = true;
                        break;
                    }
                }
                if (!selecciono) {
                    for (int i = 0; i < panelActual.getComponentCount(); i++) {
                        if (panelActual.getComponent(i).isEnabled()) {
                            panelActual.getComponent(i).requestFocus();
                            ((JButton) panelActual.getComponent(i)).doClick();
                            break;
                        }
                    }
                }
            } else {
                for (int i = 0; i < panelActual.getComponentCount(); i++) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).doClick();
                        break;
                    }
                }
            }
        } else if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
            boton.doClick();
        } else if (e.getKeyCode() == (KeyEvent.VK_UP)) {
            boolean selecciono2 = false;
            int orden = panelActual.getComponentZOrder(boton);
            if (0 <= orden - 1) {
                for (int i = orden - 1; i >= 0; i--) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).doClick();
                        selecciono2 = true;
                        break;
                    }
                }
                if (!selecciono2) {
                    for (int i = panelActual.getComponentCount() - 1; i >= 0; i--) {
                        if (panelActual.getComponent(i).isEnabled()) {
                            panelActual.getComponent(i).requestFocus();
                            ((JButton) panelActual.getComponent(i)).doClick();
                            break;
                        }
                    }
                }

            } else {
                for (int i = panelActual.getComponentCount() - 1; i >= 0; i--) {
                    if (panelActual.getComponent(i).isEnabled()) {
                        panelActual.getComponent(i).requestFocus();
                        ((JButton) panelActual.getComponent(i)).doClick();
                        break;
                    }
                }
            }
        } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
            int orden = panelAnterior.getComponentZOrder(botonPadre);
            panelAnterior.getComponent(orden).requestFocus();
            ((JButton) panelAnterior.getComponent(orden)).doClick();
            ((JButton) panelAnterior.getComponent(orden)).doClick();
        } else if (e.getKeyCode() == (KeyEvent.VK_ESCAPE)) {
            int orden = panelAnterior.getComponentZOrder(botonPadre);
            panelAnterior.getComponent(orden).requestFocus();
            ((JButton) panelAnterior.getComponent(orden)).doClick();
            ((JButton) panelAnterior.getComponent(orden)).doClick();
        } else if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
            if (panelSiguiente != null) {
                panelSiguiente.getComponent(0).requestFocus();
                ((JButton) panelSiguiente.getComponent(0)).grabFocus();
            }
        }
    }

    @Override
    public void actualizarFrame() {
        lbl_periodoContable.setText(usuario.getPeriodoContable());
        lbl_nombreUsuario.setText(usuario.getNombres().trim());
        lbl_nombreEmpresa.setText(establecimiento.getNombre());

        new FechaHora(lbl_fecha);
    }

    @Override
    public void eliminarReferencia() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarFoco() {
        btn_salir.grabFocus();
        btn_catalogos.doClick();
    }

    @Override
    public void asignarPermisos() {
//        Permisos.asignarPemisosLectura(btn_catalogoConceptos, usuario, Permisos.catalogosConceptos);
//        Permisos.asignarPemisosLectura(btn_catalogoCursos, usuario, Permisos.catalogosCursos);
//        Permisos.asignarPemisosLectura(btn_alumnoCatalogo, usuario, Permisos.catalogosAlumnosConsultar);
//        Permisos.asignarPemisosEscritura(btn_alumnoImportar, usuario, Permisos.catalogosAlumnosImportar);
//        Permisos.asignarPemisosLectura(btn_catalogoCostosEducativos, usuario, Permisos.catalogosCostosEducativos);
//        Permisos.asignarPemisosLectura(btn_catalogoCargos, usuario, Permisos.catalogosCargos);
//        Permisos.asignarPemisosLectura(btn_catalogosLimiteFechaPagos, usuario, Permisos.catalogosFechasLimite);
//
//        Permisos.asignarPemisosEscritura(btn_transPagosRegistrar, usuario, Permisos.transaccionesPagosRegistrar);
//        Permisos.asignarPemisosLectura(btn_transPagosConsultar, usuario, Permisos.transaccionesPagosConsultar);
//        Permisos.asignarPemisosEscritura(btn_transPagosImportar, usuario, Permisos.transaccionesPagosImportar);
//        Permisos.asignarPemisosEscritura(btn_transRCobroRegistrarUno, usuario, Permisos.transaccionesRecibosCobroRegistrarUno);
//        Permisos.asignarPemisosEscritura(btn_transRCobroRegistrarVarios, usuario, Permisos.transaccionesRecibosCobroRegistrarVarios);
//        Permisos.asignarPemisosLectura(btn_transRCobroConsultar, usuario, Permisos.transaccionesRecibosCobroConsultar);
//        Permisos.asignarPemisosModificacion(btn_transaGenerarMoras, usuario, Permisos.transaccionesGenerarMoras);
//
//        Permisos.asignarPemisosEscritura(btn_usuarioAdicionar, usuario, Permisos.configuracionUsuarioAdicionar);
////        Permisos.asignarPemisosBorrar(btn_usuarioDesactivar, usuario, Permisos.configuracionUsuarioDesactivar);
////        Permisos.asignarPemisosModificacion(btn_usuarioPermisos, usuario, Permisos.configuracionUsuarioPermisos);
//        Permisos.asignarPemisosLectura(btn_configuracionEditorFormatos, usuario, Permisos.configuracionEditorFormatos);
//        Permisos.asignarPemisosLectura(btn_configuracionClaveDelDia, usuario, Permisos.configuracionClaveDia);
//        Permisos.asignarPemisosLectura(btn_configuracionGeneral, usuario, Permisos.configuracionConfiguracionGeneral);
//        Permisos.asignarPemisosLectura(btn_configuracionActualizacionBD, usuario, Permisos.configuracionActualizacionBD);
//        Permisos.asignarPemisosLectura(btn_configuracionParametros, usuario, Permisos.configuracionParametros);
    }

}
