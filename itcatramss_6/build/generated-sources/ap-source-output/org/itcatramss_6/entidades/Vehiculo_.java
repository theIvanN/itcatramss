package org.itcatramss_6.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.itcatramss_6.entidades.Color;
import org.itcatramss_6.entidades.Mantenimiento;
import org.itcatramss_6.entidades.Marca;
import org.itcatramss_6.entidades.RegistroViaje;
import org.itcatramss_6.entidades.Reserva;
import org.itcatramss_6.entidades.Sucursal;
import org.itcatramss_6.entidades.Tipo;
import org.itcatramss_6.entidades.ValeCombustible;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-25T20:33:11")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, Date> fechaAdquisicion;
    public static volatile ListAttribute<Vehiculo, RegistroViaje> registroViajeList;
    public static volatile ListAttribute<Vehiculo, Sucursal> sucursalList;
    public static volatile ListAttribute<Vehiculo, Mantenimiento> mantenimientoList;
    public static volatile SingularAttribute<Vehiculo, Double> costo;
    public static volatile ListAttribute<Vehiculo, Reserva> reservaList;
    public static volatile ListAttribute<Vehiculo, Tipo> tipoList;
    public static volatile SingularAttribute<Vehiculo, String> idvehiculo;
    public static volatile ListAttribute<Vehiculo, ValeCombustible> valeCombustibleList;
    public static volatile ListAttribute<Vehiculo, Marca> marcaList;
    public static volatile ListAttribute<Vehiculo, Color> colorList;
    public static volatile SingularAttribute<Vehiculo, String> placa;

}