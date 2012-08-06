/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import br.gov.saudecaruaru.bpai.data.AcessoDAO;
import br.gov.saudecaruaru.bpai.data.BasicDAO;

/**
 *
 * @author Junior Pires
 */
public class BPAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BasicDAO<Acesso> t= new AcessoDAO();
        for(Acesso a: t.findAll()){
            System.out.println(a.getAcessoPK().getUsername());
        }
    }
}
