package activa.Expendio.vista.tablas;

import activa.Expendio.modelo.*;
import activa.Expendio.controllers.*;
import activa.Expendio.vista.utils.*;
import java.util.*;
import utils.*;

/**
 * Clase encargada de traer en una tabla todos los grupos de productos activos y
 * no eliminados.
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITablaGrupos extends GUITabla {

    public static final int columnaCodigo = 0;
    public static final int columnaNombre = columnaCodigo + 1;
    public static final int columnaId = columnaNombre + 1;

    public GUITablaGrupos(int posX, int posY, int anchoPanel, int altoPanel) {
        super(posX, posY, anchoPanel, altoPanel);
    }

    @Override
    public void adicionarColumnas() {
        dtm.addColumn("Código");
        dtm.addColumn("Nombre");
        dtm.addColumn("ID");
    }

    @Override
    public void cambiarTamanoColumnas() {
        int columna = (this.getWidth() - 25) / 3;
        tabla.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(columna);
        tabla.getColumnModel().getColumn(columnaNombre).setPreferredWidth(columna * 2);
        tabla.getColumnModel().getColumn(columnaId).setMinWidth(0);
        tabla.getColumnModel().getColumn(columnaId).setPreferredWidth(0);
        tabla.getColumnModel().getColumn(columnaId).setMaxWidth(0);
    }

    @Override
    public void aplicarFiltro(CajaDeTexto txt) {
        Filtro.filtroDosColumnasQueContenga(txt.getText().trim(), trsFiltro, columnaCodigo, columnaNombre, dtm, tabla);
    }

    @Override
    public boolean cargarDatosBasicos(Usuario usuario) {
        boolean cargo = false;
        ArrayList<GrupoProducto> grupos = Servicios.gruposController.gruposRepository.consultarActivosNoEliminados();
        if (grupos != null && grupos.size() > 0) {
            for (GrupoProducto grupo : grupos) {
                String[] datos = new String[dtm.getColumnCount()];

                datos[columnaCodigo] = grupo.getCodigo();
                datos[columnaNombre] = grupo.getNombre();
                datos[columnaId] = String.valueOf(grupo.getId());

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
