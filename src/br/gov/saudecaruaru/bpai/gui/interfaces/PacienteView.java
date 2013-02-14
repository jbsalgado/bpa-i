/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.interfaces;

import br.gov.saudecaruaru.bpai.business.model.Doenca;
import br.gov.saudecaruaru.bpai.business.model.DoencaCondicao;
import br.gov.saudecaruaru.bpai.gui.tablemodel.PacienteTableModel;
import com.towel.bind.Binder;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.InputVerifier;
import javax.swing.text.Document;

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
    public void enableCbDoencaCondicao(boolean arg);
   
    public void enableBtnNovo(boolean arg);
    public void enableBtnEditar(boolean arg);
    public void enableBtnConfirmar(boolean arg);
    public void enableBtnCancelar(boolean arg);
    public void enableBtnFamilia(boolean arg);
    public void setNovoActionListener(ActionListener listener);
    public void setEditarActionListener(ActionListener listener);
    public void setConfirmarActionListener(ActionListener listener);
    public void setCancelarActionListener(ActionListener listener);
    
    public void setSelectedAlfabetizado(Character o);
    public void setSelectedIndexAlfabetizado(int i);
    
    public void setFamiliaActionListener(ActionListener listener);
    
    public void setTxtCnsDocument(Document d);
    public void setTxtNomeDocument(Document d);
    public void setTxtIdadeDocument(Document d);
    public void setTxtSexoDocument(Document d);
    public void setTxtOcupacaoDocument(Document d);
  //  public void setTxtDataNascimentoDocument(Document d);
    
    //public String getDataNascimento();
    public Date getDataNascimento();
    public void setDataNascimento(Date dataNascimento);
    public void setTxtCnsVerifier(InputVerifier verifier);
    //public void setTxtDatanascimentoVerifier(InputVerifier verifier);
    
    public void setSelectedDoencaCondicao(DoencaCondicao c);
    public void setSelectedIndexDoencaCondicao(int i);
    
    public String getCns();
    public void setCnsFocusListener(FocusListener listener);
    public boolean validaCamposVazios();
}
