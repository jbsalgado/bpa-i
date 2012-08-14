/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.controller.MunicipioController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.model.Municipio;
import br.gov.saudecaruaru.bpai.business.model.MunicipioPK;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoPK;
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
public class ProcedimentoVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private ProcedimentoController procedimentoController;
    private  Procedimento procedimento;
    private ProcedimentoPK  procedimentoPk;
    private JTextField municNome;
    public ProcedimentoVerifier(Component component,String fieldName,JTextField muniNome) {
        this.fieldName = fieldName;
        this.component = component;
        this.municNome = muniNome;
        //instancia o controlador de  municipio
         procedimentoController = new  ProcedimentoController();
        //instancia o modelo  MunicipioPk
         this.procedimento= new   Procedimento();
         procedimentoPk = new   ProcedimentoPK();
         this.procedimento.setProcedimentoPk(procedimentoPk);
        
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextComponent txtField = (JTextField) input; 
      List<Procedimento> procedimentoSearchead = null;
      String valor = txtField.getText();
       //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = valor.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = valor.charAt(9);
    
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      
      //faz a busca pelo Procedimento  digitado, se nao encontra notifica ao usuário
      procedimentoSearchead = procedimentoController.findAllEqual(this.procedimento);
               
                if (procedimentoSearchead==null) {  
                       JOptionPane.showMessageDialog(this.component,fieldName + " INCORRETO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }
                  txtField.setBackground(Color.WHITE);
                  municNome.setText(procedimentoSearchead.get(0).getDescricao());
                return true;
       }
    
}
