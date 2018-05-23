/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author CORE I7
 */
@Embeddable
public class SegFuncionalidadPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_MODULO")
    private String codModulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SEC_FUNCIONALIDAD")
    private int secFuncionalidad;

    public SegFuncionalidadPK() {
    }

    public SegFuncionalidadPK(String codModulo, int secFuncionalidad) {
        this.codModulo = codModulo;
        this.secFuncionalidad = secFuncionalidad;
    }

    public String getCodModulo() {
        return codModulo;
    }

    public void setCodModulo(String codModulo) {
        this.codModulo = codModulo;
    }

    public int getSecFuncionalidad() {
        return secFuncionalidad;
    }

    public void setSecFuncionalidad(int secFuncionalidad) {
        this.secFuncionalidad = secFuncionalidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codModulo != null ? codModulo.hashCode() : 0);
        hash += (int) secFuncionalidad;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegFuncionalidadPK)) {
            return false;
        }
        SegFuncionalidadPK other = (SegFuncionalidadPK) object;
        if ((this.codModulo == null && other.codModulo != null) || (this.codModulo != null && !this.codModulo.equals(other.codModulo))) {
            return false;
        }
        if (this.secFuncionalidad != other.secFuncionalidad) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.SegFuncionalidadPK[ codModulo=" + codModulo + ", secFuncionalidad=" + secFuncionalidad + " ]";
    }
    
}
