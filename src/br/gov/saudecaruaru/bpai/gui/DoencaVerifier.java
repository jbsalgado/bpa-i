/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.controller.DoencaController;
import br.gov.saudecaruaru.bpai.business.model.Doenca;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class DoencaVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private DoencaController doencaController;
    private  Doenca  doenca;
    private JTextField doencaNome;
    public DoencaVerifier(Component component,String fieldName,JTextField muniNome) {
        this.fieldName = fieldName;
        this.component = component;
        this.doencaNome = muniNome;
        //instancia o controlador de  municipio
         doencaController = new  DoencaController();
        //instancia o modelo  MunicipioPk
         doenca= new   Doenca();       
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextComponent txtField = (JTextField) input; 
      Doenca doencaSearchead = null;
      String valor = txtField.getText();
     
      //seta o valor digitado no objeto
      doenca.setCodigo(valor);
    
      doencaSearchead = doencaController.findEqual(doenca);
                //faz a busca pelo Codigo do municipio digitado, se nao encontra notifica ao usuário
                if (doencaSearchead==null) {  
                       JOptionPane.showMessageDialog(this.component,fieldName + " INCORRETO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }
                  txtField.setBackground(Color.WHITE);
                  doencaNome.setText(doencaSearchead.getDescricao());
                return true;
       }
    
}
