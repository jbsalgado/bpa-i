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
@Table(name = "SYSUAF", catalog = "", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sysuaf.findAll", query = "SELECT s FROM Sysuaf s"),
    @NamedQuery(name = "Sysuaf.findByUsername", query = "SELECT s FROM Sysuaf s WHERE s.username = :username"),
    @NamedQuery(name = "Sysuaf.findBySenha", query = "SELECT s FROM Sysuaf s WHERE s.senha = :senha")})
public class Sysuaf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "USERNAME", nullable = false, length = 15)
    private String username;
    @Basic(optional = false)
    @Column(name = "SENHA", nullable = false, length = 45)
    private String senha;

    public Sysuaf() {
    }

    public Sysuaf(String username) {
        this.username = username;
    }

    public Sysuaf(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sysuaf)) {
            return false;
        }
        Sysuaf other = (Sysuaf) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.Sysuaf[ username=" + username + " ]";
    }
    
}
