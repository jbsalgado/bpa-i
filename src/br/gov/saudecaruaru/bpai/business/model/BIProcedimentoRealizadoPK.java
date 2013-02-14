/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Albuquerque
 */
@XStreamAlias("procedimento_realizado_pk")
@Embeddable
public class BIProcedimentoRealizadoPK implements Serializable{
    
    @XStreamAlias("cnes_unidade")
    @Basic(optional = false)
    @Column(name = "PRD_UID")
    @SerializedName("cnes_unidade")
    @Expose
    private String cnesUnidade;
    
    @XStreamAlias("competencia")
    @Basic(optional = false)
    @Column(name = "PRD_CMP")
    @SerializedName("competencia")
    @Expose
    private String competencia;
    
    @XStreamAlias("cns_profissional")
    @Basic(optional = false)
    @Column(name = "PRD_CNSMED")
    @SerializedName("cns_profissional")
    @Expose
    private String cnsMedico;
    
    @XStreamAlias("cbo_profissional")
    @Column(name = "PRD_CBO")
    @SerializedName("cbo_profissional")
    @Expose
    private String cboMedico;
    
    @XStreamAlias("numero_folha")
    @Basic(optional = false)
    @Column(name = "PRD_FLH")
    @SerializedName("numero_folha")
    @Expose
    private String numeroFolha;
    
    @XStreamAlias("sequencia_folha")
    @Basic(optional = false)
    @Column(name = "PRD_SEQ")
    @SerializedName("sequencia_folha")
    @Expose
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
        this.competencia=procedimentoRealizadoPK.getCompetencia();
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

    /**
     * @return the competencia
     */
    public String getCompetencia() {
        return competencia;
    }

    /**
     * @param competencia the competencia to set
     */
    public void setCompetencia(String competencia) {
        this.competencia = competencia;
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
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (this.cnesUnidade != null ? this.cnesUnidade.hashCode() : 0);
        hash = 53 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        hash = 53 * hash + (this.cnsMedico != null ? this.cnsMedico.hashCode() : 0);
        hash = 53 * hash + (this.cboMedico != null ? this.cboMedico.hashCode() : 0);
        hash = 53 * hash + (this.numeroFolha != null ? this.numeroFolha.hashCode() : 0);
        hash = 53 * hash + (this.sequenciaFolha != null ? this.sequenciaFolha.hashCode() : 0);
        return hash;
    }

   

    @Override
    public String toString() {
        return "BIProcedimentoRealizadoPK{" + "cnesUnidade=" + cnesUnidade + ", cnsMedico=" + cnsMedico + ", cboMedico=" + cboMedico + ", numeroFolha=" + numeroFolha + ", sequenciaFolha=" + sequenciaFolha;
    }
    
    
}
