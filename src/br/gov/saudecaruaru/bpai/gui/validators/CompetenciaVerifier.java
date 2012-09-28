/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.controller.GestorCompetenciaController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
import java.awt.Color;
import java.awt.Component;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class CompetenciaVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private GestorCompetenciaController gestorCompetenciaController;
    private JTextField textFieldMes;
   
    public CompetenciaVerifier(Component component,String fieldName,JTextField textFieldMes) {
        this.fieldName = fieldName;
        this.component = component;
        this.textFieldMes = textFieldMes;
        gestorCompetenciaController = new GestorCompetenciaController(); 
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
       JTextComponent txtField = (JTextField) input; 
       String mes = textFieldMes.getText();
      String valor = txtField.getText();
    
      //seta o valor digitado no objeto
      String competencia = valor+mes;
      String competenciaAtual = gestorCompetenciaController.getCompetenciaAtual();
           
               
                    int dif = Integer.parseInt(competenciaAtual)-Integer.parseInt(competencia);
                    //é permitido até 4 meses do mes atual 
                     // (implementar posteriormente a diferenca entre objetos DATE)
                    if(dif>4 || dif<0){  
                        JOptionPane.showMessageDialog(this.component, " COMPETÊNCIA INVÁLIDA!", 
                        "Erro de validação!", JOptionPane.ERROR_MESSAGE);
                        textFieldMes.requestFocus();
                        return false;
                    }
                
                
                txtField.setBackground(Color.WHITE);
                return true;
       }
    
}
