/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */

@Embeddable
public class ProcedimentoPK implements Serializable{
    
    
    
    @Basic(optional = false)
    @Column(name = "PA_ID")
    private String id;
    
   
    @Basic(optional = false)
    @Column(name = "PA_CMP")
    private String competencia;

    public ProcedimentoPK(String id, String competencia) {
        this.id = id;
        this.competencia = competencia;
    }

    public ProcedimentoPK() {
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
        final ProcedimentoPK other = (ProcedimentoPK) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.competencia == null) ? (other.competencia != null) : !this.competencia.equals(other.competencia)) {
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
