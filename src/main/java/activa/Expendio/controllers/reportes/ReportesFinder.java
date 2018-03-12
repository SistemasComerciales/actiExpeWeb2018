package activa.Expendio.controllers.reportes;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.vista.ClaseGeneral;
import activa.Expendio.vista.GUIJOption;
import java.sql.*;
import java.util.*;
import java.util.Date;

import utils.*;

public class ReportesFinder extends Finder {

    private static final long serialVersionUID = -7426959825313696983L;

    public ReportesFinder(Usuario usuario) {
        super(usuario);
    }

    public List<Map<String, Object>> traerMovimientosInterno(Long idInterno,
            String fechaInicial, String fechaFinal) {
        // Movimientos del interno

        ArrayList<Map<String, Object>> respuesta = null;
        ArrayList<Consignacion> consignaciones = Servicios.consignacionesController.consignacionesRepository.consultarActivosNoEliminados();
        ArrayList<Transaccion> transacciones = Servicios.transaccionController.transaccionRepository.getListaTransacciones();

        if (consignaciones != null && transacciones != null) {
            respuesta = new ArrayList<>();
            ArrayList<Map<String, Object>> temporal = new ArrayList<>();

            if (consignaciones.size() > 0) {
                for (Consignacion consignacion : consignaciones) {
                    Map<String, Object> temp = new HashMap<>();

                    temp.put("fecha", consignacion.getFecha());
                    temp.put("numeroRecibo", consignacion.getNumeroRecibo());
                    temp.put("descripcion", consignacion.getConcepto());
                    temp.put("valor", consignacion.getValor());
                    temp.put("usuario", consignacion.getUsuario());
                    temp.put("fechaModificacion", consignacion.getModificacion());
                    temp.put("saldoDiarioActualGastado", consignacion.getInterno().getSaldoDiarioActualGastado());
                    temp.put("saldoDisponible", consignacion.getInterno().getSaldoDisponible());
                    temp.put("saldoMensualActualGastado", consignacion.getInterno().getSaldoMensualActualGastado());
                    temp.put("esIngreso", true);

                    temporal.add(temp);
                }
            }
            if (transacciones.size() > 0) {
                for (Transaccion transaccion : transacciones) {
                    for (TransaccionItem movimiento : transaccion.getListItem()) {
                        Map<String, Object> temp = new HashMap<>();

                        temp.put("fecha", transaccion.getFecha());
                        temp.put("numeroRecibo", transaccion.getNumero());
                        temp.put("descripcion", movimiento.getDescripcionItem());
                        temp.put("valor", (movimiento.getCantidad() * movimiento.getValorUnitario()));
                        temp.put("usuario", transaccion.getUsuario());
                        temp.put("fechaModificacion", transaccion.getModificacion());
                        temp.put("saldoDiarioActualGastado", transaccion.getInterno().getSaldoDiarioActualGastado());
                        temp.put("saldoDisponible", transaccion.getInterno().getSaldoDisponible());
                        temp.put("saldoMensualActualGastado", transaccion.getInterno().getSaldoMensualActualGastado());
                        temp.put("esIngreso", false);

                        temporal.add(temp);
                    }
                }
            }

            // Ordenar por fechas y luego por fechas de modificacion.
            Collections.sort(temporal, new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    Date fecha1 = (Date) o1.get("fecha");
                    Date fecha2 = (Date) o2.get("fecha");
                    Timestamp modificacion1 = (Timestamp) o1.get("fechaModificacion");
                    Timestamp modificacion2 = (Timestamp) o2.get("fechaModificacion");

                    int orden = -10;
                    if (fecha1 != null && fecha2 != null) {
                        orden = fecha1.compareTo(fecha2);

                        if (orden == 0) {
                            int orden2 = -10;

                            if (modificacion1 != null && modificacion2 != null) {
                                orden2 = modificacion1.compareTo(modificacion2);
                            } else if (modificacion1 == null && modificacion2 != null) {
                                orden2 = -1;
                            } else if (modificacion1 != null && modificacion2 == null) {
                                orden2 = 1;
                            } else if (modificacion1 == null && modificacion2 == null) {
                                orden2 = 0;
                            }

                            orden = orden2;
                        }
                    } else if (fecha1 == null && fecha2 != null) {
                        orden = -1;
                    } else if (fecha1 != null && fecha2 == null) {
                        orden = 1;
                    } else if (fecha1 == null && fecha2 == null) {
                        orden = 0;
                    }

                    return orden;
                }

            });

            // Mostrar fechas en el rango dado.
            Date fechaI = Fecha.getDate(fechaInicial);
            Date fechaF = Fecha.getDate(fechaFinal);

            for (Map<String, Object> fila : temporal) {
                Date fecha = (Date) fila.get("fecha");
                if (!fecha.before(fechaI) && !fecha.after(fechaF)) {
                    respuesta.add(fila);
                }
            }
        } else {
//            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeError, ExpendioException.getStackTrace(ex), "Error (187)", ExpendioException.getMensajeErrorBaseDatos());
            ClaseGeneral.option.tipoMensaje(GUIJOption.mensajeAdvertencia, "", "No se han encontrado consignaciones ni transacciones.", "");
            respuesta = null;
        }

        return respuesta;
    }

}
