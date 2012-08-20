/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Albuquerque
 */

@Entity
@Table(name = "S_PRD")
public class BIProcedimentoRealizado implements Serializable{
    
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private ProcedimentoRealizadoPK procedimentoRealizadoPK;
    
    @Column(name = "PRD_CNSPAC")
    private String cnsPaciente;
    
    @Basic(optional = false)
    @Column(name = "PRD_NMPAC")
    private String nomePaciente;
    
    @Basic(optional = false)
    @Column(name = "PRD_DTNASC")
    private String dataNascimentoPaciente;
    
    @Basic(optional = false)
    @Column(name = "PRD_SEXO")
    private String sexoPaciente;
    
    
    @Basic(optional = false)
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
    
    
    @Basic(optional = false)
    @Column(name = "PRD_CATEN")
    private String caracterizacaoAtendimento;
    
    @Column(name = "PRD_NAUT")
    private String numeroAutorizacao;
    
    @Column(name = "PRD_ORG")
    private String prdOrg;
    
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
    
    
    @Basic(optional = false)
    @Column(name = "PRD_RACA")
    private String racaPaciente;
    
    @Column(name = "PRD_ETNIA")
    private String etniaPaciente;
    
    
    @Basic(optional = false)
    @Column(name = "PRD_NAC")
    private String nacionalidadePaciente;
    
    @Column(name = "PRD_ADVQT")
    private String prdAdvqt;
    
}
