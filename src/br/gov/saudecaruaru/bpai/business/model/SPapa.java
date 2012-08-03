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
@Table(name = "S_PAPA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SPapa.findAll", query = "SELECT s FROM SPapa s"),
    @NamedQuery(name = "SPapa.findByPapaCmp", query = "SELECT s FROM SPapa s WHERE s.sPapaPK.papaCmp = :papaCmp"),
    @NamedQuery(name = "SPapa.findByPapaTrat", query = "SELECT s FROM SPapa s WHERE s.sPapaPK.papaTrat = :papaTrat"),
    @NamedQuery(name = "SPapa.findByPapaPrinc", query = "SELECT s FROM SPapa s WHERE s.papaPrinc = :papaPrinc"),
    @NamedQuery(name = "SPapa.findByPapaSecun", query = "SELECT s FROM SPapa s WHERE s.papaSecun = :papaSecun"),
    @NamedQuery(name = "SPapa.findByPapaQtmax", query = "SELECT s FROM SPapa s WHERE s.papaQtmax = :papaQtmax")})
public class SPapa implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SPapaPK sPapaPK;
    @Column(name = "PAPA_PRINC")
    private String papaPrinc;
    @Column(name = "PAPA_SECUN")
    private String papaSecun;
    @Column(name = "PAPA_QTMAX")
    private String papaQtmax;

    public SPapa() {
    }

    public SPapa(SPapaPK sPapaPK) {
        this.sPapaPK = sPapaPK;
    }

    public SPapa(String papaCmp, String papaTrat) {
        this.sPapaPK = new SPapaPK(papaCmp, papaTrat);
    }

    public SPapaPK getSPapaPK() {
        return sPapaPK;
    }

    public void setSPapaPK(SPapaPK sPapaPK) {
        this.sPapaPK = sPapaPK;
    }

    public String getPapaPrinc() {
        return papaPrinc;
    }

    public void setPapaPrinc(String papaPrinc) {
        this.papaPrinc = papaPrinc;
    }

    public String getPapaSecun() {
        return papaSecun;
    }

    public void setPapaSecun(String papaSecun) {
        this.papaSecun = papaSecun;
    }

    public String getPapaQtmax() {
        return papaQtmax;
    }

    public void setPapaQtmax(String papaQtmax) {
        this.papaQtmax = papaQtmax;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sPapaPK != null ? sPapaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SPapa)) {
            return false;
        }
        SPapa other = (SPapa) object;
        if ((this.sPapaPK == null && other.sPapaPK != null) || (this.sPapaPK != null && !this.sPapaPK.equals(other.sPapaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPapa[ sPapaPK=" + sPapaPK + " ]";
    }
    
}
