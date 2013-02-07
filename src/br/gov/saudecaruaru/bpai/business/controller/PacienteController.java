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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Albuquerque
 */
public class PacienteController extends BasecController<Paciente> {

    private static HttpClient CLIENT = new DefaultHttpClient();
    private static String URL = SistemaController.HOST_SERVIDOR + "/index.php/bpa/paciente/consulta";
    private Gson gson = new GsonBuilder().create();

    public PacienteController() {
        super(new PacienteDAO());
    }

    /**
     * 
     * @param cns válido
     * @return Paciente com os dados atualizados da web
     */
    public Paciente findInWebService(String cns) {
        boolean valido = true;
//        if (cns.startsWith("1") || cns.startsWith("2")) {
//            valido = CnsVerifier.validaCns(cns);
//        } else {
//            valido = CnsVerifier.validaCnsProv(cns);
//        }
        if (valido) {
            String json = this.getClientWebService(cns);
            if (json != null) {
                Paciente pac = this.gson.fromJson(json, Paciente.class);
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
        String res = null;
        HttpPost method = new HttpPost();
        try {
            List<NameValuePair> formparams = new ArrayList<NameValuePair>();
            formparams.add(new BasicNameValuePair("senha", SistemaController.PASSWORD));
            formparams.add(new BasicNameValuePair("usuario", SistemaController.USER));
            formparams.add(new BasicNameValuePair("cns", cns));
            UrlEncodedFormEntity form = new UrlEncodedFormEntity(formparams, "UTF-8");
            builder = new URIBuilder(URL);
            builder.addParameter("cns", cns);
            method.setURI(builder.build());
            method.setEntity(form);
            HttpResponse response = CLIENT.execute(method);
            if (response != null) {
                if (response.getStatusLine().getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    if (entity.getContentType().getValue().equals("application/json")) {
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        entity.writeTo(out);
                        res = out.toString("UTF-8");
                        out.close();
                    }
                    
                }
            }

        } catch (URISyntaxException ex) {
        } catch (ClientProtocolException ex) {
        } catch (IOException ex) {
        } finally {
            method.releaseConnection();
            return res;
        }
        //method.
    }
}
