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

    public BIProcedimentoRealizadoPK() {
    }
    
    public BIProcedimentoRealizadoPK(ProcedimentoRealizadoPK procedimentoRealizadoPK) {
       this.setProcedimentoRealizadoPk(procedimentoRealizadoPK);
    }
    
    private void setProcedimentoRealizadoPk(ProcedimentoRealizadoPK procedimentoRealizadoPK){
         this.cboMedico=procedimentoRealizadoPK.getCboMedico();
        this.cnesUnidade=procedimentoRealizadoPK.getCnesUnidade();
        this.cnsMedico=procedimentoRealizadoPK.getCnsMedico();
        this.numeroFolha=procedimentoRealizadoPK.getNumeroFolha();
        this.sequenciaFolha=procedimentoRealizadoPK.getSequenciaFolha();
    }
    
    public ProcedimentoRealizadoPK getProcedimentoRealizadoPK(){
        return new ProcedimentoRealizadoPK(this);
    }
    
    public BIProcedimentoRealizadoPK(String cnesUnidade, String competencia, String cnsMedico, String cboMedico, String numeroFolha, String sequenciaFolha, String codigoProcedimento, String dataAtendimento) {
        this.cnesUnidade = cnesUnidade;
        this.cnsMedico = cnsMedico;
        this.cboMedico = cboMedico;
        this.numeroFolha = numeroFolha;
        this.sequenciaFolha = sequenciaFolha;
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
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.cnesUnidade != null ? this.cnesUnidade.hashCode() : 0);
        hash = 89 * hash + (this.cnsMedico != null ? this.cnsMedico.hashCode() : 0);
        hash = 89 * hash + (this.cboMedico != null ? this.cboMedico.hashCode() : 0);
        hash = 89 * hash + (this.numeroFolha != null ? this.numeroFolha.hashCode() : 0);
        hash = 89 * hash + (this.sequenciaFolha != null ? this.sequenciaFolha.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BIProcedimentoRealizadoPK{" + "cnesUnidade=" + cnesUnidade + ", cnsMedico=" + cnsMedico + ", cboMedico=" + cboMedico + ", numeroFolha=" + numeroFolha + ", sequenciaFolha=" + sequenciaFolha;
    }
    
    
}
