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
    private Calendar fechaNacimiento;

    public ParametrosBusquedaPersonas() {
    }

    public ParametrosBusquedaPersonas(String rfc, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }


    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
}
