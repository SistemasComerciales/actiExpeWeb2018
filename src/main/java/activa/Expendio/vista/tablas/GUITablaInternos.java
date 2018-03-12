package activa.Expendio.vista.tablas;

import activa.Expendio.modelo.*;
import activa.Expendio.controllers.*;
import activa.Expendio.vista.utils.*;
import java.util.*;
import utils.*;

/**
 * Clase encargada de traer en una tabla todos los internos activos y no
 * eliminados.
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITablaInternos extends GUITabla {

    public static final int columnaTD = 0;
    public static final int columnaNUI = columnaTD + 1;
    public static final int columnaNombre = columnaNUI + 1;
    public static final int columnaId = columnaNombre + 1;

    public GUITablaInternos(int posX, int posY, int anchoPanel, int altoPanel) {
        super(posX, posY, anchoPanel, altoPanel);
    }

    @Override
    public void adicionarColumnas() {
        dtm.addColumn("TD");
        dtm.addColumn("NUI");
        dtm.addColumn("Nombre");
        dtm.addColumn("ID");
    }

    @Override
    public void cambiarTamanoColumnas() {
        int columna = (this.getWidth() - 25) / 3;
        tabla.getColumnModel().getColumn(columnaTD).setPreferredWidth(columna);
        tabla.getColumnModel().getColumn(columnaNUI).setPreferredWidth(columna);
        tabla.getColumnModel().getColumn(columnaNombre).setPreferredWidth(columna * 2);
        tabla.getColumnModel().getColumn(columnaId).setMinWidth(0);
        tabla.getColumnModel().getColumn(columnaId).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(columnaId).setMaxWidth(0);
    }

    @Override
    public void aplicarFiltro(CajaDeTexto txt) {
        Filtro.filtroTresColumnasQueContenga(txt.getText().trim(), trsFiltro, columnaTD, columnaNUI, columnaNombre, dtm, tabla);
    }

    @Override
    public boolean cargarDatosBasicos(Usuario usuario) {
        boolean cargo = false;
        ArrayList<Interno> internos = Servicios.internosController.internosRepository.getNoEliminadosYActivos();
        if (internos != null && internos.size() > 0) {
            for (Interno interno : internos) {
                String[] datos = new String[dtm.getColumnCount()];

                datos[columnaTD] = interno.getTd();
                datos[columnaNUI] = interno.getNui();

                String primerApellido = interno.getPrimerApellido();
                String segundoApellido = interno.getSegundoApellido();
                String primerNombre = interno.getPrimerNombre();
                String segundoNombre = interno.getSegundoNombre();
                String nombre = primerApellido + " " + segundoApellido + " " + primerNombre;
                if (segundoNombre != null && !segundoNombre.trim().isEmpty()) {
                    nombre += " " + segundoNombre;
                }
                datos[columnaNombre] = nombre;

                datos[columnaId] = String.valueOf(interno.getId());

                dtm.addRow(datos);
            }
            cargo = true;
        } else {
//            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeAdvertencia, "(55)", "", ExpendioException.getMensajeErrorBaseDatos());
            cargo = false;
        }
        return cargo;
    }

}
