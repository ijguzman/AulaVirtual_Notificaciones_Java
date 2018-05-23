/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author CORE I7
 */
@Entity
@Table(name = "seg_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s")
    , @NamedQuery(name = "SegUsuario.findByCodUsuario", query = "SELECT s FROM SegUsuario s WHERE s.codUsuario = :codUsuario")
    , @NamedQuery(name = "SegUsuario.findByCorreoElectronico", query = "SELECT s FROM SegUsuario s WHERE s.correoElectronico = :correoElectronico")
    , @NamedQuery(name = "SegUsuario.findByNombre", query = "SELECT s FROM SegUsuario s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "SegUsuario.findByClave", query = "SELECT s FROM SegUsuario s WHERE s.clave = :clave")
    , @NamedQuery(name = "SegUsuario.findByEstado", query = "SELECT s FROM SegUsuario s WHERE s.estado = :estado")
    , @NamedQuery(name = "SegUsuario.findByFechaCreacion", query = "SELECT s FROM SegUsuario s WHERE s.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "SegUsuario.findByIntentosErroneos", query = "SELECT s FROM SegUsuario s WHERE s.intentosErroneos = :intentosErroneos")
    , @NamedQuery(name = "SegUsuario.findByFechaUltimoAcceso", query = "SELECT s FROM SegUsuario s WHERE s.fechaUltimoAcceso = :fechaUltimoAcceso")})
public class SegUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_USUARIO")
    private String codUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 120)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "CLAVE")
    private String clave;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INTENTOS_ERRONEOS")
    private short intentosErroneos;
    @Column(name = "FECHA_ULTIMO_ACCESO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaUltimoAcceso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario")
    private Collection<SegRolPersona> segRolPersonaCollection;
    @JoinColumn(name = "COD_PERFIL", referencedColumnName = "COD_PERFIL")
    @ManyToOne
    private SegPerfil codPerfil;

    public SegUsuario() {
    }

    public SegUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public SegUsuario(String codUsuario, String correoElectronico, String nombre, String clave, String estado, Date fechaCreacion, short intentosErroneos) {
        this.codUsuario = codUsuario;
        this.correoElectronico = correoElectronico;
        this.nombre = nombre;
        this.clave = clave;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.intentosErroneos = intentosErroneos;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public short getIntentosErroneos() {
        return intentosErroneos;
    }

    public void setIntentosErroneos(short intentosErroneos) {
        this.intentosErroneos = intentosErroneos;
    }

    public Date getFechaUltimoAcceso() {
        return fechaUltimoAcceso;
    }

    public void setFechaUltimoAcceso(Date fechaUltimoAcceso) {
        this.fechaUltimoAcceso = fechaUltimoAcceso;
    }

    @XmlTransient
    public Collection<SegRolPersona> getSegRolPersonaCollection() {
        return segRolPersonaCollection;
    }

    public void setSegRolPersonaCollection(Collection<SegRolPersona> segRolPersonaCollection) {
        this.segRolPersonaCollection = segRolPersonaCollection;
    }

    public SegPerfil getCodPerfil() {
        return codPerfil;
    }

    public void setCodPerfil(SegPerfil codPerfil) {
        this.codPerfil = codPerfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegUsuario[ codUsuario=" + codUsuario + " ]";
    }
    
}
