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
    private String codigoTabela;
    @Basic(optional = false)
    @Column(name = "CDN_IT")
    private String codigoItemTabela;

    public DiversasPK() {
    }

    public DiversasPK(String codigoTabela, String codigoItemTabela) {
        this.codigoTabela = codigoTabela;
        this.codigoItemTabela = codigoItemTabela;
    }

    public String getCodigoItemTabela() {
        return codigoItemTabela;
    }

    public void setCodigoItemTabela(String codigoItemTabela) {
        this.codigoItemTabela = codigoItemTabela;
    }

    public String getCodigoTabela() {
        return codigoTabela;
    }

    public void setCodigoTabela(String codigoTabela) {
        this.codigoTabela = codigoTabela;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DiversasPK other = (DiversasPK) obj;
        if ((this.codigoTabela == null) ? (other.codigoTabela != null) : !this.codigoTabela.trim().equals(other.codigoTabela.trim())) {
            return false;
        }
        if ((this.codigoItemTabela == null) ? (other.codigoItemTabela != null) : !this.codigoItemTabela.trim().equals(other.codigoItemTabela.trim())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.codigoTabela != null ? this.codigoTabela.trim().hashCode() : 0);
        hash = 97 * hash + (this.codigoItemTabela != null ? this.codigoItemTabela.trim().hashCode() : 0);
        return hash;
    }

    
    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCdnPK[ cdnTb=" + codigoTabela + ", cdnIt=" + codigoItemTabela + " ]";
    }
    
}
