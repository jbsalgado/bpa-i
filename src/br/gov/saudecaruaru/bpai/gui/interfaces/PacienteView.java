/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.interfaces;

import br.gov.saudecaruaru.bpai.gui.PacienteTableModel;
import com.towel.bind.Binder;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 *
 * @author juniorpires
 */
public interface PacienteView {
    
    public Character getAlfabetizado();
    public Integer getIdFamilia();
    public void setSelecionarLinhaJTableActionListener(MouseListener listener);
    public void clearFields();
    public void packAndShow();
    public PacienteTableModel getPacienteTableModel();
    public void setPacienteTableModel(PacienteTableModel model);
    public int linhaSelecionadaTablePacientes(); 
    public void refreshTablePacientes();
    public void setVerifiers();
    public void setDocuments();
    public Binder getBinder();
    public void enableTxtCns(boolean arg);
    public void enableTxtNome(boolean arg);
    public void enableTxtIdade(boolean arg);
    public void enableTxtSexo(boolean arg);
    public void enableJCbAlfabetizado(boolean arg);
    public void enableTxtDataNascimento(boolean arg);
    public void enableTxtOcupacao(boolean arg);
    public void enableTxtFamilia(boolean arg);
    public void enableTxtDoencaCondicao(boolean arg);
   
    public void enableBtnNovo(boolean arg);
    public void enableBtnEditar(boolean arg);
    public void enableBtnConfirmar(boolean arg);
    public void enableBtnCancelar(boolean arg);
    
    public void setNovoActionListener(ActionListener listener);
    public void setEditarActionListener(ActionListener listener);
    public void setConfirmarActionListener(ActionListener listener);
    public void setCancelarActionListener(ActionListener listener);
}
