/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

/**
 *
 * @author Albuquerque
 */

@Embeddable
public class ProcedimentoRegraPK implements Serializable{
    
    @Basic(optional=false)
    @Column( name= "REG_PA")
    private String codigoProcedimento;
    
    @Basic(optional=false)
    @Column( name= "REG_REGRA")
    private String regra;
    
    @Basic(optional=false)
    @Column( name= "REG_CMP")
    private String competencia;

    public ProcedimentoRegraPK() {
    }

    public ProcedimentoRegraPK(String codigoProcedimento, String regra, String competencia) {
        this.codigoProcedimento = codigoProcedimento;
        this.regra = regra;
        this.competencia = competencia;
    }

    public String getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(String codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getRegra() {
        return regra;
    }

    public void setRegra(String regra) {
        this.regra = regra;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoRegraPK other = (ProcedimentoRegraPK) obj;
        if ((this.codigoProcedimento == null) ? (other.codigoProcedimento != null) : !this.codigoProcedimento.equals(other.codigoProcedimento)) {
            return false;
        }
        if ((this.regra == null) ? (other.regra != null) : !this.regra.equals(other.regra)) {
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
        hash = 41 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
        hash = 41 * hash + (this.regra != null ? this.regra.hashCode() : 0);
        hash = 41 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ProcedimentoRegraPK{" + "codigoProcedimento=" + codigoProcedimento + ", regra=" + regra + ", competencia=" + competencia + '}';
    }
    
    
}
