/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juniorpires
 */
public class Segmento {
    public static final List<Segmento> LIST =  new ArrayList<Segmento>();
    
    
    private String codigo;
    private String nome;
    
    
    static {
        LIST.add(new Segmento("01", "ZONA URBANA"));
        LIST.add(new Segmento("02", "ZONA RURAL"));
    }

    public Segmento(String codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }
    
    
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
