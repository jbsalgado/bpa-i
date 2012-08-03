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
@Table(name = "CADCNS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadcns.findAll", query = "SELECT c FROM Cadcns c"),
    @NamedQuery(name = "Cadcns.findByCns", query = "SELECT c FROM Cadcns c WHERE c.cns = :cns"),
    @NamedQuery(name = "Cadcns.findByNome", query = "SELECT c FROM Cadcns c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cadcns.findByDtnasc", query = "SELECT c FROM Cadcns c WHERE c.dtnasc = :dtnasc"),
    @NamedQuery(name = "Cadcns.findBySexo", query = "SELECT c FROM Cadcns c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Cadcns.findByRaca", query = "SELECT c FROM Cadcns c WHERE c.raca = :raca"),
    @NamedQuery(name = "Cadcns.findByMaepcn", query = "SELECT c FROM Cadcns c WHERE c.maepcn = :maepcn"),
    @NamedQuery(name = "Cadcns.findByLogpcn", query = "SELECT c FROM Cadcns c WHERE c.logpcn = :logpcn"),
    @NamedQuery(name = "Cadcns.findByNumpcn", query = "SELECT c FROM Cadcns c WHERE c.numpcn = :numpcn"),
    @NamedQuery(name = "Cadcns.findByCplpcn", query = "SELECT c FROM Cadcns c WHERE c.cplpcn = :cplpcn"),
    @NamedQuery(name = "Cadcns.findByCeppcn", query = "SELECT c FROM Cadcns c WHERE c.ceppcn = :ceppcn"),
    @NamedQuery(name = "Cadcns.findByNmres", query = "SELECT c FROM Cadcns c WHERE c.nmres = :nmres"),
    @NamedQuery(name = "Cadcns.findByIbge", query = "SELECT c FROM Cadcns c WHERE c.ibge = :ibge"),
    @NamedQuery(name = "Cadcns.findByEtnia", query = "SELECT c FROM Cadcns c WHERE c.etnia = :etnia"),
    @NamedQuery(name = "Cadcns.findByNacionalidade", query = "SELECT c FROM Cadcns c WHERE c.nacionalidade = :nacionalidade")})
public class Cadcns implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CNS")
    private String cns;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "DTNASC")
    private String dtnasc;
    @Column(name = "SEXO")
    private Character sexo;
    @Column(name = "RACA")
    private String raca;
    @Column(name = "MAEPCN")
    private String maepcn;
    @Column(name = "LOGPCN")
    private String logpcn;
    @Column(name = "NUMPCN")
    private String numpcn;
    @Column(name = "CPLPCN")
    private String cplpcn;
    @Column(name = "CEPPCN")
    private String ceppcn;
    @Column(name = "NMRES")
    private String nmres;
    @Column(name = "IBGE")
    private String ibge;
    @Column(name = "ETNIA")
    private String etnia;
    @Column(name = "NACIONALIDADE")
    private String nacionalidade;

    public Cadcns() {
    }

    public Cadcns(String cns) {
        this.cns = cns;
    }

    public Cadcns(String cns, String nome) {
        this.cns = cns;
        this.nome = nome;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtnasc() {
        return dtnasc;
    }

    public void setDtnasc(String dtnasc) {
        this.dtnasc = dtnasc;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getMaepcn() {
        return maepcn;
    }

    public void setMaepcn(String maepcn) {
        this.maepcn = maepcn;
    }

    public String getLogpcn() {
        return logpcn;
    }

    public void setLogpcn(String logpcn) {
        this.logpcn = logpcn;
    }

    public String getNumpcn() {
        return numpcn;
    }

    public void setNumpcn(String numpcn) {
        this.numpcn = numpcn;
    }

    public String getCplpcn() {
        return cplpcn;
    }

    public void setCplpcn(String cplpcn) {
        this.cplpcn = cplpcn;
    }

    public String getCeppcn() {
        return ceppcn;
    }

    public void setCeppcn(String ceppcn) {
        this.ceppcn = ceppcn;
    }

    public String getNmres() {
        return nmres;
    }

    public void setNmres(String nmres) {
        this.nmres = nmres;
    }

    public String getIbge() {
        return ibge;
    }

    public void setIbge(String ibge) {
        this.ibge = ibge;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cns != null ? cns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadcns)) {
            return false;
        }
        Cadcns other = (Cadcns) object;
        if ((this.cns == null && other.cns != null) || (this.cns != null && !this.cns.equals(other.cns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Cadcns[ cns=" + cns + " ]";
    }
    
}
