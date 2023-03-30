package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.Tramite;
import org.itson.dominio.Vehiculo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-29T20:59:43", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apellidoPaterno;
    public static volatile ListAttribute<Persona, Tramite> listaTramites;
    public static volatile SingularAttribute<Persona, Calendar> fechaNacimiento;
    public static volatile ListAttribute<Persona, Vehiculo> listaVehiculos;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, String> rfc;
    public static volatile SingularAttribute<Persona, String> apellidoMaterno;

}