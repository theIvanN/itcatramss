/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itcatramss_6.entidades;

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
@Table(name = "vale_combustible")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ValeCombustible.findAll", query = "SELECT v FROM ValeCombustible v"),
    @NamedQuery(name = "ValeCombustible.findByIdvaleCombustible", query = "SELECT v FROM ValeCombustible v WHERE v.idvaleCombustible = :idvaleCombustible"),
    @NamedQuery(name = "ValeCombustible.findByValor", query = "SELECT v FROM ValeCombustible v WHERE v.valor = :valor"),
    @NamedQuery(name = "ValeCombustible.findByFechaEmision", query = "SELECT v FROM ValeCombustible v WHERE v.fechaEmision = :fechaEmision")})
public class ValeCombustible implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idvale_combustible")
    private String idvaleCombustible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Column(name = "fecha_emision")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEmision;
    @ManyToMany(mappedBy = "valeCombustibleList")
    private List<RegistroViaje> registroViajeList;
    @ManyToMany(mappedBy = "valeCombustibleList")
    private List<Chofer> choferList;
    @ManyToMany(mappedBy = "valeCombustibleList")
    private List<Usuario> usuarioList;
    @JoinTable(name = "vale_combustible_tiene_vehiculo", joinColumns = {
        @JoinColumn(name = "vale_combustible_idvale_combustible", referencedColumnName = "idvale_combustible")}, inverseJoinColumns = {
        @JoinColumn(name = "vehiculo_idvehiculo", referencedColumnName = "idvehiculo")})
    @ManyToMany
    private List<Vehiculo> vehiculoList;

    public ValeCombustible() {
    }

    public ValeCombustible(String idvaleCombustible) {
        this.idvaleCombustible = idvaleCombustible;
    }

    public ValeCombustible(String idvaleCombustible, double valor) {
        this.idvaleCombustible = idvaleCombustible;
        this.valor = valor;
    }

    public String getIdvaleCombustible() {
        return idvaleCombustible;
    }

    public void setIdvaleCombustible(String idvaleCombustible) {
        this.idvaleCombustible = idvaleCombustible;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @XmlTransient
    public List<RegistroViaje> getRegistroViajeList() {
        return registroViajeList;
    }

    public void setRegistroViajeList(List<RegistroViaje> registroViajeList) {
        this.registroViajeList = registroViajeList;
    }

    @XmlTransient
    public List<Chofer> getChoferList() {
        return choferList;
    }

    public void setChoferList(List<Chofer> choferList) {
        this.choferList = choferList;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        hash += (idvaleCombustible != null ? idvaleCombustible.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ValeCombustible)) {
            return false;
        }
        ValeCombustible other = (ValeCombustible) object;
        if ((this.idvaleCombustible == null && other.idvaleCombustible != null) || (this.idvaleCombustible != null && !this.idvaleCombustible.equals(other.idvaleCombustible))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itcatramss_6.entidades.ValeCombustible[ idvaleCombustible=" + idvaleCombustible + " ]";
    }
    
}
