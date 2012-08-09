/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "CADMED_CBO_CNES")
public class MedicoCboCnes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MedicoCboCnesPK medicoCboCnesPK;

    public MedicoCboCnes() {
    }

    public MedicoCboCnes(MedicoCboCnesPK cadmedCboCnesPK) {
        this.medicoCboCnesPK = cadmedCboCnesPK;
    }

    public MedicoCboCnes(String medicoCns, String medicoCbo, String medicoCnesUnidade) {
        this.medicoCboCnesPK = new MedicoCboCnesPK(medicoCns, medicoCbo, medicoCnesUnidade);
    }

    public MedicoCboCnesPK getMedicoCboCnesPK() {
        return medicoCboCnesPK;
    }

    public void setMedicoCboCnesPK(MedicoCboCnesPK medicoCboCnesPK) {
        this.medicoCboCnesPK = medicoCboCnesPK;
    }

    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicoCboCnesPK != null ? medicoCboCnesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicoCboCnes)) {
            return false;
        }
        MedicoCboCnes other = (MedicoCboCnes) object;
        if ((this.medicoCboCnesPK == null && other.medicoCboCnesPK != null) || (this.medicoCboCnesPK != null && !this.medicoCboCnesPK.equals(other.medicoCboCnesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.CadmedCboCnes[ cadmedCboCnesPK=" + medicoCboCnesPK + " ]";
    }
    
}
