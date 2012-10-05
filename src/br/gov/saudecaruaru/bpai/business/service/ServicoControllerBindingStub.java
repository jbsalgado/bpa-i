/**
 * ServicoControllerBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.saudecaruaru.bpai.business.service;

public class ServicoControllerBindingStub extends org.apache.axis.client.Stub implements br.gov.saudecaruaru.bpai.business.service.ServicoControllerPortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[5];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarEmLoteProcedimentoRealizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "procedimentoRealizado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizadoArray"), br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop"), br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizadoArray"));
        oper.setReturnClass(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("enviarProcedimentoRealizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "procedimentoRealizado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizado"), br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuario"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop"), br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMessagesLastSend");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuarioDesktop"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop"), br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "MessageWebServiceArray"));
        oper.setReturnClass(br.gov.saudecaruaru.bpai.business.service.SMessageWebService[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("atualizarProcedimentoRealizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "procedimentoRealizado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizado"), br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuarioDesktop"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop"), br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("atualizarEmLoteProcedimentoRealizado");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "procedimentoRealizado"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizadoArray"), br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "usuarioDesktop"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop"), br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizadoArray"));
        oper.setReturnClass(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        _operations[4] = oper;

    }

    public ServicoControllerBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ServicoControllerBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ServicoControllerBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "MessageWebService");
            cachedSerQNames.add(qName);
            cls = br.gov.saudecaruaru.bpai.business.service.SMessageWebService.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "MessageWebServiceArray");
            cachedSerQNames.add(qName);
            cls = br.gov.saudecaruaru.bpai.business.service.SMessageWebService[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "MessageWebService");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "Paciente");
            cachedSerQNames.add(qName);
            cls = br.gov.saudecaruaru.bpai.business.service.SPaciente.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizado");
            cachedSerQNames.add(qName);
            cls = br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizadoArray");
            cachedSerQNames.add(qName);
            cls = br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ProcedimentoRealizado");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "UsuarioDesktop");
            cachedSerQNames.add(qName);
            cls = br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] enviarEmLoteProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ServicoControllerwsdl#enviarEmLoteProcedimentoRealizado");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "enviarEmLoteProcedimentoRealizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {procedimentoRealizado, usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[]) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean enviarProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuario) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ServicoControllerwsdl#enviarProcedimentoRealizado");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "enviarProcedimentoRealizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {procedimentoRealizado, usuario});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.saudecaruaru.bpai.business.service.SMessageWebService[] getMessagesLastSend(br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ServicoControllerwsdl#getMessagesLastSend");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "getMessagesLastSend"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {usuarioDesktop});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.saudecaruaru.bpai.business.service.SMessageWebService[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.saudecaruaru.bpai.business.service.SMessageWebService[]) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.saudecaruaru.bpai.business.service.SMessageWebService[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public boolean atualizarProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ServicoControllerwsdl#atualizarProcedimentoRealizado");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "atualizarProcedimentoRealizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {procedimentoRealizado, usuarioDesktop});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] atualizarEmLoteProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("urn:ServicoControllerwsdl#atualizarEmLoteProcedimentoRealizado");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "atualizarEmLoteProcedimentoRealizado"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {procedimentoRealizado, usuarioDesktop});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[]) org.apache.axis.utils.JavaUtils.convert(_resp, br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
