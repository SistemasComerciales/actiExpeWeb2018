/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

/**
 *
 * @author Administrador
 */
public class EstadoInterno {
    
    private long saldoDiarioDisponible;
    private long saldoMensualDisponible;
    private String td;
    private boolean estadoInterno;

    
    public EstadoInterno(long saldoDiarioDisponible, long saldoMensualDisponible, String td, boolean estadoInterno){
        this.saldoDiarioDisponible = saldoDiarioDisponible;
        this.saldoMensualDisponible = saldoMensualDisponible;
        this.td = td;
        this.estadoInterno = estadoInterno;
    }
    
    /**
     * @return the saldoDiarioDisponible
     */
    public long getSaldoDiarioDisponible() {
        return saldoDiarioDisponible;
    }

    /**
     * @param saldoDiarioDisponible the saldoDiarioDisponible to set
     */
    public void setSaldoDiarioDisponible(int saldoDiarioDisponible) {
        this.saldoDiarioDisponible = saldoDiarioDisponible;
    }

    /**
     * @return the saldoMensualDisponible
     */
    public long getSaldoMensualDisponible() {
        return saldoMensualDisponible;
    }

    /**
     * @param saldoMensualDisponible the saldoMensualDisponible to set
     */
    public void setsaldoMensualDisponible(int saldoMensualDisponible) {
        this.saldoMensualDisponible = saldoMensualDisponible;
    }

    /**
     * @return the td
     */
    public String getTd() {
        return td;
    }

    /**
     * @param td the td to set
     */
    public void setTd(String td) {
        this.td = td;
    }

    /**
     * @return the estadoInterno
     */
    public boolean isEstadoInterno() {
        return estadoInterno;
    }

    /**
     * @param estadoInterno the estadoInterno to set
     */
    public void setEstadoInterno(boolean estadoInterno) {
        this.estadoInterno = estadoInterno;
    }
    
    
    
    
}
