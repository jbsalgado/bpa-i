/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import br.gov.saudecaruaru.bpai.business.model.AcessoPK;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.data.AcessoDAO;
import br.gov.saudecaruaru.bpai.data.BasicDAO;
import br.gov.saudecaruaru.bpai.data.DiversasDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.priuli.filter.Filter;
import net.priuli.filter.utils.FactoryFilter;

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
        HashMap<String, Object> rest=new HashMap<String, Object>();
        rest.put("diversasPK.codigoItemTabela", "223605");
        //rest.put("digitoVerificador", "3");
        List<Diversas> l=t.findAllEqual(rest) ;
        for(Diversas a: l){
           // System.out.println(a.getDescricao()+"/"+a.getProcedimentoPk().getCompetencia()+'/'+a.getProcedimentoPk().getId());
             System.out.println("Descrição: "+a.getClass().getPackage());
        }
        System.out.println(l.size());
        
    }
}
