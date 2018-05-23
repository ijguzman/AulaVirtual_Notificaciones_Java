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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "seg_funcionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegFuncionalidad.findAll", query = "SELECT s FROM SegFuncionalidad s")
    , @NamedQuery(name = "SegFuncionalidad.findByCodModulo", query = "SELECT s FROM SegFuncionalidad s WHERE s.segFuncionalidadPK.codModulo = :codModulo")
    , @NamedQuery(name = "SegFuncionalidad.findBySecFuncionalidad", query = "SELECT s FROM SegFuncionalidad s WHERE s.segFuncionalidadPK.secFuncionalidad = :secFuncionalidad")
    , @NamedQuery(name = "SegFuncionalidad.findByNombre", query = "SELECT s FROM SegFuncionalidad s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegFuncionalidad.findByUrl", query = "SELECT s FROM SegFuncionalidad s WHERE s.url = :url")
    , @NamedQuery(name = "SegFuncionalidad.findByEstado", query = "SELECT s FROM SegFuncionalidad s WHERE s.estado = :estado")})
public class SegFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegFuncionalidadPK segFuncionalidadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segFuncionalidad")
    private Collection<SegPerfilFuncionalidad> segPerfilFuncionalidadCollection;
    @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegModulo segModulo;

    public SegFuncionalidad() {
    }

    public SegFuncionalidad(SegFuncionalidadPK segFuncionalidadPK) {
        this.segFuncionalidadPK = segFuncionalidadPK;
    }

    public SegFuncionalidad(SegFuncionalidadPK segFuncionalidadPK, String nombre, String url, String estado) {
        this.segFuncionalidadPK = segFuncionalidadPK;
        this.nombre = nombre;
        this.url = url;
        this.estado = estado;
    }

    public SegFuncionalidad(String codModulo, int secFuncionalidad) {
        this.segFuncionalidadPK = new SegFuncionalidadPK(codModulo, secFuncionalidad);
    }

    public SegFuncionalidadPK getSegFuncionalidadPK() {
        return segFuncionalidadPK;
    }

    public void setSegFuncionalidadPK(SegFuncionalidadPK segFuncionalidadPK) {
        this.segFuncionalidadPK = segFuncionalidadPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<SegPerfilFuncionalidad> getSegPerfilFuncionalidadCollection() {
        return segPerfilFuncionalidadCollection;
    }

    public void setSegPerfilFuncionalidadCollection(Collection<SegPerfilFuncionalidad> segPerfilFuncionalidadCollection) {
        this.segPerfilFuncionalidadCollection = segPerfilFuncionalidadCollection;
    }

    public SegModulo getSegModulo() {
        return segModulo;
    }

    public void setSegModulo(SegModulo segModulo) {
        this.segModulo = segModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segFuncionalidadPK != null ? segFuncionalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegFuncionalidad)) {
            return false;
        }
        SegFuncionalidad other = (SegFuncionalidad) object;
        if ((this.segFuncionalidadPK == null && other.segFuncionalidadPK != null) || (this.segFuncionalidadPK != null && !this.segFuncionalidadPK.equals(other.segFuncionalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegFuncionalidad[ segFuncionalidadPK=" + segFuncionalidadPK + " ]";
    }
    
}
