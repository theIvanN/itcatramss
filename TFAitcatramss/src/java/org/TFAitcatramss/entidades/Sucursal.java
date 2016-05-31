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
@Table(name = "sucursal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursal.findAll", query = "SELECT s FROM Sucursal s"),
    @NamedQuery(name = "Sucursal.findByIdsucursal", query = "SELECT s FROM Sucursal s WHERE s.idsucursal = :idsucursal"),
    @NamedQuery(name = "Sucursal.findByDireccion", query = "SELECT s FROM Sucursal s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "Sucursal.findByTelefono", query = "SELECT s FROM Sucursal s WHERE s.telefono = :telefono")})
public class Sucursal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idsucursal")
    private String idsucursal;
    @Size(max = 200)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @JoinTable(name = "vehiculo_tiene_sucursal", joinColumns = {
        @JoinColumn(name = "sucursal_idsucursal", referencedColumnName = "idsucursal")}, inverseJoinColumns = {
        @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")})
    @ManyToMany
    private List<Vehiculo> vehiculoList;
    @JoinTable(name = "usuario_tiene_sucursal", joinColumns = {
        @JoinColumn(name = "sucursal_idsucursal", referencedColumnName = "idsucursal")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany
    private List<Usuario> usuarioList;

    public Sucursal() {
    }

    public Sucursal(String idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getIdsucursal() {
        return idsucursal;
    }

    public void setIdsucursal(String idsucursal) {
        this.idsucursal = idsucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsucursal != null ? idsucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sucursal)) {
            return false;
        }
        Sucursal other = (Sucursal) object;
        if ((this.idsucursal == null && other.idsucursal != null) || (this.idsucursal != null && !this.idsucursal.equals(other.idsucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.TFAitcatramss.entidades.Sucursal[ idsucursal=" + idsucursal + " ]";
    }
    
}
