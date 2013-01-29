/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia;

import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.data.BIFamiliaDAO;
import br.gov.saudecaruaru.bpai.gui.FamiliaTableModel;
import br.gov.saudecaruaru.bpai.gui.FamiliaWindow;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyNumbersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyUpperLettersDocument;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.verifiers.DataVerifier;
import java.awt.Component;
import java.util.List;


/**
 *
 * @author juniorpires
 */
public class CadastroFamiliaPresenter {
    
    private FamiliaView view;
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
        this.setVerifiers();
        this.setDocuments();
        this.setUpViewListeners();  
        this.habilitarEdicao(false);
        this.view.enableBtnEditar(false);
        this.view.visibleBtnBuscar(false);
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
    
    private void setDocuments(){
        this.view.setTxtSegmentoDocument(new OnlyNumbersDocument(2));
        this.view.setTxtAreaDocument(new OnlyNumbersDocument(3));
        this.view.setTxtMicroareaDocument(new OnlyNumbersDocument(2));
        this.view.setTxtFamiliaDocument(new OnlyNumbersDocument(3));
        this.view.setTxtEnderecoDocument(new OnlyUpperLettersDocument(60));
        this.view.setTxtNumeroDocument(new OnlyNumbersDocument(4));
        this.view.setTxtBairroDocument(new OnlyUpperLettersDocument(60));
        this.view.setTxtMunicipioDocument(new OnlyUpperLettersDocument(60));
    }
    
    private void setVerifiers(){
        this.view.setFmDataCadastroVerifier(new DataVerifier((Component) this.view, "Data Cadastro"));
        //this.view.setFmCepVerifier(null);
    }
    
    private void setUpViewListeners(){
        this.view.setNovoActionListener(new CadastroFamiliaActionListener.NovoActionListener(this));
        this.view.setConfirmarActionListener(new CadastroFamiliaActionListener.ConfirmarActionListener(this));
        this.view.setSelecionarLinhaJTableActionListener(new CadastroFamiliaWindowMouseListener.SelecionarLinhaMouseListener(this));
        this.view.setEditarActionListener(new CadastroFamiliaActionListener.EditarActionListener(this));
        this.view.setCancelarActionListener(new CadastroFamiliaActionListener.CancelarActionListener(this));
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
        this.view.enableCbUF(arg);
        this.view.enableTxtDataCadastro(arg);
    }
    
    public FamiliaView getView(){
        return this.view;
    }
    
    private class InsertStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
            CadastroFamiliaPresenter.this.inserirFamilia(); 
            
        }  
    }  
    
    private class UpdateStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
          CadastroFamiliaPresenter.this.atualizarFamilia(); 
            
        }  
    }  
    
    public void setOperacao(OperacaoStrategy operacao) {  
        this.operacao = operacao;  
    }  
  
    public OperacaoStrategy getOperacao() {  
        return operacao;  
    }
    
    private void updateModel(){
        this.getView().getBinder().updateModel(this.familia);
        String cep = this.view.getCep();
        String dataCadastro = this.view.getDataCadastro();
        if(cep!=null){
            this.familia.setCep(cep);
        }
        if(dataCadastro!=null){
            this.familia.setDataCadastro(dataCadastro);
        }
        
    }
     public void inserirFamilia(){
        this.updateModel();
        this.familiaDao.save(this.familia);
        this.initDadosJTable();
        this.view.refreshTableFamilias();
    }
     
    public void atualizarFamilia(){
        this.getView().getBinder().updateModel(this.familia);
        this.familiaDao.update(this.familia);
        this.initDadosJTable();
        this.view.refreshTableFamilias();
    }
    
    public void atualizarModeloDaJTable() {  
        FamiliaTableModel tbModel = view.getFamiliaTableModel();  
          
        this.familia = tbModel.getFamilia(view.linhaSelecionadaTableFamilias());  
          
        if (this.familia != null) {  
            this.view.getBinder().updateView(this.familia);  
        }  
           
    }  
     
}
