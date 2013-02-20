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
@Table(name="OCUPACAO")
public class BIOcupacao implements Serializable {
    @Id
    @Basic(optional=false)
    @Column(name="codigo",length=3)
    private String codigo;
    
    @Basic(optional=false)
    @Column(name="nome",length=50)
    private String nome;

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
}
