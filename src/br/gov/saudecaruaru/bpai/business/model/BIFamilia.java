/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
/**
 *
 * @author juniorpires
 */
@Entity
@Table(name="FAMILIA")
public class BIFamilia implements Serializable {
    
    @Id @GeneratedValue
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;
    
    @Column(name="segmento")
    @Basic(optional=false)
    private String segmento;
    
    @Column(name="area")
    @Basic(optional=false)
    private String area;
    
    @Column(name="microarea")
    @Basic(optional=false)
    private String microArea;
    
    @Column(name="familia")
    @Basic(optional=false)
    private String familia;
    
    @Column(name="endereco")
    private String endereco;
    
    @Column(name="numero")
    private String numero;
    
    @Column(name="bairro")
    private String bairro;
    
    @Column(name="cep")
    private String cep;
    
    @Column(name="municipio")
    private String municipio;
    
    @Column(name="uf")
    private String uf;
    
    @Column(name="data_cadastro")
    private String dataCadastro;
    @OneToMany(mappedBy="familia",targetEntity=BIPaciente.class,fetch=FetchType.LAZY,cascade= CascadeType.ALL )
    List<BIPaciente> pacientes;
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the segmento
     */
    public String getSegmento() {
        return segmento;
    }

    /**
     * @param segmento the segmento to set
     */
    public void setSegmento(String segmento) {
        this.segmento = segmento;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the microArea
     */
    public String getMicroArea() {
        return microArea;
    }

    /**
     * @param microArea the microArea to set
     */
    public void setMicroArea(String microArea) {
        this.microArea = microArea;
    }

    /**
     * @return the familia
     */
    public String getFamilia() {
        return familia;
    }

    /**
     * @param familia the familia to set
     */
    public void setFamilia(String familia) {
        this.familia = familia;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the municipio
     */
    public String getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the data
     */
    public String getDataCadastro() {
        return dataCadastro;
    }

    /**
     * @param data the data to set
     */
    public void setDataCadastro(String data) {
        this.dataCadastro = data;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
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
        final BIFamilia other = (BIFamilia) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    

    @Override
    public String toString() {
        return "segmento."+this.segmento+".area."+this.area+".micro."+this.microArea+".familia."+this.familia;
    }

    
}
