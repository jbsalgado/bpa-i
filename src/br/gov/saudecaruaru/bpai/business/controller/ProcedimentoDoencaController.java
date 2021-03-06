/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Doenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoenca;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoDoencaPK;
import br.gov.saudecaruaru.bpai.data.GenericDAO;
import br.gov.saudecaruaru.bpai.data.ProcedimentoDoencaDAO;
import br.gov.saudecaruaru.bpai.util.ModelUtil;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoDoencaController extends BasecController<ProcedimentoDoenca> {

    public ProcedimentoDoencaController() {
        super(new ProcedimentoDoencaDAO());
    }
    
    
    public boolean exigeCid(String codProc){
      
       ProcedimentoDoencaPK  procedimentoDoencaPK = new ProcedimentoDoencaPK(); 
       ProcedimentoDoenca procedimentoDoenca = new ProcedimentoDoenca(procedimentoDoencaPK);
       
       
        procedimentoDoenca.getProcedimentoDoencaPK().setProcedimentoCodigo(codProc);
        procedimentoDoenca.getProcedimentoDoencaPK().setCompetencia(ModelUtil.COMPETENCIA_MAIS_RECENTE);
        if(!findAllEqual(procedimentoDoenca).isEmpty()){
            return true;
        }
        return false;
    }
    
    public boolean existProcedimentoEDoenca(String CID,String codProc,String competencia){
        
        
       ProcedimentoDoencaPK  procedimentoDoencaPK = new ProcedimentoDoencaPK(); 
       ProcedimentoDoenca procedimentoDoenca = new ProcedimentoDoenca(procedimentoDoencaPK);
       
        procedimentoDoenca.getProcedimentoDoencaPK().setProcedimentoCodigo(codProc);
        procedimentoDoenca.getProcedimentoDoencaPK().setCodigoCid(CID);
        procedimentoDoenca.getProcedimentoDoencaPK().setCompetencia(competencia);
        
        
        if(findEqual(procedimentoDoenca)==null){
            return false;
        }
        
        return true;
    }
    
}
