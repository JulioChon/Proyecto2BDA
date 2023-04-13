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
 * Esta clase representa la entidad "Persona" que será mapeada a la tabla
 * "Personas" en la base de datos.
 *
 * Contiene los atributos correspondientes a una persona y los métodos
 * necesarios para acceder a ellos.
 */
@Entity
@Table(name = "Personas")
public class Persona implements Serializable {

    @Id
    @Column(name = "rfc", nullable = false, length = 13)
    private String rfc;

    @Column(name = "nombre", nullable = false, length = 200)
    @Convert(converter = AESEncript.class)
    private String nombre;

    @Column(name = "apellido_Paterno", nullable = false, length = 200)
    @Convert(converter = AESEncript.class)
    private String apellidoPaterno;

    @Column(name = "apellido_Materno", nullable = false, length = 200)
    @Convert(converter = AESEncript.class)
    private String apellidoMaterno;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @OneToMany(mappedBy = "Persona")
    private List<Tramite> listaTramites;

    /**
     * Contructor por defecto
     */
    public Persona() {
    }

    /**
     *
     * Constructor de la clase Persona que recibe los atributos como parámetros.
     *
     * @param rfc el RFC de la persona.
     * @param nombre el nombre de la persona.
     * @param apellidoPaterno el apellido paterno de la persona.
     * @param apellidoMaterno el apellido materno de la persona.
     * @param fechaNacimiento la fecha de nacimiento de la persona en formato
     * Calendar.
     * @param telefono el número de teléfono de la persona.
     * @param listaTramites la lista de trámites asociados a la persona.
     */
    public Persona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono, List<Tramite> listaTramites) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.listaTramites = listaTramites;
    }

    /**
     *
     * Constructor de la clase Persona que recibe los atributos como parámetros.
     *
     * @param rfc el RFC de la persona.
     * @param nombre el nombre de la persona.
     * @param apellidoPaterno el apellido paterno de la persona.
     * @param apellidoMaterno el apellido materno de la persona.
     * @param fechaNacimiento la fecha de nacimiento de la persona en formato
     * Calendar.
     * @param telefono el número de teléfono de la persona.
     */
    public Persona(String rfc, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
    }

    /**
     *
     * Obtiene el RFC de la persona.
     *
     * @return El RFC de la persona.
     */
    public String getRfc() {
        return rfc;
    }

    /**
     *
     * Establece el RFC de la persona.
     *
     * @param rfc El RFC de la persona.
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     *
     * Obtiene el nombre de la persona.
     *
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * Establece el nombre de la persona.
     *
     * @param nombre El nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * Obtiene el apellido paterno de la persona.
     *
     * @return El apellido paterno de la persona.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * Establece el apellido paterno de la persona.
     *
     * @param apellidoPaterno El apellido paterno de la persona.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     *
     * Obtiene el apellido materno de la persona.
     *
     * @return El apellido materno de la persona.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * Establece el apellido materno de la persona.
     *
     * @param apellidoMaterno El apellido materno de la persona.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     *
     * Obtiene la fecha de nacimiento de la persona.
     *
     * @return La fecha de nacimiento de la persona.
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * Establece la fecha de nacimiento de la persona.
     *
     * @param fechaNacimiento La fecha de nacimiento de la persona.
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * Obtiene el teléfono de la persona.
     *
     * @return El teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * Establece el teléfono de la persona.
     *
     * @param telefono El teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * Obtiene la lista de trámites realizados por la persona.
     *
     * @return La lista de trámites realizados por la persona.
     */
    public List<Tramite> getListaTramites() {
        return listaTramites;
    }

    /**
     * Establece la lista de trámites realizados por la persona.
     *
     * @param listaTram
     */
    public void setListaTramites(List<Tramite> listaTramites) {
        this.listaTramites = listaTramites;
    }

    /**
     * Devuelve un código hash para el objeto actual basado en el valor de su
     * atributo `rfc`.
     *
     * @return Código hash del objeto actual.
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.rfc);
        return hash;
    }

    /**
     * Compara el objeto actual con otro objeto `obj` y devuelve `true` si ambos
     * objetos son iguales.
     *
     * @param obj Objeto a comparar con el objeto actual.
     * @return true si el objeto actual y el objeto `obj` son iguales, false en
     * otro caso.
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
        final Persona other = (Persona) obj;
        return Objects.equals(this.rfc, other.rfc);
    }

    /**
     * Devuelve una representación en forma de cadena del objeto actual.
     * @return Representación en forma de cadena del objeto actual.
     */
    @Override
    public String toString() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return rfc + " " + nombre + " " + apellidoPaterno + " " + apellidoMaterno + " " + formateador.format(fechaNacimiento.getTime()) + " " + telefono;
    }

}
