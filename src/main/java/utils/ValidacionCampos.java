package utils;

import java.awt.event.*;

import javax.swing.*;

public class ValidacionCampos {

    /**
     * M�todo encargado de validar si la cantidad de enteros es valida. Si NO es
     * valida no deja insertar el valor, de lo contraro no hace nada.
     *
     * @param cantidadEnteros
     * @param numero
     * @param posicionCursor
     * @param e (evento de teclado): la tecla orpimida por el usuario
     */
    public static void validarParteEnteraConEvento(int cantidadEnteros, String numero, int posicionCursor, KeyEvent e) {
        if (cantidadDeValoresEnteros(numero.trim()) >= cantidadEnteros) {
            int posicionPunto = numero.trim().indexOf(".");
            if (posicionPunto == -1 && e.getKeyChar() != '.') {
                e.consume();
            } else if (posicionCursor <= posicionPunto) {
                e.consume();
            }
        }
    }

    /**
     * M�todo encargado de validar si la cantidad de decimales es valida. Si NO
     * es valida no deja insertar el valor, de lo contraro no hace nada.
     *
     * @param cantidadDecimales
     * @param numero
     * @param posicionCursor
     * @param e (evento de teclado): la tecla orpimida por el usuario
     */
    public static void validarParteDecimalConEvento(int cantidadDecimales, String numero, int posicionCursor,
            KeyEvent e) {
        // cantidadDecimales++;
        if (cantidadDeValoresDecimales(numero.trim()) >= cantidadDecimales) {
            int posicionPunto = numero.trim().indexOf(".");
            if (posicionCursor > posicionPunto) {
                e.consume();
            }
        }
    }

    /**
     * M�todo encargado de retornar la cantidad de enteros de un valor en
     * String.
     *
     * @param valor
     * @return
     */
    public static int cantidadDeValoresEnteros(String valor) {
        int respuesta = 0;
        if (!valor.contains(".")) {
            respuesta = valor.length();
        } else {
            respuesta = valor.indexOf(".");

        }
        return respuesta;
    }

    /**
     * M�todo encargado de retornar cuantos numeros decimales tiene el numero
     * pasado por paramtro. la parte decimal esta separado por un punto.
     *
     * @param valor
     * @return int: si no hay retorna 0 de lo contrario la cantidad que exista
     */
    public static int cantidadDeValoresDecimales(String valor) {
        int respuesta = 0;
        if (!valor.contains(".")) {
            respuesta = 0;
        } else {
            int posicionDecimal = valor.indexOf(".");

            respuesta = valor.trim().length() - 1 - posicionDecimal;
        }
        return respuesta;
    }

    /**
     * Metodo encargado de limitar la longitud de espacios escritos en un string
     *
     * @param parametro
     * @param limite
     * @param e: la tecla orpimida por el usuario
     */
    public static void limitarLongitudString(String parametro, int limite, KeyEvent e) {
        if (parametro.length() == limite) {
            e.consume();
        }
    }

    /**
     * Metodo encargado de validar que solo se pueda ingresar un valor numerico.
     * (falta revizar las teclas especiales (F, enter))
     *
     * @param caja
     * @param e: la tecla orpimida por el usuario
     */
    public static void bloquearTxtSoloNumero(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c)) {
            e.consume();
        }

    }

    /**
     * Metodo encargado de validar que solo se pueda ingresar un valor numerico.
     * (falta revizar las teclas especiales (F, enter))
     *
     * @param caja
     * @param e: la tecla orpimida por el usuario
     */
    public static void bloquearTxtSoloNumeroYCaracteresEspeciales(KeyEvent e) {
        char c = e.getKeyChar();
        if (Character.isLetter(c)) {
            e.consume();
        }
    }

    /**
     * Metodo encargado de validar que solo se pueda ingresar un valor numerico.
     * (falta revizar las teclas especiales (F, enter))
     *
     * @param caja
     * @param e: la tecla orpimida por el usuario
     */
    public static void bloquearTxtSoloLetrasYCaracteresEspeciales(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isLetter(c)) {
            e.consume();
        }
    }

    /**
     * M�todo encargado de validar si un string es un numero o no.
     *
     * @param parametro
     * @return boolean, si es numero retorna true, de lo contario retorna false.
     */
    public static boolean validarSiStringEsNumerico(String parametro) {
        boolean esNumeroValido = false;
        try {
            Double.parseDouble(parametro);
            esNumeroValido = true;
        } catch (Exception e) {
            esNumeroValido = false;
        }

        return esNumeroValido;
    }

    /**
     * M�todo encargado de remplazar el caracter ingresado por un punto, si el
     * usuario ha ingresado una coma.
     *
     * @param e (KeyEvent): la tecla orpimida por el usuario
     */
    public static void reemplazarComaPorPunto(KeyEvent e) {
        if (e.getKeyChar() == ',') {
            e.setKeyChar('.');
        }
    }

    /**
     * M�todo encargado de no permitir ingresar punto decima, si ya ha ingresado
     * anteriormente algun punto.
     *
     * @param e KeyEvent: la tecla orpimida por el usuario
     * @param valor (valor del txt)
     */
    public static void noPermitirIngresarMasDeUnPuntoDecimal(KeyEvent e, String valor) {
        if (valor.contains(".") && e.getKeyChar() == '.') {
            e.consume();
        }
    }

    /**
     * M�todo encargado de solo permitir ingresar valor numerico y punto en los
     * txt
     *
     * @param e KeyEvent: la tecla orpimida por el usuario
     */
    public static void permitirIngresarSoloNumerosYPunto(KeyEvent e) {
        char caracter = e.getKeyChar();
        if (((caracter < '0') || (caracter > '9')) && (caracter != '\b') && e.getKeyChar() != '.') {
            e.consume();
        }

    }

    /**
     * metodo que comprueba si el segundo parametro es mayor al primero
     *
     * @param valorMaximo
     * @param valor
     * @return String "ESMAYOR" , "ESMENOR"
     */
    public static String limitarValorMaximo(double valorMaximo, double valor) {
        String resultado = "";
        if (valor > valorMaximo) {
            resultado = "ESMAYOR";
        } else {
            resultado = "ESMENOR";
        }
        return resultado;
    }

    /**
     * Metodo encargado de inicializar el txt si esta seleccionado toda la
     * informacion (Tiene que ser en keyRelease
     *
     * @param txt
     */
    public static void inicializarSiEstaSeleccionadoNumero(JTextField txt, KeyEvent e) {
        String regex = "[0-9]";
        String regex2 = "[.,]";
        if (e.getKeyCode() != KeyEvent.VK_ENTER && (Character.toString(e.getKeyChar()).matches(regex)
                || Character.toString(e.getKeyChar()).matches(regex2))) {
            if (txt.getSelectionStart() == 0 && txt.getSelectionEnd() == txt.getText().length()) {
                if (Character.toString(e.getKeyChar()).matches("[,]")) {
                    txt.setText(".");
                } else {
                    txt.setText(Character.toString(e.getKeyChar()));
                }
            }
        }
    }

    /**
     * metodo que maneja el cambio de posicio entre Componentes con las flechas
     * de direccion del teclado
     *
     * @param e
     * @param arriba
     * @param abajo
     * @param derecha
     * @param izquierda
     * @param principal
     */
    public static void teclasDireccion(KeyEvent e, JComponent arriba, JComponent abajo, JComponent derecha,
            JComponent izquierda, JComponent principal) {

        if (arriba != null) {
            if (e.getKeyCode() == (KeyEvent.VK_UP)) {
                arriba.grabFocus();
            }
        }
        if (abajo != null) {
            if (e.getKeyCode() == (KeyEvent.VK_DOWN)) {
                abajo.grabFocus();
            }
        }
        if (derecha != null) {
            if (e.getKeyCode() == (KeyEvent.VK_RIGHT)) {

                if (principal instanceof JTextField) {
                    JTextField princ = new JTextField();
                    JTextField der = new JTextField();
                    princ = (JTextField) principal;
                    if (derecha instanceof JTextField) {
                        der = (JTextField) derecha;
                        if (princ.getCaretPosition() == princ.getText().trim().length()) {
                            der.setCaretPosition(der.getText().trim().length());
                            derecha = der;
                            derecha.grabFocus();
                        }
                    } else {
                        derecha.grabFocus();
                    }
                } else {
                    derecha.grabFocus();
                }

            }
        }
        if (izquierda != null) {
            if (e.getKeyCode() == (KeyEvent.VK_LEFT)) {

                if (principal instanceof JTextField) {
                    JTextField princ = new JTextField();
                    JTextField izq = new JTextField();
                    princ = (JTextField) principal;
                    if (izquierda instanceof JTextField) {
                        izq = (JTextField) izquierda;
                        if (princ.getCaretPosition() == 0) {
                            izq.setCaretPosition(izq.getText().trim().length());
                            izquierda = izq;
                            izquierda.grabFocus();
                        }
                    } else {
                        izquierda.grabFocus();
                    }
                } else {
                    izquierda.grabFocus();
                }
            }
        }

    }

    /**
     * Convierte Sring a double, si no puede retorna 0
     *
     * @param valor
     * @return
     */
    public static double convertirStringADouble(String valor) {
        double valorF = 0;
        try {
            valorF = Double.valueOf(valor);
        } catch (Exception e) {
            Log.adicionarCS(e, "", valor, "convertirStringADouble");
            valorF = 0;
        }
        return valorF;
    }

    /**
     * Convierte Sring a double, si no puede retorna null
     *
     * @param valor
     * @return
     */
    public static double convertirStringAInt(String valor) {
        double valorF = 0;
        try {
            valorF = Double.valueOf(valor);
        } catch (Exception e) {
            Log.adicionarCS(e, "", valor, "convertirStringADouble");
            valorF = 0;
        }
        return valorF;
    }

}
