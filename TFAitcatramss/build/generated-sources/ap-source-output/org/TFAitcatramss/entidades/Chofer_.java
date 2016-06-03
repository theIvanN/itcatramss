package org.TFAitcatramss.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.RegistroViaje;
import org.TFAitcatramss.entidades.Usuario;
import org.TFAitcatramss.entidades.ValeCombustible;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Chofer.class)
public class Chofer_ { 

    public static volatile SingularAttribute<Chofer, String> licencia;
    public static volatile SingularAttribute<Chofer, String> idchofer;
    public static volatile ListAttribute<Chofer, ValeCombustible> valeCombustibleList;
    public static volatile ListAttribute<Chofer, Usuario> usuarioList;
    public static volatile ListAttribute<Chofer, RegistroViaje> registroViajeList;
    public static volatile SingularAttribute<Chofer, String> pasaporte;

}