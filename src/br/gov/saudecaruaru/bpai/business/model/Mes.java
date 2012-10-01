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
public class Mes {

    /**
     * @return the LIST
     */
    public static List<Mes> getLIST() {
        return LIST;
    }
    private String codigo;
    private String descricao;
   
    
    
    
    private static List<Mes> LIST = new ArrayList<Mes>(){
    };
    
    static{
        getLIST().add(new Mes("01","JANEIRO"));
        getLIST().add(new Mes("02","FEVEREIRO"));
        getLIST().add(new Mes("03", "MARÇO"));
        getLIST().add(new Mes("04", "ABRIL"));
        getLIST().add(new Mes("05", "MAIO"));
        getLIST().add(new Mes("06", "JUNHO"));
        getLIST().add(new Mes("07", "JULHO"));
        getLIST().add(new Mes("08", "AGOSTO"));
        getLIST().add(new Mes("09", "SETEMBRO"));
        getLIST().add(new Mes("10", "OUTUBRO"));
        getLIST().add(new Mes("11", "NOVEMBRO"));
        getLIST().add(new Mes("12", "DEZEMBRO"));
    
    }

    public Mes(String codigo,String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
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
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        hash += (descricao!= null ? descricao.hashCode() : 0);
        return hash;
    }

   @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mes other = (Mes) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }
}
