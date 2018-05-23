/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CORE I7
 */
@Entity
@Table(name = "seg_perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPerfil.findAll", query = "SELECT s FROM SegPerfil s")
    , @NamedQuery(name = "SegPerfil.findByCodPerfil", query = "SELECT s FROM SegPerfil s WHERE s.codPerfil = :codPerfil")
    , @NamedQuery(name = "SegPerfil.findByNombre", query = "SELECT s FROM SegPerfil s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegPerfil.findByEstado", query = "SELECT s FROM SegPerfil s WHERE s.estado = :estado")})
public class SegPerfil implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_PERFIL")
    private String codPerfil;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "codPerfil")
    private Collection<SegUsuario> segUsuarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segPerfil")
    private Collection<SegPerfilFuncionalidad> segPerfilFuncionalidadCollection;

    public SegPerfil() {
    }

    public SegPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public SegPerfil(String codPerfil, String nombre, String estado) {
        this.codPerfil = codPerfil;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(String codPerfil) {
        this.codPerfil = codPerfil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<SegUsuario> getSegUsuarioCollection() {
        return segUsuarioCollection;
    }

    public void setSegUsuarioCollection(Collection<SegUsuario> segUsuarioCollection) {
        this.segUsuarioCollection = segUsuarioCollection;
    }

    @XmlTransient
    public Collection<SegPerfilFuncionalidad> getSegPerfilFuncionalidadCollection() {
        return segPerfilFuncionalidadCollection;
    }

    public void setSegPerfilFuncionalidadCollection(Collection<SegPerfilFuncionalidad> segPerfilFuncionalidadCollection) {
        this.segPerfilFuncionalidadCollection = segPerfilFuncionalidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPerfil != null ? codPerfil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfil)) {
            return false;
        }
        SegPerfil other = (SegPerfil) object;
        if ((this.codPerfil == null && other.codPerfil != null) || (this.codPerfil != null && !this.codPerfil.equals(other.codPerfil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegPerfil[ codPerfil=" + codPerfil + " ]";
    }
    
}
