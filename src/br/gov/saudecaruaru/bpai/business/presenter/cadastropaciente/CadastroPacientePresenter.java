/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.cadastropaciente;

import br.gov.saudecaruaru.bpai.business.model.*;
import br.gov.saudecaruaru.bpai.data.BIFamiliaDAO;
import br.gov.saudecaruaru.bpai.data.BIOcupacaoDAO;
import br.gov.saudecaruaru.bpai.data.BIPacienteDAO;
import br.gov.saudecaruaru.bpai.gui.*;
import br.gov.saudecaruaru.bpai.gui.documents.DataDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyNumbersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.OnlyUpperLettersDocument;
import br.gov.saudecaruaru.bpai.gui.documents.SexoDocument;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import br.gov.saudecaruaru.bpai.gui.tablemodel.PacienteTableModel;
import br.gov.saudecaruaru.bpai.gui.verifiers.CnesVerifier;
import br.gov.saudecaruaru.bpai.gui.verifiers.CnsVerifier;
import br.gov.saudecaruaru.bpai.gui.verifiers.DataVerifier;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import br.gov.saudecaruaru.bpai.util.Search;
import java.awt.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
     
    
    private void setUpViewListeners(){
        this.view.setNovoActionListener(new CadastroPacienteActionListener.NovoActionListener(this));
        this.view.setConfirmarActionListener(new CadastroPacienteActionListener.ConfirmarActionListener(this));
        this.view.setSelecionarLinhaJTableActionListener(new CadastroPacienteWindowMouseListener.SelecionarLinhaMouseListener(this));
        this.view.setEditarActionListener(new CadastroPacienteActionListener.EditarActionListener(this));
        this.view.setFamiliaActionListener(new CadastroPacienteActionListener.FamiliaActionListener(this));
        this.view.setCancelarActionListener(new CadastroPacienteActionListener.CancelarActionListener(this));
        this.view.setCnsFocusListener(new CadastroPacienteFocusListener.CnsFocusListener(this));
        
        this.view.setCodigoOcupacaoKeyListener(new CadastroPacienteKeyListener.OcupacaoKeyListener(this));
        this.view.setIdadeFocusListener(new CadastroPacienteFocusListener.IdadeFocusListener(this));
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
            list= this.pacienteDao.findAll();
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
        this.view.enableCbDoencaCondicao(arg);
        //this.view.enableTxtFamilia(arg);
        this.view.enableTxtIdade(arg);
        this.view.enableTxtNome(arg);
        this.view.enableTxtOcupacao(arg);
        this.view.enableTxtSexo(arg);
        this.view.enableJCbAlfabetizado(arg);
        //this.view.setSelectedIndexAlfabetizado(0);
        //this.view.setSelectedIndexDoencaCondicao(0);
        this.view.enableBtnFamilia(arg);
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
         //String dataNascimento = this.view.getDataNascimento();
//         if(dataNascimento!=null){
//             this.paciente.setDataNascimento(dataNascimento);
//         }
     }
     
     private void updateView(){
          this.getView().getBinder().updateView(this.paciente);
          this.getView().setSelectedAlfabetizado(this.paciente.getAlfabetizado());
          this.getView().setSelectedDoencaCondicao(DoencaCondicao.MAP.get(this.paciente.getDoencaCondicao()));
          //atualiza o campo data nascimento
          this.getView().setDataNascimento(this.paciente.getDataNascimento());
          
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
