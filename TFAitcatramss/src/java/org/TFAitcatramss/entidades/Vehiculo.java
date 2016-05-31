/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.TFAitcatramss.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lel
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v"),
    @NamedQuery(name = "Vehiculo.findByIdvehiculo", query = "SELECT v FROM Vehiculo v WHERE v.idvehiculo = :idvehiculo"),
    @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa"),
    @NamedQuery(name = "Vehiculo.findByFechaAdquisicion", query = "SELECT v FROM Vehiculo v WHERE v.fechaAdquisicion = :fechaAdquisicion"),
    @NamedQuery(name = "Vehiculo.findByCosto", query = "SELECT v FROM Vehiculo v WHERE v.costo = :costo")})
public class Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idvehiculo")
    private String idvehiculo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "placa")
    private String placa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_adquisicion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAdquisicion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "costo")
    private double costo;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<RegistroViaje> registroViajeList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<Color> colorList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<Reserva> reservaList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<Mantenimiento> mantenimientoList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<Sucursal> sucursalList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<Tipo> tipoList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<Marca> marcaList;
    @ManyToMany(mappedBy = "vehiculoList")
    private List<ValeCombustible> valeCombustibleList;

    public Vehiculo() {
    }

    public Vehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public Vehiculo(String idvehiculo, String placa, Date fechaAdquisicion, double costo) {
        this.idvehiculo = idvehiculo;
        this.placa = placa;
        this.fechaAdquisicion = fechaAdquisicion;
        this.costo = costo;
    }

    public String getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(String idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @XmlTransient
    public List<RegistroViaje> getRegistroViajeList() {
        return registroViajeList;
    }

    public void setRegistroViajeList(List<RegistroViaje> registroViajeList) {
        this.registroViajeList = registroViajeList;
    }

    @XmlTransient
    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @XmlTransient
    public List<Mantenimiento> getMantenimientoList() {
        return mantenimientoList;
    }

    public void setMantenimientoList(List<Mantenimiento> mantenimientoList) {
        this.mantenimientoList = mantenimientoList;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
    }

    @XmlTransient
    public List<Tipo> getTipoList() {
        return tipoList;
    }

    public void setTipoList(List<Tipo> tipoList) {
        this.tipoList = tipoList;
    }

    @XmlTransient
    public List<Marca> getMarcaList() {
        return marcaList;
    }

    public void setMarcaList(List<Marca> marcaList) {
        this.marcaList = marcaList;
    }

    @XmlTransient
    public List<ValeCombustible> getValeCombustibleList() {
        return valeCombustibleList;
    }

    public void setValeCombustibleList(List<ValeCombustible> valeCombustibleList) {
        this.valeCombustibleList = valeCombustibleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehiculo != null ? idvehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.idvehiculo == null && other.idvehiculo != null) || (this.idvehiculo != null && !this.idvehiculo.equals(other.idvehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.TFAitcatramss.entidades.Vehiculo[ idvehiculo=" + idvehiculo + " ]";
    }
    
}
