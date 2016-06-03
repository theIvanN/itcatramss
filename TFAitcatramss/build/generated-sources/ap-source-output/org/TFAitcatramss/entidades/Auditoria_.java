package org.TFAitcatramss.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Usuario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Auditoria.class)
public class Auditoria_ { 

    public static volatile SingularAttribute<Auditoria, Date> fecha;
    public static volatile ListAttribute<Auditoria, Usuario> usuarioList;
    public static volatile SingularAttribute<Auditoria, String> descripcion;
    public static volatile SingularAttribute<Auditoria, String> idauditoria;

}