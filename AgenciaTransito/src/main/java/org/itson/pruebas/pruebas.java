/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Estado;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.TipoLicencia;


/**
 *
 * @author julio
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        
        entityManager.getTransaction().begin();
   
        
        Persona persona = new Persona("ghbvfkd", "Pablo","Ayon","Figueroa", new GregorianCalendar(2023, 3-1, 8), "6871619691");
        Licencia licencia = new Licencia(TipoLicencia.normal, Estado.Activo, 15, new GregorianCalendar(2023, 3-1, 8), new GregorianCalendar(2023, 3-1, 8), persona);
        
        
        entityManager.persist(licencia);
        
        entityManager.getTransaction().commit();
    }
    
}
