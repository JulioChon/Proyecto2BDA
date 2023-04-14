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
 ** Clase que representa un vehículo. Esta clase se utiliza como clase base
 * para las distintas clases de vehículos.
 *
 * @author Julio Chon, Luis Ayon
 */
@Entity
@Table(name = "Vehiculos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehiculo implements Serializable {

    /**
     * Número de serie del vehículo.
     */
    @Id
    @Column(name = "numeroSerie", nullable = false)
    private String numeroSerie;

    /**
     * Color del vehículo.
     */
    @Column(name = "color", nullable = false, length = 20)
    private String color;

    /**
     * Línea del vehículo.
     */
    @Column(name = "Linea", nullable = false, length = 20)
    private String linea;

    /**
     * Marca del vehículo.
     */
    @Column(name = "marca", nullable = false, length = 20)
    private String marca;

    /**
     * Modelo del vehículo.
     */
    @Column(name = "modelo", nullable = false, length = 20)
    private String modelo;

    /**
     * Lista de placas asociadas al vehículo.
     */
    @OneToMany(mappedBy = "Vehiculo")
    private List<Placa> listaPlacas;

    /**
     * Constructor por defecto.
     */
    public Vehiculo() {
    }

    /**
     * Constructor de la clase Vehículo que recibe los atributos como
     * parámetros.
     *
     * @param numeroSerie el número de serie del vehículo.
     * @param color el color del vehículo.
     * @param linea la línea del vehículo.
     * @param marca la marca del vehículo.
     * @param modelo el modelo del vehículo.
     * @param listaPlacas la lista de placas asociadas al vehículo.
     */
    public Vehiculo(String numeroSerie, String color, String linea, String marca, String modelo, List<Placa> listaPlacas) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.listaPlacas = listaPlacas;
    }

    /**
     * Constructor de la clase Vehículo que recibe los atributos como
     * parámetros.
     *
     * @param numeroSerie el número de serie del vehículo.
     * @param color el color del vehículo.
     * @param linea la línea del vehículo.
     * @param marca la marca del vehículo.
     * @param modelo el modelo del vehículo.
     */
    public Vehiculo(String numeroSerie, String color, String linea, String marca, String modelo) {
        this.numeroSerie = numeroSerie;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * Obtiene el número de serie del vehículo.
     *
     * @return el número de serie del vehículo.
     */
    public String getNumeroSerie() {
        return numeroSerie;
    }

    /**
     * Establece el número de serie del vehículo.
     *
     * @param numeroSerie el número de serie del vehículo.
     */
    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    /**
     * Devuelve el color del vehículo.
     *
     * @return el color del vehículo.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del vehículo.
     *
     * @param color el nuevo color del vehículo.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Devuelve la línea del vehículo.
     *
     * @return la línea del vehículo.
     */
    public String getLinea() {
        return linea;
    }

    /**
     * Establece la línea del vehículo.
     *
     * @param linea la nueva línea del vehículo.
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * Devuelve la marca del vehículo.
     *
     * @return la marca del vehículo.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del vehículo.
     *
     * @param marca la nueva marca del vehículo.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Devuelve el modelo del vehículo.
     *
     * @return el modelo del vehículo.
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Establece el modelo del vehículo.
     *
     * @param modelo el nuevo modelo del vehículo.
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Devuelve la lista de placas asociadas al vehículo.
     *
     * @return la lista de placas asociadas al vehículo.
     */
    public List<Placa> getListaLicencias() {
        return listaPlacas;
    }

    /**
     * Establece la lista de placas asociadas al vehículo.
     *
     * @param listaPlacas la nueva lista de placas asociadas al vehículo.
     */
    public void setListaLicencias(List<Placa> listaPlacas) {
        this.listaPlacas = listaPlacas;
    }

    /**
     * Devuelve el valor hash del vehículo.
     *
     * @return el valor hash del vehículo.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.numeroSerie);
        return hash;
    }

    /**
     * Compara el vehículo con otro objeto para determinar si son iguales.
     *
     * @param obj el objeto con el que se desea comparar el vehículo.
     * @return true si el objeto es igual al vehículo, false en caso contrario.
     */
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

    /**
     * Devuelve una representación en cadena del vehículo.
     *
     * @return una representación en cadena del vehículo.
     */
    @Override
    public String toString() {
        return "Vehiculo[" + "Serie: " + numeroSerie + ", color: " + color + ", linea: " + linea + ", marca: " + marca + ", modelo: " + modelo + ", listaPlacas: " + listaPlacas + ']';
    }

}
