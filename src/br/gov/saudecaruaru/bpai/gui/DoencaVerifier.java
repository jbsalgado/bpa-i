/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.controller.DoencaController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoDoencaController;
import br.gov.saudecaruaru.bpai.business.model.Doenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoencaPK;
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
    private JTextField codProc;
    public DoencaVerifier(Component component,String fieldName,JTextField doencaNome,JTextField codProc) {
        this.fieldName = fieldName;
        this.component = component;
        this.doencaNome = doencaNome;
        this.codProc = codProc;
        //instancia o controlador de  municipio
         this.doencaController = new  DoencaController();
        //instancia o modelo  MunicipioPk
        this.doenca= new   Doenca();     
        this.procedimentoDoencaPK = new ProcedimentoDoencaPK(); 
        this.procedimentoDoenca = new ProcedimentoDoenca(procedimentoDoencaPK);
        this.procedimentoDoencaController = new ProcedimentoDoencaController();
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
                       JOptionPane.showMessageDialog(this.component,fieldName + " NÃO CADASTRADO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }else if(doencaSearchead.getSubcategoria()=='N'){
                     JOptionPane.showMessageDialog(this.component,fieldName + " NÃO PERTENCA A UMA SUBCATEGORIA!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }else if(!temProcedimentoEDoenca(valor, codProc.getText().substring(0, 9))){
                     JOptionPane.showMessageDialog(this.component, " PROCED. INCOMPATIVEL COM CID!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }
                  txtField.setBackground(Color.WHITE);
                  doencaNome.setText(doencaSearchead.getDescricao());
                return true;
       }
    
    
    
    
    private boolean temProcedimentoEDoenca(String CID,String codProc){
        procedimentoDoenca.getProcedimentoDoencaPK().setProcedimentoCodigo(codProc);
        procedimentoDoenca.getProcedimentoDoencaPK().setCodigoCid(CID);
        
        if(procedimentoDoencaController.findAllEqual(procedimentoDoenca).isEmpty()){
            return false;
        }
        
        return true;
    }
    
}
