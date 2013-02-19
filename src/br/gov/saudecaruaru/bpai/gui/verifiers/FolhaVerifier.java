/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.verifiers;

import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
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
//classe validadora para o campo CNSUsuario
public class FolhaVerifier extends InputVerifier {

    private Component component = null;

    public FolhaVerifier(Component component, String fieldName) {
        this.component = component;

    }

    @Override
    public boolean verify(JComponent input) {
        JTextField txtField = (JTextField) input;
        String valor = txtField.getText().trim();
        if (!validarFolha(valor)) {
            MessagesErrors.erro(component, txtField, " Folha Inválida!");
            return false;
        }
        //seta cor branca
        txtField.setBackground(Color.WHITE);
        return true;
    }

    public static boolean validarFolha(String numero) {
        if (numero == null) {
            return false;
        } else if (numero.isEmpty()) {
            return false;
        } //converte para um inteiro
        else {
            try {
                int n = Integer.parseInt(numero);
                if (n <= 0 || n > ProcedimentoRealizado.MAXIMA_QUANTIDADE_FOLHA) {
                    return false;
                }
                return true;
            } catch (NumberFormatException ex) {
                //não é um número
                return false;
            }
        }

    }
}
