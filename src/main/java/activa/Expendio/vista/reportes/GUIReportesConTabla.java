package activa.Expendio.vista.reportes;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.*;
import utils.*;

public abstract class GUIReportesConTabla extends GUIReportes {

    private static final long serialVersionUID = -9016589185761511842L;

    // Tabla General
    protected JTable tablaGeneral;
    protected DefaultTableModel dtmTablaGeneral;
    protected JPanel panel_tablaGeneral;
    protected JScrollPane scrollPaneTablaGeneral;

    public GUIReportesConTabla(Usuario usuario) {
        super(usuario);

        prepareElementosTabla();
    }

    /**
     * Adiciona columnas a la tabla.
     */
    protected abstract void adicionarColumnas();

    /**
     * Cambiar el tamano cada columna de la tabla. <br>
     * <code>
     * tablaGeneral.getColumnModel().getColumn(i).setMaxWidth(<b><i>{tamano de
     * la columna}</i></b>);<br>
     * tablaGeneral.getColumnModel().getColumn(i).setMinWidth(<b><i>{tamano de
     * la columna}</i></b>);<br>
     * tablaGeneral.getColumnModel().getColumn(i).setPreferredWidth(<b><i>{tamano
     * de la columna</i></b>});
     * </code>
     */
    protected abstract void cambiarTamanoColumnas();

    protected void prepareElementosTabla() {// XXX Panel de tabla
        int anchoPanel = 7 * CargaImagenes.ANCHO_PANTALLA / 8;
        int altoPanel = CargaImagenes.ALTO_PANTALLA / 2;
        int margenSuperior = panel_botones.getY() + panel_botones.getHeight();//CargaImagenes.ALTO_PANTALLA / 100 * 43;
        int margenIzquierda = (CargaImagenes.ANCHO_PANTALLA - anchoPanel) / 2;

        panel_tablaGeneral = new JPanel();
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBounds(margenIzquierda, margenSuperior, anchoPanel, altoPanel);

        dtmTablaGeneral = new TablaNoEditable();
        tablaGeneral = new JTable(dtmTablaGeneral);
        scrollPaneTablaGeneral = new JScrollPane(tablaGeneral);

        scrollPaneTablaGeneral.setBounds(0, 0, anchoPanel - 25, altoPanel - 27);
        tablaGeneral.setPreferredScrollableViewportSize(new Dimension(anchoPanel - 25, altoPanel - 60));

        tablaGeneral.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablaGeneral.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tablaGeneral.getTableHeader().setReorderingAllowed(false);
        tablaGeneral.setDefaultRenderer(Object.class, new Tabla.MiRenderColumnasPesos());
        tablaGeneral.setShowHorizontalLines(false);
        tablaGeneral.setBorder(null);
        tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setOpaque(false);
        panel_tablaGeneral.setBorder(null);
        scrollPaneTablaGeneral.setOpaque(false);
        scrollPaneTablaGeneral.getViewport().setOpaque(false);
        scrollPaneTablaGeneral.setBorder(null);

        panel_tablaGeneral.add(scrollPaneTablaGeneral);
        this.add(panel_tablaGeneral);

        adicionarColumnas();
        columnasTamanioCero();
        cambiarTamanoColumnas();
    }

    protected final void columnasTamanioCero() {
        for (int i = 0; i < tablaGeneral.getColumnCount(); i++) {
            tablaGeneral.getColumnModel().getColumn(i).setMaxWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setMinWidth(0);
            tablaGeneral.getColumnModel().getColumn(i).setPreferredWidth(0);
        }
    }

}
