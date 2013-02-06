/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.gui.MessagesErrors;
import br.gov.saudecaruaru.bpai.gui.interfaces.TelaCadastroI;
import java.awt.Component;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author Junior Pires
 */
  //classe validadora para o campo CNSUsuario
public class CnsUsuarioVerifier extends CnsVerifier{
        private Component component=null;
        private TelaCadastroI t=null;
        public CnsUsuarioVerifier(Component component, String fieldName,TelaCadastroI t) {
            super(component, fieldName);
            this.component=component;
            this.t =t;
        }

        @Override
        public boolean verify(JComponent input) {
             JTextField txtField = (JTextField) input;
             ProcedimentoRealizado proRealizado = t.getProcedimentoRealizado();
             
             String valor = txtField.getText().trim();
             if(!valor.isEmpty() && proRealizado.getProcedimentoRealizadoPK().getCnsMedico()!=null ){
                 
                 if(valor.equals(proRealizado.getProcedimentoRealizadoPK().getCnsMedico())){
                    MessagesErrors.erro(component,txtField," CNS do Usuário é igual ao CNS do profissional!");    
                    return false;
                 }
                return super.verify(input);
            }
             return true;
        }
}
