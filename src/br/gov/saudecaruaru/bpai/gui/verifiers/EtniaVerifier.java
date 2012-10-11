/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.business.validators.ProcedimentoRealizadoValidator;
import br.gov.saudecaruaru.bpai.gui.CadastroIndividualizado;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.TelaCadastroI;
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
public class EtniaVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private DiversasController diversasController;
    private Diversas diversas;
    private DiversasPK diversasPk;
    private JTextField nacioNome;
    private TelaCadastroI t;
    private ProcedimentoRealizadoValidator prv;
    public EtniaVerifier(Component component,String fieldName,JTextField nacioNome,TelaCadastroI t) {
        this.fieldName = fieldName;
        this.component = component;
        this.nacioNome = nacioNome;
        //instancia o controlador de diversas
        diversasController = new DiversasController();
        //instancia o modelo DiversasPk
        diversas = new  Diversas();
        diversasPk = new DiversasPK();
        diversas.setDiversasPK(diversasPk);
        //seta o codigo da tabela que será usado na busca, nesse caso a tabela Profissão
        diversas.getDiversasPK().setCodigoTabela(Diversas.TABELA_ETNIA);
        this.t = t;
        
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
       JTextField txtField = (JTextField) input; 
      String valor = txtField.getText();
     
       //objeto procurado
       Diversas diversasEtniaSearchead = null;
      //seta o valor digitado no objeto
      diversas.getDiversasPK().setCodigoItemTabela(valor);
      diversasEtniaSearchead=CadastroIndividualizado.MAP_DIVERSAS.get(this.diversas.getDiversasPK());
      if(diversasEtniaSearchead==null){
          t.getProcedimentoRealizado().setEtniaPaciente(valor);
          prv = new ProcedimentoRealizadoValidator(t.getProcedimentoRealizado());
          String msg = prv.validExisteEtnia();
          if(!msg.equals("")){
                //exibe mensagem de erro
                MessagesErrors.erro(component,txtField,msg); 
                return false;
          }
//          //faz a busca pelo CBO digitado, se nao encontra notifica ao usuário
//          diversasEtniaSearchead = diversasController.findEqual(diversas);
      }
                
//        if (diversasEtniaSearchead==null) {  
//            JOptionPane.showMessageDialog(this.component,fieldName+" INCORRETO!", 
//                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
//                txtField.setBackground(Color.RED);
//                    return false;
//            
//        }
        //guarda a busca no banco de dados
        CadastroIndividualizado.MAP_DIVERSAS.put(diversasEtniaSearchead.getDiversasPK(), diversasEtniaSearchead);
        txtField.setBackground(Color.WHITE);
        nacioNome.setText(diversasEtniaSearchead.getDescricaoItemTabela());
        return true;
       }
    
}
