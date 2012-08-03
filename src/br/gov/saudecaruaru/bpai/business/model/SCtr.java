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
@Table(name = "S_CTR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SCtr.findAll", query = "SELECT s FROM SCtr s"),
    @NamedQuery(name = "SCtr.findByCtrMvm", query = "SELECT s FROM SCtr s WHERE s.ctrMvm = :ctrMvm"),
    @NamedQuery(name = "SCtr.findByCtrTab", query = "SELECT s FROM SCtr s WHERE s.ctrTab = :ctrTab"),
    @NamedQuery(name = "SCtr.findByCtrTipo", query = "SELECT s FROM SCtr s WHERE s.ctrTipo = :ctrTipo"),
    @NamedQuery(name = "SCtr.findByCtrCoduni", query = "SELECT s FROM SCtr s WHERE s.ctrCoduni = :ctrCoduni"),
    @NamedQuery(name = "SCtr.findByCtrNome", query = "SELECT s FROM SCtr s WHERE s.ctrNome = :ctrNome"),
    @NamedQuery(name = "SCtr.findByCtrSigl", query = "SELECT s FROM SCtr s WHERE s.ctrSigl = :ctrSigl"),
    @NamedQuery(name = "SCtr.findByCtrCgc", query = "SELECT s FROM SCtr s WHERE s.ctrCgc = :ctrCgc"),
    @NamedQuery(name = "SCtr.findByCtrNmss", query = "SELECT s FROM SCtr s WHERE s.ctrNmss = :ctrNmss"),
    @NamedQuery(name = "SCtr.findByCtrUf", query = "SELECT s FROM SCtr s WHERE s.ctrUf = :ctrUf"),
    @NamedQuery(name = "SCtr.findByCtrMn", query = "SELECT s FROM SCtr s WHERE s.ctrMn = :ctrMn")})
public class SCtr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CTR_MVM")
    private String ctrMvm;
    @Column(name = "CTR_TAB")
    private String ctrTab;
    @Basic(optional = false)
    @Column(name = "CTR_TIPO")
    private char ctrTipo;
    @Basic(optional = false)
    @Column(name = "CTR_CODUNI")
    private String ctrCoduni;
    @Id
    @Basic(optional = false)
    @Column(name = "CTR_NOME")
    private String ctrNome;
    @Column(name = "CTR_SIGL")
    private String ctrSigl;
    @Column(name = "CTR_CGC")
    private String ctrCgc;
    @Column(name = "CTR_NMSS")
    private String ctrNmss;
    @Column(name = "CTR_UF")
    private String ctrUf;
    @Column(name = "CTR_MN")
    private String ctrMn;

    public SCtr() {
    }

    public SCtr(String ctrNome) {
        this.ctrNome = ctrNome;
    }

    public SCtr(String ctrNome, char ctrTipo, String ctrCoduni) {
        this.ctrNome = ctrNome;
        this.ctrTipo = ctrTipo;
        this.ctrCoduni = ctrCoduni;
    }

    public String getCtrMvm() {
        return ctrMvm;
    }

    public void setCtrMvm(String ctrMvm) {
        this.ctrMvm = ctrMvm;
    }

    public String getCtrTab() {
        return ctrTab;
    }

    public void setCtrTab(String ctrTab) {
        this.ctrTab = ctrTab;
    }

    public char getCtrTipo() {
        return ctrTipo;
    }

    public void setCtrTipo(char ctrTipo) {
        this.ctrTipo = ctrTipo;
    }

    public String getCtrCoduni() {
        return ctrCoduni;
    }

    public void setCtrCoduni(String ctrCoduni) {
        this.ctrCoduni = ctrCoduni;
    }

    public String getCtrNome() {
        return ctrNome;
    }

    public void setCtrNome(String ctrNome) {
        this.ctrNome = ctrNome;
    }

    public String getCtrSigl() {
        return ctrSigl;
    }

    public void setCtrSigl(String ctrSigl) {
        this.ctrSigl = ctrSigl;
    }

    public String getCtrCgc() {
        return ctrCgc;
    }

    public void setCtrCgc(String ctrCgc) {
        this.ctrCgc = ctrCgc;
    }

    public String getCtrNmss() {
        return ctrNmss;
    }

    public void setCtrNmss(String ctrNmss) {
        this.ctrNmss = ctrNmss;
    }

    public String getCtrUf() {
        return ctrUf;
    }

    public void setCtrUf(String ctrUf) {
        this.ctrUf = ctrUf;
    }

    public String getCtrMn() {
        return ctrMn;
    }

    public void setCtrMn(String ctrMn) {
        this.ctrMn = ctrMn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ctrNome != null ? ctrNome.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SCtr)) {
            return false;
        }
        SCtr other = (SCtr) object;
        if ((this.ctrNome == null && other.ctrNome != null) || (this.ctrNome != null && !this.ctrNome.equals(other.ctrNome))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCtr[ ctrNome=" + ctrNome + " ]";
    }
    
}
