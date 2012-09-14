/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Albuquerque
 */
@Embeddable
public class ProcedimentoServicoPK {
    
    @Basic(optional=false)
    @Column(name="PASRV_CMP")
    private String competencia;
    
    @Basic(optional=false)
    @Column(name="PASRV_PA")
    private String codigoProcedimento;
    
    @Basic(optional=false)
    @Column(name="PASRV_SRV")
    private String servico;
    
    @Basic(optional=false)
    @Column(name="PASRV_CSF")
    private String classificacaoServico;
    

    public ProcedimentoServicoPK() {
    }

    public ProcedimentoServicoPK(String competencia, String codigoProcedimento, String servico, String classificacaoServico) {
        this.competencia = competencia;
        this.codigoProcedimento = codigoProcedimento;
        this.servico = servico;
        this.classificacaoServico = classificacaoServico;
    }

    public String getClassificacaoServico() {
        return classificacaoServico;
    }

    public void setClassificacaoServico(String classificacaoServico) {
        this.classificacaoServico = classificacaoServico;
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

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoServicoPK other = (ProcedimentoServicoPK) obj;
        if ((this.competencia == null) ? (other.competencia != null) : !this.competencia.equals(other.competencia)) {
            return false;
        }
        if ((this.codigoProcedimento == null) ? (other.codigoProcedimento != null) : !this.codigoProcedimento.equals(other.codigoProcedimento)) {
            return false;
        }
        if ((this.servico == null) ? (other.servico != null) : !this.servico.equals(other.servico)) {
            return false;
        }
        if ((this.classificacaoServico == null) ? (other.classificacaoServico != null) : !this.classificacaoServico.equals(other.classificacaoServico)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        hash = 79 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
        hash = 79 * hash + (this.servico != null ? this.servico.hashCode() : 0);
        hash = 79 * hash + (this.classificacaoServico != null ? this.classificacaoServico.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ProcedimentoServicoPK{" + "competencia=" + competencia + ", codigoProcedimento=" + codigoProcedimento + ", servico=" + servico + ", classificacaoServico=" + classificacaoServico + '}';
    }
    
    
}
