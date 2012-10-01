/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "S_CTR")
public class GestorCompetencia implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private GestorCompetenciaPK gestorCompetenciaPK;
    
    @Column(name = "CTR_MVM")
    private String competenciaMovimento;
    
    
    public GestorCompetencia() {
    }

    public GestorCompetencia(GestorCompetenciaPK gestorCompetenciaPK) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
    }

    public GestorCompetencia(GestorCompetenciaPK gestorCompetenciaPK, String competenciaMovimento) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
        this.competenciaMovimento = competenciaMovimento;
    }

    public String getCompetenciaMes(){
        return this.getCompetenciaMovimento().substring(4);
    }
    
    public String getCompetenciaAno(){
        return this.getCompetenciaMovimento().substring(0,4);
    }
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GestorCompetencia other = (GestorCompetencia) obj;
        if (this.getGestorCompetenciaPK() != other.getGestorCompetenciaPK() && (this.getGestorCompetenciaPK() == null || !this.gestorCompetenciaPK.equals(other.gestorCompetenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.getGestorCompetenciaPK() != null ? this.getGestorCompetenciaPK().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "GestorCompetencia{" + "gestorCompetenciaPK=" + getGestorCompetenciaPK() + '}';
    }

    /**
     * @return the gestorCompetenciaPK
     */
    public GestorCompetenciaPK getGestorCompetenciaPK() {
        return gestorCompetenciaPK;
    }

    /**
     * @param gestorCompetenciaPK the gestorCompetenciaPK to set
     */
    public void setGestorCompetenciaPK(GestorCompetenciaPK gestorCompetenciaPK) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
    }

    /**
     * @return the competenciaMovimento
     */
    public String getCompetenciaMovimento() {
        return competenciaMovimento;
    }

    /**
     * @param competenciaMovimento the competenciaMovimento to set
     */
    public void setCompetenciaMovimento(String competenciaMovimento) {
        this.competenciaMovimento = competenciaMovimento;
    }

    
    
}
