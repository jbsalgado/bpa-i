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
@Table(name = "CADMED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadmed.findAll", query = "SELECT c FROM Cadmed c"),
    @NamedQuery(name = "Cadmed.findByCadmedCns", query = "SELECT c FROM Cadmed c WHERE c.cadmedCns = :cadmedCns"),
    @NamedQuery(name = "Cadmed.findByCadmedNome", query = "SELECT c FROM Cadmed c WHERE c.cadmedNome = :cadmedNome")})
public class Cadmed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CADMED_CNS")
    private String cadmedCns;
    @Basic(optional = false)
    @Column(name = "CADMED_NOME")
    private String cadmedNome;

    public Cadmed() {
    }

    public Cadmed(String cadmedCns) {
        this.cadmedCns = cadmedCns;
    }

    public Cadmed(String cadmedCns, String cadmedNome) {
        this.cadmedCns = cadmedCns;
        this.cadmedNome = cadmedNome;
    }

    public String getCadmedCns() {
        return cadmedCns;
    }

    public void setCadmedCns(String cadmedCns) {
        this.cadmedCns = cadmedCns;
    }

    public String getCadmedNome() {
        return cadmedNome;
    }

    public void setCadmedNome(String cadmedNome) {
        this.cadmedNome = cadmedNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cadmedCns != null ? cadmedCns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadmed)) {
            return false;
        }
        Cadmed other = (Cadmed) object;
        if ((this.cadmedCns == null && other.cadmedCns != null) || (this.cadmedCns != null && !this.cadmedCns.equals(other.cadmedCns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Cadmed[ cadmedCns=" + cadmedCns + " ]";
    }
    
}
