package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Chofer;
import org.itcatramss_6.entidades.RegistroViaje;
import org.itcatramss_6.entidades.Usuario;
import org.itcatramss_6.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(ValeCombustible.class)
public class ValeCombustible_ { 

    public static volatile ListAttribute<ValeCombustible, RegistroViaje> registroViajeList;
    public static volatile ListAttribute<ValeCombustible, Chofer> choferList;
    public static volatile ListAttribute<ValeCombustible, Usuario> usuarioList;
    public static volatile SingularAttribute<ValeCombustible, Double> valor;
    public static volatile SingularAttribute<ValeCombustible, Date> fechaEmision;
    public static volatile SingularAttribute<ValeCombustible, String> idvaleCombustible;
    public static volatile ListAttribute<ValeCombustible, Vehiculo> vehiculoList;

}