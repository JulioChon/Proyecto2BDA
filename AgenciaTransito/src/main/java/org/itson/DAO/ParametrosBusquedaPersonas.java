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

    /**
     *
     * Constructor sin argumentos.
     */
    public ParametrosBusquedaPersonas() {
    }

    /**
     *
     * Constructor con argumentos.
     *
     * @param rfc el RFC de la persona a buscar.
     * @param fechaNacimiento la fecha de nacimiento de la persona a buscar.
     */
    public ParametrosBusquedaPersonas(String rfc, Calendar fechaNacimiento) {
        this.rfc = rfc;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * Obtiene el RFC de la persona a buscar.
     *
     * @return el RFC de la persona a buscar.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     *
     * Establece el RFC de la persona a buscar.
     *
     * @param rfc el RFC de la persona a buscar.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     *
     * Obtiene la fecha de nacimiento de la persona a buscar.
     *
     * @return la fecha de nacimiento de la persona a buscar.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * Establece la fecha de nacimiento de la persona a buscar.
     *
     * @param fechaNacimiento la fecha de nacimiento de la persona a buscar.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
