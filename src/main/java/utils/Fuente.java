/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.*;
import java.io.*;

/**
 *
 * @author SISTEMASCOMERCIALES
 */
public class Fuente {

    private Font font = null;

    public Fuente() {

        String fontName = "fuentes/AmpleSoft.otf";
        try {
            //Se carga la fuente
            File is = new File(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            font = new Font("Arial", Font.BOLD, 12);
//			JOptionPane.showOptionDialog(null, mensajeErrorfuente, "Error (3571)",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,"aceptar");   	   
            //Si existe un error se carga fuente por defecto ARIAL
//           System.err.println(fontName + " No se cargo la fuente");
        }

    }

    public Font MyFont(int estilo, float tamano) {
        Font tfont = font.deriveFont(estilo, tamano);
        return tfont;
    }
}
