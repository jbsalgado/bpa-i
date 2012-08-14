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
    protected ProcedimentoDoencaPK procedimentoCidPK;
    
    @Column(name = "PACID_AUX")
    private Character procedimentoAuxiliar;
    

    public ProcedimentoDoenca() {
    }

    public ProcedimentoDoenca(ProcedimentoDoencaPK procedimentoCidPK) {
        this.procedimentoCidPK = procedimentoCidPK;
    }

    public ProcedimentoDoenca(ProcedimentoDoencaPK procedimentoCidPK, Character procedimentoAuxiliar) {
        this.procedimentoCidPK = procedimentoCidPK;
        this.procedimentoAuxiliar = procedimentoAuxiliar;
    }

    public Character getProcedimentoAuxiliar() {
        return procedimentoAuxiliar;
    }

    public void setProcedimentoAuxiliar(Character procedimentoAuxiliar) {
        this.procedimentoAuxiliar = procedimentoAuxiliar;
    }

    public ProcedimentoDoencaPK getProcedimentoCidPK() {
        return procedimentoCidPK;
    }

    public void setProcedimentoCidPK(ProcedimentoDoencaPK procedimentoCidPK) {
        this.procedimentoCidPK = procedimentoCidPK;
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
        if (this.procedimentoCidPK != other.procedimentoCidPK && (this.procedimentoCidPK == null || !this.procedimentoCidPK.equals(other.procedimentoCidPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.procedimentoCidPK != null ? this.procedimentoCidPK.hashCode() : 0);
        return hash;
    }

   
    
    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacid[ sPacidPK=" + procedimentoCidPK + " ]";
    }
    
}
