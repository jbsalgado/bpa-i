/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente;

import br.gov.saudecaruaru.bpai.business.model.BIDoencaCondicao;
import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.business.model.BIPaciente;
import br.gov.saudecaruaru.bpai.business.model.DoencaCondicao;
import br.gov.saudecaruaru.bpai.data.BIDoencaCondicaoDAO;
import br.gov.saudecaruaru.bpai.data.BIOcupacaoDAO;
import br.gov.saudecaruaru.bpai.data.BIPacienteDAO;
import br.gov.saudecaruaru.bpai.gui.PacienteWindow;
import br.gov.saudecaruaru.bpai.gui.SearchGeneric;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyNumbersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyUpperLettersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.SexoDocument;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import br.gov.saudecaruaru.bpai.gui.tablemodel.PacienteTableModel;
import br.gov.saudecaruaru.bpai.gui.verifiers.CnsVerifier;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import br.gov.saudecaruaru.bpai.util.Search;
import java.awt.Component;
import java.util.*;
import javax.swing.DefaultListModel;


/**
 *
 * @author juniorpires
 */
public class CadastroPacientePresenter {
    
    private PacienteView view;
    private BIPacienteDAO pacienteDao;
    private BIPaciente paciente;
    private List<BIPaciente> list;
    
    public final OperacaoStrategy INSERT_STRATEGY = new InsertStrategy();  
    public final OperacaoStrategy UPDATE_STRATEGY = new UpdateStrategy();  
      
    private OperacaoStrategy operacao = INSERT_STRATEGY;  
    
    public void createView() { 
        //cria a view 
        this.view = new PacienteWindow();
        //cria o modelo
        this.novoPaciente();
        //cria o DAO
        this.pacienteDao = new BIPacienteDAO();
        this.setVerifiers();
        this.setDocuments();
        this.setUpViewListeners();  
        this.habilitarEdicao(false);
        this.view.editableIdade(false);
        this.view.enableBtnEditar(false);
        this.view.enableBtnFamilia(false);
        this.view.enableTxtFamilia(false);
        //preenche a lista doencaCondicao
        this.preencheListDoencaCondicao2();
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
     
    
    private void setUpViewListeners(){
        this.view.setNovoActionListener(new CadastroPacienteActionListener.NovoActionListener(this));
        this.view.setConfirmarActionListener(new CadastroPacienteActionListener.ConfirmarActionListener(this));
        this.view.setSelecionarLinhaJTableActionListener(new CadastroPacienteMouseListener.SelecionarLinhaMouseListener(this));
        this.view.setEditarActionListener(new CadastroPacienteActionListener.EditarActionListener(this));
        this.view.setFamiliaActionListener(new CadastroPacienteActionListener.FamiliaActionListener(this));
        this.view.setCancelarActionListener(new CadastroPacienteActionListener.CancelarActionListener(this));
        this.view.setCnsFocusListener(new CadastroPacienteFocusListener.CnsFocusListener(this));
        this.view.setDoencaCondicaoActionListener(new CadastroPacienteActionListener.DoencaCondicaoActionListener(this));
        
        this.view.setCodigoOcupacaoKeyListener(new CadastroPacienteKeyListener.OcupacaoKeyListener(this));
        this.view.setIdadeFocusListener(new CadastroPacienteFocusListener.IdadeFocusListener(this));
        
        this.view.setListDoencaCondicao2MouseListener(new CadastroPacienteMouseListener.ListDoencaCondicao2MouseListener(this));
        this.view.setListDoencaCondicaoKeyListener(new CadastroPacienteKeyListener.ListDoencaCondicaoKeyListener(this));
    }
    
    private void setDocuments(){
        this.view.setTxtCnsDocument(new OnlyNumbersDocument(15));
        this.view.setTxtNomeDocument(new OnlyUpperLettersDocument(45));
        this.view.setTxtIdadeDocument(new OnlyNumbersDocument(3));
        this.view.setTxtSexoDocument(new OnlyUpperLettersDocument(1));
        this.view.setTxtOcupacaoDocument(new OnlyNumbersDocument(3));
        this.view.setTxtSexoDocument(new SexoDocument());
       // this.view.setTxtDataNascimentoDocument(new DataDocument());
    }
    
    private void setVerifiers(){
        this.view.setTxtCnsVerifier(new CnsVerifier((Component) this.view,"CNS"));
        //this.view.setTxtDatanascimentoVerifier(new DataVerifier((Component) this.view, "Data de Nascimento"));
    }
     private void initDadosJTable(){
      
        try {
            //List<String> groupByList = new ArrayList<String>();
            //groupByList.add("cns");
            list= new ArrayList<BIPaciente>(new HashSet<BIPaciente>( this.pacienteDao.findAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        PacienteTableModel pacienteTableModel= new PacienteTableModel(list);
        view.setPacienteTableModel(pacienteTableModel);
        
    }
    public void novoPaciente(){
        this.paciente = new BIPaciente();
    }
    
    public void habilitarEdicao(boolean arg){
        this.view.enableTxtCns(arg);
        this.view.enableTxtDataNascimento(arg);
        //this.view.enableTxtFamilia(arg);
        this.view.enableTxtIdade(arg);
        this.view.enableTxtNome(arg);
        this.view.enableTxtOcupacao(arg);
        this.view.enableTxtSexo(arg);
        this.view.enableJCbAlfabetizado(arg);
        //this.view.setSelectedIndexAlfabetizado(0);
        //this.view.setSelectedIndexDoencaCondicao(0);
        this.view.enableBtnFamilia(arg);
        this.view.enableBtnDoencaCondicao(arg);
        this.view.enableListDoencaCondicao(arg);
        this.view.enableListDoencaCondicao2(arg);
    }
    
    public PacienteView getView(){
        return this.view;
    }
    
    private class InsertStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
            CadastroPacientePresenter.this.inserirFamilia(); 
            
        }  
    }  
    
    private class UpdateStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
          CadastroPacientePresenter.this.atualizarPaciente(); 
            
        }  
    }  
    
    public void setOperacao(OperacaoStrategy operacao) {  
        this.operacao = operacao;  
    }  
  
    public OperacaoStrategy getOperacao() {  
        return operacao;  
    }
    
    
     public void inserirFamilia(){
        this.updateModel();
        this.pacienteDao.save(this.paciente);
        this.initDadosJTable();
        this.view.refreshTablePacientes();
    }
     
     private void updateModel(){
         this.getView().getBinder().updateModel(this.paciente);
         //this.paciente.setAlfabetizado(this.view.getAlfabetizado());
         this.paciente.setFamilia(new BIFamilia());
         this.paciente.getFamilia().setId(this.view.getIdFamilia());
         Date  dataNascimento = this.view.getDataNascimento();
          if(dataNascimento!=null){
             this.paciente.setDataNascimento(dataNascimento);
         }
          //pega o modelo da lista DoencaCondicao
          DefaultListModel listModel = this.view.getModelListDoencaCondicao();
          BIDoencaCondicao doencaCondicao =null;

          
          List<BIDoencaCondicao> doencaCondicaoList= new ArrayList<BIDoencaCondicao>();
          if(listModel!=null){
             for(int i=0;i<listModel.size();i++){
                 doencaCondicao = (BIDoencaCondicao) listModel.getElementAt(i);
                 if(doencaCondicao!=null){
                     doencaCondicaoList.add(doencaCondicao);
                 }
             }
          }
          
          this.paciente.setDoencaCondicaoList(doencaCondicaoList);
   }
     
     private void updateView(){
          this.getView().getBinder().updateView(this.paciente);
          this.getView().setSelectedAlfabetizado(this.paciente.getAlfabetizado());
//          this.getView().setSelectedDoencaCondicao(DoencaCondicao.MAP.get(this.paciente.getDoencaCondicao()));
          
          //atualiza o campo data nascimento
          this.getView().setDataNascimento(this.paciente.getDataNascimento());
          
          
          Collection<BIDoencaCondicao> doencaCondicaoList = this.paciente.getDoencaCondicaoList();
          DefaultListModel listModel = this.view.getModelListDoencaCondicao();
          //remove todos os elementos da lista para poder inserir os novos elementos vindos do modelo
          listModel.removeAllElements();
          
          for (BIDoencaCondicao bIDoencaCondicao : doencaCondicaoList) {
             listModel.addElement(bIDoencaCondicao);
         }
     }
    public void atualizarPaciente(){
        this.updateModel();
        this.pacienteDao.update(this.paciente);
        this.initDadosJTable();
        this.view.refreshTablePacientes();
    }
    
    public void atualizarModeloDaJTable() {  
        PacienteTableModel tbModel = view.getPacienteTableModel();  
          
        this.paciente = tbModel.getPaciente(view.linhaSelecionadaTablePacientes());  
          
        if (this.paciente != null) {  
            this.updateView();
        }  
           
    }  
    
    public boolean exibePaciente(String cns){
        BIPaciente p = this.buscaPaciente(cns);
        if(p!=null){
            this.paciente = p;
            this.updateView();
            return true;
        }
        
        return false;
    }
    
    private BIPaciente buscaPaciente(String cns){
        BIPaciente p = new BIPaciente();
        p.setCns(cns);
        return this.pacienteDao.findEqual(p);
    }
    
    public void selecionarOcupacao(){
        Search model= SearchGeneric.getInstance().initModeSearch(new BIOcupacaoDAO(), "codigo", "nome", "Código", "Descrição", new HashMap<String,Object>());
        if ( model != null){
            this.view.setCodigoOcupacao(model.getId());
           
        }
    }
    
    public void selecionarDoencaCondicao(){
            DefaultListModel modelListDoencaCondicao2 = this.view.getModelListDoencaCondicao2();
            DefaultListModel modelListDoencaCondicao = this.view.getModelListDoencaCondicao();
            
            if(this.view.getSelectedListDoencaCondicao2()>=0){
                BIDoencaCondicao doencaCondicao =(BIDoencaCondicao) modelListDoencaCondicao2.get(this.view.getSelectedListDoencaCondicao2());

                //evita inserir dois registros iguais
                if(!modelListDoencaCondicao.contains(doencaCondicao)){
                    modelListDoencaCondicao.addElement(doencaCondicao);
                }
            
            }
              
    }

    
    //seta uma lista de BIDoencaCondicao ao model de DoencaCondicao
    private void setDataListaDoencaCondicao2(List<BIDoencaCondicao> list){
        DefaultListModel modelListDoencaCondicao2 = this.view.getModelListDoencaCondicao2();
        for (Object object : list) {
            modelListDoencaCondicao2.addElement(object);
        }
        
    }
    public void preencheListDoencaCondicao2(){
        BIDoencaCondicaoDAO condicaoDAO = new BIDoencaCondicaoDAO();
        this.setDataListaDoencaCondicao2(condicaoDAO.findAll());
    }
    
    public void removeItemListaDoencaCondicao(){
        DefaultListModel modelListDoencaCondicao = this.view.getModelListDoencaCondicao();
        if(this.view.getSelectedListDoencaCondicao()>=0){
            modelListDoencaCondicao.remove(this.view.getSelectedListDoencaCondicao());
        }
    }
    
    //metodo que calcula a idade baseado na data de nascimento e insere a idade no campo idade
    public void insereIdade(){
        Date dataNascimento = this.view.getDataNascimento();
            if(dataNascimento!=null){
                //calcula a idade
                int idade = DateUtil.getAge(dataNascimento, new Date());
                //seta a idade no campo idade
                this.view.setIdade(idade);
            }else{
                this.view.setIdade("");
            }
    }
    
   
     
}
