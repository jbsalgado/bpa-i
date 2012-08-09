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
@Table(name = "S_PRD")
public class ProcedimentoRealizado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_UID")
    private String cnesUnidade;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_CMP")
    private String competencia;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_CNSMED")
    private String cnsMedico;
    
    @Column(name = "PRD_CBO")
    private String cboMedico;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_FLH")
    private String numeroFolha;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_SEQ")
    private String sequenciaFolha;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_PA")
    private String codigoProcedimento;
    
    @Column(name = "PRD_CNSPAC")
    private String cnsPaciente;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_NMPAC")
    private String nomePaciente;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_DTNASC")
    private String dataNascimentoPaciente;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_SEXO")
    private String sexoPaciente;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_IBGE")
    private String codigoIBGECidadePaciente;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_DTATEN")
    private String dataAtendimento;
    
    @Column(name = "PRD_CID")
    private String cidDoencaprocedimento;
    
    @Column(name = "PRD_IDADE")
    private String idadePaciente;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_QT_P")
    private Double quantidadeRealizada;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_CATEN")
    private String caracterizacaoAtendimento;
    
    @Column(name = "PRD_NAUT")
    private String numeroAutorizacao;
    
    @Column(name = "PRD_ORG")
    private String prdOrg;
    
    @Column(name = "PRD_MVM")
    private String prdMvm;
    
    @Column(name = "PRD_FLPA")
    private String prdFlpa;
    @Column(name = "PRD_FLCBO")
    private String prdFlcbo;
    @Column(name = "PRD_FLCA")
    private String prdFlca;
    @Column(name = "PRD_FLIDA")
    private String prdFlida;
    @Column(name = "PRD_FLQT")
    private String prdFlqt;
    @Column(name = "PRD_FLER")
    private String prdFler;
    @Column(name = "PRD_FLMUN")
    private String prdFlmun;
    @Column(name = "PRD_FLCID")
    private String prdFlcid;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_RACA")
    private String racaPaciente;
    
    @Column(name = "PRD_ETNIA")
    private String etniaPaciente;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_NAC")
    private String nacionalidadePaciente;
    
    @Column(name = "PRD_ADVQT")
    private String prdAdvqt;

    public ProcedimentoRealizado() {
    }

    public ProcedimentoRealizado(String prdUid) {
        this.cnesUnidade = prdUid;
    }

    public String getCaracterizacaoAtendimento() {
        return caracterizacaoAtendimento;
    }

    public void setCaracterizacaoAtendimento(String caracterizacaoAtendimento) {
        this.caracterizacaoAtendimento = caracterizacaoAtendimento;
    }

    public String getCboMedico() {
        return cboMedico;
    }

    public void setCboMedico(String cboMedico) {
        this.cboMedico = cboMedico;
    }

    public String getCidDoencaprocedimento() {
        return cidDoencaprocedimento;
    }

    public void setCidDoencaprocedimento(String cidDoencaprocedimento) {
        this.cidDoencaprocedimento = cidDoencaprocedimento;
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

    public String getCnsPaciente() {
        return cnsPaciente;
    }

    public void setCnsPaciente(String cnsPaciente) {
        this.cnsPaciente = cnsPaciente;
    }

    public String getCodigoIBGECidadePaciente() {
        return codigoIBGECidadePaciente;
    }

    public void setCodigoIBGECidadePaciente(String codigoIBGECidadePaciente) {
        this.codigoIBGECidadePaciente = codigoIBGECidadePaciente;
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

    public String getDataNascimentoPaciente() {
        return dataNascimentoPaciente;
    }

    public void setDataNascimentoPaciente(String dataNascimentoPaciente) {
        this.dataNascimentoPaciente = dataNascimentoPaciente;
    }

    public String getEtniaPaciente() {
        return etniaPaciente;
    }

    public void setEtniaPaciente(String etniaPaciente) {
        this.etniaPaciente = etniaPaciente;
    }

    public String getIdadePaciente() {
        return idadePaciente;
    }

    public void setIdadePaciente(String idadePaciente) {
        this.idadePaciente = idadePaciente;
    }

    public String getNacionalidadePaciente() {
        return nacionalidadePaciente;
    }

    public void setNacionalidadePaciente(String nacionalidadePaciente) {
        this.nacionalidadePaciente = nacionalidadePaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getNumeroAutorizacao() {
        return numeroAutorizacao;
    }

    public void setNumeroAutorizacao(String numeroAutorizacao) {
        this.numeroAutorizacao = numeroAutorizacao;
    }

    public String getNumeroFolha() {
        return numeroFolha;
    }

    public void setNumeroFolha(String numeroFolha) {
        this.numeroFolha = numeroFolha;
    }

    public String getPrdAdvqt() {
        return prdAdvqt;
    }

    public void setPrdAdvqt(String prdAdvqt) {
        this.prdAdvqt = prdAdvqt;
    }

    public String getPrdFlca() {
        return prdFlca;
    }

    public void setPrdFlca(String prdFlca) {
        this.prdFlca = prdFlca;
    }

    public String getPrdFlcbo() {
        return prdFlcbo;
    }

    public void setPrdFlcbo(String prdFlcbo) {
        this.prdFlcbo = prdFlcbo;
    }

    public String getPrdFlcid() {
        return prdFlcid;
    }

    public void setPrdFlcid(String prdFlcid) {
        this.prdFlcid = prdFlcid;
    }

    public String getPrdFler() {
        return prdFler;
    }

    public void setPrdFler(String prdFler) {
        this.prdFler = prdFler;
    }

    public String getPrdFlida() {
        return prdFlida;
    }

    public void setPrdFlida(String prdFlida) {
        this.prdFlida = prdFlida;
    }

    public String getPrdFlmun() {
        return prdFlmun;
    }

    public void setPrdFlmun(String prdFlmun) {
        this.prdFlmun = prdFlmun;
    }

    public String getPrdFlpa() {
        return prdFlpa;
    }

    public void setPrdFlpa(String prdFlpa) {
        this.prdFlpa = prdFlpa;
    }

    public String getPrdFlqt() {
        return prdFlqt;
    }

    public void setPrdFlqt(String prdFlqt) {
        this.prdFlqt = prdFlqt;
    }

    public String getPrdMvm() {
        return prdMvm;
    }

    public void setPrdMvm(String prdMvm) {
        this.prdMvm = prdMvm;
    }

    public String getPrdOrg() {
        return prdOrg;
    }

    public void setPrdOrg(String prdOrg) {
        this.prdOrg = prdOrg;
    }

    public Double getQuantidadeRealizada() {
        return quantidadeRealizada;
    }

    public void setQuantidadeRealizada(Double quantidadeRealizada) {
        this.quantidadeRealizada = quantidadeRealizada;
    }

    public String getRacaPaciente() {
        return racaPaciente;
    }

    public void setRacaPaciente(String racaPaciente) {
        this.racaPaciente = racaPaciente;
    }

    public String getSequenciaFolha() {
        return sequenciaFolha;
    }

    public void setSequenciaFolha(String sequenciaFolha) {
        this.sequenciaFolha = sequenciaFolha;
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoRealizado other = (ProcedimentoRealizado) obj;
        if ((this.cnesUnidade == null) ? (other.cnesUnidade != null) : !this.cnesUnidade.equals(other.cnesUnidade)) {
            return false;
        }
        if ((this.competencia == null) ? (other.competencia != null) : !this.competencia.equals(other.competencia)) {
            return false;
        }
        if ((this.cnsMedico == null) ? (other.cnsMedico != null) : !this.cnsMedico.equals(other.cnsMedico)) {
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
        if ((this.nomePaciente == null) ? (other.nomePaciente != null) : !this.nomePaciente.equals(other.nomePaciente)) {
            return false;
        }
        if ((this.dataNascimentoPaciente == null) ? (other.dataNascimentoPaciente != null) : !this.dataNascimentoPaciente.equals(other.dataNascimentoPaciente)) {
            return false;
        }
        if ((this.sexoPaciente == null) ? (other.sexoPaciente != null) : !this.sexoPaciente.equals(other.sexoPaciente)) {
            return false;
        }
        if ((this.codigoIBGECidadePaciente == null) ? (other.codigoIBGECidadePaciente != null) : !this.codigoIBGECidadePaciente.equals(other.codigoIBGECidadePaciente)) {
            return false;
        }
        if ((this.dataAtendimento == null) ? (other.dataAtendimento != null) : !this.dataAtendimento.equals(other.dataAtendimento)) {
            return false;
        }
        if (this.quantidadeRealizada != other.quantidadeRealizada && (this.quantidadeRealizada == null || !this.quantidadeRealizada.equals(other.quantidadeRealizada))) {
            return false;
        }
        if ((this.caracterizacaoAtendimento == null) ? (other.caracterizacaoAtendimento != null) : !this.caracterizacaoAtendimento.equals(other.caracterizacaoAtendimento)) {
            return false;
        }
        if ((this.racaPaciente == null) ? (other.racaPaciente != null) : !this.racaPaciente.equals(other.racaPaciente)) {
            return false;
        }
        if ((this.nacionalidadePaciente == null) ? (other.nacionalidadePaciente != null) : !this.nacionalidadePaciente.equals(other.nacionalidadePaciente)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.cnesUnidade != null ? this.cnesUnidade.hashCode() : 0);
        hash = 19 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        hash = 19 * hash + (this.numeroFolha != null ? this.numeroFolha.hashCode() : 0);
        hash = 19 * hash + (this.sequenciaFolha != null ? this.sequenciaFolha.hashCode() : 0);
        hash = 19 * hash + (this.codigoProcedimento != null ? this.codigoProcedimento.hashCode() : 0);
        hash = 19 * hash + (this.nomePaciente != null ? this.nomePaciente.hashCode() : 0);
        hash = 19 * hash + (this.dataNascimentoPaciente != null ? this.dataNascimentoPaciente.hashCode() : 0);
        hash = 19 * hash + (this.sexoPaciente != null ? this.sexoPaciente.hashCode() : 0);
        hash = 19 * hash + (this.codigoIBGECidadePaciente != null ? this.codigoIBGECidadePaciente.hashCode() : 0);
        hash = 19 * hash + (this.dataAtendimento != null ? this.dataAtendimento.hashCode() : 0);
        hash = 19 * hash + (this.quantidadeRealizada != null ? this.quantidadeRealizada.hashCode() : 0);
        hash = 19 * hash + (this.caracterizacaoAtendimento != null ? this.caracterizacaoAtendimento.hashCode() : 0);
        hash = 19 * hash + (this.racaPaciente != null ? this.racaPaciente.hashCode() : 0);
        hash = 19 * hash + (this.nacionalidadePaciente != null ? this.nacionalidadePaciente.hashCode() : 0);
        return hash;
    }



 

    @Override
    public String toString() {
        return "Procedimento: "+this.codigoProcedimento+"\nPaciente: "+this.nomePaciente+"\nUnidade: "+this.cnesUnidade;
    }
    
}
