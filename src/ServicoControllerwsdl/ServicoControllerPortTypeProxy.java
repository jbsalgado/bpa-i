package ServicoControllerwsdl;

public class ServicoControllerPortTypeProxy implements ServicoControllerwsdl.ServicoControllerPortType {
  private String _endpoint = null;
  private ServicoControllerwsdl.ServicoControllerPortType servicoControllerPortType = null;
  
  public ServicoControllerPortTypeProxy() {
    _initServicoControllerPortTypeProxy();
  }
  
  public ServicoControllerPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoControllerPortTypeProxy();
  }
  
  private void _initServicoControllerPortTypeProxy() {
    try {
      servicoControllerPortType = (new ServicoControllerwsdl.ServicoControllerServiceLocator()).getServicoControllerPort();
      if (servicoControllerPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicoControllerPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicoControllerPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicoControllerPortType != null)
      ((javax.xml.rpc.Stub)servicoControllerPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ServicoControllerwsdl.ServicoControllerPortType getServicoControllerPortType() {
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType;
  }
  
  public ServicoControllerwsdl.MessageWebService[] sendProcedimentoRealizadoEPaciente(ServicoControllerwsdl.ProcedimentoRealizado[] procedimentoRealizado, ServicoControllerwsdl.UsuarioDesktop paciente) throws java.rmi.RemoteException{
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType.sendProcedimentoRealizadoEPaciente(procedimentoRealizado, paciente);
  }
  
  
}