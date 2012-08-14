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
public class ProcedimentoDoencaPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "PACID_PA")
    private String procedimentoCodigo;
    
    @Basic(optional = false)
    @Column(name = "PACID_CID")
    private String codigoCid;
    
    @Basic(optional = false)
    @Column(name = "PACID_CMP")
    private String competencia;

    public ProcedimentoDoencaPK() {
    }

    
    public ProcedimentoDoencaPK(String procedimentoCodigo, String codigoCid, String competencia) {
        this.procedimentoCodigo = procedimentoCodigo;
        this.codigoCid = codigoCid;
        this.competencia = competencia;
    }

    public String getCodigoCid() {
        return codigoCid;
    }

    public void setCodigoCid(String codigoCid) {
        this.codigoCid = codigoCid;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getProcedimentoCodigo() {
        return procedimentoCodigo;
    }

    public void setProcedimentoCodigo(String procedimentoCodigo) {
        this.procedimentoCodigo = procedimentoCodigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProcedimentoDoencaPK other = (ProcedimentoDoencaPK) obj;
        if ((this.procedimentoCodigo == null) ? (other.procedimentoCodigo != null) : !this.procedimentoCodigo.equals(other.procedimentoCodigo)) {
            return false;
        }
        if ((this.codigoCid == null) ? (other.codigoCid != null) : !this.codigoCid.equals(other.codigoCid)) {
            return false;
        }
        if ((this.competencia == null) ? (other.competencia != null) : !this.competencia.equals(other.competencia)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.procedimentoCodigo != null ? this.procedimentoCodigo.hashCode() : 0);
        hash = 97 * hash + (this.codigoCid != null ? this.codigoCid.hashCode() : 0);
        hash = 97 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SPacidPK[ pacidPa=" + procedimentoCodigo + ", pacidCid=" + codigoCid + " ]";
    }
    
}
