/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import br.gov.saudecaruaru.bpai.business.service.SPaciente;
import br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */

@Entity
@Table(name = "S_PRD")
@XStreamAlias("bi_procedimento_realizado")
public class BIProcedimentoRealizado implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    public static final Character ATUALIZADO='S';
    public static final Character NAO_ATUALIZADO='N';
    public static final Character ENVIADO='S';
    public static final Character NAO_ENVIADO='N';
    
    @EmbeddedId
    private BIProcedimentoRealizadoPK biProcedimentoRealizadoPK;
    

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
    private String origemProcedimento;
    
    @Column(name = "PRD_MVM")
    private String competenciaMovimento;
    
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

    @Column(name = "PRD_SERVICO")
    private String codigoServico;
    
    @Column(name = "PRD_CLASSIFICACAO")
    private String codigoClassificacaoServico;
    
    @Column(name = "PRD_EQUIPE")
    private String equipe;
    
    @Column(name = "PRD_ENVIADO")
    private Character enviado;
    
    @Column(name = "PRD_ATUALIZADO")
    private Character atualizado;
    
    @Column(name = "PRD_CNPJ")
    private String cnpj;
    
    @Column(name = "PRD_EQP_AREA")
    private String equipeArea;
    
    @Column(name = "PRD_EQP_SEQ")
    private String equipeSequencia;
    
    public BIProcedimentoRealizado() {
    }

    public BIProcedimentoRealizado(ProcedimentoRealizado procedimentoRealizado) {
        this.setBiProcedimentoRealizado(procedimentoRealizado);
        
    }
    
    private void setBiProcedimentoRealizado(ProcedimentoRealizado procedimentoRealizado){
        this.biProcedimentoRealizadoPK= new BIProcedimentoRealizadoPK(procedimentoRealizado.getProcedimentoRealizadoPK());
        this.origemProcedimento = procedimentoRealizado.getOrigemProcedimento();
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
        this.competenciaMovimento=procedimentoRealizado.getCompetenciaMovimento();
        this.quantidadeRealizada=procedimentoRealizado.getQuantidadeRealizada();
        this.sexoPaciente=procedimentoRealizado.getSexoPaciente();
        this.racaPaciente=procedimentoRealizado.getRacaPaciente();
        this.codigoProcedimento=procedimentoRealizado.getCodigoProcedimento();
        this.dataAtendimento=procedimentoRealizado.getDataAtendimento();
        this.codigoServico=procedimentoRealizado.getCodigoServico();
        this.codigoClassificacaoServico=procedimentoRealizado.getCodigoClassificacaoServico();
        this.equipe=procedimentoRealizado.getEquipe();
        
        this.equipeArea=procedimentoRealizado.getEquipeArea();
        this.equipeSequencia=procedimentoRealizado.getEquipeSequencia();
        this.cnpj=procedimentoRealizado.getCnpj();
    }
    
    public ProcedimentoRealizado getProcedimentoRealizado(){
        ProcedimentoRealizado pr= new ProcedimentoRealizado();
        
        
        return pr;
        
    }
    public BIProcedimentoRealizado(BIProcedimentoRealizadoPK biProcedimentoRealizadoPK) {
        this.biProcedimentoRealizadoPK = biProcedimentoRealizadoPK;
    }

    public BIProcedimentoRealizado(BIProcedimentoRealizadoPK biProcedimentoRealizadoPK, String cnsPaciente, String nomePaciente, String dataNascimentoPaciente, String sexoPaciente, String codigoIBGECidadePaciente, String cidDoencaprocedimento, String idadePaciente, Double quantidadeRealizada, String caracterizacaoAtendimento, String numeroAutorizacao, String prdOrg, String prdMvm, String prdFlpa, String prdFlcbo, String prdFlca, String prdFlida, String prdFlqt, String prdFler, String prdFlmun, String prdFlcid, String racaPaciente, String etniaPaciente, String nacionalidadePaciente, String prdAdvqt) {
        this.biProcedimentoRealizadoPK = biProcedimentoRealizadoPK;
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
        this.origemProcedimento = prdOrg;
        this.competenciaMovimento = prdMvm;
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

    public BIProcedimentoRealizado(SProcedimentoRealizado sProcedimentoRealizado){
        
        SimpleDateFormat simple= new SimpleDateFormat("yyyyMMdd");
        
        this.biProcedimentoRealizadoPK= new BIProcedimentoRealizadoPK();
        
        this.biProcedimentoRealizadoPK.setCboMedico(sProcedimentoRealizado.getProfissional_cbo());
        this.biProcedimentoRealizadoPK.setCnesUnidade(sProcedimentoRealizado.getUnidade());
        this.biProcedimentoRealizadoPK.setCnsMedico(sProcedimentoRealizado.getProfissional_cns());
        this.biProcedimentoRealizadoPK.setCompetencia(sProcedimentoRealizado.getCompetencia());
        this.biProcedimentoRealizadoPK.setSequenciaFolha(sProcedimentoRealizado.getSequencia());
        this.biProcedimentoRealizadoPK.setNumeroFolha(sProcedimentoRealizado.getFolha());
        this.caracterizacaoAtendimento=sProcedimentoRealizado.getCaracter_atendimento();
        this.cidDoencaprocedimento=sProcedimentoRealizado.getCid();
        this.cnsPaciente=sProcedimentoRealizado.getPaciente().getCns();
        this.codigoClassificacaoServico=sProcedimentoRealizado.getClassificacao();
        this.codigoIBGECidadePaciente=sProcedimentoRealizado.getPaciente().getCidade();
        this.codigoProcedimento=sProcedimentoRealizado.getProcedimento();
        this.codigoServico=sProcedimentoRealizado.getServico();
        this.dataAtendimento=simple.format( sProcedimentoRealizado.getData_atendimento());
        this.dataNascimentoPaciente=simple.format( sProcedimentoRealizado.getPaciente().getData_nascimento());
        this.equipe=sProcedimentoRealizado.getEquipe();
        this.etniaPaciente=sProcedimentoRealizado.getPaciente().getEtnia();
        this.idadePaciente=ModelUtil.completar(sProcedimentoRealizado.getIdade_paciente().toString(),3,'0');
        this.nacionalidadePaciente=sProcedimentoRealizado.getPaciente().getNacionalidade();
        this.nomePaciente=sProcedimentoRealizado.getPaciente().getNome();
        this.numeroAutorizacao=sProcedimentoRealizado.getNumero_autorizacao();
        this.origemProcedimento=sProcedimentoRealizado.getOrigem();
        this.competenciaMovimento=sProcedimentoRealizado.getCompetencia_movimento();
        this.quantidadeRealizada=sProcedimentoRealizado.getQuantidade().doubleValue();
        this.racaPaciente=sProcedimentoRealizado.getPaciente().getRaca();
        this.sexoPaciente=sProcedimentoRealizado.getPaciente().getSexo();
        
        this.equipeArea=sProcedimentoRealizado.getEquipe_area();
        this.equipeSequencia=sProcedimentoRealizado.getEquipe_sequencia();
        this.cnpj=sProcedimentoRealizado.getCnpj();
        
       // this.equipeArea=sProcedimentoRealizado.get
    }
    
    public SProcedimentoRealizado getProcedimentoRealizadoParaEnviar(){
        SProcedimentoRealizado pro= new br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado();
        SPaciente pac=new br.gov.saudecaruaru.bpai.business.service.SPaciente();
        SimpleDateFormat simpla= new SimpleDateFormat("yyyyMMdd");
        
        pac.setCidade(this.codigoIBGECidadePaciente);
        pac.setCns(this.cnsPaciente);
        try {
            pac.setData_nascimento(simpla.parse(this.getDataNascimentoPaciente()));
            pro.setData_atendimento(simpla.parse(this.getDataAtendimento()));
        } catch (ParseException ex) {
            Logger.getLogger(ProcedimentoRealizado.class.getName()).log(Level.SEVERE, null, ex);
        }
        pac.setEtnia(this.etniaPaciente);
        pac.setNacionalidade(this.nacionalidadePaciente);
        pac.setNome(this.nomePaciente);
        pac.setRaca(this.racaPaciente);
        pac.setSexo(this.sexoPaciente);
        
        pro.setPaciente(pac);
        pro.setCaracter_atendimento(this.caracterizacaoAtendimento);
        pro.setCid(this.cidDoencaprocedimento);
        pro.setClassificacao(this.codigoClassificacaoServico);
        pro.setCompetencia(this.getBiProcedimentoRealizadoPK().getCompetencia());
        pro.setCompetencia_movimento(this.competenciaMovimento);
        pro.setEquipe(this.equipe);
        pro.setFolha(this.biProcedimentoRealizadoPK.getNumeroFolha());
        if( this.idadePaciente==null? false : !this.idadePaciente.trim().isEmpty()){
            pro.setIdade_paciente(BigInteger.valueOf(Long.parseLong(this.idadePaciente)));
        }
        pro.setNumero_autorizacao(this.numeroAutorizacao);
        pro.setOrigem(this.origemProcedimento);
        pro.setProcedimento(this.codigoProcedimento);
        pro.setProfissional_cbo(this.getBiProcedimentoRealizadoPK().getCboMedico());
        pro.setProfissional_cns(this.getBiProcedimentoRealizadoPK().getCnsMedico());
        pro.setQuantidade(BigInteger.valueOf(this.quantidadeRealizada.longValue()));
        pro.setSequencia(this.biProcedimentoRealizadoPK.getSequenciaFolha());
        pro.setServico(this.codigoServico);
        pro.setUnidade(this.biProcedimentoRealizadoPK.getCnesUnidade());
        
        pro.setEquipe_area(this.equipeArea);
        pro.setEquipe_sequencia(this.equipeSequencia);
        pro.setCnpj(this.cnpj);
        
        return pro;
    }
    
    public String getCodigoClassificacaoServico() {
        return codigoClassificacaoServico;
    }

    public void setCodigoClassificacaoServico(String codigoClassificacaoServico) {
        this.codigoClassificacaoServico = codigoClassificacaoServico;
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico;
    }

    public String getEquipe() {
        return equipe;
    }

    public Character getAtualizado() {
        return atualizado;
    }

    public void setAtualizado(Character atualizado) {
        this.atualizado = atualizado;
    }

    public Character getEnviado() {
        return enviado;
    }

    public void setEnviado(Character enviado) {
        this.enviado = enviado;
    }

    
    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    
    public String getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public void setCodigoProcedimento(String codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEquipeArea() {
        return equipeArea;
    }

    public void setEquipeArea(String equipeArea) {
        this.equipeArea = equipeArea;
    }

    public String getEquipeSequencia() {
        return equipeSequencia;
    }

    public void setEquipeSequencia(String equipeSequencia) {
        this.equipeSequencia = equipeSequencia;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
    
    public BIProcedimentoRealizadoPK getBiProcedimentoRealizadoPK() {
        return biProcedimentoRealizadoPK;
    }

    public void setBiProcedimentoRealizadoPK(BIProcedimentoRealizadoPK biProcedimentoRealizadoPK) {
        this.biProcedimentoRealizadoPK = biProcedimentoRealizadoPK;
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

    public String getCompetenciaMovimento() {
        return competenciaMovimento;
    }

    public void setCompetenciaMovimento(String competenciaMovimento) {
        this.competenciaMovimento = competenciaMovimento;
    }

    public String getOrigemProcedimento() {
        return origemProcedimento;
    }

    public void setOrigemProcedimento(String origemProcedimento) {
        this.origemProcedimento = origemProcedimento;
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

    public void setPaciente(Paciente paciente){
        
        this.cnsPaciente=paciente.getCns();
        this.codigoIBGECidadePaciente=paciente.getCodigoIbgeCidade();
        this.dataNascimentoPaciente=paciente.getDataNascimento();
        this.etniaPaciente=paciente.getEtnia();
        this.nacionalidadePaciente=paciente.getNacionalidade();
        this.nomePaciente=paciente.getNome();
        this.racaPaciente=paciente.getRaca();
        this.sexoPaciente=paciente.getSexo().toString();
        
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BIProcedimentoRealizado other = (BIProcedimentoRealizado) obj;
        if (this.biProcedimentoRealizadoPK != other.biProcedimentoRealizadoPK && (this.biProcedimentoRealizadoPK == null || !this.biProcedimentoRealizadoPK.equals(other.biProcedimentoRealizadoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + (this.biProcedimentoRealizadoPK != null ? this.biProcedimentoRealizadoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "BIProcedimentoRealizado{" + "biProcedimentoRealizadoPK=" + biProcedimentoRealizadoPK + ", codigoProcedimento=" + codigoProcedimento + ", dataAtendimento=" + dataAtendimento + ", cnsPaciente=" + cnsPaciente + ", nomePaciente=" + nomePaciente + ", dataNascimentoPaciente=" + dataNascimentoPaciente + ", sexoPaciente=" + sexoPaciente + ", codigoIBGECidadePaciente=" + codigoIBGECidadePaciente + ", cidDoencaprocedimento=" + cidDoencaprocedimento + ", idadePaciente=" + idadePaciente + ", quantidadeRealizada=" + quantidadeRealizada + ", caracterizacaoAtendimento=" + caracterizacaoAtendimento + ", numeroAutorizacao=" + numeroAutorizacao + ", origemProcedimento=" + origemProcedimento + ", prdMvm=" + competenciaMovimento + ", prdFlpa=" + prdFlpa + ", prdFlcbo=" + prdFlcbo + ", prdFlca=" + prdFlca + ", prdFlida=" + prdFlida + ", prdFlqt=" + prdFlqt + ", prdFler=" + prdFler + ", prdFlmun=" + prdFlmun + ", prdFlcid=" + prdFlcid + ", racaPaciente=" + racaPaciente + ", etniaPaciente=" + etniaPaciente + ", nacionalidadePaciente=" + nacionalidadePaciente + ", prdAdvqt=" + prdAdvqt + ", codigoServico=" + codigoServico + ", codigoClassificacaoServico=" + codigoClassificacaoServico + ", equipe=" + equipe + ", enviado=" + enviado + ", atualizado=" + atualizado + '}';
    }

    
    
    
    
}
