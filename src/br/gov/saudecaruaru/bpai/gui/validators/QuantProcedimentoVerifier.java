/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;


import br.gov.saudecaruaru.bpai.business.controller.MunicipioController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoCboController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
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
    private TelaCadastroI t;
    private ProcedimentoCbo procedimentoCbo;
    private ProcedimentoCboPK procedimentoCboPK;
    private ProcedimentoCboController procedimentoCboController;
    
    
    public QuantProcedimentoVerifier(Component component,String fieldName,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.t = t;
       
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
      JTextField txtField = (JTextField) input; 
      String valor = txtField.getText();
      double quant = Double.parseDouble(valor);
      String proc = t.getProcedimentoRealizado().getProcedimentoRealizadoPK().getCodigoProcedimento();
      //pega os sete primeiros digitos (que representam o codigo do procedimento)
      String codProc = proc.substring(0,9);
       //pega o oitavo digito (que representam o digito verificador)
      Character digitoVerificador = proc.charAt(9);
    
      procedimento.getProcedimentoPk().setId(codProc);
      procedimento.setDigitoVerificador(digitoVerificador);
      
      List<Procedimento> procedimentoSearchead = null;
     
     
      
      //faz a busca pelo Procedimento  digitado, se nao encontra notifica ao usuário
      procedimentoSearchead = procedimentoController.findAllEqual(this.procedimento);
               
                if (!procedimentoSearchead.isEmpty()) {  
                    double quantMaxima = procedimentoSearchead.get(0).getQuantidadeMaximaExecucao();
                    if(quant>quantMaxima){
                          return  MessagesErrors.exibeTelaContinuaErro(component,null," ERRO! QUANTIDADE MÁXIMA PERMITIDA "+quantMaxima, txtField);
                    }
                }
                  txtField.setBackground(Color.WHITE);
                return true;
       }
        
      
    
}
