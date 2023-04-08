/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.DAO;

import interfaces.ITramite;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import org.itson.dominio.Estado;
import org.itson.dominio.Licencia;
import org.itson.dominio.Placa;
import org.itson.dominio.TipoLicencia;

/**
 *
 * @author julio
 */
public class TramitesDAO implements ITramite {

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
        Date fechaEntrega =  placa.getFechaEntrega().getTime();
        String rfc = placa.getPersona().getRfc();
        storedProcedure.setParameter(1, placa.getVehiculo().getNumeroSerie());
        storedProcedure.setParameter(2, fechaEntrega);
        storedProcedure.setParameter(3, fechaExpedicion);
        storedProcedure.setParameter(4, vigencia);
        storedProcedure.setParameter(5, placa.getTipoPlaca().toString());
        storedProcedure.setParameter(6, rfc);
        storedProcedure.setParameter(7, (float)placa.getCosto());
        storedProcedure.setParameter(8, placa.getEstado().toString());

        storedProcedure.execute();

    }

}
