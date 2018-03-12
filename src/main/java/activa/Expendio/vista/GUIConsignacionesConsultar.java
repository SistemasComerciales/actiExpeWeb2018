package activa.Expendio.vista;

import activa.Expendio.modelo.*;

/**
 *
 * @author Administrador
 */
public class GUIConsignacionesConsultar extends GUIConsignacionesInterfaz {

    public GUIConsignacionesConsultar(Usuario usuario, Consignacion consignacion) {
        super(usuario);

//     super.tituloFrame(0, CargaImagenes.ALTO_PANTALLA / 100 * 2, "Consulta " +nombreClase.toUpperCase(), CargaImagenes.ANCHO_PANTALLA, 50);
        super.GUIConsignacionesInterfaz(usuario, "Consultar " + nombreClase.toUpperCase());
        this.consignacion = consignacion;
        asignarAplicacionesAPresentacion();
        ocultarPanelAuxiliar();
        deshabilitarCamposConsultar();
    }

    @Override
    public void actualizarFrame() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void ocultarPanelAuxiliar() {
        tablaInternos.setVisible(false);
    }

}
