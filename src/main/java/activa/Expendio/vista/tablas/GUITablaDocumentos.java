package activa.Expendio.vista.tablas;

import activa.Expendio.modelo.*;
import activa.Expendio.controllers.*;
import activa.Expendio.vista.*;
import activa.Expendio.vista.utils.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import utils.*;

/**
 * Clase encargada de traer en una tabla todos los documentos fuente activos y
 * no eliminados.
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITablaDocumentos extends JPanel {

    public DefaultTableModel dtm;
    public JTable tabla;
    public JScrollPane scroll;
    public TableRowSorter<DefaultTableModel> trsFiltro;

    public static final int columnaCodigo = 0;
    public static final int columnaNombre = columnaCodigo + 1;
    public static final int columnaId = columnaNombre + 1;

    public GUITablaDocumentos(int posX, int posY, int anchoPanel, int altoPanel) {
        crearTabla();
        cambiarTamanoTabla(posX, posY, anchoPanel, altoPanel);
    }

    public void crearTabla() {
        this.setOpaque(false);
        this.setBorder(null);

        dtm = new TablaNoEditable();
        dtm.addColumn("Código");
        dtm.addColumn("Nombre");
        dtm.addColumn("ID");

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
    public void cambiarTamanoTabla(int posX, int posY, int anchoPanel, int altoPanel) {
        this.setLocation(posX, posY);
        this.setSize(anchoPanel, altoPanel);
        tabla.setPreferredScrollableViewportSize(new Dimension(this.getWidth() - 25, this.getHeight() - 50));
        scroll.setBounds(0, 0, this.getWidth() - 25, this.getHeight());

        int columna = (anchoPanel - 25) / 3;
        tabla.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(columna);
        tabla.getColumnModel().getColumn(columnaNombre).setPreferredWidth(columna * 2);
        tabla.getColumnModel().getColumn(columnaId).setMinWidth(0);
        tabla.getColumnModel().getColumn(columnaId).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(columnaId).setMaxWidth(0);
    }

    /**
     * Metodo encargado de cargar los datos de la tabla de documentos fuente.
     *
     * @param usuario
     * @return boolean <br>
     * <b>true</b>: SI cargo bien<br>
     * <b>false</b>: Si ocurre algun error
     */
    public boolean cargarDatosBasicos(Usuario usuario) {
        boolean cargo = false;
        ArrayList<DocumentoFuente> documentos = Servicios.documentosController.documentosRepository.consultarActivosNoEliminados();
        if (documentos != null && documentos.size() > 0) {
            for (DocumentoFuente documento : documentos) {
                String[] datos = new String[dtm.getColumnCount()];

                datos[columnaCodigo] = documento.getCodigo();
                datos[columnaNombre] = documento.getNombre();
                datos[columnaId] = String.valueOf(documento.getId());

                dtm.addRow(datos);
            }
            cargo = true;
        } else {
//            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeAdvertencia, "(55)", "", ExpendioException.getMensajeErrorBaseDatos());
            cargo = false;
        }
        return cargo;
    }

    public void deshacerFiltro() {
        Filtro.deshacerFiltro(trsFiltro, dtm, tabla);
    }

    public void aplicarFiltro(CajaDeTexto txt) {
        Filtro.filtroDosColumnasQueContenga(txt.getText().trim(), trsFiltro, columnaCodigo, columnaNombre, dtm, tabla);
    }

    @Override
    public void grabFocus() {
        if (tabla.getRowCount() >= 1) {
            tabla.grabFocus();
            tabla.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

}
