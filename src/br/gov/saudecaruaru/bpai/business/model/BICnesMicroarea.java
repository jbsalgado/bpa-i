/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author juniorpires
 */
@Entity
@Table(name="CNES_MICROAREA")
@SequenceGenerator(name="INC_MICROAREA_ID",sequenceName="GEN_MICROAREA_ID",allocationSize=0,initialValue=1)
public class BICnesMicroarea implements Serializable{
   
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="INC_MICROAREA_ID")
    @Basic(optional=false)
    @Column(name="id")
    private int id;
    
    @Column(name="nome_microarea",length=50)
    private String nomeMicroarea;
    
    @Column(name="codigo_microarea",length=2)
    private String codigoMicroarea;
    
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name="cnes",referencedColumnName="cnes")
    private BICnesArea cnesArea;

    public BICnesMicroarea() {
    }

    
    public BICnesMicroarea(CnesMicroarea microarea){
        this.setCodigoMicroarea(microarea.getCodigoMicroarea());
        this.setNomeMicroarea(microarea.getNomeMicroarea());
        this.setCnesArea(new BICnesArea(microarea.getCodigoUnidade()));
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
     * @return the nomeMicroarea
     */
    public String getNomeMicroarea() {
        return nomeMicroarea;
    }

    /**
     * @param nomeMicroarea the nomeMicroarea to set
     */
    public void setNomeMicroarea(String nomeMicroarea) {
        this.nomeMicroarea = nomeMicroarea;
    }

    /**
     * @return the codigoMicroarea
     */
    public String getCodigoMicroarea() {
        return codigoMicroarea;
    }

    /**
     * @param codigoMicroarea the codigoMicroarea to set
     */
    public void setCodigoMicroarea(String codigoMicroarea) {
        this.codigoMicroarea = codigoMicroarea;
    }

    /**
     * @return the cnesArea
     */
    public BICnesArea getCnesArea() {
        return cnesArea;
    }

    /**
     * @param cnesArea the cnesArea to set
     */
    public void setCnesArea(BICnesArea cnesArea) {
        this.cnesArea = cnesArea;
    }
    
    
    
}
