package org.TFAitcatramss.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Usuario;
import org.TFAitcatramss.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile ListAttribute<Sucursal, Vehiculo> vehiculoList;
    public static volatile SingularAttribute<Sucursal, String> idsucursal;
    public static volatile ListAttribute<Sucursal, Usuario> usuarioList;
    public static volatile SingularAttribute<Sucursal, String> telefono;

}