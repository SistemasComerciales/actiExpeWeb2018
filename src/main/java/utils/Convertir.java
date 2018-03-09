package utils;

import java.text.*;
import java.util.*;

public class Convertir {

    /**
     * metodo que convierte un String(moneda) en un entero TENER CUIDADO CON LOS
     * DECIMALES LOS CONVIERTE EN ENTERO
     *
     * @param valor
     * @return valor sin formato moneda
     */
    public static long convertirMonedaLong(String valor) {
        long valorSinMoneda = 0;
        String valorNuevo = "";
        char a1[] = valor.toCharArray();
        for (int i = 0; i < a1.length; i++) {
            if (Character.isDigit(a1[i])) {
                valorNuevo = valorNuevo + a1[i];
            }

        }
        valorSinMoneda = Integer.parseInt(valorNuevo);
        return valorSinMoneda;
    }

    /**
     * metodo que convierte un String(moneda) en un Double
     *
     * @param valor
     * @return valor sin formato moneda o -1 en caso de error
     */
    public static double convertirMonedaDouble(String valor) {
        double valorSinMoneda = 0;
        String valorNuevo = valor.trim().replace("$", "").replace(",", "").replace(" ", "").replace("�", "");
        if (valorNuevo.trim().equalsIgnoreCase("")) {
            valorSinMoneda = -1;
        } else {
            valorSinMoneda = Double.parseDouble(valorNuevo);
            valorSinMoneda = Formatos.truncarDecimales(valorSinMoneda, 2);
        }

        return valorSinMoneda;
    }

    /**
     * metodo que convierte un Double en moneda
     *
     * @param valor
     * @return String con formato moneda
     */
    public static String convertirDoubleMoneda(double valor) {
        String valorNuevo = "";
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        valorNuevo = nf.format(Formatos.truncarDecimales(valor, 2));
        if (valorNuevo.equals("-1")) {
            valorNuevo = "0";
        }
        return valorNuevo;
    }

    /**
     * metodo que convierte un Double en porcentaje
     *
     * @param valor
     * @return String con formato Porcentaje
     */
    public static String convertirDoublePorcentaje(double valor) {
        String valorNuevo = "";
        valorNuevo = String.valueOf(valor) + "%";
        return valorNuevo;
    }

    /**
     * metodo que convierte un String(Porcentaje) en un Float
     *
     * @param valor
     * @return valor sin formato moneda
     */
    public static double convertirPorcentajeDouble(String valor) {
        double valorSinporcentaje = 0;
        String valorNuevo = valor.replace("%", "").replace(",", "").replace(" ", "");

        valorSinporcentaje = Float.parseFloat(valorNuevo);
        return valorSinporcentaje;
    }

    /**
     * metodo que convierte un String a un String moneda
     *
     * @param valor
     * @return String con formato moneda o ERROR
     */
    public static String convertirStringAStringMoneda(String valor) {
        String valorNuevo = "";
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.ENGLISH);
        try {
            double val = Formatos.truncarDecimales(Double.parseDouble(valor), 2);
            valorNuevo = nf.format(val).replace(".", ":").replace(",", ".").replace(":", ",").replace("�", "$");
        } catch (Exception e) {
            valorNuevo = "ERROR";
        }

        return valorNuevo;
    }

    /**
     * metodo que convierte un String a un String moneda
     *
     * @param valor
     * @return String con formato Porcentaje o ERROR
     */
    public static String convertirStringAStringPorcentaje(String valor) {
        String valorNuevo = "";
        valorNuevo = valor + "%";
        return valorNuevo;
    }

}
