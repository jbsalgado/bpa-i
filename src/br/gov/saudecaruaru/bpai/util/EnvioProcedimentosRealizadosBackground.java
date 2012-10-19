/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.SProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
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
public class EnvioProcedimentosRealizadosBackground implements Runnable{
    private BIProcedimentoRealizadoController bIProcedimentoRealizadoController=new BIProcedimentoRealizadoController();
    private SProcedimentoRealizadoController sProcedimentoRealizadoController= new SProcedimentoRealizadoController();
    private int timeSleep=1000; //um minuto
    private int maxResult=30;
    private boolean runInBackground=true;
    private SUsuarioDesktop sUsuarioDesktop;

    public EnvioProcedimentosRealizadosBackground() {
    }

    public EnvioProcedimentosRealizadosBackground(SUsuarioDesktop sUsuarioDesktop,boolean runInBackground, int timeSleep,int maxResult) {
        this.runInBackground=runInBackground;
        this.timeSleep=timeSleep;
        this.maxResult=maxResult;
        this.sUsuarioDesktop=sUsuarioDesktop;
    }
    
    
    @Override
    public void run() {
        //map para guardar as restrições
        HashMap<String, Object> restr= new HashMap<String, Object>();
        
        //executa enquanto o programa rodar ou somente umaz, ou seja, enquanto existir registros a serem enviados
        do{
            //pega os que não foram enviados
            restr.clear();
            restr.put("enviado", BIProcedimentoRealizado.NAO_ENVIADO);
            this.enviar(restr);
            //agora pega aqueles que estão desatualizados
//            restr.clear();
//            restr.put("atualizado", BIProcedimentoRealizado.NAO_ATUALIZADO);
//            this.enviar(restr);
//            
            //vai esperar um pouco para começar a enviar novamente.
//            try {
//                //Thread.currentThread().s
//            } catch (InterruptedException ex) {
//                Logger.getLogger(EnvioProcedimentosRealizadosBackground.class.getName()).log(Level.SEVERE, null, ex);
//                
//            }
        }while(this.runInBackground);
        System.out.println("Encerrou a thread");
    }
    
    private void enviar(HashMap<String, Object> restr){
        //vai guardar a quantidade de registros
        int size=this.maxResult;
        List<BIProcedimentoRealizado> list=null;
        //início da página (paginação)
        int offset=0;
        //enquanto houver a lista retornada não for menor que a quantidade máxima, então não para.
        while(size>=this.maxResult){

            list=this.bIProcedimentoRealizadoController.findAllEqual(restr, offset, maxResult);

            if( list!=null){
                //incrementa as variáveis
                size=list.size();
                offset+=this.maxResult;
                SProcedimentoRealizado[] l=new SProcedimentoRealizado[size];
                //popula o vetor
                for(int i=0;i<size;i++){

                    l[i]=list.get(i).getProcedimentoRealizadoParaEnviar();
                }
                //limpa a lista
                list.clear();
                this.sProcedimentoRealizadoController.enviarSProcedimentoRealizado(l, this.sUsuarioDesktop);
            }else{
                //pare o laço
                break;
            }
        }
    }
}
