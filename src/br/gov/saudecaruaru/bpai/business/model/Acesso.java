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
@Table(name = "ACESSO")
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AcessoPK acessoPK;

    public Acesso() {
    }

    public Acesso(AcessoPK acessoPK) {
        this.acessoPK = acessoPK;
    }

    public Acesso(String username, String modulo, String rotina, String funcao) {
        this.acessoPK = new AcessoPK(username, modulo, rotina, funcao);
    }

    public AcessoPK getAcessoPK() {
        return acessoPK;
    }

    public void setAcessoPK(AcessoPK acessoPK) {
        this.acessoPK = acessoPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acessoPK != null ? acessoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.acessoPK == null && other.acessoPK != null) || (this.acessoPK != null && !this.acessoPK.equals(other.acessoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Acesso[ acessoPK=" + acessoPK + " ]";
    }
    
}
