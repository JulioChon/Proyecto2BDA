/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import java.util.Calendar;
import java.util.Date;
import utilidades.TipoTramite;

/**
 *
 * @author julio
 */
public class ParametrosReportes {
    private String nombre;
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private TipoTramite tipoTramite;
    
    public ParametrosReportes() {
    }

    public ParametrosReportes(String nombre, Calendar fechaInicio, Calendar fechaFin, TipoTramite tipoTramite) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoTramite = tipoTramite;
    }

    public ParametrosReportes(String nombre) {
        this.nombre = nombre;
    }

    public ParametrosReportes(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    public ParametrosReportes(Calendar fechaInicio, Calendar fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Calendar getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }

    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }

    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }
    
    
}
