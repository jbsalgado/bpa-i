/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.main;

import br.gov.saudecaruaru.bpai.business.service.ServicoControllerPortTypeProxy;
import br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop;
import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.EquipeController;
import br.gov.saudecaruaru.bpai.business.controller.SProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.SistemaController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.Equipe;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.data.BIProcedimentoRealizadoXML;
import br.gov.saudecaruaru.bpai.data.DiversasDAO;
import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import br.gov.saudecaruaru.bpai.data.ProcedimentoRealizadoDAO;
import br.gov.saudecaruaru.bpai.gui.ExportacaoCentralEnvio;
import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import br.gov.saudecaruaru.bpai.util.EnvioProcedimentosRealizadosBackground;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import org.apache.axis.attachments.OctetStream;
import org.apache.log4j.Logger;
/**
 *
 * @author Albuquerque
 */
public class Teste {
    public static void main(String[] args){
        SistemaController.loadConfigurations();
//        HibernateUtil.createIndices();
//        testeExportacaoProcedimentosIndividuais();
//        testeExportacaoProcedimentosCosolidados();
//        testeEquipes();
        //init();
        //testServico();
        //testInEnvioBackground();
        //testLogger();
        //testXML();
        testarRestFul();
    }
    
    public static void testeDiversasServicos(){
        DiversasDAO di= new DiversasDAO();
        ProcedimentoRealizado pro= new ProcedimentoRealizado(new ProcedimentoRealizadoPK());
        pro.getProcedimentoRealizadoPK().setCompetencia("201208");
        pro.setCodigoProcedimento("0102010420");
//        for(Diversas d: di.findAllServicos(pro)){
//            System.out.println(d.getDiversasPK().getCodigoItemTabela()+d.getDescricaoItemTabela());
//        }
    }
    public static void testeDiversasTabelaClassificacaoServico(){
        DiversasDAO di= new DiversasDAO();
        ProcedimentoRealizado pro= new ProcedimentoRealizado(new ProcedimentoRealizadoPK());
        pro.getProcedimentoRealizadoPK().setCompetencia("201208");
        pro.setCodigoProcedimento("0102010420");
//        for(Diversas d: di.findAllClassificacaoServico(pro)){
//            System.out.println(d.getDiversasPK().getCodigoItemTabela()+d.getDescricaoItemTabela());
//        }

        
    }
    
    public static void testeExportacaoProcedimentosIndividuais(){
        BIProcedimentoRealizadoController con= new BIProcedimentoRealizadoController();
        //con.findAllProcedimentosIndividuaisAndSave(null, new ProcedimentoRealizadoDAO(), 50);
    }
    
    public static void testeExportacaoProcedimentosCosolidados(){
        BIProcedimentoRealizadoController con= new BIProcedimentoRealizadoController();
        //con.findAllProcedimentosConsolidadosAndSave(null, new ProcedimentoRealizadoDAO(), 50);
    }
    
    public static void testeEquipes(){
        EquipeController equipe= new EquipeController();
        for(Equipe e: equipe.findAll()){
            System.out.println(e);
        }
    }
    
    public static void init(){
        HibernateUtil.createIndices();
    }
   
    public static void testServico(){
        ServicoControllerPortTypeProxy serv= new  ServicoControllerPortTypeProxy();
        BIProcedimentoRealizadoController control= new BIProcedimentoRealizadoController();
        SProcedimentoRealizadoController con= new SProcedimentoRealizadoController();
        
        SUsuarioDesktop desk=new SUsuarioDesktop();
        desk.setSerial_aplicacao("324324324");
        desk.setServidor_cpf("00000000098");
        desk.setToken("324324");
        desk.setUsuario_sistema("cesar");
        
       List<BIProcedimentoRealizado> list = list=control.findAll();
       
       List<SProcedimentoRealizado> lproc= new ArrayList<SProcedimentoRealizado>();
       for(int i=0;i<list.size();i++){
           ProcedimentoRealizado pro=new ProcedimentoRealizado(list.get(i));
           pro.preencherAtributosVazios();
           pro.setCompetenciaMovimento("201206");
            br.gov.saudecaruaru.bpai.business.service.SProcedimentoRealizado p=pro.getProcedimentoRealizadoParaEnviar();
          lproc.add(p);
       }
       
       con.enviarSProcedimentoRealizado(lproc, desk);
    }
    
    public static void testInEnvioBackground(){
        SUsuarioDesktop desk=new SUsuarioDesktop();
        desk.setSerial_aplicacao("324324324");
        desk.setServidor_cpf("00000000098");
        desk.setToken("324324");
        desk.setUsuario_sistema("cesar");
     
        IExportacaoStrategy ex= new ExportacaoCentralEnvio(desk, "");
        //System.out.println(ex.execute());
    }
    
    public static void testXML(){
        
        BIProcedimentoRealizadoXML xml= new BIProcedimentoRealizadoXML();
        
        BIProcedimentoRealizadoController control= new BIProcedimentoRealizadoController();
       xml.salvar(control.findAll(),"test.xml");
        for(BIProcedimentoRealizado p: xml.carregar("test.xml")){
            System.out.println(p);
        }
    }
    
    public static void testLogger(){
        Logger lo=Logger.getLogger(Teste.class);
        lo.info("mensagem de teste pow!");
    }
    
    public static void testarRestFul(){
        Client client=Client.create();
        WebResource webResource = client.resource("http://localhost:8080/sispadreport/hello");
        ClientResponse response = webResource.accept("application/pdf")
                   .get(ClientResponse.class);
        if (response.getStatus() != 200) {
		   throw new RuntimeException("Failed : HTTP error code : "
			+ response.getStatus());
		}
        else{
            
            try {
                InputStream ob= response.getEntityInputStream();

                // write the inputStream to a FileOutputStream
                OutputStream out;
                        out = new FileOutputStream(new File("D:\\newfile.pdf"));

                int read = 0;
                byte[] bytes = new byte[1024];
                    while ((read = ob.read(bytes)) != -1) {
                            out.write(bytes, 0, read);
                    }
                

                ob.close();
                out.flush();
                out.close();
        
            } catch (FileNotFoundException ex) {
                java.util.logging.Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
            }
             catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
                }
            //System.out.println(ob);
        }
    }
}
