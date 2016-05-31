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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario"),
    @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido1", query = "SELECT u FROM Usuario u WHERE u.apellido1 = :apellido1"),
    @NamedQuery(name = "Usuario.findByApellido2", query = "SELECT u FROM Usuario u WHERE u.apellido2 = :apellido2")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idusuario")
    private String idusuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido1")
    private String apellido1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "apellido2")
    private String apellido2;
    @ManyToMany(mappedBy = "usuarioList")
    private List<IntentoLogin> intentoLoginList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Auditoria> auditoriaList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Reserva> reservaList;
    @JoinTable(name = "vale_combustible_tiene_emisor", joinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")}, inverseJoinColumns = {
        @JoinColumn(name = "vale_combustible_idvale_combustible", referencedColumnName = "idvale_combustible")})
    @ManyToMany
    private List<ValeCombustible> valeCombustibleList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Estado> estadoList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Rol> rolList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Sucursal> sucursalList;
    @ManyToMany(mappedBy = "usuarioList")
    private List<Chofer> choferList;

    public Usuario() {
    }

    public Usuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(String idusuario, String usuario, String password, String nombre, String apellido1, String apellido2) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    @XmlTransient
    public List<IntentoLogin> getIntentoLoginList() {
        return intentoLoginList;
    }

    public void setIntentoLoginList(List<IntentoLogin> intentoLoginList) {
        this.intentoLoginList = intentoLoginList;
    }

    @XmlTransient
    public List<Auditoria> getAuditoriaList() {
        return auditoriaList;
    }

    public void setAuditoriaList(List<Auditoria> auditoriaList) {
        this.auditoriaList = auditoriaList;
    }

    @XmlTransient
    public List<Reserva> getReservaList() {
        return reservaList;
    }

    public void setReservaList(List<Reserva> reservaList) {
        this.reservaList = reservaList;
    }

    @XmlTransient
    public List<ValeCombustible> getValeCombustibleList() {
        return valeCombustibleList;
    }

    public void setValeCombustibleList(List<ValeCombustible> valeCombustibleList) {
        this.valeCombustibleList = valeCombustibleList;
    }

    @XmlTransient
    public List<Estado> getEstadoList() {
        return estadoList;
    }

    public void setEstadoList(List<Estado> estadoList) {
        this.estadoList = estadoList;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Sucursal> getSucursalList() {
        return sucursalList;
    }

    public void setSucursalList(List<Sucursal> sucursalList) {
        this.sucursalList = sucursalList;
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
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.TFAitcatramss.entidades.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
