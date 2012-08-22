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
@Table(name = "S_PA")
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    @EmbeddedId
    private ProcedimentoPK procedimentoPk;
    
    @Basic(optional = false)
    @Column(name = "PA_DV")
    private char digitoVerificador;
    
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
    private Character paIdebpa;
    
    @Column(name = "PA_CNSPCN")
    private Character paCnspcn;
    
    @Column(name = "PA_CNRAC")
    private Character paCnrac;
    
    @Column(name = "PA_6MESES")
    private Character maisDeSeisMeses;
    
    @Column(name = "PA_EXIGCBO")
    private Character exigeCBO;
    
    

    public Procedimento() {
    }

    public Procedimento(ProcedimentoPK procedimentoPk) {
        this.procedimentoPk = procedimentoPk;
    }

    public Procedimento(ProcedimentoPK procedimentoPk, char digitoVerificador, Double paTotal, String descricao, String paRub, Character paTpcc, String paAux, Double paSp, Double paSa, String paCpx, String paCtf, Character tipoDocumento, Short idadeMaximaPaciente, Short idadeMinimaPaciente, Character sexo, Double quantidadeMaximaExecucao, Character paIdebpa, Character paCnspcn, Character paCnrac, Character maisDeSeisMeses, Character exigeCBO) {
        this.procedimentoPk = procedimentoPk;
        this.digitoVerificador = digitoVerificador;
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
        this.paIdebpa = paIdebpa;
        this.paCnspcn = paCnspcn;
        this.paCnrac = paCnrac;
        this.maisDeSeisMeses = maisDeSeisMeses;
        this.exigeCBO = exigeCBO;
    }



    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(char digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
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

    public Character getPaIdebpa() {
        return paIdebpa;
    }

    public void setPaIdebpa(Character paIdebpa) {
        this.paIdebpa = paIdebpa;
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

    public ProcedimentoPK getProcedimentoPk() {
        return procedimentoPk;
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
        final Procedimento other = (Procedimento) obj;
        if (this.procedimentoPk != other.procedimentoPk && (this.procedimentoPk == null || !this.procedimentoPk.equals(other.procedimentoPk))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.procedimentoPk != null ? this.procedimentoPk.hashCode() : 0);
        return hash;
    }

    public void setProcedimentoPk(ProcedimentoPK procedimentoPk) {
        this.procedimentoPk = procedimentoPk;
    }

 
    


    @Override
    public String toString() {
        return this.descricao+"/"+this.procedimentoPk.getId()+""+this.procedimentoPk.getCompetencia()+ " ]";
    }
    
}
