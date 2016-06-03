package org.TFAitcatramss.entidades;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Auditoria;
import org.TFAitcatramss.entidades.Chofer;
import org.TFAitcatramss.entidades.Estado;
import org.TFAitcatramss.entidades.IntentoLogin;
import org.TFAitcatramss.entidades.Reserva;
import org.TFAitcatramss.entidades.Rol;
import org.TFAitcatramss.entidades.Sucursal;
import org.TFAitcatramss.entidades.ValeCombustible;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile ListAttribute<Usuario, Estado> estadoList;
    public static volatile ListAttribute<Usuario, IntentoLogin> intentoLoginList;
    public static volatile SingularAttribute<Usuario, String> apellido2;
    public static volatile SingularAttribute<Usuario, String> idusuario;
    public static volatile SingularAttribute<Usuario, String> usuario;
    public static volatile SingularAttribute<Usuario, String> apellido1;
    public static volatile SingularAttribute<Usuario, String> password;
    public static volatile ListAttribute<Usuario, Auditoria> auditoriaList;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, ValeCombustible> valeCombustibleList;
    public static volatile ListAttribute<Usuario, Rol> rolList;
    public static volatile ListAttribute<Usuario, Sucursal> sucursalList;
    public static volatile ListAttribute<Usuario, Reserva> reservaList;
    public static volatile ListAttribute<Usuario, Chofer> choferList;

}