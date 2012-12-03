/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoXML;
import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author Albuquerque
 */
public class ImportacaoBackup implements IExportacaoStrategy{

    private static Logger logger= Logger.getLogger(ExportacaoXML.class);
    private BIProcedimentoRealizadoXML bIProcedimentoRealizadoXML= new BIProcedimentoRealizadoXML();
    private BIProcedimentoRealizadoDAO bIProcedimentoRealizadoDAO= new BIProcedimentoRealizadoDAO();
    private String filePath;
    private BIProcedimentoRealizado bIProcedimentoRealizado;

    public ImportacaoBackup(String filePath, BIProcedimentoRealizado bIProcedimentoRealizado) {
        this.filePath = filePath;
        this.bIProcedimentoRealizado = bIProcedimentoRealizado;
    }
    
    
    
    @Override
    public String execute(String competenciaMovimento, String cnesUnidade) {
        String msg=null;
        try{
            this.bIProcedimentoRealizado.getBiProcedimentoRealizadoPK().setCnesUnidade(cnesUnidade);
            this.bIProcedimentoRealizado.setCompetenciaMovimento(competenciaMovimento);
            List<BIProcedimentoRealizado> list=this.bIProcedimentoRealizadoXML.carregar(this.filePath);
            this.bIProcedimentoRealizadoDAO.merge(list);
            msg="Importação do arquivo Backup realizada com sucesso.";
        }catch(Exception ex){
            ex.printStackTrace();
            logger.error(ex.getMessage());
            msg= "Falha na importação do arquivo de Backup!. Contacte os dedsenvolvedores do sistema";
        }
        finally{
            return msg;
        }
    }
    
}
