/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.priuli.filter.Filter;

/**
 *
 * @author Albuquerque
 */
public class ProcedimentoDAO extends GenericDAO<Procedimento> implements BasicDAO<Procedimento> {

    @Override
    public void salve(Procedimento object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Procedimento encontre(Procedimento object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualize(Procedimento object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Procedimento> encontreTodos() {
        try {
            return super.findAll();
        } catch (Exception ex) {
            Logger.getLogger(ProcedimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Procedimento>();
        }
    }

    @Override
    public List<Procedimento> encontreTodos(Filter filter) {
        try {
            return super.findAll(filter);
        } catch (Exception ex) {
            Logger.getLogger(ProcedimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Procedimento>();
        }
    }

    @Override
    public Procedimento encontre(Filter filter) {
        try {
            return super.find(filter);
        } catch (Exception ex) {
            Logger.getLogger(ProcedimentoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public void exclua(Procedimento object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
