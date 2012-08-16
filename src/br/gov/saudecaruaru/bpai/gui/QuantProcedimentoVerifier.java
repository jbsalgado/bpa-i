/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.controller.MunicipioController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoCboController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.model.*;
import java.awt.Color;
import java.awt.Component;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class QuantProcedimentoVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private ProcedimentoController procedimentoController;
    private  Procedimento procedimento;
    private ProcedimentoPK  procedimentoPk;
    private JTextField textFieldProc;
    private ProcedimentoCbo procedimentoCbo;
    private ProcedimentoCboPK procedimentoCboPK;
    private ProcedimentoCboController procedimentoCboController;
    
    
    public QuantProcedimentoVerifier(Component component,String fieldName,JTextField textFieldProc) {
        this.fieldName = fieldName;
        this.component = component;
       
        this.textFieldProc = textFieldProc;
        //instancia o controlador de  municipio
         procedimentoController = new  ProcedimentoController();
        //instancia o modelo  MunicipioPk
         this.procedimento= new   Procedimento();
         procedimentoPk = new   ProcedimentoPK();
         this.procedimento.setProcedimentoPk(procedimentoPk);
         
         
         this.procedimentoCboPK = new ProcedimentoCboPK();
         this.procedimentoCbo = new ProcedimentoCbo(procedimentoCboPK);
         
         this.procedimentoCboController = new ProcedimentoCboController();
        
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextComponent txtField = (JTextField) input; 
      String valor = txtField.getText();
      double quant = Double.parseDouble(valor);
      String codProc = textFieldProc.getText();
      List<Procedimento> procedimentoSearchead = null;
     
      procedimento.getProcedimentoPk().setId(codProc);
      
      //faz a busca pelo Procedimento  digitado, se nao encontra notifica ao usuário
      procedimentoSearchead = procedimentoController.findAllEqual(this.procedimento);
               
                if (!procedimentoSearchead.isEmpty()) {  
                    double quantMaxima = procedimentoSearchead.get(0).getQuantidadeMaximaExecucao();
                    if(quant>procedimentoSearchead.get(0).getQuantidadeMaximaExecucao()){
                       JOptionPane.showMessageDialog(this.component," ERRO! QUANTIDADE MÁXIMA PERMITIDA "+quantMaxima, 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                    }
                }
                  txtField.setBackground(Color.WHITE);
                return true;
       }
        
      
    
}
