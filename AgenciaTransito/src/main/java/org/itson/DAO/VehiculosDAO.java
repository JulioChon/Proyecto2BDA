/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.dominio.Vehiculo;

/**
 *
 * @author Zaurus
 */
public class VehiculosDAO {
    public void registrarVehiculo(Vehiculo vehiculo) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(vehiculo);

        entityManager.getTransaction().commit();

    }
}
