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
public class ProcedimentoCBOPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PACBO_PA")
    private String pacboPa;
    @Basic(optional = false)
    @Column(name = "PACBO_CBO")
    private String pacboCbo;

    public ProcedimentoCBOPK() {
    }

    public ProcedimentoCBOPK(String pacboPa, String pacboCbo) {
        this.pacboPa = pacboPa;
        this.pacboCbo = pacboCbo;
    }

    public String getPacboPa() {
        return pacboPa;
    }

    public void setPacboPa(String pacboPa) {
        this.pacboPa = pacboPa;
    }

    public String getPacboCbo() {
        return pacboCbo;
    }

    public void setPacboCbo(String pacboCbo) {
        this.pacboCbo = pacboCbo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacboPa != null ? pacboPa.hashCode() : 0);
        hash += (pacboCbo != null ? pacboCbo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimentoCBOPK)) {
            return false;
        }
        ProcedimentoCBOPK other = (ProcedimentoCBOPK) object;
        if ((this.pacboPa == null && other.pacboPa != null) || (this.pacboPa != null && !this.pacboPa.equals(other.pacboPa))) {
            return false;
        }
        if ((this.pacboCbo == null && other.pacboCbo != null) || (this.pacboCbo != null && !this.pacboCbo.equals(other.pacboCbo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacboPK[ pacboPa=" + pacboPa + ", pacboCbo=" + pacboCbo + " ]";
    }
    
}
