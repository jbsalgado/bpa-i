/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.BIPaciente;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author juniorpires
 */
public class BIPacienteDAO extends GenericDAO<BIPaciente> {
    @Override
    public Session getSession() {
        return HibernateUtil.getSessionBpaI();
    }
}
