/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Diversas;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.priuli.filter.Filter;

/**
 *
 * @author Junior Pires
 */
public class DiversasDAO extends GenericDAO<Diversas> implements BasicDAO<Diversas> {

    @Override
    public void salve(Diversas object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Diversas encontre(Diversas object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualize(Diversas object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exclua(Diversas object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Diversas> encontreTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Diversas> encontreTodos(Filter filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Diversas encontre(Filter filter) {
        try {
            return super.find(filter);
        } catch (Exception ex) {
            Logger.getLogger(DiversasDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
