/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.gui.CadastroIndividualizado;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import java.awt.Color;
import java.awt.Component;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

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
    public EtniaVerifier(Component component,String fieldName,JTextField nacioNome) {
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
          //faz a busca pelo CBO digitado, se nao encontra notifica ao usuário
          diversasEtniaSearchead = diversasController.findEqual(diversas);
      }
                
        if (diversasEtniaSearchead==null) {  
            MessagesErrors.erro(component,txtField,fieldName+" INCORRETO!");  
            return false;
            
        }
        //guarda a busca no banco de dados
        CadastroIndividualizado.MAP_DIVERSAS.put(diversasEtniaSearchead.getDiversasPK(), diversasEtniaSearchead);
        txtField.setBackground(Color.WHITE);
        nacioNome.setText(diversasEtniaSearchead.getDescricaoItemTabela());
        return true;
       }
    
}