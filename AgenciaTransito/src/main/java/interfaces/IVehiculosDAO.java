/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.dominio.Automovil;
import org.itson.dominio.Persona;

/**
 *
 * @author Zaurus
 */
public interface IVehiculosDAO {
    /**
     * Metodo que recibe un automivil y lo inserta en la base de datos.
     * @param automovil automovil que sera insertado en la base de datos.
     */
    void registrarAutomovil(Automovil automovil) ;
    /**
     * Metodo que busca vehiculos en este caso Automoviles de la base de datos.
     * @return Lista de automoviles
     */
    List<Automovil> buscarVehiculo();
    /**
     * Metodo que busca vehiculos en este caso Automoviles de la base de datos segun su numero de serie.
     * @param numeroSerie numero de serie que se utilizara para buscar los vehiculos.
     * @return Lista de automoviles
     */
    List<Automovil> buscarVehiculo(String numeroSerie);
    /**
     * Metodo que busca vehiculos en este caso Automoviles de la base de datos segun la persona que lo posee.
     * @param persona persona que se utilizara para buscar los vehiculos.
     * @return Lista de automoviles.
     */
    List<Automovil> buscarVehiculo(Persona persona);
    
}
