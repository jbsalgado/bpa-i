/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.BICnesMicroarea;
import org.hibernate.Session;

/**
 *
 * @author juniorpires
 */
public class BICnesMicroareaDAO extends GenericDAO<BICnesMicroarea> {
    @Override
    public Session getSession() {
        return HibernateUtil.getSessionBpaI();
    }
}
