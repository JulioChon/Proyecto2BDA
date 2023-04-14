/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import org.itson.DAO.ParametrosReportes;
import org.itson.dominio.Licencia;
import org.itson.dominio.Persona;
import org.itson.dominio.Placa;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;



/**
 *
 * @author julio
 */
public interface ITramiteDAO {
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
    /**
     * Metodo que busca las licencias registradas segun la persona de la licencia.
     * @param persona persona de la cual buscaran las licencias
     * @return lista de licencias.
     */
    List<Licencia> buscarLicencias(Persona persona);
    /**
     * Metodo que busca las placas registradas segun el vehiculo que las posee.
     * @param vehiculo vehiculo de la cual buscaran las placas
     * @return lista de placas.
     */
    List<Placa> buscarPlacas(Vehiculo vehiculo);
    /**
     * Metodo que busca las placas registradas segun la serie de la placa.
     * @param serie serie de la cual buscaran las placas
     * @return lista de placas.
     */
    List<Placa> buscarPlacas(String serie);
    /**
     * Metodo que busca las licencias registradas y aun vigentes segun la persona de la licencia.
     * @param persona persona de la cual buscaran las licencias
     * @return lista de licencias.
     */
    List<Licencia> buscarLicenciasVigentes(Persona persona);
    /**
     * Metodo que busca los tramites registrados segun la persona del tramite y una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @param persona persona de la cual buscaran los tramites
     * @return lista de tramites.
     */
    List<Tramite> buscar(ParametrosReportes params, Persona persona);
    /**
     * Metodo que busca las placas registradas segun la persona del placa y una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @param persona persona de la cual buscaran las placas.
     * @return lista de placas.
     */
    List<Placa> buscarPlacas(ParametrosReportes params, Persona persona);
    /**
     * Metodo que busca las licencias registradas segun la persona del licencia y una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @param persona persona de la cual buscaran las licencias.
     * @return lista de licencias.
     */
    List<Licencia> buscarLicencias(ParametrosReportes params, Persona persona);
    /**
     * Metodo que busca los tramites registrados segun una serie de parametros.
     * @param params parametros que se usaran en la busqueda.
     * @return lista de tramites.
     */
    List<Tramite> buscar(ParametrosReportes params);
    /**
     * Metodo que busca las placas registradas segun la persona que las registro.
     * @param persona persona de la cual buscaran las placas
     * @return lista de placas.
     */
    List<Placa> buscarPlacas(Persona persona);
}
