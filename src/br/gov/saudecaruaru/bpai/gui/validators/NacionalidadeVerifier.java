/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.validators;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.business.model.Municipio;
import br.gov.saudecaruaru.bpai.gui.CadastroIndividualizado;
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
public class NacionalidadeVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private DiversasController diversasController;
    private Diversas diversas;
    private DiversasPK diversasPk;
    private JTextField nacioNome;
    public NacionalidadeVerifier(Component component,String fieldName,JTextField nacioNome) {
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
        diversas.getDiversasPK().setCodigoTabela(Diversas.TABELA_PAIS);
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
       JTextComponent txtField = (JTextField) input; 
      String valor = txtField.getText();
       //objeto procurado
       Diversas diversasNacioSearchead = null;
      //seta o valor digitado no objeto
      diversas.getDiversasPK().setCodigoItemTabela(valor);
      
      //faz a busca pelo CBO digitado, se nao encontra notifica ao usuário
      diversasNacioSearchead=CadastroIndividualizado.MAP_DIVERSAS.get(this.diversas.getDiversasPK());
      if(diversasNacioSearchead==null){
        diversasNacioSearchead = diversasController.findEqual(diversas);
      }
                
      if (diversasNacioSearchead==null) {  
                       JOptionPane.showMessageDialog(this.component,fieldName + " INCORRETO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
       }
      CadastroIndividualizado.MAP_DIVERSAS.put(diversasNacioSearchead.getDiversasPK(), diversasNacioSearchead);
      txtField.setBackground(Color.WHITE);
       nacioNome.setText(diversasNacioSearchead.getDescricaoItemTabela());
       return true;
       }
    
}
