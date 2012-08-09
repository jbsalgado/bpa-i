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
@Table(name = "S_CID")
public class Cid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_COD")
    private String codigo;
    
    @Column(name = "OPC")
    private Character opcao;
    
    @Column(name = "CAT")
    private Character categoria;
    
    @Column(name = "SUBCAT")
    private Character subcategoria;
    
    @Column(name = "CD_DESCR")
    private String descricao;
    
    @Column(name = "RESTRSEXO")
    private Character restricaoSexo;
    
    @Column(name = "CAMPOS_RAD")
    private String camposRad;
    
    @Column(name = "ESTADIO")
    private Character estadio;
    
    @Column(name = "REPETE_RAD")
    private Character repeteRad;
    
    @Column(name = "AUX")
    private Character aux;

    public Cid() {
    }

    public Cid(String codigo) {
        this.codigo = codigo;
    }

    public Cid(String codigo, Character opcao, Character categoria, Character subcategoria, String descricao, Character restricaoSexo, String camposRad, Character estadio, Character repeteRad, Character aux) {
        this.codigo = codigo;
        this.opcao = opcao;
        this.categoria = categoria;
        this.subcategoria = subcategoria;
        this.descricao = descricao;
        this.restricaoSexo = restricaoSexo;
        this.camposRad = camposRad;
        this.estadio = estadio;
        this.repeteRad = repeteRad;
        this.aux = aux;
    }

    public Character getAux() {
        return aux;
    }

    public void setAux(Character aux) {
        this.aux = aux;
    }

    public String getCamposRad() {
        return camposRad;
    }

    public void setCamposRad(String camposRad) {
        this.camposRad = camposRad;
    }

    public Character getCategoria() {
        return categoria;
    }

    public void setCategoria(Character categoria) {
        this.categoria = categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Character getEstadio() {
        return estadio;
    }

    public void setEstadio(Character estadio) {
        this.estadio = estadio;
    }

    public Character getOpcao() {
        return opcao;
    }

    public void setOpcao(Character opcao) {
        this.opcao = opcao;
    }

    public Character getRepeteRad() {
        return repeteRad;
    }

    public void setRepeteRad(Character repeteRad) {
        this.repeteRad = repeteRad;
    }

    public Character getRestricaoSexo() {
        return restricaoSexo;
    }

    public void setRestricaoSexo(Character restricaoSexo) {
        this.restricaoSexo = restricaoSexo;
    }

    public Character getSubcategoria() {
        return subcategoria;
    }

    public void setSubcategoria(Character subcategoria) {
        this.subcategoria = subcategoria;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cid other = (Cid) obj;
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }

    

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCid[ cdCod=" + codigo + " ]";
    }
    
}
