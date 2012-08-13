/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "S_PACBO")
public class ProcedimentoCbo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimentoCboPK procedimentoCboPK;
    
    
    @Column(name = "PACBO_AUX")
    private Character procedimentoAuxiliar;

    public ProcedimentoCbo() {
    }

    public ProcedimentoCbo(ProcedimentoCboPK sPacboPK) {
        this.procedimentoCboPK = sPacboPK;
    }

    public Character getProcedimentoAuxiliar() {
        return procedimentoAuxiliar;
    }

    public void setProcedimentoAuxiliar(Character procedimentoAuxiliar) {
        this.procedimentoAuxiliar = procedimentoAuxiliar;
    }

    public ProcedimentoCboPK getProcedimentoCboPK() {
        return procedimentoCboPK;
    }

    public void setProcedimentoCboPK(ProcedimentoCboPK procedimentoCboPK) {
        this.procedimentoCboPK = procedimentoCboPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoCbo other = (ProcedimentoCbo) obj;
        if (this.procedimentoCboPK != other.procedimentoCboPK && (this.procedimentoCboPK == null || !this.procedimentoCboPK.equals(other.procedimentoCboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.procedimentoCboPK != null ? this.procedimentoCboPK.hashCode() : 0);
        return hash;
    }

    

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacbo[ sPacboPK=" + procedimentoCboPK + " ]";
    }
    
}
