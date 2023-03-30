/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author julio
 */
@Entity
@Table(name= "Tramites")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Tramite implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    
    @Column(name = "estado",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Estado estado;
    
    @Column(name = "Costo",nullable = false)
    private float costo;
    
    @Column(name = "fecha_expedicion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaExpedicion;
    
    
    @Column(name = "vigencia",nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar vigencia;
    
    @ManyToOne
    @JoinColumn(name = "rfc",nullable = false)
    private Persona persona;

    public Tramite() {
    }

    public Tramite(Long id, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        this.id = id;
        this.estado = estado;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.vigencia = vigencia;
        this.persona = persona;
    }

    public Tramite(Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        this.estado = estado;
        this.costo = costo;
        this.fechaExpedicion = fechaExpedicion;
        this.vigencia = vigencia;
        this.persona = persona;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Calendar getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Calendar fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Calendar getVigencia() {
        return vigencia;
    }

    public void setVigencia(Calendar vigencia) {
        this.vigencia = vigencia;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

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

    @Override
    public String toString() {
        return "org.itson.dominio.Tramite[ id=" + id + " ]";
    }
    
}
