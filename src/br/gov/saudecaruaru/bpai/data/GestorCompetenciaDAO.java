/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.GestorCompetencia;
import java.io.Serializable;
import org.hibernate.Session;

/**
 *
 * @author Albuquerque
 */
public class GestorCompetenciaDAO extends GenericDAO<GestorCompetencia> {
     @Override
    public Session getSession() {
        return HibernateUtil.getSessionBpaI();
    }
}
