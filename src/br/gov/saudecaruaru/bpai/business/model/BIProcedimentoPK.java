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
public class BIProcedimentoPK implements Serializable{
    
    
    
    @Basic(optional = false)
    @Column(name = "PA_ID")
    private String id;
    
   
    @Basic(optional = false)
    @Column(name = "PA_CMP")
    private String competencia;

    public BIProcedimentoPK(String id, String competencia) {
        this.id = id;
        this.competencia = competencia;
    }

    public BIProcedimentoPK() {
    }
    
    public BIProcedimentoPK(ProcedimentoPK procedimentoPK){
        this.competencia=procedimentoPK.getCompetencia();
        this.id=procedimentoPK.getId();
    }

    
    
    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BIProcedimentoPK other = (BIProcedimentoPK) obj;
        if ((this.id == null) ? (other.getId() != null) : !this.id.equals(other.getId())) {
            return false;
        }
        if ((this.competencia == null) ? (other.getId() != null) : !this.competencia.equals(other.getCompetencia())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 43 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        return hash;
    }
    
}
