/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import utilidades.TipoTramite;

/**
 * Clase que representa un trámite de vehículo.
 */
@Entity
@Table(name = "Tramites")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "tipoTramite", discriminatorType = DiscriminatorType.STRING)
public class Tramite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "estado", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado estado;

    @Column(name = "Costo", nullable = false)
    private float costo;

    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;

    @Column(name = "vigencia", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar vigencia;

    @ManyToOne
    @JoinColumn(name = "rfc", nullable = false)
    private Persona persona;

    @Column(name = "tipoTramite")
    @Enumerated(value = EnumType.STRING)
    private TipoTramite tipoTramite;

    /**
     * Constructor por defecto de la clase.
     */
    public Tramite() {
    }

    /**
     * Constructor con todos los atributos de la clase.
     *
     * @param id Identificador del trámite.
     * @param estado Estado actual del trámite.
     * @param costo Costo del trámite.
     * @param fechaExpedicion Fecha de expedición del trámite.
     * @param vigencia Fecha de vigencia del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Tramite(Long id, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        this.id = id;
        this.estado = estado;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.vigencia = vigencia;
        this.persona = persona;
    }

    /**
     * Constructor con los atributos necesarios para crear un trámite, sin
     * incluir el identificador.
     *
     * @param estado Estado actual del trámite.
     * @param costo Costo del trámite.
     * @param fechaExpedicion Fecha de expedición del trámite.
     * @param vigencia Fecha de vigencia del trámite.
     * @param persona Persona asociada al trámite.
     */
    public Tramite(Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        this.estado = estado;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.vigencia = vigencia;
        this.persona = persona;
    }

    /**
     * Método que devuelve el identificador del trámite.
     *
     * @return Identificador del trámite.
     */
    public Long getId() {
        return id;
    }

    /**
     * Método que establece el identificador del trámite.
     *
     * @param id Identificador del trámite.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Método que devuelve el estado actual del trámite.
     *
     * @return Estado actual del trámite.
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Método que establece el estado actual del trámite.
     *
     * @param estado Estado actual del trámite.
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * Método que devuelve el costo del trámite.
     *
     * @return Costo del trámite.
     */
    public float getCosto() {
        return costo;
    }

    /**
     * Metodo que establece el costo del tramite
     *
     * @param costo del tramite
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }

    /**
     * Metodo que devuelve la fecha de expedicion del tramite
     *
     * @return fecha de expedicion del tramite
     */
    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    /**
     * Metodo que establece la fecha de expedicion del tramite
     *
     * @param fechaExpedicion del tramite
     */
    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    /**
     * Metodo que devuelve la fecha de vigencia del tramite
     *
     * @return fecha de vigencia del tramite
     */
    public Calendar getVigencia() {
        return vigencia;
    }

    /**
     * Metodo que establece la vigencia del tramite
     *
     * @param vigencia fecha de vigencia del tramite
     */
    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Metodo que devuelve la persona a la que pertenece el tramite
     *
     * @return persona a la que pertence el tramite
     */
    public Persona getPersona() {
        return persona;
    }

    /**
     * Metodo que estable a la persona que pertence el tramite
     *
     * @param persona a la que pertenece el tramite
     */
    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    /**
     * Metodo que devuelve el tipo de tramite que se realiza
     *
     * @return tipo de tramite que se realizo
     */
    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    /**
     * Metodo que establece el tipo de tramite que se realizo
     *
     * @param tipoTramite tipo de tramite que se realizo
     */
    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     * Devuelve un código hash para el objeto actual basado en el valor de su
     * atributo `id`.
     *
     * @return Código hash del objeto actual.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    /**
     * Compara el objeto actual con otro objeto `obj` y devuelve `true` si ambos
     * objetos son iguales.
     *
     * @param obj Objeto a comparar con el objeto actual.
     * @return true si el objeto actual y el objeto `obj` son iguales, false en
     * otro caso.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tramite)) {
            return false;
        }
        Tramite other = (Tramite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto actual.
     *
     * @return Representación en forma de cadena del objeto actual.
     */
    @Override
    public String toString() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return "id= " + id + ", estado= " + estado + ", costo= " + costo + ", fechaExpedicion= " + formateador.format(fechaExpedicion.getTime()) + ", vigencia= " + formateador.format(vigencia.getTime()) + ",tipo tramite= " + tipoTramite + " ";
    }

}
