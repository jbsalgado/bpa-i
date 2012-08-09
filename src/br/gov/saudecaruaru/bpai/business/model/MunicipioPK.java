/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Junior Pires
 */
@Embeddable
public class MunicipioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CODUF")
    private String coduf;
    @Basic(optional = false)
    @Column(name = "CODMUNIC")
    private String codmunic;

    public MunicipioPK() {
    }

    public MunicipioPK(String coduf, String codmunic) {
        this.coduf = coduf;
        this.codmunic = codmunic;
    }

    public String getCoduf() {
        return coduf;
    }

    public void setCoduf(String coduf) {
        this.coduf = coduf;
    }

    public String getCodmunic() {
        return codmunic;
    }

    public void setCodmunic(String codmunic) {
        this.codmunic = codmunic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coduf != null ? coduf.hashCode() : 0);
        hash += (codmunic != null ? codmunic.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipioPK)) {
            return false;
        }
        MunicipioPK other = (MunicipioPK) object;
        if ((this.coduf == null && other.coduf != null) || (this.coduf != null && !this.coduf.equals(other.coduf))) {
            return false;
        }
        if ((this.codmunic == null && other.codmunic != null) || (this.codmunic != null && !this.codmunic.equals(other.codmunic))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.CadmunPK[ coduf=" + coduf + ", codmunic=" + codmunic + " ]";
    }
    
}
