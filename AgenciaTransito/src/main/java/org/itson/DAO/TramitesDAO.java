/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import interfaces.ITramite;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;

/**
 *
 * @author Julio Chon, Luis Ayon.
 */
public class TramitesDAO implements ITramite {

    /**
     * Metodo que usa un stored de mysql para agregar una licencia a la 
     * base de datos, agrega la licencia que recibe en su parametro
     * @param licencia licencia que se desea agregar 
     */
    @Override
    public void registrarLicencia(Licencia licencia) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("actualizar_licencias");
        storedProcedure.registerStoredProcedureParameter(1, Float.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(5, Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);

        Date fechaExpedicion = licencia.getFechaExpedicion().getTime();
        Date vigencia = licencia.getVigencia().getTime();
        String rfc = licencia.getPersona().getRfc();
        float costo = licencia.getCosto();
        storedProcedure.setParameter(1, costo);
        storedProcedure.setParameter(2, licencia.getEstado().toString());
        storedProcedure.setParameter(3, fechaExpedicion, TemporalType.DATE);
        storedProcedure.setParameter(4, licencia.getTipoCosto().toString());
        storedProcedure.setParameter(5, vigencia, TemporalType.DATE);
        storedProcedure.setParameter(6, rfc);

        storedProcedure.execute();
    }

    /**
     * Metodo que usa un stored de mysql para agregar una placa a la base 
     * de datos, agrega la placa que recibe en un parametro
     * @param placa placa que se desea agregar 
     */
    @Override
    public void registrarPlaca(Placa placa) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("actualizar_placas");
        storedProcedure.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(2, Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(3, Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(4, Date.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(5, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(6, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(7, Float.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(8, String.class, ParameterMode.IN);

        Date fechaExpedicion = placa.getFechaExpedicion().getTime();
        Date vigencia = placa.getVigencia().getTime();
        Date fechaEntrega = placa.getFechaEntrega().getTime();
        String rfc = placa.getPersona().getRfc();
        storedProcedure.setParameter(1, placa.getVehiculo().getNumeroSerie());
        storedProcedure.setParameter(2, fechaEntrega);
        storedProcedure.setParameter(3, fechaExpedicion);
        storedProcedure.setParameter(4, vigencia);
        storedProcedure.setParameter(5, placa.getTipoPlaca().toString());
        storedProcedure.setParameter(6, rfc);
        storedProcedure.setParameter(7, (float) placa.getCosto());
        storedProcedure.setParameter(8, placa.getEstado().toString());

        storedProcedure.execute();

    }
    /**
     * Metodo que busca las placas registradas segun la persona que las registro.
     * @param persona persona de la cual buscaran las placas
     * @return lista de placas.
     */
    public List<Placa> buscarPlacas(Persona persona) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Placa> root = criteriaQuery.from(Placa.class);
        criteriaQuery.select(root);

        Predicate predicatePlaca = criteriaBuilder.equal(root.get("persona"), persona);
        criteriaQuery.where(predicatePlaca);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Placa> listaResultados = query.getResultList();
        return listaResultados;
    }
    /**
     * Metodo que busca las placas registradas segun el vehiculo que las posee.
     * @param vehiculo vehiculo de la cual buscaran las placas
     * @return lista de placas.
     */
    public List<Placa> buscarPlacas(Vehiculo vehiculo) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Placa> root = criteriaQuery.from(Placa.class);
        criteriaQuery.select(root);

        Predicate predicatePlaca = criteriaBuilder.equal(root.get("vehiculo"), vehiculo);
        criteriaQuery.where(predicatePlaca);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Placa> listaResultados = query.getResultList();
        return listaResultados;
    }
    /**
     * Metodo que busca las placas registradas segun la serie de la placa.
     * @param serie serie de la cual buscaran las placas
     * @return lista de placas.
     */
    public List<Placa> buscarPlacas(String serie) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Placa> root = criteriaQuery.from(Placa.class);
        criteriaQuery.select(root);

        Predicate predicatePlaca = criteriaBuilder.equal(root.get("serie"), serie);
        criteriaQuery.where(predicatePlaca);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Placa> listaResultados = query.getResultList();
        return listaResultados;
    }
    /**
     * Metodo que busca las licencias registradas segun la persona de la licencia.
     * @param persona persona de la cual buscaran las licencias
     * @return lista de licencias.
     */
    public List<Licencia> buscarLicencias(Persona persona) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Licencia> root = criteriaQuery.from(Licencia.class);
        criteriaQuery.select(root);

        Predicate predicateLicencia = criteriaBuilder.equal(root.get("persona"), persona);
        criteriaQuery.where(predicateLicencia);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Licencia> listaResultados = query.getResultList();
        return listaResultados;
    }
    /**
     * Metodo que busca las licencias registradas y aun vigentes segun la persona de la licencia.
     * @param persona persona de la cual buscaran las licencias
     * @return lista de licencias.
     */
    public List<Licencia> buscarLicenciasVigentes(Persona persona) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Licencia> root = criteriaQuery.from(Licencia.class);
        criteriaQuery.select(root);

        Predicate predicateLicenciaPersona = criteriaBuilder.equal(root.get("persona"), persona);
        java.sql.Date fecha = new java.sql.Date(new Date().getTime());
        Predicate predicateLicenciaVigente = criteriaBuilder.greaterThan(root.get("vigencia"), fecha);
        Predicate predicateLicencia = criteriaBuilder.and(predicateLicenciaPersona, predicateLicenciaVigente);
        criteriaQuery.where(predicateLicencia);
        Query query = entityManager.createQuery(criteriaQuery);
        List<Licencia> listaResultados = query.getResultList();
        return listaResultados;
    }
    /**
     * Metodo que busca los tramites registrados segun la persona del tramite y una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @param persona persona de la cual buscaran los tramites
     * @return lista de tramites.
     */
    public List<Tramite> buscar(ParametrosReportes params, Persona persona) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tramite> criteria = builder.createQuery(Tramite.class);
        Root<Tramite> entidadTramite = criteria.from(Tramite.class);
        List<Predicate> filtros = new LinkedList<>();
        if (persona != null) {
            CriteriaQuery<Persona> criteriaPersona = builder.createQuery(Persona.class);
            Root<Persona> entidadPersona = criteria.from(Persona.class);
            filtros.add(builder.equal(entidadTramite.get("persona"), persona));

        }
        if (params != null) {

            if (params.getFechaInicio() != null && params.getFechaFin() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.between(entidadTramite.get("fechaExpedicion"), params.getFechaInicio(), params.getFechaFin()));
            } else if (params.getFechaInicio() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.greaterThan(entidadTramite.get("fechaExpedicion"), params.getFechaInicio()));
            } else if (params.getFechaFin() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.lessThan(entidadTramite.get("fechaExpedicion"), params.getFechaFin()));
            }
        }

        if (filtros.isEmpty()) {
            criteria = criteria.select(entidadTramite);
        } else {
            criteria = criteria.select(entidadTramite).where(
                    builder.or((filtros.toArray(new Predicate[filtros.size()]))));
        }

        TypedQuery<Tramite> query = entityManager.createQuery(criteria);

        List<Tramite> personas = query.getResultList();
        return personas;

    }
    /**
     * Metodo que busca las placas registradas segun la persona del placa y una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @param persona persona de la cual buscaran las placas.
     * @return lista de placas.
     */
    public List<Placa> buscarPlacas(ParametrosReportes params, Persona persona) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Placa> criteria = builder.createQuery(Placa.class);
        Root<Placa> entidadTramite = criteria.from(Placa.class);
        List<Predicate> filtros = new LinkedList<>();
        if (persona != null) {
            CriteriaQuery<Persona> criteriaPersona = builder.createQuery(Persona.class);
            Root<Persona> entidadPersona = criteria.from(Persona.class);
            filtros.add(builder.equal(entidadTramite.get("persona"), persona));

        }
        if (params != null) {

            if (params.getFechaInicio() != null && params.getFechaFin() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.between(entidadTramite.get("fechaExpedicion"), params.getFechaInicio(), params.getFechaFin()));
            } else if (params.getFechaInicio() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.greaterThan(entidadTramite.get("fechaExpedicion"), params.getFechaInicio()));
            } else if (params.getFechaFin() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.lessThan(entidadTramite.get("fechaExpedicion"), params.getFechaFin()));
            }
        }

        if (filtros.isEmpty()) {
            criteria = criteria.select(entidadTramite);
        } else {
            criteria = criteria.select(entidadTramite).where(
                    builder.or((filtros.toArray(new Predicate[filtros.size()]))));
        }

        TypedQuery<Placa> query = entityManager.createQuery(criteria);

        List<Placa> placas = query.getResultList();
        return placas;

    }
    /**
     * Metodo que busca las licencias registradas segun la persona del licencia y una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @param persona persona de la cual buscaran las licencias.
     * @return lista de licencias.
     */
    public List<Licencia> buscarLicencias(ParametrosReportes params, Persona persona) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Licencia> criteria = builder.createQuery(Licencia.class);
        Root<Licencia> entidadTramite = criteria.from(Licencia.class);
        List<Predicate> filtros = new LinkedList<>();
        if (persona != null) {
            CriteriaQuery<Persona> criteriaPersona = builder.createQuery(Persona.class);
            Root<Persona> entidadPersona = criteria.from(Persona.class);
            filtros.add(builder.equal(entidadTramite.get("persona"), persona));

        }
        if (params != null) {

            if (params.getFechaInicio() != null && params.getFechaFin() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.between(entidadTramite.get("fechaExpedicion"), params.getFechaInicio(), params.getFechaFin()));
            } else if (params.getFechaInicio() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.greaterThan(entidadTramite.get("fechaExpedicion"), params.getFechaInicio()));
            } else if (params.getFechaFin() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.lessThan(entidadTramite.get("fechaExpedicion"), params.getFechaFin()));
            }
        }

        if (filtros.isEmpty()) {
            criteria = criteria.select(entidadTramite);
        } else {
            criteria = criteria.select(entidadTramite).where(
                    builder.or((filtros.toArray(new Predicate[filtros.size()]))));
        }

        TypedQuery<Licencia> query = entityManager.createQuery(criteria);

        List<Licencia> licencias = query.getResultList();
        return licencias;

    }
    /**
     * Metodo que busca los tramites registrados segun una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @return lista de tramites.
     */
    public List<Tramite> buscar(ParametrosReportes params) {
        List<Tramite> listaResultados = new LinkedList<>();
        if(params.getNombre() != null)
        {
            List<Persona> listaPersonas = new PersonasDAO().buscarNombre(params.getNombre());
            for (int i = 0; i < listaPersonas.size(); i++) 
            {
                if (null != params.getTipoTramite()) 
                switch (params.getTipoTramite()) {
                    case PlacasLicencias:
                        listaResultados.addAll(this.buscarPlacas(params, listaPersonas.get(i)));
                        listaResultados.addAll(this.buscarLicencias(params, listaPersonas.get(i)));
                        break;
                    case Licencias:
                        listaResultados.addAll(this.buscarLicencias(params, listaPersonas.get(i)));
                        break;
                    case Placas:
                        listaResultados.addAll(this.buscarPlacas(params, listaPersonas.get(i)));
                        break;
                    default:
                        break;
                }
            }
        }else 
        {
            if (null != params.getTipoTramite()) 
                switch (params.getTipoTramite()) {
                case PlacasLicencias:
                    listaResultados.addAll(this.buscarPlacas(params, null));
                    listaResultados.addAll(this.buscarLicencias(params, null));
                    break;
                case Licencias:
                    listaResultados.addAll(this.buscarLicencias(params, null));
                    break;
                case Placas:
                    listaResultados.addAll(this.buscarPlacas(params, null));
                    break;
                default:
                    break;
            }
        }
        
        return listaResultados;
    }

}
