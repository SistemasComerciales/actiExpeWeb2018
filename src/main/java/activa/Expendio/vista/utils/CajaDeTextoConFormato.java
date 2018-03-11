package activa.Expendio.vista.utils;

import activa.Expendio.modelo.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;

import javax.swing.*;
import javax.swing.text.*;
import utils.*;

public class CajaDeTextoConFormato extends JFormattedTextField {

    /**
     * F = Fecha
     */
    private static final long serialVersionUID = -2236496467475297268L;
    private JFormattedTextField txt;
    private String tipo;
    private Usuario usuario;

    /**
     * constructor
     *
     * @param tipo
     * @param usuario F = Fecha
     */
    public CajaDeTextoConFormato(String tipo, Usuario usuario) {
        this.tipo = tipo;
        this.txt = this;
        this.usuario = usuario;
        this.setFont(Letra.fuenteTxt);
        this.setForeground(Letra.colorTxt);
        this.setDisabledTextColor(Letra.colorTxtDisable);
        preparaCampo();
        accioneTxt();

    }

    /**
     * metodo que prepara el txt para fecha o hora
     */
    public void preparaCampo() {
        MaskFormatter mascara = null;
        try {
            if (tipo.equals("F")) {
                mascara = new MaskFormatter("##/##/####");
            } else if (tipo.equals("H")) {
                mascara = new MaskFormatter("##:##");
            }

        } catch (ParseException e) {
            StringWriter errors = new StringWriter();
            e.printStackTrace(new PrintWriter(errors));
            JOptionPane.showOptionDialog(null, "Ha Ocurrido un error al APlicar la mascara.", "Error (4182)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
            e.printStackTrace();
        }
        mascara.install(txt);
        txt.setFocusLostBehavior(JFormattedTextField.PERSIST);
        txt.setForeground(Letra.colorTxt);
        txt.setDisabledTextColor(Letra.colorTxtDisable);
    }

    /**
     * metodo que contiene las acciones generalers de los JformatTxt
     */
    public void accioneTxt() {
        txt.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                if (tipo.equals("F")) {
                    if (!txt.getText().replace(" ", "").replace("/", "").isEmpty()) {
                        Fecha.completarFechaStatic(txt, Configuracion.periodoContable);
                        String resultado = Fecha.validarFechaDDMMYYYYStatic(txt.getText().trim());
                        if (resultado.equals("mes")) {
                            JOptionPane.showOptionDialog(null, "Ha ingresado un mes inv�lido. Int�ntelo de nuevo", "Error (4182)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
                            txt.setText("");
                            txt.grabFocus();
                        } else if (resultado.equals("dia")) {
                            JOptionPane.showOptionDialog(null, "Ha ingresado un d�a inv�lido. Int�ntelo de nuevo", "Error (4182)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
                            txt.setText("");
                            txt.grabFocus();
                        } else if (resultado.equals("anio")) {
                            JOptionPane.showOptionDialog(null, "Ha ingresado un a�o inv�lido. Int�ntelo de nuevo", "Error (4182)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
                            txt.setText("");
                            txt.grabFocus();
                        } else if (resultado.equals("fecha")) {
                            JOptionPane.showOptionDialog(null, "Ha ingresado una fecha inv�lida. Int�ntelo de nuevo", "Error (4182)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
                            txt.setText("");
                            txt.grabFocus();
                        } else if (resultado.equals("INVALIDO")) {
                            JOptionPane.showOptionDialog(null, "Ha ingresado una fecha inv�lida. Int�ntelo de nuevo", "Error (4182)", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, null, "aceptar");
                            txt.setText("");
                            txt.grabFocus();
                        }
                    }
                }
            }

            @Override
            public void focusGained(FocusEvent arg0) {

            }
        });
        txt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (tipo.trim().equals("F")) {
                    if (KeyEvent.getKeyText(e.getKeyCode()).equals("H")) {
                        txt.setText(Fecha.fechaActualStatic());
                    } else if (e.getKeyCode() == KeyEvent.VK_I) {
                        txt.setText("01" + "01" + Configuracion.periodoContable);
                    } else if (e.getKeyCode() == KeyEvent.VK_F) {
                        txt.setText("31" + "12" + Configuracion.periodoContable);
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }

    /**
     * Metodo encargado de inhabilitar los campos de hora
     */
    public void inhabilitar() {
        this.setEnabled(false);
    }

    /**
     * Metodo encargado de habilitar los campos de hora
     */
    public void habilitar() {
        this.setEnabled(true);
    }

    /**
     * Metodo encargado de inicializzar la informacion de la hora, txt y combo
     */
    public void inicializar() {
        this.setText("");
    }
}
