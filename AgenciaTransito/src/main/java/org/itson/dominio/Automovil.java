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
 *
 * @author julio
 */
@Entity
public class Automovil extends Vehiculo implements Serializable {

    public Automovil() {
    }

    public Automovil(String numeroSerie, String color, String linea, String marca, String modelo, List<Placa> listaPlacas) {
        super(numeroSerie, color, linea, marca, modelo, listaPlacas);
    }

    public Automovil(String numeroSerie, String color, String linea, String marca, String modelo) {
        super(numeroSerie, color, linea, marca, modelo);
    }
    

    
    
}
