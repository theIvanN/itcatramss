package org.TFAitcatramss.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Usuario;
import org.TFAitcatramss.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, String> destino;
    public static volatile SingularAttribute<Reserva, String> nombreEvento;
    public static volatile ListAttribute<Reserva, Vehiculo> vehiculoList;
    public static volatile ListAttribute<Reserva, Usuario> usuarioList;
    public static volatile SingularAttribute<Reserva, String> idreserva;
    public static volatile SingularAttribute<Reserva, Date> fechaReserva;

}