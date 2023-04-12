/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.dominio;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.*;

/**
 *
 * @author julio
 */
@Entity
@PrimaryKeyJoinColumn(name = "id_Licencia")
@Table(name = "Licencias")
public class Licencia extends Tramite implements Serializable {

    
    @Column(name = "tipoCosto",nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TipoLicencia tipoCosto;

    public Licencia() {
    }

    public Licencia(TipoLicencia tipoCosto,  Estado estado, float costo, Calendar fechaExpedicion, Calendar vigencia, Persona persona) {
        super(estado, costo, fechaExpedicion, vigencia, persona);
        this.tipoCosto = tipoCosto;
    }

    public TipoLicencia getTipoCosto() {
        return tipoCosto;
    }

    public void setTipoCosto(TipoLicencia tipoCosto) {
        this.tipoCosto = tipoCosto;
    }

    @Override
    public String toString() {
        return super.toString() + "tipoCosto=" + tipoCosto ;
    }

   
    
    
   
    
    
    
}
