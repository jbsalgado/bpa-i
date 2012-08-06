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
    @Id
    @Basic(optional = false)
    @Column(name = "PA_ID")
    private String id;
    
    @Id
    @Basic(optional = false)
    @Column(name = "PA_DV")
    private char digitoVerificador;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PA_TOTAL")
    private Double paTotal;
    
    @Id
    @Basic(optional = false)
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
    
    @Id
    @Basic(optional = false)
    @Column(name = "PA_CMP")
    private String paCmp;

    public Procedimento() {
    }

    public Procedimento(String paId) {
        this.id = paId;
    }

    public Procedimento(String paId, char paDv, String paCmp) {
        this.id = paId;
        this.digitoVerificador = paDv;
        this.paCmp = paCmp;
    }

    public String getPaId() {
        return id;
    }

    public void setPaId(String paId) {
        this.id = paId;
    }

    public char getPaDv() {
        return digitoVerificador;
    }

    public void setPaDv(char paDv) {
        this.digitoVerificador = paDv;
    }

    public Double getPaTotal() {
        return paTotal;
    }

    public void setPaTotal(Double paTotal) {
        this.paTotal = paTotal;
    }

    public String getPaDc() {
        return descricao;
    }

    public void setPaDc(String paDc) {
        this.descricao = paDc;
    }

    public String getPaRub() {
        return paRub;
    }

    public void setPaRub(String paRub) {
        this.paRub = paRub;
    }

    public Character getPaTpcc() {
        return paTpcc;
    }

    public void setPaTpcc(Character paTpcc) {
        this.paTpcc = paTpcc;
    }

    public String getPaAux() {
        return paAux;
    }

    public void setPaAux(String paAux) {
        this.paAux = paAux;
    }

    public Double getPaSp() {
        return paSp;
    }

    public void setPaSp(Double paSp) {
        this.paSp = paSp;
    }

    public Double getPaSa() {
        return paSa;
    }

    public void setPaSa(Double paSa) {
        this.paSa = paSa;
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

    public Character getPaDoc() {
        return tipoDocumento;
    }

    public void setPaDoc(Character paDoc) {
        this.tipoDocumento = paDoc;
    }

    public Short getPaIdademx() {
        return idadeMaximaPaciente;
    }

    public void setPaIdademx(Short paIdademx) {
        this.idadeMaximaPaciente = paIdademx;
    }

    public Short getPaIdademn() {
        return idadeMinimaPaciente;
    }

    public void setPaIdademn(Short paIdademn) {
        this.idadeMinimaPaciente = paIdademn;
    }

    public Character getPaSexo() {
        return sexo;
    }

    public void setPaSexo(Character paSexo) {
        this.sexo = paSexo;
    }

    public Double getPaQtdmax() {
        return quantidadeMaximaExecucao;
    }

    public void setPaQtdmax(Double paQtdmax) {
        this.quantidadeMaximaExecucao = paQtdmax;
    }

    public Character getPaIdebpa() {
        return paIdebpa;
    }

    public void setPaIdebpa(Character paIdebpa) {
        this.paIdebpa = paIdebpa;
    }

    public Character getPaCnspcn() {
        return paCnspcn;
    }

    public void setPaCnspcn(Character paCnspcn) {
        this.paCnspcn = paCnspcn;
    }

    public Character getPaCnrac() {
        return paCnrac;
    }

    public void setPaCnrac(Character paCnrac) {
        this.paCnrac = paCnrac;
    }

    public Character getPa6meses() {
        return maisDeSeisMeses;
    }

    public void setPa6meses(Character pa6meses) {
        this.maisDeSeisMeses = pa6meses;
    }

    public Character getPaExigcbo() {
        return exigeCBO;
    }

    public void setPaExigcbo(Character paExigcbo) {
        this.exigeCBO = paExigcbo;
    }

    public String getPaCmp() {
        return paCmp;
    }

    public void setPaCmp(String paCmp) {
        this.paCmp = paCmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedimento)) {
            return false;
        }
        Procedimento other = (Procedimento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPa[ paId=" + id + " ]";
    }
    
}
