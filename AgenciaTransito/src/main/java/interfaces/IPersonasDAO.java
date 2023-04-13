/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import excepciones.PersistenciaException;
import java.util.List;
import org.itson.DAO.ParametrosBusquedaPersonas;
import org.itson.dominio.Persona;

/**
 *
 * @author julio
 */
public interface IPersonasDAO {
    
    /**
     * Metodo que agrega a la base de datos la informacion de 20 personas 
     * @throws PersistenciaException lanza esta excepcion en caso de haber un problema al 
     * agregar a las personas
     */
    void agregarPersonas() throws PersistenciaException;
    /**
     * Metodo que devuelve una lista de personas las cuales se obtien mediante una 
     * serie de parametros que recibe en su parametro
     * @param params parametros para la busqueda de las personas
     * @return lista de personas que cumplen los filtros, en caso de no haber filtros
     * regresa una lista con todas las personas de la lista
     */
    List<Persona> buscar(ParametrosBusquedaPersonas params);
    /**
     * Metodo que devuelve una lista de personas, las cuales en su nombre exista 
     * coinsidencias con el atributo que recibe en su parametros
     * @param nombreCompleto nombre de la persona o personas que se buscan 
     * @return lista de personas las cuales tengas coicidencias con el nombre 
     * que recibe en su parametro
     */
    List<Persona> buscarNombre(String nombreCompleto);
}
