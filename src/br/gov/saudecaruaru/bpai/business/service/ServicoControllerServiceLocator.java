/**
 * ServicoControllerServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ServicoControllerwsdl;

public class ServicoControllerServiceLocator extends org.apache.axis.client.Service implements ServicoControllerwsdl.ServicoControllerService {

    public ServicoControllerServiceLocator() {
    }


    public ServicoControllerServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicoControllerServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicoControllerPort
    private java.lang.String ServicoControllerPort_address = "http://localhost/sispad/index.php/bpa/servico/main/ws/1";

    public java.lang.String getServicoControllerPortAddress() {
        return ServicoControllerPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicoControllerPortWSDDServiceName = "ServicoControllerPort";

    public java.lang.String getServicoControllerPortWSDDServiceName() {
        return ServicoControllerPortWSDDServiceName;
    }

    public void setServicoControllerPortWSDDServiceName(java.lang.String name) {
        ServicoControllerPortWSDDServiceName = name;
    }

    public ServicoControllerwsdl.ServicoControllerPortType getServicoControllerPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicoControllerPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicoControllerPort(endpoint);
    }

    public ServicoControllerwsdl.ServicoControllerPortType getServicoControllerPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ServicoControllerwsdl.ServicoControllerBindingStub _stub = new ServicoControllerwsdl.ServicoControllerBindingStub(portAddress, this);
            _stub.setPortName(getServicoControllerPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicoControllerPortEndpointAddress(java.lang.String address) {
        ServicoControllerPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ServicoControllerwsdl.ServicoControllerPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                ServicoControllerwsdl.ServicoControllerBindingStub _stub = new ServicoControllerwsdl.ServicoControllerBindingStub(new java.net.URL(ServicoControllerPort_address), this);
                _stub.setPortName(getServicoControllerPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicoControllerPort".equals(inputPortName)) {
            return getServicoControllerPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ServicoControllerService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:ServicoControllerwsdl", "ServicoControllerPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicoControllerPort".equals(portName)) {
            setServicoControllerPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
