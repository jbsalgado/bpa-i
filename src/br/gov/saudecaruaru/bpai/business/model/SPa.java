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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SPa.findAll", query = "SELECT s FROM SPa s"),
    @NamedQuery(name = "SPa.findByPaId", query = "SELECT s FROM SPa s WHERE s.paId = :paId"),
    @NamedQuery(name = "SPa.findByPaDv", query = "SELECT s FROM SPa s WHERE s.paDv = :paDv"),
    @NamedQuery(name = "SPa.findByPaTotal", query = "SELECT s FROM SPa s WHERE s.paTotal = :paTotal"),
    @NamedQuery(name = "SPa.findByPaDc", query = "SELECT s FROM SPa s WHERE s.paDc = :paDc"),
    @NamedQuery(name = "SPa.findByPaRub", query = "SELECT s FROM SPa s WHERE s.paRub = :paRub"),
    @NamedQuery(name = "SPa.findByPaTpcc", query = "SELECT s FROM SPa s WHERE s.paTpcc = :paTpcc"),
    @NamedQuery(name = "SPa.findByPaAux", query = "SELECT s FROM SPa s WHERE s.paAux = :paAux"),
    @NamedQuery(name = "SPa.findByPaSp", query = "SELECT s FROM SPa s WHERE s.paSp = :paSp"),
    @NamedQuery(name = "SPa.findByPaSa", query = "SELECT s FROM SPa s WHERE s.paSa = :paSa"),
    @NamedQuery(name = "SPa.findByPaCpx", query = "SELECT s FROM SPa s WHERE s.paCpx = :paCpx"),
    @NamedQuery(name = "SPa.findByPaCtf", query = "SELECT s FROM SPa s WHERE s.paCtf = :paCtf"),
    @NamedQuery(name = "SPa.findByPaDoc", query = "SELECT s FROM SPa s WHERE s.paDoc = :paDoc"),
    @NamedQuery(name = "SPa.findByPaIdademx", query = "SELECT s FROM SPa s WHERE s.paIdademx = :paIdademx"),
    @NamedQuery(name = "SPa.findByPaIdademn", query = "SELECT s FROM SPa s WHERE s.paIdademn = :paIdademn"),
    @NamedQuery(name = "SPa.findByPaSexo", query = "SELECT s FROM SPa s WHERE s.paSexo = :paSexo"),
    @NamedQuery(name = "SPa.findByPaQtdmax", query = "SELECT s FROM SPa s WHERE s.paQtdmax = :paQtdmax"),
    @NamedQuery(name = "SPa.findByPaIdebpa", query = "SELECT s FROM SPa s WHERE s.paIdebpa = :paIdebpa"),
    @NamedQuery(name = "SPa.findByPaCnspcn", query = "SELECT s FROM SPa s WHERE s.paCnspcn = :paCnspcn"),
    @NamedQuery(name = "SPa.findByPaCnrac", query = "SELECT s FROM SPa s WHERE s.paCnrac = :paCnrac"),
    @NamedQuery(name = "SPa.findByPa6meses", query = "SELECT s FROM SPa s WHERE s.pa6meses = :pa6meses"),
    @NamedQuery(name = "SPa.findByPaExigcbo", query = "SELECT s FROM SPa s WHERE s.paExigcbo = :paExigcbo"),
    @NamedQuery(name = "SPa.findByPaCmp", query = "SELECT s FROM SPa s WHERE s.paCmp = :paCmp")})
public class SPa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PA_ID")
    private String paId;
    @Basic(optional = false)
    @Column(name = "PA_DV")
    private char paDv;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PA_TOTAL")
    private Double paTotal;
    @Column(name = "PA_DC")
    private String paDc;
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
    private Character paDoc;
    @Column(name = "PA_IDADEMX")
    private Short paIdademx;
    @Column(name = "PA_IDADEMN")
    private Short paIdademn;
    @Column(name = "PA_SEXO")
    private Character paSexo;
    @Column(name = "PA_QTDMAX")
    private Double paQtdmax;
    @Column(name = "PA_IDEBPA")
    private Character paIdebpa;
    @Column(name = "PA_CNSPCN")
    private Character paCnspcn;
    @Column(name = "PA_CNRAC")
    private Character paCnrac;
    @Column(name = "PA_6MESES")
    private Character pa6meses;
    @Column(name = "PA_EXIGCBO")
    private Character paExigcbo;
    @Basic(optional = false)
    @Column(name = "PA_CMP")
    private String paCmp;

    public SPa() {
    }

    public SPa(String paId) {
        this.paId = paId;
    }

    public SPa(String paId, char paDv, String paCmp) {
        this.paId = paId;
        this.paDv = paDv;
        this.paCmp = paCmp;
    }

    public String getPaId() {
        return paId;
    }

    public void setPaId(String paId) {
        this.paId = paId;
    }

    public char getPaDv() {
        return paDv;
    }

    public void setPaDv(char paDv) {
        this.paDv = paDv;
    }

    public Double getPaTotal() {
        return paTotal;
    }

    public void setPaTotal(Double paTotal) {
        this.paTotal = paTotal;
    }

    public String getPaDc() {
        return paDc;
    }

    public void setPaDc(String paDc) {
        this.paDc = paDc;
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
        return paDoc;
    }

    public void setPaDoc(Character paDoc) {
        this.paDoc = paDoc;
    }

    public Short getPaIdademx() {
        return paIdademx;
    }

    public void setPaIdademx(Short paIdademx) {
        this.paIdademx = paIdademx;
    }

    public Short getPaIdademn() {
        return paIdademn;
    }

    public void setPaIdademn(Short paIdademn) {
        this.paIdademn = paIdademn;
    }

    public Character getPaSexo() {
        return paSexo;
    }

    public void setPaSexo(Character paSexo) {
        this.paSexo = paSexo;
    }

    public Double getPaQtdmax() {
        return paQtdmax;
    }

    public void setPaQtdmax(Double paQtdmax) {
        this.paQtdmax = paQtdmax;
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
        return pa6meses;
    }

    public void setPa6meses(Character pa6meses) {
        this.pa6meses = pa6meses;
    }

    public Character getPaExigcbo() {
        return paExigcbo;
    }

    public void setPaExigcbo(Character paExigcbo) {
        this.paExigcbo = paExigcbo;
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
        hash += (paId != null ? paId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SPa)) {
            return false;
        }
        SPa other = (SPa) object;
        if ((this.paId == null && other.paId != null) || (this.paId != null && !this.paId.equals(other.paId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPa[ paId=" + paId + " ]";
    }
    
}
