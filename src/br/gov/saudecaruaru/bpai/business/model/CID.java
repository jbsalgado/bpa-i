/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Junior Pires
 */
@Entity
@Table(name = "S_CID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SCid.findAll", query = "SELECT s FROM SCid s"),
    @NamedQuery(name = "SCid.findByCdCod", query = "SELECT s FROM SCid s WHERE s.cdCod = :cdCod"),
    @NamedQuery(name = "SCid.findByOpc", query = "SELECT s FROM SCid s WHERE s.opc = :opc"),
    @NamedQuery(name = "SCid.findByCat", query = "SELECT s FROM SCid s WHERE s.cat = :cat"),
    @NamedQuery(name = "SCid.findBySubcat", query = "SELECT s FROM SCid s WHERE s.subcat = :subcat"),
    @NamedQuery(name = "SCid.findByCdDescr", query = "SELECT s FROM SCid s WHERE s.cdDescr = :cdDescr"),
    @NamedQuery(name = "SCid.findByRestrsexo", query = "SELECT s FROM SCid s WHERE s.restrsexo = :restrsexo"),
    @NamedQuery(name = "SCid.findByCamposRad", query = "SELECT s FROM SCid s WHERE s.camposRad = :camposRad"),
    @NamedQuery(name = "SCid.findByEstadio", query = "SELECT s FROM SCid s WHERE s.estadio = :estadio"),
    @NamedQuery(name = "SCid.findByRepeteRad", query = "SELECT s FROM SCid s WHERE s.repeteRad = :repeteRad"),
    @NamedQuery(name = "SCid.findByAux", query = "SELECT s FROM SCid s WHERE s.aux = :aux")})
public class CID implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CD_COD")
    private String cdCod;
    @Column(name = "OPC")
    private Character opc;
    @Column(name = "CAT")
    private Character cat;
    @Column(name = "SUBCAT")
    private Character subcat;
    @Column(name = "CD_DESCR")
    private String cdDescr;
    @Column(name = "RESTRSEXO")
    private Character restrsexo;
    @Column(name = "CAMPOS_RAD")
    private String camposRad;
    @Column(name = "ESTADIO")
    private Character estadio;
    @Column(name = "REPETE_RAD")
    private Character repeteRad;
    @Column(name = "AUX")
    private Character aux;

    public CID() {
    }

    public CID(String cdCod) {
        this.cdCod = cdCod;
    }

    public String getCdCod() {
        return cdCod;
    }

    public void setCdCod(String cdCod) {
        this.cdCod = cdCod;
    }

    public Character getOpc() {
        return opc;
    }

    public void setOpc(Character opc) {
        this.opc = opc;
    }

    public Character getCat() {
        return cat;
    }

    public void setCat(Character cat) {
        this.cat = cat;
    }

    public Character getSubcat() {
        return subcat;
    }

    public void setSubcat(Character subcat) {
        this.subcat = subcat;
    }

    public String getCdDescr() {
        return cdDescr;
    }

    public void setCdDescr(String cdDescr) {
        this.cdDescr = cdDescr;
    }

    public Character getRestrsexo() {
        return restrsexo;
    }

    public void setRestrsexo(Character restrsexo) {
        this.restrsexo = restrsexo;
    }

    public String getCamposRad() {
        return camposRad;
    }

    public void setCamposRad(String camposRad) {
        this.camposRad = camposRad;
    }

    public Character getEstadio() {
        return estadio;
    }

    public void setEstadio(Character estadio) {
        this.estadio = estadio;
    }

    public Character getRepeteRad() {
        return repeteRad;
    }

    public void setRepeteRad(Character repeteRad) {
        this.repeteRad = repeteRad;
    }

    public Character getAux() {
        return aux;
    }

    public void setAux(Character aux) {
        this.aux = aux;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCod != null ? cdCod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CID)) {
            return false;
        }
        CID other = (CID) object;
        if ((this.cdCod == null && other.cdCod != null) || (this.cdCod != null && !this.cdCod.equals(other.cdCod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.gov.saudecaruaru.bpai.business.model.SCid[ cdCod=" + cdCod + " ]";
    }
    
}
