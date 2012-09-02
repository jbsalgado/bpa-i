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
        
        
        BasicDAO<Diversas> t= new DiversasDAO();
        Diversas d = new Diversas();
        d.setDiversasPK(new DiversasPK());
        d.getDiversasPK().setCodigoTabela(Diversas.TABELA_PROFISSAO);
        
        BIProcedimentoRealizadoDAO test= new BIProcedimentoRealizadoDAO();
        ProcedimentoRealizadoDAO dao= new ProcedimentoRealizadoDAO();
        HashMap<String,Object> res= new HashMap<String, Object>();
        
        res.put("procedimentoPk.competencia", "201206");
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
//        System.out.println(SearchGeneric.getInstance().initModeSearch(new ProcedimentoController(),
//                                            "procedimentoPk.id", "descricao","Id","Nome",res));
        
        BIProcedimentoRealizadoController ctrl= new BIProcedimentoRealizadoController();
        BIProcedimentoRealizado pro=new BIProcedimentoRealizado();
        
        pro.setCaracterizacaoAtendimento("02");
        pro.setCidDoencaprocedimento("Q730");
        pro.setNacionalidadePaciente("010");
        pro.setSexoPaciente("F");
        pro.setNomePaciente("kauanne esthafane silva");
        pro.setRacaPaciente("99");
        pro.setQuantidadeRealizada(2d);
        pro.setCnsPaciente("");
        pro.setCodigoIBGECidadePaciente("260410");
        pro.setDataNascimentoPaciente("19900112");
        BIProcedimentoRealizadoPK pk= new BIProcedimentoRealizadoPK();
        pk.setCboMedico("223505");
        pk.setCnsMedico("980016277313811");
        pk.setCnesUnidade("3083721");
        pro.setCodigoProcedimento("0310010012");
        pro.setCompetencia("201206");
        pro.setDataAtendimento("20120606");
        //pro.setNumeroFolha("001");
        //pro.setSequenciaFolha("01");
        pro.setBiProcedimentoRealizadoPK(pk);
        //ctrl.salvar(pro);
        
        
    int i=0;
    for(ProcedimentoRealizado p: dao.findAllConsolidados("", 0, 1000)){
        i++;
        System.out.println(p.getQuantidadeRealizada());
    }
    System.out.println("Tamanho do resultado: "+i);
    }
}
