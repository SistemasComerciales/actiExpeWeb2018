package activa.Expendio.persistencia;

import activa.Expendio.controllers.*;
import activa.Expendio.modelo.*;
import activa.Expendio.persistencia.Interface.*;
import java.sql.*;
import java.util.*;
import java.util.Date;
import org.springframework.stereotype.*;

/**
 *
 * @author Administrador
 */
@Service
public class PersistenciaConsignacion implements PersistenciaConsignacionInt {

    ArrayList<Consignacion> consignaciones;

    public PersistenciaConsignacion() {
        consignaciones = new ArrayList<>();
//        crearMock();
    }

    @Override
    public void crearMock() {
        Consignacion consignacion = new Consignacion();
        Interno interno = Servicios.internosController.internosRepository.getInternos().get(0);
        consignacion.setCajasEspeciales(0);
        consignacion.setConcepto(Concepto.CONCEPTOS[1]);
        consignacion.setEliminado(false);
        consignacion.setFecha(new Date(1520852565865L));
        consignacion.setId(1);
        consignacion.setNumeroRecibo("0000000001");
        consignacion.setNumeroTransaccion("0000000001");
        consignacion.setObservaciones("");
        consignacion.setValor(900000);
        interno.registrarIngreso(900000);
        consignacion.setInterno(interno);
        consignacion.setCreacion(new Timestamp(System.currentTimeMillis()));
        consignacion.setModificacion(new Timestamp(System.currentTimeMillis()));
        consignacion.setUsuario(null);
        consignaciones.add(consignacion);
    }

    @Override
    public ArrayList<Consignacion> getConsignaciones() {
        return consignaciones;
    }

    @Override
    public ArrayList<Consignacion> getConsignacionesInterno(Interno interno) {
        ArrayList<Consignacion> arreglo = new ArrayList<>();
        for (int i = 0; i < consignaciones.size(); i++) {
            if (Objects.equals(consignaciones.get(i).getInterno().getId(), interno.getId())) {
                arreglo.add(consignaciones.get(i));
            }
        }
        return arreglo;
    }

    @Override
    public Consignacion adicionar(Consignacion consignacion) {
        consignaciones.add(consignacion);
        return consignacion;
    }

    @Override
    public Consignacion modificar(Consignacion consignacion) {
        for (int i = 0; i < consignaciones.size(); i++) {
            if (consignaciones.get(i).getId() == consignacion.getId()) {
                consignaciones.set(i, consignacion);
            }
        }
        return consignacion;
    }

    @Override
    public Consignacion eliminar(Consignacion consignacion) {
        consignacion.setEliminado(true);
        for (int i = 0; i < consignaciones.size(); i++) {
            if (consignaciones.get(i).getId() == consignacion.getId()) {
                consignaciones.set(i, consignacion);
            }
        }
        return consignacion;
    }

    @Override
    public ArrayList<Consignacion> consultarActivosNoEliminados() {
        ArrayList<Consignacion> arreglo = new ArrayList<>();
        for (int i = 0; i < consignaciones.size(); i++) {
            if (!consignaciones.get(i).isEliminado()) {
                arreglo.add(consignaciones.get(i));
            }
        }
        return arreglo;
    }

    @Override
    public Consignacion consultarPorId(int id) {
        for (int i = 0; i < consignaciones.size(); i++) {
            if (consignaciones.get(i).getId() == id) {
                return consignaciones.get(i);
            }
        }
        return null;
    }

    @Override
    public Consignacion consultarPorNumero(String numero) {
        for (int i = 0; i < consignaciones.size(); i++) {
            if (consignaciones.get(i).getNumeroRecibo().trim().equals(numero)) {
                return consignaciones.get(i);
            }
        }
        return null;
    }

    @Override
    public ArrayList<Consignacion> consultarPorFecha(Date fecha) {
        ArrayList<Consignacion> arreglo = new ArrayList<>();
        for (int i = 0; i < consignaciones.size(); i++) {
            if (consignaciones.get(i).getFecha() == fecha) {
                arreglo.add(consignaciones.get(i));
            }
        }
        return arreglo;
    }

    @Override
    public String traerSiguienteNumeroTransaccion() {
        if (consignaciones.isEmpty()) {
            return "0000000001";
        } else {
            String ultimoNumero = consignaciones.get(consignaciones.size() - 1).getNumeroTransaccion();
            String ceros;
//            String numeros;
            int longitudCeros = 0;
            for (int i = 0; i < ultimoNumero.length(); i++) {
                if (!ultimoNumero.substring(i, i + 1).equals("0")) {
                    longitudCeros = i;
                    break;
                }
            }
            ceros = ultimoNumero.substring(0, longitudCeros);
//            numeros = ultimoNumero.substring(longitudCeros,ultimoNumero.length()-1);

            System.out.println("ceros: " + ceros);

            long numero = Long.valueOf(ultimoNumero);
            System.out.println("numero: " + numero);
            numero++;
            return ceros + numero;
        }

    }

    @Override
    public long traerSiguienteId() {
        return consignaciones.size() + 1;
    }

}
