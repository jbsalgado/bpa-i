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
@Table(name = "S_PACID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SPacid.findAll", query = "SELECT s FROM SPacid s"),
    @NamedQuery(name = "SPacid.findByPacidPa", query = "SELECT s FROM SPacid s WHERE s.sPacidPK.pacidPa = :pacidPa"),
    @NamedQuery(name = "SPacid.findByPacidCid", query = "SELECT s FROM SPacid s WHERE s.sPacidPK.pacidCid = :pacidCid"),
    @NamedQuery(name = "SPacid.findByPacidAux", query = "SELECT s FROM SPacid s WHERE s.pacidAux = :pacidAux"),
    @NamedQuery(name = "SPacid.findByPacidCmp", query = "SELECT s FROM SPacid s WHERE s.pacidCmp = :pacidCmp")})
public class ProcedimentoCID implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimentoCIDPK sPacidPK;
    @Column(name = "PACID_AUX")
    private Character pacidAux;
    @Column(name = "PACID_CMP")
    private String pacidCmp;

    public ProcedimentoCID() {
    }

    public ProcedimentoCID(ProcedimentoCIDPK sPacidPK) {
        this.sPacidPK = sPacidPK;
    }

    public ProcedimentoCID(String pacidPa, String pacidCid) {
        this.sPacidPK = new ProcedimentoCIDPK(pacidPa, pacidCid);
    }

    public ProcedimentoCIDPK getSPacidPK() {
        return sPacidPK;
    }

    public void setSPacidPK(ProcedimentoCIDPK sPacidPK) {
        this.sPacidPK = sPacidPK;
    }

    public Character getPacidAux() {
        return pacidAux;
    }

    public void setPacidAux(Character pacidAux) {
        this.pacidAux = pacidAux;
    }

    public String getPacidCmp() {
        return pacidCmp;
    }

    public void setPacidCmp(String pacidCmp) {
        this.pacidCmp = pacidCmp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sPacidPK != null ? sPacidPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedimentoCID)) {
            return false;
        }
        ProcedimentoCID other = (ProcedimentoCID) object;
        if ((this.sPacidPK == null && other.sPacidPK != null) || (this.sPacidPK != null && !this.sPacidPK.equals(other.sPacidPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacid[ sPacidPK=" + sPacidPK + " ]";
    }
    
}
