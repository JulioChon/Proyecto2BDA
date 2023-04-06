/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author julio
 */
public class ParametrosBusquedaPersonas {
    private String rfc;
    private String nombre;
    private Date fechaNacimiento;

    public ParametrosBusquedaPersonas() {
    }

    public ParametrosBusquedaPersonas(String rfc, String nombre, Date fechaNacimiento) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
