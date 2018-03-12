package activa.Expendio.vista;

import activa.Expendio.controllers.Servicios;
import activa.Expendio.modelo.*;
import java.util.Date;
import utils.CargaImagenes;

/**
 *
 * @author Avuuna la Luz del Alba
 */
public class GUIConsignacionesRegistrar extends GUIConsignacionesInterfaz {

    public GUIConsignacionesRegistrar(Usuario usuario) {
        super(usuario);
        super.GUIConsignacionesInterfaz(usuario, "Registro "+nombreClase.toUpperCase());
    }

    @Override
    public void actualizarFrame() {
        txt_numeroTransaccion.setText("");
        txt_fecha.setText("");

        txt_td.setText("");
        txt_nombre.setText("");
        txt_saldoActual.setText("");
        txt_estado.setText("");
        lbl_imagenFoto.setIcon(null);

        combo_concepto.setSelectedIndex(-1);
        txt_numeroRecibo.setText("");
        txt_valor.setText("");
        txt_cajasEspeciales.setText("");
        txt_observaciones.setText("");

        btn_otro.setEnabled(false);
        btn_reporte.setEnabled(false);

        consignacion = new Consignacion();
        consignacion.setNumeroTransaccion(Servicios.consignacionesController.consignacionesRepository.traerSiguienteNumeroTransaccion());
        consignacion.setFecha(new Date());
        cargarTerceros();
        asignarAplicacionesAPresentacion();
//        super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "Consultar "+nombreClase.toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
    
        }


}
