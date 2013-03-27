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
    
  
    @Column(name = "CTR_TAB")
    private String tab;
    @Column(name = "CTR_TIPO")
    private String tipo;
    @Column(name = "CTR_CODUNI")
    private String codigoUnidade;
    @Column(name = "CTR_NOME")
    private String nome;
    @Column(name = "CTR_SIGL")
    private String sigl;
    @Column(name = "CTR_CGC")
    private String codigoGestor;
    @Column(name = "CTR_NMSS")
    private String nomeSecretariaSaude;
    @Column(name = "CTR_UF")
    private String uf;
    @Column(name = "CTR_MN")
    private String mn;
    
    
    public GestorCompetencia() {
    }

    public GestorCompetencia(GestorCompetenciaPK gestorCompetenciaPK) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
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
     * @return the tab
     */
    public String getTab() {
        return tab;
    }

    /**
     * @param tab the tab to set
     */
    public void setTab(String tab) {
        this.tab = tab;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the codigoUnidade
     */
    public String getCodigoUnidade() {
        return codigoUnidade;
    }

    /**
     * @param codigoUnidade the codigoUnidade to set
     */
    public void setCodigoUnidade(String codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sigl
     */
    public String getSigl() {
        return sigl;
    }

    /**
     * @param sigl the sigl to set
     */
    public void setSigl(String sigl) {
        this.sigl = sigl;
    }

    /**
     * @return the codigoGestor
     */
    public String getCodigoGestor() {
        return codigoGestor;
    }

    /**
     * @param codigoGestor the codigoGestor to set
     */
    public void setCodigoGestor(String codigoGestor) {
        this.codigoGestor = codigoGestor;
    }

    /**
     * @return the nomeSecretariaSaude
     */
    public String getNomeSecretariaSaude() {
        return nomeSecretariaSaude;
    }

    /**
     * @param nomeSecretariaSaude the nomeSecretariaSaude to set
     */
    public void setNomeSecretariaSaude(String nomeSecretariaSaude) {
        this.nomeSecretariaSaude = nomeSecretariaSaude;
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
     * @return the mn
     */
    public String getMn() {
        return mn;
    }

    /**
     * @param mn the mn to set
     */
    public void setMn(String mn) {
        this.mn = mn;
    }

   

   
    
    
}
