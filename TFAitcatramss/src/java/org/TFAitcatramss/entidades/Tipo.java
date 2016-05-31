/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.TFAitcatramss.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lel
 */
@Entity
@Table(name = "tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t"),
    @NamedQuery(name = "Tipo.findByIdtipo", query = "SELECT t FROM Tipo t WHERE t.idtipo = :idtipo"),
    @NamedQuery(name = "Tipo.findByNombreTipo", query = "SELECT t FROM Tipo t WHERE t.nombreTipo = :nombreTipo")})
public class Tipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idtipo")
    private String idtipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre_tipo")
    private String nombreTipo;
    @JoinTable(name = "vehiculo_tiene_tipo", joinColumns = {
        @JoinColumn(name = "tipo_idtipo", referencedColumnName = "idtipo")}, inverseJoinColumns = {
        @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")})
    @ManyToMany
    private List<Vehiculo> vehiculoList;

    public Tipo() {
    }

    public Tipo(String idtipo) {
        this.idtipo = idtipo;
    }

    public Tipo(String idtipo, String nombreTipo) {
        this.idtipo = idtipo;
        this.nombreTipo = nombreTipo;
    }

    public String getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(String idtipo) {
        this.idtipo = idtipo;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
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
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.TFAitcatramss.entidades.Tipo[ idtipo=" + idtipo + " ]";
    }
    
}
