/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;
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
    public List<Vehiculo> buscarVehiculo(String numeroSerie)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery  = criteriaBuilder.createQuery();
        Root<Vehiculo> root = criteriaQuery.from(Vehiculo.class);
        criteriaQuery.select(root);
        
        Predicate predicateNumeroSerie = criteriaBuilder.equal(root.get("numeroSerie"), numeroSerie);
        criteriaQuery.where(predicateNumeroSerie);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Vehiculo> listaResultados = query.getResultList();
        return  listaResultados;
    }
    public List<Vehiculo> buscarVehiculo(Persona persona)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery  = criteriaBuilder.createQuery();
        Root<Vehiculo> root = criteriaQuery.from(Vehiculo.class);
        criteriaQuery.select(root);
        
        Predicate predicateNumeroSerie = criteriaBuilder.equal(root.get("persona"), persona);
        criteriaQuery.where(predicateNumeroSerie);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Vehiculo> listaResultados = query.getResultList();
        return  listaResultados;
    }
}
