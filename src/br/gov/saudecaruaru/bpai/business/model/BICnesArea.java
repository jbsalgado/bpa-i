/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
/**
 *
 * @author juniorpires
 */
@Entity
@Table(name="CNES_AREA")
public class BICnesArea implements Serializable {
    
    @Id
    @Basic(optional=false)
    @Column(name="cnes",length=15)
    private String cnes;
    
    @Column(name="nome_unidade",length=45)
    private String nomeUnidade;
    @Column(name="codigo_area",length=4)
    private String codigoArea;
    @Column(name="nome_area",length=45)
    private String nomeArea;
    @Column(name="codigo_segmento",length=2)
    private String codigoSegmento;
    @Column(name="nome_segmento",length=45)
    private String nomeSegmento;
    
    @OneToMany(mappedBy="cnesArea",fetch=FetchType.LAZY )
    @Fetch(FetchMode.SELECT)
    private List<BICnesMicroarea> cnes_microareas;

    public BICnesArea() {
    }
    
    
    public BICnesArea(CnesArea area){
        this.cnes = area.getCodigoUnidade();
        this.codigoArea = area.getCodigoArea();
        this.codigoSegmento = area.getCodigoSegmento();
        this.nomeArea = area.getNomeArea();
        this.nomeSegmento = area.getNomeSegmento();
        this.nomeUnidade = area.getNomeUnidade();
    }
    
    public BICnesArea(String cnes){
        this.cnes = cnes;
    }
    /**
     * @return the cnes
     */
    public String getCnes() {
        return cnes;
    }

    /**
     * @param cnes the cnes to set
     */
    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    /**
     * @return the nomeUnidade
     */
    public String getNomeUnidade() {
        return nomeUnidade;
    }

    /**
     * @param nomeUnidade the nomeUnidade to set
     */
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    /**
     * @return the codigoArea
     */
    public String getCodigoArea() {
        return codigoArea;
    }

    /**
     * @param codigoArea the codigoArea to set
     */
    public void setCodigoArea(String codigoArea) {
        this.codigoArea = codigoArea;
    }

    /**
     * @return the nomeArea
     */
    public String getNomeArea() {
        return nomeArea;
    }

    /**
     * @param nomeArea the nomeArea to set
     */
    public void setNomeArea(String nomeArea) {
        this.nomeArea = nomeArea;
    }

    /**
     * @return the codigoSegmento
     */
    public String getCodigoSegmento() {
        return codigoSegmento;
    }

    /**
     * @param codigoSegmento the codigoSegmento to set
     */
    public void setCodigoSegmento(String codigoSegmento) {
        this.codigoSegmento = codigoSegmento;
    }

    /**
     * @return the nomeSegmento
     */
    public String getNomeSegmento() {
        return nomeSegmento;
    }

    /**
     * @param nomeSegmento the nomeSegmento to set
     */
    public void setNomeSegmento(String nomeSegmento) {
        this.nomeSegmento = nomeSegmento;
    }

    /**
     * @return the cnes_microareas
     */
    public List<BICnesMicroarea> getCnes_microareas() {
        return cnes_microareas;
    }

    /**
     * @param cnes_microareas the cnes_microareas to set
     */
    public void setCnes_microareas(List<BICnesMicroarea> cnes_microareas) {
        this.cnes_microareas = cnes_microareas;
    }
    
    
}
