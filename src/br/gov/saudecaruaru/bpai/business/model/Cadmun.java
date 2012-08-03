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
@Table(name = "CADMUN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadmun.findAll", query = "SELECT c FROM Cadmun c"),
    @NamedQuery(name = "Cadmun.findByCoduf", query = "SELECT c FROM Cadmun c WHERE c.cadmunPK.coduf = :coduf"),
    @NamedQuery(name = "Cadmun.findByCodmunic", query = "SELECT c FROM Cadmun c WHERE c.cadmunPK.codmunic = :codmunic"),
    @NamedQuery(name = "Cadmun.findByNome", query = "SELECT c FROM Cadmun c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cadmun.findByCondic", query = "SELECT c FROM Cadmun c WHERE c.condic = :condic"),
    @NamedQuery(name = "Cadmun.findByDthabil", query = "SELECT c FROM Cadmun c WHERE c.dthabil = :dthabil"),
    @NamedQuery(name = "Cadmun.findByAux", query = "SELECT c FROM Cadmun c WHERE c.aux = :aux")})
public class Cadmun implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CadmunPK cadmunPK;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CONDIC")
    private String condic;
    @Column(name = "DTHABIL")
    private String dthabil;
    @Column(name = "AUX")
    private Character aux;

    public Cadmun() {
    }

    public Cadmun(CadmunPK cadmunPK) {
        this.cadmunPK = cadmunPK;
    }

    public Cadmun(String coduf, String codmunic) {
        this.cadmunPK = new CadmunPK(coduf, codmunic);
    }

    public CadmunPK getCadmunPK() {
        return cadmunPK;
    }

    public void setCadmunPK(CadmunPK cadmunPK) {
        this.cadmunPK = cadmunPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCondic() {
        return condic;
    }

    public void setCondic(String condic) {
        this.condic = condic;
    }

    public String getDthabil() {
        return dthabil;
    }

    public void setDthabil(String dthabil) {
        this.dthabil = dthabil;
    }

    public Character getAux() {
        return aux;
    }

    public void setAux(Character aux) {
        this.aux = aux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cadmunPK != null ? cadmunPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadmun)) {
            return false;
        }
        Cadmun other = (Cadmun) object;
        if ((this.cadmunPK == null && other.cadmunPK != null) || (this.cadmunPK != null && !this.cadmunPK.equals(other.cadmunPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Cadmun[ cadmunPK=" + cadmunPK + " ]";
    }
    
}
