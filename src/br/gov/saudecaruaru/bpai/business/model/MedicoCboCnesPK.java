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
public class MedicoCboCnesPK implements Serializable {
    
    
    @Basic(optional = false)
    @Column(name = "MED_CNS")
    private String medicoCns;
    @Basic(optional = false)
    @Column(name = "MED_CBO")
    private String medicoCbo;
    @Basic(optional = false)
    @Column(name = "MED_CNES")
    private String medicoCnesUnidade;

    public MedicoCboCnesPK() {
    }

    public MedicoCboCnesPK(String medicoCns, String medicoCbo, String medicoCnesUnidade) {
        this.medicoCns = medicoCns;
        this.medicoCbo = medicoCbo;
        this.medicoCnesUnidade = medicoCnesUnidade;
    }
    
    public MedicoCboCnesPK(Medico medico, String medicoCnesUnidade,String medicoCbo) {
        this.medicoCns=medico.getCns();
        this.medicoCbo=medicoCbo;
        this.medicoCnesUnidade=medicoCnesUnidade;
    }
    
    public String getMedicoCbo() {
        return medicoCbo;
    }

    public void setMedicoCbo(String medicoCbo) {
        this.medicoCbo = medicoCbo;
    }

    public String getMedicoCnesUnidade() {
        return medicoCnesUnidade;
    }

    public void setMedicoCnesUnidade(String medicoCnesUnidade) {
        this.medicoCnesUnidade = medicoCnesUnidade;
    }

    public String getMedicoCns() {
        return medicoCns;
    }

    public void setMedicoCns(String medicoCns) {
        this.medicoCns = medicoCns;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MedicoCboCnesPK other = (MedicoCboCnesPK) obj;
        if ((this.medicoCns == null) ? (other.medicoCns != null) : !this.medicoCns.equals(other.medicoCns)) {
            return false;
        }
        if ((this.medicoCbo == null) ? (other.medicoCbo != null) : !this.medicoCbo.equals(other.medicoCbo)) {
            return false;
        }
        if ((this.medicoCnesUnidade == null) ? (other.medicoCnesUnidade != null) : !this.medicoCnesUnidade.equals(other.medicoCnesUnidade)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.medicoCns != null ? this.medicoCns.hashCode() : 0);
        hash = 59 * hash + (this.medicoCbo != null ? this.medicoCbo.hashCode() : 0);
        hash = 59 * hash + (this.medicoCnesUnidade != null ? this.medicoCnesUnidade.hashCode() : 0);
        return hash;
    }

    
    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.CadmedCboCnesPK[ medCns=" + medicoCns + ", medCbo=" + medicoCbo + ", medCnes=" + medicoCnesUnidade + " ]";
    }
    
}
