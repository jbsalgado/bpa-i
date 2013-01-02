/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */

@Entity
@Table(name="S_PAREGR")
public class ProcedimentoRegra implements Serializable{
    
    @EmbeddedId
    private ProcedimentoRegraPK procedimentoRegraPK;

    public ProcedimentoRegra() {
    }

    public ProcedimentoRegra(ProcedimentoRegraPK procedimentoRegraPK) {
        this.procedimentoRegraPK = procedimentoRegraPK;
    }

    public ProcedimentoRegraPK getProcedimentoRegraPK() {
        return procedimentoRegraPK;
    }

    public void setProcedimentoRegraPK(ProcedimentoRegraPK procedimentoRegraPK) {
        this.procedimentoRegraPK = procedimentoRegraPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoRegra other = (ProcedimentoRegra) obj;
        if (this.procedimentoRegraPK != other.procedimentoRegraPK && (this.procedimentoRegraPK == null || !this.procedimentoRegraPK.equals(other.procedimentoRegraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.procedimentoRegraPK != null ? this.procedimentoRegraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ProcedimentoRegra{" + "procedimentoRegraPK=" + procedimentoRegraPK + '}';
    }
    
    

    
    
}
