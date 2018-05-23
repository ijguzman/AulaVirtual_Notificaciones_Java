/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CORE I7
 */
@Entity
@Table(name = "seg_perfil_funcionalidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPerfilFuncionalidad.findAll", query = "SELECT s FROM SegPerfilFuncionalidad s")
    , @NamedQuery(name = "SegPerfilFuncionalidad.findByCodPerfil", query = "SELECT s FROM SegPerfilFuncionalidad s WHERE s.segPerfilFuncionalidadPK.codPerfil = :codPerfil")
    , @NamedQuery(name = "SegPerfilFuncionalidad.findByCodModulo", query = "SELECT s FROM SegPerfilFuncionalidad s WHERE s.segPerfilFuncionalidadPK.codModulo = :codModulo")
    , @NamedQuery(name = "SegPerfilFuncionalidad.findBySecFuncionalidad", query = "SELECT s FROM SegPerfilFuncionalidad s WHERE s.segPerfilFuncionalidadPK.secFuncionalidad = :secFuncionalidad")
    , @NamedQuery(name = "SegPerfilFuncionalidad.findByEstado", query = "SELECT s FROM SegPerfilFuncionalidad s WHERE s.estado = :estado")})
public class SegPerfilFuncionalidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegPerfilFuncionalidadPK segPerfilFuncionalidadPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumns({
        @JoinColumn(name = "COD_MODULO", referencedColumnName = "COD_MODULO", insertable = false, updatable = false)
        , @JoinColumn(name = "SEC_FUNCIONALIDAD", referencedColumnName = "SEC_FUNCIONALIDAD", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private SegFuncionalidad segFuncionalidad;
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private SegPerfil segPerfil;

    public SegPerfilFuncionalidad() {
    }

    public SegPerfilFuncionalidad(SegPerfilFuncionalidadPK segPerfilFuncionalidadPK) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
    }

    public SegPerfilFuncionalidad(SegPerfilFuncionalidadPK segPerfilFuncionalidadPK, String estado) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
        this.estado = estado;
    }

    public SegPerfilFuncionalidad(String codPerfil, String codModulo, int secFuncionalidad) {
        this.segPerfilFuncionalidadPK = new SegPerfilFuncionalidadPK(codPerfil, codModulo, secFuncionalidad);
    }

    public SegPerfilFuncionalidadPK getSegPerfilFuncionalidadPK() {
        return segPerfilFuncionalidadPK;
    }

    public void setSegPerfilFuncionalidadPK(SegPerfilFuncionalidadPK segPerfilFuncionalidadPK) {
        this.segPerfilFuncionalidadPK = segPerfilFuncionalidadPK;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public SegFuncionalidad getSegFuncionalidad() {
        return segFuncionalidad;
    }

    public void setSegFuncionalidad(SegFuncionalidad segFuncionalidad) {
        this.segFuncionalidad = segFuncionalidad;
    }

    public SegPerfil getSegPerfil() {
        return segPerfil;
    }

    public void setSegPerfil(SegPerfil segPerfil) {
        this.segPerfil = segPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segPerfilFuncionalidadPK != null ? segPerfilFuncionalidadPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPerfilFuncionalidad)) {
            return false;
        }
        SegPerfilFuncionalidad other = (SegPerfilFuncionalidad) object;
        if ((this.segPerfilFuncionalidadPK == null && other.segPerfilFuncionalidadPK != null) || (this.segPerfilFuncionalidadPK != null && !this.segPerfilFuncionalidadPK.equals(other.segPerfilFuncionalidadPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegPerfilFuncionalidad[ segPerfilFuncionalidadPK=" + segPerfilFuncionalidadPK + " ]";
    }
    
}
