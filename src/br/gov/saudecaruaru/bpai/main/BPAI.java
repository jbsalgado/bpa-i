/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.data.AcessoDAO;
import br.gov.saudecaruaru.bpai.data.BasicDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDAO;
import java.util.List;
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
        BasicDAO<Acesso> ac=new AcessoDAO();
        for(Acesso a: ac.encontreTodos()){
             System.out.println(a.getAcessoPK().getUsername());
        }
        BasicDAO<Procedimento> t= new ProcedimentoDAO();
        Filter filter= FactoryFilter.createFilter();
        filter.addRestriction("procedimentoPk.competencia", "201206");
        
        List<Procedimento> l=t.encontreTodos(filter) ;
        for(Procedimento a: l){
            System.out.println(a.getDescricao()+"/"+a.getProcedimentoPk().getCompetencia()+'/'+a.getProcedimentoPk().getId());
        }
        System.out.println(l.size());
        
    }
}
