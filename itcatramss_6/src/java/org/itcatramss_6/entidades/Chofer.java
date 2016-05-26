/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.itcatramss_6.entidades;

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
@Table(name = "chofer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chofer.findAll", query = "SELECT c FROM Chofer c"),
    @NamedQuery(name = "Chofer.findByIdchofer", query = "SELECT c FROM Chofer c WHERE c.idchofer = :idchofer"),
    @NamedQuery(name = "Chofer.findByLicencia", query = "SELECT c FROM Chofer c WHERE c.licencia = :licencia"),
    @NamedQuery(name = "Chofer.findByPasaporte", query = "SELECT c FROM Chofer c WHERE c.pasaporte = :pasaporte")})
public class Chofer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "idchofer")
    private String idchofer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "licencia")
    private String licencia;
    @Size(max = 45)
    @Column(name = "pasaporte")
    private String pasaporte;
    @JoinTable(name = "vale_combustible_tiene_chofer", joinColumns = {
        @JoinColumn(name = "chofer_idchofer", referencedColumnName = "idchofer")}, inverseJoinColumns = {
        @JoinColumn(name = "vale_combustible_idvale_combustible", referencedColumnName = "idvale_combustible")})
    @ManyToMany
    private List<ValeCombustible> valeCombustibleList;
    @JoinTable(name = "registro_viaje_tiene_chofer", joinColumns = {
        @JoinColumn(name = "chofer_idchofer", referencedColumnName = "idchofer")}, inverseJoinColumns = {
        @JoinColumn(name = "registro_viaje_idregistro_viaje", referencedColumnName = "idregistro_viaje")})
    @ManyToMany
    private List<RegistroViaje> registroViajeList;
    @JoinTable(name = "usuario_y_chofer", joinColumns = {
        @JoinColumn(name = "chofer_idchofer", referencedColumnName = "idchofer")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idusuario", referencedColumnName = "idusuario")})
    @ManyToMany
    private List<Usuario> usuarioList;

    public Chofer() {
    }

    public Chofer(String idchofer) {
        this.idchofer = idchofer;
    }

    public Chofer(String idchofer, String licencia) {
        this.idchofer = idchofer;
        this.licencia = licencia;
    }

    public String getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(String idchofer) {
        this.idchofer = idchofer;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    @XmlTransient
    public List<ValeCombustible> getValeCombustibleList() {
        return valeCombustibleList;
    }

    public void setValeCombustibleList(List<ValeCombustible> valeCombustibleList) {
        this.valeCombustibleList = valeCombustibleList;
    }

    @XmlTransient
    public List<RegistroViaje> getRegistroViajeList() {
        return registroViajeList;
    }

    public void setRegistroViajeList(List<RegistroViaje> registroViajeList) {
        this.registroViajeList = registroViajeList;
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
        hash += (idchofer != null ? idchofer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chofer)) {
            return false;
        }
        Chofer other = (Chofer) object;
        if ((this.idchofer == null && other.idchofer != null) || (this.idchofer != null && !this.idchofer.equals(other.idchofer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.itcatramss_6.entidades.Chofer[ idchofer=" + idchofer + " ]";
    }
    
}
