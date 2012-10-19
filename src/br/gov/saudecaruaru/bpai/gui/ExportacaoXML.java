/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoXML;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Albuquerque
 */
public class ExportacaoXML implements IExportacaoStrategy{
    
    private static Logger logger= Logger.getLogger(ExportacaoXML.class);
    private BIProcedimentoRealizadoXML bIProcedimentoRealizadoXML= new BIProcedimentoRealizadoXML();
    private BIProcedimentoRealizadoDAO bIProcedimentoRealizadoDAO= new BIProcedimentoRealizadoDAO();
    private String filePath;
    private BIProcedimentoRealizado bIProcedimentoRealizado;

    public ExportacaoXML(String filePath, BIProcedimentoRealizado bIProcedimentoRealizado) {
        this.filePath = filePath;
        this.bIProcedimentoRealizado = bIProcedimentoRealizado;
    }

    @Override
    public String execute(String competenciaMovimento,String cnesUnidade) {
        String msg=null;
        this.bIProcedimentoRealizado.setCompetenciaMovimento(competenciaMovimento);
        this.bIProcedimentoRealizado.getBiProcedimentoRealizadoPK().setCnesUnidade(cnesUnidade);
        try{
            List<BIProcedimentoRealizado> list=this.bIProcedimentoRealizadoDAO.findAllEqual(this.bIProcedimentoRealizado);
            this.bIProcedimentoRealizadoXML.salvar(list, this.filePath);
            msg="Exportação para o arquivo XML executada com sucesso!.";
        }catch(Exception ex){
            msg="Falha na exportação para o arquivo XML! Comunique aos desenvolvedores do sistema!";
            logger.error("Método execute. "+ex.getMessage());
        }
        finally{
            return msg;
        }
    }
    
    
}
