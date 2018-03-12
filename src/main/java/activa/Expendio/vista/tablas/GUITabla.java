package activa.Expendio.vista.tablas;

import activa.Expendio.modelo.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import utils.*;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public abstract class GUITabla extends JPanel {

    public DefaultTableModel dtm;
    public JTable tabla;
    public JScrollPane scroll;
    public TableRowSorter<DefaultTableModel> trsFiltro;

    public GUITabla(int posX, int posY, int anchoPanel, int altoPanel) {
        crearTabla();
        cambiarTamanoTabla(posX, posY, anchoPanel, altoPanel);
    }

    public abstract void adicionarColumnas();

    public abstract void cambiarTamanoColumnas();

    public abstract void aplicarFiltro(CajaDeTexto txt);

    /**
     * Metodo encargado de cargar los datos de la tabla correspondiente.
     *
     * @param usuario
     * @return boolean <br>
     * <b>true</b>: SI cargo bien<br>
     * <b>false</b>: Si ocurre algun error
     */
    public abstract boolean cargarDatosBasicos(Usuario usuario);

    public final void crearTabla() {
        this.setOpaque(false);
        this.setBorder(null);

        dtm = new TablaNoEditable();
        adicionarColumnas();

        tabla = new JTable(dtm);
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabla.setDefaultRenderer(Object.class, new Tabla.MiRender());
        tabla.setShowHorizontalLines(false);
        tabla.setBorder(null);
        tabla.setOpaque(false);
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        scroll = new JScrollPane(tabla);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        this.add(scroll);
    }

    /**
     * Metodo encargado de cambiar la posicion y tamaño del panel
     *
     * @param anchoPanel
     * @param altoPanel
     */
    public final void cambiarTamanoTabla(int posX, int posY, int anchoPanel, int altoPanel) {
        this.setLocation(posX, posY);
        this.setSize(anchoPanel, altoPanel);
        tabla.setPreferredScrollableViewportSize(new Dimension(this.getWidth() - 25, this.getHeight() - 50));
        scroll.setBounds(0, 0, this.getWidth() - 25, this.getHeight());

        cambiarTamanoColumnas();
    }

    public final void deshacerFiltro() {
        Filtro.deshacerFiltro(trsFiltro, dtm, tabla);
    }

    @Override
    public final void grabFocus() {
        if (tabla.getRowCount() >= 1) {
            tabla.grabFocus();
            seleccionarPrimero();
        }
    }

    public final void seleccionarPrimero() {
        if (tabla.getRowCount() >= 1) {
            tabla.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

}
