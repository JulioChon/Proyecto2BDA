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
    void registrarLicencia(Licencia licencia);
    void registrarPlaca (Placa placa);
}
