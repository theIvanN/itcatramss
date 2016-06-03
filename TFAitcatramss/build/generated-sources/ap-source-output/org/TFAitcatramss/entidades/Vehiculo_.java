package org.TFAitcatramss.entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.TFAitcatramss.entidades.Color;
import org.TFAitcatramss.entidades.Mantenimiento;
import org.TFAitcatramss.entidades.Marca;
import org.TFAitcatramss.entidades.RegistroViaje;
import org.TFAitcatramss.entidades.Reserva;
import org.TFAitcatramss.entidades.Sucursal;
import org.TFAitcatramss.entidades.Tipo;
import org.TFAitcatramss.entidades.ValeCombustible;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-01T21:48:08")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> idvehiculo;
    public static volatile ListAttribute<Vehiculo, Marca> marcaList;
    public static volatile ListAttribute<Vehiculo, ValeCombustible> valeCombustibleList;
    public static volatile ListAttribute<Vehiculo, Color> colorList;
    public static volatile ListAttribute<Vehiculo, Tipo> tipoList;
    public static volatile SingularAttribute<Vehiculo, String> placa;
    public static volatile ListAttribute<Vehiculo, RegistroViaje> registroViajeList;
    public static volatile ListAttribute<Vehiculo, Mantenimiento> mantenimientoList;
    public static volatile ListAttribute<Vehiculo, Sucursal> sucursalList;
    public static volatile SingularAttribute<Vehiculo, Double> costo;
    public static volatile SingularAttribute<Vehiculo, Date> fechaAdquisicion;
    public static volatile ListAttribute<Vehiculo, Reserva> reservaList;

}