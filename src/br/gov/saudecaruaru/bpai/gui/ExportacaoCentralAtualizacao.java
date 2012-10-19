/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public class ExportacaoCentralAtualizacao extends ExportacaoCentral implements IExportacaoStrategy {
    
    private String competencia;

    public ExportacaoCentralAtualizacao(String competencia, SUsuarioDesktop sUsuarioDesktop) {
        super(sUsuarioDesktop);
        this.competencia = competencia;
    }

    public ExportacaoCentralAtualizacao(String competencia, SUsuarioDesktop sUsuarioDesktop, int maxResult) {
        super(sUsuarioDesktop, maxResult);
        this.competencia = competencia;
    }

    
    @Override
    public String execute() {
        List<Thread> threads= new ArrayList<Thread>();
        HashMap<String, Object> restr= new HashMap<String,Object>();
        if( this.competencia != null ? !this.competencia.isEmpty() : false){
            restr.put("biProcedimentoRealizadoPK.competencia", this.competencia);
        }
        
        restr.put("atualizado", BIProcedimentoRealizado.NAO_ATUALIZADO);
        threads.addAll(this.atualizar(restr));
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
