package activa.Expendio.vista.tablas;

import activa.Expendio.modelo.*;
import activa.Expendio.controllers.*;
import activa.Expendio.vista.utils.*;
import java.util.*;
import utils.*;

/**
 * Clase encargada de traer en una tabla todas las bodegas activas y no
 * eliminadas.
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITablaBodegas extends GUITabla {

    public static final int columnaCodigo = 0;
    public static final int columnaNombre = columnaCodigo + 1;
    public static final int columnaEstado = columnaNombre + 1;
    public static final int columnaId = columnaEstado + 1;

    public GUITablaBodegas(int posX, int posY, int anchoPanel, int altoPanel) {
        super(posX, posY, anchoPanel, altoPanel);
    }

    @Override
    public void adicionarColumnas() {
        dtm.addColumn("Código");
        dtm.addColumn("Nombre");
        dtm.addColumn("Estado");
        dtm.addColumn("ID");
    }

    @Override
    public void cambiarTamanoColumnas() {
        int columna = (this.getWidth() - 25) / 3;
        tabla.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(columna / 2);
        tabla.getColumnModel().getColumn(columnaNombre).setPreferredWidth(columna * 2);
        tabla.getColumnModel().getColumn(columnaEstado).setPreferredWidth(columna / 2);
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
        deshacerFiltro();
        Tabla.eliminarFilasTabla(dtm);
        ArrayList<Bodega> bodegas = Servicios.bodegasController.bodegasRepository.consultarActivosNoEliminados();
        if (bodegas != null && bodegas.size() > 0) {
            for (Bodega bodega : bodegas) {
                String[] datos = new String[dtm.getColumnCount()];

                datos[columnaCodigo] = bodega.getCodigo();
                datos[columnaNombre] = bodega.getNombre();

                boolean estado = bodega.getEstado();
                String est;
                if (estado) {
                    est = DatosBaseDatos.estadoActivo;
                } else {
                    est = DatosBaseDatos.estadoInactivo;
                }
                datos[columnaEstado] = est;

                datos[columnaId] = String.valueOf(bodega.getId());

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
