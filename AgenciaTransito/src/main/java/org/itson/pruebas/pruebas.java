/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;

import com.mycompany.plantillapantallasproyecto2basedatosavanzadas.MenuInicio;
import java.time.LocalDateTime;
import java.util.GregorianCalendar;
import java.util.List;
import org.itson.DAO.ParametrosBusquedaPersonas;
import org.itson.DAO.PersonasDAO;
import org.itson.dominio.Persona;


/**
 *
 * @author julio
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
        MenuInicio menuInicion = new MenuInicio();
//       PersonasDAO personasDAO = new PersonasDAO();
//       ParametrosBusquedaPersonas params = new ParametrosBusquedaPersonas();
//       params.setRfc("BAFJ701213SB1");
//       //params.setNombre("Carlos");
//       //params.setFechaNacimiento(new GregorianCalendar(1989,10-1,27).getTime());
//       List<Persona> personas = personasDAO.buscar(params);
//        for (Persona persona : personas) {
//            System.out.println(persona.getListaTramites());   
//        }
////        TramitesDAO tramitesDAO = new TramitesDAO();
//////        Licencia licencia = new Licencia(TipoLicencia.normal, Estado.Activo, 1100, new GregorianCalendar(1989,10-1,27), new GregorianCalendar(1989,10-1,27), personas.get(0));
//////        tramitesDAO.registrarLicencia(licencia);
////          Automovil automovil = new Automovil("1", "rojo", "azul", "Azul", "Azul", personas.get(0));
////          Placa placa = new Placa(new GregorianCalendar(1989,10-1,27), TipoPlaca.usado, Estado.Activo, 0, new GregorianCalendar(1989,10-1,27), new GregorianCalendar(1989,10-1,27), personas.get(0), automovil);
////       tramitesDAO.registrarPlaca(placa);
    }
    
}
