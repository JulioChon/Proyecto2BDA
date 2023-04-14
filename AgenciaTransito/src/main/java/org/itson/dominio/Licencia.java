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
 * Esta clase representa el trámite de Licencia en el sistema. Es una subclase
 * de la clase abstracta Tramite.
 *
 * @author Julio Chon, Luis Ayon
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_Licencia")
@Table(name = "Licencias")
@DiscriminatorValue("Licencia")
public class Licencia extends Tramite implements Serializable {

    /**
     *
     * El tipo de licencia requerido para el trámite.
     */
    @Column(name = "tipoCosto", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoLicencia tipoCosto;

    /**
     * Crea una instancia vacía de la clase Licencia.
     */
    public Licencia() {
    }

    /**
     * Crea una instancia de la clase Licencia con los valores especificados.
     * @param tipoCosto el tipo de licencia requerido para el trámite.
     * @param estado el estado actual del trámite.
     * @param costo el costo total del trámite.
     * @param fechaExpedicion la fecha de expedición del trámite.
     * @param vigencia la fecha de vencimiento del trámite.
     * @param persona la persona que realiza el trámite.
     */
    public Licencia(TipoLicencia tipoCosto, Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        super(estado, costo, fechaExpedicion, vigencia, persona);
        this.tipoCosto = tipoCosto;
    }

    /**
     * Obtiene el tipo de licencia requerido para el trámite.
     * @return el tipo de licencia requerido para el trámite.
     */
    public TipoLicencia getTipoCosto() {
        return tipoCosto;
    }

    /**
     * Establece el tipo de licencia requerido para el trámite.
     * @param tipoCosto el tipo de licencia requerido para el trámite.
     */
    public void setTipoCosto(TipoLicencia tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    /**
     * Devuelve una cadena que representa la información del objeto Licencia.
     * @return una cadena que representa la información del objeto Licencia.
     */
    @Override
    public String toString() {
        return super.toString() + "tipoCosto=" + tipoCosto;
    }
}
