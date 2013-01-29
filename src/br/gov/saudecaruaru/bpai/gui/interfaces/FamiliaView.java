/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.interfaces;

import br.gov.saudecaruaru.bpai.gui.FamiliaTableModel;
import com.towel.bind.Binder;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.InputVerifier;
import javax.swing.text.Document;

/**
 *
 * @author juniorpires
 */
public interface FamiliaView {
    public void setSelecionarLinhaJTableActionListener(MouseListener listener);
    public void clearFields();
    public void packAndShow();
    public FamiliaTableModel getFamiliaTableModel();
    public void setFamiliaTableModel(FamiliaTableModel model);
    public int linhaSelecionadaTableFamilias(); 
    public void refreshTableFamilias();
    public void setVerifiers();
    public void setDocuments();
    public Binder getBinder();
    public void enableTxtSegmento(boolean arg);
    public void enableTxtArea(boolean arg);
    public void enableTxtMicroarea(boolean arg);
    public void enableTxtFamilia(boolean arg);
    public void enableTxtEndereco(boolean arg);
    public void enableTxtNumero(boolean arg);
    public void enableTxtBairro(boolean arg);
    public void enableTxtCep(boolean arg);
    public void enableTxtMunicipio(boolean arg);
    public void enableCbUF(boolean arg);
    public void enableTxtDataCadastro(boolean arg);
    
    public void enableBtnNovo(boolean arg);
    public void enableBtnEditar(boolean arg);
    public void enableBtnConfirmar(boolean arg);
    public void enableBtnCancelar(boolean arg);
    
    public void setNovoActionListener(ActionListener listener);
    public void setEditarActionListener(ActionListener listener);
    public void setConfirmarActionListener(ActionListener listener);
    public void setCancelarActionListener(ActionListener listener);
    
    public void visibleBtnBuscar(boolean arg);
    public void setBuscarActionListener(ActionListener listener);
    public void fecharJanela();
    
    public void setTxtSegmentoDocument(Document d);
    public void setTxtAreaDocument(Document d);
    public void setTxtMicroareaDocument(Document d);
    public void setTxtFamiliaDocument(Document d);
    public void setTxtEnderecoDocument(Document d);
    public void setTxtNumeroDocument(Document d);
    public void setTxtBairroDocument(Document d);
    public void setTxtCepDocument(Document d);
    public void setTxtMunicipioDocument(Document d);
    public String getCep();
    public String getDataCadastro();
    
    
    public void setFmDataCadastroVerifier(InputVerifier verifier);
    public void setFmCepVerifier(InputVerifier verifier);
    
}
