/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activa.Expendio.modelo;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Interno {

    private Long id;
    private String td;
    private String primerApellido;
    private String segundoApellido;
    private String primerNombre;
    private String segundoNombre;
    private String nui;
    private String nacionalidad;
    private String situacionJuridica;
    private Date fechaIngreso;
    private Date fechaSalida;
    private String delito;
    private String observaciones;
    private Boolean estado;
    private Usuario usuario;
    private String accionUsuario;
    private boolean eliminado;
    private Timestamp creacion;
    private Timestamp modificacion;
    private String rutaImagen;

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
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the segundoApellido
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * @param segundoApellido the segundoApellido to set
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * @return the primerNombre
     */
    public String getPrimerNombre() {
        return primerNombre;
    }

    /**
     * @param primerNombre the primerNombre to set
     */
    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    /**
     * @return the segundoNombre
     */
    public String getSegundoNombre() {
        return segundoNombre;
    }

    /**
     * @param segundoNombre the segundoNombre to set
     */
    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    /**
     * @return the nui
     */
    public String getNui() {
        return nui;
    }

    /**
     * @param nui the nui to set
     */
    public void setNui(String nui) {
        this.nui = nui;
    }

    /**
     * @return the nacionalidad
     */
    public String getNacionalidad() {
        return nacionalidad;
    }

    /**
     * @param nacionalidad the nacionalidad to set
     */
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    /**
     * @return the situacionJuridica
     */
    public String getSituacionJuridica() {
        return situacionJuridica;
    }

    /**
     * @param situacionJuridica the situacionJuridica to set
     */
    public void setSituacionJuridica(String situacionJuridica) {
        this.situacionJuridica = situacionJuridica;
    }

    /**
     * @return the fechaIngreso
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * @param fechaIngreso the fechaIngreso to set
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * @return the fechaSalida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * @return the delito
     */
    public String getDelito() {
        return delito;
    }

    /**
     * @param delito the delito to set
     */
    public void setDelito(String delito) {
        this.delito = delito;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the eliminado
     */
    public boolean getEliminado() {
        return eliminado;
    }

    /**
     * @param eliminado the eliminado to set
     */
    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    /**
     * @return the creacion
     */
    public Timestamp getCreacion() {
        return creacion;
    }

    /**
     * @param creacion the creacion to set
     */
    public void setCreacion(Timestamp creacion) {
        this.creacion = creacion;
    }

    /**
     * @return the modificacion
     */
    public Timestamp getModificacion() {
        return modificacion;
    }

    /**
     * @param modificacion the modificacion to set
     */
    public void setModificacion(Timestamp modificacion) {
        this.modificacion = modificacion;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public void desactivar() {
        estado = false;
    }

    public boolean estaActivo() {
        return estado;
    }

    public void eliminar() {
        estado = false;
    }

    public boolean estaEliminado() {
        return estado;
    }

    /**
     * @return the rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getAccionUsuario() {
        return accionUsuario;
    }

    public void setAccionUsuario(String accionUsuario) {
        this.accionUsuario = accionUsuario;
    }

    public String validarCamposObligatorios(boolean esModificar) {
        if (td == null || (td != null && td.trim().isEmpty())) {
            return "TD";
        }
        if (nui == null || (nui != null && nui.trim().isEmpty())) {
            return "NUI";
        }
        if (primerApellido == null || (primerApellido != null && primerApellido.trim().isEmpty())) {
            return "PRIMERAPELLIDO";
        }
        if (segundoApellido == null || (segundoApellido != null && segundoApellido.trim().isEmpty())) {
            return "SEGUNDOAPELLIDO";
        }
        if (primerNombre == null || (primerNombre != null && primerNombre.trim().isEmpty())) {
            return "PRIMERNOMBRE";
        }
        if (segundoNombre == null || (segundoNombre != null && segundoNombre.trim().isEmpty())) {
            return "SEGUNDONOMBRE";
        }
        if (nacionalidad == null || (nacionalidad != null && nacionalidad.trim().isEmpty())) {
            return "NACIONALIDAD";
        }
        if (situacionJuridica == null || (situacionJuridica != null && situacionJuridica.trim().isEmpty())) {
            return "SITUACIONJURIDICA";
        }
        if (fechaIngreso == null) {
            return "FECHAINGRESO";
        }
//        if (fechaSalida == null) {
//            return "FECHASALIDA";
//        }
//        if (delito == null || (delito != null && delito.trim().isEmpty())) {
//            return "DELITO";
//        }
//        if (observaciones == null || (observaciones != null && observaciones.trim().isEmpty())) {
//            return "OBSERVACIONES";
//        }
        if (rutaImagen == null || (rutaImagen != null && rutaImagen.trim().isEmpty())) {
            return "RUTAFOTO";
        }
        if (estado == null) {
            return "ESTADO";
        }
        if (esModificar && id == null) {
            return "ID";
        }
        return null;
    }

}
