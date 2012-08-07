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
public class ProcedimentoProcedimento implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProcedimentoProcedimentoPK sPapaPK;
    @Column(name = "PAPA_PRINC")
    private String papaPrinc;
    @Column(name = "PAPA_SECUN")
    private String papaSecun;
    @Column(name = "PAPA_QTMAX")
    private String papaQtmax;

    public ProcedimentoProcedimento() {
    }

    public ProcedimentoProcedimento(ProcedimentoProcedimentoPK sPapaPK) {
        this.sPapaPK = sPapaPK;
    }

    public ProcedimentoProcedimento(String papaCmp, String papaTrat) {
        this.sPapaPK = new ProcedimentoProcedimentoPK(papaCmp, papaTrat);
    }

    public ProcedimentoProcedimentoPK getSPapaPK() {
        return sPapaPK;
    }

    public void setSPapaPK(ProcedimentoProcedimentoPK sPapaPK) {
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
        if (!(object instanceof ProcedimentoProcedimento)) {
            return false;
        }
        ProcedimentoProcedimento other = (ProcedimentoProcedimento) object;
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
