/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Junior Pires
 */
@Embeddable
public class DiversasPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CDN_TB")
    private String cdnTb;
    @Basic(optional = false)
    @Column(name = "CDN_IT")
    private String cdnIt;

    public DiversasPK() {
    }

    public DiversasPK(String cdnTb, String cdnIt) {
        this.cdnTb = cdnTb;
        this.cdnIt = cdnIt;
    }

    public String getCdnTb() {
        return cdnTb;
    }

    public void setCdnTb(String cdnTb) {
        this.cdnTb = cdnTb;
    }

    public String getCdnIt() {
        return cdnIt;
    }

    public void setCdnIt(String cdnIt) {
        this.cdnIt = cdnIt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdnTb != null ? cdnTb.hashCode() : 0);
        hash += (cdnIt != null ? cdnIt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiversasPK)) {
            return false;
        }
        DiversasPK other = (DiversasPK) object;
        if ((this.cdnTb == null && other.cdnTb != null) || (this.cdnTb != null && !this.cdnTb.equals(other.cdnTb))) {
            return false;
        }
        if ((this.cdnIt == null && other.cdnIt != null) || (this.cdnIt != null && !this.cdnIt.equals(other.cdnIt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCdnPK[ cdnTb=" + cdnTb + ", cdnIt=" + cdnIt + " ]";
    }
    
}
