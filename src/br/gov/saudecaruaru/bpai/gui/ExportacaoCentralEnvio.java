/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.SProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Albuquerque
 */
public class ExportacaoCentralEnvio extends ExportacaoCentral implements IExportacaoStrategy{
    
    
    public ExportacaoCentralEnvio(SUsuarioDesktop sUsuarioDesktop, String competencia) {
        super(sUsuarioDesktop);
    }

    public ExportacaoCentralEnvio(SUsuarioDesktop sUsuarioDesktop, int maxResult) {
        super(sUsuarioDesktop, maxResult);
    }
    
    
    
    @Override
    public String execute(String competenciaMovimento,String cnesUnidade) {
        List<Thread> threads= new ArrayList<Thread>();
        HashMap<String, Object> restr= new HashMap<String,Object>();
        
        restr.put("enviado", BIProcedimentoRealizado.NAO_ENVIADO);
        restr.put("biProcedimentoRealizadoPK.cnesUnidade", cnesUnidade);
        restr.put("competenciaMovimento", competenciaMovimento);
        threads.addAll( this.enviar(restr) );
//        while(task >0){
//            task=0;
//            for(Thread t: threads){
//                //não terminou o serviço
//                if(  t.isAlive() ){
//                    //vai fazer a thread esperar
//                    synchronized (this){
//                        try {
//                            Thread.currentThread().wait(3000L);
//                        } catch (InterruptedException ex) {
//                            Logger.getLogger(ExportacaoServidorCentral.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                    //depois da durmida
//                    task++;
//                }
//            }
//        }
        return "Essa operação é executada em segundo plano.\nVocê pode continuar usando o programa.";
    }
    
    
}
