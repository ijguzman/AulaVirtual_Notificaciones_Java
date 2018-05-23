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
@Table(name = "seg_modulo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegModulo.findAll", query = "SELECT s FROM SegModulo s")
    , @NamedQuery(name = "SegModulo.findByCodModulo", query = "SELECT s FROM SegModulo s WHERE s.codModulo = :codModulo")
    , @NamedQuery(name = "SegModulo.findByNombre", query = "SELECT s FROM SegModulo s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegModulo.findByEstado", query = "SELECT s FROM SegModulo s WHERE s.estado = :estado")})
public class SegModulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_MODULO")
    private String codModulo;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segModulo")
    private Collection<SegFuncionalidad> segFuncionalidadCollection;

    public SegModulo() {
    }

    public SegModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public SegModulo(String codModulo, String nombre, String estado) {
        this.codModulo = codModulo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
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
    public Collection<SegFuncionalidad> getSegFuncionalidadCollection() {
        return segFuncionalidadCollection;
    }

    public void setSegFuncionalidadCollection(Collection<SegFuncionalidad> segFuncionalidadCollection) {
        this.segFuncionalidadCollection = segFuncionalidadCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegModulo)) {
            return false;
        }
        SegModulo other = (SegModulo) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegModulo[ codModulo=" + codModulo + " ]";
    }
    
}
