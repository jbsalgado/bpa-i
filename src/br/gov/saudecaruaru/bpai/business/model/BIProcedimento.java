/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
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
@Table(name = "S_PA")
public class BIProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @EmbeddedId
    private BIProcedimentoPK bIprocedimentoPk;
    
    @Basic(optional = false)
    @Column(name = "PA_CMP")
    private String competencia;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PA_TOTAL")
    private Double paTotal;
    
    @Basic(optional= false)
    @Column(name = "PA_DC")
    private String descricao;
    
    @Column(name = "PA_RUB")
    private String paRub;
    
    @Column(name = "PA_TPCC")
    private Character paTpcc;
    
    @Column(name = "PA_AUX")
    private String paAux;
    
    @Column(name = "PA_SP")
    private Double paSp;
    
    @Column(name = "PA_SA")
    private Double paSa;
    
    @Column(name = "PA_CPX")
    private String paCpx;
    
    @Column(name = "PA_CTF")
    private String paCtf;
    
    @Column(name = "PA_DOC")
    private Character tipoDocumento
            ;
    
    @Column(name = "PA_IDADEMX")
    private Short idadeMaximaPaciente;
    
    @Column(name = "PA_IDADEMN")
    private Short idadeMinimaPaciente;
    
    @Column(name = "PA_SEXO")
    private Character sexo;
    
    @Column(name = "PA_QTDMAX")
    private Double quantidadeMaximaExecucao;
    
    @Column(name = "PA_IDEBPA")
    private Character exigeIdadeBPA;
    
    @Column(name = "PA_CNSPCN")
    private Character paCnspcn;
    
    @Column(name = "PA_CNRAC")
    private Character paCnrac;
    
    @Column(name = "PA_6MESES")
    private Character maisDeSeisMeses;
    
    @Column(name = "PA_EXIGCBO")
    private Character exigeCBO;
    
    

    public BIProcedimento() {
    }

    public BIProcedimento(BIProcedimentoPK bIprocedimentoPk) {
        this.bIprocedimentoPk = bIprocedimentoPk;
    }

    public BIProcedimento(Procedimento procedimento){
        this.bIprocedimentoPk=new BIProcedimentoPK(procedimento);
        this.competencia = procedimento.getProcedimentoPk().getCompetencia();
        this.setDescricao(procedimento.getDescricao());
        //this.digitoVerificador=procedimento.getDigitoVerificador();
        this.exigeCBO=procedimento.getExigeCBO();
        this.exigeIdadeBPA=procedimento.getExigeIdadeBPA();
        this.idadeMaximaPaciente=procedimento.getIdadeMaximaPaciente();
        this.idadeMinimaPaciente=procedimento.getIdadeMinimaPaciente();
        this.maisDeSeisMeses=procedimento.getMaisDeSeisMeses();
        this.paAux=procedimento.getPaAux();
        this.paCnrac=procedimento.getPaCnrac();
        this.paCnspcn=procedimento.getPaCnspcn();
        this.paCpx=procedimento.getPaCpx();
        this.paCtf=procedimento.getPaCtf();
        this.paRub=procedimento.getPaRub();
        this.paSa=procedimento.getPaSa();
        this.paSp=procedimento.getPaSp();
        this.paTotal=procedimento.getPaTotal();
        this.paTpcc=procedimento.getPaTpcc();
        this.quantidadeMaximaExecucao=procedimento.getQuantidadeMaximaExecucao();
        this.sexo=procedimento.getSexo();
        this.tipoDocumento=procedimento.getTipoDocumento();
       
    }
    public BIProcedimento(BIProcedimentoPK bIprocedimentoPk, char digitoVerificador, Double paTotal, String descricao, String paRub, Character paTpcc, String paAux, Double paSp, Double paSa, String paCpx, String paCtf, Character tipoDocumento, Short idadeMaximaPaciente, Short idadeMinimaPaciente, Character sexo, Double quantidadeMaximaExecucao, Character paIdebpa, Character paCnspcn, Character paCnrac, Character maisDeSeisMeses, Character exigeCBO) {
        this.bIprocedimentoPk = bIprocedimentoPk;
        //this.digitoVerificador = digitoVerificador;
        this.paTotal = paTotal;
        this.descricao = descricao;
        this.paRub = paRub;
        this.paTpcc = paTpcc;
        this.paAux = paAux;
        this.paSp = paSp;
        this.paSa = paSa;
        this.paCpx = paCpx;
        this.paCtf = paCtf;
        this.tipoDocumento = tipoDocumento;
        this.idadeMaximaPaciente = idadeMaximaPaciente;
        this.idadeMinimaPaciente = idadeMinimaPaciente;
        this.sexo = sexo;
        this.quantidadeMaximaExecucao = quantidadeMaximaExecucao;
        this.exigeIdadeBPA = paIdebpa;
        this.paCnspcn = paCnspcn;
        this.paCnrac = paCnrac;
        this.maisDeSeisMeses = maisDeSeisMeses;
        this.exigeCBO = exigeCBO;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = "bugado";//descricao.length() > 59 ? descricao.substring(0,59) : descricao;
    }

 
    public Character getExigeCBO() {
        return exigeCBO;
    }

    public void setExigeCBO(Character exigeCBO) {
        this.exigeCBO = exigeCBO;
    }



    public Short getIdadeMaximaPaciente() {
        return idadeMaximaPaciente;
    }

    public void setIdadeMaximaPaciente(Short idadeMaximaPaciente) {
        this.idadeMaximaPaciente = idadeMaximaPaciente;
    }

    public Short getIdadeMinimaPaciente() {
        return idadeMinimaPaciente;
    }

    public void setIdadeMinimaPaciente(Short idadeMinimaPaciente) {
        this.idadeMinimaPaciente = idadeMinimaPaciente;
    }

    public Character getMaisDeSeisMeses() {
        return maisDeSeisMeses;
    }

    public void setMaisDeSeisMeses(Character maisDeSeisMeses) {
        this.maisDeSeisMeses = maisDeSeisMeses;
    }

    public String getPaAux() {
        return paAux;
    }

    public void setPaAux(String paAux) {
        this.paAux = paAux;
    }

    public Character getPaCnrac() {
        return paCnrac;
    }

    public void setPaCnrac(Character paCnrac) {
        this.paCnrac = paCnrac;
    }

    public Character getPaCnspcn() {
        return paCnspcn;
    }

    public void setPaCnspcn(Character paCnspcn) {
        this.paCnspcn = paCnspcn;
    }

    public String getPaCpx() {
        return paCpx;
    }

    public void setPaCpx(String paCpx) {
        this.paCpx = paCpx;
    }

    public String getPaCtf() {
        return paCtf;
    }

    public void setPaCtf(String paCtf) {
        this.paCtf = paCtf;
    }

    public Character getExigeIdadeBPA() {
        return exigeIdadeBPA;
    }

    public void setExigeIdadeBPA(Character paIdebpa) {
        this.exigeIdadeBPA = paIdebpa;
    }

    public String getPaRub() {
        return paRub;
    }

    public void setPaRub(String paRub) {
        this.paRub = paRub;
    }

    public Double getPaSa() {
        return paSa;
    }

    public void setPaSa(Double paSa) {
        this.paSa = paSa;
    }

    public Double getPaSp() {
        return paSp;
    }

    public void setPaSp(Double paSp) {
        this.paSp = paSp;
    }

    public Double getPaTotal() {
        return paTotal;
    }

    public void setPaTotal(Double paTotal) {
        this.paTotal = paTotal;
    }

    public Character getPaTpcc() {
        return paTpcc;
    }

    public void setPaTpcc(Character paTpcc) {
        this.paTpcc = paTpcc;
    }

    public Double getQuantidadeMaximaExecucao() {
        return quantidadeMaximaExecucao;
    }

    public void setQuantidadeMaximaExecucao(Double quantidadeMaximaExecucao) {
        this.quantidadeMaximaExecucao = quantidadeMaximaExecucao;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public Character getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Character tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public BIProcedimentoPK getBIProcedimentoPk() {
        return bIprocedimentoPk;
    }
    
    public boolean exigeSexo(){
        if(!this.sexo.toString().equals("A")){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BIProcedimento other = (BIProcedimento) obj;
        if (this.bIprocedimentoPk != other.getBIProcedimentoPk() && (this.bIprocedimentoPk == null || !this.bIprocedimentoPk.equals(other.getBIProcedimentoPk()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.bIprocedimentoPk != null ? this.bIprocedimentoPk.hashCode() : 0);
        return hash;
    }

    public void setProcedimentoPk(BIProcedimentoPK bIprocedimentoPk) {
        this.bIprocedimentoPk = bIprocedimentoPk;
    }

 
    


    @Override
    public String toString() {
        return this.descricao+"/"+this.bIprocedimentoPk.getId()+""+ " ]";
    }
    
}
