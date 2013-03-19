/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author juniorpires
 */
@Entity
@Table(name="DOENCA_CONDICAO",uniqueConstraints = { @UniqueConstraint( columnNames = "sigla" ) })
@SequenceGenerator(name="INC_DOENCACOND_ID",sequenceName="GEN_DOENCACOND_ID",allocationSize=0,initialValue=1)
public class BIDoencaCondicao implements Serializable{
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="INC_DOENCACOND_ID")
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;
    
    @Basic(optional=false)
    @Column(name="sigla",length=3)
    private String sigla;
    
    @Column(name="nome",length=45)
    private String nome;

    @ManyToMany(targetEntity=br.gov.saudecaruaru.bpai.business.model.BIPaciente.class,fetch = FetchType.LAZY, mappedBy = "doencaCondicaoList")
    @JoinTable(
            name="PACIENTE_DOENCA_CONDICAO",
            joinColumns={@JoinColumn(name="doenca_condicao_id")},inverseJoinColumns={@JoinColumn(name="paciente_id")})
    private Collection<BIPaciente> pacientes; 
    public BIDoencaCondicao(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public BIDoencaCondicao(Integer id) {
        this.id = id;
    }

    public BIDoencaCondicao(Integer id, String sigla, String nome) {
        this.id = id;
        this.sigla = sigla;
        this.nome = nome;
    }

    
    public BIDoencaCondicao() {
    }

    
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.sigla+"-"+this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BIDoencaCondicao other = (BIDoencaCondicao) obj;
        if ((this.sigla == null) ? (other.sigla != null) : !this.sigla.equals(other.sigla)) {
            return false;
        }
        if ((this.nome == null) ? (other.nome != null) : !this.nome.equals(other.nome)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + (this.sigla != null ? this.sigla.hashCode() : 0);
        hash = 83 * hash + (this.nome != null ? this.nome.hashCode() : 0);
        return hash;
    }
    
    
    
}
