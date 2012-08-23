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
public class GestorCompetenciaPK implements Serializable {
    
    @Basic(optional = false)
    @Column(name = "CTR_MVM")
    private String competenciaMovimento;
    
    @Basic(optional = false)
    @Column(name = "CTR_NOME")
    private String nomeResponsavel;

    public GestorCompetenciaPK() {
    }

    public GestorCompetenciaPK(String competenciaMovimento, String nomeResponsavel) {
        this.competenciaMovimento = competenciaMovimento;
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getCompetenciaMovimento() {
        return competenciaMovimento;
    }

    public void setCompetenciaMovimento(String competenciaMovimento) {
        this.competenciaMovimento = competenciaMovimento;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GestorCompetenciaPK other = (GestorCompetenciaPK) obj;
        if ((this.competenciaMovimento == null) ? (other.competenciaMovimento != null) : !this.competenciaMovimento.equals(other.competenciaMovimento)) {
            return false;
        }
        if ((this.nomeResponsavel == null) ? (other.nomeResponsavel != null) : !this.nomeResponsavel.equals(other.nomeResponsavel)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.competenciaMovimento != null ? this.competenciaMovimento.hashCode() : 0);
        hash = 89 * hash + (this.nomeResponsavel != null ? this.nomeResponsavel.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return competenciaMovimento+"=" + competenciaMovimento + ", nomeResponsavel=" + nomeResponsavel + '}';
    }
    
    
    
}
