/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "S_CDN")
public class Diversas implements Serializable {
    
    public static final String TABELA_PROFISSAO="50";
    public static final String TABELA_TIPO_ESTABELECIMENTO="05";
    public static final String TABELA_PAIS="31";
    public static final String TABELA_COMPLEXIDADE_PROCEDIMENTO="45";
    public static final String TABELA_COR_INDIVIDUO="54";
    public static final String TABELA_ETNIA="58";
    public static final String CODIGO_NACIONALIDADE_BRASIL="010";
    
    
    public static final String COD_RACA_COR_INDIGENA="05";
    
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DiversasPK diversasPK;
    @Column(name = "CDN_DSCR")
    private String descricaoItemTabela;
    @Column(name = "CDN_AUX")
    private Character auxiliar;

    public Diversas() {
    }

    public Diversas(DiversasPK diversasPK) {
        this.diversasPK = diversasPK;
    }

    public Diversas(DiversasPK diversasPK, String descricaoItemTabela, Character auxiliar) {
        this.diversasPK = diversasPK;
        this.descricaoItemTabela = descricaoItemTabela;
        this.auxiliar = auxiliar;
    }

    public Character getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Character auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getDescricaoItemTabela() {
        return descricaoItemTabela;
    }

    public void setDescricaoItemTabela(String descricaoItemTabela) {
        this.descricaoItemTabela = descricaoItemTabela;
    }

    public DiversasPK getDiversasPK() {
        return diversasPK;
    }

    public void setDiversasPK(DiversasPK diversasPK) {
        this.diversasPK = diversasPK;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Diversas other = (Diversas) obj;
        if (this.diversasPK != other.diversasPK && (this.diversasPK == null || !this.diversasPK.equals(other.diversasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.diversasPK != null ? this.diversasPK.hashCode() : 0);
        return hash;
    }

    
    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCdn[ sCdnPK=" + diversasPK + " ]";
    }
    
}
