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
@Table(name = "CADMED_CBO_CNES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadmedCboCnes.findAll", query = "SELECT c FROM CadmedCboCnes c"),
    @NamedQuery(name = "CadmedCboCnes.findByMedCns", query = "SELECT c FROM CadmedCboCnes c WHERE c.cadmedCboCnesPK.medCns = :medCns"),
    @NamedQuery(name = "CadmedCboCnes.findByMedCbo", query = "SELECT c FROM CadmedCboCnes c WHERE c.cadmedCboCnesPK.medCbo = :medCbo"),
    @NamedQuery(name = "CadmedCboCnes.findByMedCnes", query = "SELECT c FROM CadmedCboCnes c WHERE c.cadmedCboCnesPK.medCnes = :medCnes")})
public class CadmedCboCnes implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CadmedCboCnesPK cadmedCboCnesPK;

    public CadmedCboCnes() {
    }

    public CadmedCboCnes(CadmedCboCnesPK cadmedCboCnesPK) {
        this.cadmedCboCnesPK = cadmedCboCnesPK;
    }

    public CadmedCboCnes(String medCns, String medCbo, String medCnes) {
        this.cadmedCboCnesPK = new CadmedCboCnesPK(medCns, medCbo, medCnes);
    }

    public CadmedCboCnesPK getCadmedCboCnesPK() {
        return cadmedCboCnesPK;
    }

    public void setCadmedCboCnesPK(CadmedCboCnesPK cadmedCboCnesPK) {
        this.cadmedCboCnesPK = cadmedCboCnesPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cadmedCboCnesPK != null ? cadmedCboCnesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadmedCboCnes)) {
            return false;
        }
        CadmedCboCnes other = (CadmedCboCnes) object;
        if ((this.cadmedCboCnesPK == null && other.cadmedCboCnesPK != null) || (this.cadmedCboCnesPK != null && !this.cadmedCboCnesPK.equals(other.cadmedCboCnesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.CadmedCboCnes[ cadmedCboCnesPK=" + cadmedCboCnesPK + " ]";
    }
    
}
