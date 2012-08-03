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
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SPrd.findAll", query = "SELECT s FROM SPrd s"),
    @NamedQuery(name = "SPrd.findByPrdUid", query = "SELECT s FROM SPrd s WHERE s.prdUid = :prdUid"),
    @NamedQuery(name = "SPrd.findByPrdCmp", query = "SELECT s FROM SPrd s WHERE s.prdCmp = :prdCmp"),
    @NamedQuery(name = "SPrd.findByPrdCnsmed", query = "SELECT s FROM SPrd s WHERE s.prdCnsmed = :prdCnsmed"),
    @NamedQuery(name = "SPrd.findByPrdCbo", query = "SELECT s FROM SPrd s WHERE s.prdCbo = :prdCbo"),
    @NamedQuery(name = "SPrd.findByPrdFlh", query = "SELECT s FROM SPrd s WHERE s.prdFlh = :prdFlh"),
    @NamedQuery(name = "SPrd.findByPrdSeq", query = "SELECT s FROM SPrd s WHERE s.prdSeq = :prdSeq"),
    @NamedQuery(name = "SPrd.findByPrdPa", query = "SELECT s FROM SPrd s WHERE s.prdPa = :prdPa"),
    @NamedQuery(name = "SPrd.findByPrdCnspac", query = "SELECT s FROM SPrd s WHERE s.prdCnspac = :prdCnspac"),
    @NamedQuery(name = "SPrd.findByPrdNmpac", query = "SELECT s FROM SPrd s WHERE s.prdNmpac = :prdNmpac"),
    @NamedQuery(name = "SPrd.findByPrdDtnasc", query = "SELECT s FROM SPrd s WHERE s.prdDtnasc = :prdDtnasc"),
    @NamedQuery(name = "SPrd.findByPrdSexo", query = "SELECT s FROM SPrd s WHERE s.prdSexo = :prdSexo"),
    @NamedQuery(name = "SPrd.findByPrdIbge", query = "SELECT s FROM SPrd s WHERE s.prdIbge = :prdIbge"),
    @NamedQuery(name = "SPrd.findByPrdDtaten", query = "SELECT s FROM SPrd s WHERE s.prdDtaten = :prdDtaten"),
    @NamedQuery(name = "SPrd.findByPrdCid", query = "SELECT s FROM SPrd s WHERE s.prdCid = :prdCid"),
    @NamedQuery(name = "SPrd.findByPrdIdade", query = "SELECT s FROM SPrd s WHERE s.prdIdade = :prdIdade"),
    @NamedQuery(name = "SPrd.findByPrdQtP", query = "SELECT s FROM SPrd s WHERE s.prdQtP = :prdQtP"),
    @NamedQuery(name = "SPrd.findByPrdCaten", query = "SELECT s FROM SPrd s WHERE s.prdCaten = :prdCaten"),
    @NamedQuery(name = "SPrd.findByPrdNaut", query = "SELECT s FROM SPrd s WHERE s.prdNaut = :prdNaut"),
    @NamedQuery(name = "SPrd.findByPrdOrg", query = "SELECT s FROM SPrd s WHERE s.prdOrg = :prdOrg"),
    @NamedQuery(name = "SPrd.findByPrdMvm", query = "SELECT s FROM SPrd s WHERE s.prdMvm = :prdMvm"),
    @NamedQuery(name = "SPrd.findByPrdFlpa", query = "SELECT s FROM SPrd s WHERE s.prdFlpa = :prdFlpa"),
    @NamedQuery(name = "SPrd.findByPrdFlcbo", query = "SELECT s FROM SPrd s WHERE s.prdFlcbo = :prdFlcbo"),
    @NamedQuery(name = "SPrd.findByPrdFlca", query = "SELECT s FROM SPrd s WHERE s.prdFlca = :prdFlca"),
    @NamedQuery(name = "SPrd.findByPrdFlida", query = "SELECT s FROM SPrd s WHERE s.prdFlida = :prdFlida"),
    @NamedQuery(name = "SPrd.findByPrdFlqt", query = "SELECT s FROM SPrd s WHERE s.prdFlqt = :prdFlqt"),
    @NamedQuery(name = "SPrd.findByPrdFler", query = "SELECT s FROM SPrd s WHERE s.prdFler = :prdFler"),
    @NamedQuery(name = "SPrd.findByPrdFlmun", query = "SELECT s FROM SPrd s WHERE s.prdFlmun = :prdFlmun"),
    @NamedQuery(name = "SPrd.findByPrdFlcid", query = "SELECT s FROM SPrd s WHERE s.prdFlcid = :prdFlcid"),
    @NamedQuery(name = "SPrd.findByPrdRaca", query = "SELECT s FROM SPrd s WHERE s.prdRaca = :prdRaca"),
    @NamedQuery(name = "SPrd.findByPrdEtnia", query = "SELECT s FROM SPrd s WHERE s.prdEtnia = :prdEtnia"),
    @NamedQuery(name = "SPrd.findByPrdNac", query = "SELECT s FROM SPrd s WHERE s.prdNac = :prdNac"),
    @NamedQuery(name = "SPrd.findByPrdAdvqt", query = "SELECT s FROM SPrd s WHERE s.prdAdvqt = :prdAdvqt")})
public class SPrd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PRD_UID")
    private String prdUid;
    @Column(name = "PRD_CMP")
    private String prdCmp;
    @Column(name = "PRD_CNSMED")
    private String prdCnsmed;
    @Column(name = "PRD_CBO")
    private String prdCbo;
    @Column(name = "PRD_FLH")
    private String prdFlh;
    @Column(name = "PRD_SEQ")
    private String prdSeq;
    @Column(name = "PRD_PA")
    private String prdPa;
    @Column(name = "PRD_CNSPAC")
    private String prdCnspac;
    @Column(name = "PRD_NMPAC")
    private String prdNmpac;
    @Column(name = "PRD_DTNASC")
    private String prdDtnasc;
    @Column(name = "PRD_SEXO")
    private String prdSexo;
    @Column(name = "PRD_IBGE")
    private String prdIbge;
    @Column(name = "PRD_DTATEN")
    private String prdDtaten;
    @Column(name = "PRD_CID")
    private String prdCid;
    @Column(name = "PRD_IDADE")
    private String prdIdade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRD_QT_P")
    private Double prdQtP;
    @Column(name = "PRD_CATEN")
    private String prdCaten;
    @Column(name = "PRD_NAUT")
    private String prdNaut;
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
    @Column(name = "PRD_RACA")
    private String prdRaca;
    @Column(name = "PRD_ETNIA")
    private String prdEtnia;
    @Column(name = "PRD_NAC")
    private String prdNac;
    @Column(name = "PRD_ADVQT")
    private String prdAdvqt;

    public SPrd() {
    }

    public SPrd(String prdUid) {
        this.prdUid = prdUid;
    }

    public String getPrdUid() {
        return prdUid;
    }

    public void setPrdUid(String prdUid) {
        this.prdUid = prdUid;
    }

    public String getPrdCmp() {
        return prdCmp;
    }

    public void setPrdCmp(String prdCmp) {
        this.prdCmp = prdCmp;
    }

    public String getPrdCnsmed() {
        return prdCnsmed;
    }

    public void setPrdCnsmed(String prdCnsmed) {
        this.prdCnsmed = prdCnsmed;
    }

    public String getPrdCbo() {
        return prdCbo;
    }

    public void setPrdCbo(String prdCbo) {
        this.prdCbo = prdCbo;
    }

    public String getPrdFlh() {
        return prdFlh;
    }

    public void setPrdFlh(String prdFlh) {
        this.prdFlh = prdFlh;
    }

    public String getPrdSeq() {
        return prdSeq;
    }

    public void setPrdSeq(String prdSeq) {
        this.prdSeq = prdSeq;
    }

    public String getPrdPa() {
        return prdPa;
    }

    public void setPrdPa(String prdPa) {
        this.prdPa = prdPa;
    }

    public String getPrdCnspac() {
        return prdCnspac;
    }

    public void setPrdCnspac(String prdCnspac) {
        this.prdCnspac = prdCnspac;
    }

    public String getPrdNmpac() {
        return prdNmpac;
    }

    public void setPrdNmpac(String prdNmpac) {
        this.prdNmpac = prdNmpac;
    }

    public String getPrdDtnasc() {
        return prdDtnasc;
    }

    public void setPrdDtnasc(String prdDtnasc) {
        this.prdDtnasc = prdDtnasc;
    }

    public String getPrdSexo() {
        return prdSexo;
    }

    public void setPrdSexo(String prdSexo) {
        this.prdSexo = prdSexo;
    }

    public String getPrdIbge() {
        return prdIbge;
    }

    public void setPrdIbge(String prdIbge) {
        this.prdIbge = prdIbge;
    }

    public String getPrdDtaten() {
        return prdDtaten;
    }

    public void setPrdDtaten(String prdDtaten) {
        this.prdDtaten = prdDtaten;
    }

    public String getPrdCid() {
        return prdCid;
    }

    public void setPrdCid(String prdCid) {
        this.prdCid = prdCid;
    }

    public String getPrdIdade() {
        return prdIdade;
    }

    public void setPrdIdade(String prdIdade) {
        this.prdIdade = prdIdade;
    }

    public Double getPrdQtP() {
        return prdQtP;
    }

    public void setPrdQtP(Double prdQtP) {
        this.prdQtP = prdQtP;
    }

    public String getPrdCaten() {
        return prdCaten;
    }

    public void setPrdCaten(String prdCaten) {
        this.prdCaten = prdCaten;
    }

    public String getPrdNaut() {
        return prdNaut;
    }

    public void setPrdNaut(String prdNaut) {
        this.prdNaut = prdNaut;
    }

    public String getPrdOrg() {
        return prdOrg;
    }

    public void setPrdOrg(String prdOrg) {
        this.prdOrg = prdOrg;
    }

    public String getPrdMvm() {
        return prdMvm;
    }

    public void setPrdMvm(String prdMvm) {
        this.prdMvm = prdMvm;
    }

    public String getPrdFlpa() {
        return prdFlpa;
    }

    public void setPrdFlpa(String prdFlpa) {
        this.prdFlpa = prdFlpa;
    }

    public String getPrdFlcbo() {
        return prdFlcbo;
    }

    public void setPrdFlcbo(String prdFlcbo) {
        this.prdFlcbo = prdFlcbo;
    }

    public String getPrdFlca() {
        return prdFlca;
    }

    public void setPrdFlca(String prdFlca) {
        this.prdFlca = prdFlca;
    }

    public String getPrdFlida() {
        return prdFlida;
    }

    public void setPrdFlida(String prdFlida) {
        this.prdFlida = prdFlida;
    }

    public String getPrdFlqt() {
        return prdFlqt;
    }

    public void setPrdFlqt(String prdFlqt) {
        this.prdFlqt = prdFlqt;
    }

    public String getPrdFler() {
        return prdFler;
    }

    public void setPrdFler(String prdFler) {
        this.prdFler = prdFler;
    }

    public String getPrdFlmun() {
        return prdFlmun;
    }

    public void setPrdFlmun(String prdFlmun) {
        this.prdFlmun = prdFlmun;
    }

    public String getPrdFlcid() {
        return prdFlcid;
    }

    public void setPrdFlcid(String prdFlcid) {
        this.prdFlcid = prdFlcid;
    }

    public String getPrdRaca() {
        return prdRaca;
    }

    public void setPrdRaca(String prdRaca) {
        this.prdRaca = prdRaca;
    }

    public String getPrdEtnia() {
        return prdEtnia;
    }

    public void setPrdEtnia(String prdEtnia) {
        this.prdEtnia = prdEtnia;
    }

    public String getPrdNac() {
        return prdNac;
    }

    public void setPrdNac(String prdNac) {
        this.prdNac = prdNac;
    }

    public String getPrdAdvqt() {
        return prdAdvqt;
    }

    public void setPrdAdvqt(String prdAdvqt) {
        this.prdAdvqt = prdAdvqt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prdUid != null ? prdUid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SPrd)) {
            return false;
        }
        SPrd other = (SPrd) object;
        if ((this.prdUid == null && other.prdUid != null) || (this.prdUid != null && !this.prdUid.equals(other.prdUid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPrd[ prdUid=" + prdUid + " ]";
    }
    
}
