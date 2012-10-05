/**
 * UsuarioDesktop.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.saudecaruaru.bpai.business.service;

public class SUsuarioDesktop  implements java.io.Serializable {
    private java.lang.String servidor_cpf;

    private java.lang.String token;

    private java.lang.String usuario_sistema;

    private java.lang.String serial_aplicacao;

    public SUsuarioDesktop() {
    }

    public SUsuarioDesktop(
           java.lang.String servidor_cpf,
           java.lang.String token,
           java.lang.String usuario_sistema,
           java.lang.String serial_aplicacao) {
           this.servidor_cpf = servidor_cpf;
           this.token = token;
           this.usuario_sistema = usuario_sistema;
           this.serial_aplicacao = serial_aplicacao;
    }


    /**
     * Gets the servidor_cpf value for this UsuarioDesktop.
     * 
     * @return servidor_cpf
     */
    public java.lang.String getServidor_cpf() {
        return servidor_cpf;
    }


    /**
     * Sets the servidor_cpf value for this UsuarioDesktop.
     * 
     * @param servidor_cpf
     */
    public void setServidor_cpf(java.lang.String servidor_cpf) {
        this.servidor_cpf = servidor_cpf;
    }


    /**
     * Gets the token value for this UsuarioDesktop.
     * 
     * @return token
     */
    public java.lang.String getToken() {
        return token;
    }


    /**
     * Sets the token value for this UsuarioDesktop.
     * 
     * @param token
     */
    public void setToken(java.lang.String token) {
        this.token = token;
    }


    /**
     * Gets the usuario_sistema value for this UsuarioDesktop.
     * 
     * @return usuario_sistema
     */
    public java.lang.String getUsuario_sistema() {
        return usuario_sistema;
    }


    /**
     * Sets the usuario_sistema value for this UsuarioDesktop.
     * 
     * @param usuario_sistema
     */
    public void setUsuario_sistema(java.lang.String usuario_sistema) {
        this.usuario_sistema = usuario_sistema;
    }


    /**
     * Gets the serial_aplicacao value for this UsuarioDesktop.
     * 
     * @return serial_aplicacao
     */
    public java.lang.String getSerial_aplicacao() {
        return serial_aplicacao;
    }


    /**
     * Sets the serial_aplicacao value for this UsuarioDesktop.
     * 
     * @param serial_aplicacao
     */
    public void setSerial_aplicacao(java.lang.String serial_aplicacao) {
        this.serial_aplicacao = serial_aplicacao;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SUsuarioDesktop)) return false;
        SUsuarioDesktop other = (SUsuarioDesktop) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.servidor_cpf==null && other.getServidor_cpf()==null) || 
             (this.servidor_cpf!=null &&
              this.servidor_cpf.equals(other.getServidor_cpf()))) &&
            ((this.token==null && other.getToken()==null) || 
             (this.token!=null &&
              this.token.equals(other.getToken()))) &&
            ((this.usuario_sistema==null && other.getUsuario_sistema()==null) || 
             (this.usuario_sistema!=null &&
              this.usuario_sistema.equals(other.getUsuario_sistema()))) &&
            ((this.serial_aplicacao==null && other.getSerial_aplicacao()==null) || 
             (this.serial_aplicacao!=null &&
              this.serial_aplicacao.equals(other.getSerial_aplicacao())));
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
        if (getServidor_cpf() != null) {
            _hashCode += getServidor_cpf().hashCode();
        }
        if (getToken() != null) {
            _hashCode += getToken().hashCode();
        }
        if (getUsuario_sistema() != null) {
            _hashCode += getUsuario_sistema().hashCode();
        }
        if (getSerial_aplicacao() != null) {
            _hashCode += getSerial_aplicacao().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SUsuarioDesktop.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("servidor_cpf");
        elemField.setXmlName(new javax.xml.namespace.QName("", "servidor_cpf"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("token");
        elemField.setXmlName(new javax.xml.namespace.QName("", "token"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario_sistema");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario_sistema"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serial_aplicacao");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serial_aplicacao"));
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
