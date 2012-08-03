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
public class AcessoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "MODULO")
    private String modulo;
    @Basic(optional = false)
    @Column(name = "ROTINA")
    private String rotina;
    @Basic(optional = false)
    @Column(name = "FUNCAO")
    private String funcao;

    public AcessoPK() {
    }

    public AcessoPK(String username, String modulo, String rotina, String funcao) {
        this.username = username;
        this.modulo = modulo;
        this.rotina = rotina;
        this.funcao = funcao;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getRotina() {
        return rotina;
    }

    public void setRotina(String rotina) {
        this.rotina = rotina;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        hash += (modulo != null ? modulo.hashCode() : 0);
        hash += (rotina != null ? rotina.hashCode() : 0);
        hash += (funcao != null ? funcao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcessoPK)) {
            return false;
        }
        AcessoPK other = (AcessoPK) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        if ((this.modulo == null && other.modulo != null) || (this.modulo != null && !this.modulo.equals(other.modulo))) {
            return false;
        }
        if ((this.rotina == null && other.rotina != null) || (this.rotina != null && !this.rotina.equals(other.rotina))) {
            return false;
        }
        if ((this.funcao == null && other.funcao != null) || (this.funcao != null && !this.funcao.equals(other.funcao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.AcessoPK[ username=" + username + ", modulo=" + modulo + ", rotina=" + rotina + ", funcao=" + funcao + " ]";
    }
    
}
