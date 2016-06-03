package org.TFAitcatramss.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Chofer;
import org.TFAitcatramss.entidades.ValeCombustible;
import org.TFAitcatramss.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(RegistroViaje.class)
public class RegistroViaje_ { 

    public static volatile SingularAttribute<RegistroViaje, Date> fechaLlegada;
    public static volatile ListAttribute<RegistroViaje, Vehiculo> vehiculoList;
    public static volatile ListAttribute<RegistroViaje, ValeCombustible> valeCombustibleList;
    public static volatile SingularAttribute<RegistroViaje, String> observacionViaje;
    public static volatile ListAttribute<RegistroViaje, Chofer> choferList;
    public static volatile SingularAttribute<RegistroViaje, String> idregistroViaje;
    public static volatile SingularAttribute<RegistroViaje, Date> fechaIda;

}