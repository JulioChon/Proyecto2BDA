/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilidades;

/**
 *
 * @author Zaurus
 */
public class ReporteDTO {
    private String tramite;
    private String estado;
    private String fechaExpedicion;
    private String solicitante;
    private String vigencia;
    private String costo;
    
    /**
     * Este es el constructor de la clase ReporteDTO. Toma seis parámetros de
     * tipo String que representan las diferentes propiedades de un informe,
     * como el tipo de trámite, el estado, la fecha de expedición, el
     * solicitante, la vigencia y el costo. Este constructor se utiliza para
     * inicializar una instancia de la clase ReporteDTO con los valores
     * proporcionados.
     * @param tramite parametro tramite que sera inicializado
     * @param estado parametro estado que sera inicializado
     * @param fechaExpidicion parametro fechaExpedicion que sera inicializado
     * @param solicitante parametro solicitante que sera inicializado
     * @param vigencia parametro vigencia que sera inicializado
     * @param costo parametro costo que sera inicializado
     */
    public ReporteDTO(String tramite, String estado, String fechaExpidicion, String solicitante, String vigencia, String costo) {
        this.tramite = tramite;
        this.estado = estado;
        this.fechaExpedicion = fechaExpidicion;
        this.solicitante = solicitante;
        this.vigencia = vigencia;
        this.costo = costo;
    }
    /**
     * Este método es un getter que devuelve el valor de la variable miembro
     * privada tramite.
     * @return tramite
     */
    public String getTramite() {
        return tramite;
    }
    /**
     * Este método es un setter que establece el valor de la variable miembro
     * privada tramite. Toma un parámetro de tipo String que representa el nuevo
     * valor del tipo de trámite.
     * @param tramite parametro que se seteara.
     */
    public void setTramite(String tramite) {
        this.tramite = tramite;
    }
    /**
     * Este método es un getter que devuelve el valor de la variable miembro
     * privada estado.
     * @return estado
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Este método es un setter que establece el valor de la variable miembro
     * privada estado. Toma un parámetro de tipo String que representa el nuevo
     * valor del estado.
     * @param estado parametro que se seteara.
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }
    /**
     * Este método es un getter que devuelve el valor de la variable miembro privada fechaExpedicion.
     * @return fechaExpedicion.
     */
    public String getFechaExpedicion() {
        return fechaExpedicion;
    }
    /**
     * Este método es un setter que establece el valor de la variable miembro
     * privada fechaExpedicion. Toma un parámetro de tipo String que representa
     * el nuevo valor de la fecha de expedición.
     * @param fechaExpedicion el nuevo valor de la fecha de expedición
     */
    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }
    /**
     * Este método es un getter que devuelve el valor de la variable miembro
     * privada solicitante.
     * @return solicitante.
     */
    public String getSolicitante() {
        return solicitante;
    }
    /**
     * Este método es un setter que establece el valor de la variable miembro
     * privada solicitante. Toma un parámetro de tipo String que representa el
     * nuevo valor del solicitante.
     * @param solicitante parametro que se seteara.
     */
    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }
    /**
     * Este método es un getter que devuelve el valor de la variable miembro
     * privada vigencia.
     * @return vigencia.
     */
    public String getVigencia() {
        return vigencia;
    }
    /**
     * Este método es un setter que establece el valor de la variable miembro
     * privada vigencia. Toma un parámetro de tipo String que representa el
     * nuevo valor de la vigencia.
     * @param vigencia parametro que se seteara.
     */
    public void setVigencia(String vigencia) {
        this.vigencia = vigencia;
    }
    /**
     * Este método es un getter que devuelve el valor de la variable miembro privada costo.
     * @return costo.
     */
    public String getCosto() {
        return costo;
    }
    /**
     * Este método es un setter que establece el valor de la variable miembro
     * privada costo. Toma un parámetro de tipo String que representa el nuevo
     * valor del costo.
     * @param costo parametro que se seteara.
     */
    public void setCosto(String costo) {
        this.costo = costo;
    }
   
}
