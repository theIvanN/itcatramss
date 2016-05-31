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
@Table(name = "mantenimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mantenimiento.findAll", query = "SELECT m FROM Mantenimiento m"),
    @NamedQuery(name = "Mantenimiento.findByIdmantenimiento", query = "SELECT m FROM Mantenimiento m WHERE m.idmantenimiento = :idmantenimiento"),
    @NamedQuery(name = "Mantenimiento.findByNombreTaller", query = "SELECT m FROM Mantenimiento m WHERE m.nombreTaller = :nombreTaller"),
    @NamedQuery(name = "Mantenimiento.findByFechaInicio", query = "SELECT m FROM Mantenimiento m WHERE m.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Mantenimiento.findByFechaEntrega", query = "SELECT m FROM Mantenimiento m WHERE m.fechaEntrega = :fechaEntrega"),
    @NamedQuery(name = "Mantenimiento.findByObservacion", query = "SELECT m FROM Mantenimiento m WHERE m.observacion = :observacion")})
public class Mantenimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idmantenimiento")
    private String idmantenimiento;
    @Size(max = 45)
    @Column(name = "nombre_taller")
    private String nombreTaller;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "observacion")
    private String observacion;
    @JoinTable(name = "vehiculo_tiene_mantenimiento", joinColumns = {
        @JoinColumn(name = "mantenimiento_idmantenimiento", referencedColumnName = "idmantenimiento")}, inverseJoinColumns = {
        @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")})
    @ManyToMany
    private List<Vehiculo> vehiculoList;

    public Mantenimiento() {
    }

    public Mantenimiento(String idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public Mantenimiento(String idmantenimiento, Date fechaInicio, Date fechaEntrega, String observacion) {
        this.idmantenimiento = idmantenimiento;
        this.fechaInicio = fechaInicio;
        this.fechaEntrega = fechaEntrega;
        this.observacion = observacion;
    }

    public String getIdmantenimiento() {
        return idmantenimiento;
    }

    public void setIdmantenimiento(String idmantenimiento) {
        this.idmantenimiento = idmantenimiento;
    }

    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmantenimiento != null ? idmantenimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mantenimiento)) {
            return false;
        }
        Mantenimiento other = (Mantenimiento) object;
        if ((this.idmantenimiento == null && other.idmantenimiento != null) || (this.idmantenimiento != null && !this.idmantenimiento.equals(other.idmantenimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.TFAitcatramss.entidades.Mantenimiento[ idmantenimiento=" + idmantenimiento + " ]";
    }
    
}
