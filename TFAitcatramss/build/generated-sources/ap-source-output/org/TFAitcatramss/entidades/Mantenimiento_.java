package org.TFAitcatramss.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Mantenimiento.class)
public class Mantenimiento_ { 

    public static volatile ListAttribute<Mantenimiento, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<Mantenimiento, String> observacion;
    public static volatile SingularAttribute<Mantenimiento, String> idmantenimiento;
    public static volatile SingularAttribute<Mantenimiento, String> nombreTaller;
    public static volatile SingularAttribute<Mantenimiento, Date> fechaEntrega;
    public static volatile SingularAttribute<Mantenimiento, Date> fechaInicio;

}