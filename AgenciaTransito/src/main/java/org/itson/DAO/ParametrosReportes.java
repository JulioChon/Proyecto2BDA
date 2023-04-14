/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import java.util.Calendar;
import utilidades.TipoTramite;

/**
 *
 * @author Julio Chon, Luis Ayon.
 */
public class ParametrosReportes {

    private String nombre;
    private Calendar fechaInicio;
    private Calendar fechaFin;
    private TipoTramite tipoTramite;

    /**
     *
     * Constructor por defecto de la clase ParametrosReportes.
     */
    public ParametrosReportes() {
    }

    /**
     *
     * Constructor de la clase ParametrosReportes que recibe como parámetros el
     * nombre del reporte, la fecha de inicio, la fecha de fin y el tipo de
     * trámite.
     *
     * @param nombre El nombre del reporte.
     * @param fechaInicio La fecha de inicio del periodo a considerar en el
     * reporte.
     * @param fechaFin La fecha de fin del periodo a considerar en el reporte.
     * @param tipoTramite El tipo de trámite a considerar en el reporte.
     */
    public ParametrosReportes(String nombre, Calendar fechaInicio, Calendar fechaFin, TipoTramite tipoTramite) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipoTramite = tipoTramite;
    }

    /**
     *
     * Constructor de la clase ParametrosReportes que recibe como parámetro el
     * nombre del reporte.
     *
     * @param nombre El nombre del reporte.
     */
    public ParametrosReportes(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Constructor de la clase ParametrosReportes que recibe como parámetro el
     * tipo de trámite.
     *
     * @param tipoTramite El tipo de trámite a considerar en el reporte.
     */
    public ParametrosReportes(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

    /**
     *
     * Constructor de la clase ParametrosReportes que recibe como parámetros la
     * fecha de inicio y la fecha de fin.
     *
     * @param fechaInicio La fecha de inicio del periodo a considerar en el
     * reporte.
     * @param fechaFin La fecha de fin del periodo a considerar en el reporte.
     */
    public ParametrosReportes(Calendar fechaInicio, Calendar fechaFin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    /**
     *
     * Método que retorna el nombre del reporte.
     *
     * @return El nombre del reporte.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * Método que asigna el nombre del reporte.
     *
     * @param nombre El nombre del reporte a asignar.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Método que retorna la fecha de inicio del periodo a considerar en el
     * reporte.
     *
     * @return La fecha de inicio del periodo a considerar en el reporte.
     */
    public Calendar getFechaInicio() {
        return fechaInicio;
    }

    /**
     *
     * Método que asigna la fecha de inicio del periodo a considerar en el
     * reporte.
     *
     * @param fechaInicio La fecha de inicio a asignar.
     */
    public void setFechaInicio(Calendar fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    /**
     *
     * Método que retorna la fecha de fin del periodo a considerar en el
     * reporte.
     *
     * @return La fecha de fin del periodo a considerar en el reporte.
     */
    public Calendar getFechaFin() {
        return fechaFin;
    }
    /**
     *
     * Método que asigna la fecha de Fin del periodo a considerar en el
     * reporte.
     *
     * @param fechaFin La fecha de Fin a asignar.
     */
    public void setFechaFin(Calendar fechaFin) {
        this.fechaFin = fechaFin;
    }
    /**
     *
     * Método que regresa el tipo de tramite.
     *
     * @return TipoTramite.
     */
    public TipoTramite getTipoTramite() {
        return tipoTramite;
    }
    /**
     *
     * Método que asigna el tipo de tramite.
     *
     * @param tipoTramite el TipoTramite a asignar.
     */
    public void setTipoTramite(TipoTramite tipoTramite) {
        this.tipoTramite = tipoTramite;
    }

}
