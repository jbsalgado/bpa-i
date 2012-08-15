/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

/**
 *
 * @author Junior Pires
 */
public enum CaraterAtendimento {
    SEM_INFORMACAO("- SEM INFORMAÇÃO"),
    ELETIVO("1 - ELETIVO"),
    URGENCIA("2 - URGÊNCIA"),
    ACIDENTE_LOCAL("3 - ACIDENTE NO LOCAL DO TRABALHO OU A SERVICO DA EMPRESA"),
    ACIDENTE_EXTERNO("4 - ACIDENTE NO TRAJETO PARA O TRABALHO"),
    ACIDENTE_OUTROS("5 - OUTROS TIPOS DE ACIDENTES DE TRÃNSITO"),
    LESOES_OUTRAS("6 - OUTROS TIPOS DE LESÕES E EVEN. POR AGENTES QUÍMICOS OU FÍSICOS");

    private final String desc;
    
    private CaraterAtendimento(String desc) {
        this.desc = desc;
    }
    
    public String desc(){
        return this.desc;
    }
    
}
