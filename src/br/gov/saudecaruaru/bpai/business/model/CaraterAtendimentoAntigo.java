/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

/**
 *
 * @author Junior Pires
 */
public enum CaraterAtendimentoAntigo {
    SEM_INFORMACAO("- SEM INFORMAÇÃO","  "),
    ELETIVO("1 - ELETIVO","01"),
    URGENCIA("2 - URGÊNCIA","02"),
    ACIDENTE_LOCAL("3 - ACIDENTE NO LOCAL DO TRABALHO OU A SERVICO DA EMPRESA","03"),
    ACIDENTE_EXTERNO("4 - ACIDENTE NO TRAJETO PARA O TRABALHO","04"),
    ACIDENTE_OUTROS("5 - OUTROS TIPOS DE ACIDENTES DE TRÃNSITO","05"),
    LESOES_OUTRAS("6 - OUTROS TIPOS DE LESÕES E EVEN. POR AGENTES QUÍMICOS OU FÍSICOS","06");

    private final String desc;
    private final String cod;
    
    private CaraterAtendimentoAntigo(String desc,String cod) {
        this.desc = desc;
        this.cod = cod;
    }
    
    public String desc(){
        return this.desc;
    }
    public String cod(){
        return cod;
    }

    @Override
    public String toString() {
        return this.desc;
    }
    
    
    
    
}
