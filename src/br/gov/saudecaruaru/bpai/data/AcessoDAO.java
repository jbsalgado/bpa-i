/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.data;

import br.gov.saudecaruaru.bpai.business.model.Acesso;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Junior Pires
 */
public class AcessoDAO extends GenericDAO<Acesso> implements BasicDAO<Acesso> {

    @Override
    public void salvar(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void find(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void deletar(Acesso object) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Acesso> findAll() {
        try {
            return this.findAll();
        } catch (Exception ex) {
            Logger.getLogger(AcessoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<Acesso>();
        }
    }
    
    
    
}
