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
public class ProcedimentoProcedimentoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PAPA_CMP")
    private String papaCmp;
    @Basic(optional = false)
    @Column(name = "PAPA_TRAT")
    private String papaTrat;

    public ProcedimentoProcedimentoPK() {
    }

    public ProcedimentoProcedimentoPK(String papaCmp, String papaTrat) {
        this.papaCmp = papaCmp;
        this.papaTrat = papaTrat;
    }

    public String getPapaCmp() {
        return papaCmp;
    }

    public void setPapaCmp(String papaCmp) {
        this.papaCmp = papaCmp;
    }

    public String getPapaTrat() {
        return papaTrat;
    }

    public void setPapaTrat(String papaTrat) {
        this.papaTrat = papaTrat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (papaCmp != null ? papaCmp.hashCode() : 0);
        hash += (papaTrat != null ? papaTrat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimentoProcedimentoPK)) {
            return false;
        }
        ProcedimentoProcedimentoPK other = (ProcedimentoProcedimentoPK) object;
        if ((this.papaCmp == null && other.papaCmp != null) || (this.papaCmp != null && !this.papaCmp.equals(other.papaCmp))) {
            return false;
        }
        if ((this.papaTrat == null && other.papaTrat != null) || (this.papaTrat != null && !this.papaTrat.equals(other.papaTrat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPapaPK[ papaCmp=" + papaCmp + ", papaTrat=" + papaTrat + " ]";
    }
    
}
