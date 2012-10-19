/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.SProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Albuquerque
 */
public abstract class ExportacaoCentral {
    
    private BIProcedimentoRealizadoController bIProcedimentoRealizadoController= new BIProcedimentoRealizadoController();
    private SProcedimentoRealizadoController sProcedimentoRealizadoController= new SProcedimentoRealizadoController();
    private int maxResult=50;
    private SUsuarioDesktop sUsuarioDesktop;
    
    
    public ExportacaoCentral(SUsuarioDesktop sUsuarioDesktop ){
        this.sUsuarioDesktop = sUsuarioDesktop;
    }

    public ExportacaoCentral(SUsuarioDesktop sUsuarioDesktop, int maxResult) {
        this.sUsuarioDesktop = sUsuarioDesktop;
        this.maxResult=maxResult;
    }
    
    
    
    protected List<Thread> enviar(HashMap<String, Object> restr){
        List<Thread> threads= new ArrayList<Thread>();
         //vai guardar a quantidade de registros
        int size=this.maxResult;
        List<BIProcedimentoRealizado> list=null;
        //início da página (paginação)
        int offset=0;
        //enquanto houver a lista retornada não for menor que a quantidade máxima, então não para.
        while(size==this.maxResult){

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
                threads.add( this.sProcedimentoRealizadoController.enviarSProcedimentoRealizado(l, this.sUsuarioDesktop));
            }else{
                //pare o laço
                break;
            }
        }
        return threads;
    }
    
    protected List<Thread> atualizar(HashMap<String, Object> restr){
        List<Thread> threads= new ArrayList<Thread>();
         //vai guardar a quantidade de registros
        int size=this.maxResult;
        List<BIProcedimentoRealizado> list=null;
        //início da página (paginação)
        int offset=0;
        //enquanto houver a lista retornada não for menor que a quantidade máxima, então não para.
        while(size==this.maxResult){

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
                threads.add( this.sProcedimentoRealizadoController.atualizarSProcedimentoRealizado(l, this.sUsuarioDesktop));
            }else{
                //pare o laço
                break;
            }
        }
        return threads;
    }

    public BIProcedimentoRealizadoController getbIProcedimentoRealizadoController() {
        return bIProcedimentoRealizadoController;
    }

    public void setbIProcedimentoRealizadoController(BIProcedimentoRealizadoController bIProcedimentoRealizadoController) {
        this.bIProcedimentoRealizadoController = bIProcedimentoRealizadoController;
    }

    public int getMaxResult() {
        return maxResult;
    }

    public void setMaxResult(int maxResult) {
        this.maxResult = maxResult;
    }

    public SProcedimentoRealizadoController getsProcedimentoRealizadoController() {
        return sProcedimentoRealizadoController;
    }

    public void setsProcedimentoRealizadoController(SProcedimentoRealizadoController sProcedimentoRealizadoController) {
        this.sProcedimentoRealizadoController = sProcedimentoRealizadoController;
    }

    public SUsuarioDesktop getsUsuarioDesktop() {
        return sUsuarioDesktop;
    }

    public void setsUsuarioDesktop(SUsuarioDesktop sUsuarioDesktop) {
        this.sUsuarioDesktop = sUsuarioDesktop;
    }
    
    
}
