/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.data.*;
import br.gov.saudecaruaru.bpai.gui.SearchGeneric;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        
        
        BasicDAO<Diversas> t= new DiversasDAO();
        Diversas d = new Diversas();
        d.setDiversasPK(new DiversasPK());
        d.getDiversasPK().setCodigoTabela(Diversas.TABELA_PROFISSAO);
        //d.setCdnDscr("Fisioterapeuta geral");
        //HashMap<String, Object> rest=new HashMap<String, Object>();
         ///rest.put("sCdnPK.cdnIt", "223605");
        //rest.put("digitoVerificador", "3");
//        List<Diversas> l=t.findAllEqual(d) ;
//        Map<String,String> m=ModelUtil.getMapSearch(l, "diversasPK.codigoItemTabela", "descricaoItemTabela");
//        for(String a: m.keySet()) {
//           // System.out.println(a.getDescricao()+"/"+a.getProcedimentoPk().getCompetencia()+'/'+a.getProcedimentoPk().getId());
//           //  System.out.println("Descrição: "+a.getCdnDscr()+"ID "+a.getSCdnPK().getCdnIt());
//           System.out.println("codigo CBO: "+a+"/"+m.get(a));
//        }
// 
//        System.out.println(l.size());
        System.out.println(SearchGeneric.getInstance().initModeSearch(new ProcedimentoController(),
                                            "procedimentoPk.id", "descricao","Id","Nome"));
        
    }
}
