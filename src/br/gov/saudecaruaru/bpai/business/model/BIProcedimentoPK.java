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
    @Column(name = "PA_DV")
    private char digitoVerificador;
   
   

    public BIProcedimentoPK(String id, char digitoVerificador) {
        this.id = id;
        this.digitoVerificador = digitoVerificador;
    }

    public BIProcedimentoPK() {
    }
    
    public BIProcedimentoPK(Procedimento procedimento){
        this.digitoVerificador = procedimento.getDigitoVerificador();
        this.id=procedimento.getProcedimentoPk().getId();
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
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if (this.digitoVerificador != other.digitoVerificador) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 17 * hash + this.digitoVerificador;
        return hash;
    }

  
    
}
