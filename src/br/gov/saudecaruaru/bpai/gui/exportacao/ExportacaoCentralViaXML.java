/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui.exportacao;

import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.service.SMessageWebService;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoXML;
import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Albuquerque
 */
public class ExportacaoCentralViaXML implements IExportacaoStrategy {

    private static Logger logger = Logger.getLogger(ExportacaoXML.class);
    private BIProcedimentoRealizadoXML bIProcedimentoRealizadoXML = new BIProcedimentoRealizadoXML();
    private BIProcedimentoRealizadoDAO bIProcedimentoRealizadoDAO = new BIProcedimentoRealizadoDAO();

    @Override
    public String execute(String competenciaMovimento, String cnesUnidade) {
        String msg = null;
        try {

            //busca a produção a ser exportada
            Map<String, Object> rest = new HashMap<String, Object>();
            rest.put("competenciaMovimento", competenciaMovimento);
            rest.put("biProcedimentoRealizadoPK.cnesUnidade", cnesUnidade);
            List<BIProcedimentoRealizado> list = this.bIProcedimentoRealizadoDAO.findAllEqual(rest);
            //agora cria o arquivo
            String fileName = SistemaController.DIRETORIO_PRINCIPAL + "/exportacao.xml";
            this.bIProcedimentoRealizadoXML.salvar(list, fileName);
            //exporta para o servidor.
            SMessageWebService[] m = SistemaController.getnstance().enviarProducaoParaServidor(new File(fileName),competenciaMovimento,cnesUnidade);
            if (m == null) {
                msg = "Erro ao exportar o arquivo. Verifique sua coneção com a internet.";
            }
            else{
                StringBuilder str= new StringBuilder();
                for(SMessageWebService message: m){
                    str.append(message.getMessage());
                    str.append("\n");
                    if (message.getTipo().equals("0")){
                        str.append("ERRO: ");
                        str.append(message.getCodigo());
                        
                    }
                    str.append("\n");
                }
                msg=str.toString();
            }
        } catch (Exception ex) {
            logger.error("ERRO ao tentar executar o método execute. " + ex.getMessage());
            msg = "Erro ao tentar enviar o arquivo. Comunique o ocorrido aos desenvolvedores.";
        } finally {
            return msg;
        }
    }
}
