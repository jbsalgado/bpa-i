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
@Table(name = "APLICAC", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aplicac.findAll", query = "SELECT a FROM Aplicac a"),
    @NamedQuery(name = "Aplicac.findByModulo", query = "SELECT a FROM Aplicac a WHERE a.aplicacPK.modulo = :modulo"),
    @NamedQuery(name = "Aplicac.findByRotina", query = "SELECT a FROM Aplicac a WHERE a.aplicacPK.rotina = :rotina"),
    @NamedQuery(name = "Aplicac.findByFuncao", query = "SELECT a FROM Aplicac a WHERE a.aplicacPK.funcao = :funcao"),
    @NamedQuery(name = "Aplicac.findByDescricao", query = "SELECT a FROM Aplicac a WHERE a.descricao = :descricao")})
public class Aplicac implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AplicacPK aplicacPK;
    @Column(name = "DESCRICAO", length = 40)
    private String descricao;

    public Aplicac() {
    }

    public Aplicac(AplicacPK aplicacPK) {
        this.aplicacPK = aplicacPK;
    }

    public Aplicac(String modulo, String rotina, String funcao) {
        this.aplicacPK = new AplicacPK(modulo, rotina, funcao);
    }

    public AplicacPK getAplicacPK() {
        return aplicacPK;
    }

    public void setAplicacPK(AplicacPK aplicacPK) {
        this.aplicacPK = aplicacPK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aplicacPK != null ? aplicacPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aplicac)) {
            return false;
        }
        Aplicac other = (Aplicac) object;
        if ((this.aplicacPK == null && other.aplicacPK != null) || (this.aplicacPK != null && !this.aplicacPK.equals(other.aplicacPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Aplicac[ aplicacPK=" + aplicacPK + " ]";
    }
    
}
