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
public class MedicoCBOCNSPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "MED_CNS")
    private String medCns;
    @Basic(optional = false)
    @Column(name = "MED_CBO")
    private String medCbo;
    @Basic(optional = false)
    @Column(name = "MED_CNES")
    private String medCnes;

    public MedicoCBOCNSPK() {
    }

    public MedicoCBOCNSPK(String medCns, String medCbo, String medCnes) {
        this.medCns = medCns;
        this.medCbo = medCbo;
        this.medCnes = medCnes;
    }

    public String getMedCns() {
        return medCns;
    }

    public void setMedCns(String medCns) {
        this.medCns = medCns;
    }

    public String getMedCbo() {
        return medCbo;
    }

    public void setMedCbo(String medCbo) {
        this.medCbo = medCbo;
    }

    public String getMedCnes() {
        return medCnes;
    }

    public void setMedCnes(String medCnes) {
        this.medCnes = medCnes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medCns != null ? medCns.hashCode() : 0);
        hash += (medCbo != null ? medCbo.hashCode() : 0);
        hash += (medCnes != null ? medCnes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicoCBOCNSPK)) {
            return false;
        }
        MedicoCBOCNSPK other = (MedicoCBOCNSPK) object;
        if ((this.medCns == null && other.medCns != null) || (this.medCns != null && !this.medCns.equals(other.medCns))) {
            return false;
        }
        if ((this.medCbo == null && other.medCbo != null) || (this.medCbo != null && !this.medCbo.equals(other.medCbo))) {
            return false;
        }
        if ((this.medCnes == null && other.medCnes != null) || (this.medCnes != null && !this.medCnes.equals(other.medCnes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.CadmedCboCnesPK[ medCns=" + medCns + ", medCbo=" + medCbo + ", medCnes=" + medCnes + " ]";
    }
    
}
