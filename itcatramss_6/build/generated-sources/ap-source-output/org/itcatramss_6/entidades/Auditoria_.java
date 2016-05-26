package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ { 

    public static volatile SingularAttribute<Auditoria, String> descripcion;
    public static volatile SingularAttribute<Auditoria, Date> fecha;
    public static volatile ListAttribute<Auditoria, Usuario> usuarioList;
    public static volatile SingularAttribute<Auditoria, String> idauditoria;

}