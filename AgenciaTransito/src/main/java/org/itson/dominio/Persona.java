/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;

/**
 *
 * @author julio
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {
 
    @Id
    @Column(name ="rfc",nullable = false, length = 13)
    private String rfc;
    
    @Column(name = "nombre",nullable = false, length = 20)
    private String nombre;
    
    @Column(name = "apellido_Paterno",nullable = false, length = 20)
    private String apellidoPaterno;
    
    @Column(name = "apellido_Materno",nullable = false,length = 20)
    private String apellidoMaterno;
    
    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    
    @Column(name ="telefono",nullable = false,length = 15)
    private String telefono;
    
    
    @OneToMany(mappedBy = "Persona")
    private List<Tramite> listaTramites;

    @OneToMany(mappedBy = "Persona")
    private List<Vehiculo> listaVehiculos;

    public Persona() {
    }

    public Persona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, List<Tramite> listaTramites, List<Vehiculo> listaVehiculos) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.listaTramites = listaTramites;
        this.listaVehiculos = listaVehiculos;
    }

    public Persona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Tramite> getListaTramites() {
        return listaTramites;
    }

    public void setListaTramites(List<Tramite> listaTramites) {
        this.listaTramites = listaTramites;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.rfc);
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    @Override
    public String toString() {
         SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return   rfc + " "+ nombre+ " " + apellidoPaterno +" "+ apellidoMaterno +" "+ formateador.format(fechaNacimiento.getTime()) + " "+ telefono;
    }
    
    
    
    
}
