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
@Table(name = "S_PRD")
public class ProcedimentoRealizado implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ProcedimentoRealizadoPK procedimentoRealizadoPK; 
    
    @Column(name = "PRD_CMP")
    private String competencia;

    
    @Column(name = "PRD_PA")
    private String codigoProcedimento;
    
    @Column(name = "PRD_DTATEN")
    private String dataAtendimento;
    
    @Column(name = "PRD_CNSPAC")
    private String cnsPaciente;
    
    @Basic(optional = false)
    @Column(name = "PRD_NMPAC")
    private String nomePaciente;
    
    @Basic(optional = false)
    @Column(name = "PRD_DTNASC")
    private String dataNascimentoPaciente;
    
    @Basic(optional = false)
    @Column(name = "PRD_SEXO")
    private String sexoPaciente;
    
    
    @Basic(optional = false)
    @Column(name = "PRD_IBGE")
    private String codigoIBGECidadePaciente;
    
    
    @Column(name = "PRD_CID")
    private String cidDoencaprocedimento;
    
    @Column(name = "PRD_IDADE")
    private String idadePaciente;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Basic(optional = false)
    @Column(name = "PRD_QT_P")
    private Double quantidadeRealizada;
    
    
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
    
    
    @Basic(optional = false)
    @Column(name = "PRD_RACA")
    private String racaPaciente;
    
    @Column(name = "PRD_ETNIA")
    private String etniaPaciente;
    
    
    @Basic(optional = false)
    @Column(name = "PRD_NAC")
    private String nacionalidadePaciente;
    
    @Column(name = "PRD_ADVQT")
    private String prdAdvqt;

    public ProcedimentoRealizado() {
        this.procedimentoRealizadoPK = new ProcedimentoRealizadoPK();
    }

    public ProcedimentoRealizado(ProcedimentoRealizadoPK procedimentoRealizadoPK) {
        this.procedimentoRealizadoPK = procedimentoRealizadoPK;
    }

    public ProcedimentoRealizado(ProcedimentoRealizadoPK procedimentoRealizadoPK, String competencia, String codigoProcedimento, String dataAtendimento, String cnsPaciente, String nomePaciente, String dataNascimentoPaciente, String sexoPaciente, String codigoIBGECidadePaciente, String cidDoencaprocedimento, String idadePaciente, Double quantidadeRealizada, String caracterizacaoAtendimento, String numeroAutorizacao, String prdOrg, String prdMvm, String prdFlpa, String prdFlcbo, String prdFlca, String prdFlida, String prdFlqt, String prdFler, String prdFlmun, String prdFlcid, String racaPaciente, String etniaPaciente, String nacionalidadePaciente, String prdAdvqt) {
        this.procedimentoRealizadoPK = procedimentoRealizadoPK;
        this.competencia = competencia;
        this.codigoProcedimento = codigoProcedimento;
        this.dataAtendimento = dataAtendimento;
        this.cnsPaciente = cnsPaciente;
        this.nomePaciente = nomePaciente;
        this.dataNascimentoPaciente = dataNascimentoPaciente;
        this.sexoPaciente = sexoPaciente;
        this.codigoIBGECidadePaciente = codigoIBGECidadePaciente;
        this.cidDoencaprocedimento = cidDoencaprocedimento;
        this.idadePaciente = idadePaciente;
        this.quantidadeRealizada = quantidadeRealizada;
        this.caracterizacaoAtendimento = caracterizacaoAtendimento;
        this.numeroAutorizacao = numeroAutorizacao;
        this.prdOrg = prdOrg;
        this.prdMvm = prdMvm;
        this.prdFlpa = prdFlpa;
        this.prdFlcbo = prdFlcbo;
        this.prdFlca = prdFlca;
        this.prdFlida = prdFlida;
        this.prdFlqt = prdFlqt;
        this.prdFler = prdFler;
        this.prdFlmun = prdFlmun;
        this.prdFlcid = prdFlcid;
        this.racaPaciente = racaPaciente;
        this.etniaPaciente = etniaPaciente;
        this.nacionalidadePaciente = nacionalidadePaciente;
        this.prdAdvqt = prdAdvqt;
    }
    
    
   
    
    public ProcedimentoRealizado(String cnes,String cnsProfissional,String cbo,String competencia,String folha) {
        this.procedimentoRealizadoPK = new ProcedimentoRealizadoPK(cnes, cnsProfissional, cbo, competencia, folha);
        
      
    }
    
    public ProcedimentoRealizado(BIProcedimentoRealizado procedimentoRealizado){
        this.setBiProcedimentoRealizado(procedimentoRealizado);
    }
    
    private void setBiProcedimentoRealizado(BIProcedimentoRealizado procedimentoRealizado){
        this.procedimentoRealizadoPK= new ProcedimentoRealizadoPK(procedimentoRealizado.getBiProcedimentoRealizadoPK());
        this.caracterizacaoAtendimento= procedimentoRealizado.getCaracterizacaoAtendimento();
        this.cidDoencaprocedimento= procedimentoRealizado.getCidDoencaprocedimento();
        this.cnsPaciente=procedimentoRealizado.getCnsPaciente();
        this.codigoIBGECidadePaciente=procedimentoRealizado.getCodigoIBGECidadePaciente();
        this.dataNascimentoPaciente=procedimentoRealizado.getDataNascimentoPaciente();
        this.etniaPaciente=procedimentoRealizado.getEtniaPaciente();
        this.idadePaciente=procedimentoRealizado.getIdadePaciente();
        this.nacionalidadePaciente=procedimentoRealizado.getNacionalidadePaciente();
        this.nomePaciente=procedimentoRealizado.getNomePaciente();
        this.numeroAutorizacao=procedimentoRealizado.getNumeroAutorizacao();
        this.prdAdvqt=procedimentoRealizado.getPrdAdvqt();
        this.prdFlca=procedimentoRealizado.getPrdFlca();
        this.prdFlcbo=procedimentoRealizado.getPrdFlcbo();
        this.prdFlcid=procedimentoRealizado.getPrdFlcid();
        this.prdFler=procedimentoRealizado.getPrdFler();
        this.prdFlida=procedimentoRealizado.getPrdFlida();
        this.prdFlmun=procedimentoRealizado.getPrdFlmun();
        this.prdFlpa=procedimentoRealizado.getPrdFlpa();
        this.prdFlqt=procedimentoRealizado.getPrdFlqt();
        this.prdMvm=procedimentoRealizado.getPrdMvm();
        this.quantidadeRealizada=procedimentoRealizado.getQuantidadeRealizada();
        this.sexoPaciente=procedimentoRealizado.getSexoPaciente();
        this.racaPaciente=procedimentoRealizado.getRacaPaciente();
        this.competencia=procedimentoRealizado.getCompetencia();
        this.codigoProcedimento=procedimentoRealizado.getCodigoProcedimento();
        this.dataAtendimento=procedimentoRealizado.getDataAtendimento();
    }
    
    public void setPaciente(Paciente paciente){
        this.cnsPaciente=paciente.getCns();
        this.nomePaciente=paciente.getNome();
        this.dataNascimentoPaciente=paciente.getDataNascimento();
        this.sexoPaciente=paciente.getSexo().toString();
        this.codigoIBGECidadePaciente=paciente.getCodigoIbgeCidade();
        this.racaPaciente=paciente.getRaca();
        this.etniaPaciente=paciente.getEtnia();
        this.nacionalidadePaciente=paciente.getNacionalidade();
       // this.idadePaciente
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
    
    public String getCaracterizacaoAtendimento() {
        return caracterizacaoAtendimento;
    }

    public void setCaracterizacaoAtendimento(String caracterizacaoAtendimento) {
        this.caracterizacaoAtendimento = caracterizacaoAtendimento;
    }

    public String getCidDoencaprocedimento() {
        return cidDoencaprocedimento;
    }

    public void setCidDoencaprocedimento(String cidDoencaprocedimento) {
        this.cidDoencaprocedimento = cidDoencaprocedimento;
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

    public ProcedimentoRealizadoPK getProcedimentoRealizadoPK() {
        return procedimentoRealizadoPK;
    }

    public void setProcedimentoRealizadoPK(ProcedimentoRealizadoPK procedimentoRealizadoPK) {
        this.procedimentoRealizadoPK = procedimentoRealizadoPK;
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

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }
    
    public Paciente getPaciente(){
        Paciente p= new Paciente();
        
        p.setCep(null);
        p.setCns(this.cnsPaciente);
        p.setCodigoIbgeCidade(this.codigoIBGECidadePaciente);
        p.setComplemento(null);
        p.setDataNascimento(this.dataNascimentoPaciente);
        p.setEtnia(this.etniaPaciente);
        p.setLogradouro(null);
        p.setNacionalidade(this.nacionalidadePaciente);
        p.setNome(this.nomePaciente);
        p.setNomeMae(null);
        p.setRaca(this.racaPaciente);
        p.setSexo(this.sexoPaciente.charAt(0));
        
        return p;
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
        if (this.procedimentoRealizadoPK != other.procedimentoRealizadoPK && (this.procedimentoRealizadoPK == null || !this.procedimentoRealizadoPK.equals(other.procedimentoRealizadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.procedimentoRealizadoPK != null ? this.procedimentoRealizadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ProcedimentoRealizado{" + "procedimentoRealizadoPK=" + procedimentoRealizadoPK + ", cnsPaciente=" + cnsPaciente + ", nomePaciente=" + nomePaciente + ", dataNascimentoPaciente=" + dataNascimentoPaciente + ", sexoPaciente=" + sexoPaciente + ", codigoIBGECidadePaciente=" + codigoIBGECidadePaciente + ", cidDoencaprocedimento=" + cidDoencaprocedimento + ", idadePaciente=" + idadePaciente + ", quantidadeRealizada=" + quantidadeRealizada + ", caracterizacaoAtendimento=" + caracterizacaoAtendimento + ", numeroAutorizacao=" + numeroAutorizacao + ", prdOrg=" + prdOrg + ", prdMvm=" + prdMvm + ", prdFlpa=" + prdFlpa + ", prdFlcbo=" + prdFlcbo + ", prdFlca=" + prdFlca + ", prdFlida=" + prdFlida + ", prdFlqt=" + prdFlqt + ", prdFler=" + prdFler + ", prdFlmun=" + prdFlmun + ", prdFlcid=" + prdFlcid + ", racaPaciente=" + racaPaciente + ", etniaPaciente=" + etniaPaciente + ", nacionalidadePaciente=" + nacionalidadePaciente + ", prdAdvqt=" + prdAdvqt + '}';
    }

   
 
    
    
}
