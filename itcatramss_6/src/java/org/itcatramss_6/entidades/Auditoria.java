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
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a"),
    @NamedQuery(name = "Auditoria.findByIdauditoria", query = "SELECT a FROM Auditoria a WHERE a.idauditoria = :idauditoria"),
    @NamedQuery(name = "Auditoria.findByFecha", query = "SELECT a FROM Auditoria a WHERE a.fecha = :fecha"),
    @NamedQuery(name = "Auditoria.findByDescripcion", query = "SELECT a FROM Auditoria a WHERE a.descripcion = :descripcion")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idauditoria")
    private String idauditoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinTable(name = "usuario_y_auditoria", joinColumns = {
        @JoinColumn(name = "auditoria_idauditoria", referencedColumnName = "idauditoria")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany
    private List<Usuario> usuarioList;

    public Auditoria() {
    }

    public Auditoria(String idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Auditoria(String idauditoria, Date fecha, String descripcion) {
        this.idauditoria = idauditoria;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public String getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(String idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (idauditoria != null ? idauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itcatramss_6.entidades.Auditoria[ idauditoria=" + idauditoria + " ]";
    }
    
}
