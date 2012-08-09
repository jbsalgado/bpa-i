/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.priuli.filter.Filter;

/**
 *
 * @author Junior Pires
 */
public class AcessoDAO extends GenericDAO<Acesso> implements BasicDAO<Acesso> {

    @Override
    public void salve(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Acesso encontre(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualize(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void exclua(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Acesso> encontreTodos() {
        try {
            return super.findAll();
        } catch (Exception ex) {
            Logger.getLogger(AcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<Acesso> encontreTodos(Filter filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Acesso encontre(Filter filter) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
