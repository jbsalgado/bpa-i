/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.controller.GestorCompetenciaController;
import br.gov.saudecaruaru.bpai.business.validators.ProcedimentoRealizadoValidator;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class CompetenciaVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private JTextField textFieldMes;
    private TelaCadastroI t;
    private ProcedimentoRealizadoValidator prv;
    public CompetenciaVerifier(Component component,String fieldName,JTextField textFieldMes,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.textFieldMes = textFieldMes;
        this.t=t;
        prv = new ProcedimentoRealizadoValidator(t.getProcedimentoRealizado());
    }
    
    
    @Override
    public boolean verify(JComponent input) {
       JTextComponent txtField = (JTextField) input; 
       String mes = textFieldMes.getText();
       String valor = txtField.getText();
       
      //seta o valor digitado no objeto
      String competencia = valor+mes;
      t.getProcedimentoRealizado().getProcedimentoRealizadoPK().setCompetencia(competencia);
      
      String msg = prv.validCompetencia();
      if(!msg.equals("")){
          MessagesErrors.erro(component,txtField,msg); 
          textFieldMes.requestFocus();
          return false;
      }                
      txtField.setBackground(Color.WHITE);
      return true;
 }
    
}
