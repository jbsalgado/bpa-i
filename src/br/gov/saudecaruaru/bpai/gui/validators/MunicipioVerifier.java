/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;


import br.gov.saudecaruaru.bpai.business.controller.MunicipioController;
import br.gov.saudecaruaru.bpai.business.model.Municipio;
import br.gov.saudecaruaru.bpai.business.model.MunicipioPK;
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
public class MunicipioVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private MunicipioController municipioController;
    private  Municipio  municipio;
    private  MunicipioPK  municipioPk;
    private JTextField municNome;
    public MunicipioVerifier(Component component,String fieldName,JTextField muniNome) {
        this.fieldName = fieldName;
        this.component = component;
        this.municNome = muniNome;
        //instancia o controlador de  municipio
         municipioController = new  MunicipioController();
        //instancia o modelo  MunicipioPk
         municipio= new   Municipio();
         municipioPk = new  MunicipioPK();
         municipio.setCadmunPK(municipioPk);
        
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextComponent txtField = (JTextField) input; 
      Municipio municipioSearchead = null;
      String valor = txtField.getText();
      //pega os dois primeiros digitos (que representam o Estado do municipio)
      String codUf=valor.substring(0, 2);
      //pega os quatro ultimos digitos (que representam o codigo do municipio)
      String codMun = valor.substring(2);
      //seta o valor digitado no objeto
      municipio.getCadmunPK().setCoduf(codUf);
    
      municipio.getCadmunPK().setCodmunic(codMun);
      
      municipioSearchead = municipioController.findEqual(municipio);
                //faz a busca pelo Codigo do municipio digitado, se nao encontra notifica ao usuário
                if (municipioSearchead==null) {  
                       JOptionPane.showMessageDialog(this.component,fieldName + " INCORRETO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }
                  txtField.setBackground(Color.WHITE);
                  municNome.setText(municipioSearchead.getNome());
                return true;
       }
    
}
