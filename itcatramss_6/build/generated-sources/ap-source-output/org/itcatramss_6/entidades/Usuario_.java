package org.itcatramss_6.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Auditoria;
import org.itcatramss_6.entidades.Chofer;
import org.itcatramss_6.entidades.Estado;
import org.itcatramss_6.entidades.IntentoLogin;
import org.itcatramss_6.entidades.Reserva;
import org.itcatramss_6.entidades.Rol;
import org.itcatramss_6.entidades.Sucursal;
import org.itcatramss_6.entidades.ValeCombustible;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> apellido2;
    public static volatile ListAttribute<Usuario, Estado> estadoList;
    public static volatile SingularAttribute<Usuario, String> apellido1;
    public static volatile ListAttribute<Usuario, Auditoria> auditoriaList;
    public static volatile ListAttribute<Usuario, ValeCombustible> valeCombustibleList;
    public static volatile ListAttribute<Usuario, Rol> rolList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> idusuario;
    public static volatile ListAttribute<Usuario, Sucursal> sucursalList;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile ListAttribute<Usuario, Chofer> choferList;
    public static volatile ListAttribute<Usuario, Reserva> reservaList;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile ListAttribute<Usuario, IntentoLogin> intentoLoginList;

}