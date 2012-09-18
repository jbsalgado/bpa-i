/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Transient;

/**
 *
 * @author Albuquerque
 */
public class BaseProcedimentoRealizado {
    private static final long serialVersionUID = 1L;
    
    public static final String ORIGEM_CONSOLIDADO="BPA";
    public static final String ORIGEM_INDIVIDUALIZADO="BPI";
    public static final int MAXIMA_QUANTIDADE_FOLHA=900;
    public static final int MAXIMA_QUANTIDADE_SEQUENCIA=20;
    
    @EmbeddedId
    private ProcedimentoRealizadoPK procedimentoRealizadoPK; 
    
    
    @Column(name = "PRD_PA")
    private String codigoProcedimento;
    
    @Column(name = "PRD_DTATEN")
    private String dataAtendimento;
    
    @Column(name = "PRD_CNSPAC")
    private String cnsPaciente;
    
    @Column(name = "PRD_NMPAC")
    private String nomePaciente;
    
    @Column(name = "PRD_DTNASC")
    private String dataNascimentoPaciente;
    
    @Column(name = "PRD_SEXO")
    private String sexoPaciente;
    
    
    @Column(name = "PRD_IBGE")
    private String codigoIBGECidadePaciente;
    
    @Column(name = "PRD_CID")
    private String cidDoencaprocedimento;
    
    @Column(name = "PRD_IDADE")
    private String idadePaciente;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Basic(optional = false)
    @Column(name = "PRD_QT_P")
    private Double quantidadeRealizada;
    
    @Column(name = "PRD_CATEN")
    private String caracterizacaoAtendimento;
    
    @Column(name = "PRD_NAUT")
    private String numeroAutorizacao;
    
    @Column(name = "PRD_ORG")
    private String origemProcedimento;
    
    @Column(name = "PRD_MVM")
    private String prdMvm;
    
    @Column(name = "PRD_FLPA")
    private String prdFlpa;
    @Column(name = "PRD_FLCBO")
    private String prdFlcbo;
    @Column(name = "PRD_FLCA")
    private String prdFlca;
    @Column(name = "PRD_FLIDA")
    private String prdFlida;
    @Column(name = "PRD_FLQT")
    private String prdFlqt;
    @Column(name = "PRD_FLER")
    private String prdFler;
    @Column(name = "PRD_FLMUN")
    private String prdFlmun;
    @Column(name = "PRD_FLCID")
    private String prdFlcid;
    
    
    @Column(name = "PRD_RACA")
    private String racaPaciente;
    
    @Column(name = "PRD_ETNIA")
    private String etniaPaciente;
    
    @Column(name = "PRD_NAC")
    private String nacionalidadePaciente;
    
    @Column(name = "PRD_ADVQT")
    private String prdAdvqt;

    @Transient
    private String nomeProfissional;
}
