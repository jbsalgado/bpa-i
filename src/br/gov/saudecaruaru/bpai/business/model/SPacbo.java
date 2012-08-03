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
@Table(name = "S_PACBO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SPacbo.findAll", query = "SELECT s FROM SPacbo s"),
    @NamedQuery(name = "SPacbo.findByPacboPa", query = "SELECT s FROM SPacbo s WHERE s.sPacboPK.pacboPa = :pacboPa"),
    @NamedQuery(name = "SPacbo.findByPacboCbo", query = "SELECT s FROM SPacbo s WHERE s.sPacboPK.pacboCbo = :pacboCbo"),
    @NamedQuery(name = "SPacbo.findByPacboAux", query = "SELECT s FROM SPacbo s WHERE s.pacboAux = :pacboAux"),
    @NamedQuery(name = "SPacbo.findByPacboCmp", query = "SELECT s FROM SPacbo s WHERE s.pacboCmp = :pacboCmp")})
public class SPacbo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SPacboPK sPacboPK;
    @Column(name = "PACBO_AUX")
    private Character pacboAux;
    @Column(name = "PACBO_CMP")
    private String pacboCmp;

    public SPacbo() {
    }

    public SPacbo(SPacboPK sPacboPK) {
        this.sPacboPK = sPacboPK;
    }

    public SPacbo(String pacboPa, String pacboCbo) {
        this.sPacboPK = new SPacboPK(pacboPa, pacboCbo);
    }

    public SPacboPK getSPacboPK() {
        return sPacboPK;
    }

    public void setSPacboPK(SPacboPK sPacboPK) {
        this.sPacboPK = sPacboPK;
    }

    public Character getPacboAux() {
        return pacboAux;
    }

    public void setPacboAux(Character pacboAux) {
        this.pacboAux = pacboAux;
    }

    public String getPacboCmp() {
        return pacboCmp;
    }

    public void setPacboCmp(String pacboCmp) {
        this.pacboCmp = pacboCmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sPacboPK != null ? sPacboPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SPacbo)) {
            return false;
        }
        SPacbo other = (SPacbo) object;
        if ((this.sPacboPK == null && other.sPacboPK != null) || (this.sPacboPK != null && !this.sPacboPK.equals(other.sPacboPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacbo[ sPacboPK=" + sPacboPK + " ]";
    }
    
}
