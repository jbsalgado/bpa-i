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
    protected MunicipioPK municipioPK;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "CONDIC")
    private String condicicao;
    @Column(name = "DTHABIL")
    private String dataHabilitacao;
    @Column(name = "AUX")
    private Character aux;

    public Municipio() {
    }

    public Municipio(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public Municipio(MunicipioPK municipioPK, String nome, String condicicao, String dataHabilitacao, Character aux) {
        this.municipioPK = municipioPK;
        this.nome = nome;
        this.condicicao = condicicao;
        this.dataHabilitacao = dataHabilitacao;
        this.aux = aux;
    }

    public Character getAux() {
        return aux;
    }

    public void setAux(Character aux) {
        this.aux = aux;
    }

    public String getCondicicao() {
        return condicicao;
    }

    public void setCondicicao(String condicicao) {
        this.condicicao = condicicao;
    }

    public String getDataHabilitacao() {
        return dataHabilitacao;
    }

    public void setDataHabilitacao(String dataHabilitacao) {
        this.dataHabilitacao = dataHabilitacao;
    }

    public MunicipioPK getMunicipioPK() {
        return municipioPK;
    }

    public void setMunicipioPK(MunicipioPK municipioPK) {
        this.municipioPK = municipioPK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (municipioPK != null ? municipioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.municipioPK == null && other.municipioPK != null) || (this.municipioPK != null && !this.municipioPK.equals(other.municipioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Cadmun[ cadmunPK=" + municipioPK + " ]";
    }
    
}
