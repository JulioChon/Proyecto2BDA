/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import excepciones.PersistenciaException;
import interfaces.IPersonasDAO;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.itson.dominio.Persona;

/**
 *
 * @author julio
 */
public class PersonasDAO implements IPersonasDAO {

    /**
     * Metodo que agrega a la base de datos la informacion de 20 personas 
     * @throws PersistenciaException lanza esta excepcion en caso de haber un problema al 
     * agregar a las personas
     */
    @Override
    public void agregarPersonas() throws PersistenciaException{
        try {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Persona persona = new Persona("BAFJ701213SB1", "Juan", "Barrios", "Fernandez", new GregorianCalendar(1970, 12 - 1, 13), "66712345678");
        Persona persona2 = new Persona("OIPF790205P2", "Francisco", "Ortiz", "Perez", new GregorianCalendar(1979, 2 - 1, 5), "66718752678");
        Persona persona3 = new Persona("MAHM670102NJ", "Manuel", "Martinez", "Hernandez", new GregorianCalendar(1967, 1 - 1, 2), "66812345678");
        Persona persona4 = new Persona("CAGM6406181Y", "Felipe", "Camargo", "Llamas", new GregorianCalendar(1975, 2 - 1, 28), "68712345678");
        Persona persona5 = new Persona("GATJ860324HY", "Julia", "García", "Téllez", new GregorianCalendar(1986, 3 - 1, 24), "6861875236");
        Persona persona6 = new Persona("LAMM950201W6", "María", "López", "Álvarez", new GregorianCalendar(1995, 2 - 1, 1), "6671234578");
        Persona persona7 = new Persona("RAMC891027GA", "Carlos", "Ramírez", "Camacho", new GregorianCalendar(1989, 10 - 1, 27), "6641875290");
        Persona persona8 = new Persona("ZARF711017MF", "Fernanda", "Zárate", "Flores", new GregorianCalendar(1971, 10 - 1, 17), "6621875200");
        Persona persona9 = new Persona("LODP850304M8", "Pedro", "López", "Díaz", new GregorianCalendar(1985, 3 - 1, 4), "6691234590");
        Persona persona10 = new Persona("BALT810810HA", "Hugo", "Barrera", "López", new GregorianCalendar(1981, 8 - 1, 10), "6671234578");
        Persona persona11 = new Persona("RIAC730710H6", "Carmen", "Rivas", "Acosta", new GregorianCalendar(1973, 7 - 1, 10), "6621875265");
        Persona persona12 = new Persona("VASL9510195Z", "Luis", "Vargas", "Sánchez", new GregorianCalendar(1995, 10 - 1, 19), "6641234567");
        Persona persona13 = new Persona("JALM810203ML", "Mario", "Juárez", "Luna", new GregorianCalendar(1981, 2 - 1, 3), "6691234567");
        Persona persona14 = new Persona("DORF841123HJ", "Fabiola", "Dominguez", "Ramírez", new GregorianCalendar(1984, 11 - 1, 23), "6641875290");
        Persona persona15 = new Persona("ROAC750722M8", "Cristina", "Rojas", "Acosta", new GregorianCalendar(1975, 7 - 1, 22), "6621875215");
        Persona persona16 = new Persona("MIGJ8807086U", "José", "Miguel", "Gutiérrez", new GregorianCalendar(1988, 7 - 1, 8), "6691875265");
        Persona persona17 = new Persona("VALD9011251J", "Daniel", "Valdez", "Dominguez", new GregorianCalendar(1990, 11 - 1, 25), "6641234590");
        Persona persona18 = new Persona("RORC7605271F", "Carlos", "Romero", "Rocha", new GregorianCalendar(1976, 5 - 1, 27), "6621875200");
        Persona persona19 = new Persona("GAVL950329RF", "Luis", "García", "Velasco", new GregorianCalendar(1995, 3 - 1, 29), "6671357968");
        Persona persona20 = new Persona("LOAM880721HM", "Mónica", "López", "Alvarado", new GregorianCalendar(1988, 7 - 1, 21), "6681567398");

        Persona[] personas = {persona, persona2, persona3, persona4, persona5, persona6, persona7, persona8, persona9, persona10, persona11,
            persona12, persona13, persona14, persona15, persona16, persona17, persona18, persona19, persona20};
        
            for (Persona p : personas) {
                entityManager.persist(p);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new PersistenciaException("Las personas ya fueron registradas");
        }

    }

    /**
     * Metodo que devuelve una lista de personas las cuales se obtien mediante una 
     * serie de parametros que recibe en su parametro
     * @param params parametros para la busqueda de las personas
     * @return lista de personas que cumplen los filtros, en caso de no haber filtros
     * regresa una lista con todas las personas de la lista
     */
    @Override
    public List<Persona> buscar(ParametrosBusquedaPersonas params) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> criteria = builder.createQuery(Persona.class);
        Root<Persona> entidadPersona = criteria.from(Persona.class);
        List<Predicate> filtros = new LinkedList<>();

        if (params != null) {
            if (params.getRfc() != null) {
                filtros.add(builder.like(entidadPersona.get("rfc"), "%" + params.getRfc() + "%"));

            }
            if (params.getFechaNacimiento() != null) {
                SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
                filtros.add(builder.equal(entidadPersona.get("fechaNacimiento"), params.getFechaNacimiento()));
            }
        }

        if (filtros.isEmpty()) {
            criteria = criteria.select(entidadPersona);
        } else {
            criteria = criteria.select(entidadPersona).where(
                    builder.or((filtros.toArray(new Predicate[filtros.size()]))));
        }

        TypedQuery<Persona> query = entityManager.createQuery(criteria);

        List<Persona> personas = query.getResultList();
        return personas;

    }

    /**
     * Metodo que devuelve una lista de personas, las cuales en su nombre exista 
     * coinsidencias con el atributo que recibe en su parametros
     * @param nombreCompleto nombre de la persona o personas que se buscan 
     * @return lista de personas las cuales tengas coicidencias con el nombre 
     * que recibe en su parametro
     */
    @Override
    public List<Persona> buscarNombre(String nombre) {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("org.itson.agenciaTransito");
        EntityManager entityManager = emFactory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Persona> personas = entityManager.createQuery("SELECT p FROM Persona p", Persona.class).getResultList();
        List<Persona> coincidencia = new ArrayList<>();
        entityManager.getTransaction().commit();
        String nombreCompleto = null;
        for (Persona persona : personas) {
            nombreCompleto = persona.getNombre() + " " + persona.getApellidoPaterno() + " " + persona.getApellidoPaterno();
            if (nombreCompleto.toUpperCase().contains(nombre.toUpperCase())) {
                coincidencia.add(persona);
            }
        }
        return coincidencia;

    }

}
