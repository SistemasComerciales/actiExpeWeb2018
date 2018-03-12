package utils;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.*;

/**
 *
 * @author Avuunita
 */
public class NumeroConsecutivo {

    public static String numeroConsecutivoPrefijo(String numeroParametro, Usuario usuario) {
        String valorRetornar = "";
        String prefijo = "";
        String numero = "";
        String numeroModificar = numeroParametro.trim();
        String ceros = "";
        int posicionPrefijo = -1;

        for (int i = numeroModificar.length() - 1; i >= 0; i--) {
            if (!Character.isDigit(numeroModificar.charAt(i))) {
                posicionPrefijo = i;
                break;
            }

        }
        prefijo = numeroModificar.substring(0, posicionPrefijo + 1);
        numero = numeroModificar.substring(posicionPrefijo + 1, numeroModificar.length());
        numero = numero.trim();
        prefijo = prefijo.trim();

        long nuevoNumero = 0;
        if (numero.length() >= 1) {
            try {
                nuevoNumero = Long.parseLong(numero);
                nuevoNumero = nuevoNumero + 1;
            } catch (Exception e) {
                ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeAdvertencia, "141", "Ha ocurrido un error con el consecutivo.", "Inténtelo de nuevo.");
                e.printStackTrace();
            }
        } else {
            return "";
        }

        //////////////////////////////////
        String temporalParaLongitud = "" + nuevoNumero;
        temporalParaLongitud = temporalParaLongitud.trim();

        int longitudNumeroAnterior = numero.length();
        int longitudNuevoNumeroAA = temporalParaLongitud.length();

//        if (longitudNumeroAnterior < longitudNuevoNumeroAA) {
//            return "NOHAYCUPO";
//        }
        ////////////////////////////////

        String longitudNuevoNumero = String.valueOf(nuevoNumero);
        longitudNuevoNumero = longitudNuevoNumero.trim();

        for (int f = 0; f < (numero.length() - longitudNuevoNumero.length()); f++) {
            if (numero.charAt(f) == '0') {
                ceros = ceros + "0";
            } else {
                break;
            }
        }

        valorRetornar = prefijo + ceros + nuevoNumero;
        return valorRetornar;
    }

    public static String numeroConsecutivoPrefijo(int posicionPrefijo, String numeroParametro, Usuario usuario) {
        String valorRetornar = "";
        String prefijo = "";
        String numero = "";
        String numeroModificar = numeroParametro.trim();
        String ceros = "";

        prefijo = numeroModificar.substring(0, posicionPrefijo + 1);
        numero = numeroModificar.substring(posicionPrefijo + 1, numeroModificar.length());
        numero = numero.trim();
        prefijo = prefijo.trim();

        long nuevoNumero = 0;
        if (numero.length() >= 1) {
            try {
                nuevoNumero = Long.parseLong(numero);
                nuevoNumero = nuevoNumero + 1;
            } catch (Exception e) {
                ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeAdvertencia, "141", "Ha ocurrido un error con el consecutivo.", "Inténtelo de nuevo.");
                e.printStackTrace();
            }
        } else {
            return "";
        }

        //////////////////////////////////
        String temporalParaLongitud = "" + nuevoNumero;
        temporalParaLongitud = temporalParaLongitud.trim();

        int longitudNumeroAnterior = numero.length();
        int longitudNuevoNumeroAA = temporalParaLongitud.length();

        if (longitudNumeroAnterior < longitudNuevoNumeroAA) {
            return "NOHAYCUPO";
        }
        ////////////////////////////////

        String longitudNuevoNumero = String.valueOf(nuevoNumero);
        longitudNuevoNumero = longitudNuevoNumero.trim();

        for (int f = 0; f < (numero.length() - longitudNuevoNumero.length()); f++) {
            if (numero.charAt(f) == '0') {
                ceros = ceros + "0";
            } else {
                break;
            }
        }

        valorRetornar = prefijo + ceros + nuevoNumero;
        return valorRetornar;
    }
}
