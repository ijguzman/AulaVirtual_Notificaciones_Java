/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author CORE I7
 */
@Entity
@Table(name = "seg_registro_acceso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRegistroAcceso.findAll", query = "SELECT s FROM SegRegistroAcceso s")
    , @NamedQuery(name = "SegRegistroAcceso.findByCodAcceso", query = "SELECT s FROM SegRegistroAcceso s WHERE s.codAcceso = :codAcceso")
    , @NamedQuery(name = "SegRegistroAcceso.findByTipoAcceso", query = "SELECT s FROM SegRegistroAcceso s WHERE s.tipoAcceso = :tipoAcceso")
    , @NamedQuery(name = "SegRegistroAcceso.findByCodUsuario", query = "SELECT s FROM SegRegistroAcceso s WHERE s.codUsuario = :codUsuario")
    , @NamedQuery(name = "SegRegistroAcceso.findByIp", query = "SELECT s FROM SegRegistroAcceso s WHERE s.ip = :ip")
    , @NamedQuery(name = "SegRegistroAcceso.findByFuncionalidad", query = "SELECT s FROM SegRegistroAcceso s WHERE s.funcionalidad = :funcionalidad")
    , @NamedQuery(name = "SegRegistroAcceso.findByResultado", query = "SELECT s FROM SegRegistroAcceso s WHERE s.resultado = :resultado")
    , @NamedQuery(name = "SegRegistroAcceso.findByFecha", query = "SELECT s FROM SegRegistroAcceso s WHERE s.fecha = :fecha")})
public class SegRegistroAcceso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_ACCESO")
    private Integer codAcceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "TIPO_ACCESO")
    private String tipoAcceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_USUARIO")
    private String codUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "IP")
    private String ip;
    @Size(max = 30)
    @Column(name = "FUNCIONALIDAD")
    private String funcionalidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "RESULTADO")
    private String resultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public SegRegistroAcceso() {
    }

    public SegRegistroAcceso(Integer codAcceso) {
        this.codAcceso = codAcceso;
    }

    public SegRegistroAcceso(Integer codAcceso, String tipoAcceso, String codUsuario, String ip, String resultado, Date fecha) {
        this.codAcceso = codAcceso;
        this.tipoAcceso = tipoAcceso;
        this.codUsuario = codUsuario;
        this.ip = ip;
        this.resultado = resultado;
        this.fecha = fecha;
    }

    public Integer getCodAcceso() {
        return codAcceso;
    }

    public void setCodAcceso(Integer codAcceso) {
        this.codAcceso = codAcceso;
    }

    public String getTipoAcceso() {
        return tipoAcceso;
    }

    public void setTipoAcceso(String tipoAcceso) {
        this.tipoAcceso = tipoAcceso;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAcceso != null ? codAcceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRegistroAcceso)) {
            return false;
        }
        SegRegistroAcceso other = (SegRegistroAcceso) object;
        if ((this.codAcceso == null && other.codAcceso != null) || (this.codAcceso != null && !this.codAcceso.equals(other.codAcceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegRegistroAcceso[ codAcceso=" + codAcceso + " ]";
    }
    
}
