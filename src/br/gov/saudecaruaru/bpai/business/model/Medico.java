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
public class Medico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CADMED_CNS")
    private String cns;
    @Column(name = "CADMED_NOME")
    private String nome;

    public Medico() {
    }

    public Medico(ProcedimentoRealizado procedimentoRealizado){
        this.cns=procedimentoRealizado.getProcedimentoRealizadoPK().getCnsMedico();
        this.nome=procedimentoRealizado.getNomeProfissional();
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
        if(nome!=null){
            if(nome.length()>=30){
                this.nome = nome.substring(0, 30);
                return;
            }
        }
            this.nome = nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medico other = (Medico) obj;
        if ((this.cns == null) ? (other.cns != null) : !this.cns.equals(other.cns)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.cns != null ? this.cns.hashCode() : 0);
        return hash;
    }

    public Medico(String cns) {
        this.cns = cns;
    }

    public Medico(String cns, String nome) {
        this.cns = cns;
        this.nome = nome;
    }

    

    @Override
    public String toString() {
        return this.nome;
    }
    
}
