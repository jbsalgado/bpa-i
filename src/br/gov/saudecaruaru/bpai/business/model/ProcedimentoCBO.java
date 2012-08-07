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
public class ProcedimentoCBO implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimentoCBOPK sPacboPK;
    @Column(name = "PACBO_AUX")
    private Character pacboAux;
    @Column(name = "PACBO_CMP")
    private String pacboCmp;

    public ProcedimentoCBO() {
    }

    public ProcedimentoCBO(ProcedimentoCBOPK sPacboPK) {
        this.sPacboPK = sPacboPK;
    }

    public ProcedimentoCBO(String pacboPa, String pacboCbo) {
        this.sPacboPK = new ProcedimentoCBOPK(pacboPa, pacboCbo);
    }

    public ProcedimentoCBOPK getSPacboPK() {
        return sPacboPK;
    }

    public void setSPacboPK(ProcedimentoCBOPK sPacboPK) {
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
        if (!(object instanceof ProcedimentoCBO)) {
            return false;
        }
        ProcedimentoCBO other = (ProcedimentoCBO) object;
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
