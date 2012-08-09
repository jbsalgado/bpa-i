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
 * @author Junior Pires
 */
@Embeddable
public class ProcedimentoCboPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "PACBO_PA")
    private String procedimentoCodigo;
    
    @Basic(optional = false)
    @Column(name = "PACBO_CBO")
    private String codigoCbo;
    
    @Basic(optional = false)
    @Column(name = "PACBO_CMP")
    private String competencia;

    public ProcedimentoCboPK() {
    }

    public ProcedimentoCboPK(String procedimentoCodigo, String codigoCbo, String competencia) {
        this.procedimentoCodigo = procedimentoCodigo;
        this.codigoCbo = codigoCbo;
        this.competencia = competencia;
    }

    public ProcedimentoCboPK(Procedimento procedimento, String codigoCbo, String competencia) {
        this.procedimentoCodigo = procedimento.getProcedimentoPk().getId();
        this.codigoCbo = codigoCbo;
        this.competencia = competencia;
    }    
    public String getCodigoCbo() {
        return codigoCbo;
    }

    public void setCodigoCbo(String codigoCbo) {
        this.codigoCbo = codigoCbo;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getProcedimentoCodigo() {
        return procedimentoCodigo;
    }

    public void setProcedimentoCodigo(String procedimentoCodigo) {
        this.procedimentoCodigo = procedimentoCodigo;
    }
    
    public void setProcedimentoCodigo(Procedimento procedimento) {
        this.procedimentoCodigo = procedimento.getProcedimentoPk().getId();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoCboPK other = (ProcedimentoCboPK) obj;
        if ((this.procedimentoCodigo == null) ? (other.procedimentoCodigo != null) : !this.procedimentoCodigo.equals(other.procedimentoCodigo)) {
            return false;
        }
        if ((this.codigoCbo == null) ? (other.codigoCbo != null) : !this.codigoCbo.equals(other.codigoCbo)) {
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
        hash = 79 * hash + (this.procedimentoCodigo != null ? this.procedimentoCodigo.hashCode() : 0);
        hash = 79 * hash + (this.codigoCbo != null ? this.codigoCbo.hashCode() : 0);
        hash = 79 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        return hash;
    }
    

    
    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacboPK[ pacboPa=" + procedimentoCodigo + ", pacboCbo=" + codigoCbo + " ]";
    }
    
}
