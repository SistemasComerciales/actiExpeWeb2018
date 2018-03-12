package activa.Expendio.controllers.reportes;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import java.sql.Timestamp;
import java.util.*;

import utils.*;

public class ReportesFinder extends Finder {

    private static final long serialVersionUID = -7426959825313696983L;

    public ReportesFinder(Usuario usuario) {
        super(usuario);
    }

    public ArrayList<Map<String, Object>> traerMovimientosInterno(Long idInterno,
            String fechaInicial, String fechaFinal) {
        // Movimientos del interno

        ArrayList<Map<String, Object>> respuesta = null;

        ArrayList<Consignacion> consignaciones = Servicios.consignacionesController.consignacionesRepository.consultarActivosNoEliminados();
        ArrayList<Transaccion> transacciones = Servicios.transaccionController.transaccionRepository.getListaTransacciones();

        if (consignaciones != null && transacciones != null) {
            respuesta = new ArrayList<>();

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

                    respuesta.add(temp);
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

                        respuesta.add(temp);
                    }
                }
            }

            // Ordenar por fechas y luego por fechas de modificacion.
            Collections.sort(respuesta, new Comparator<Map<String, Object>>() {
                @Override
                public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                    Date fecha1 = (Date) o1.get("fecha");
                    Date fecha2 = (Date) o2.get("fecha");
                    Timestamp modificacion1 = (Timestamp) o1.get("fechaModificacion");
                    Timestamp modificacion2 = (Timestamp) o2.get("fechaModificacion");
                    return -1;
                }

            });
        }

        return respuesta;
    }

}
