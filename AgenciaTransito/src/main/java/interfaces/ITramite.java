/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;



/**
 *
 * @author julio
 */
public interface ITramite {
    /**
     * Metodo que usa un stored de mysql para agregar una licencia a la 
     * base de datos, agrega la licencia que recibe en su parametro
     * @param licencia licencia que se desea agregar 
     */
    void registrarLicencia(Licencia licencia);
    /**
     * Metodo que usa un stored de mysql para agregar una placa a la base 
     * de datos, agrega la placa que recibe en un parametro
     * @param placa placa que se desea agregar 
     */
    void registrarPlaca (Placa placa);
}
