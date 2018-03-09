package utils;

import activa.expendio.vista.utils.CajaDeTexto;
import java.math.*;
import java.text.*;
import java.util.*;

public abstract class Formatos {

    public Formatos() {
    }

    /**
     * metodo que formatea un String Para Porcentajes con dos decimales
     *
     * @param valor
     * @return el valor ingresado formateado a porcentaje o vacio en caso de
     * error
     */
    public static String formatearPorcentajeString(String valor) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }

            double monto = Double.parseDouble(valor.replace(" ", ""));
            java.text.DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#########.00", simbolos);

            valor = (formateador.format(monto) + "%");

            return valor;
        }
        return valor;
    }

    /**
     * metodo que quita a un String Formato Porcentaje
     *
     * @param valor
     * @return el valor ingresado sin formtato o porcentaje o vacio en caso de
     * error
     */
    public static String quitarFormatoPorcentaje(String valor) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }

            double monto = Double.parseDouble(valor.replace(" ", ""));
            java.text.DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#########.00", simbolos);

            valor = (formateador.format(monto));
            return valor;
        }
        return valor;
    }

    /**
     * metodo que formatea un String Para Pesos con dos decimales
     *
     * @param valor
     * @return valor con formato pesos y dos decimales o el mismo valor si no
     * comienza con el signo $
     */
    public static String formatearValorString(String valor) {
        if (valor.length() == 1 && valor.startsWith(".")) {
            valor = "";
        }
        if (!valor.startsWith("$")) {
            if (!valor.trim().isEmpty()) {
                double monto = Double.parseDouble(valor.trim().replace(" ", "").replace(",", "").replace("$", ""));
                int decimales = CajaDeTexto.longitudDecimalMoneda;
                monto = truncarDecimales(monto, decimales);
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

                valor = nf.format(monto);
                if (valor.startsWith("(")) {
                    valor = "-" + valor.replace("(", "").replace(")", "");
                }
                return valor;
            }
        }
        return valor;
    }

    /**
     * metodo que formatea un String Para Pesos con dos decimales
     *
     * @param valor
     * @return valor con formato pesos y dos decimales o el mismo valor si no
     * comienza con el signo $
     */
    public static String formatearValorDecimalesString(String valor, int decimales) {
        if (valor.length() == 1 && valor.startsWith(".")) {
            valor = "";
        }
        if (!valor.startsWith("$")) {
            if (!valor.trim().isEmpty()) {
                double monto = Double.parseDouble(valor.trim().replace(" ", "").replace(",", "").replace("$", ""));
                monto = truncarDecimales(monto, decimales);
                NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);

                valor = nf.format(monto);
                if (valor.startsWith("(")) {
                    valor = "-" + valor.replace("(", "").replace(")", "");
                }
                return valor;
            }
        }
        return valor;
    }

    /**
     * metodo que quita el formato Pesos a un string
     *
     * @param valor
     * @return valor sin formato pesos o el mismo valor si no comienza con el
     * signo $
     */
    public static String quitarFormatoValorString(String valor) {
        if (valor.startsWith("$") || valor.startsWith("-")) {
            if (!valor.trim().isEmpty()) {
                valor = (valor.replace(",", "").replace("$", "").replace("�", "").replace(" ", "").trim());
                return valor;
            }
        }
        return valor;
    }

    /**
     * metodo que agrega decimales y separadores de mil a un String
     *
     * @param valor
     * @return devuelve el valor con dos decimales o vacio en caso de error
     */
    public static String formatearNumeroAgregaDecimalesString(String valor) {
        if (!valor.trim().isEmpty()) {
            double monto = Double.parseDouble(valor.trim().replace(" ", "").replace(",", "").replace("$", ""));
            NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
            valor = nf.format(monto);
            valor = valor.replace("$", "");
            if (valor.startsWith("(")) {
                valor = "-" + valor.replace("(", "").replace(")", "");
            }
            return valor;
        }
        return valor;
    }

    /**
     * metodo que quita el formato miles y decimal a un string
     *
     * @param valor
     * @return valor sin formato miles a decimales o vacio en caso de error
     */
    public static String quitarFormatoDecimalesString(String valor) {

        if (!valor.trim().isEmpty()) {
            valor = (valor.replace(",", "").replace("$", "").replace("�", "").replace(" ", "").trim());
            return valor;
        }

        return valor;
    }

    /**
     * metodo que formatea un String Para Porcentajes, con el numero de
     * decimales pasado por parametro
     *
     * @param valor
     * @param numeroDecimales
     * @return el valor ingresado formateado a porcentaje o vacio en caso de
     * error
     */
    public static String formatearPorcentajeString(String valor, int numeroDecimales) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }
            String cerosDecimales = "";
            for (int i = 0; i < numeroDecimales; i++) {
                cerosDecimales = cerosDecimales + "0";
            }
            double monto = Double.parseDouble(valor.replace(" ", ""));
            java.text.DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#########." + cerosDecimales + "", simbolos);

            valor = (formateador.format(monto) + "%");
            if (valor.startsWith(".")) {
                valor = "0" + valor;
            }
            return valor;
        }
        return valor;
    }

    /**
     * metodo que quita a un String Formato Porcentaje
     *
     * @param valor
     * @param numeroDecimales
     * @return el valor ingresado sin formtato o porcentaje o vacio en caso de
     * error
     */
    public static String quitarFormatoPorcentaje(String valor, int numeroDecimales) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }

            String cerosDecimales = "";
            for (int i = 0; i < numeroDecimales; i++) {
                cerosDecimales = cerosDecimales + "0";
            }

            float monto = Float.parseFloat(valor.replace(" ", ""));
            java.text.DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#########." + cerosDecimales + "", simbolos);

            valor = (formateador.format(monto));
            if (valor.startsWith(".")) {
                valor = "0" + valor;
            }
            return valor;
        }
        return valor;
    }

    /**
     * metodo que quita a un String los ceros decimales.
     *
     * @param valor
     * @return el valor ingresado sin ceros a la derecha
     */
    public static String quitarCerosDecimalesPorcentaje(String valor) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }

            if (valor.contains(".")) {
                int posicionPunto = valor.indexOf(".");
                for (int i = valor.length(); i > posicionPunto; i--) {
                    if (valor.substring(i - 1, i).equals("0")) {
                        valor = valor.substring(0, i - 1);
                    } else {
                        return valor + "%";
                    }
                }
            } else {
                return valor + "%";
            }

        }
        return valor;
    }

    /**
     * metodo que trunca un valor con decimales
     *
     * @param numero
     * @param decimales
     * @return el valor truncado
     */
    public static double truncarDecimales(double numero, int decimales) {
        double valor = numero;
        String val = String.valueOf(valor);
        BigDecimal big = new BigDecimal(val);
        big = big.setScale(decimales, RoundingMode.HALF_UP);

        return big.doubleValue();
    }

    /**
     * metodo que formatea un String Para Factor, con el numero de decimales
     * pasado por parametro
     *
     * @param valor
     * @param numeroDecimales
     * @return el valor ingresado formateado a porcentaje o vacio en caso de
     * error
     */
    public static String formatearFactorString(String valor, int numeroDecimales) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }
            String cerosDecimales = "";
            for (int i = 0; i < numeroDecimales; i++) {
                cerosDecimales = cerosDecimales + "0";
            }
            double monto = Double.parseDouble(valor.replace(" ", ""));
            java.text.DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#########." + cerosDecimales + "", simbolos);

            valor = (formateador.format(monto) + "");
            if (valor.startsWith(".")) {
                valor = "0" + valor;
            }
            return valor;
        }
        return valor;
    }

    /**
     * metodo que quita a un String Formato Factor
     *
     * @param valor
     * @param numeroDecimales
     * @return el valor ingresado sin formtato o porcentaje o vacio en caso de
     * error
     */
    public static String quitarFormatoFactor(String valor, int numeroDecimales) {
        if (!valor.trim().isEmpty()) {
            if (valor.trim().endsWith("%")) {
                valor = valor.substring(0, valor.length() - 1);
            }

            String cerosDecimales = "";
            for (int i = 0; i < numeroDecimales; i++) {
                cerosDecimales = cerosDecimales + "0";
            }

            float monto = Float.parseFloat(valor.replace(" ", ""));
            java.text.DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("#########." + cerosDecimales + "", simbolos);

            valor = (formateador.format(monto));
            if (valor.startsWith(".")) {
                valor = "0" + valor;
            }
            return valor;
        }
        return valor;
    }

}
