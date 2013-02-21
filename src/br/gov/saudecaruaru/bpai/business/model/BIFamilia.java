/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 *
 * @author juniorpires
 */
@Entity
@Table(name="FAMILIA")
@SequenceGenerator(name="INC_FAMILIA_ID",sequenceName="GEN_FAMILIA_ID",allocationSize=0,initialValue=1)
public class BIFamilia implements Serializable {
    
    @Id 
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="INC_FAMILIA_ID")
    @Basic(optional=false)
    @Column(name="id")
    private Integer id;
    
    @Column(name="segmento",length=2)
    @Basic(optional=false)
    private String segmento;
    
    @Column(name="area", length=4)
    @Basic(optional=false)
    private String area;
    
    @Column(name="microarea",length=2)
    @Basic(optional=false)
    private String microArea;
    
    @Column(name="familia",length=3)
    @Basic(optional=false)
    private String familia;
    
    @Column(name="endereco",length=60)
    private String endereco;
    
    @Column(name="numero",length=4)
    private String numero;
    
    @Column(name="bairro",length=60)
    private String bairro;
    
    @Column(name="cep",length=8)
    private String cep;
    
    @Column(name="municipio",length=60)
    private String municipio;
    
    @Column(name="uf",length=2)
    private String uf;
    
    @Column(name="ano",length=4)
    private String ano;
    
    @OneToMany(mappedBy="familia",fetch=FetchType.LAZY )
    @Fetch(FetchMode.SELECT)
    private List<BIPaciente> pacientes;
    
    
    public void setNullCamposVazios(){
        if(this.area!=null){ 
            if(this.area.equals("")){
                this.area = null;
            }
        }
        if(this.microArea!=null){ 
            if(this.microArea.equals("")){
                this.microArea = null;
            }
         }
         if(this.segmento!=null){  
            if(this.segmento.equals("")){
                this.segmento = null;
            }
         }
         if(this.bairro!=null){ 
            if(this.bairro.equals("")){
                this.bairro = null;
            }
         }
         if(this.cep!=null){  
            if(this.cep.equals("")){
                this.cep = null;
            }
         }
        if(this.ano!=null){  
            if(this.ano.equals("")){
                this.ano = null;
            }
        }
        if(this.endereco!=null){ 
            if(this.endereco.equals("")){
                this.endereco = null;
            } 
        }
        if(this.familia!=null){ 
            if(this.familia.equals("")){
                this.familia = null;
            }
         }
        if(this.municipio!=null){ 
            if(this.municipio.equals("")){
                this.municipio = null;
            } 
        }
        if(this.numero!=null){ 
            if(this.numero.equals("")){
                this.numero = null;
            }
        }
        if(this.uf!=null){ 
            if(this.uf.equals("")){
                this.uf = null;
            }
        }
         
        
         
             
        
        
    }
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
    public String getAno() {
        return ano;
    }

    /**
     * @param ano the data to set
     */
    public void setAno(String ano) {
        this.ano = ano;
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
