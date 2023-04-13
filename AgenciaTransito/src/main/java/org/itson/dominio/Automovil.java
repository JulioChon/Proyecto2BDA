/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * La clase Automovil es una subclase de Vehiculo y representa a un automóvil en
 * el sistema.
 *
 * @author julio
 */
@Entity
public class Automovil extends Vehiculo implements Serializable {

    /**
     *
     * Constructor por defecto de la clase Automovil.
     */
    public Automovil() {
    }

    /**
     *
     * Constructor de la clase Automovil que recibe los atributos como
     * parámetros.
     *
     * @param numeroSerie el número de serie del automóvil.
     * @param color el color del automóvil.
     * @param linea la línea del automóvil.
     * @param marca la marca del automóvil.
     * @param modelo el modelo del automóvil.
     * @param listaPlacas la lista de placas asociadas al automóvil.
     */
    public Automovil(String numeroSerie, String color, String linea, String marca, String modelo, List<Placa> listaPlacas) {
        super(numeroSerie, color, linea, marca, modelo, listaPlacas);
    }

    /**
     *
     * Constructor de la clase Automovil que recibe los atributos como
     * parámetros.
     *
     * @param numeroSerie el número de serie del automóvil.
     * @param color el color del automóvil.
     * @param linea la línea del automóvil.
     * @param marca la marca del automóvil.
     * @param modelo el modelo del automóvil.
     */
    public Automovil(String numeroSerie, String color, String linea, String marca, String modelo) {
        super(numeroSerie, color, linea, marca, modelo);
    }
     

}
