/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.vista;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public abstract class GUIInterfazCatalogos extends ClaseGeneral {

    // Botones
    protected JPanel panel_subOpciones;
    protected Boton btn_agregar, btn_modificar, btn_borrar, btn_buscar, btn_salir, btn_exportar, btn_reporte, btn_adicional;
    protected boolean estaEditando, estaBuscando;
    protected CajaDeTexto txt_buscar;
    protected CampoLabel lbl_buscar;

    // Tabla General
    public DefaultTableModel dtmTablaGeneral;
    protected JTable tablaGeneral;
    protected JScrollPane scrollPaneTablaGeneral;
    protected JPanel panel_tablaGeneral;
    protected TableRowSorter<DefaultTableModel> trsFiltroGeneral;

    // Variables
    protected int anchoTablaGeneral, altoTablaGeneral;
    protected int anchoTabla, altoTabla;
    protected int posicionXTabla, posicionYTabla;

    public GUIInterfazCatalogos(Usuario usuario, Establecimiento establecimiento, boolean botonAdicional) {
        super(usuario, establecimiento);

        prepareElementos();
        prepareElementosInformacion();
        prepareElementosPanelBotones(botonAdicional);
        prepareElementosTablaGeneral();
        preparaCamposDeTexto();

        definaAccionesInformacion();
        definaAccionesBotones();
        
        inicializar();
    }

    /**
     * Método encargado del diseño del frame, tamaño, fondo.
     */
    protected void prepareElementos() {
        this.setTitle(getNombreClase());
        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, getNombreClase().toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
        Imagenes.fondoInternalFrame(NombreImagenes.imFondoG, this.getWidth(), this.getHeight(), this);

        estaEditando = false;
        estaBuscando = false;
    }

    /**
     * Método encargado de crear los botones con sus imagenes y ponerlos en la
     * posicion correcta
     */
    protected void prepareElementosPanelBotones(boolean botonAdicional) {
        panel_subOpciones = new JPanel();
        panel_subOpciones.setSize(CargaImagenes.ANCHO_PANTALLA - 2 * (CargaImagenes.ANCHO_PANTALLA / 10), (CargaImagenes.ALTO_PANTALLA / 6) / 3);
        panel_subOpciones.setLocation((CargaImagenes.ANCHO_PANTALLA / 10), 5 * (CargaImagenes.ALTO_PANTALLA / 16/*13*/) + 15);
        panel_subOpciones.setLayout(new GridLayout(1, 0));
        panel_subOpciones.setOpaque(false);
        this.add(panel_subOpciones);

        btn_agregar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Agregar");
        panel_subOpciones.add(btn_agregar);
        btn_agregar.setToolTipText("F1");

        btn_modificar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Modificar");
        panel_subOpciones.add(btn_modificar);
        btn_modificar.setToolTipText("F2");

        btn_borrar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Borrar");
        panel_subOpciones.add(btn_borrar);
        btn_borrar.setToolTipText("F3");

        btn_buscar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Buscar");
        panel_subOpciones.add(btn_buscar);
        btn_buscar.setToolTipText("F4");

        btn_exportar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Exportar");
        panel_subOpciones.add(btn_exportar);

        btn_reporte = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Reporte");
        panel_subOpciones.add(btn_reporte);

        btn_adicional = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "");
        if (botonAdicional) {
            panel_subOpciones.add(btn_adicional);
        }

        btn_salir = new Boton(NombreImagenes.imBGeneralRojo, NombreImagenes.imBGeneral2, "Salir");
        panel_subOpciones.add(btn_salir);
        btn_salir.setToolTipText("(ESC)");
    }

    /**
     * metodo que prepara los campos de texto necesarios
     */
    protected void preparaCamposDeTexto() {
        int posicionX = this.getWidth() / 100 * 40;
        int posicionY = this.getHeight() / 100 * 25;
        int altoObjetos = 25;
        int anchoTxt = this.getWidth() / 9;

        lbl_buscar = new CampoLabel("Buscar: ", CampoLabel.labelEstatico);
        lbl_buscar.setSize(80, altoObjetos);
        lbl_buscar.setLocation(posicionX, posicionY);
        this.add(lbl_buscar);
        lbl_buscar.setVisible(false);

        txt_buscar = new CajaDeTexto(CajaDeTexto.textoLetrasNumeros, 20);
        txt_buscar.setSize(anchoTxt, altoObjetos);
        txt_buscar.setLocation(posicionX + anchoTxt / 2 - 10, posicionY);
        txt_buscar.setFont(Letra.fuenteTxt);
        this.add(txt_buscar);
        txt_buscar.setVisible(false);
    }

    /**
     * Método encargado de asignarle las acciones a los botones.
     */
    protected void definaAccionesBotones() {
        btn_agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!estaEditando) {
                    accionBotonAgregar();
                } else {
                    accionBotonAgregarModificar();
                }
            }
        });
        btn_agregar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_agregar.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Guardar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Agregar");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Guardar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Agregar");
                }
            }
        });
        btn_agregar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Guardar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Agregar");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Guardar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_agregar);
                    btn_agregar.cambirTextoBotonGeneral("Agregar");
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btn_modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estaEditando) {
                    accionBotonCancelarModificacion();
                } else {
                    accionBotonModificar();
                }
            }
        });
        btn_modificar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_modificar.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneralRojo, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Modificar");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Modificar");
                }
            }
        });
        btn_modificar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneralRojo, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Modificar");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (estaEditando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_modificar);
                    btn_modificar.cambirTextoBotonGeneral("Modificar");
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        btn_borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonBorrar();
            }
        });
        btn_borrar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!estaBuscando) {
                    accionBotonBusqueda();
                } else {
                    accionBotonCancelarBusqueda();
                }
            }
        });
        btn_buscar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_buscar.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                if (estaBuscando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneralRojo, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Buscar");
                }
            }

            @Override
            public void focusGained(FocusEvent e) {
                if (estaBuscando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Buscar");

                }
            }
        });
        btn_buscar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (estaBuscando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneralRojo, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Buscar");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (estaBuscando) {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Cancelar");
                } else {
                    Imagenes.imagenBoton(NombreImagenes.imBGeneral2, btn_buscar);
                    btn_buscar.cambirTextoBotonGeneral("Buscar");
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });

        btn_exportar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonExcel(tablaGeneral, getNombreClase(), frame, usuario);
            }
        });
        btn_exportar.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_reporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonReporte();
            }
        });
        btn_reporte.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonSalir();
            }
        });
        btn_salir.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
        btn_adicional.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accionBotonAdicional();
            }
        });
        btn_adicional.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                teclasRapidas(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }

    /**
     * Metodo encargado de asignar las teclas rapidas
     */
    protected void teclasRapidas(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_F1:
                btn_agregar.doClick();
                break;
            case KeyEvent.VK_F2:
                btn_modificar.doClick();
                break;
            case KeyEvent.VK_F3:
                btn_borrar.doClick();
                break;
            case KeyEvent.VK_F4:
                btn_buscar.doClick();
                break;
            case KeyEvent.VK_F5:
                btn_exportar.doClick();
                break;
            case KeyEvent.VK_F6:
                btn_reporte.doClick();
                break;
            case KeyEvent.VK_ESCAPE:
                btn_salir.doClick();
                break;
//            case KeyEvent.VK_F7:
////            case KeyEvent.VK_ENTER:
//                btn_adicional.doClick();
//                break;
////            case KeyEvent.VK_LEFT:
////                btn_reporte.grabFocus();
////                break;
        }
    }

    /**
     * Metodo encargado de seleccionar la fila que tenga le id pasado por
     * parametro.
     *
     * @param id
     * @param columnaId
     */
    protected void seleccionarFila(String id, int columnaId) {
        SeleccionarFila.seleccionarFila(tablaGeneral, id, columnaId);
    }

    /**
     * Metodo encargado de inhabilitar botones y tabla al modificar
     */
    protected void accionModificarComun() {
        btn_borrar.setEnabled(false);
        btn_buscar.setEnabled(false);
        btn_exportar.setEnabled(false);
        btn_reporte.setEnabled(false);
        btn_salir.setEnabled(false);
        btn_adicional.setEnabled(false);

        tablaGeneral.setEnabled(false);

        Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_modificar);
        btn_modificar.cambirTextoBotonGeneral("Cancelar");

        Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_agregar);
        btn_agregar.cambirTextoBotonGeneral("Guardar");

        estaEditando = true;
    }

    /**
     * Metodo encargado de habilitar botones y tabla al modificar
     */
    protected void accionModificarComunDesactivar() {
        btn_borrar.setEnabled(true);
        btn_buscar.setEnabled(true);
        btn_exportar.setEnabled(true);
        btn_reporte.setEnabled(true);
        btn_salir.setEnabled(true);
        btn_adicional.setEnabled(true);
        tablaGeneral.setEnabled(true);
        Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_agregar);
        btn_agregar.cambirTextoBotonGeneral("Agregar");

        Imagenes.imagenBoton(NombreImagenes.imBGeneral1, btn_modificar);
        btn_modificar.cambirTextoBotonGeneral("Modificar");

        inicializarInformacion();
        estaEditando = false;
        Filtro.deshacerFiltro(trsFiltroGeneral, dtmTablaGeneral, tablaGeneral);
    }

    /**
     * metodo que cambia la posicion del txt buscar
     */
    protected void setPosicionTxtBuscar(int posicionX, int posicionY) {
        lbl_buscar.setLocation(posicionX, posicionY);
        txt_buscar.setLocation(posicionX + txt_buscar.getWidth() / 2 - 10, posicionY);
    }

    /**
     * oculta el campo buscar
     */
    protected void ocultarTxtBuscar() {
        lbl_buscar.setVisible(false);
        txt_buscar.setVisible(false);
        estaBuscando = false;
    }

    /**
     * mostrar el campo buscar
     */
    protected void mostrarTxtBuscar() {
        lbl_buscar.setVisible(true);
        txt_buscar.setVisible(true);
        estaBuscando = true;
    }

    /**
     * inicializa el campo buscar
     */
    public void inicializarTxtBuscar() {
        txt_buscar.setText("");
        btn_buscar.cambirTextoBotonGeneral("Buscar");
    }

    /**
     * Método encargado de crear todo lo relacionado con la tabla General.
     */
    protected abstract void prepareElementosTablaGeneral();

    /**
     * Método encargado de preparar los botones y elementos para poder
     * modificar.
     */
    protected abstract void activarModificar();

    /**
     * Método encargado de preparar los botones y elementos para dejar de
     * modificar.
     */
    protected abstract void desactivarModificar();

    /**
     * Método encargado de activar y preparar los elementos para poder realizar
     * una busqueda
     */
    protected abstract void activarBusqueda();

    /**
     * Método encargado de desactivar y preparar los elementos para dejar de
     * realizar una busqueda
     */
    protected abstract void desactivarBusqueda();

    /**
     * Método encargado de dejar todos los campos vacios, sin informacion y el
     * combo seleccionado el primero
     */
    protected abstract void inicializarInformacion();

    /**
     * Metodo encargado de definir las acciones de los elementos de informacion
     */
    protected abstract void definaAccionesInformacion();

    /**
     * Metodo encargado de crear los elementos de informacion
     */
    protected abstract void prepareElementosInformacion();

    /**
     * Metodo encargado de dar la accion al boton de agregar
     */
    protected abstract void accionBotonAgregar();

    /**
     * Metodo encargado de dar la accion al boton de agregar pero modificando
     */
    protected abstract void accionBotonAgregarModificar();

    /**
     * Metodo encargado de dar la accion al boton de modificar
     */
    protected abstract void accionBotonModificar();

    /**
     * Metodo encargado de dar la accion al boton de borrar
     */
    protected abstract void accionBotonBorrar();

    /**
     * Metodo encargado de dar la accion al boton de cancelar modificacion
     */
    protected abstract void accionBotonCancelarModificacion();

    /**
     * Metodo encargado de dar la accion al boton de cancelar busqueda
     */
    protected abstract void accionBotonCancelarBusqueda();

    /**
     * Metodo encargado de dar la accion al boton de busqueda
     */
    protected abstract void accionBotonBusqueda();

    /**
     * Metodo encargado de dar la accion al boton de Reporte
     */
    protected abstract void accionBotonReporte();

    /**
     * Metodo encargado de dar la acicion al boton adicional
     */
    protected abstract void accionBotonAdicional();

    /**
     * Obtiene el nombre de la clase o titulo de la ventana.
     *
     * @return
     */
    protected abstract String getNombreClase();

}
