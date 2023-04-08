/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.itson.pruebas;

import com.mycompany.plantillapantallasproyecto2basedatosavanzadas.MenuInicio;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.itson.DAO.ParametrosBusquedaPersonas;
import org.itson.DAO.PersonasDAO;
import org.itson.DAO.TramitesDAO;
import org.itson.dominio.Automovil;
import org.itson.dominio.Estado;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.TipoLicencia;
import org.itson.dominio.TipoPlaca;


/**
 *
 * @author julio
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MenuInicio menuInicion = new MenuInicio();
//       PersonasDAO personasDAO = new PersonasDAO();
//       ParametrosBusquedaPersonas params = new ParametrosBusquedaPersonas();
//       params.setRfc("RAMC891027GA");
//       //params.setNombre("Carlos");
//       params.setFechaNacimiento(new GregorianCalendar(1989,10-1,27).getTime());
//       List<Persona> personas = personasDAO.buscar(params);
//        for (Persona persona : personas) {
//            System.out.println(persona.getNombre());   
//        }
//        TramitesDAO tramitesDAO = new TramitesDAO();
////        Licencia licencia = new Licencia(TipoLicencia.normal, Estado.Activo, 1100, new GregorianCalendar(1989,10-1,27), new GregorianCalendar(1989,10-1,27), personas.get(0));
////        tramitesDAO.registrarLicencia(licencia);
//          Automovil automovil = new Automovil("1", "rojo", "azul", "Azul", "Azul", personas.get(0));
//          Placa placa = new Placa(new GregorianCalendar(1989,10-1,27), TipoPlaca.usado, Estado.Activo, 0, new GregorianCalendar(1989,10-1,27), new GregorianCalendar(1989,10-1,27), personas.get(0), automovil);
//       tramitesDAO.registrarPlaca(placa);
    }
    
}
