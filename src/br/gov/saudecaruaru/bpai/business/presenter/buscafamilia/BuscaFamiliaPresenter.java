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
import br.gov.saudecaruaru.bpai.gui.documents.CepDocument;
import br.gov.saudecaruaru.bpai.gui.documents.DataDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyNumbersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyUpperLettersDocument;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.verifiers.CepVerifier;
import br.gov.saudecaruaru.bpai.gui.verifiers.DataVerifier;
import java.awt.Component;
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
       // this.desabilitaCabecalho();
        this.setVerifiers();
        this.setDocuments();
        this.setUpViewListeners();  
        this.view.enableBtnEditar(false);
        this.view.enableBtnConfirmar(false);
        this.view.enableBtnNovo(false);
        this.view.enableBtnCancelar(false);
        this.view.visibleBtnBuscar(true);
        //this.view.enableTxtFamilia(false);
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
     
    
    private void setUpViewListeners(){
          this.view.setSelecionarLinhaJTableActionListener(this.selecionarLinhaMouseListener);
          this.view.setBuscarActionListener(new BuscaFamiliaActionListener.BuscaActionListener(this));
          
          //listeners para completar com zeros a esquerda
          this.view.setSegmentoFocusListener(new BuscaFamiliaFocusListener.CompletarComZerosFocusListener("2"));
          this.view.setAreaFocusListener(new BuscaFamiliaFocusListener.CompletarComZerosFocusListener("3"));
          this.view.setMicroareaFocusListener(new BuscaFamiliaFocusListener.CompletarComZerosFocusListener("2"));
          this.view.setFamiliaFocusListener(new BuscaFamiliaFocusListener.CompletarComZerosFocusListener("3"));
    }
     public void setDocuments(){
        this.view.setTxtSegmentoDocument(new OnlyNumbersDocument(2));
        this.view.setTxtAreaDocument(new OnlyNumbersDocument(3));
        this.view.setTxtMicroareaDocument(new OnlyNumbersDocument(2));
        this.view.setTxtFamiliaDocument(new OnlyNumbersDocument(3));
        this.view.setTxtEnderecoDocument(new OnlyUpperLettersDocument(0));
        this.view.setTxtNumeroDocument(new OnlyNumbersDocument(0));
        this.view.setTxtBairroDocument(new OnlyUpperLettersDocument(0));
        this.view.setTxtMunicipioDocument(new OnlyUpperLettersDocument(0));
        this.view.setTxtCepDocument(new CepDocument());
        this.view.setTxtDataCadastroDocument(new DataDocument());
    }
     
    private void setVerifiers(){
        this.view.setTxtDataCadastroVerifier(new DataVerifier((Component) this.view, "Data Cadastro"));
        this.view.setTxtCepVerifier(new CepVerifier((Component)this.view,"Cep"));
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
    
    private void desabilitaCabecalho(){
        view.enableTxtSegmento(false);
        view.enableTxtArea(false);
        view.enableTxtMicroarea(false);
        view.enableTxtFamilia(false);
    }
    public FamiliaView getView(){
        return this.view;
    }

    public void atualizarModeloDaJTable() {  
        FamiliaTableModel tbModel = view.getFamiliaTableModel();  
          
        this.familia = tbModel.getFamilia(view.linhaSelecionadaTableFamilias());  
          
        if (this.familia != null) {  
            this.updateView();
        }  
           
    }
    
    private void updateView(){
       view.getBinder().updateView(this.familia);  
       this.getView().setSelectedUF(this.familia.getUf());    
    }
    
    public void atualizarJTable(){
        FamiliaTableModel familiaTableModel= new FamiliaTableModel(list);
        view.setFamiliaTableModel(familiaTableModel);
        this.view.refreshTableFamilias();
          
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
    public void buscarFamilias(){
        this.updateModel();
        list = this.familiaDao.findAllEqual(this.familia);
        this.atualizarJTable();
    }
    public int getIdFamilia(){
        return this.familia.getId();
    }

   
    
     
}
