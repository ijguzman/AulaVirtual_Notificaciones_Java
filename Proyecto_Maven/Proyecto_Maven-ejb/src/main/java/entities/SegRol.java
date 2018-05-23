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
@Table(name = "seg_rol")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRol.findAll", query = "SELECT s FROM SegRol s")
    , @NamedQuery(name = "SegRol.findByCodRol", query = "SELECT s FROM SegRol s WHERE s.codRol = :codRol")
    , @NamedQuery(name = "SegRol.findByNombre", query = "SELECT s FROM SegRol s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegRol.findByEstado", query = "SELECT s FROM SegRol s WHERE s.estado = :estado")})
public class SegRol implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "COD_ROL")
    private String codRol;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segRol")
    private Collection<SegRolPersona> segRolPersonaCollection;

    public SegRol() {
    }

    public SegRol(String codRol) {
        this.codRol = codRol;
    }

    public SegRol(String codRol, String nombre, String estado) {
        this.codRol = codRol;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCodRol() {
        return codRol;
    }

    public void setCodRol(String codRol) {
        this.codRol = codRol;
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
    public Collection<SegRolPersona> getSegRolPersonaCollection() {
        return segRolPersonaCollection;
    }

    public void setSegRolPersonaCollection(Collection<SegRolPersona> segRolPersonaCollection) {
        this.segRolPersonaCollection = segRolPersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRol)) {
            return false;
        }
        SegRol other = (SegRol) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegRol[ codRol=" + codRol + " ]";
    }
    
}
