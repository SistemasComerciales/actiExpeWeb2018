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
public class ConfirmacionRecarga {
    private String numeroRecibo;
    private String expendioAsignado;
    private int status;
    private String mensaje;

    /**
     * @return the numeroRecibo
     */
    public String getNumeroRecibo() {
        return numeroRecibo;
    }

    /**
     * @param numeroRecibo the numeroRecibo to set
     */
    public void setNumeroRecibo(String numeroRecibo) {
        this.numeroRecibo = numeroRecibo;
    }

    /**
     * @return the expendioAsignado
     */
    public String getExpendioAsignado() {
        return expendioAsignado;
    }

    /**
     * @param expendioAsignado the expendioAsignado to set
     */
    public void setExpendioAsignado(String expendioAsignado) {
        this.expendioAsignado = expendioAsignado;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
