/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
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

    public ExportacaoBPAMagnetico(BIProcedimentoRealizado bIProcedimentoRealizado) {
        this.bIProcedimentoRealizado=bIProcedimentoRealizado;
    }
    
    
    @Override
    public String execute() {
        String msg=null;
        try{
            this.bIProcedimentoRealizadoController.findAllProcedimentosIndividuaisAndSave(this.bIProcedimentoRealizado.getBiProcedimentoRealizadoPK().getCompetencia(), procedimentoRealizadoDAO, 100);
            this.bIProcedimentoRealizadoController.findAllProcedimentosConsolidadosAndSave(this.bIProcedimentoRealizado.getBiProcedimentoRealizadoPK().getCompetencia(), procedimentoRealizadoDAO, 100);
            msg= "Exportação concluída com sucesso!\nAbra o BPA Magnético para ver os resultados.";
        }catch(Exception ex){
            msg="Falha na exportacão dos dados!\nComunique o ocorrido ao desenvolvedores do sistema.";
            logger.error("Método execute. "+ex.getMessage());
        }
        finally{
            return msg;
        }
    }
    
}
