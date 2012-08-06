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
public class ProcedimentoCIDPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PACID_PA")
    private String pacidPa;
    @Basic(optional = false)
    @Column(name = "PACID_CID")
    private String pacidCid;

    public ProcedimentoCIDPK() {
    }

    public ProcedimentoCIDPK(String pacidPa, String pacidCid) {
        this.pacidPa = pacidPa;
        this.pacidCid = pacidCid;
    }

    public String getPacidPa() {
        return pacidPa;
    }

    public void setPacidPa(String pacidPa) {
        this.pacidPa = pacidPa;
    }

    public String getPacidCid() {
        return pacidCid;
    }

    public void setPacidCid(String pacidCid) {
        this.pacidCid = pacidCid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacidPa != null ? pacidPa.hashCode() : 0);
        hash += (pacidCid != null ? pacidCid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimentoCIDPK)) {
            return false;
        }
        ProcedimentoCIDPK other = (ProcedimentoCIDPK) object;
        if ((this.pacidPa == null && other.pacidPa != null) || (this.pacidPa != null && !this.pacidPa.equals(other.pacidPa))) {
            return false;
        }
        if ((this.pacidCid == null && other.pacidCid != null) || (this.pacidCid != null && !this.pacidCid.equals(other.pacidCid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacidPK[ pacidPa=" + pacidPa + ", pacidCid=" + pacidCid + " ]";
    }
    
}
