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
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MunicipioPK cadmunPK;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CONDIC")
    private String condic;
    @Column(name = "DTHABIL")
    private String dthabil;
    @Column(name = "AUX")
    private Character aux;

    public Municipio() {
    }

    public Municipio(MunicipioPK cadmunPK) {
        this.cadmunPK = cadmunPK;
    }

    public Municipio(String coduf, String codmunic) {
        this.cadmunPK = new MunicipioPK(coduf, codmunic);
    }

    public MunicipioPK getCadmunPK() {
        return cadmunPK;
    }

    public void setCadmunPK(MunicipioPK cadmunPK) {
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
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
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
