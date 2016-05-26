package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Usuario;
import org.itcatramss_6.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, String> nombreEvento;
    public static volatile ListAttribute<Reserva, Usuario> usuarioList;
    public static volatile SingularAttribute<Reserva, String> idreserva;
    public static volatile SingularAttribute<Reserva, String> destino;
    public static volatile ListAttribute<Reserva, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<Reserva, Date> fechaReserva;

}