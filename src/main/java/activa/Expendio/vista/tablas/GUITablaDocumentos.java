package activa.Expendio.vista.tablas;

import activa.Expendio.modelo.*;
import activa.Expendio.controllers.*;
import activa.Expendio.vista.utils.*;
import java.util.*;
import utils.*;

/**
 * Clase encargada de traer en una tabla todos los documentos fuente activos y
 * no eliminados.
 *
 * @author Avuuna la Luz del Alba
 */
public class GUITablaDocumentos extends GUITabla {

    public static final int columnaCodigo = 0;
    public static final int columnaNombre = columnaCodigo + 1;
    public static final int columnaAccion = columnaNombre + 1;
    public static final int columnaAplica = columnaAccion + 1;
    public static final int columnaId = columnaAplica + 1;

    public GUITablaDocumentos(int posX, int posY, int anchoPanel, int altoPanel) {
        super(posX, posY, anchoPanel, altoPanel);
    }

    @Override
    public void adicionarColumnas() {
        dtm.addColumn("Código");
        dtm.addColumn("Nombre");
        dtm.addColumn("Acción");
        dtm.addColumn("Aplica");
        dtm.addColumn("ID");
    }

    @Override
    public void cambiarTamanoColumnas() {
        int columna = (this.getWidth() - 25) / 3;
        tabla.getColumnModel().getColumn(columnaCodigo).setPreferredWidth(columna / 2);
        tabla.getColumnModel().getColumn(columnaNombre).setPreferredWidth(columna * 3 / 2);
        tabla.getColumnModel().getColumn(columnaAccion).setPreferredWidth(columna / 2);
        tabla.getColumnModel().getColumn(columnaAplica).setPreferredWidth(columna / 2);
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
        ArrayList<DocumentoFuente> documentos = Servicios.documentosController.documentosRepository.consultarActivosNoEliminados();
        if (documentos != null && documentos.size() > 0) {
            for (DocumentoFuente documento : documentos) {
                String[] datos = new String[dtm.getColumnCount()];

                datos[columnaCodigo] = documento.getCodigo();
                datos[columnaNombre] = documento.getNombre();

                String accionInv = documento.getAccion();
                switch (accionInv) {
                    case DatosBaseDatos.varEntradaBD:
                        datos[columnaAccion] = DatosBaseDatos.varEntrada;
                        break;
                    case DatosBaseDatos.varSalidaBD:
                        datos[columnaAccion] = DatosBaseDatos.varSalida;
                        break;
                    default:
                        break;
                }

                String aplica = documento.getAplica();
                switch (aplica) {
                    case DatosBaseDatos.varAplicaClienteBD:
                        datos[columnaAplica] = DatosBaseDatos.varAplicaCliente;
                        break;
                    case DatosBaseDatos.varAplicaProveedorBD:
                        datos[columnaAplica] = DatosBaseDatos.varAplicaProveedor;
                        break;
                    default:
                        break;
                }

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

}
