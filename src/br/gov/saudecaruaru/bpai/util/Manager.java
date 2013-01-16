/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.util;

import br.gov.saudecaruaru.bpai.data.RecursoXML;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.org.apache.xml.internal.security.Init;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Albuquerque
 */
public class Manager {

    private static String host = "http://www.saudecaruaru.pe.gov.br";

    public List<Recurso> getRecursosASeremAtualizados(Client client) {
        try {
            WebResource webResource = client.resource(host + "/sispad/index.php/sistema/BPAI");
            
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            } else {
                Recurso re = new Recurso();
                re.setExtensao("xml");
                re.setNomeLocal("/temp");
                if (this.criarArquivo(response.getEntityInputStream(), re)) {
                    RecursoXML xml = new RecursoXML();
                    return xml.carregar("C:/BPAI/temp.xml");
                }
                return null;
            }
        } catch (ClientHandlerException ex){
            ex.printStackTrace();
            return null;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean baixarBancoDeDados(Client client) {
        try {
            WebResource webResource = client.resource(host + "/sispad/index.php/sistema/BPAIBanco");
            //webResource.p
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() == 200) {
                Recurso re = new Recurso();
                re.setExtensao("GDB");
                re.setNomeLocal("/banco/TESTANDO");
                return this.criarArquivo(response.getEntityInputStream(), re);
            }
            return false;
        }  catch (ClientHandlerException ex){
            ex.printStackTrace();
            return false;
        }catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean atualizarRecurso(Client client, Recurso recurso) {
        try {
            //cambiarra!!!!!!!
            StringBuilder cambiarra = new StringBuilder(host);
            cambiarra.append("/sispad/index.php/sistema/BPAIUpdateResource");
            cambiarra.append("?f=");
            cambiarra.append(recurso.getNomeRemoto());
            cambiarra.append("&e=");
            cambiarra.append(recurso.getExtensao());
            WebResource webResource = client.resource(cambiarra.toString());
            //fim da cambiarra
            //não está funcionando!!!!!!!!!!!!!!
            //MultivaluedMap<String, String> params=new MultivaluedMapImpl();
            //params.add("f", recurso.getNomeRemoto());
            //params.add("e", recurso.getExtensao());
            //webResource.queryParam();
            //webResource.queryParams(params);
            webResource.accept("application/" + recurso.getExtensao());
            //for(String s:webResource.)
            ClientResponse response = webResource.get(ClientResponse.class);
            if (response.getStatus() == 200) {
                return this.criarArquivo(response.getEntityInputStream(), recurso);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    /*
     * Cria um arquivo
     */

    private boolean criarArquivo(InputStream input, Recurso recurso) {
        boolean sucess = false;
        try {

            // write the inputStream to a FileOutputStream
            File f = new File("C:/BPAI" + recurso.getNomeLocal() + "." + recurso.getExtensao());
            OutputStream out;
            out = new FileOutputStream(f);

            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = input.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }


            input.close();
            out.flush();
            out.close();
            sucess = true;
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            return sucess;
        }
    }
}
