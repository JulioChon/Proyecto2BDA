/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.DAO.ParametrosBusquedaPersonas;
import org.itson.dominio.Persona;

/**
 *
 * @author julio
 */
public interface IPersonasDAO {
    
    
    void agregarPersonas();
    List<Persona> buscar(ParametrosBusquedaPersonas params);
    List<Persona> buscarNombre(String nombreCompleto);
}
