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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "registro_viaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RegistroViaje.findAll", query = "SELECT r FROM RegistroViaje r"),
    @NamedQuery(name = "RegistroViaje.findByIdregistroViaje", query = "SELECT r FROM RegistroViaje r WHERE r.idregistroViaje = :idregistroViaje"),
    @NamedQuery(name = "RegistroViaje.findByFechaIda", query = "SELECT r FROM RegistroViaje r WHERE r.fechaIda = :fechaIda"),
    @NamedQuery(name = "RegistroViaje.findByFechaLlegada", query = "SELECT r FROM RegistroViaje r WHERE r.fechaLlegada = :fechaLlegada"),
    @NamedQuery(name = "RegistroViaje.findByObservacionViaje", query = "SELECT r FROM RegistroViaje r WHERE r.observacionViaje = :observacionViaje")})
public class RegistroViaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idregistro_viaje")
    private String idregistroViaje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ida")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIda;
    @Column(name = "fecha_llegada")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaLlegada;
    @Size(max = 300)
    @Column(name = "observacion_viaje")
    private String observacionViaje;
    @JoinTable(name = "registro_viaje_tiene_vehiculo", joinColumns = {
        @JoinColumn(name = "registro_viaje_idregistro_viaje", referencedColumnName = "idregistro_viaje")}, inverseJoinColumns = {
        @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")})
    @ManyToMany
    private List<Vehiculo> vehiculoList;
    @JoinTable(name = "vale_combustible_tiene_registro_viaje", joinColumns = {
        @JoinColumn(name = "registro_viaje_idregistro_viaje", referencedColumnName = "idregistro_viaje")}, inverseJoinColumns = {
        @JoinColumn(name = "vale_combustible_idvale_combustible", referencedColumnName = "idvale_combustible")})
    @ManyToMany
    private List<ValeCombustible> valeCombustibleList;
    @ManyToMany(mappedBy = "registroViajeList")
    private List<Chofer> choferList;

    public RegistroViaje() {
    }

    public RegistroViaje(String idregistroViaje) {
        this.idregistroViaje = idregistroViaje;
    }

    public RegistroViaje(String idregistroViaje, Date fechaIda) {
        this.idregistroViaje = idregistroViaje;
        this.fechaIda = fechaIda;
    }

    public String getIdregistroViaje() {
        return idregistroViaje;
    }

    public void setIdregistroViaje(String idregistroViaje) {
        this.idregistroViaje = idregistroViaje;
    }

    public Date getFechaIda() {
        return fechaIda;
    }

    public void setFechaIda(Date fechaIda) {
        this.fechaIda = fechaIda;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public String getObservacionViaje() {
        return observacionViaje;
    }

    public void setObservacionViaje(String observacionViaje) {
        this.observacionViaje = observacionViaje;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<ValeCombustible> getValeCombustibleList() {
        return valeCombustibleList;
    }

    public void setValeCombustibleList(List<ValeCombustible> valeCombustibleList) {
        this.valeCombustibleList = valeCombustibleList;
    }

    @XmlTransient
    public List<Chofer> getChoferList() {
        return choferList;
    }

    public void setChoferList(List<Chofer> choferList) {
        this.choferList = choferList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistroViaje != null ? idregistroViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RegistroViaje)) {
            return false;
        }
        RegistroViaje other = (RegistroViaje) object;
        if ((this.idregistroViaje == null && other.idregistroViaje != null) || (this.idregistroViaje != null && !this.idregistroViaje.equals(other.idregistroViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.TFAitcatramss.entidades.RegistroViaje[ idregistroViaje=" + idregistroViaje + " ]";
    }
    
}
