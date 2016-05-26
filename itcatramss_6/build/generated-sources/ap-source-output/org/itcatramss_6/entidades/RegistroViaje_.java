package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Chofer;
import org.itcatramss_6.entidades.ValeCombustible;
import org.itcatramss_6.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(RegistroViaje.class)
public class RegistroViaje_ { 

    public static volatile ListAttribute<RegistroViaje, Chofer> choferList;
    public static volatile SingularAttribute<RegistroViaje, Date> fechaLlegada;
    public static volatile SingularAttribute<RegistroViaje, Date> fechaIda;
    public static volatile ListAttribute<RegistroViaje, ValeCombustible> valeCombustibleList;
    public static volatile SingularAttribute<RegistroViaje, String> idregistroViaje;
    public static volatile ListAttribute<RegistroViaje, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<RegistroViaje, String> observacionViaje;

}