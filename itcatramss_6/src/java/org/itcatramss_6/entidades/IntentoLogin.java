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
@Table(name = "intento_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IntentoLogin.findAll", query = "SELECT i FROM IntentoLogin i"),
    @NamedQuery(name = "IntentoLogin.findByIdintentoLogin", query = "SELECT i FROM IntentoLogin i WHERE i.idintentoLogin = :idintentoLogin"),
    @NamedQuery(name = "IntentoLogin.findByIntentoFecha", query = "SELECT i FROM IntentoLogin i WHERE i.intentoFecha = :intentoFecha")})
public class IntentoLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idintento_login")
    private String idintentoLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intento_fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intentoFecha;
    @JoinTable(name = "usuario_e_intento_login", joinColumns = {
        @JoinColumn(name = "intento_login_idintento_login", referencedColumnName = "idintento_login")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany
    private List<Usuario> usuarioList;

    public IntentoLogin() {
    }

    public IntentoLogin(String idintentoLogin) {
        this.idintentoLogin = idintentoLogin;
    }

    public IntentoLogin(String idintentoLogin, Date intentoFecha) {
        this.idintentoLogin = idintentoLogin;
        this.intentoFecha = intentoFecha;
    }

    public String getIdintentoLogin() {
        return idintentoLogin;
    }

    public void setIdintentoLogin(String idintentoLogin) {
        this.idintentoLogin = idintentoLogin;
    }

    public Date getIntentoFecha() {
        return intentoFecha;
    }

    public void setIntentoFecha(Date intentoFecha) {
        this.intentoFecha = intentoFecha;
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
        hash += (idintentoLogin != null ? idintentoLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IntentoLogin)) {
            return false;
        }
        IntentoLogin other = (IntentoLogin) object;
        if ((this.idintentoLogin == null && other.idintentoLogin != null) || (this.idintentoLogin != null && !this.idintentoLogin.equals(other.idintentoLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itcatramss_6.entidades.IntentoLogin[ idintentoLogin=" + idintentoLogin + " ]";
    }
    
}
