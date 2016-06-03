package org.TFAitcatramss.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Chofer;
import org.TFAitcatramss.entidades.RegistroViaje;
import org.TFAitcatramss.entidades.Usuario;
import org.TFAitcatramss.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(ValeCombustible.class)
public class ValeCombustible_ { 

    public static volatile ListAttribute<ValeCombustible, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<ValeCombustible, Double> valor;
    public static volatile ListAttribute<ValeCombustible, Usuario> usuarioList;
    public static volatile SingularAttribute<ValeCombustible, String> idvaleCombustible;
    public static volatile SingularAttribute<ValeCombustible, Date> fechaEmision;
    public static volatile ListAttribute<ValeCombustible, RegistroViaje> registroViajeList;
    public static volatile ListAttribute<ValeCombustible, Chofer> choferList;

}