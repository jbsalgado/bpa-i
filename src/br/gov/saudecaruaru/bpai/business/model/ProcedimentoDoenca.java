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
@Table(name = "S_PACID")
public class ProcedimentoDoenca implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ProcedimentoDoencaPK procedimentoDoencaPK;
    
    @Column(name = "PACID_AUX")
    private Character procedimentoAuxiliar;
    

    public ProcedimentoDoenca() {
    }

    public ProcedimentoDoenca(ProcedimentoDoencaPK procedimentoDoencaPK) {
        this.procedimentoDoencaPK = procedimentoDoencaPK;
    }

    public ProcedimentoDoenca(ProcedimentoDoencaPK procedimentoDoencaPK, Character procedimentoAuxiliar) {
        this.procedimentoDoencaPK = procedimentoDoencaPK;
        this.procedimentoAuxiliar = procedimentoAuxiliar;
    }

    public Character getProcedimentoAuxiliar() {
        return procedimentoAuxiliar;
    }

    public void setProcedimentoAuxiliar(Character procedimentoAuxiliar) {
        this.procedimentoAuxiliar = procedimentoAuxiliar;
    }

    public ProcedimentoDoencaPK getProcedimentoDoencaPK() {
        return procedimentoDoencaPK;
    }

    public void setProcedimentoCidPK(ProcedimentoDoencaPK procedimentoDoencaPK) {
        this.procedimentoDoencaPK = procedimentoDoencaPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoDoenca other = (ProcedimentoDoenca) obj;
        if (this.procedimentoDoencaPK != other.procedimentoDoencaPK && (this.procedimentoDoencaPK == null || !this.procedimentoDoencaPK.equals(other.procedimentoDoencaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.procedimentoDoencaPK != null ? this.procedimentoDoencaPK.hashCode() : 0);
        return hash;
    }

   
    
    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacid[ sPacidPK=" + procedimentoDoencaPK + " ]";
    }
    
}
