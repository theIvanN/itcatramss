package org.itcatramss_6.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.RegistroViaje;
import org.itcatramss_6.entidades.Usuario;
import org.itcatramss_6.entidades.ValeCombustible;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Chofer.class)
public class Chofer_ { 

    public static volatile ListAttribute<Chofer, RegistroViaje> registroViajeList;
    public static volatile SingularAttribute<Chofer, String> idchofer;
    public static volatile SingularAttribute<Chofer, String> licencia;
    public static volatile ListAttribute<Chofer, Usuario> usuarioList;
    public static volatile SingularAttribute<Chofer, String> pasaporte;
    public static volatile ListAttribute<Chofer, ValeCombustible> valeCombustibleList;

}