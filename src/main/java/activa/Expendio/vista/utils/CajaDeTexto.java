package activa.Expendio.vista.utils;

import utils.*;
import java.awt.event.*;

import javax.swing.*;

public class CajaDeTexto extends JTextField {

    private static final long serialVersionUID = -6696593929851235879L;

    /**
     * N = Solo numero Entero
     * D = Numero decimal y entero
     * L = Solo letras
     * G = Letras y Numeros
     * F = Fecha
     * M = Moneda
     * P = Porcentaje
     *
     */
    private String tipo;

    public static final String textoNumeroEntero = "N";
    public static final String textoNumeroDecimal = "D";
    public static final String textoSoloLetras = "L";
    public static final String textoLetrasNumeros = "G";
    public static final String textoFecha = "F";
    public static final String textoMoneda = "M";
    public static final String textoPorcentaje = "P";

    public static final int longitudDecimalPorcentaje = 3;
    public static final int longitudDecimalMoneda = 2;
    public static int longitudMaxima = 500;

    /**
     * @param tipo
     * @param longitudMaxima maxima Contructor N = Solo numero Entero D = Numero
     * decimal y entero L = Solo letras G = Letras y Numeros F = Fecha M =
     * Moneda P = Porcentaje
     */
    public CajaDeTexto(String tipo, int longitudMaxima) {
        this.tipo = tipo;
        CajaDeTexto.longitudMaxima = longitudMaxima;
        this.setFont(Letra.fuenteTxt);
        this.setForeground(Letra.colorTxt);
        this.setDisabledTextColor(Letra.colorTxtDisable);
        definaAcciones();
        condicionales();
    }

    /**
     * Contructor
     *
     * @param tipo Contructor N = Solo numero Entero D = Numero decimal y entero
     * L = Solo letras G = Letras y Numeros F = Fecha M = Moneda P = Porcentaje
     */
    public CajaDeTexto(String tipo) {
        this.tipo = tipo;
        this.setFont(Letra.fuenteTxt);
        this.setForeground(Letra.colorTxt);
        this.setDisabledTextColor(Letra.colorTxtDisable);
        definaAcciones();
        condicionales();
    }

    /**
     * Metodo encargado de definir las acciones
     */
    public void definaAcciones() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent arg0) {
                if (tipo.trim().equalsIgnoreCase(textoMoneda)) {
                    setText(Formatos.formatearValorString(getText().trim()));
                } else if (tipo.trim().equalsIgnoreCase(textoPorcentaje)) {
                    setText(Formatos.formatearPorcentajeString(getText().trim(), longitudDecimalPorcentaje));
                } else if (tipo.trim().equalsIgnoreCase("T")) {
                    setText(Formatos.formatearFactorString(getText().trim(), longitudDecimalPorcentaje));
                }
            }

            @Override
            public void focusGained(FocusEvent arg0) {
                if (tipo.trim().equalsIgnoreCase(textoMoneda)) {
                    setText(Formatos.quitarFormatoValorString(getText().trim()));
                } else if (tipo.trim().equalsIgnoreCase(textoPorcentaje)) {
                    setText(Formatos.quitarFormatoPorcentaje(getText().trim(), longitudDecimalPorcentaje));
                } else if (tipo.trim().equalsIgnoreCase("T")) {
                    setText(Formatos.quitarFormatoFactor(getText().trim(), longitudDecimalPorcentaje));
                }
                setSelectionStart(0);
                setSelectionEnd(getText().trim().length());

            }
        });
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char KeyChar = e.getKeyChar();
                if (Character.isLowerCase(KeyChar)) {
                    e.setKeyChar(Character.toUpperCase(KeyChar));
                }

                if (tipo.trim().equalsIgnoreCase(textoNumeroEntero)) {
                    ValidacionCampos.bloquearTxtSoloNumero(e);
                    ValidacionCampos.limitarLongitudString(getText(), longitudMaxima, e);
                } else if (tipo.trim().equalsIgnoreCase(textoNumeroDecimal)) {
                    ValidacionCampos.reemplazarComaPorPunto(e);
                    ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
                    ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
                    ValidacionCampos.validarParteDecimalConEvento(3, getText().trim(), getCaretPosition(), e);
                    ValidacionCampos.validarParteEnteraConEvento(longitudMaxima, getText().trim(), getCaretPosition(),
                            e);
                } else if (tipo.trim().equalsIgnoreCase(textoSoloLetras)) {
                    ValidacionCampos.limitarLongitudString(getText(), longitudMaxima, e);
                    ValidacionCampos.bloquearTxtSoloLetrasYCaracteresEspeciales(e);
                } else if (tipo.trim().equalsIgnoreCase(textoLetrasNumeros)) {
                    ValidacionCampos.limitarLongitudString(getText(), longitudMaxima, e);
                } else if (tipo.trim().equalsIgnoreCase(textoMoneda)) {
                    // Reemplaza la coma por punto
                    ValidacionCampos.reemplazarComaPorPunto(e);
                    // No permite ingresas m�s de un punto
                    ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
                    // Solo permite ingresar numeros y puntos
                    ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
                    // Valida la longitud decimal.
                    ValidacionCampos.validarParteDecimalConEvento(longitudDecimalMoneda, getText().trim(),
                            getCaretPosition(), e);
                } else if (tipo.trim().equalsIgnoreCase(textoPorcentaje)) {
                    // Reemplaza la coma por punto
                    ValidacionCampos.reemplazarComaPorPunto(e);
                    // No permite ingresas m�s de un punto
                    ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
                    // Solo permite ingresar numeros y puntos
                    ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
                    // Valida la longitud del decimal.
                    ValidacionCampos.validarParteDecimalConEvento(longitudDecimalPorcentaje, getText().trim(),
                            getCaretPosition(), e);
                    // Valida la longitud entera.
                    ValidacionCampos.validarParteEnteraConEvento(3, getText().trim(), getCaretPosition(), e);
                } else if (tipo.trim().equalsIgnoreCase("T")) {
                    ValidacionCampos.reemplazarComaPorPunto(e);
                    ValidacionCampos.noPermitirIngresarMasDeUnPuntoDecimal(e, getText().trim());
                    ValidacionCampos.permitirIngresarSoloNumerosYPunto(e);
                    ValidacionCampos.validarParteDecimalConEvento(longitudDecimalPorcentaje, getText().trim(),
                            getCaretPosition(), e);
                    ValidacionCampos.validarParteEnteraConEvento(2, getText().trim(), getCaretPosition(), e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String regex = "[0-9]";
                String regex2 = "[.,]";
                if (e.getKeyCode() != KeyEvent.VK_ENTER && (Character.toString(e.getKeyChar()).matches(regex)
                        || Character.toString(e.getKeyChar()).matches(regex2))) {
                    if (getSelectionStart() == 0 && getSelectionEnd() == getText().length()) {
                        if (Character.toString(e.getKeyChar()).matches("[,]")) {
                            setText(".");
                        } else {
                            setText(Character.toString(e.getKeyChar()));
                        }
                    }
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }
        });
    }

    /**
     * Metodo encargado de darle las condiciones dependiendo del tipo
     */
    public void condicionales() {
        if (tipo.trim().equalsIgnoreCase(textoMoneda) || tipo.trim().equalsIgnoreCase(textoPorcentaje)
                || tipo.trim().equalsIgnoreCase("T")) {
            this.setHorizontalAlignment(JTextField.RIGHT);
        }
    }
}
