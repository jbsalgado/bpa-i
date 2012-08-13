/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.data.*;
import java.util.List;

/**
 *
 * @author Junior Pires
 */
public class BPAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BasicDAO<Diversas> t= new DiversasDAO();
        Diversas d = new Diversas();
        //d.setSCdnPK(new DiversasPK());
        //d.getSCdnPK().setCdnIt("223605");
        //d.setCdnDscr("Fisioterapeuta geral");
        //HashMap<String, Object> rest=new HashMap<String, Object>();
         ///rest.put("sCdnPK.cdnIt", "223605");
        //rest.put("digitoVerificador", "3");
        List<Diversas> l=t.findAllEqual(d) ;
        for(Diversas a: l){
           // System.out.println(a.getDescricao()+"/"+a.getProcedimentoPk().getCompetencia()+'/'+a.getProcedimentoPk().getId());
           //  System.out.println("Descrição: "+a.getCdnDscr()+"ID "+a.getSCdnPK().getCdnIt());
        }
 
        System.out.println(l.size());
        
    }
}
