/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.familia;

import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.data.BIFamiliaDAO;
import br.gov.saudecaruaru.bpai.gui.FamiliaTableModel;
import br.gov.saudecaruaru.bpai.gui.FamiliaWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import java.util.List;

/**
 *
 * @author juniorpires
 */
public class FamiliaPresenter {
    
    private FamiliaWindow view;
    private BIFamiliaDAO familiaDao;
    private BIFamilia familia;
    private List<BIFamilia> list;
    
    public final OperacaoStrategy INSERT_STRATEGY = new InsertStrategy();  
    public final OperacaoStrategy UPDATE_STRATEGY = new UpdateStrategy();  
      
    private OperacaoStrategy operacao = INSERT_STRATEGY;  
    
    public void createView() { 
        //cria a view 
        this.view = new FamiliaWindow();
        //cria o modelo
        this.novaFamilia();
        //cria o DAO
        this.familiaDao = new BIFamiliaDAO();
        
        this.setUpViewListeners();  
        this.habilitarEdicao(false);
        this.view.enableBtnEditar(false);
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
     
    
    private void setUpViewListeners(){
        this.view.setNovoActionListener(new FamiliaActionListener.NovoActionListener(this));
        this.view.setConfirmarActionListener(new FamiliaActionListener.ConfirmarActionListener(this));
    }
    
     private void initDadosJTable(){
      
        try {
            list= this.familiaDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FamiliaTableModel familiaTableModel= new FamiliaTableModel(list);
        view.setFamiliaTableModel(familiaTableModel);
        
    }
    public void novaFamilia(){
        this.familia = new BIFamilia();
    }
    
    public void habilitarEdicao(boolean arg){
        this.view.enableTxtArea(arg);
        this.view.enableTxtBairro(arg);
        this.view.enableTxtCep(arg);
        this.view.enableTxtEndereco(arg);
        this.view.enableTxtFamilia(arg);
        this.view.enableTxtMicroarea(arg);
        this.view.enableTxtMunicipio(arg);
        this.view.enableTxtNumero(arg);
        this.view.enableTxtSegmento(arg);
        this.view.enableTxtUF(arg);
        this.view.enableTxtDataCadastro(arg);
    }
    
    public FamiliaView getView(){
        return this.view;
    }
    
    private class InsertStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
            FamiliaPresenter.this.inserirFamilia(); 
            
        }  
    }  
    
    private class UpdateStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
           // CadastroPortePresenter.this.inserir; 
            
        }  
    }  
    
    public void setOperacao(OperacaoStrategy operacao) {  
        this.operacao = operacao;  
    }  
  
    public OperacaoStrategy getOperacao() {  
        return operacao;  
    }
    
    
     public void inserirFamilia(){
        this.getView().getBinder().updateModel(this.familia);
        this.familiaDao.save(this.familia);
        this.initDadosJTable();
        this.view.refreshTablePortes();
    }
}
