/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;
/**
 *
 * @author juniorpires
 */
@Entity
@Table(name="Paciente")
public class BIPaciente implements Serializable {
    @Id
    @Basic(optional=false)
    @Column(name = "cns")
    private String cns;
    
    @Basic(optional = false)
    @Column(name="nome")
    private String nome;
   
    @Column(name="data_nascimento")
    private String dataNascimento;
  
    @Column(name="idade")
    private int idade;
   
    @Column(name="sexo")
    private Character sexo;
   
    @Column(name = "alfabetizado")
    private Character alfabetizado;
   
    @Column(name="ocupacao")
    private String ocupacao;
    
    @Column(name="doenca_condicao")
    private String doencaCondicao;
    
    @ManyToOne
    @JoinColumn(name="familia_id")
    private BIFamilia familia;
    /**
     * @return the cns
     */
    public String getCns() {
        return cns;
    }

    /**
     * @param cns the cns to set
     */
    public void setCns(String cns) {
        this.cns = cns;
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

    /**
     * @return the data_nascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param data_nascimento the data_nascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * @return the sexo
     */
    public Character getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the alfabetizado
     */
    public Character getAlfabetizado() {
        return alfabetizado;
    }

    /**
     * @param alfabetizado the alfabetizado to set
     */
    public void setAlfabetizado(Character alfabetizado) {
        this.alfabetizado = alfabetizado;
    }

    /**
     * @return the ocupacao
     */
    public String getOcupacao() {
        return ocupacao;
    }

    /**
     * @param ocupacao the ocupacao to set
     */
    public void setOcupacao(String ocupacao) {
        this.ocupacao = ocupacao;
    }

    /**
     * @return the doencaCondicao
     */
    public String getDoencaCondicao() {
        return doencaCondicao;
    }

    /**
     * @param doencaCondicao the doencaCondicao to set
     */
    public void setDoencaCondicao(String doencaCondicao) {
        this.doencaCondicao = doencaCondicao;
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
        if (!(object instanceof BIPaciente)) {
            return false;
        }
        BIPaciente other = (BIPaciente) object;
        if ((this.cns == null && other.cns != null) || (this.cns != null && !this.cns.equals(other.cns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }

   

    /**
     * @return the familia
     */
    public BIFamilia getFamilia() {
        return familia;
    }

    /**
     * @param familia the familia to set
     */
    public void setFamilia(BIFamilia familia) {
        this.familia = familia;
    }
    
    
}
