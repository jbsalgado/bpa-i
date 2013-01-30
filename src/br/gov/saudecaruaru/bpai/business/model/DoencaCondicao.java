/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author juniorpires
 */
public class DoencaCondicao {
    
    public static final List<DoencaCondicao> LIST = new ArrayList<DoencaCondicao>();
    public static final Map<String,DoencaCondicao> MAP = new HashMap<String,DoencaCondicao>();
    
    
    private String codigo;
    private String descricao;

    
   
    
    
    static{
        LIST.add(new DoencaCondicao("ALC","Alcoolismo"));
        LIST.add(new DoencaCondicao("CHA","Chagas"));
        LIST.add(new DoencaCondicao("DEF","Deficiência"));
        LIST.add(new DoencaCondicao("DIA","Diabetes"));
        LIST.add(new DoencaCondicao("EPI","Epilepsia"));
        LIST.add(new DoencaCondicao("GES","Gestação"));
        LIST.add(new DoencaCondicao("HA","Hipertensão Harterial"));
        LIST.add(new DoencaCondicao("TB","Tuberculose"));
        LIST.add(new DoencaCondicao("HAN","Hanseníase"));
        LIST.add(new DoencaCondicao("MAL","Malária"));
        
        
         for(DoencaCondicao e:LIST){
            MAP.put(e.getCodigo(), e);
        }
    }

    public DoencaCondicao() {
    }
    
    
    public DoencaCondicao(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
    
    
}
