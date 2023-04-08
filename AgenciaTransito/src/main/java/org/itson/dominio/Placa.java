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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.*;

/**
 *
 * @author julio
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_placa")
@Table(name = "Placas")
public class Placa extends Tramite implements Serializable {

    
    @Column(name = "serie",nullable = false,length = 20)
    private String serie;
    
    @Column(name = "fecha_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEntrega;
    
    
    @Column(name = "tipoPlaca",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoPlaca tipoPlaca;
    
    @ManyToOne
    @JoinColumn(name = "numeroSerie",nullable = false)
    private Vehiculo vehiculo;

    public Placa() {
    }

    public Placa(String serie, Calendar fechaEntrega, TipoPlaca tipoPlaca, Vehiculo vehiculo, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        super(estado, costo, fechaExpedicion, vigencia, persona);
        this.serie = serie;
        this.fechaEntrega = fechaEntrega;
        this.tipoPlaca = tipoPlaca;
        this.vehiculo = vehiculo;
    }

    public Placa(Calendar fechaEntrega, TipoPlaca tipoPlaca, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona, Vehiculo vehiculo) {
        super(estado, costo, fechaExpedicion, vigencia, persona);
        this.fechaEntrega = fechaEntrega;
        this.tipoPlaca = tipoPlaca;
        this.vehiculo = vehiculo;
    }
    

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Calendar getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public TipoPlaca getTipoPlaca() {
        return tipoPlaca;
    }

    public void setTipoPlaca(TipoPlaca tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Placa{" + "serie=" + serie + ", fechaEntrega=" + fechaEntrega + ", tipoPlaca=" + tipoPlaca + ", vehiculo=" + vehiculo + '}';
    }
    
    
    
}
