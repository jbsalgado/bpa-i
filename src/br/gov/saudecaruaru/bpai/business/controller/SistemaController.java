/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import br.gov.saudecaruaru.bpai.data.RecursoXML;
import br.gov.saudecaruaru.bpai.util.Recurso;
import com.sun.istack.internal.logging.Logger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;

/**
 *
 * @author Albuquerque
 */
public class SistemaController {

    private static SistemaController instance = new SistemaController();
    
    public static final Logger logger = Logger.getLogger(SistemaController.class);
    /*
     * Endereço do servidor onde os dados serão enviado e recuperados
     */
    public static String HOST_SERVIDOR = "http://localhost/sispad";
    /*
     * Direttório principal da aplicação
     */
    public static String DIRETORIO_PRINCIPAL = "C:/BPAI";
    /*
     * Diretório default do banco de dados
     */
    public static String DIRETORIO_DEFAULT_BANCO = DIRETORIO_PRINCIPAL + "/banco";
    /*
     * Diretório default dos arquivos de log
     */
    public static String DIRETORIO_DEFAULT_LOG = DIRETORIO_PRINCIPAL + "/log";

    public static SistemaController getnstance() {
        return instance;
    }

    private SistemaController() {
    }

    public static boolean testConnectionBPA(String pathBanco) {
        HibernateUtil.PATH_DATABASE_BPA = pathBanco;
        Session s = null;
        boolean sucess = false;
        try {
            s = HibernateUtil.getSession();
            Transaction t = s.beginTransaction();
            t.rollback();
            sucess = true;
        } catch (GenericJDBCException ex) {
            HibernateUtil.restartSessionFactory();
            sucess = false;
            //ex.printStackTrace();
            logger.severe("Erro ao tentar executar o método testConnectionBPA " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } finally {
            if (s != null) {
                if (s.isOpen()) {
                    s.close();
                }
            }
            return sucess;
        }
    }

    public static boolean testConnectionBPA() {
        return testConnectionBPA(HibernateUtil.PATH_DATABASE_BPA);
    }

    public static boolean testConnectionBPAI(String pathBanco) {
        HibernateUtil.PATH_DATABASE_BPA_I = pathBanco;
        Session s = HibernateUtil.getSessionBpaI();
        boolean sussess = false;
        try {
            Transaction t = s.beginTransaction();
            t.rollback();
            sussess = true;
        } catch (GenericJDBCException ex) {
            HibernateUtil.restartSessionFactoryBpaI();
            sussess = false;
            logger.severe("Erro ao tentar executar o método testConnectionBPAI " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } finally {
            if (s.isOpen()) {
                s.close();
            }
            return sussess;
        }
    }

    public static boolean testConnectionBPAI() {
        return testConnectionBPAI(HibernateUtil.PATH_DATABASE_BPA_I);
    }

    public static void createConfiguration() {
        Properties prop = new Properties();

        try {

            File f = new File(DIRETORIO_PRINCIPAL + "/configs.conf");

            // se nÃ£o existe o arquivo, cria, caso contrÃ¡rio carrega  
            if (!f.exists()) {

                prop.setProperty("bpa.database.path", HibernateUtil.PATH_DATABASE_BPA);
                prop.setProperty("bpai.database.path", HibernateUtil.PATH_DATABASE_BPA_I);
                FileOutputStream out = new FileOutputStream(f);
                prop.store(out,
                        "Esse arquivo nÃ£o deve ser modificado!");
                out.close();
                loadConfigurations();

            } else {

                loadConfigurations();

            }

        } catch (IOException exc) {
            logger.severe("Erro ao tentar executar o método createConfiguration " + exc.getMessage());
            logger.logException(exc, Level.SEVERE);
        }
    }

    public static void loadConfigurations() {
        Properties prop = new Properties();

        try {

            File f = new File(DIRETORIO_PRINCIPAL + "/configs.conf");
            FileInputStream in = new FileInputStream(f);
            prop.load(in);

            //configuraÃ§oes do banco
            HibernateUtil.PATH_DATABASE_BPA = prop.getProperty("bpa.database.path");
            HibernateUtil.PATH_DATABASE_BPA_I = prop.getProperty("bpai.database.path");

            //libera recursos
            in.close();
            //f.
        } catch (IOException exc) {
            logger.severe("Erro ao tentar executar o método loadConfigurations " + exc.getMessage());
            logger.logException(exc, Level.SEVERE);
        }
    }

    public static void updateConfigurations() {
        Properties prop = new Properties();

        try {

            File f = new File(DIRETORIO_PRINCIPAL + "/configs.conf");
            FileInputStream in = new FileInputStream(f);
            prop.load(in);
            //atualiza
            prop.setProperty("bpa.database.path", HibernateUtil.PATH_DATABASE_BPA);
            prop.setProperty("bpai.database.path", HibernateUtil.PATH_DATABASE_BPA_I);

            FileOutputStream out = new FileOutputStream(f);
            prop.store(out, null);
            in.close();
            out.close();
        } catch (IOException exc) {
            logger.severe("Erro ao tentar executar o método updateConfigurations " + exc.getMessage());
            logger.logException(exc, Level.SEVERE);
        }
    }

    public static String procedimentoExcessao(String codigoProcedimento) {
        Properties prop = new Properties();

        try {

            File f = new File("./excecao.conf");
            FileInputStream in = new FileInputStream(f);
            prop.load(in);
            //atualiza
            //prop.setProperty("bpa.database.path", HibernateUtil.PATH_DATABASE_BPA);  
            //prop.setProperty("bpai.database.path", HibernateUtil.PATH_DATABASE_BPA_I); 
            if (prop.containsKey(codigoProcedimento)) {
                in.close();
                return prop.getProperty(codigoProcedimento);
            }

            in.close();

        } catch (IOException exc) {
            logger.severe("Erro ao tentar executar o método procedimentoExcessao " + exc.getMessage());
            logger.logException(exc, Level.SEVERE);
            return "";
        }

        return "";
    }

    /**
     * Envia um arquivo XML com a produção dos dados
     *@param file arquivo XML
     * 
     */
    public void enviarProducaoParaServidor(File file) {
        try {
            URI url = new URI(HOST_SERVIDOR + "/index.php/bpa/procedimentorealizado/envio");
            //new URI
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url);;
            FileBody fileContent = new FileBody(file);
            //StringBody comment = new StringBody("Filename: " + fileName);
            MultipartEntity reqEntity = new MultipartEntity();
            reqEntity.addPart(file.getName(), fileContent);
            httppost.setEntity(reqEntity);
            HttpResponse response = httpclient.execute(httppost);
            if (response != null) {

                HttpEntity resEntity = response.getEntity();
                resEntity.writeTo(System.out);
            }
        } catch (URISyntaxException ex) {
            logger.severe("Erro ao tentar executar o método enviarProducaoParaServidor " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } catch (ConnectException ex) {
            logger.severe("Erro ao tentar executar o método enviarProducaoParaServidor " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } catch (IOException ex) {
            logger.severe("Erro ao tentar executar o método enviarProducaoParaServidor " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        }
    }

    /**
     * 
     * @param client instancia de Client do Jersey
     * @return List<Recurso> que devem ser atualizados
     */
    public List<Recurso> getRecursosASeremAtualizados(Client client) {
        List<Recurso> list = null;
        try {
            WebResource webResource = client.resource(HOST_SERVIDOR + "/index.php/sistema/BPAI");

            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            //verifica se a resposta está correta
            if (response.getStatus() == 200) {
                Recurso re = new Recurso();
                re.setExtensao("xml");
                re.setNomeLocal("/temp");
                if (this.criarArquivo(response.getEntityInputStream(), re)) {
                    RecursoXML xml = new RecursoXML();
                    list = xml.carregar(DIRETORIO_PRINCIPAL + "/temp.xml");
                }
            }
        } catch (ClientHandlerException ex) {
            logger.severe("Erro ao tentar executar o método getRecursosASeremAtualizados " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } catch (Exception ex) {
            logger.severe("Erro ao tentar executar o método getRecursosASeremAtualizados " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } finally {
            return list;
        }
    }

    /**
     * Baixa o banco de dados do servidor central
     * @param client Instancia de Cliente do Jersey
     * @return devolve true se conseguir baixar e criar o arquivo, caso contrário false
     */
    public boolean baixarBancoDeDados(Client client) {
        try {
            WebResource webResource = client.resource(HOST_SERVIDOR + "/index.php/sistema/BPAIBanco");
            //webResource.p
            ClientResponse response = webResource.accept("application/xml").get(ClientResponse.class);
            if (response.getStatus() == 200) {
                Recurso re = new Recurso();
                re.setExtensao("GDB");
                re.setNomeLocal(DIRETORIO_DEFAULT_BANCO + "/TESTANDO");
                return this.criarArquivo(response.getEntityInputStream(), re);
            }
            return false;
        } catch (ClientHandlerException ex) {
            logger.severe("Erro ao tentar executar o método baixarBancoDeDados " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
            return false;
        } catch (Exception ex) {
            logger.severe("Erro ao tentar executar o método baixarBancoDeDados " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
            return false;
        }
    }

    /**
     * 
     * @param client instãncia de Client do Jesery
     * @param recurso que deve ser atualizado
     * @return true se conseguir atualizar com sucesso, caso contrário false
     */
    public boolean atualizarRecurso(Client client, Recurso recurso) {
        try {
            //cambiarra!!!!!!!
            StringBuilder cambiarra = new StringBuilder(HOST_SERVIDOR);
            cambiarra.append("/index.php/sistema/BPAIUpdateResource");
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
            logger.severe("Erro ao tentar executar o método atualizarRecurso " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
            return false;
        }
        return false;
    }

    /**
     * 
     * @param input recurso em forma de bytes
     * @param recurso que deve ser atualizado
     * @return true caso o arquivo seja criado com sucesso, senão false
     */
    private boolean criarArquivo(InputStream input, Recurso recurso) {
        boolean sucess = false;
        try {

            // write the inputStream to a FileOutputStream
            File f = new File(DIRETORIO_PRINCIPAL + recurso.getNomeLocal() + "." + recurso.getExtensao());
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
            logger.severe("Erro ao tentar executar o método criarArquivo " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } catch (IOException ex) {
            logger.severe("Erro ao tentar executar o método criarArquivo " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } catch (Exception ex) {
            logger.severe("Erro ao tentar executar o método criarArquivo " + ex.getMessage());
            logger.logException(ex, Level.SEVERE);
        } finally {
            return sucess;
        }
    }
}
