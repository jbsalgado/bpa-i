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
    @Column(name = "CTR_ID")
    private String competenciaId;
    
   

    public GestorCompetenciaPK() {
    }

    public GestorCompetenciaPK(String competenciaId) {
        this.competenciaId = competenciaId;
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
        if ((this.competenciaId == null) ? (other.competenciaId != null) : !this.competenciaId.equals(other.competenciaId)) {
            return false;
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.competenciaId != null ? this.competenciaId.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return competenciaId+"=" + competenciaId +'}';
    }

    /**
     * @return the competenciaId
     */
    public String getCompetenciaId() {
        return competenciaId;
    }

    /**
     * @param competenciaId the competenciaId to set
     */
    public void setCompetenciaId(String competenciaId) {
        this.competenciaId = competenciaId;
    }
    
    
    
}
