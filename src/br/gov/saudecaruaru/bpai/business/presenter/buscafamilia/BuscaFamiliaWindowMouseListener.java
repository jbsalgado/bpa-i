/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.buscafamilia;


import br.gov.saudecaruaru.bpai.business.model.Observer;
import br.gov.saudecaruaru.bpai.business.model.Subject;
import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.*;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Junior Pires
 */
public class BuscaFamiliaWindowMouseListener {
    
    static class SelecionarLinhaMouseListener implements MouseListener,Subject{
        private BuscaFamiliaPresenter presenter;  
        private List<Observer> observers;
        
        public SelecionarLinhaMouseListener(BuscaFamiliaPresenter presenter) {  
            this.presenter = presenter; 
            this.observers = new ArrayList<Observer>();
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            FamiliaView view = this.presenter.getView();
            this.presenter.atualizarModeloDaJTable();
            this.presenter.habilitarEdicao(true);
            
            if(e.getClickCount()==2){
                int id = this.presenter.getIdFamilia();
                //notifica aos observadores sobre a selecao de registro
                notifyObservers(id);
                view.fecharJanela();
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
           
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
           
        }

        @Override
        public void mouseExited(MouseEvent e) {
           
        }

        @Override
    public void registerObserver(Observer o) {
      observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object obj) {
       for(Observer o: observers){
           o.update(this, obj);
       }
    }
  }
}
