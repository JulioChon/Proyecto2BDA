/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import interfaces.IVehiculosDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Automovil;
import org.itson.dominio.Persona;

/**
 *
 * @author Julio Chon, Luis Ayon
 */
public class VehiculosDAO implements IVehiculosDAO{
    /**
     * Metodo que recibe un automivil y lo inserta en la base de datos.
     * @param automovil automovil que sera insertado en la base de datos.
     */
    @Override
    public void registrarAutomovil(Automovil automovil) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(automovil);
        entityManager.getTransaction().commit();

    }
    /**
     * Metodo que busca vehiculos en este caso Automoviles de la base de datos.
     * @return Lista de automoviles
     */
    @Override
    public List<Automovil> buscarVehiculo()
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery  = criteriaBuilder.createQuery();
        Root<Automovil> root = criteriaQuery.from(Automovil.class);
        criteriaQuery.select(root);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Automovil> listaResultados = query.getResultList();
        return  listaResultados;
    }
    /**
     * Metodo que busca vehiculos en este caso Automoviles de la base de datos segun su numero de serie.
     * @param numeroSerie numero de serie que se utilizara para buscar los vehiculos.
     * @return Lista de automoviles
     */
    @Override
    public List<Automovil> buscarVehiculo(String numeroSerie)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery  = criteriaBuilder.createQuery();
        Root<Automovil> root = criteriaQuery.from(Automovil.class);
        criteriaQuery.select(root);
        
        Predicate predicateNumeroSerie = criteriaBuilder.equal(root.get("numeroSerie"), numeroSerie);
        criteriaQuery.where(predicateNumeroSerie);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Automovil> listaResultados = query.getResultList();
        return  listaResultados;
    }
    /**
     * Metodo que busca vehiculos en este caso Automoviles de la base de datos segun la persona que lo posee.
     * @param persona persona que se utilizara para buscar los vehiculos.
     * @return Lista de automoviles.
     */
    @Override
    public List<Automovil> buscarVehiculo(Persona persona)
    {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery  = criteriaBuilder.createQuery();
        Root<Automovil> root = criteriaQuery.from(Automovil.class);
        criteriaQuery.select(root);
        
        Predicate predicateNumeroSerie = criteriaBuilder.equal(root.get("persona"), persona);
        criteriaQuery.where(predicateNumeroSerie);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Automovil> listaResultados = query.getResultList();
        return  listaResultados;
    }
}
