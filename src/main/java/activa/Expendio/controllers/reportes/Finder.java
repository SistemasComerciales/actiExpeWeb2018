package activa.Expendio.controllers.reportes;

import activa.Expendio.modelo.*;
import java.io.*;
import java.sql.*;
import utils.*;

public abstract class Finder implements Serializable {

    private static final long serialVersionUID = 3855023591447838809L;

    protected Usuario usuario;
//    protected Persistencia persistencia;
//    protected ResultSet resultado;
    protected Fecha fecha;

    public Finder(Usuario usuario) {
        this.usuario = usuario;
//        this.persistencia = new Persistencia(usuario);
        this.fecha = new Fecha();
    }

//    public final Persistencia getPersistencia() {
//        return persistencia;
//    }
//    public final void conectarBD() throws Exception {
//        try {
//            persistencia.conectar();
//        } catch (Exception ex) {
//            Log.adicionar(ex, "187", usuario, TesoreriaException.getMensajeErrorBaseDatos());
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//
//    protected final void consultar(String sql) throws Exception {
//        try {
////			System.out.println(sql);
//            resultado = persistencia.consultar(sql);
//        } catch (Exception ex) {
//            Log.adicionar(ex, "187", usuario, TesoreriaException.getMensajeErrorBaseDatos());
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//
//    public final void desconectar() throws Exception {
//        try {
//            resultado.close();
//            desconectarBD();
//        } catch (Exception ex) {
//            Log.adicionar(ex, "187", usuario, TesoreriaException.getMensajeErrorBaseDatos());
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//
//    public final void desconectarBD() throws Exception {
//        try {
//            persistencia.desconectar();
//        } catch (Exception ex) {
//            Log.adicionar(ex, "187", usuario, TesoreriaException.getMensajeErrorBaseDatos());
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//
//    protected final void executeQuery(String sql) throws Exception {
//        try {
//            conectarBD();
//            consultar(sql);
//        } catch (Exception ex) {
//            Log.adicionarCS(ex, "187", usuario, sql, TesoreriaException.getMensajeErrorBaseDatos());
//            throw ex;
//        }
//    }
}
