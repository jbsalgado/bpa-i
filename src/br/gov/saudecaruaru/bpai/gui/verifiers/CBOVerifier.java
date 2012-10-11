/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
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
public class CBOVerifier extends InputVerifier{
    private String fieldName; 
    private Component component;
    private DiversasController diversasController;
    private Diversas diversas;
    private DiversasPK diversasPk;
    public CBOVerifier(Component component,String fieldName) {
        this.fieldName = fieldName;
        this.component = component;
        //instancia o controlador de diversas
        diversasController = new DiversasController();
        //instancia o modelo DiversasPk
        diversas = new  Diversas();
        diversasPk = new DiversasPK();
        diversas.setDiversasPK(diversasPk);
        //seta o codigo da tabela que será usado na busca, nesse caso a tabela Profissão
        diversas.getDiversasPK().setCodigoTabela(Diversas.TABELA_PROFISSAO);
        
    }
    
    
    @Override
    public boolean verify(JComponent input) {
      JTextComponent txtField = (JTextField) input; 
      String valor = txtField.getText();
      //seta o valor digitado no objeto
      diversas.getDiversasPK().setCodigoItemTabela(valor);
                //faz a busca pelo CBO digitado, se nao encontra notifica ao usuário
                //primeiro tenta buscar os que ja foram selecionados
                Diversas d=CadastroIndividualizado.MAP_DIVERSAS.get(this.diversas.getDiversasPK());
                if(d==null){
                    //pega no banco de dados
                        d=diversasController.findEqual(diversas);
                }
                //não encontrou pq não tem!
                if (d==null) {  
                       JOptionPane.showMessageDialog(this.component,fieldName + " INCORRETO!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                    return false;
                }
                //vai adicionar o CBO
                CadastroIndividualizado.MAP_DIVERSAS.put(d.getDiversasPK(), d);
                txtField.setBackground(Color.WHITE);
                return true;
       }
    
}
