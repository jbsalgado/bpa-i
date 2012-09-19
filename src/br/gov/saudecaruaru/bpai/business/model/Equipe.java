/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */
@Entity
@Table(name= "S_EQESF")
public class Equipe implements Serializable{

    @EmbeddedId
    private EquipePK equipePK;
    
    @Column(name="ESF_AREA")
    private String area;
        
    @Column(name="ESF_NOME")
    private String nome;
        
    @Column(name="ESF_TIPO")
    private String tipo;
        
    @Column(name="ESF_DT_VIGENCIA_INICIAL")
    private String dataVigenciaInicial;
            
    @Column(name="ESF_DT_VIGENCIA_FINAL")
    private String dataVigenciaFinal;
    
    @Column(name="ESF_AUX")
    private Character auxiliar;

    public Equipe() {
    }

    public Equipe(EquipePK equipePK) {
        this.equipePK = equipePK;
    }

    public Equipe(EquipePK equipePK, String area, String nome, String tipo, String dataVigenciaInicial, String dataVigenciaFinal, Character auxiliar) {
        this.equipePK = equipePK;
        this.area = area;
        this.nome = nome;
        this.tipo = tipo;
        this.dataVigenciaInicial = dataVigenciaInicial;
        this.dataVigenciaFinal = dataVigenciaFinal;
        this.auxiliar = auxiliar;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Character getAuxiliar() {
        return auxiliar;
    }

    public void setAuxiliar(Character auxiliar) {
        this.auxiliar = auxiliar;
    }

    public String getDataVigenciaFinal() {
        return dataVigenciaFinal;
    }

    public void setDataVigenciaFinal(String dataVigenciaFinal) {
        this.dataVigenciaFinal = dataVigenciaFinal;
    }

    public String getDataVigenciaInicial() {
        return dataVigenciaInicial;
    }

    public void setDataVigenciaInicial(String dataVigenciaInicial) {
        this.dataVigenciaInicial = dataVigenciaInicial;
    }

    public EquipePK getEquipePK() {
        return equipePK;
    }

    public void setEquipePK(EquipePK equipePK) {
        this.equipePK = equipePK;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        if (this.equipePK != other.equipePK && (this.equipePK == null || !this.equipePK.equals(other.equipePK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.equipePK != null ? this.equipePK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Equipe{" + "equipePK=" + equipePK + ", area=" + area + ", nome=" + nome + ", tipo=" + tipo + ", dataVigenciaInicial=" + dataVigenciaInicial + ", dataVigenciaFinal=" + dataVigenciaFinal + ", auxiliar=" + auxiliar + '}';
    }
    
    
}
