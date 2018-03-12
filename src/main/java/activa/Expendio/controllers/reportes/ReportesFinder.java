package activa.Expendio.controllers.reportes;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
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
                    
                    temp.put("Fecha", consignacion.getFecha());
                    temp.put("numeroRecibo", consignacion.getNumeroRecibo());
//                    temp.put("", consignacion.getConcepto());
//                    temp.put("", );
//                    temp.put("", );
//                    temp.put("", );
//                    temp.put("", );
//                    temp.put("", );
//                    temp.put("", );
//                    temp.put("", );
                    
                    respuesta.add(temp);
                }
            }
            if (transacciones.size() > 0) {
                //
            }
        }

        return respuesta;
    }

}
