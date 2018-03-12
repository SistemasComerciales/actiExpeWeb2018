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

    private double saldoDiarioDisponible;
    private double saldoMensualDisponible;
    private String td;
    private boolean estadoInterno;

    public EstadoInterno(double saldoDiarioDisponible, double saldoMensualDisponible, String td, boolean estadoInterno) {
        this.saldoDiarioDisponible = saldoDiarioDisponible;
        this.saldoMensualDisponible = saldoMensualDisponible;
        this.td = td;
        this.estadoInterno = estadoInterno;
    }

    /**
     * @return the saldoDiarioDisponible
     */
    public double getSaldoDiarioDisponible() {
        return saldoDiarioDisponible;
    }

    /**
     * @param saldoDiarioDisponible the saldoDiarioDisponible to set
     */
    public void setSaldoDiarioDisponible(double saldoDiarioDisponible) {
        this.saldoDiarioDisponible = saldoDiarioDisponible;
    }

    /**
     * @return the saldoMensualDisponible
     */
    public double getSaldoMensualDisponible() {
        return saldoMensualDisponible;
    }

    /**
     * @param saldoMensualDisponible the saldoMensualDisponible to set
     */
    public void setsaldoMensualDisponible(double saldoMensualDisponible) {
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
