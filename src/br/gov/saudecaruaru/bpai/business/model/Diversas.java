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
@Table(name = "S_CDN")
public class Diversas implements Serializable {
    private static final Long serialVersionUID = 1L;
    @EmbeddedId
    protected DiversasPK sCdnPK;
    @Column(name = "CDN_DSCR")
    private String cdnDscr;
    @Column(name = "CDN_AUX")
    private Character cdnAux;

    public Diversas() {
    }

    public Diversas(DiversasPK sCdnPK) {
        this.sCdnPK = sCdnPK;
    }

    public Diversas(String cdnTb, String cdnIt) {
        this.sCdnPK = new DiversasPK(cdnTb, cdnIt);
    }

    public DiversasPK getSCdnPK() {
        return sCdnPK;
    }

    public void setSCdnPK(DiversasPK sCdnPK) {
        this.sCdnPK = sCdnPK;
    }

    public String getCdnDscr() {
        return cdnDscr;
    }

    public void setCdnDscr(String cdnDscr) {
        this.cdnDscr = cdnDscr;
    }

    public Character getCdnAux() {
        return cdnAux;
    }

    public void setCdnAux(Character cdnAux) {
        this.cdnAux = cdnAux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sCdnPK != null ? sCdnPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Diversas)) {
            return false;
        }
        Diversas other = (Diversas) object;
        if ((this.sCdnPK == null && other.sCdnPK != null) || (this.sCdnPK != null && !this.sCdnPK.equals(other.sCdnPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCdn[ sCdnPK=" + sCdnPK + " ]";
    }
    
}
