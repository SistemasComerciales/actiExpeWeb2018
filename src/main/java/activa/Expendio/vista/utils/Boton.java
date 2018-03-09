package activa.Expendio.vista.utils;

import utils.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Boton extends JButton {

    private static final long serialVersionUID = -8856017798467020757L;

    private String ruta1, ruta2, texto;
    private JButton btn;

    /**
     * constructor de la clase
     */
    public Boton(String ruta1, String ruta2, String texto) {
        this.ruta1 = ruta1;
        this.ruta2 = ruta2;
        btn = this;
        this.texto = texto;
        configuracionPredefinida();
        accionBoton();

    }

    /**
     * @return the ruta1
     */
    public String getRuta1() {
        return ruta1;
    }

    /**
     * @param ruta1 the ruta1 to set
     */
    public void setRuta1(String ruta1) {
        this.ruta1 = ruta1;
    }

    /**
     * @return the ruta2
     */
    public String getRuta2() {
        return ruta2;
    }

    /**
     * @param ruta2 the ruta2 to set
     */
    public void setRuta2(String ruta2) {
        this.ruta2 = ruta2;
    }

    public void reiniciarBoton() {
        accionBoton();
    }

    /**
     * metodo que contiene las configuracion inicial del boton
     */
    public void configuracionPredefinida() {
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        Imagenes.imagenBoton(ruta1, btn);
        this.setText(texto);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setLayout(null);
        this.setForeground(new Color(255, 255, 255));
        this.setFont(new Fuente().MyFont(0, CargaImagenes.anchoBotonGeneral / 6f));
    }

    /**
     * metodo que cambia el texto de los botones menos lo del menu desde el
     * primer nivel hacia abajo
     */
    public void cambirTextoBotonGeneral(String texto) {
        this.texto = texto;
        this.setText(texto);
    }

    /**
     * metodo que cambia el tama�o del texto dentro del boton
     */
    public void cambiarTamanoTexto(float tamano) {
        this.setFont(new Fuente().MyFont(0, tamano));

    }

    /**
     * metodo que cambia el tama�o del texto dentro del boton
     */
    public void cambiarTamanoLabelBoton(int tamanoAlto, int tamanoAncho) {
        this.setSize(tamanoAlto, tamanoAncho);
    }

    /**
     * metodo que acomoda el texto para el menuPrimerNivel
     */
    public void textoParaMenuPrimerNivel() {
        this.setLayout(null);
        JLabel tex = new JLabel(texto, JLabel.LEFT);
        tex.setLocation(0, 0);
        tex.setSize(CargaImagenes.anchoBotonPrimerNivelMenu, CargaImagenes.altoBotonPrimerNivelMenu);
        tex.setForeground(new Color(255, 255, 255));
        tex.setFont(new Fuente().MyFont(0, CargaImagenes.anchoBotonPrimerNivelMenu / 17f));
        tex.setText("<html>&nbsp; &nbsp; &nbsp;" + texto + "</html>");
        this.add(tex);
        this.setText("");
    }

    /**
     * metodo que acomoda el texto para el menuSegundoNivel
     */
    public void textoParaMenuSegundoNivel() {
        JLabel tex = new JLabel(texto, JLabel.LEFT);
        tex.setLocation(0, 0);
        tex.setSize(CargaImagenes.anchoBotonSegundoNivelMenu, CargaImagenes.altoBotonSegundoNivelMenu);
        tex.setForeground(new Color(255, 255, 255));
        tex.setFont(new Fuente().MyFont(0, CargaImagenes.anchoBotonSegundoNivelMenu / 13f));
        tex.setText("<html> &nbsp; &nbsp; &nbsp;" + texto + "</html>");
        this.add(tex);
        this.setText("");
    }

    /**
     * metodo que acomoda el texto para el menuSegundoNivel
     */
    public void textoParaMenuTercerNivel() {
        JLabel tex = new JLabel(texto, JLabel.LEFT);
        tex.setLocation(0, 0);
        tex.setSize(CargaImagenes.anchoBotonTercerNivelMenu, CargaImagenes.altoBotonTercerNivelMenu);
        tex.setForeground(new Color(255, 255, 255));
        tex.setFont(new Fuente().MyFont(0, CargaImagenes.anchoBotonTercerNivelMenu / 13f));
        tex.setText("<html> &nbsp; &nbsp;" + texto + "</html>");
        this.add(tex);
        this.setText("");
    }

    /**
     * metodo que contiene los eventos nesesarios del boton
     */
    public void accionBoton() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                Imagenes.imagenBoton(ruta1, btn);
            }

            @Override
            public void focusGained(FocusEvent e) {
                Imagenes.imagenBoton(ruta2, btn);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Imagenes.imagenBoton(ruta1, btn);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Imagenes.imagenBoton(ruta2, btn);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    doClick();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }
}
