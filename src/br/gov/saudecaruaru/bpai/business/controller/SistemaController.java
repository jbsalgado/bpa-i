/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.controller;

import br.gov.saudecaruaru.bpai.business.service.SMessageWebService;
import br.gov.saudecaruaru.bpai.data.HibernateUtil;
import br.gov.saudecaruaru.bpai.data.RecursoXML;
import br.gov.saudecaruaru.bpai.util.Recurso;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.ConnectException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.FormBodyPart;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;

/**
 *
 * @author Albuquerque
 */
public class SistemaController {

    private static SistemaController instance = new SistemaController();
    private static String APPLICATION_JSON = "application/json";
    private static HttpClient client = new DefaultHttpClient();
    public static final String PASSWORD = "1234";
    public static final String USER = "CESAR";
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
            logger.error("Erro ao tentar executar o método testConnectionBPA " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
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
            logger.error("Erro ao tentar executar o método testConnectionBPAI " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
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
                        "Esse arquivo não deve ser modificado!");
                out.close();
                loadConfigurations();

            } else {

                loadConfigurations();

            }

        } catch (IOException exc) {
            logger.error("Erro ao tentar executar o método createConfiguration " + exc.getMessage());
            // logger.logException(exc, Level.SEVERE);
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
            logger.error("Erro ao tentar executar o método loadConfigurations " + exc.getMessage());
            //logger.logException(exc, Level.SEVERE);
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
            logger.error("Erro ao tentar executar o método updateConfigurations " + exc.getMessage());
            // logger.logException(exc, Level.SEVERE);
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
            logger.error("Erro ao tentar executar o método procedimentoExcessao " + exc.getMessage());
            //logger.logException(exc, Level.SEVERE);
            return "";
        }

        return "";
    }

    /**
     * Envia um arquivo XML com a produção dos dados
     * @param file arquivo XML
     * @param competenciaMovimento a competência
     * @param unidadeCnes cnes da unidade
     * @param token token para validar os dados
     * @return SMessageWebService[] com as mensagens recebidas do servidor
     */
    public SMessageWebService[] enviarProducaoParaServidor(File file, String competenciaMovimento, String unidadeCnes,String token) {
        SMessageWebService[] msg = null;
        SMessageWebService m = null;
        HttpPost httppost = new HttpPost();
        try {
            URI uri = new URI(HOST_SERVIDOR + "/index.php/bpa/procedimentoRealizado/envio");
            httppost.setURI(uri);
            FileBody fileContent = new FileBody(file);
            //StringBody comment = new StringBody("Filename: " + fileName);
            MultipartEntity reqEntity = new MultipartEntity();
            //seta os parametros
            FormBodyPart form = new FormBodyPart("competencia", new StringBody(competenciaMovimento));
            reqEntity.addPart(form);
            form = new FormBodyPart("unidade", new StringBody(unidadeCnes));
            reqEntity.addPart(form);
            form = new FormBodyPart("usuario", new StringBody(USER));
            reqEntity.addPart(form);
            form = new FormBodyPart("senha", new StringBody(PASSWORD));
            reqEntity.addPart(form);
            form = new FormBodyPart("token", new StringBody(token));
            reqEntity.addPart(form);
            //fim dos parâmetros
            reqEntity.addPart(file.getName(), fileContent);
            httppost.setEntity(reqEntity);
            //httppost.se
            HttpResponse response = client.execute(httppost);

            //verifica se a resposta não é nulla
            if (response != null) {
                //verifica se o servidor mandou uma respsota (200)
                //if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    HttpEntity resEntity = response.getEntity();
                    BufferedReader r = new BufferedReader(new InputStreamReader(resEntity.getContent()));
                    StringBuilder builder = new StringBuilder();
                    while (r.ready()) {
                        builder.append(r.readLine());
                    }
                    r.close();
                    String s=builder.toString();
                    //verifica se o content-type é application/json
                    if (resEntity.getContentType().getValue().equals(APPLICATION_JSON)) {
                        //pega os dados recebido em json e deserializa
                        Gson parser = new GsonBuilder().create();
                        msg = parser.fromJson(s, SMessageWebService[].class);
                    } else {
                         m = new SMessageWebService("BPADADOS11", "O programa não pode ler os dados recebidos do servidor. Informe o erro aos desenvolvedores do sistema.", "0");
                        logger.error(" falha ao executar o método enviarProducaoParaServidor. Resposta recebida: " + s);
                    }
//                }//código http da resposta é diferente de 200
//                else {
//                     m = new SMessageWebService("BPARESPOSTA12", "Ops! O Programa recebeu uma resposta diferente do que esperava. Informe o erro aos desenvolvedores do sistema.", "0");
//                     logger.error(" falha ao executar o método enviarProducaoParaServidor. CÓDIDO DA RESPSOTA: " + response.getStatusLine());
//                }
            } //response é nulla
            else {
                 m = new SMessageWebService("BPARESPONSE13", "Ops! O Programa não recebeu nenhuma resposta do servidor. Informe o erro aos desenvolvedores do sistema.", "0");
            }
        } catch (URISyntaxException ex) {
            logger.error("Erro ao tentar executar o método enviarProducaoParaServidor " + ex.getMessage());
            m = new SMessageWebService("BPAIURI01", "A URI comtém erros. Informe o erro aos desenvolvedores do sistema.", "0");
            //logger.logException(ex, Level.SEVERE);
        } catch (ConnectException ex) {
            logger.error("Erro ao tentar executar o método enviarProducaoParaServidor " + ex.getMessage());
            m = new SMessageWebService("BPAICONEXAO02", "Não foi possível estabelecer conexão com o servidor. Informe o erro aos desenvolvedores do sistema.", "0");
            //logger.logException(ex, Level.SEVERE);
        } catch (IOException ex) {
            logger.error("Erro ao tentar executar o método enviarProducaoParaServidor " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
            m = new SMessageWebService("BPAIARQUIVO03", "Problemas na geração do arquivo de exportação. Informe o erro aos desenvolvedores do sistema.", "0");
        } finally {
            httppost.releaseConnection();
            if (msg == null && m != null) {
                msg = new SMessageWebService[1];
                msg[0] = m;
            }
            return msg;
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
            logger.error("Erro ao tentar executar o método getRecursosASeremAtualizados " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
        } catch (Exception ex) {
            logger.error("Erro ao tentar executar o método getRecursosASeremAtualizados " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
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
                re.setNomeLocal("/banco/TESTANDO");
                return this.criarArquivo(response.getEntityInputStream(), re);
            }
            return false;
        } catch (ClientHandlerException ex) {
            logger.error("Erro ao tentar executar o método baixarBancoDeDados " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
            return false;
        } catch (Exception ex) {
            logger.error("Erro ao tentar executar o método baixarBancoDeDados " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
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
            logger.error("Erro ao tentar executar o método atualizarRecurso " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
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
            logger.error("Erro ao tentar executar o método criarArquivo " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
        } catch (IOException ex) {
            logger.error("Erro ao tentar executar o método criarArquivo " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
        } catch (Exception ex) {
            logger.error("Erro ao tentar executar o método criarArquivo " + ex.getMessage());
            //logger.logException(ex, Level.SEVERE);
        } finally {
            return sucess;
        }
    }
}
