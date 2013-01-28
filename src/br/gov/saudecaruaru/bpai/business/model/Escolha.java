/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.hibernate.type.ForeignKeyDirection;

/**
 *
 * @author juniorpires
 */
public class Escolha {
    
    
    public static List<Escolha> LIST = new ArrayList<Escolha>();
    public static Map<Character,Escolha> MAP = new HashMap<Character,Escolha>();
    private Character codigo;
    private String descricao;

    public Escolha() {
    }

    public Escolha(Character codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    
    static{
        LIST.add(new Escolha('S', "Sim"));
        LIST.add(new Escolha('N', "Não"));
        
        for(Escolha e:LIST){
            MAP.put(e.getCodigo(), e);
        }
    }
    /**
     * @return the codigo
     */
    public Character getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Character codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Escolha other = (Escolha) obj;
        if (this.codigo != other.codigo && (this.codigo == null || !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
    
    
}
