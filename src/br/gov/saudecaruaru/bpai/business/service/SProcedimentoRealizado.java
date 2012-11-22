/**
 * ProcedimentoRealizado.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.saudecaruaru.bpai.business.service;

public class SProcedimentoRealizado  implements java.io.Serializable {
    private java.lang.String unidade;

    private java.lang.String competencia;

    private java.lang.String profissional_cns;

    private br.gov.saudecaruaru.bpai.business.service.SPaciente paciente;

    private java.lang.String profissional_cbo;

    private java.lang.String folha;

    private java.lang.String sequencia;

    private java.lang.String procedimento;

    private java.util.Date data_atendimento;

    private java.lang.String cid;

    private java.math.BigInteger quantidade;

    private java.lang.String caracter_atendimento;

    private java.lang.String numero_autorizacao;

    private java.lang.String origem;

    private java.lang.String competencia_movimento;

    private java.lang.String servico;

    private java.lang.String equipe;

    private java.lang.String cnpj;

    private java.lang.String equipe_area;

    private java.lang.String equipe_sequencia;

    private java.lang.String classificacao;

    private java.math.BigInteger idade_paciente;

    public SProcedimentoRealizado() {
    }

    public SProcedimentoRealizado(
           java.lang.String unidade,
           java.lang.String competencia,
           java.lang.String profissional_cns,
           br.gov.saudecaruaru.bpai.business.service.SPaciente paciente,
           java.lang.String profissional_cbo,
           java.lang.String folha,
           java.lang.String sequencia,
           java.lang.String procedimento,
           java.util.Date data_atendimento,
           java.lang.String cid,
           java.math.BigInteger quantidade,
           java.lang.String caracter_atendimento,
           java.lang.String numero_autorizacao,
           java.lang.String origem,
           java.lang.String competencia_movimento,
           java.lang.String servico,
           java.lang.String equipe,
           java.lang.String cnpj,
           java.lang.String equipe_area,
           java.lang.String equipe_sequencia,
           java.lang.String classificacao,
           java.math.BigInteger idade_paciente) {
           this.unidade = unidade;
           this.competencia = competencia;
           this.profissional_cns = profissional_cns;
           this.paciente = paciente;
           this.profissional_cbo = profissional_cbo;
           this.folha = folha;
           this.sequencia = sequencia;
           this.procedimento = procedimento;
           this.data_atendimento = data_atendimento;
           this.cid = cid;
           this.quantidade = quantidade;
           this.caracter_atendimento = caracter_atendimento;
           this.numero_autorizacao = numero_autorizacao;
           this.origem = origem;
           this.competencia_movimento = competencia_movimento;
           this.servico = servico;
           this.equipe = equipe;
           this.cnpj = cnpj;
           this.equipe_area = equipe_area;
           this.equipe_sequencia = equipe_sequencia;
           this.classificacao = classificacao;
           this.idade_paciente = idade_paciente;
    }


    /**
     * Gets the unidade value for this ProcedimentoRealizado.
     * 
     * @return unidade
     */
    public java.lang.String getUnidade() {
        return unidade;
    }


    /**
     * Sets the unidade value for this ProcedimentoRealizado.
     * 
     * @param unidade
     */
    public void setUnidade(java.lang.String unidade) {
        this.unidade = unidade;
    }


    /**
     * Gets the competencia value for this ProcedimentoRealizado.
     * 
     * @return competencia
     */
    public java.lang.String getCompetencia() {
        return competencia;
    }


    /**
     * Sets the competencia value for this ProcedimentoRealizado.
     * 
     * @param competencia
     */
    public void setCompetencia(java.lang.String competencia) {
        this.competencia = competencia;
    }


    /**
     * Gets the profissional_cns value for this ProcedimentoRealizado.
     * 
     * @return profissional_cns
     */
    public java.lang.String getProfissional_cns() {
        return profissional_cns;
    }


    /**
     * Sets the profissional_cns value for this ProcedimentoRealizado.
     * 
     * @param profissional_cns
     */
    public void setProfissional_cns(java.lang.String profissional_cns) {
        this.profissional_cns = profissional_cns;
    }


    /**
     * Gets the paciente value for this ProcedimentoRealizado.
     * 
     * @return paciente
     */
    public br.gov.saudecaruaru.bpai.business.service.SPaciente getPaciente() {
        return paciente;
    }


    /**
     * Sets the paciente value for this ProcedimentoRealizado.
     * 
     * @param paciente
     */
    public void setPaciente(br.gov.saudecaruaru.bpai.business.service.SPaciente paciente) {
        this.paciente = paciente;
    }


    /**
     * Gets the profissional_cbo value for this ProcedimentoRealizado.
     * 
     * @return profissional_cbo
     */
    public java.lang.String getProfissional_cbo() {
        return profissional_cbo;
    }


    /**
     * Sets the profissional_cbo value for this ProcedimentoRealizado.
     * 
     * @param profissional_cbo
     */
    public void setProfissional_cbo(java.lang.String profissional_cbo) {
        this.profissional_cbo = profissional_cbo;
    }


    /**
     * Gets the folha value for this ProcedimentoRealizado.
     * 
     * @return folha
     */
    public java.lang.String getFolha() {
        return folha;
    }


    /**
     * Sets the folha value for this ProcedimentoRealizado.
     * 
     * @param folha
     */
    public void setFolha(java.lang.String folha) {
        this.folha = folha;
    }


    /**
     * Gets the sequencia value for this ProcedimentoRealizado.
     * 
     * @return sequencia
     */
    public java.lang.String getSequencia() {
        return sequencia;
    }


    /**
     * Sets the sequencia value for this ProcedimentoRealizado.
     * 
     * @param sequencia
     */
    public void setSequencia(java.lang.String sequencia) {
        this.sequencia = sequencia;
    }


    /**
     * Gets the procedimento value for this ProcedimentoRealizado.
     * 
     * @return procedimento
     */
    public java.lang.String getProcedimento() {
        return procedimento;
    }


    /**
     * Sets the procedimento value for this ProcedimentoRealizado.
     * 
     * @param procedimento
     */
    public void setProcedimento(java.lang.String procedimento) {
        this.procedimento = procedimento;
    }


    /**
     * Gets the data_atendimento value for this ProcedimentoRealizado.
     * 
     * @return data_atendimento
     */
    public java.util.Date getData_atendimento() {
        return data_atendimento;
    }


    /**
     * Sets the data_atendimento value for this ProcedimentoRealizado.
     * 
     * @param data_atendimento
     */
    public void setData_atendimento(java.util.Date data_atendimento) {
        this.data_atendimento = data_atendimento;
    }


    /**
     * Gets the cid value for this ProcedimentoRealizado.
     * 
     * @return cid
     */
    public java.lang.String getCid() {
        return cid;
    }


    /**
     * Sets the cid value for this ProcedimentoRealizado.
     * 
     * @param cid
     */
    public void setCid(java.lang.String cid) {
        this.cid = cid;
    }


    /**
     * Gets the quantidade value for this ProcedimentoRealizado.
     * 
     * @return quantidade
     */
    public java.math.BigInteger getQuantidade() {
        return quantidade;
    }


    /**
     * Sets the quantidade value for this ProcedimentoRealizado.
     * 
     * @param quantidade
     */
    public void setQuantidade(java.math.BigInteger quantidade) {
        this.quantidade = quantidade;
    }


    /**
     * Gets the caracter_atendimento value for this ProcedimentoRealizado.
     * 
     * @return caracter_atendimento
     */
    public java.lang.String getCaracter_atendimento() {
        return caracter_atendimento;
    }


    /**
     * Sets the caracter_atendimento value for this ProcedimentoRealizado.
     * 
     * @param caracter_atendimento
     */
    public void setCaracter_atendimento(java.lang.String caracter_atendimento) {
        this.caracter_atendimento = caracter_atendimento;
    }


    /**
     * Gets the numero_autorizacao value for this ProcedimentoRealizado.
     * 
     * @return numero_autorizacao
     */
    public java.lang.String getNumero_autorizacao() {
        return numero_autorizacao;
    }


    /**
     * Sets the numero_autorizacao value for this ProcedimentoRealizado.
     * 
     * @param numero_autorizacao
     */
    public void setNumero_autorizacao(java.lang.String numero_autorizacao) {
        this.numero_autorizacao = numero_autorizacao;
    }


    /**
     * Gets the origem value for this ProcedimentoRealizado.
     * 
     * @return origem
     */
    public java.lang.String getOrigem() {
        return origem;
    }


    /**
     * Sets the origem value for this ProcedimentoRealizado.
     * 
     * @param origem
     */
    public void setOrigem(java.lang.String origem) {
        this.origem = origem;
    }


    /**
     * Gets the competencia_movimento value for this ProcedimentoRealizado.
     * 
     * @return competencia_movimento
     */
    public java.lang.String getCompetencia_movimento() {
        return competencia_movimento;
    }


    /**
     * Sets the competencia_movimento value for this ProcedimentoRealizado.
     * 
     * @param competencia_movimento
     */
    public void setCompetencia_movimento(java.lang.String competencia_movimento) {
        this.competencia_movimento = competencia_movimento;
    }


    /**
     * Gets the servico value for this ProcedimentoRealizado.
     * 
     * @return servico
     */
    public java.lang.String getServico() {
        return servico;
    }


    /**
     * Sets the servico value for this ProcedimentoRealizado.
     * 
     * @param servico
     */
    public void setServico(java.lang.String servico) {
        this.servico = servico;
    }


    /**
     * Gets the equipe value for this ProcedimentoRealizado.
     * 
     * @return equipe
     */
    public java.lang.String getEquipe() {
        return equipe;
    }


    /**
     * Sets the equipe value for this ProcedimentoRealizado.
     * 
     * @param equipe
     */
    public void setEquipe(java.lang.String equipe) {
        this.equipe = equipe;
    }


    /**
     * Gets the cnpj value for this ProcedimentoRealizado.
     * 
     * @return cnpj
     */
    public java.lang.String getCnpj() {
        return cnpj;
    }


    /**
     * Sets the cnpj value for this ProcedimentoRealizado.
     * 
     * @param cnpj
     */
    public void setCnpj(java.lang.String cnpj) {
        this.cnpj = cnpj;
    }


    /**
     * Gets the equipe_area value for this ProcedimentoRealizado.
     * 
     * @return equipe_area
     */
    public java.lang.String getEquipe_area() {
        return equipe_area;
    }


    /**
     * Sets the equipe_area value for this ProcedimentoRealizado.
     * 
     * @param equipe_area
     */
    public void setEquipe_area(java.lang.String equipe_area) {
        this.equipe_area = equipe_area;
    }


    /**
     * Gets the equipe_sequencia value for this ProcedimentoRealizado.
     * 
     * @return equipe_sequencia
     */
    public java.lang.String getEquipe_sequencia() {
        return equipe_sequencia;
    }


    /**
     * Sets the equipe_sequencia value for this ProcedimentoRealizado.
     * 
     * @param equipe_sequencia
     */
    public void setEquipe_sequencia(java.lang.String equipe_sequencia) {
        this.equipe_sequencia = equipe_sequencia;
    }


    /**
     * Gets the classificacao value for this ProcedimentoRealizado.
     * 
     * @return classificacao
     */
    public java.lang.String getClassificacao() {
        return classificacao;
    }


    /**
     * Sets the classificacao value for this ProcedimentoRealizado.
     * 
     * @param classificacao
     */
    public void setClassificacao(java.lang.String classificacao) {
        this.classificacao = classificacao;
    }


    /**
     * Gets the idade_paciente value for this ProcedimentoRealizado.
     * 
     * @return idade_paciente
     */
    public java.math.BigInteger getIdade_paciente() {
        return idade_paciente;
    }


    /**
     * Sets the idade_paciente value for this ProcedimentoRealizado.
     * 
     * @param idade_paciente
     */
    public void setIdade_paciente(java.math.BigInteger idade_paciente) {
        this.idade_paciente = idade_paciente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SProcedimentoRealizado)) return false;
        SProcedimentoRealizado other = (SProcedimentoRealizado) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.unidade==null && other.getUnidade()==null) || 
             (this.unidade!=null &&
              this.unidade.equals(other.getUnidade()))) &&
            ((this.competencia==null && other.getCompetencia()==null) || 
             (this.competencia!=null &&
              this.competencia.equals(other.getCompetencia()))) &&
            ((this.profissional_cns==null && other.getProfissional_cns()==null) || 
             (this.profissional_cns!=null &&
              this.profissional_cns.equals(other.getProfissional_cns()))) &&
            ((this.paciente==null && other.getPaciente()==null) || 
             (this.paciente!=null &&
              this.paciente.equals(other.getPaciente()))) &&
            ((this.profissional_cbo==null && other.getProfissional_cbo()==null) || 
             (this.profissional_cbo!=null &&
              this.profissional_cbo.equals(other.getProfissional_cbo()))) &&
            ((this.folha==null && other.getFolha()==null) || 
             (this.folha!=null &&
              this.folha.equals(other.getFolha()))) &&
            ((this.sequencia==null && other.getSequencia()==null) || 
             (this.sequencia!=null &&
              this.sequencia.equals(other.getSequencia()))) &&
            ((this.procedimento==null && other.getProcedimento()==null) || 
             (this.procedimento!=null &&
              this.procedimento.equals(other.getProcedimento()))) &&
            ((this.data_atendimento==null && other.getData_atendimento()==null) || 
             (this.data_atendimento!=null &&
              this.data_atendimento.equals(other.getData_atendimento()))) &&
            ((this.cid==null && other.getCid()==null) || 
             (this.cid!=null &&
              this.cid.equals(other.getCid()))) &&
            ((this.quantidade==null && other.getQuantidade()==null) || 
             (this.quantidade!=null &&
              this.quantidade.equals(other.getQuantidade()))) &&
            ((this.caracter_atendimento==null && other.getCaracter_atendimento()==null) || 
             (this.caracter_atendimento!=null &&
              this.caracter_atendimento.equals(other.getCaracter_atendimento()))) &&
            ((this.numero_autorizacao==null && other.getNumero_autorizacao()==null) || 
             (this.numero_autorizacao!=null &&
              this.numero_autorizacao.equals(other.getNumero_autorizacao()))) &&
            ((this.origem==null && other.getOrigem()==null) || 
             (this.origem!=null &&
              this.origem.equals(other.getOrigem()))) &&
            ((this.competencia_movimento==null && other.getCompetencia_movimento()==null) || 
             (this.competencia_movimento!=null &&
              this.competencia_movimento.equals(other.getCompetencia_movimento()))) &&
            ((this.servico==null && other.getServico()==null) || 
             (this.servico!=null &&
              this.servico.equals(other.getServico()))) &&
            ((this.equipe==null && other.getEquipe()==null) || 
             (this.equipe!=null &&
              this.equipe.equals(other.getEquipe()))) &&
            ((this.cnpj==null && other.getCnpj()==null) || 
             (this.cnpj!=null &&
              this.cnpj.equals(other.getCnpj()))) &&
            ((this.equipe_area==null && other.getEquipe_area()==null) || 
             (this.equipe_area!=null &&
              this.equipe_area.equals(other.getEquipe_area()))) &&
            ((this.equipe_sequencia==null && other.getEquipe_sequencia()==null) || 
             (this.equipe_sequencia!=null &&
              this.equipe_sequencia.equals(other.getEquipe_sequencia()))) &&
            ((this.classificacao==null && other.getClassificacao()==null) || 
             (this.classificacao!=null &&
              this.classificacao.equals(other.getClassificacao()))) &&
            ((this.idade_paciente==null && other.getIdade_paciente()==null) || 
             (this.idade_paciente!=null &&
              this.idade_paciente.equals(other.getIdade_paciente())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getUnidade() != null) {
            _hashCode += getUnidade().hashCode();
        }
        if (getCompetencia() != null) {
            _hashCode += getCompetencia().hashCode();
        }
        if (getProfissional_cns() != null) {
            _hashCode += getProfissional_cns().hashCode();
        }
        if (getPaciente() != null) {
            _hashCode += getPaciente().hashCode();
        }
        if (getProfissional_cbo() != null) {
            _hashCode += getProfissional_cbo().hashCode();
        }
        if (getFolha() != null) {
            _hashCode += getFolha().hashCode();
        }
        if (getSequencia() != null) {
            _hashCode += getSequencia().hashCode();
        }
        if (getProcedimento() != null) {
            _hashCode += getProcedimento().hashCode();
        }
        if (getData_atendimento() != null) {
            _hashCode += getData_atendimento().hashCode();
        }
        if (getCid() != null) {
            _hashCode += getCid().hashCode();
        }
        if (getQuantidade() != null) {
            _hashCode += getQuantidade().hashCode();
        }
        if (getCaracter_atendimento() != null) {
            _hashCode += getCaracter_atendimento().hashCode();
        }
        if (getNumero_autorizacao() != null) {
            _hashCode += getNumero_autorizacao().hashCode();
        }
        if (getOrigem() != null) {
            _hashCode += getOrigem().hashCode();
        }
        if (getCompetencia_movimento() != null) {
            _hashCode += getCompetencia_movimento().hashCode();
        }
        if (getServico() != null) {
            _hashCode += getServico().hashCode();
        }
        if (getEquipe() != null) {
            _hashCode += getEquipe().hashCode();
        }
        if (getCnpj() != null) {
            _hashCode += getCnpj().hashCode();
        }
        if (getEquipe_area() != null) {
            _hashCode += getEquipe_area().hashCode();
        }
        if (getEquipe_sequencia() != null) {
            _hashCode += getEquipe_sequencia().hashCode();
        }
        if (getClassificacao() != null) {
            _hashCode += getClassificacao().hashCode();
        }
        if (getIdade_paciente() != null) {
            _hashCode += getIdade_paciente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SProcedimentoRealizado.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizado"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "unidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("competencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "competencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profissional_cns");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profissional_cns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paciente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paciente"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "Paciente"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("profissional_cbo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "profissional_cbo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sequencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sequencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("procedimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "procedimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data_atendimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data_atendimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("quantidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "quantidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("caracter_atendimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "caracter_atendimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numero_autorizacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numero_autorizacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("origem");
        elemField.setXmlName(new javax.xml.namespace.QName("", "origem"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("competencia_movimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "competencia_movimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "servico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equipe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "equipe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cnpj");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cnpj"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equipe_area");
        elemField.setXmlName(new javax.xml.namespace.QName("", "equipe_area"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("equipe_sequencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "equipe_sequencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("classificacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "classificacao"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idade_paciente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idade_paciente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

    @Override
    public String toString() {
        return "SProcedimentoRealizado{" + "unidade=" + unidade + ", competencia=" + competencia + ", profissional_cns=" + profissional_cns + ", paciente=" + paciente + ", profissional_cbo=" + profissional_cbo + ", folha=" + folha + ", sequencia=" + sequencia + ", procedimento=" + procedimento + ", data_atendimento=" + data_atendimento + ", cid=" + cid + ", quantidade=" + quantidade + ", caracter_atendimento=" + caracter_atendimento + ", numero_autorizacao=" + numero_autorizacao + ", origem=" + origem + ", competencia_movimento=" + competencia_movimento + ", servico=" + servico + ", equipe=" + equipe + ", cnpj=" + cnpj + ", equipe_area=" + equipe_area + ", equipe_sequencia=" + equipe_sequencia + ", classificacao=" + classificacao + ", idade_paciente=" + idade_paciente + '}';
    }

    
}
