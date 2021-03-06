/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "CADCNS")
public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    public static final Paciente DADOS_CONSOLIDADOS= new Paciente("000000000000000", "DADOS GLOBALIZADOS", "19710101", 'F', "99", "260410","010");
             
    @Id
    @Basic(optional = false)
    @Column(name = "CNS")
    @SerializedName("cns")
    private String cns;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    @SerializedName("nome")
    private String nome;
    
    @Column(name = "DTNASC")
    @SerializedName("data_nascimento")
    private String dataNascimento;
    
    @Column(name = "SEXO")
    @SerializedName("sexo")
    private Character sexo;
    
    @Column(name = "RACA")
    @SerializedName("raca")
    private String raca;
    
    @Column(name = "MAEPCN")
    private String nomeMae;
    
    @Column(name = "LOGPCN")
    private String logradouro;
    
    @Column(name = "NUMPCN")
    private String numeroPaciente;
    
    @Column(name = "CPLPCN")
    private String complemento;
    
    @Column(name = "CEPPCN")
    private String cep;
    
    @Column(name = "NMRES")
    private String numeroResidencia;
    
    @Column(name = "IBGE")
    @SerializedName("cidade")
    private String codigoIbgeCidade;
    
    @Column(name = "ETNIA")
    @SerializedName("etnia")
    private String etnia;
    
    @Column(name = "NACIONALIDADE")
    @SerializedName("nacionalidade")
    private String nacionalidade;

    public Paciente() {
    }

    public Paciente(ProcedimentoRealizado procedimentoRealizado){
        this.cns=procedimentoRealizado.getCnsPaciente();
        this.codigoIbgeCidade=procedimentoRealizado.getCodigoIBGECidadePaciente();
        this.dataNascimento=procedimentoRealizado.getDataNascimentoPaciente();
        this.etnia=procedimentoRealizado.getEtniaPaciente();
        this.nacionalidade=procedimentoRealizado.getNacionalidadePaciente();
        this.nome=procedimentoRealizado.getNomePaciente();
        this.raca=procedimentoRealizado.getRacaPaciente();
        this.sexo=procedimentoRealizado.getSexoPaciente().charAt(0);
    }
    
    public Paciente(String cns) {
        this.cns = cns;
    }

    public Paciente(String cns, String nome) {
        this.cns = cns;
        this.nome = nome;
    }

    public Paciente(String cns, String nome, String dataNascimento, Character sexo, String raca, String codigoIbgeCidade, String nacionalidade) {
        this.cns = cns;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.raca = raca;
        this.codigoIbgeCidade = codigoIbgeCidade;
        this.nacionalidade = nacionalidade;
    }

    public String getCns() {
        return cns;
    }

    public void setCns(String cns) {
        this.cns = cns;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCodigoIbgeCidade() {
        return codigoIbgeCidade;
    }

    public void setCodigoIbgeCidade(String codigoIbgeCidade) {
        this.codigoIbgeCidade = codigoIbgeCidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNumeroPaciente() {
        return numeroPaciente;
    }

    public void setNumeroPaciente(String numeroPaciente) {
        this.numeroPaciente = numeroPaciente;
    }

    public String getNumeroResidencia() {
        return numeroResidencia;
    }

    public void setNumeroResidencia(String numeroResidencia) {
        this.numeroResidencia = numeroResidencia;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cns != null ? cns.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paciente)) {
            return false;
        }
        Paciente other = (Paciente) object;
        if ((this.cns == null && other.cns != null) || (this.cns != null && !this.cns.equals(other.cns))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
