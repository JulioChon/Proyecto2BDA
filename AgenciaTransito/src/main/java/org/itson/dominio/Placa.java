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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.*;

/**
 *
 * @author Julio Chon, Luis Ayon
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_placa")
@Table(name = "Placas")
@DiscriminatorValue("Placa")
public class Placa extends Tramite implements Serializable {

    @Column(name = "serie", nullable = false, length = 20)
    private String serie;

    @Column(name = "fecha_entrega", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaEntrega;

    @Column(name = "tipoPlaca", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoPlaca tipoPlaca;

    @ManyToOne
    @JoinColumn(name = "numeroSerie", nullable = false)
    private Vehiculo vehiculo;

    /**
     *
     * Constructor vacio de la clase Placa.
     */
    public Placa() {
    }

    /**
     *
     * Constructor de la clase Placa que recibe los atributos propios de un
     * Tramite de Placa y los heredados de la clase abstracta Tramite.
     *
     * @param serie String que representa la serie de la placa.
     * @param fechaEntrega Calendar que representa la fecha de entrega de la
     * placa.
     * @param tipoPlaca TipoPlaca que representa el tipo de placa.
     * @param vehiculo Vehiculo al que se asigna la placa.
     * @param estado Estado en que se encuentra el tramite.
     * @param costo Float que representa el costo del tramite.
     * @param fechaExpedicion Calendar que representa la fecha de expedicion del
     * tramite.
     * @param vigencia Calendar que representa la fecha de vigencia del tramite.
     * @param persona Persona que realiza el tramite.
     */
    public Placa(String serie, Calendar fechaEntrega, TipoPlaca tipoPlaca, Vehiculo vehiculo, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        super(estado, costo, fechaExpedicion, vigencia, persona);
        this.serie = serie;
        this.fechaEntrega = fechaEntrega;
        this.tipoPlaca = tipoPlaca;
        this.vehiculo = vehiculo;
    }

    /**
     *
     * Constructor de la clase Placa que recibe los atributos propios de un
     * Tramite de Placa y los heredados de la clase abstracta Tramite. Este
     * constructor no recibe la serie de la placa.
     *
     * @param fechaEntrega Calendar que representa la fecha de entrega de la
     * placa.
     * @param tipoPlaca TipoPlaca que representa el tipo de placa.
     * @param estado Estado en que se encuentra el tramite.
     * @param costo Float que representa el costo del tramite.
     * @param fechaExpedicion Calendar que representa la fecha de expedicion del
     * tramite.
     * @param vigencia Calendar que representa la fecha de vigencia del tramite.
     * @param persona Persona que realiza el tramite.
     * @param vehiculo Vehiculo al que se asigna la placa.
     */
    public Placa(Calendar fechaEntrega, TipoPlaca tipoPlaca, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona, Vehiculo vehiculo) {
        super(estado, costo, fechaExpedicion, vigencia, persona);
        this.fechaEntrega = fechaEntrega;
        this.tipoPlaca = tipoPlaca;
        this.vehiculo = vehiculo;
    }

    /**
     * Obtiene el numero de serie de la placa
     *
     * @return el numero de serie de la placa
     */
    public String getSerie() {
        return serie;
    }

    /**
     * Establece el numero de serie de la placa
     *
     * @param serie el numero de serie de la placa
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * Obtiene la fecha de entrega de la placa
     *
     * @return fecha de entrega de la placa
     */
    public Calendar getFechaEntrega() {
        return fechaEntrega;
    }

    /**
     * Establece la fecha de entrega de la placa
     *
     * @param fechaEntrega fecha de entrega de la placa
     */
    public void setFechaEntrega(Calendar fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    /**
     * Obtiene el tipo de placa
     *
     * @return tipo de placa
     */
    public TipoPlaca getTipoPlaca() {
        return tipoPlaca;
    }

    /**
     * Establece el tipo de placa
     *
     * @param tipoPlaca tipo de placa
     */
    public void setTipoPlaca(TipoPlaca tipoPlaca) {
        this.tipoPlaca = tipoPlaca;
    }

    /**
     * Obtiene el vehiculo al que pertenece la placa
     *
     * @return vehiculo al que pertence la placa
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Establece el vehiculo al que pertenece la placa
     *
     * @param vehiculo al que pertenece la placa
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto actual.
     *
     * @return Representación en forma de cadena del objeto actual.
     */
    @Override
    public String toString() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return super.toString() + "serie=" + serie + ", fechaEntrega=" + formateador.format(fechaEntrega.getTime()) + ", tipoPlaca=" + tipoPlaca;
    }

}
