package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(IntentoLogin.class)
public class IntentoLogin_ { 

    public static volatile ListAttribute<IntentoLogin, Usuario> usuarioList;
    public static volatile SingularAttribute<IntentoLogin, Date> intentoFecha;
    public static volatile SingularAttribute<IntentoLogin, String> idintentoLogin;

}