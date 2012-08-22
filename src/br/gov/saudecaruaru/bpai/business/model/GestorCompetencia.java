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
    protected GestorCompetenciaPK gestorCompetenciaPK;
    
    @Column(name = "CTR_TAB")
    private String estadoSistema;
    
    @Column(name = "CTR_TIPO")
    private char tipoEstabelecimento;
    
    @Column(name = "CTR_CODUNI")
    private String codigoUnidadeSaude;
    
    @Column(name = "CTR_SIGL")
    private String siglaEstabelecimento;
    
    @Column(name = "CTR_CGC")
    private String cnpjEstabelecimento;
    
    @Column(name = "CTR_NMSS")
    private String nomeSecretariaSaude;
    
    @Column(name = "CTR_UF")
    private String unidadeFederativa;
    
    @Column(name = "CTR_MN")
    private String ctrMn;

    public GestorCompetencia() {
    }

    public GestorCompetencia(GestorCompetenciaPK gestorCompetenciaPK) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
    }

    public GestorCompetencia(GestorCompetenciaPK gestorCompetenciaPK, String estadoSistema, char tipoEstabelecimento, String codigoUnidadeSaude, String siglaEstabelecimento, String cnpjEstabelecimento, String nomeSecretariaSaude, String unidadeFederativa, String ctrMn) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
        this.estadoSistema = estadoSistema;
        this.tipoEstabelecimento = tipoEstabelecimento;
        this.codigoUnidadeSaude = codigoUnidadeSaude;
        this.siglaEstabelecimento = siglaEstabelecimento;
        this.cnpjEstabelecimento = cnpjEstabelecimento;
        this.nomeSecretariaSaude = nomeSecretariaSaude;
        this.unidadeFederativa = unidadeFederativa;
        this.ctrMn = ctrMn;
    }

    public String getCnpjEstabelecimento() {
        return cnpjEstabelecimento;
    }

    public void setCnpjEstabelecimento(String cnpjEstabelecimento) {
        this.cnpjEstabelecimento = cnpjEstabelecimento;
    }

    public String getCodigoUnidadeSaude() {
        return codigoUnidadeSaude;
    }

    public void setCodigoUnidadeSaude(String codigoUnidadeSaude) {
        this.codigoUnidadeSaude = codigoUnidadeSaude;
    }

    public String getCtrMn() {
        return ctrMn;
    }

    public void setCtrMn(String ctrMn) {
        this.ctrMn = ctrMn;
    }

    public String getEstadoSistema() {
        return estadoSistema;
    }

    public void setEstadoSistema(String estadoSistema) {
        this.estadoSistema = estadoSistema;
    }

    public GestorCompetenciaPK getGestorCompetenciaPK() {
        return gestorCompetenciaPK;
    }

    public void setGestorCompetenciaPK(GestorCompetenciaPK gestorCompetenciaPK) {
        this.gestorCompetenciaPK = gestorCompetenciaPK;
    }

    public String getNomeSecretariaSaude() {
        return nomeSecretariaSaude;
    }

    public void setNomeSecretariaSaude(String nomeSecretariaSaude) {
        this.nomeSecretariaSaude = nomeSecretariaSaude;
    }

    public String getSiglaEstabelecimento() {
        return siglaEstabelecimento;
    }

    public void setSiglaEstabelecimento(String siglaEstabelecimento) {
        this.siglaEstabelecimento = siglaEstabelecimento;
    }

    public char getTipoEstabelecimento() {
        return tipoEstabelecimento;
    }

    public void setTipoEstabelecimento(char tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
    }

    public String getUnidadeFederativa() {
        return unidadeFederativa;
    }

    public void setUnidadeFederativa(String unidadeFederativa) {
        this.unidadeFederativa = unidadeFederativa;
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
        if (this.gestorCompetenciaPK != other.gestorCompetenciaPK && (this.gestorCompetenciaPK == null || !this.gestorCompetenciaPK.equals(other.gestorCompetenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.gestorCompetenciaPK != null ? this.gestorCompetenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "GestorCompetencia{" + "gestorCompetenciaPK=" + gestorCompetenciaPK + '}';
    }

    
    
}
