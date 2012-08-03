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
@Table(name = "S_CDN", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SCdn.findAll", query = "SELECT s FROM SCdn s"),
    @NamedQuery(name = "SCdn.findByCdnTb", query = "SELECT s FROM SCdn s WHERE s.sCdnPK.cdnTb = :cdnTb"),
    @NamedQuery(name = "SCdn.findByCdnIt", query = "SELECT s FROM SCdn s WHERE s.sCdnPK.cdnIt = :cdnIt"),
    @NamedQuery(name = "SCdn.findByCdnDscr", query = "SELECT s FROM SCdn s WHERE s.cdnDscr = :cdnDscr"),
    @NamedQuery(name = "SCdn.findByCdnAux", query = "SELECT s FROM SCdn s WHERE s.cdnAux = :cdnAux")})
public class SCdn implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SCdnPK sCdnPK;
    @Column(name = "CDN_DSCR", length = 40)
    private String cdnDscr;
    @Column(name = "CDN_AUX")
    private Character cdnAux;

    public SCdn() {
    }

    public SCdn(SCdnPK sCdnPK) {
        this.sCdnPK = sCdnPK;
    }

    public SCdn(String cdnTb, String cdnIt) {
        this.sCdnPK = new SCdnPK(cdnTb, cdnIt);
    }

    public SCdnPK getSCdnPK() {
        return sCdnPK;
    }

    public void setSCdnPK(SCdnPK sCdnPK) {
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
        if (!(object instanceof SCdn)) {
            return false;
        }
        SCdn other = (SCdn) object;
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
