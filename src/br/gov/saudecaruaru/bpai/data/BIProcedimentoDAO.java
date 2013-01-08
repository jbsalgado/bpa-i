/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.BIProcedimento;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author Albuquerque
 */
public class BIProcedimentoDAO extends GenericDAO<BIProcedimento> {
    
    @Override
    public Session getSession() {
        return HibernateUtil.getSessionBpaI();
    }
}
