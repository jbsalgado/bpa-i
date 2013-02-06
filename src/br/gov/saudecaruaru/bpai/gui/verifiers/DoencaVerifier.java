/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;


import br.gov.saudecaruaru.bpai.business.controller.DoencaController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoDoencaController;
import br.gov.saudecaruaru.bpai.business.model.Doenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoencaPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.interfaces.TelaCadastroI;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
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
    private ProcedimentoDoenca procedimentoDoenca;
    private ProcedimentoDoencaPK procedimentoDoencaPK;
    private ProcedimentoDoencaController procedimentoDoencaController;
    private  Doenca  doenca;
    private JTextField doencaNome;
    private TelaCadastroI t;
    public DoencaVerifier(Component component,String fieldName,JTextField doencaNome,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.doencaNome = doencaNome;
        this.t = t;
        //instancia o controlador de  municipio
         this.doencaController = new  DoencaController();
        //instancia o modelo  MunicipioPk
        this.doenca= new   Doenca();     
        this.procedimentoDoencaPK = new ProcedimentoDoencaPK(); 
        this.procedimentoDoenca = new ProcedimentoDoenca(procedimentoDoencaPK);
        this.procedimentoDoencaController = new ProcedimentoDoencaController();
        
        this.procedimentoDoencaPK.setCompetencia(null);
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextField txtField = (JTextField) input; 
      Doenca doencaSearchead = null;
      String valor = txtField.getText();
      
      
      
      
      
      
      ProcedimentoRealizado procedimentoRealizado = t.getProcedimentoRealizado();
      
      
      //seta o valor digitado no objeto
      doenca.setCodigo(valor);
      
    
      doencaSearchead = doencaController.findEqual(doenca);
             String valor2 = txtField.getText().trim();
             if(valor2.isEmpty()){
                 if(procedimentoRealizado.getCodigoProcedimento()!=null){
                  String codigoProc = procedimentoRealizado.getCodigoProcedimento().substring(0, 9);
                        if(!procedimentoDoencaController.exigeCid(codigoProc)){
                            txtField.setBackground(Color.WHITE);  
                            return true;
                        }else {
                            MessagesErrors.erro(component,txtField," PROCED. EXIGE CID!");
                            return false;
                        }
                 }else{
                     return true;
                 }
             }
               
                //faz a busca pelo Codigo do municipio digitado, se nao encontra notifica ao usuário
                if (doencaSearchead==null) { 
                        MessagesErrors.erro(component,txtField,fieldName+ " NÃO CADASTRADO!");
                        return false;
                       
                }else{
                    
                    if(doencaSearchead.getSubcategoria()=='N'){
                            MessagesErrors.erro(component,txtField,fieldName+ "  NÃO PERTENCA A UMA SUBCATEGORIA!");
                            return false;
                       
                    }
                     if(procedimentoRealizado.getCodigoProcedimento()!=null){
                            if(!procedimentoDoencaController.existProcedimentoEDoenca(valor,procedimentoRealizado.getCodigoProcedimento().substring(0, 9),ModelUtil.COMPETENCIA_MAIS_RECENTE)){
                                return  MessagesErrors.continuaErro(component,fieldName," PROCED. INCOMPATIVEL COM CID!", txtField);
                            }
                     } 
                    doencaNome.setText(doencaSearchead.getDescricao());
                }
                  txtField.setBackground(Color.WHITE);
                  doencaNome.setText(doencaSearchead.getDescricao());
                return true;
       }
    
    
    
    
   
    
}
