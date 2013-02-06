/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.model.Paciente;
import br.gov.saudecaruaru.bpai.data.PacienteDAO;
import br.gov.saudecaruaru.bpai.gui.verifiers.CnsVerifier;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 *
 * @author Albuquerque
 */
public class PacienteController extends BasecController<Paciente> {

    private static HttpClient CLIENT = new DefaultHttpClient();
    private static String URL = SistemaController.HOST_SERVIDOR + "/index.php/bpa/paciente/consulta";
    private Gson gson= new GsonBuilder().create();

    public PacienteController() {
        super(new PacienteDAO());
    }

    /**
     * 
     * @param cns válido
     * @return Paciente com os dados atualizados da web
     */
    public Paciente findInWebService(String cns) {
        boolean valido=false;
        if (cns.startsWith("1") || cns.startsWith("2")){
            valido=CnsVerifier.validaCns(cns);
        }
        else{
            valido=CnsVerifier.validaCnsProv(cns);
        }
        if (valido) {
            String json=this.getClientWebService(cns);
            if (json != null){
            Paciente pac=this.gson.fromJson(json, Paciente.class);
            return pac;
                    }
        }
        throw new IllegalArgumentException("CNS não é válido");
    }

    /**
     * 
     * @param cns válido
     * @return String que representa os dados em JSON de um paciente
     */
    private String getClientWebService(String cns) {
        URIBuilder builder;
        String res=null;
        HttpGet method = new HttpGet();
        try {
            builder = new URIBuilder(URL);

            builder.addParameter("cns", cns);
            method.setURI(builder.build());
            HttpResponse response = CLIENT.execute(method);
            if (response!=  null){
                if (response.getStatusLine().getStatusCode() == 200){
                    HttpEntity entity = response.getEntity();
                    if (entity.getContentType().getValue().equals("application/json")){
                         ByteArrayOutputStream out=new ByteArrayOutputStream();
                         entity.writeTo(out);
                         res=out.toString("UTF-8");
                    }
                }
            }

        } catch (URISyntaxException ex) {
            
        }  catch (ClientProtocolException ex) {
            
        }catch (IOException ex) {
            
        }
        finally{
            method.releaseConnection();
            return res;
        }
        //method.
    }
}
