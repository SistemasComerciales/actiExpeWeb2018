package utils;

import java.awt.*;

import javax.swing.*;

public class SeleccionarFila {

    /**
     * Metodo encargado de seleccionar la fila que tenga le id pasado por
     * parametro.
     *
     * @param id
     * @param columnaId
     */
    public static void seleccionarFila(JTable tablaGeneral, String id, int columnaId) {
        int filaActual = 0;
        for (int i = 0; i < tablaGeneral.getRowCount(); i++) {
            if (tablaGeneral.getValueAt(i, columnaId).equals(id)) {
                filaActual = i;
                break;
            }
        }
        tablaGeneral.setRowSelectionInterval(filaActual, filaActual);
        tablaGeneral.grabFocus();
        tablaGeneral.scrollRectToVisible(new Rectangle(tablaGeneral.getCellRect(filaActual, 0, true)));
    }
}
