/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.bussines.hibernatevalidator;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Junior Pires
 */
public class Cliente {
   
    
    @Cep(min=idade)
    private String cep;
    
    private static final int idade=30;

    public Cliente(String cep) {
        this.cep = cep;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }
    
    
}
