/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name="S_PASRV")
public class ProcedimentoServico implements Serializable{
    
    private static final long serialVersionUID = -1324L;
    @EmbeddedId
    private ProcedimentoServicoPK procedimentoServicoPK;
    
    @Column(name="PASRV_AUX")
    private Character temAuxiliar;

    public ProcedimentoServico() {
    }

    public ProcedimentoServico(ProcedimentoServicoPK procedimentoServicoPK) {
        this.procedimentoServicoPK = procedimentoServicoPK;
    }

    public ProcedimentoServico(ProcedimentoServicoPK procedimentoServicoPK, Character temAuxiliar) {
        this.procedimentoServicoPK = procedimentoServicoPK;
        this.temAuxiliar = temAuxiliar;
    }

    public ProcedimentoServicoPK getProcedimentoServicoPK() {
        return procedimentoServicoPK;
    }

    public void setProcedimentoServicoPK(ProcedimentoServicoPK procedimentoServicoPK) {
        this.procedimentoServicoPK = procedimentoServicoPK;
    }

    public Character getTemAuxiliar() {
        return temAuxiliar;
    }

    public void setTemAuxiliar(Character temAuxiliar) {
        this.temAuxiliar = temAuxiliar;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoServico other = (ProcedimentoServico) obj;
        if (this.procedimentoServicoPK != other.procedimentoServicoPK && (this.procedimentoServicoPK == null || !this.procedimentoServicoPK.equals(other.procedimentoServicoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.procedimentoServicoPK != null ? this.procedimentoServicoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ProcedimentoServico{" + "procedimentoServicoPK=" + procedimentoServicoPK + ", temAuxiliar=" + temAuxiliar + '}';
    }
    
    
}
