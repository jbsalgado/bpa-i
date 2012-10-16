/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import br.gov.saudecaruaru.bpai.business.service.SPaciente;
import br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "S_PRD")
public class ProcedimentoRealizado implements Serializable,Cloneable {
    private static final long serialVersionUID = 1L;
    
    public static final String ORIGEM_CONSOLIDADO="BPA";
    public static final String ORIGEM_INDIVIDUALIZADO="BPI";
    public static final int MAXIMA_QUANTIDADE_FOLHA=900;
    public static final int MAXIMA_QUANTIDADE_SEQUENCIA=20;
    
    @EmbeddedId
    private ProcedimentoRealizadoPK procedimentoRealizadoPK; 
    
    
    @Column(name = "PRD_PA")
    private String codigoProcedimento;
    
    @Column(name = "PRD_DTATEN")
    private String dataAtendimento;
    
    @Column(name = "PRD_CNSPAC")
    private String cnsPaciente;
    
    @Column(name = "PRD_NMPAC")
    private String nomePaciente;
    
    @Column(name = "PRD_DTNASC")
    private String dataNascimentoPaciente;
    
    @Column(name = "PRD_SEXO")
    private String sexoPaciente;
    
    
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
    
    
    @Column(name = "PRD_RACA")
    private String racaPaciente;
    
    @Column(name = "PRD_ETNIA")
    private String etniaPaciente;
    
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

    @Transient
    private String nomeProfissional;
    
    public ProcedimentoRealizado() {
        this.procedimentoRealizadoPK = new ProcedimentoRealizadoPK();
    }

    public ProcedimentoRealizado(ProcedimentoRealizadoPK procedimentoRealizadoPK) {
        this.procedimentoRealizadoPK = procedimentoRealizadoPK;
    }

    public ProcedimentoRealizado(ProcedimentoRealizadoPK procedimentoRealizadoPK, String codigoProcedimento, String dataAtendimento, String cnsPaciente, String nomePaciente, String dataNascimentoPaciente, String sexoPaciente, String codigoIBGECidadePaciente, String cidDoencaprocedimento, String idadePaciente, Double quantidadeRealizada, String caracterizacaoAtendimento, String numeroAutorizacao, String origemProcedimento, String prdMvm, String prdFlpa, String prdFlcbo, String prdFlca, String prdFlida, String prdFlqt, String prdFler, String prdFlmun, String prdFlcid, String racaPaciente, String etniaPaciente, String nacionalidadePaciente, String prdAdvqt, String codigoServico, String codigoClassificacaoServico, String equipe, String nomeProfissional) {
        this.procedimentoRealizadoPK = procedimentoRealizadoPK;
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
        this.origemProcedimento = origemProcedimento;
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
        this.codigoServico = codigoServico;
        this.codigoClassificacaoServico = codigoClassificacaoServico;
        this.equipe = equipe;
        this.nomeProfissional = nomeProfissional;
    }
    
    public ProcedimentoRealizado(ProcedimentoRealizado procedimentoRealizado){
        
        this.procedimentoRealizadoPK= new ProcedimentoRealizadoPK();
        this.procedimentoRealizadoPK.setCboMedico(procedimentoRealizado.getProcedimentoRealizadoPK().getCboMedico());
        this.procedimentoRealizadoPK.setCnesUnidade(procedimentoRealizado.getProcedimentoRealizadoPK().getCnesUnidade());
        this.procedimentoRealizadoPK.setCnsMedico(procedimentoRealizado.getProcedimentoRealizadoPK().getCnsMedico());
        this.procedimentoRealizadoPK.setCompetencia(procedimentoRealizado.getProcedimentoRealizadoPK().getCompetencia());
        this.procedimentoRealizadoPK.setNumeroFolha(procedimentoRealizado.getProcedimentoRealizadoPK().getNumeroFolha());
        this.procedimentoRealizadoPK.setSequenciaFolha(procedimentoRealizado.getProcedimentoRealizadoPK().getSequenciaFolha());
        
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
        this.origemProcedimento=procedimentoRealizado.getOrigemProcedimento();
        this.codigoServico=procedimentoRealizado.getCodigoServico();
        this.codigoClassificacaoServico=procedimentoRealizado.getCodigoClassificacaoServico();
        this.equipe=procedimentoRealizado.getEquipe();
        this.nomeProfissional=procedimentoRealizado.getNomeProfissional();
    }
    
    public ProcedimentoRealizado(String cnes,String cnsProfissional,String cbo,String competencia,String folha) {
        this.procedimentoRealizadoPK = new ProcedimentoRealizadoPK(cnes, cnsProfissional, cbo, competencia, folha);
        
      
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        
        return super.clone();
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
        this.competenciaMovimento=procedimentoRealizado.getPrdMvm();
        this.quantidadeRealizada=procedimentoRealizado.getQuantidadeRealizada();
        this.sexoPaciente=procedimentoRealizado.getSexoPaciente();
        this.racaPaciente=procedimentoRealizado.getRacaPaciente();
        this.codigoProcedimento=procedimentoRealizado.getCodigoProcedimento();
        this.dataAtendimento=procedimentoRealizado.getDataAtendimento();
        this.origemProcedimento=procedimentoRealizado.getOrigemProcedimento();
        this.codigoServico=procedimentoRealizado.getCodigoServico();
        this.codigoClassificacaoServico=procedimentoRealizado.getCodigoClassificacaoServico();
        this.equipe=procedimentoRealizado.getEquipe();
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

    /**
     * Preenche os camps com valores padrões e formata os campos númericos
     */
    public void preencherAtributosVazios(){
        if(this.origemProcedimento.equals(ORIGEM_CONSOLIDADO)){
            
            if( this.getProcedimentoRealizadoPK().getCnsMedico()==null? true: this.getProcedimentoRealizadoPK().getCnsMedico().isEmpty()){
                this.getProcedimentoRealizadoPK().setCnsMedico("               ");
            }
            if(this.nomePaciente == null ? true: this.nomePaciente.isEmpty()){
                this.nomePaciente="                              ";
            }
            if( this.sexoPaciente == null ? true: this.sexoPaciente.isEmpty() ){
                this.sexoPaciente=" ";
            }
            if( this.dataNascimentoPaciente == null ? true : this.dataNascimentoPaciente.isEmpty()){
                this.dataNascimentoPaciente="        ";
            }
            if( this.codigoIBGECidadePaciente == null ? true : this.codigoIBGECidadePaciente.isEmpty() ){
                this.codigoIBGECidadePaciente="      ";
            }
            if( this.nacionalidadePaciente ==  null ? true :  this.nacionalidadePaciente.isEmpty()){
                this.nacionalidadePaciente="   ";
            }
            if( this.racaPaciente == null ? true: this.racaPaciente.isEmpty()){
                this.racaPaciente="  ";
            }
            if( this.caracterizacaoAtendimento== null ? true : this.caracterizacaoAtendimento.isEmpty()){
                this.caracterizacaoAtendimento="  ";
            } 
            if( this.dataAtendimento == null ? true : this.dataAtendimento.isEmpty()){
                this.dataAtendimento="        ";
            }
        }
        
        if(this.cidDoencaprocedimento == null ? true : this.cidDoencaprocedimento.isEmpty()){
            this.cidDoencaprocedimento="    ";
        }
        
        if(this.nomeProfissional == null ? true : this.nomeProfissional.isEmpty()){
            this.nomeProfissional="                              ";
        }

        if( this.idadePaciente== null ? true : this.idadePaciente.isEmpty()){
            this.idadePaciente=ModelUtil.completar(""+this.idadePaciente, 3, '0');
        }
        if(this.cnsPaciente==null ? true : this.cnsPaciente.isEmpty()){
            this.cnsPaciente="               ";
        }
        
        if(this.codigoClassificacaoServico==null ? true : this.codigoClassificacaoServico.isEmpty()){
            this.codigoClassificacaoServico="   ";
        }
        if(this.codigoServico==null ? true : this.codigoServico.isEmpty()){
            this.codigoServico="   ";
        }
        if(this.equipe==null ? true : this.equipe.isEmpty()){
            this.equipe="            ";
        }
        if(this.etniaPaciente == null ? true : this.equipe.isEmpty()){
            this.etniaPaciente="    ";
        }
        if(this.numeroAutorizacao == null ? true : this.numeroAutorizacao.isEmpty()){
            this.numeroAutorizacao="             ";
        }
        if(this.prdAdvqt==null? true : this.prdAdvqt.isEmpty()){
            this.prdAdvqt="  ";
        }
        if(this.prdFlca== null ? true : this.prdFlca.isEmpty()){
            this.prdFlca="0";
        }
        if( this.prdFlcbo == null ? true : this.prdFlcbo.isEmpty()){
            this.prdFlcbo="0";
        }
        if( this.prdFlcid == null ? true : this.prdFlcid.isEmpty()){
            this.prdFlcid="0";
        }
        if( this.prdFler == null ? true : this.prdFler.isEmpty()){
            this.prdFler="0";
        }
        if( this.prdFlida == null ? true : this.prdFlida.isEmpty()){
            this.prdFlida="0";
        }
        if( this.prdFlmun == null ? true : this.prdFlmun.isEmpty()){
            this.prdFlmun="0";
        }
        if( this.prdFlpa == null ? true : this.prdFlpa.isEmpty()){
            this.prdFlpa="0";
        }
        if( this.prdFlqt == null ? true : this.prdFlqt.isEmpty()){
            this.prdFlqt="0";
        }
        
        if( this.competenciaMovimento== null ? true : this.competenciaMovimento.isEmpty()){
            this.competenciaMovimento="      ";
        }

        String tmp=this.getProcedimentoRealizadoPK().getNumeroFolha();
        this.getProcedimentoRealizadoPK().setNumeroFolha(ModelUtil.completar(tmp, 3, '0'));

        tmp=this.getProcedimentoRealizadoPK().getSequenciaFolha();
        this.getProcedimentoRealizadoPK().setSequenciaFolha(ModelUtil.completar(tmp, 2, '0'));
    }
    public String getCodigoClassificacaoServico() {
        return codigoClassificacaoServico;
    }

    public void setCodigoClassificacaoServico(String codigoClassificacaoServico) {
        this.codigoClassificacaoServico = codigoClassificacaoServico.trim();
    }

    public String getCodigoServico() {
        return codigoServico;
    }

    public void setCodigoServico(String codigoServico) {
        this.codigoServico = codigoServico.trim();
    }

    public boolean isComplete(){
        if(this.procedimentoRealizadoPK==null){
            return false;
        }
        if(this.procedimentoRealizadoPK.getCboMedico() ==null ? true : this.procedimentoRealizadoPK.getCboMedico().isEmpty()){
            return false;
        }
        if(this.procedimentoRealizadoPK.getCnesUnidade() ==null ? true : this.procedimentoRealizadoPK.getCnesUnidade().isEmpty()){
            return false;
        }
        if(this.procedimentoRealizadoPK.getCnsMedico() ==null ? true : this.procedimentoRealizadoPK.getCnsMedico().isEmpty()){
            return false;
        }
        if(this.procedimentoRealizadoPK.getCompetencia() ==null ? true : this.procedimentoRealizadoPK.getCompetencia().isEmpty()){
            return false;
        }
        if(this.procedimentoRealizadoPK.getNumeroFolha() ==null ? true : this.procedimentoRealizadoPK.getNumeroFolha().isEmpty()){
            return false;
        }
        if(this.procedimentoRealizadoPK.getSequenciaFolha() ==null ? true : this.procedimentoRealizadoPK.getSequenciaFolha().isEmpty()){
            return false;
        }
        
        return true;
    }
    
    public ProcedimentoRealizado getOnlyHeader(){
        ProcedimentoRealizadoPK pr=null;
        try {
            pr = (ProcedimentoRealizadoPK) this.procedimentoRealizadoPK.clone();
            pr.setSequenciaFolha(null);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(ProcedimentoRealizado.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ProcedimentoRealizado(pr);
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
        pro.setCompetencia(this.getProcedimentoRealizadoPK().getCompetencia());
        pro.setCompetencia_movimento(this.competenciaMovimento);
        pro.setEquipe(this.equipe);
        pro.setFolha(this.procedimentoRealizadoPK.getNumeroFolha());
        if( this.idadePaciente==null? false : !this.idadePaciente.trim().isEmpty()){
            pro.setIdade_paciente(BigInteger.valueOf(Long.parseLong(this.idadePaciente)));
        }
        pro.setNumero_autorizacao(this.numeroAutorizacao);
        pro.setOrigem(this.origemProcedimento);
        pro.setProcedimento(this.codigoProcedimento);
        pro.setProfissional_cbo(this.getProcedimentoRealizadoPK().getCboMedico());
        pro.setProfissional_cns(this.getProcedimentoRealizadoPK().getCnsMedico());
        pro.setQuantidade(BigInteger.valueOf(this.quantidadeRealizada.longValue()));
        pro.setSequencia(this.procedimentoRealizadoPK.getSequenciaFolha());
        pro.setServico(this.codigoServico);
        pro.setUnidade(this.procedimentoRealizadoPK.getCnesUnidade());
        
        return pro;
    }
    
    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }
    
    
    public String getCodigoProcedimento() {
        return codigoProcedimento;
    }

    public Medico getMedico(){
        Medico me= new Medico(this);
        return me;
    }
    
    public MedicoCboCnes getMedicoCboCnes(){
        MedicoCboCnes me= new MedicoCboCnes(this);
        return me;
    }
    public void setCodigoProcedimento(String codigoProcedimento) {
        this.codigoProcedimento = codigoProcedimento;
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
        //seta somente Strings Uppercase
        this.cidDoencaprocedimento = cidDoencaprocedimento.toUpperCase();
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
        if(idadePaciente==null){
            this.idadePaciente ="0";
        }else
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
        if(nomePaciente!=null){
            if(nomePaciente.length()>=30){
                this.nomePaciente = nomePaciente.substring(0,30);
                return;
            }
        }
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
        this.racaPaciente = racaPaciente.trim();
    }

    public String getSexoPaciente() {
        return sexoPaciente;
    }

    public void setSexoPaciente(String sexoPaciente) {
        this.sexoPaciente = sexoPaciente;
    }
    
    public Paciente getPaciente(){
        Paciente p= new Paciente(this);
        
//        p.setCep(null);
//        p.setCns(this.cnsPaciente);
//        p.setCodigoIbgeCidade(this.codigoIBGECidadePaciente);
//        p.setComplemento(null);
//        p.setDataNascimento(this.dataNascimentoPaciente);
//        p.setEtnia(this.etniaPaciente);
//        p.setLogradouro(null);
//        p.setNacionalidade(this.nacionalidadePaciente);
//        p.setNome(this.nomePaciente);
//        p.setNomeMae(null);
//        p.setRaca(this.racaPaciente);
//        p.setSexo(this.sexoPaciente.charAt(0));
        
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
        return "ProcedimentoRealizado{" + "procedimentoRealizadoPK=" + procedimentoRealizadoPK + ", cnsPaciente=" + cnsPaciente + ", nomePaciente=" + nomePaciente + ", dataNascimentoPaciente=" + dataNascimentoPaciente + ", sexoPaciente=" + sexoPaciente + ", codigoIBGECidadePaciente=" + codigoIBGECidadePaciente + ", cidDoencaprocedimento=" + cidDoencaprocedimento + ", idadePaciente=" + idadePaciente + ", quantidadeRealizada=" + quantidadeRealizada + ", caracterizacaoAtendimento=" + caracterizacaoAtendimento + ", numeroAutorizacao=" + numeroAutorizacao + ", prdOrg=" + origemProcedimento + ", prdMvm=" + competenciaMovimento + ", prdFlpa=" + prdFlpa + ", prdFlcbo=" + prdFlcbo + ", prdFlca=" + prdFlca + ", prdFlida=" + prdFlida + ", prdFlqt=" + prdFlqt + ", prdFler=" + prdFler + ", prdFlmun=" + prdFlmun + ", prdFlcid=" + prdFlcid + ", racaPaciente=" + racaPaciente + ", etniaPaciente=" + etniaPaciente + ", nacionalidadePaciente=" + nacionalidadePaciente + ", prdAdvqt=" + prdAdvqt + '}';
    }

    /**
     * @return the nomeProfissional
     */
    public String getNomeProfissional() {
        return nomeProfissional;
    }

    /**
     * @param nomeProfissional the nomeProfissional to set
     */
    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

  
 
    
    
}
