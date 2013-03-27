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
 * @author Albuquerque
 */
@Embeddable
public class GestorCompetenciaPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "CTR_MVM")
    private String competenciaMovimento;
    
    
    
   

    public GestorCompetenciaPK() {
    }

    public GestorCompetenciaPK(String competenciaMovimento) {
        this.competenciaMovimento = competenciaMovimento;
    }

    /**
     * @return the competenciaMovimento
     */
    public String getCompetenciaMovimento() {
        return competenciaMovimento;
    }

    /**
     * @param competenciaMovimento the competenciaMovimento to set
     */
    public void setCompetenciaMovimento(String competenciaMovimento) {
        this.competenciaMovimento = competenciaMovimento;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GestorCompetenciaPK other = (GestorCompetenciaPK) obj;
        if ((this.competenciaMovimento == null) ? (other.competenciaMovimento != null) : !this.competenciaMovimento.equals(other.competenciaMovimento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.competenciaMovimento != null ? this.competenciaMovimento.hashCode() : 0);
        return hash;
    }

   
    
   
    
    
}
