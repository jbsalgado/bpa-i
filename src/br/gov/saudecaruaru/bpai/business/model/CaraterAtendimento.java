/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Junior Pires
 */
public class CaraterAtendimento {
    
    public static List<CaraterAtendimento> LIST = new ArrayList<CaraterAtendimento>(){
    };
    public static final String SEM_INFORMACAO = "00";
    static{
        getList().add(new CaraterAtendimento("00","SEM INFORMAÇÃO"));
        getList().add(new CaraterAtendimento("01","ELETIVO"));
        getList().add(new CaraterAtendimento("02","URGÊNCIA"));
        getList().add(new CaraterAtendimento("03","ACIDENTE NO LOCAL DO TRABALHO OU A SERVICO DA EMPRESA"));
        getList().add(new CaraterAtendimento("04","ACIDENTE NO TRAJETO PARA O TRABALHO"));
        getList().add(new CaraterAtendimento("05","OUTROS TIPOS DE ACIDENTES DE TRÃNSITO"));
        getList().add(new CaraterAtendimento("06","OUTROS TIPOS DE LESÕES E EVEN. POR AGENTES QUÍMICOS OU FÍSICOS"));
        
    }

    /**
     * @return the list
     */
    public static List<CaraterAtendimento> getList() {
        return LIST;
    }

    /**
     * @param aList the list to set
     */
    public static void setList(List<CaraterAtendimento> aList) {
        LIST = aList;
    }
    
    
    private  String descricao;
    private  String codigo;
    
    public CaraterAtendimento(String cod,String desc) {
        this.descricao = desc;
        this.codigo = cod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.codigo != null ? this.codigo .trim().hashCode() : 0);
        return hash;
    }
    
   

    @Override
    public String toString() {
        return this.getDescricao();
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
   
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CaraterAtendimento other = (CaraterAtendimento) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
