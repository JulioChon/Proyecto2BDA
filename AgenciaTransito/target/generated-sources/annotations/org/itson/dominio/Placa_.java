package org.itson.dominio;

import java.util.Calendar;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itson.dominio.TipoPlaca;
import org.itson.dominio.Vehiculo;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-04-11T23:23:48", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Placa.class)
public class Placa_ extends Tramite_ {

    public static volatile SingularAttribute<Placa, TipoPlaca> tipoPlaca;
    public static volatile SingularAttribute<Placa, String> serie;
    public static volatile SingularAttribute<Placa, Calendar> fechaEntrega;
    public static volatile SingularAttribute<Placa, Vehiculo> vehiculo;

}