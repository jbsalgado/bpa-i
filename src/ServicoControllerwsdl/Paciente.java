/**
 * Paciente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ServicoControllerwsdl;

public class Paciente  implements java.io.Serializable {
    private java.lang.String cns;

    private java.lang.String nome;

    private java.lang.String sexo;

    private java.util.Date data_nascimento;

    private java.lang.String cidade;

    private java.lang.String nacionalidade;

    private java.lang.String raca;

    private java.lang.String etnia;

    public Paciente() {
    }

    public Paciente(
           java.lang.String cns,
           java.lang.String nome,
           java.lang.String sexo,
           java.util.Date data_nascimento,
           java.lang.String cidade,
           java.lang.String nacionalidade,
           java.lang.String raca,
           java.lang.String etnia) {
           this.cns = cns;
           this.nome = nome;
           this.sexo = sexo;
           this.data_nascimento = data_nascimento;
           this.cidade = cidade;
           this.nacionalidade = nacionalidade;
           this.raca = raca;
           this.etnia = etnia;
    }


    /**
     * Gets the cns value for this Paciente.
     * 
     * @return cns
     */
    public java.lang.String getCns() {
        return cns;
    }


    /**
     * Sets the cns value for this Paciente.
     * 
     * @param cns
     */
    public void setCns(java.lang.String cns) {
        this.cns = cns;
    }


    /**
     * Gets the nome value for this Paciente.
     * 
     * @return nome
     */
    public java.lang.String getNome() {
        return nome;
    }


    /**
     * Sets the nome value for this Paciente.
     * 
     * @param nome
     */
    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }


    /**
     * Gets the sexo value for this Paciente.
     * 
     * @return sexo
     */
    public java.lang.String getSexo() {
        return sexo;
    }


    /**
     * Sets the sexo value for this Paciente.
     * 
     * @param sexo
     */
    public void setSexo(java.lang.String sexo) {
        this.sexo = sexo;
    }


    /**
     * Gets the data_nascimento value for this Paciente.
     * 
     * @return data_nascimento
     */
    public java.util.Date getData_nascimento() {
        return data_nascimento;
    }


    /**
     * Sets the data_nascimento value for this Paciente.
     * 
     * @param data_nascimento
     */
    public void setData_nascimento(java.util.Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }


    /**
     * Gets the cidade value for this Paciente.
     * 
     * @return cidade
     */
    public java.lang.String getCidade() {
        return cidade;
    }


    /**
     * Sets the cidade value for this Paciente.
     * 
     * @param cidade
     */
    public void setCidade(java.lang.String cidade) {
        this.cidade = cidade;
    }


    /**
     * Gets the nacionalidade value for this Paciente.
     * 
     * @return nacionalidade
     */
    public java.lang.String getNacionalidade() {
        return nacionalidade;
    }


    /**
     * Sets the nacionalidade value for this Paciente.
     * 
     * @param nacionalidade
     */
    public void setNacionalidade(java.lang.String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }


    /**
     * Gets the raca value for this Paciente.
     * 
     * @return raca
     */
    public java.lang.String getRaca() {
        return raca;
    }


    /**
     * Sets the raca value for this Paciente.
     * 
     * @param raca
     */
    public void setRaca(java.lang.String raca) {
        this.raca = raca;
    }


    /**
     * Gets the etnia value for this Paciente.
     * 
     * @return etnia
     */
    public java.lang.String getEtnia() {
        return etnia;
    }


    /**
     * Sets the etnia value for this Paciente.
     * 
     * @param etnia
     */
    public void setEtnia(java.lang.String etnia) {
        this.etnia = etnia;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Paciente)) return false;
        Paciente other = (Paciente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cns==null && other.getCns()==null) || 
             (this.cns!=null &&
              this.cns.equals(other.getCns()))) &&
            ((this.nome==null && other.getNome()==null) || 
             (this.nome!=null &&
              this.nome.equals(other.getNome()))) &&
            ((this.sexo==null && other.getSexo()==null) || 
             (this.sexo!=null &&
              this.sexo.equals(other.getSexo()))) &&
            ((this.data_nascimento==null && other.getData_nascimento()==null) || 
             (this.data_nascimento!=null &&
              this.data_nascimento.equals(other.getData_nascimento()))) &&
            ((this.cidade==null && other.getCidade()==null) || 
             (this.cidade!=null &&
              this.cidade.equals(other.getCidade()))) &&
            ((this.nacionalidade==null && other.getNacionalidade()==null) || 
             (this.nacionalidade!=null &&
              this.nacionalidade.equals(other.getNacionalidade()))) &&
            ((this.raca==null && other.getRaca()==null) || 
             (this.raca!=null &&
              this.raca.equals(other.getRaca()))) &&
            ((this.etnia==null && other.getEtnia()==null) || 
             (this.etnia!=null &&
              this.etnia.equals(other.getEtnia())));
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
        if (getCns() != null) {
            _hashCode += getCns().hashCode();
        }
        if (getNome() != null) {
            _hashCode += getNome().hashCode();
        }
        if (getSexo() != null) {
            _hashCode += getSexo().hashCode();
        }
        if (getData_nascimento() != null) {
            _hashCode += getData_nascimento().hashCode();
        }
        if (getCidade() != null) {
            _hashCode += getCidade().hashCode();
        }
        if (getNacionalidade() != null) {
            _hashCode += getNacionalidade().hashCode();
        }
        if (getRaca() != null) {
            _hashCode += getRaca().hashCode();
        }
        if (getEtnia() != null) {
            _hashCode += getEtnia().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Paciente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "Paciente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cns");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cns"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nome");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nome"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sexo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sexo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data_nascimento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data_nascimento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nacionalidade");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nacionalidade"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("raca");
        elemField.setXmlName(new javax.xml.namespace.QName("", "raca"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etnia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "etnia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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

}
