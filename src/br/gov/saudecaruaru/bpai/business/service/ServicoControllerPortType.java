/**
 * ServicoControllerPortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.gov.saudecaruaru.bpai.business.service;

public interface ServicoControllerPortType extends java.rmi.Remote {
    public br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] enviarEmLoteProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuario) throws java.rmi.RemoteException;
    public boolean enviarProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuario) throws java.rmi.RemoteException;
    public br.gov.saudecaruaru.bpai.business.service.SMessageWebService[] getMessagesLastSend(br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException;
    public boolean atualizarProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException;
    public br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] atualizarEmLoteProcedimentoRealizado(br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado[] procedimentoRealizado, br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop usuarioDesktop) throws java.rmi.RemoteException;
}
