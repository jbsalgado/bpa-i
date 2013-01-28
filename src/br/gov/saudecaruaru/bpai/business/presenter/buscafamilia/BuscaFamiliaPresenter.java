/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.buscafamilia;

import br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia.*;
import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.business.model.Observer;
import br.gov.saudecaruaru.bpai.business.model.Subject;
import br.gov.saudecaruaru.bpai.business.presenter.buscafamilia.BuscaFamiliaWindowMouseListener.SelecionarLinhaMouseListener;
import br.gov.saudecaruaru.bpai.data.BIFamiliaDAO;
import br.gov.saudecaruaru.bpai.gui.FamiliaTableModel;
import br.gov.saudecaruaru.bpai.gui.FamiliaWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author juniorpires
 */
public class BuscaFamiliaPresenter{
    
    private FamiliaWindow view;
    private BIFamiliaDAO familiaDao;
    private BIFamilia familia;
    private List<BIFamilia> list;
    private SelecionarLinhaMouseListener selecionarLinhaMouseListener;

    public BuscaFamiliaPresenter() {
        this.selecionarLinhaMouseListener = new BuscaFamiliaWindowMouseListener.SelecionarLinhaMouseListener(this);
    }
    
    //metodo que cria a tela e registra um observer para ela
    public void createView(Observer o){
        this.createView();
        this.selecionarLinhaMouseListener.registerObserver(o);
       
    }
    public void createView() { 
        //cria a view 
        this.view = new FamiliaWindow();
        //cria o modelo
        this.novaFamilia();
        //cria o DAO
        this.familiaDao = new BIFamiliaDAO();
        
        this.setUpViewListeners();  
        this.view.enableBtnEditar(false);
        this.view.enableBtnConfirmar(false);
        this.view.enableBtnNovo(false);
        this.view.enableBtnCancelar(false);
        this.view.visibleBtnBuscar(true);
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
     
    
    private void setUpViewListeners(){
          this.view.setSelecionarLinhaJTableActionListener(this.selecionarLinhaMouseListener);
          this.view.setBuscarActionListener(new BuscaFamiliaActionListener.BuscaActionListener(this));
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

    public void atualizarModeloDaJTable() {  
        FamiliaTableModel tbModel = view.getFamiliaTableModel();  
          
        this.familia = tbModel.getFamilia(view.linhaSelecionadaTableFamilias());  
          
        if (this.familia != null) {  
            this.view.getBinder().updateView(this.familia);  
        }  
           
    }
    
    public void atualizarJTable(){
        FamiliaTableModel familiaTableModel= new FamiliaTableModel(list);
        view.setFamiliaTableModel(familiaTableModel);
        this.view.refreshTableFamilias();
          
    }
    public void buscarFamilias(){
        this.view.getBinder().updateModel(this.familia);
        list = this.familiaDao.findAllEqual(this.familia);
        this.atualizarJTable();
    }
    public int getIdFamilia(){
        return this.familia.getId();
    }

   
    
     
}
