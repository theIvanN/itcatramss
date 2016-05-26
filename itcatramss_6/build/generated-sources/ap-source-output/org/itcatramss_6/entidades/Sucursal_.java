package org.itcatramss_6.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Usuario;
import org.itcatramss_6.entidades.Vehiculo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Sucursal.class)
public class Sucursal_ { 

    public static volatile ListAttribute<Sucursal, Usuario> usuarioList;
    public static volatile SingularAttribute<Sucursal, String> direccion;
    public static volatile SingularAttribute<Sucursal, String> idsucursal;
    public static volatile SingularAttribute<Sucursal, String> telefono;
    public static volatile ListAttribute<Sucursal, Vehiculo> vehiculoList;

}