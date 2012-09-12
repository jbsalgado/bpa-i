/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.data.*;
import br.gov.saudecaruaru.bpai.gui.SearchGeneric;
import java.util.HashMap;

/**
 *
 * @author Junior Pires
 */
public class BPAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGeneric.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        ProcedimentoRealizado pr = new ProcedimentoRealizado();
        
        BIProcedimentoRealizadoController prc = new BIProcedimentoRealizadoController();
        
        pr.getProcedimentoRealizadoPK().setCnesUnidade("3083721");
        pr.getProcedimentoRealizadoPK().setCnsMedico("980016277313814");
        pr.getProcedimentoRealizadoPK().setCboMedico("223505");
        pr.getProcedimentoRealizadoPK().setCompetencia("201206");
        
        BIProcedimentoRealizado BIpr = new BIProcedimentoRealizado(pr);
        String folha = prc.getNextFolha(BIpr);
        System.out.println("Folha "+folha);
        
//        BIProcedimentoRealizadoDAO dr=new BIProcedimentoRealizadoDAO();
//        for(BIProcedimentoRealizado p:dr.findAll()){
//            System.out.println(p);
//        }
    }
}
