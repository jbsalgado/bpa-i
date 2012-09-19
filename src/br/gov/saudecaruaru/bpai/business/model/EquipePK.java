/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Albuquerque
 */
@Embeddable
public class EquipePK implements Serializable{

                      
    @Basic(optional= false)
    @Column(name="ESF_CMP")
    private String competencia;
    
    @Basic(optional= false)
    @Column(name="ESF_IBGE")
    private String codigoIBGECidade;
        
    @Basic(optional= false)
    @Column(name="ESF_CNES")
    private String cnes;
        
    @Basic(optional= false)
    @Column(name="ESF_SEQ")
    private String sequencia;

    public EquipePK() {
    }

    public EquipePK(String competencia, String codigoIBGECidade, String cnes, String sequencia) {
        this.competencia = competencia;
        this.codigoIBGECidade = codigoIBGECidade;
        this.cnes = cnes;
        this.sequencia = sequencia;
    }

    public String getCnes() {
        return cnes;
    }

    public void setCnes(String cnes) {
        this.cnes = cnes;
    }

    public String getCodigoIBGECidade() {
        return codigoIBGECidade;
    }

    public void setCodigoIBGECidade(String codigoIBGECidade) {
        this.codigoIBGECidade = codigoIBGECidade;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getSequencia() {
        return sequencia;
    }

    public void setSequencia(String sequencia) {
        this.sequencia = sequencia;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EquipePK other = (EquipePK) obj;
        if ((this.competencia == null) ? (other.competencia != null) : !this.competencia.equals(other.competencia)) {
            return false;
        }
        if ((this.codigoIBGECidade == null) ? (other.codigoIBGECidade != null) : !this.codigoIBGECidade.equals(other.codigoIBGECidade)) {
            return false;
        }
        if ((this.cnes == null) ? (other.cnes != null) : !this.cnes.equals(other.cnes)) {
            return false;
        }
        if ((this.sequencia == null) ? (other.sequencia != null) : !this.sequencia.equals(other.sequencia)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.competencia != null ? this.competencia.hashCode() : 0);
        hash = 53 * hash + (this.codigoIBGECidade != null ? this.codigoIBGECidade.hashCode() : 0);
        hash = 53 * hash + (this.cnes != null ? this.cnes.hashCode() : 0);
        hash = 53 * hash + (this.sequencia != null ? this.sequencia.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "EquipePK{" + "competencia=" + competencia + ", codigoIBGECidade=" + codigoIBGECidade + ", cnes=" + cnes + ", sequencia=" + sequencia + '}';
    }
    
    
}
