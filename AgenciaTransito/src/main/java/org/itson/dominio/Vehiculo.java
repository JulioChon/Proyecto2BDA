/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.*;

/**
 *
 * @author julio
 */
@Entity
@Table(name= "Vehiculos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehiculo implements Serializable {


    @Id
    @Column(name = "numeroSerie",nullable = false)
    private String numeroSerie;
    
    @Column(name = "color",nullable = false,length = 20)
    private String color;
    
    @Column(name ="Linea",nullable = false,length = 20)
    private String linea;
    
    @Column(name = "marca",nullable = false,length = 20)
    private String marca;
    
    @Column(name = "modelo",nullable = false,length = 20)
    private String modelo;
    
    
    @OneToMany(mappedBy = "Vehiculo")
    private List<Placa> listaPlacas;

    public Vehiculo() {
    }

    public Vehiculo(String numeroSerie, String color, String linea, String marca, String modelo, List<Placa> listaPlacas) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.listaPlacas = listaPlacas;
    }

    public Vehiculo(String numeroSerie, String color, String linea, String marca, String modelo) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
    }
    

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }



    public List<Placa> getListaLicencias() {
        return listaPlacas;
    }

    public void setListaLicencias(List<Placa> listaPlacas ) {
        this.listaPlacas = listaPlacas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeroSerie);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        return Objects.equals(this.numeroSerie, other.numeroSerie);
    }

    @Override
    public String toString() {
        return "Vehiculo[" + "Serie: " + numeroSerie + ", color: " + color + ", linea: " + linea + ", marca: " + marca + ", modelo: " + modelo + ", listaPlacas: " + listaPlacas + ']';
    }
    
    
    
}
