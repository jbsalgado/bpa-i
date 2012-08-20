/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Albuquerque
 */

@Embeddable
public class BIProcedimentoRealizadoPK {
    
    @Basic(optional = false)
    @Column(name = "PRD_UID")
    private String cnesUnidade;
    
    @Basic(optional = false)
    @Column(name = "PRD_CMP")
    private String competencia;
    
    @Basic(optional = false)
    @Column(name = "PRD_CNSMED")
    private String cnsMedico;
    
    @Column(name = "PRD_CBO")
    private String cboMedico;
    
    @Basic(optional = false)
    @Column(name = "PRD_FLH")
    private String numeroFolha;
    
    @Basic(optional = false)
    @Column(name = "PRD_SEQ")
    private String sequenciaFolha;
    
    @Basic(optional = false)
    @Column(name = "PRD_PA")
    private String codigoProcedimento;
    
    
    @Basic(optional = false)
    @Column(name = "PRD_DTATEN")
    private String dataAtendimento;
    
}
