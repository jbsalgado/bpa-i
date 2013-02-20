/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.BIOcupacao;
import org.hibernate.Session;

/**
 *
 * @author juniorpires
 */
public class BIOcupacaoDAO extends GenericDAO<BIOcupacao> {
    @Override
    public Session getSession() {
        return HibernateUtil.getSessionBpaI();
    }
}
