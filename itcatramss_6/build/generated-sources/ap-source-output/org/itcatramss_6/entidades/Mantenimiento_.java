package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Mantenimiento.class)
public class Mantenimiento_ { 

    public static volatile SingularAttribute<Mantenimiento, String> nombreTaller;
    public static volatile SingularAttribute<Mantenimiento, Date> fechaInicio;
    public static volatile SingularAttribute<Mantenimiento, String> idmantenimiento;
    public static volatile SingularAttribute<Mantenimiento, Date> fechaEntrega;
    public static volatile SingularAttribute<Mantenimiento, String> observacion;
    public static volatile ListAttribute<Mantenimiento, Vehiculo> vehiculoList;

}