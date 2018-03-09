/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.expendio.vista;

import activa.expendio.vista.utils.Boton;
import activa.expendio.vista.utils.CajaDeTexto;
import activa.expendio.vista.utils.CajaTextoArea;
import activa.expendio.vista.utils.CampoLabel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import utils.*;

/**
 *
 * @author SISTEMASCOMERCIALES
 */
public class GUIJOption implements Serializable {

    private static final long serialVersionUID = -6729190000249803913L;

    private JDialog ventanaEmergente;
    private JFrame framePadre;
    private int posicionY;

    private JButton btn_tiempo;
    private Boton btn_aceptar, btn_si, btn_no;
    private CampoLabel lbl_detalle, lbl_mensaje1, lbl_mensaje2, lbl_pregunta, lbl_advertencia, lbl_informacion,
            lbl_error;
    private CajaTextoArea txta_error;
    private JScrollPane scroll_errores;

    private int resultado = JOptionPane.YES_OPTION;
    private String tipoMensaje = "";
    public static final String mensajePregunta = "P";
    public static final String mensajeInformacion = "I";
    public static final String mensajeAdvertencia = "A";
    public static final String mensajeError = "E";

    public GUIJOption(JFrame framePadre) {
        this.framePadre = framePadre;
        prepareElementosDialogo();
        accionBoton();
    }

    /**
     * metodo que prepara los Joption Personalizados
     */
    public void prepareElementosDialogo() {
        int anchoBotonGeneral = CargaImagenes.anchoBotonGeneral;
        int altoBotonGeneral = CargaImagenes.altoBotonGeneral;

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double ancho = screenSize.getWidth();
        double altura = screenSize.getHeight();
        int ANCHO_PANTALLA = (int) ancho;
        int ALTO_PANTALLA = (int) altura - 35;

        ventanaEmergente = new JDialog(framePadre, true);
        ventanaEmergente.setTitle("Joption");
        ventanaEmergente.setSize(ANCHO_PANTALLA / 2, ALTO_PANTALLA / 4);
        ventanaEmergente.setLocationRelativeTo(null);
        ventanaEmergente.setUndecorated(true);
        Imagenes.fondoDialog(NombreImagenes.imFondoD, ANCHO_PANTALLA / 2, ALTO_PANTALLA / 4, ventanaEmergente);

        int posicionX = ventanaEmergente.getWidth() / 40 * 17;
        posicionY = ventanaEmergente.getHeight() / 10 * 8;

        btn_tiempo = new JButton();

        btn_aceptar = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Aceptar");
        btn_aceptar.setSize(anchoBotonGeneral, altoBotonGeneral);
        btn_aceptar.setLocation(posicionX, posicionY);
        btn_aceptar.setToolTipText("Aceptar");
        ventanaEmergente.add(btn_aceptar);

        btn_si = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "Si");
        btn_si.setSize(anchoBotonGeneral, altoBotonGeneral);
        btn_si.setLocation(posicionX - anchoBotonGeneral / 2 - 5, posicionY);
        btn_si.setToolTipText("Si");
        ventanaEmergente.add(btn_si);

        btn_no = new Boton(NombreImagenes.imBGeneral1, NombreImagenes.imBGeneral2, "No");
        btn_no.setSize(anchoBotonGeneral, altoBotonGeneral);
        btn_no.setLocation(posicionX + anchoBotonGeneral / 2 + 5, posicionY);
        btn_no.setToolTipText("No");
        ventanaEmergente.add(btn_no);

        lbl_detalle = new CampoLabel("<html><u>Detalles</u></html>", CampoLabel.labelVariable);
        lbl_detalle.setLocation(30, posicionY);
        lbl_detalle.setSize(100, 20);
        ventanaEmergente.add(lbl_detalle);
        lbl_detalle.setVisible(false);

        lbl_mensaje1 = new CampoLabel("", CampoLabel.labelVariable);
        lbl_mensaje1.setLocation(ventanaEmergente.getWidth() / 3, ventanaEmergente.getHeight() / 10 * 2);
        lbl_mensaje1.setSize(ventanaEmergente.getWidth(), 30);
        ventanaEmergente.add(lbl_mensaje1);

        lbl_mensaje2 = new CampoLabel("", CampoLabel.labelVariable);
        lbl_mensaje2.setLocation(ventanaEmergente.getWidth() / 3, lbl_mensaje1.getY() + altoBotonGeneral / 2);
        lbl_mensaje2.setSize(ventanaEmergente.getWidth(), 30);
        ventanaEmergente.add(lbl_mensaje2);

        lbl_pregunta = new CampoLabel("", CampoLabel.labelVariable);
        lbl_pregunta.setLocation(ventanaEmergente.getWidth() / 15, 15);
        lbl_pregunta.setSize(ventanaEmergente.getWidth(), ventanaEmergente.getHeight() / 3 * 2);
        Imagenes.fondoLabel(NombreImagenes.imLblPregunta, lbl_pregunta);
        ventanaEmergente.add(lbl_pregunta);
        lbl_pregunta.setVisible(false);

        lbl_advertencia = new CampoLabel("", CampoLabel.labelVariable);
        lbl_advertencia.setLocation(ventanaEmergente.getWidth() / 15, 15);
        lbl_advertencia.setSize(ventanaEmergente.getWidth(), ventanaEmergente.getHeight() / 3 * 2);
        Imagenes.fondoLabel(NombreImagenes.imLblAdvertencia, lbl_advertencia);
        ventanaEmergente.add(lbl_advertencia);
        lbl_advertencia.setVisible(false);

        lbl_informacion = new CampoLabel("", CampoLabel.labelVariable);
        lbl_informacion.setLocation(ventanaEmergente.getWidth() / 15, 15);
        lbl_informacion.setSize(ventanaEmergente.getWidth(), ventanaEmergente.getHeight() / 3 * 2);
        Imagenes.fondoLabel(NombreImagenes.imLblInformacion, lbl_informacion);
        ventanaEmergente.add(lbl_informacion);
        lbl_informacion.setVisible(false);

        lbl_error = new CampoLabel("", CampoLabel.labelVariable);
        lbl_error.setLocation(ventanaEmergente.getWidth() / 15, 15);
        lbl_error.setSize(ventanaEmergente.getWidth(), ventanaEmergente.getHeight() / 3 * 2);
        Imagenes.fondoLabel(NombreImagenes.imLblError, lbl_error);
        ventanaEmergente.add(lbl_error);
        lbl_error.setVisible(false);

        txta_error = new CajaTextoArea(CajaDeTexto.textoLetrasNumeros);
        scroll_errores = new JScrollPane(txta_error);
        scroll_errores.setBounds(ventanaEmergente.getWidth() / 20, ventanaEmergente.getHeight() / 4,
                (ventanaEmergente.getWidth() / 20) * 18, (ventanaEmergente.getHeight() / 10) * 4);
        scroll_errores.setViewportView(txta_error);
        txta_error.setEditable(false);
        txta_error.setColumns(5);
        txta_error.setRows(5);
        txta_error.setAutoscrolls(false);
        txta_error.setLineWrap(true);
        ventanaEmergente.add(scroll_errores);
        txta_error.grabFocus();
        txta_error.setBounds(ventanaEmergente.getWidth() / 20, ventanaEmergente.getHeight() / 4,
                (ventanaEmergente.getWidth() / 20) * 18, (ventanaEmergente.getHeight() / 10) * 4);
        scroll_errores.setVisible(false);
    }

    /**
     * metodo que prepara el dialogo segun el mensaje a mostrar
     *
     * @param tipoMensaje:
     * <br>
     * <b>P</b>: Pregunta<br>
     * <b>I</b>: Informacion<br>
     * <b>A</b>: Advertencia<br>
     * <b>E</b>: Error<br>
     * @return int<br>
     * <b>0</b>: Aceptar<br>
     * <b>0</b>: SI <br>
     * <b>1</b>: NO<br>
     */
    public int tipoMensaje(String tipoMensaje, String mensajeErrorExcepcion, String mensaje1, String mensaje2) {
        this.tipoMensaje = tipoMensaje;
        if (tipoMensaje.equals(mensajePregunta)) {
            // PREGUNTA
            ocultarTodo();
            btn_si.setVisible(true);
            btn_no.setVisible(true);
            lbl_pregunta.setVisible(true);
            lbl_mensaje1.setText(mensaje1);
            lbl_mensaje2.setText(mensaje2);
            ventanaEmergente.setVisible(true);
            btn_si.grabFocus();
        } else if (tipoMensaje.equals(mensajeInformacion)) {
            // INFORMACION
            ocultarTodo();
            btn_aceptar.setVisible(true);
            lbl_informacion.setVisible(true);
            lbl_mensaje1.setText(mensaje1);
            lbl_mensaje2.setText(mensaje2);
            ventanaEmergente.setVisible(true);
            btn_aceptar.grabFocus();
        } else if (tipoMensaje.equals(mensajeAdvertencia)) {
            // ADVERTENCIA
            ocultarTodo();
            btn_aceptar.setVisible(true);
            lbl_advertencia.setVisible(true);
            lbl_mensaje1.setText(mensaje1);
            lbl_mensaje2.setText(mensaje2);
            ventanaEmergente.setVisible(true);
            btn_aceptar.grabFocus();

        } else if (tipoMensaje.equals(mensajeError)) {
            // ERROR
            ocultarTodo();
            btn_aceptar.setVisible(true);
            lbl_error.setVisible(true);
            lbl_detalle.setVisible(true);
            lbl_mensaje1.setText(mensaje1);
            lbl_mensaje2.setText(mensaje2);
            txta_error.setText(mensajeErrorExcepcion);
            ventanaEmergente.setVisible(true);
            btn_aceptar.grabFocus();
        }
        return resultado;
    }

    public void ocultarTodo() {
        lbl_pregunta.setVisible(false);
        lbl_advertencia.setVisible(false);
        lbl_informacion.setVisible(false);
        lbl_error.setVisible(false);
        lbl_detalle.setVisible(false);
        btn_si.setVisible(false);
        btn_no.setVisible(false);
        btn_aceptar.setVisible(false);
    }

    /**
     * metodo que cdontiene las acciones de los botones
     */
    public void accionBoton() {
        btn_aceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                scroll_errores.setVisible(false);
                if (tipoMensaje.equals(mensajeAdvertencia)) {
                    lbl_advertencia.setVisible(true);
                } else if (tipoMensaje.equals(mensajeError)) {
                    lbl_error.setVisible(true);
                } else if (tipoMensaje.equals(mensajeInformacion)) {
                    lbl_informacion.setVisible(true);
                } else if (tipoMensaje.equals(mensajePregunta)) {
                    lbl_pregunta.setVisible(true);
                }
                lbl_mensaje1.setVisible(true);
                lbl_mensaje2.setVisible(true);

                ventanaEmergente.setVisible(false);
                resultado = JOptionPane.YES_OPTION;
            }
        });
        btn_si.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaEmergente.setVisible(false);
                resultado = JOptionPane.YES_OPTION;
            }
        });
        btn_no.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaEmergente.setVisible(false);
                resultado = JOptionPane.NO_OPTION;
            }
        });

        btn_tiempo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        lbl_detalle.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl_detalle.setForeground(Letra.colorLabelVariable);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_detalle.setForeground(Color.RED);
            }

            @Override
            public void mouseClicked(MouseEvent arg0) {
                if (scroll_errores.isVisible()) {
                    scroll_errores.setVisible(false);
                    if (tipoMensaje.equals(mensajeAdvertencia)) {
                        lbl_advertencia.setVisible(true);
                    } else if (tipoMensaje.equals(mensajeError)) {
                        lbl_error.setVisible(true);
                    } else if (tipoMensaje.equals(mensajeInformacion)) {
                        lbl_informacion.setVisible(true);
                    } else if (tipoMensaje.equals(mensajePregunta)) {
                        lbl_pregunta.setVisible(true);
                    }
                    lbl_mensaje1.setVisible(true);
                    lbl_mensaje2.setVisible(true);
                } else {
                    scroll_errores.setVisible(true);
                    lbl_pregunta.setVisible(false);
                    lbl_advertencia.setVisible(false);
                    lbl_informacion.setVisible(false);
                    lbl_error.setVisible(false);
                    lbl_mensaje1.setVisible(false);
                    lbl_mensaje2.setVisible(false);

                }

            }
        });

        btn_aceptar.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_aceptar.doClick();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }
        });
        btn_si.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_si.doClick();
                } else if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {
                    btn_no.grabFocus();

                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        btn_no.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_no.doClick();
                } else if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {
                    btn_si.grabFocus();

                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });
        txta_error.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == (KeyEvent.VK_ENTER)) {
                    btn_aceptar.doClick();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub

            }
        });

    }

    /**
     * Metodo encargado de cambiar la ubicacion en Y del panel
     *
     * @param y
     */
    public void setLocation(int y) {
        ventanaEmergente.setLocation(ventanaEmergente.getX(), y);
    }

    /**
     * Metodo encargado de retornar el avlor predeterminado de la posicion y de
     * la ventana
     *
     * @return
     */
    public int getPosicionY() {
        return posicionY;
    }
}
