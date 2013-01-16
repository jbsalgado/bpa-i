package br.gov.saudecaruaru.bpai.util;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Albuquerque
 */
@XStreamAlias("recurso")
public class Recurso implements Serializable{
    
    private String nomeLocal;
    private String nomeRemoto;
    private String mensagem;
    private String extensao;
    private boolean seNaoExistir;
    public Recurso() {
    }

    public Recurso(String nomeLocal, String nomeRemoto, String mensagem) {
        this.nomeLocal = nomeLocal;
        this.nomeRemoto = nomeRemoto;
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getNomeRemoto() {
        return nomeRemoto;
    }

    public void setNomeRemoto(String nomeRemoto) {
        this.nomeRemoto = nomeRemoto;
    }

    public String getExtensao() {
        return extensao;
    }

    public void setExtensao(String extensao) {
        this.extensao = extensao;
    }
}
