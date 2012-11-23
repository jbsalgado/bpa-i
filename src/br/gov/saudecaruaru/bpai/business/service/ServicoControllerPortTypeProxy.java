package br.gov.saudecaruaru.bpai.business.service;

public class ServicoControllerPortTypeProxy implements br.gov.saudecaruaru.bpai.business.service.ServicoControllerPortType {
  private String _endpoint = null;
  private br.gov.saudecaruaru.bpai.business.service.ServicoControllerPortType servicoControllerPortType = null;
  
  public ServicoControllerPortTypeProxy() {
    _initServicoControllerPortTypeProxy();
  }
  
  public ServicoControllerPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicoControllerPortTypeProxy();
  }
  
  private void _initServicoControllerPortTypeProxy() {
    try {
      servicoControllerPortType = (new br.gov.saudecaruaru.bpai.business.service.ServicoControllerServiceLocator()).getServicoControllerPort();
      if (servicoControllerPortType != null) {
        if (_endpoint != null){
            javax.xml.rpc.Stub stub=(javax.xml.rpc.Stub)servicoControllerPortType;
            stub._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        }
        
        else{
          _endpoint = (String)((javax.xml.rpc.Stub)servicoControllerPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
        }
        
        //seta a autenticação
        javax.xml.rpc.Stub stub=(javax.xml.rpc.Stub)servicoControllerPortType;
        stub._setProperty(javax.xml.rpc.Stub.PASSWORD_PROPERTY, "1234");
        stub._setProperty(javax.xml.rpc.Stub.USERNAME_PROPERTY, "CESAR");
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
  
  public br.gov.saudecaruaru.bpai.business.service.ServicoControllerPortType getServicoControllerPortType() {
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType;
  }
  
  public br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] enviarEmLoteProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuario) throws java.rmi.RemoteException{
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType.enviarEmLoteProcedimentoRealizado(procedimentoRealizado, usuario);
  }
  
  public boolean enviarProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuario) throws java.rmi.RemoteException{
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType.enviarProcedimentoRealizado(procedimentoRealizado, usuario);
  }
  
  public br.gov.saudecaruaru.bpai.business.service.SMessageWebService[] getMessagesLastSend(br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException{
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType.getMessagesLastSend(usuarioDesktop);
  }
  
  public boolean atualizarProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException{
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType.atualizarProcedimentoRealizado(procedimentoRealizado, usuarioDesktop);
  }
  
  public br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] atualizarEmLoteProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException{
    if (servicoControllerPortType == null)
      _initServicoControllerPortTypeProxy();
    return servicoControllerPortType.atualizarEmLoteProcedimentoRealizado(procedimentoRealizado, usuarioDesktop);
  }
  
  
}