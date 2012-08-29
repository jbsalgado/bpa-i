/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import br.gov.saudecaruaru.bpai.gui.validators.DataAtendimentoVerifier;
import java.io.Serializable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Albuquerque
 */

@Embeddable
public class ProcedimentoRealizadoPK implements Serializable,Cloneable{
    
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

    public ProcedimentoRealizadoPK(String cnesUnidade, String competencia, String cnsMedico, String cboMedico, String numeroFolha, String sequenciaFolha, String codigoProcedimento, String dataAtendimento) {
        this.cnesUnidade = cnesUnidade;
        this.competencia = competencia;
        this.cnsMedico = cnsMedico;
        this.cboMedico = cboMedico;
        this.numeroFolha = numeroFolha;
        this.sequenciaFolha = sequenciaFolha;
        this.codigoProcedimento = codigoProcedimento;
        this.dataAtendimento = dataAtendimento;
    }
    
    public ProcedimentoRealizadoPK(MedicoCboCnes medicoCboCnes, Procedimento procedimento, String competencia,String numeroFolha,String sequenciaFolha,String dataAtendimento){
        this.cboMedico=medicoCboCnes.getMedicoCboCnesPK().getMedicoCbo();
        this.cnesUnidade=medicoCboCnes.getMedicoCboCnesPK().getMedicoCnesUnidade();
        this.cnsMedico=medicoCboCnes.getMedicoCboCnesPK().getMedicoCns();
        this.codigoProcedimento=procedimento.getProcedimentoPk().getId();
        this.competencia=competencia;
        this.numeroFolha = numeroFolha;
        this.sequenciaFolha = sequenciaFolha;
        this.dataAtendimento = dataAtendimento;
    
    }
     public ProcedimentoRealizadoPK() {
    }
     
     
    public ProcedimentoRealizadoPK(String sequencia,String cnes,String cnsProfissional,String cbo,String competencia,String folha) {
        this.sequenciaFolha = sequencia;
        this.cnesUnidade = cnes;
        this.cnsMedico = cnsProfissional;
        this.cboMedico = cbo;
        this.competencia = competencia;
        this.numeroFolha = folha;
    
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
        final ProcedimentoRealizadoPK other = (ProcedimentoRealizadoPK) obj;
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
        int hash = 5;
        hash = 47 * hash + (this.cnesUnidade != null ? this.cnesUnidade.hashCode() : 0);
        hash = 47 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        hash = 47 * hash + (this.cnsMedico != null ? this.cnsMedico.hashCode() : 0);
        hash = 47 * hash + (this.cboMedico != null ? this.cboMedico.hashCode() : 0);
        hash = 47 * hash + (this.numeroFolha != null ? this.numeroFolha.hashCode() : 0);
        hash = 47 * hash + (this.sequenciaFolha != null ? this.sequenciaFolha.hashCode() : 0);
        hash = 47 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
        hash = 47 * hash + (this.dataAtendimento != null ? this.dataAtendimento.hashCode() : 0);
        return hash;
    }
    
    
}
