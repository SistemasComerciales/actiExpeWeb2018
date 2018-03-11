package utils;

import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;

public class Tabla {

    /**
     * Metodo encargado de eliminar las filas de las tablas
     *
     * @param dtmTabla
     * @param tabla
     */
    public static void eliminarFilasTabla(DefaultTableModel dtmTabla) {
        dtmTabla.setRowCount(0);
    }

    /**
     * Render clasico
     *
     * @author Usuario
     *
     */
    public static class MiRender extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 6549210495205555390L;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c2 = new Color(216, 233, 225);
            Color c = new Color(255, 255, 255);
            Color colorSelect = new Color(195, 245, 220);
            this.setForeground(Letra.colorFuenteTabla);
            this.setFont(Letra.fuenteTabla);
            this.setBackground(c2);
            boolean oddRow = (row % 2 == 0);
            if (oddRow) {
                setBackground(c);
            }
            if (isSelected) {
                this.setBackground(colorSelect);
            }
            return this;
        }
    }

    public static class MiRender2 extends DefaultTableCellRenderer {

        private static final long serialVersionUID = -5696292528926397833L;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c2 = new Color(236, 253, 245);
            Color c = new Color(255, 255, 255);
            Color colorSelect = new Color(195, 245, 220);
            this.setForeground(Letra.colorFuenteTabla);
            this.setFont(Letra.fuenteTabla);
            this.setBackground(c2);
            boolean oddRow = (row % 2 == 0);
            if (oddRow) {
                setBackground(c);
            }

            if (isSelected) {
                this.setBackground(colorSelect);
            }
            return this;
        }
    }

    public static class MiRenderColumnasPesos extends DefaultTableCellRenderer {

        private static final long serialVersionUID = -514080149699416809L;

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c2 = new Color(236, 253, 245);
            Color c = new Color(255, 255, 255);
            Color colorSelect = new Color(195, 245, 220);
            this.setForeground(Letra.colorFuenteTabla);
            this.setFont(Letra.fuenteTabla);
            this.setBackground(c2);
            boolean oddRow = (row % 2 == 0);
            if (oddRow) {
                setBackground(c);
            }
            if (isSelected) {
                this.setBackground(colorSelect);
            }
            if (value != null) {
                if (value.toString().startsWith("$") || value.toString().startsWith("-$")) {
                    this.setHorizontalAlignment(SwingConstants.RIGHT);
                } else {
                    this.setHorizontalAlignment(SwingConstants.LEFT);
                }
            } else {
                this.setHorizontalAlignment(SwingConstants.LEFT);
            }

            return this;
        }
    }

    public static class MiRenderPagos extends DefaultTableCellRenderer {

        private static final long serialVersionUID = 7238057999006423403L;

        private int columnaIdInterno;

        public MiRenderPagos(int columnaIdInterno) {
            this.columnaIdInterno = columnaIdInterno;
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            Color c2 = new Color(236, 253, 245);
            Color c = new Color(255, 255, 255);
            Color colorSelect = new Color(195, 245, 220);
            this.setForeground(Letra.colorFuenteTabla);
            this.setFont(Letra.fuenteTabla);
            this.setBackground(c2);

            boolean oddRow = false;
            String idInterno = (String) table.getModel().getValueAt(row, columnaIdInterno);
            int idInt = idInterno != null && !idInterno.trim().isEmpty() ? Integer.parseInt(idInterno.trim()) : 0;
            oddRow = (idInt % 2 == 0);
            if (oddRow) {
                setBackground(c);
            }

            if (isSelected) {
                this.setBackground(colorSelect);
            }
            if (value != null) {
                if (value.toString().startsWith("$") || value.toString().startsWith("-$")) {
                    this.setHorizontalAlignment(SwingConstants.RIGHT);
                } else {
                    this.setHorizontalAlignment(SwingConstants.LEFT);
                }
            } else {
                this.setHorizontalAlignment(SwingConstants.LEFT);
            }

            return this;
        }
    }
}
