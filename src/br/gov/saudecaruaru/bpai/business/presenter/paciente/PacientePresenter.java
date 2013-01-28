/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.business.presenter.paciente;

import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.business.model.BIPaciente;
import br.gov.saudecaruaru.bpai.data.BIFamiliaDAO;
import br.gov.saudecaruaru.bpai.data.BIPacienteDAO;
import br.gov.saudecaruaru.bpai.gui.FamiliaTableModel;
import br.gov.saudecaruaru.bpai.gui.FamiliaWindow;
import br.gov.saudecaruaru.bpai.gui.PacienteTableModel;
import br.gov.saudecaruaru.bpai.gui.PacienteWindow;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import br.gov.saudecaruaru.bpai.gui.interfaces.OperacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import java.util.List;

/**
 *
 * @author juniorpires
 */
public class PacientePresenter {
    
    private PacienteWindow view;
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
        
        this.setUpViewListeners();  
        this.habilitarEdicao(false);
        this.view.enableBtnEditar(false);
        this.initDadosJTable();
        //this.view.setVerifiers();
        //this.view.setDocuments();
        this.view.packAndShow();
    }  
     
    
    private void setUpViewListeners(){
        this.view.setNovoActionListener(new PacienteActionListener.NovoActionListener(this));
        this.view.setConfirmarActionListener(new PacienteActionListener.ConfirmarActionListener(this));
        this.view.setSelecionarLinhaJTableActionListener(new PacienteWindowMouseListener.SelecionarLinhaMouseListener(this));
        this.view.setEditarActionListener(new PacienteActionListener.EditarActionListener(this));
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
        this.view.enableTxtDoencaCondicao(arg);
        this.view.enableTxtFamilia(arg);
        this.view.enableTxtIdade(arg);
        this.view.enableTxtNome(arg);
        this.view.enableTxtOcupacao(arg);
        this.view.enableTxtSexo(arg);
        this.view.enableJCbAlfabetizado(arg);
    }
    
    public PacienteView getView(){
        return this.view;
    }
    
    private class InsertStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
            PacientePresenter.this.inserirFamilia(); 
            
        }  
    }  
    
    private class UpdateStrategy implements OperacaoStrategy {  
        @Override
        public void execute() {  
          PacientePresenter.this.atualizarFamilia(); 
            
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
         this.paciente.setAlfabetizado(this.view.getAlfabetizado());
         this.paciente.setFamilia(new BIFamilia());
         this.paciente.getFamilia().setId(this.view.getIdFamilia());
     }
    public void atualizarFamilia(){
        this.updateModel();
        this.pacienteDao.update(this.paciente);
        this.initDadosJTable();
        this.view.refreshTablePacientes();
    }
    
    public void atualizarModeloDaJTable() {  
        PacienteTableModel tbModel = view.getPacienteTableModel();  
          
        this.paciente = tbModel.getPaciente(view.linhaSelecionadaTablePacientes());  
          
        if (this.paciente != null) {  
            this.view.getBinder().updateView(this.paciente);  
        }  
           
    }  
     
}
