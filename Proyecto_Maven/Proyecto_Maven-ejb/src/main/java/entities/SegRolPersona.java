/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CORE I7
 */
@Entity
@Table(name = "seg_rol_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRolPersona.findAll", query = "SELECT s FROM SegRolPersona s")
    , @NamedQuery(name = "SegRolPersona.findByCodRol", query = "SELECT s FROM SegRolPersona s WHERE s.segRolPersonaPK.codRol = :codRol")
    , @NamedQuery(name = "SegRolPersona.findByCodUsuario", query = "SELECT s FROM SegRolPersona s WHERE s.segRolPersonaPK.codUsuario = :codUsuario")
    , @NamedQuery(name = "SegRolPersona.findByCodPersona", query = "SELECT s FROM SegRolPersona s WHERE s.segRolPersonaPK.codPersona = :codPersona")})
public class SegRolPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegRolPersonaPK segRolPersonaPK;
    @JoinColumn(name = "COD_ROL", referencedColumnName = "COD_ROL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegRol segRol;
    @JoinColumn(name = "COD_USUARIO", referencedColumnName = "COD_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegUsuario segUsuario;

    public SegRolPersona() {
    }

    public SegRolPersona(SegRolPersonaPK segRolPersonaPK) {
        this.segRolPersonaPK = segRolPersonaPK;
    }

    public SegRolPersona(String codRol, String codUsuario, String codPersona) {
        this.segRolPersonaPK = new SegRolPersonaPK(codRol, codUsuario, codPersona);
    }

    public SegRolPersonaPK getSegRolPersonaPK() {
        return segRolPersonaPK;
    }

    public void setSegRolPersonaPK(SegRolPersonaPK segRolPersonaPK) {
        this.segRolPersonaPK = segRolPersonaPK;
    }

    public SegRol getSegRol() {
        return segRol;
    }

    public void setSegRol(SegRol segRol) {
        this.segRol = segRol;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segRolPersonaPK != null ? segRolPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRolPersona)) {
            return false;
        }
        SegRolPersona other = (SegRolPersona) object;
        if ((this.segRolPersonaPK == null && other.segRolPersonaPK != null) || (this.segRolPersonaPK != null && !this.segRolPersonaPK.equals(other.segRolPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegRolPersona[ segRolPersonaPK=" + segRolPersonaPK + " ]";
    }
    
}
