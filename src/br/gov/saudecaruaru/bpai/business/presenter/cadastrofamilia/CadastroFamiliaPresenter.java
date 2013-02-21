/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastrofamilia;

import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.business.model.BIPaciente;
import br.gov.saudecaruaru.bpai.business.model.DoencaCondicao;
import br.gov.saudecaruaru.bpai.data.BICnesAreaDAO;
import br.gov.saudecaruaru.bpai.data.BIFamiliaDAO;
import br.gov.saudecaruaru.bpai.gui.tablemodel.FamiliaTableModel;
import br.gov.saudecaruaru.bpai.gui.FamiliaWindow;
import br.gov.saudecaruaru.bpai.gui.SearchGeneric;
import br.gov.saudecaruaru.bpai.gui.documents.CepDocument;
import br.gov.saudecaruaru.bpai.gui.documents.DataDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyNumbersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyUpperLettersDocument;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.verifiers.CepVerifier;
import br.gov.saudecaruaru.bpai.gui.verifiers.DataVerifier;
import br.gov.saudecaruaru.bpai.util.Search;
import java.awt.Component;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        this.view.setDocuments();
        this.setUpViewListeners();  
        this.habilitarEdicao(false);
        this.view.enableBtnEditar(false);
        this.view.visibleBtnBuscar(false);
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
    
    
    
    private void setVerifiers(){
        this.view.setTxtCepVerifier(new CepVerifier((Component)this.view,"Cep"));
    }
    
    private void setUpViewListeners(){
        this.view.setNovoActionListener(new CadastroFamiliaActionListener.NovoActionListener(this));
        this.view.setConfirmarActionListener(new CadastroFamiliaActionListener.ConfirmarActionListener(this));
        this.view.setSelecionarLinhaJTableActionListener(new CadastroFamiliaWindowMouseListener.SelecionarLinhaMouseListener(this));
        this.view.setEditarActionListener(new CadastroFamiliaActionListener.EditarActionListener(this));
        this.view.setCancelarActionListener(new CadastroFamiliaActionListener.CancelarActionListener(this));
        
        //listeners para completar com zeros a esquerda
        this.view.setSegmentoFocusListener(new CadastroFamiliaFocusListener.CompletarComZerosFocusListener("2"));
        this.view.setAreaFocusListener(new CadastroFamiliaFocusListener.CompletarComZerosFocusListener("4"));
        this.view.setMicroareaFocusListener(new CadastroFamiliaFocusListener.CompletarComZerosFocusListener("2"));
        this.view.setFamiliaFocusListener(new CadastroFamiliaFocusListener.CompletarComZerosFocusListener("3"));
        
        // esse listener tem que ser adicionado depois dos listeneres de completar com zero
        this.view.setFamiliaFocusListener(new CadastroFamiliaFocusListener.FamiliaFocusListener(this));
        
        //key listeners
        this.view.setAreaKeyListener(new CadastroFamiliaKeyListener.TxtAreaKeyKistener(this));
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
        this.view.enableTxtAno(arg);
        
        //this.view.setSelectedIndexUF(0);
    }
    
    public void desabilitaCabecalho(){
        view.enableTxtSegmento(false);
        view.enableTxtArea(false);
        view.enableTxtMicroarea(false);
        view.enableTxtFamilia(false);
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
        if(cep!=null){
            this.familia.setCep(cep);
        }
        
        
    }
    
     private void updateView(){
       view.getBinder().updateView(this.familia);  
       this.getView().setSelectedUF(this.familia.getUf());    
   }
     public void inserirFamilia(){
        this.updateModel();
        this.familiaDao.save(this.familia);
        this.initDadosJTable();
        this.view.refreshTableFamilias();
    }
     
    public void atualizarFamilia(){
        this.updateModel();
        this.familiaDao.update(this.familia);
        this.initDadosJTable();
        this.view.refreshTableFamilias();
    }
    
    public void atualizarModeloDaJTable() {  
        FamiliaTableModel tbModel = view.getFamiliaTableModel();  
          
        this.familia = tbModel.getFamilia(view.linhaSelecionadaTableFamilias());  
          
        if (this.familia != null) {  
            this.updateView();
        }  
           
    }  
    
    
  
    
     public boolean exibeFamilia(){
         BIFamilia f = new BIFamilia();
         f.setSegmento(this.view.getSegmento());
         f.setArea(this.view.getArea());
         f.setMicroArea(this.view.getMicroarea());
         f.setFamilia(this.view.getFamilia());
         
         
         List<BIFamilia> listFamilia = this.buscaFamilia(f);
         if(!listFamilia.isEmpty()){
            this.familia = listFamilia.get(0);
            this.updateView();
            return true;
         }
        
        return false;
    }
    
    private List<BIFamilia> buscaFamilia(BIFamilia p){
        return this.familiaDao.findAllEqual(p);
    }
    
    
    
    protected void selecionarArea(){
            Search model= SearchGeneric.getInstance().initModeSearch(new BICnesAreaDAO(), "codigoArea", "nomeArea", "Código", "Descrição", new HashMap<String,Object>());
            if ( model != null){
                CadastroFamiliaPresenter.this.view.setArea(model.getId());
                //agora vai buscar no banco de dados
//                Map<String,Object> res=new HashMap<String, Object>();
//                res.put("codigo_area", model.getId());
//                ProcedimentoAmbulatorial pro=ProcedimentoMedicoPresenter.this.procedimentoAmbulatorialDAO.findEqual(res);
//                ProcedimentoMedicoPresenter.this.
//                        procedimentoMedico.setProcedimentoAmbulatorial(pro);
        }
        
    }
     
}
