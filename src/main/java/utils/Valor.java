/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Administrador
 */
public class Valor {

    /**
     * Metodo encargado de convertir a un valor long´pasando un string, si
     * ocurre algun error retorna 0
     *
     * @param valor
     * @return
     */
    public static long convertirValorStringALong(String valor) {
//        System.out.println("Valor Aca: " + valor);
        if (valor == null || valor.trim().isEmpty()) {
            return 0;
        }
        try {
            double valorD = Double.valueOf(valor);
            return (long) valorD;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * Metodo encargado de convertir a un valor double´pasando un string, si
     * ocurre algun error retorna 0
     *
     * @param valor
     * @return
     */
    public static double convertirValorStringDouble(String valor) {
//        System.out.println("Valor Aca: " + valor);
        if (valor == null || valor.trim().isEmpty()) {
            return 0;
        }
        try {
            double valorD = Double.valueOf(valor);
            return valorD;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
