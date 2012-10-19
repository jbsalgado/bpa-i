/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
import org.apache.log4j.Logger;

/**
 *
 * @author Albuquerque
 */
public class ExportacaoBPAMagnetico implements IExportacaoStrategy{

    private static Logger logger= Logger.getLogger(ExportacaoXML.class);
    
    private BIProcedimentoRealizadoController bIProcedimentoRealizadoController=new BIProcedimentoRealizadoController();
    private ProcedimentoRealizadoDAO procedimentoRealizadoDAO= new ProcedimentoRealizadoDAO();
    private BIProcedimentoRealizado bIProcedimentoRealizado;
    private ProcedimentoRealizadoController procedimentoRealizadoController= new ProcedimentoRealizadoController();

    public ExportacaoBPAMagnetico(BIProcedimentoRealizado bIProcedimentoRealizado) {
        this.bIProcedimentoRealizado=bIProcedimentoRealizado;
    }
    
    
    @Override
    public String execute(String competenciaMovimento, String cnesUnidade) {
        String msg="Falha na exportacão dos dados!\nComunique o ocorrido ao desenvolvedores do sistema.";
        try{
            //apaga os dados 
            ProcedimentoRealizado p=new ProcedimentoRealizado(this.bIProcedimentoRealizado);
            p.setCompetenciaMovimento(competenciaMovimento);
            p.getProcedimentoRealizadoPK().setCnesUnidade(cnesUnidade);
            
            if(this.procedimentoRealizadoController.removeAll(p)){
            
                if(this.bIProcedimentoRealizadoController.findAllProcedimentosIndividuaisAndSave(competenciaMovimento,cnesUnidade ,procedimentoRealizadoDAO, 100)){
                    if(this.bIProcedimentoRealizadoController.findAllProcedimentosConsolidadosAndSave(competenciaMovimento,cnesUnidade, procedimentoRealizadoDAO, 100)){

                        msg= "Exportação concluída com sucesso!\nAbra o BPA Magnético para ver os resultados.";
                    }
                }
            }
        }catch(Exception ex){
            logger.error("Método execute. "+ex.getMessage());
        }
        finally{
            return msg;
        }
    }

    
}
