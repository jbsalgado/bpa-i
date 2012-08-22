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
public class BIProcedimentoRealizadoPK implements Serializable{
    
    @Basic(optional = false)
    @Column(name = "PRD_UID")
    private String cnesUnidade;
    
    @Basic(optional = false)
    @Column(name = "PRD_CMP")
    private String competencia;
    
    @Basic(optional = false)
    @Column(name = "PRD_CNSMED")
    private String cnsMedico;
    
    @Column(name = "PRD_CBO")
    private String cboMedico;
    
    @Basic(optional = false)
    @Column(name = "PRD_FLH")
    private String numeroFolha;
    
    @Basic(optional = false)
    @Column(name = "PRD_SEQ")
    private String sequenciaFolha;
    
    @Basic(optional = false)
    @Column(name = "PRD_PA")
    private String codigoProcedimento;
    
    
    @Basic(optional = false)
    @Column(name = "PRD_DTATEN")
    private String dataAtendimento;

    public BIProcedimentoRealizadoPK() {
    }
    
    public BIProcedimentoRealizadoPK(ProcedimentoRealizadoPK procedimentoRealizadoPK) {
       this.setProcedimentoRealizadoPk(procedimentoRealizadoPK);
    }
    
    private void setProcedimentoRealizadoPk(ProcedimentoRealizadoPK procedimentoRealizadoPK){
         this.cboMedico=procedimentoRealizadoPK.getCboMedico();
        this.cnesUnidade=procedimentoRealizadoPK.getCnesUnidade();
        this.cnsMedico=procedimentoRealizadoPK.getCnsMedico();
        this.codigoProcedimento=procedimentoRealizadoPK.getCodigoProcedimento();
        this.competencia=procedimentoRealizadoPK.getCompetencia();
        this.dataAtendimento=procedimentoRealizadoPK.getDataAtendimento();
        this.numeroFolha=procedimentoRealizadoPK.getNumeroFolha();
        this.sequenciaFolha=procedimentoRealizadoPK.getSequenciaFolha();
    }
    
    public BIProcedimentoRealizadoPK(String cnesUnidade, String competencia, String cnsMedico, String cboMedico, String numeroFolha, String sequenciaFolha, String codigoProcedimento, String dataAtendimento) {
        this.cnesUnidade = cnesUnidade;
        this.competencia = competencia;
        this.cnsMedico = cnsMedico;
        this.cboMedico = cboMedico;
        this.numeroFolha = numeroFolha;
        this.sequenciaFolha = sequenciaFolha;
        this.codigoProcedimento = codigoProcedimento;
        this.dataAtendimento = dataAtendimento;
    }

    public String getCboMedico() {
        return cboMedico;
    }

    public void setCboMedico(String cboMedico) {
        this.cboMedico = cboMedico;
    }

    public String getCnesUnidade() {
        return cnesUnidade;
    }

    public void setCnesUnidade(String cnesUnidade) {
        this.cnesUnidade = cnesUnidade;
    }

    public String getCnsMedico() {
        return cnsMedico;
    }

    public void setCnsMedico(String cnsMedico) {
        this.cnsMedico = cnsMedico;
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

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getNumeroFolha() {
        return numeroFolha;
    }

    public void setNumeroFolha(String numeroFolha) {
        this.numeroFolha = numeroFolha;
    }

    public String getSequenciaFolha() {
        return sequenciaFolha;
    }

    public void setSequenciaFolha(String sequenciaFolha) {
        this.sequenciaFolha = sequenciaFolha;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BIProcedimentoRealizadoPK other = (BIProcedimentoRealizadoPK) obj;
        if ((this.cnesUnidade == null) ? (other.cnesUnidade != null) : !this.cnesUnidade.equals(other.cnesUnidade)) {
            return false;
        }
        if ((this.competencia == null) ? (other.competencia != null) : !this.competencia.equals(other.competencia)) {
            return false;
        }
        if ((this.cnsMedico == null) ? (other.cnsMedico != null) : !this.cnsMedico.equals(other.cnsMedico)) {
            return false;
        }
        if ((this.cboMedico == null) ? (other.cboMedico != null) : !this.cboMedico.equals(other.cboMedico)) {
            return false;
        }
        if ((this.numeroFolha == null) ? (other.numeroFolha != null) : !this.numeroFolha.equals(other.numeroFolha)) {
            return false;
        }
        if ((this.sequenciaFolha == null) ? (other.sequenciaFolha != null) : !this.sequenciaFolha.equals(other.sequenciaFolha)) {
            return false;
        }
        if ((this.codigoProcedimento == null) ? (other.codigoProcedimento != null) : !this.codigoProcedimento.equals(other.codigoProcedimento)) {
            return false;
        }
        if ((this.dataAtendimento == null) ? (other.dataAtendimento != null) : !this.dataAtendimento.equals(other.dataAtendimento)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.cnesUnidade != null ? this.cnesUnidade.hashCode() : 0);
        hash = 89 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        hash = 89 * hash + (this.cnsMedico != null ? this.cnsMedico.hashCode() : 0);
        hash = 89 * hash + (this.cboMedico != null ? this.cboMedico.hashCode() : 0);
        hash = 89 * hash + (this.numeroFolha != null ? this.numeroFolha.hashCode() : 0);
        hash = 89 * hash + (this.sequenciaFolha != null ? this.sequenciaFolha.hashCode() : 0);
        hash = 89 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
        hash = 89 * hash + (this.dataAtendimento != null ? this.dataAtendimento.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BIProcedimentoRealizadoPK{" + "cnesUnidade=" + cnesUnidade + ", competencia=" + competencia + ", cnsMedico=" + cnsMedico + ", cboMedico=" + cboMedico + ", numeroFolha=" + numeroFolha + ", sequenciaFolha=" + sequenciaFolha + ", codigoProcedimento=" + codigoProcedimento + ", dataAtendimento=" + dataAtendimento + '}';
    }
    
    
}
