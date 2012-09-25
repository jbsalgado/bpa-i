
package br.gov.saudecaruaru.bpai.gui;




import br.gov.saudecaruaru.bpai.gui.formatter.CaraterAtendimentoFormatter;
import br.gov.saudecaruaru.bpai.gui.formatter.DiversasFormatter;
import br.gov.saudecaruaru.bpai.business.controller.*;
import br.gov.saudecaruaru.bpai.business.model.*;

import br.gov.saudecaruaru.bpai.gui.formatter.EquipeFormatter;
import br.gov.saudecaruaru.bpai.gui.validators.*;
import br.gov.saudecaruaru.bpai.util.DateUtil;
import br.gov.saudecaruaru.bpai.util.ProcedimentoRealizadoTableModel;
import br.gov.saudecaruaru.bpai.util.Search;
import com.towel.swing.combo.ObjectComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Junior Pires
 */
public class CadastroIndividualizado extends javax.swing.JDialog implements TelaCadastroI{
    
     //armazenamento de variáveis para a busca dos dados ficar mais rápida
     public static HashMap<String, Equipe> MAP_EQUIPE= new HashMap<String, Equipe>();
     public static HashMap<Object, Diversas> MAP_DIVERSAS= new HashMap<Object, Diversas>();
     public static HashMap<Object, Paciente> MAP_PACIENTE= new HashMap<Object, Paciente>();
     public static HashMap<Object, Municipio> MAP_MUNICIPIO= new HashMap<Object, Municipio>();
     
     
    
         
    

    /**
     * @return the listFieldsHeader
     */
    public  List<Component> getListFieldsHeader() {
        return listFieldsHeader;
    }
     private Diversas diversas;
     private DiversasPK diversasPk;
     //controladores
     private DiversasController diversasController;
     private MedicoController medicoController;
     private MedicoCboCnesController medicoCboCnesController;
     private PacienteController pacienteController;
     private MunicipioController municipioController;
     private ProcedimentoController procedimentoController;
     private DoencaController doencaController;
     private BIProcedimentoRealizadoController bIProcedimentoRealizadoController;
     private ProcedimentoRealizadoController procedimentoRealizadoController;
     private ProcedimentoServicoController procedimentoServicoController;
     private EquipeController equipeController;
     
     private ProcedimentoRealizado procedimentoRealizado;
     private GestorCompetenciaController gestorCompetenciaController;
     
     private ProcedimentoRealizadoTableModel tableModelDados;
     private ObjectComboBoxModel<Diversas> objectComboBoxModelRacaCor;
     private ObjectComboBoxModel<Diversas> objectComboBoxModelServico;
     private ObjectComboBoxModel<Diversas> objectComboBoxModelClassificaoServico;
     private ObjectComboBoxModel<CaraterAtendimento> objectComboBoxModelCaraterAtend;
     private ObjectComboBoxModel<Equipe> objectComboBoxModelEquipe;
     private int sequencia=1;
     
     private List<BIProcedimentoRealizado> lBi;
     private Set<Paciente> setPaciente;
     private Set<Medico> setMedico;
     private Set<MedicoCboCnes> setMedicoCboCnes;
     
     private  List<Component> listFieldsHeader = new ArrayList<Component>();
     private  List<Component> listFieldsProcedimento = new ArrayList<Component>();
     private  List<Component> listFieldsDates = new ArrayList<Component>();
     
    /**
     * Creates new form CadastroIndividualizado
     */
    public CadastroIndividualizado() {

        this.initComponents();
       
        this.myInitComponents();
        
    }

    public CadastroIndividualizado(Frame owner) {
        super(owner);
        this.initComponents();
        this.myInitComponents();
        
        
    }
    
    public CadastroIndividualizado(Frame owner, boolean modal) {
        super(owner);
        this.initComponents();
        this.myInitComponents();
        this.setModal(modal);
        
        
    }
    
    
    
    
    private void initInstances(){
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        //inicializa as opcoes do JOptionPane
        UIManager.put("OptionPane.yesButtonText", "Sim");     
        UIManager.put("OptionPane.noButtonText", "Não");   
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");

        this.objectComboBoxModelRacaCor= new ObjectComboBoxModel<Diversas>();
        this.objectComboBoxModelServico= new ObjectComboBoxModel<Diversas>();
        this.objectComboBoxModelClassificaoServico= new ObjectComboBoxModel<Diversas>();
        this.objectComboBoxModelCaraterAtend= new ObjectComboBoxModel<CaraterAtendimento>();
        this.objectComboBoxModelEquipe= new ObjectComboBoxModel<Equipe>();
        
        DiversasFormatter formatter=new DiversasFormatter();
        this.objectComboBoxModelRacaCor.setFormatter(formatter);
        this.objectComboBoxModelServico.setFormatter(formatter);
        this.objectComboBoxModelClassificaoServico.setFormatter(formatter);
        this.objectComboBoxModelCaraterAtend.setFormatter(new CaraterAtendimentoFormatter());
        this.objectComboBoxModelEquipe.setFormatter(new EquipeFormatter());
        
        this.gestorCompetenciaController = new GestorCompetenciaController(); 
        this.diversasController = new DiversasController();
        this.medicoController= new MedicoController();
        this.medicoCboCnesController=new MedicoCboCnesController();
        this.pacienteController=new PacienteController();
        this.municipioController= new MunicipioController();
        this.procedimentoController= new ProcedimentoController();
        this.doencaController=new DoencaController();
        this.bIProcedimentoRealizadoController= new BIProcedimentoRealizadoController();
        this.procedimentoRealizadoController=new ProcedimentoRealizadoController();
        this.procedimentoServicoController= new ProcedimentoServicoController();
        this.equipeController= new EquipeController();
        
        this.lBi=new ArrayList<BIProcedimentoRealizado>();
        this.setPaciente=new HashSet<Paciente>();
        this.setMedico= new HashSet<Medico>();
        this.setMedicoCboCnes= new HashSet<MedicoCboCnes>();
        
        
        //instancia o modelo DiversasPk
        diversas = new  Diversas();
        diversasPk = new DiversasPK();
        diversas.setDiversasPK(diversasPk);
        
        //inicializa a lista com as referencias aos campso do cabeçalho
        this.initListFieldsHeader();
        this.initListFieldsProcedimento();
        this.initListFieldsDates();
    }
    private void initListFieldsHeader(){
       listFieldsHeader= new ArrayList<Component>();
       listFieldsHeader.add(jTextFieldCnes);
       listFieldsHeader.add(jTextFieldCnsProfiss);
       listFieldsHeader.add(jTextFieldNomeProfiss);
       listFieldsHeader.add(jTextFieldCBO);
       listFieldsHeader.add(jTextFieldMes);
       listFieldsHeader.add(jTextFieldAno);
       listFieldsHeader.add(jTextFieldFolha);

    }
    
     private void initListFieldsDates(){
       listFieldsDates= new ArrayList<Component>();
       listFieldsDates.add(jTextFieldUsarioDatNasc);
       listFieldsDates.add(jTextFieldProcDataAtend);
     }
    
     private void initListFieldsProcedimento(){
       listFieldsProcedimento= new ArrayList<Component>();
        //seta as referencias dos textsFields na lista
        //LEMBRE-SE QUE A ORDEM É IMPORTANTE PORQUE A VALIDACAO DE UM TEXTFIELD (nos input verifiers)
        //PODEM DEPENDER DO VALOR DE OUTRO
        getListFieldsProcedimento().add(jTextFieldUsarioDatNasc);
        getListFieldsProcedimento().add(jTextFieldUsuarioNome);
        getListFieldsProcedimento().add(jTextFieldUsuarioSexo);
        getListFieldsProcedimento().add(jTextFieldUsuarioCodMunicip);
        getListFieldsProcedimento().add(jTextFieldProcDataAtend);
        getListFieldsProcedimento().add(jTextFieldProcCod);
       
     }
    
    private boolean textFieldVerifier(List<Component> listComponents){
     
        for(Component c:listComponents){
            if(c instanceof JTextField){
                JTextField field = ((JTextField)c);
                String value = field.getText().replace("/"," ").trim();
                if(value.isEmpty()){
                     //rquisista o foco
                     field.requestFocus();
                     //perde o foco
                     field.transferFocus();
                     return false;
                 
                }
            }  
 }
      return true;
}
    private void insertInJTable() {
        try{
         //insere o modelo Procedimento realizado na jTable
         this.tableModelDados.setValueAt(procedimentoRealizado,Integer.parseInt(this.procedimentoRealizado.getProcedimentoRealizadoPK().getSequenciaFolha())-1);

            
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void myInitComponents(){
       
        //seta o estado do frame para ocupar toda a tela
        //this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        //this.setVisible(true);
        this.initInstances();
        
        this.initJTableDados();
        //pega o primeiro objeto da jTable e atribui ao modelo atual
        this.procedimentoRealizado = this.tableModelDados.getCloneElementList(0);
        //caso o objeto pego já possua informacoes, desabilita o cabeçalho
        this.fillFields(this.procedimentoRealizado, true); 
        this.disabledFieldsProcedimento();
        
         this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
         this.initComboBoxs();
         //incializa os campos com busca por F2
         this.initKeyPresseds();
         //adicionando listeners aos campos 
         this.addListenersFields();
         //disabilita alguns campos
         this.disableSomeFields();
         //inicializa alguns campos
         this.initFields();
         // Inicializa os validadores dos campos
         this.setVerifiers();
         
       
}
   
    private void disableSomeFields(){
        //desabilita alguns campos do usuario
        jTextFieldUsuarioNomeMunicip.setEnabled(false);
        jTextFieldUsuarioNomeNac.setEnabled(false);
        jTextFieldUsuarioDescEtnia.setEnabled(false);
        
        //desabilita alguns campos do procedimento
        jTextFieldProcDescricao.setEnabled(false);
        //jTextFieldProcDescricaoProc.setText("ANALISE DE ALGUMA COISA");
        jTextFieldProcDescriDoenca.setEnabled(false);
        //desabilitando etnia
        jTextFieldUsuarioCodEtnia.setEnabled(false);
    }
    
    private void initFields(){
        //inicializando campos 
        
        //inicializando competencia
        String competencia = gestorCompetenciaController.getCompetenciaAtual();
        //verifica se existe competencia
        if(!competencia.equals("")){
            jTextFieldMes.setText(competencia.substring(4));
            jTextFieldAno.setText(competencia.substring(0, 4));
            //seta a competencia vinda do banco
            procedimentoRealizado.getProcedimentoRealizadoPK().setCompetencia(competencia);
        }
        
        jTextFieldUsuarioSexo.setText("");
        //inicializando nacionalidade: BRASIL
        jTextFieldUsuarioCodNac.setText(Diversas.CODIGO_NACIONALIDADE_BRASIL);
        procedimentoRealizado.setNacionalidadePaciente(Diversas.CODIGO_NACIONALIDADE_BRASIL);
        
        //inicializando os comboboxs
        this.selectItemJComboBoxRacaCor(Diversas.COD_RACA_COR_SEM_INFORMACAO);
        this.selectItemJComboBoxCaraterAtend(CaraterAtendimento.SEM_INFORMACAO);
        
        
        
       
    }
    
    private void setVerifiers(){
        //atribui validadores
        jTextFieldNomeProfiss.setInputVerifier(new OnlyLettersVerifier(this, "Nome"));
        jTextFieldCnes.setInputVerifier(new CnesVerifier(this, "CNES"));
        jTextFieldUsuarioNome.setInputVerifier(new OnlyLettersVerifier(this, "Nome"));
        jTextFieldProcQuant.setInputVerifier(new OnlyNumbers(this,"Quantidade"));
        jTextFieldCnsProfiss.setInputVerifier(new CnsVerifier(this,"CNS"));
        jTextFieldUsuarioCns.setInputVerifier(new CnsUsuarioVerifier(this, "CNS",this));
        jTextFieldCBO.setInputVerifier(new CBOVerifier(this, "CBO"));
        jTextFieldUsuarioCodNac.setInputVerifier(new NacionalidadeVerifier(this, "Nacionalidade",jTextFieldUsuarioNomeNac));
        jTextFieldUsuarioCodMunicip.setInputVerifier(new MunicipioVerifier(this,"Municipio",jTextFieldUsuarioNomeMunicip));
        jTextFieldUsuarioCodEtnia.setInputVerifier(new EtniaVerifier(this,"Etnia", jTextFieldUsuarioDescEtnia));
        jTextFieldProcCod.setInputVerifier(new ProcedimentoVerifier(this, "Procedimento", jTextFieldProcDescricao,this));
        jTextFieldProcCID.setInputVerifier(new DoencaVerifier(this, "CID", jTextFieldProcDescriDoenca,this));
        jComboBoxProcCaraterAtend.setInputVerifier(new CaraterAtendVerifier(this,"Caráter de Atendimento"));
        jTextFieldUsarioDatNasc.setInputVerifier(new DataVerifier(this, "Data de Nascimento"));
        jTextFieldProcQuant.setInputVerifier(new QuantProcedimentoVerifier(this, "Quantidade",this));
        jTextFieldProcDataAtend.setInputVerifier(new DataAtendimentoVerifier(this, "Data Atendimento",this,jTextFieldUsarioDatNasc));
        jTextFieldAno.setInputVerifier(new CompetenciaVerifier(this,"Ano", jTextFieldMes));
        jTextFieldFolha.setInputVerifier(new FolhaVerifier(this, "Folha"));
        jTextFieldMes.setInputVerifier(new MesVerifier(this, "Mês"));
        jTextFieldUsuarioSexo.setInputVerifier(new SexoVerifier(this, "Sexo"));
        jComboBoxEquipe.setInputVerifier(new ComboBoxVerifier(this, "Equipe"));
        jComboBoxUsuarioServico.setInputVerifier(new ComboBoxVerifier(this, "Serviço"));
        jComboBoxEquipe.setInputVerifier(new ComboBoxVerifier(this, "Classificação"));
    }
    
    
    
    private void initKeyPresseds(){
        //campo do CNES
        this.jTextFieldCnes.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldCnsProfiss.requestFocusInWindow();
                }
            }
        });
        
        this.jTextFieldCnsProfiss.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Search m=CadastroIndividualizado.this.keyPressedJTextFieldCnsProfiss();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        CadastroIndividualizado.this.jTextFieldCnsProfiss.setText(m.getId());
                    }
                }
                //teclou "enter"
                else if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldNomeProfiss.requestFocusInWindow();
                }
            }
             
        
        });
        //campo para o nome do profissional
        this.jTextFieldNomeProfiss.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldCBO.requestFocusInWindow();
                }
            }
        });
         //para CBO do profissional
        this.jTextFieldCBO.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Search m=CadastroIndividualizado.this.keyPressedJTextFieldCBO();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        CadastroIndividualizado.this.jTextFieldCBO.setText(m.getId());
                    }
                }
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jComboBoxEquipe.requestFocusInWindow();
                } 
                
            }
             
        
        });
        
        
        
        //combobox da equipe
        this.jComboBoxEquipe.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
               if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldMes.requestFocusInWindow();
                } 
            }
        });
        //campo mês da competência
        this.jTextFieldMes.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldAno.requestFocusInWindow();
                } 
            }
        });
        //campo ano da competência
        this.jTextFieldAno.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldFolha.requestFocusInWindow();
                } 
            }
        });
        
        //folha da competência
        
        this.jTextFieldFolha.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldUsuarioCns.requestFocusInWindow();
                } 
            }
        });
        
        //para pacientes/cns do paciente
        this.jTextFieldUsuarioCns.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Search m=CadastroIndividualizado.this.keyPressedJTextFieldUsuarioCns();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        CadastroIndividualizado.this.jTextFieldUsuarioCns.setText(m.getId());
                    }
                }
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldUsuarioNome.requestFocusInWindow();
                }
            }
             
        
        });
        
        
        //campo nome do paciente/usuário
        this.jTextFieldUsuarioNome.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldUsuarioSexo.requestFocusInWindow();
                } 
            }
        });
        
        //campo sexo do paciente/usuário
        this.jTextFieldUsuarioSexo.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldUsarioDatNasc.requestFocusInWindow();
                } 
            }
        });
        
        //campo data de nascimento do paciente/usuário
        this.jTextFieldUsarioDatNasc.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldUsuarioCodMunicip.requestFocusInWindow();
                } 
            }
        });
        
        //para município
        this.jTextFieldUsuarioCodMunicip.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Search m=CadastroIndividualizado.this.keyPressedJTextFieldUsuarioMunicip();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        //26 é referente ao estado de pernambuco
                        CadastroIndividualizado.this.jTextFieldUsuarioCodMunicip.setText("26"+m.getId());
                        CadastroIndividualizado.this.jTextFieldUsuarioNomeMunicip.setText(m.getDescription());
                    }
                }
                
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldUsuarioCodNac.requestFocusInWindow();
                } 
            }
             
        
        });
        
        //para município
        this.jTextFieldUsuarioCodNac.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Search m=CadastroIndividualizado.this.keyPressedJTextFieldUsuarioCodNac();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        //26 é referente ao estado de pernambuco
                        CadastroIndividualizado.this.jTextFieldUsuarioCodNac.setText(m.getId());
                        CadastroIndividualizado.this.jTextFieldUsuarioNomeNac.setText(m.getDescription());
                    }
                }
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jComboBoxUsuarioRacaCor.requestFocusInWindow();
                } 
            }
             
        
        });
        //combobox raça/cor
        this.jComboBoxUsuarioRacaCor.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    //pega o codigo do elemento selecionado
                    String codigo=CadastroIndividualizado.this.objectComboBoxModelRacaCor.getSelectedObject().getDiversasPK().getCodigoItemTabela();
                    if(Diversas.COD_RACA_COR_INDIGENA.equals(codigo)){
                        CadastroIndividualizado.this.jTextFieldUsuarioCodEtnia.requestFocusInWindow();
                    }
                    else{
                        CadastroIndividualizado.this.jTextFieldProcDataAtend.requestFocusInWindow();
                    }
                } 
            }
        });
        
        //campo código da etnia
        this.jTextFieldUsuarioCodEtnia.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldProcDataAtend.requestFocusInWindow();
                } 
            }
        });
        
        //campo data de atendimento
        this.jTextFieldProcDataAtend.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldProcCod.requestFocusInWindow();
                } 
            }
        });
        
        //para procedimento realizado
        this.jTextFieldProcCod.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Procedimento m=CadastroIndividualizado.this.keyPressedJTextFieldProcCod();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        //26 é referente ao estado de pernambuco
                        CadastroIndividualizado.this.jTextFieldProcCod.setText(m.getProcedimentoPk().getId()+m.getDigitoVerificador());
                        CadastroIndividualizado.this.jTextFieldProcDescricao.setText(m.getDescricao());
                    }
                }
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldProcQuant.requestFocusInWindow();
                } 
            }
             
        
        });
        
        //campo quantidade de vezes que o procedimento foi executado
        this.jTextFieldProcQuant.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jComboBoxUsuarioServico.requestFocusInWindow();
                } 
            }
        });
        
        //comboxo de serviço
        this.jComboBoxUsuarioServico.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jComboBoxUsuarioClassificacao.requestFocusInWindow();
                } 
            }
        });
        
        //campo quantidade de vezes que o procedimento foi executado
        this.jComboBoxUsuarioClassificacao.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldProcCID.requestFocusInWindow();
                } 
            }
        });
        
        //para procedimento realizado
        this.jTextFieldProcCID.addKeyListener(new KeyAdapter() {
             public void keyPressed(java.awt.event.KeyEvent evt) {
                 //o usuário clicou F2
                if(evt.getKeyCode()==KeyEvent.VK_F1){
                    Search m=CadastroIndividualizado.this.keyPressedJTextFieldProcCID();
                    //o usuário selecionou um registro
                    if(m!=null){
                        //vai setor o valor do código no campo
                        //26 é referente ao estado de pernambuco
                        CadastroIndividualizado.this.jTextFieldProcCID.setText(m.getId());
                        CadastroIndividualizado.this.jTextFieldProcDescriDoenca.setText(m.getDescription());
                    }
                }
                
                if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jComboBoxProcCaraterAtend.requestFocusInWindow();
                } 
            }
             
        
        });
        
        //combobox caráter de atendimento
        this.jComboBoxProcCaraterAtend.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jTextFieldProcNumAut.requestFocusInWindow();
                } 
            }
        });
        
        //campo número de autorização
        this.jTextFieldProcNumAut.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    CadastroIndividualizado.this.jButtonIncluir.requestFocusInWindow();
                } 
            }
        });
    }
    
    private void initJTableDados(){
       //cria a lista para armazenar 20 procedimentos 
       List<ProcedimentoRealizado> list= new ArrayList<ProcedimentoRealizado>();
       //inicializa a lista de procedimentos realizados
       for(int i=0;i<20;i++){
           ProcedimentoRealizado p=new ProcedimentoRealizado();
           p.setProcedimentoRealizadoPK(new ProcedimentoRealizadoPK());
           //inicia a sequência
           p.getProcedimentoRealizadoPK().setSequenciaFolha(Integer.toString(i+1));
           list.add(p);
       }
       //cria um modelo para a tabela
       this.tableModelDados= new ProcedimentoRealizadoTableModel(list);
       this.jTable1.setModel(this.tableModelDados);
       //incia o tamanho padrão da tabela
       TableColumnModel columns=this.jTable1.getColumnModel();
       
       //coluna sequência
       columns.getColumn(0).setPreferredWidth(40);
       //coluna cns do paciente
       columns.getColumn(1).setPreferredWidth(120);
       //coluna nome do paciente
       columns.getColumn(2).setPreferredWidth(300);
       //coluna data de nascimento do paciente
       columns.getColumn(3).setPreferredWidth(70);
       //coluna sexo do paciente
       columns.getColumn(4).setPreferredWidth(40);
       //coluna município de residência do paciente
       columns.getColumn(5).setPreferredWidth(120);
       //coluna data de atendimento
       columns.getColumn(6).setPreferredWidth(100);
       //coluna procedimento
       columns.getColumn(7).setPreferredWidth(100);
       //coluna quantidade de realizações do procedimento no paciente
       columns.getColumn(8).setPreferredWidth(40);
       //cid do procedimento
       columns.getColumn(9).setPreferredWidth(40);
       //coluna caraterização do atendimento 
       columns.getColumn(10).setPreferredWidth(80);
       //coluna número de autorização
       columns.getColumn(11).setPreferredWidth(100);
       //coluna raça/cor
       columns.getColumn(12).setPreferredWidth(80);
       //coluna etnia
       columns.getColumn(13).setPreferredWidth(80);
       //coluna nacionalidade do paciente
       columns.getColumn(14).setPreferredWidth(80);
       //inicia o ScrollPanel
       //this.jScrollPane1.setHorizontalScrollBarPolicy(JScrollPane.);
       
    }
    //todos os keyPressed
    
    /**
     * Método que realiza a busca de um médico
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Search keyPressedJTextFieldCnsProfiss(){
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.medicoController, "cns", "nome","CNS", "Nome",new HashMap<String, Object>());
    }
    
     /**
     * Método que realiza a busca um CBO
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Search keyPressedJTextFieldCBO(){
        //restrição para qualquer busca
        HashMap<String, Object> res=new HashMap<String, Object>();
        res.put("diversasPK.codigoTabela", Diversas.TABELA_PROFISSAO);
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.diversasController, 
                                                        "diversasPK.codigoItemTabela", "descricaoItemTabela",
                                                        "Código", "Profissão",res);
    }
    
    /**
     * Método que realiza uma busca de usuários/pacientes
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Search keyPressedJTextFieldUsuarioCns(){
        
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.pacienteController, "cns", "nome","CNS", "Nome",new HashMap<String, Object>());
    }
    
    /**
     * Método que realiza a busca de um município
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Search keyPressedJTextFieldUsuarioMunicip(){
        HashMap<String, Object> res=new HashMap<String, Object>();
        //pernambuco
        res.put("municipioPK.uf", "26");
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.municipioController, 
                                                            "municipioPK.codigoMunicipio", "nome",
                                                            "Código", "Nome", res);
    }
    
   /**
     * Método que realiza a busca da nacionalidade
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Search keyPressedJTextFieldUsuarioCodNac(){
        //restrição para qualquer busca
        HashMap<String, Object> res=new HashMap<String, Object>();
        res.put("diversasPK.codigoTabela", Diversas.TABELA_PAIS);
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.diversasController, 
                                                        "diversasPK.codigoItemTabela", "descricaoItemTabela",
                                                        "Código", "Nacionalidade",res);
    }
    
    /**
     * Método que realiza a busca da nacionalidade
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Procedimento keyPressedJTextFieldProcCod(){
        //restrição para qualquer busca
        HashMap<String, Object> res=new HashMap<String, Object>();
        String comp=this.jTextFieldAno.getText()+this.jTextFieldMes.getText();
        res.put("procedimentoPk.competencia", comp);
        Search s=SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.procedimentoController, 
                                                        "procedimentoPk.id", "descricao",
                                                        "Código", "Descrição",res);
        res.put("procedimentoPk.id",s.getId() );
        return this.procedimentoController.findEqual(res);
    }
    
    /**
     * Método que realiza a busca da nacionalidade
     * @return Search objeto de pesquisa com um identificador e uma descrição
     */
    private Search keyPressedJTextFieldProcCID(){
        //restrição para qualquer busca
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.doencaController, 
                                                        "codigo", "descricao",
                                                        "Código", "Descrição",new HashMap<String, Object>());
    }
    
    
        
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNomeProfiss = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelUsuarioSeq = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldUsuarioNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldUsuarioNomeNac = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldUsuarioNomeMunicip = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldUsuarioDescEtnia = new javax.swing.JTextField();
        jComboBoxUsuarioRacaCor = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldUsuarioCns = new javax.swing.JFormattedTextField();
        jTextFieldUsuarioSexo = new javax.swing.JFormattedTextField();
        jTextFieldUsarioDatNasc = new javax.swing.JFormattedTextField();
        jTextFieldUsuarioCodEtnia = new javax.swing.JFormattedTextField();
        jTextFieldUsuarioCodMunicip = new javax.swing.JFormattedTextField();
        jTextFieldUsuarioCodNac = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabelProcSeq = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldProcQuant = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldProcDescriDoenca = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextFieldProcDescricao = new javax.swing.JTextField();
        jComboBoxProcCaraterAtend = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextFieldProcDataAtend = new javax.swing.JFormattedTextField();
        jTextFieldProcCod = new javax.swing.JFormattedTextField();
        jTextFieldProcCID = new javax.swing.JFormattedTextField();
        jTextFieldProcNumAut = new javax.swing.JFormattedTextField();
        jButtonGravar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jComboBoxUsuarioServico = new javax.swing.JComboBox();
        jLabel27 = new javax.swing.JLabel();
        jComboBoxUsuarioClassificacao = new javax.swing.JComboBox();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldCnes = new javax.swing.JFormattedTextField();
        jTextFieldCnsProfiss = new javax.swing.JFormattedTextField();
        jTextFieldMes = new javax.swing.JFormattedTextField();
        jTextFieldAno = new javax.swing.JFormattedTextField();
        jTextFieldFolha = new javax.swing.JFormattedTextField();
        jTextFieldCBO = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();
        jComboBoxEquipe = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName("Cadastro indivualizado"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("CNES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("CNS Profissional");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nome Profissional");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Mês/Ano");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Folha");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText(" /");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("CNS");

        jLabel8.setText("Usuário Sequência :");

        jLabelUsuarioSeq.setText("01");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Nome ");

        jTextFieldUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Sexo");

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText(" F/M");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Dt. Nascimento");

        jTextFieldUsuarioNomeNac.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioNomeNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeNacActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Nacionalidade");

        jTextFieldUsuarioNomeMunicip.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioNomeMunicip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeMunicipActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Município de Residência");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Raça/Cor");

        jTextFieldUsuarioDescEtnia.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioDescEtnia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioDescEtniaActionPerformed(evt);
            }
        });

        jComboBoxUsuarioRacaCor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUsuarioRacaCor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuarioRacaCorActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Etnia");

        jTextFieldUsuarioCns.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###############"))));

        try {
            jTextFieldUsuarioSexo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("U")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldUsarioDatNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldUsuarioCodEtnia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldUsuarioCodMunicip.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldUsuarioCodNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelUsuarioSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuarioCns, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsarioDatNasc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxUsuarioRacaCor, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioCodEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsuarioDescEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioCodMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsuarioNomeMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioCodNac, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldUsuarioNomeNac, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(546, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelUsuarioSeq))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1))
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldUsuarioNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldUsuarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsarioDatNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jTextFieldUsuarioCns, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuarioNomeMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioNomeNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioCodMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioCodNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuarioDescEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUsuarioRacaCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioCodEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel16.setText("Procedimento Sequência :");

        jLabelProcSeq.setText("01");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Dt. Atendimento");

        jTextFieldProcQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcQuantActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Quantidade");

        jTextFieldProcDescriDoenca.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldProcDescriDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcDescriDoencaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("Código");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("CID");

        jTextFieldProcDescricao.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldProcDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcDescricaoActionPerformed(evt);
            }
        });

        jComboBoxProcCaraterAtend.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProcCaraterAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProcCaraterAtendActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Nº Autorização");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel18.setText("Caráter Atendimento");

        jButtonIncluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonIncluirMouseClicked(evt);
            }
        });
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        jButtonIncluir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButtonIncluirKeyPressed(evt);
            }
        });

        jButtonLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLimparMouseClicked(evt);
            }
        });
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        try {
            jTextFieldProcDataAtend.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldProcCod.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldProcCID.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("****")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldProcNumAut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*************")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonGravar.setText("Gravar");
        jButtonGravar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGravarMouseClicked(evt);
            }
        });

        jButtonSair.setText("Sair");
        jButtonSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSairMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Serviço");

        jComboBoxUsuarioServico.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUsuarioServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuarioServicoActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Classificação");

        jComboBoxUsuarioClassificacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxUsuarioClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxUsuarioClassificacaoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1217, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxProcCaraterAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldProcNumAut)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jTextFieldProcCID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProcDescriDoenca))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(174, 174, 174)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabelProcSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jComboBoxUsuarioServico, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jComboBoxUsuarioClassificacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel20)
                                                .addComponent(jTextFieldProcDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(347, 347, 347))
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(jTextFieldProcCod)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jTextFieldProcDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextFieldProcQuant)))))
                                .addGap(0, 3, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1054, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabelProcSeq))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldProcQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(jLabel23))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldProcDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldProcDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldProcCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxUsuarioClassificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxUsuarioServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonIncluir, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(jButtonLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldProcDescriDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProcCaraterAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcNumAut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGravar)
                    .addComponent(jButtonSair))
                .addContainerGap())
        );

        try {
            jTextFieldCnes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldCnsProfiss.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldMes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));

        try {
            jTextFieldFolha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jTextFieldCBO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("CBO");

        jComboBoxEquipe.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxEquipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEquipeActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Equipe");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1239, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCnes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldCnsProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNomeProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCBO, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 547, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel21)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldNomeProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCnsProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxEquipe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
    
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jComboBoxProcCaraterAtendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxProcCaraterAtendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxProcCaraterAtendActionPerformed

    private void jTextFieldProcDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProcDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProcDescricaoActionPerformed

    private void jTextFieldProcDescriDoencaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProcDescriDoencaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProcDescriDoencaActionPerformed

    private void jTextFieldProcQuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldProcQuantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldProcQuantActionPerformed

    private void jButtonIncluirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonIncluirMouseClicked
        if(this.textFieldVerifier(getListFieldsProcedimento())){
        // metodo que pega os valores de alguns campos e adiciona-os ao modelo
        this.getValuesOfFieldsForModel();
         if(this.tableModelDados.getCloneElementListEmpty()==null){
           //insere o modelo na jTable
          this.insertInJTable();
          
        
         }else{
      
            //insere o modelo na jTable
            this.insertInJTable();

            ProcedimentoRealizado p = this.tableModelDados.getCloneElementListEmpty();
            if(p!=null){
                this.procedimentoRealizado = p;
                this.fillHeaderModelProcedimentoRealizado(this.procedimentoRealizado);
                this.fillFields(procedimentoRealizado, false);
            }else{
                this.beginNewWindow();
            }

               
         }
       

        }
    }//GEN-LAST:event_jButtonIncluirMouseClicked

    private void beginNewWindow(){
        this.insertInDatabase();
        //inicia a jTable
        this.initJTableDados();
        //pega o primeiro objeto da jTable e atribui ao modelo atual
        this.procedimentoRealizado = this.tableModelDados.getCloneElementList(0);
        if(JOptionPane.showOptionDialog(this,"DESEJA INICIAR A INCLUSÃO COM O MESMO CABEÇALHO?","Questão",
                               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null)==JOptionPane.YES_OPTION){
             //pega o valor do campo folha e converte para inteiro
             int folha = Integer.parseInt(jTextFieldFolha.getText());
             //incrementa
             ++folha;
             //converte de volta para String recolocando os zeros a esquerda se necessário com o metodo format
             String f = String.format("%03d",folha);  
             //seta o novo valor de folha no campo folha
             jTextFieldFolha.setText(f); 
           this.fillFields(this.procedimentoRealizado, false);
           this.fillHeaderModelProcedimentoRealizado(this.procedimentoRealizado);
        }else{
           //preenche todos os campos  
           this.fillFields(this.procedimentoRealizado,true);
           //habilita os campos do cabeçalho
           this.enableFieldsHeader();
        }
    }
   
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JTable j = (JTable)evt.getComponent();
        int row = j.getSelectedRow();
        
        this.procedimentoRealizado = this.tableModelDados.getCloneElementList(row);
        fillFields(procedimentoRealizado,false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButtonGravarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGravarMouseClicked
        this.beginNewWindow();
        
    }//GEN-LAST:event_jButtonGravarMouseClicked

    private void jButtonLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLimparMouseClicked
       this.clearFields();
    }//GEN-LAST:event_jButtonLimparMouseClicked

    private void jComboBoxEquipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEquipeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEquipeActionPerformed

    private void jComboBoxUsuarioServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuarioServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUsuarioServicoActionPerformed

    private void jComboBoxUsuarioClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxUsuarioClassificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxUsuarioClassificacaoActionPerformed

    private void jButtonSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSairMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonSairMouseClicked

    private void jButtonIncluirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButtonIncluirKeyPressed
           if(evt.getKeyCode()==KeyEvent.VK_ENTER){
               this.jButtonIncluirMouseClicked(null);
           }
    }//GEN-LAST:event_jButtonIncluirKeyPressed
                                          

    private void jTextFieldCnsProfissActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jTextFieldNomeProfissActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void jTextFieldUsuarioSexoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

                                              

    private void jTextFieldAnoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void jTextFieldFolhaActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void jTextFieldUsuarioCnsActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jTextFieldUsuarioNomeActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void jTextFieldUsarioDatNascActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void jTextFieldUsuarioCodMunicipActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        // TODO add your handling code here:
    }                                                           

    private void jTextFieldUsuarioNomeMunicipActionPerformed(java.awt.event.ActionEvent evt) {                                                             
        // TODO add your handling code here:
    }                                                            

    private void jTextFieldUsuarioCodNacActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void jTextFieldUsuarioNomeNacActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // TODO add your handling code here:
    }                                                        

    private void jTextFieldProcDataAtendActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       
                                                        

    private void jTextFieldProcCodActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jTextFieldProcCIDActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
    }                                                 

    private void jTextFieldProcDescricaoProcActionPerformed(java.awt.event.ActionEvent evt) {                                                            
        // TODO add your handling code here:
    }                                                           

    private void jTextFieldUsuarioEtniaActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void jTextFieldUsuarioDescEtniaActionPerformed(java.awt.event.ActionEvent evt) {                                                           
        // TODO add your handling code here:
    }                                                          

    private void jComboBoxUsuarioRacaCorActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

   

    private void jTextFieldCBOActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxEquipe;
    private javax.swing.JComboBox jComboBoxProcCaraterAtend;
    private javax.swing.JComboBox jComboBoxUsuarioClassificacao;
    private javax.swing.JComboBox jComboBoxUsuarioRacaCor;
    private javax.swing.JComboBox jComboBoxUsuarioServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelProcSeq;
    private javax.swing.JLabel jLabelUsuarioSeq;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JFormattedTextField jTextFieldAno;
    private javax.swing.JFormattedTextField jTextFieldCBO;
    private javax.swing.JFormattedTextField jTextFieldCnes;
    private javax.swing.JFormattedTextField jTextFieldCnsProfiss;
    private javax.swing.JFormattedTextField jTextFieldFolha;
    private javax.swing.JFormattedTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldNomeProfiss;
    private javax.swing.JFormattedTextField jTextFieldProcCID;
    private javax.swing.JFormattedTextField jTextFieldProcCod;
    private javax.swing.JFormattedTextField jTextFieldProcDataAtend;
    private javax.swing.JTextField jTextFieldProcDescriDoenca;
    private javax.swing.JTextField jTextFieldProcDescricao;
    private javax.swing.JFormattedTextField jTextFieldProcNumAut;
    private javax.swing.JTextField jTextFieldProcQuant;
    private javax.swing.JFormattedTextField jTextFieldUsarioDatNasc;
    private javax.swing.JFormattedTextField jTextFieldUsuarioCns;
    private javax.swing.JFormattedTextField jTextFieldUsuarioCodEtnia;
    private javax.swing.JFormattedTextField jTextFieldUsuarioCodMunicip;
    private javax.swing.JFormattedTextField jTextFieldUsuarioCodNac;
    private javax.swing.JTextField jTextFieldUsuarioDescEtnia;
    private javax.swing.JTextField jTextFieldUsuarioNome;
    private javax.swing.JTextField jTextFieldUsuarioNomeMunicip;
    private javax.swing.JTextField jTextFieldUsuarioNomeNac;
    private javax.swing.JFormattedTextField jTextFieldUsuarioSexo;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the procedimentoRealizado
     */
    @Override
    public ProcedimentoRealizado getProcedimentoRealizado() {
        return procedimentoRealizado;
    }

    /**
     * @return the listFieldsProcedimento
     */
    public List<Component> getListFieldsProcedimento() {
        return listFieldsProcedimento;
    }


    private void initComboBoxs(){
        
        
        initComboBoxServico();
        initComboBoxClassificacao();
        this.jComboBoxEquipe.setModel(this.objectComboBoxModelEquipe);
        
        //inicializar comboBox Cor
        //seta no modelo Diversas o codigo referente a tabela Cor no banco
        diversas.getDiversasPK().setCodigoTabela(Diversas.TABELA_COR_INDIVIDUO);
        //realiza a busca no banco 
        List<Diversas> list = diversasController.findAllEqual(diversas);
        this.objectComboBoxModelRacaCor.setData(list);
//        //cria um vetor de string para popular o combobox
//        String[] comboListCor = new String[list.size()];
//        //preenche o vetor de String com os valores retornados do banco
//        for (int i=0;i<list.size();i++) {
//            //concatena o codigo e a descriacao da Cor e atribui ao vetor de String
//            comboListCor[i] = list.get(i).getDiversasPK().getCodigoItemTabela()+list.get(i).getDescricaoItemTabela();
//        }
//        //cria o modelo do combobox com as informações do banco
        //ComboBoxModel model = new DefaultComboBoxModel(this.objectComboBoxModelRacaCor);
        //seta o modelo no combobox Cor
        jComboBoxUsuarioRacaCor.setModel(this.objectComboBoxModelRacaCor);
       
        //seta os objetos no modelo
        this.objectComboBoxModelCaraterAtend.setData(CaraterAtendimento.LIST);
        //seta o modelo no combobox CaraterAtendimento
        jComboBoxProcCaraterAtend.setModel(objectComboBoxModelCaraterAtend);
    }
    
    private void initComboBoxServico(){
        this.jComboBoxUsuarioServico.setModel(this.objectComboBoxModelServico);
    }
    private void initComboBoxClassificacao(){
        this.jComboBoxUsuarioClassificacao.setModel(this.objectComboBoxModelClassificaoServico);
    }
   
    
     
      
      
      private void addListenersFields(){
          
          
          jTextFieldCnes.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
                                //perdeu o foco para um campo e o objeto não tem um CNS
                if(e.getOppositeComponent() instanceof JTextField ){
                   String cnes=CadastroIndividualizado.this.jTextFieldCnes.getText();
                   if(!cnes.isEmpty()){
                       //caso os cnes's sejam diferentes vai executar
                       if(!cnes.equals(CadastroIndividualizado.this.procedimentoRealizado.getProcedimentoRealizadoPK().getCnesUnidade())){
                           CadastroIndividualizado.this.focusLostFieldCnes();
                       }
                   }
               }
              
            }
        });

            jTextFieldCnsProfiss.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.getProcedimentoRealizadoPK().setCnsMedico( ((JTextField)e.getComponent()).getText());
                  
            }
        });
         jTextFieldNomeProfiss.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
             
            }
        });   
         jTextFieldCBO.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.getProcedimentoRealizadoPK().setCboMedico(((JTextField)e.getComponent()).getText());
               
             
            }
        });
         
        jTextFieldAno.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
                  if(e.getOppositeComponent() instanceof JTextField){
                    procedimentoRealizado.getProcedimentoRealizadoPK().setCompetencia(((JTextField)e.getComponent()).getText()+jTextFieldMes.getText());
                    enableFieldsProcedimento();
               }
            }
        }); 
        
         jTextFieldFolha.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                
               String folha = bIProcedimentoRealizadoController.getNextFolha(new BIProcedimentoRealizado(procedimentoRealizado));
               if(!folha.isEmpty()&& folha.length()==3){
                   
                   jTextFieldFolha.setText(folha);
               }
            }

            @Override
            public void focusLost(FocusEvent e) {
               //se o próximo componente for um jtextfield 
               if(e.getOppositeComponent() instanceof Component){
                   //pega o número da folha
                   procedimentoRealizado.getProcedimentoRealizadoPK().setNumeroFolha(((JTextField)e.getComponent()).getText());

                   if(jTextFieldFolha.getInputVerifier().shouldYieldFocus(jTextFieldFolha)){
                        //List<String> emptyFields = 
                        if(textFieldVerifier(getListFieldsHeader())){
                            //desabilita os campos do cabeçalho da tela que são 
                            //referentes as informações da unidade e do usuário      
                            disableFieldsHeader();
                            
                        }  

                   }
                    try {
                        //vai pegar a folha caso exista
                       ProcedimentoRealizado pr=(ProcedimentoRealizado) CadastroIndividualizado.this.procedimentoRealizado.clone();
                       //coloca a origem
                       pr.setOrigemProcedimento(ProcedimentoRealizado.ORIGEM_INDIVIDUALIZADO);
                       //retira a nacionalidade
                       pr.setNacionalidadePaciente(null);
                       pr.setQuantidadeRealizada(null);
                       //pr.getProcedimentoRealizadoPK().setCompetencia();
                       //retira a sequência
                       pr.getProcedimentoRealizadoPK().setSequenciaFolha(null);
                        CadastroIndividualizado.this.findAllProcedimentosFolha(pr);
                       
      
                    } catch (CloneNotSupportedException ex) {
                        Logger.getLogger(CadastroIndividualizado.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
           }
        });
         
         
         
         
         
          jTextFieldUsuarioCns.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
                //perdeu o foco para um campo e o objeto não tem um CNS
                if(e.getOppositeComponent() instanceof JTextField ){
                   String cns=CadastroIndividualizado.this.jTextFieldUsuarioCns.getText();
                   if(!cns.isEmpty()){
                       //caso os códigos sejam diferentes vai executar
                       if(!cns.equals(CadastroIndividualizado.this.procedimentoRealizado.getCnsPaciente())){
                           CadastroIndividualizado.this.focusLostFieldUsuarioCns();
                       }
                   }
               }
               
            }
        });
          
           jTextFieldUsuarioNome.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               CadastroIndividualizado.this.procedimentoRealizado.setNomePaciente(((JTextField)e.getComponent()).getText());
            }
        });
           
            jTextFieldUsuarioSexo.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               CadastroIndividualizado.this.procedimentoRealizado.setSexoPaciente(((JTextField)e.getComponent()).getText());
            }
        });
          
            
             jTextFieldUsarioDatNasc.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
               //se o próximo componente for um Component e o método ainda não tinha sido executado
               if( e.getOppositeComponent() instanceof Component 
                       /*&& procedimentoRealizado.getDataNascimentoPaciente()==null*/){ 
                if(jTextFieldUsarioDatNasc.getInputVerifier().shouldYieldFocus(jTextFieldUsarioDatNasc)){   
                    //converte a data para o formato YYYMMdd 
                    String dataNasc = DateUtil.parseToYearMonthDay(((JTextField)e.getComponent()).getText());
                    CadastroIndividualizado.this.procedimentoRealizado.setDataNascimentoPaciente(dataNasc);
                }
            
               }
            
            }
        });
            
           jTextFieldUsuarioCodMunicip.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               CadastroIndividualizado.this.procedimentoRealizado.setCodigoIBGECidadePaciente(((JTextField)e.getComponent()).getText());
            }
        });
           
            jTextFieldUsuarioCodNac.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               CadastroIndividualizado.this.procedimentoRealizado.setNacionalidadePaciente(((JTextField)e.getComponent()).getText());
            }
        });
             jComboBoxUsuarioRacaCor.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               //abre o combobox ao ganhar o foco 
               jComboBoxUsuarioRacaCor.setPopupVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
               int index = ((JComboBox)e.getComponent()).getSelectedIndex();
               Diversas d = (Diversas) objectComboBoxModelRacaCor.getData().get(index);
               CadastroIndividualizado.this.procedimentoRealizado.setRacaPaciente(d.getDiversasPK().getCodigoItemTabela().toString());
            }
        });
             
          jTextFieldUsuarioCodEtnia.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               CadastroIndividualizado.this.procedimentoRealizado.setEtniaPaciente(((JTextField)e.getComponent()).getText());
            }
        });
          
           jTextFieldProcDataAtend.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
//               if(jTextFieldUsarioDatNasc.getText().equals("  /  /    ")){
//                   jTextFieldUsarioDatNasc.requestFocus();
//               }
                   
            }

            @Override
            public void focusLost(FocusEvent e) {
               //se o próximo componente for um jtextfield e o método ainda não tinha sido executado
               if(e.getOppositeComponent() instanceof JTextField){ 
                   String dataAtend = ((JTextField)e.getComponent()).getText();
                   if(!dataAtend.isEmpty()){
                        //converte a data para o formato YYYYMMdd    
                        dataAtend = DateUtil.parseToYearMonthDay(dataAtend);
                        //caso as data sejam diferentes vai executar e o formato do conteudo do campo for válido
                        if(!dataAtend.equals(CadastroIndividualizado.this.procedimentoRealizado.getDataAtendimento()) &&
                            jTextFieldProcDataAtend.getInputVerifier().shouldYieldFocus(jTextFieldProcDataAtend)){
                   
                            CadastroIndividualizado.this.procedimentoRealizado.setDataAtendimento(dataAtend);
                            

                           
                }
                   
                   }
              
               
               }
               
           
           }
               
               
        });
           
         jTextFieldProcCod.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                //se o proximo elemento for um textField
                if(e.getOppositeComponent() instanceof JTextField ){
                    //se as datas nao forem nulas
                    if(CadastroIndividualizado.this.procedimentoRealizado.getDataNascimentoPaciente()!=null && CadastroIndividualizado.this.procedimentoRealizado.getDataAtendimento()!=null){
                        String dataNasc = CadastroIndividualizado.this.jTextFieldUsarioDatNasc.getText();
                        String dataAtend = CadastroIndividualizado.this.jTextFieldProcDataAtend.getText();
                        //se alguma data for diferente da que está persistida no objeto
                        if(!dataNasc.equals(CadastroIndividualizado.this.procedimentoRealizado.getDataNascimentoPaciente()) || !dataAtend.equals(CadastroIndividualizado.this.procedimentoRealizado.getDataAtendimento())){
                            //obtem a idade do paciente
                            String age = String.valueOf(DateUtil.getAge(CadastroIndividualizado.this.procedimentoRealizado.getDataNascimentoPaciente(),CadastroIndividualizado.this.procedimentoRealizado.getDataAtendimento()));
                            //seta no modelo
                            CadastroIndividualizado.this.procedimentoRealizado.setIdadePaciente(age);
                        }
                    }
                }
                //textFieldVerifier(listFieldsDates);
            }

            @Override
            public void focusLost(FocusEvent e) {
                //perdeu o foco para a campo "quantidade"
               if(e.getOppositeComponent() instanceof JTextField ){
                  
                   String codigo=CadastroIndividualizado.this.jTextFieldProcCod.getText();
                   if(!codigo.isEmpty()){
                       
                       //caso os código sejam diferentes vai executar
                       if(!codigo.equals(CadastroIndividualizado.this.procedimentoRealizado.getCodigoProcedimento())){
                           CadastroIndividualizado.this.focusLostComboboxServico();
                       }
                       
                   }
               
               }
            }
        });
          
          jTextFieldProcQuant.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(e.getOppositeComponent() instanceof JComboBox ){
                   String quantidade=CadastroIndividualizado.this.jTextFieldProcQuant.getText();
                   if(!quantidade.isEmpty()){
                       //caso as quantidades sejam diferentes vai executar
                       try{
                           Double d=Double.parseDouble(quantidade);

                           if(!d.equals(CadastroIndividualizado.this.procedimentoRealizado.getQuantidadeRealizada())){
                               CadastroIndividualizado.this.procedimentoRealizado.setQuantidadeRealizada(d); 
                           }
                       }catch(NumberFormatException ex){
                       
                       }
                   }
               }
               
            }
        });
          
         jTextFieldProcCID.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
                
                
               CadastroIndividualizado.this.procedimentoRealizado.setCidDoencaprocedimento(((JTextField)e.getComponent()).getText());
            }
        });
         
          jComboBoxProcCaraterAtend.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               //abre o combobox ao ganhar o foco 
               jComboBoxProcCaraterAtend.setPopupVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
               int index = ((JComboBox)e.getComponent()).getSelectedIndex(); 
               CaraterAtendimento c = (CaraterAtendimento) objectComboBoxModelCaraterAtend.getData().get(index);
               CadastroIndividualizado.this.procedimentoRealizado.setCaracterizacaoAtendimento(c.getCodigo().toString());
               
              
              
            }
        });
          
         jTextFieldProcNumAut.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               CadastroIndividualizado.this.procedimentoRealizado.setNumeroAutorizacao(((JTextField)e.getComponent()).getText());
            }
        });
          
        jComboBoxEquipe.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               //abre o combobox ao ganhar o foco 
               jComboBoxEquipe.setPopupVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
               int index = ((JComboBox)e.getComponent()).getSelectedIndex();
               if(index>=0){
                    Equipe equipe = (Equipe) objectComboBoxModelEquipe.getData().get(index);
                    CadastroIndividualizado.this.procedimentoRealizado.setEquipe(equipe.getEquipePK().getSequencia()+equipe.getArea());
               }
               }
        });
        
        jComboBoxUsuarioServico.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               //abre o combobox ao ganhar o foco 
               jComboBoxUsuarioServico.setPopupVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
               int index = ((JComboBox)e.getComponent()).getSelectedIndex();
               if(index>=0){
               Diversas d = (Diversas) objectComboBoxModelServico.getData().get(index);
               CadastroIndividualizado.this.procedimentoRealizado.setCodigoServico(d.getDiversasPK().getCodigoItemTabela().toString());
               }
            }
        });
        
        jComboBoxUsuarioClassificacao.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                //abre o combobox ao ganhar o foco 
               jComboBoxUsuarioClassificacao.setPopupVisible(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
               int index = ((JComboBox)e.getComponent()).getSelectedIndex();
               if(index>=0){
               Diversas d = (Diversas) objectComboBoxModelClassificaoServico.getData().get(index);
               CadastroIndividualizado.this.procedimentoRealizado.setCodigoClassificacaoServico(d.getDiversasPK().getCodigoItemTabela().substring(3));
               }
            }
        });
      }
      
      /**
       * Desabilita os campos do cabeçalho da tela
       */
      public void disableFieldsHeader(){
           this.changeStatusHeader(false);
      }
      
      /**
       * Abilita os campos do cabeçalho da tela
       */
      private void enableFieldsHeader(){
          this.changeStatusHeader(true);
      }
      
      private void changeStatusHeader(boolean status){
            jTextFieldCnes.setEnabled(status);
            jTextFieldCnsProfiss.setEnabled(status);
            jTextFieldNomeProfiss.setEnabled(status);
            jTextFieldCBO.setEnabled(status);
            jComboBoxEquipe.setEnabled(status);
            jTextFieldMes.setEnabled(status);
            jTextFieldAno.setEnabled(status);
            jTextFieldFolha.setEnabled(status);
      }
      /**
       * Desabilita os campos relacionados ao paciente/usuário
       */
      public void disabledFieldsProcedimento(){
        this.changeStatusFieldsProcedimento(false);
          
      }
      public void enableFieldsProcedimento(){
        this.changeStatusFieldsProcedimento(true);
          
      }
      
      
      
      private void changeStatusFieldsProcedimento(boolean status){
          jTextFieldUsuarioCns.setEnabled(status);
          jTextFieldUsuarioNome.setEnabled(status);
          jTextFieldUsuarioSexo.setEnabled(status);
          jTextFieldUsarioDatNasc.setEnabled(status);
          jTextFieldUsuarioCodMunicip.setEnabled(status);
          jTextFieldUsuarioCodNac.setEnabled(status);
          jComboBoxUsuarioRacaCor.setEnabled(status);
          jTextFieldProcDataAtend.setEnabled(status);
          jTextFieldProcCod.setEnabled(status);
          jTextFieldProcQuant.setEnabled(status);
          jComboBoxUsuarioClassificacao.setEnabled(status);
          jComboBoxUsuarioServico.setEnabled(status);
          jTextFieldProcCID.setEnabled(status);
          jComboBoxProcCaraterAtend.setEnabled(status);
          jTextFieldProcNumAut.setEnabled(status);
          jTable1.setEnabled(status);
          jButtonLimpar.setEnabled(status);  
          jButtonIncluir.setEnabled(status);        
          
      }
      
      /**
       *Preenche um modelo ProcedimentoRealizado com os campos do cabeçalho da tela  
       */
      private void fillHeaderModelProcedimentoRealizado(ProcedimentoRealizado p){
          p.getProcedimentoRealizadoPK().setCnesUnidade(jTextFieldCnes.getText());
          p.getProcedimentoRealizadoPK().setCnsMedico(jTextFieldCnsProfiss.getText());
          p.getProcedimentoRealizadoPK().setCboMedico(jTextFieldCBO.getText());
          p.getProcedimentoRealizadoPK().setCompetencia(jTextFieldAno.getText()+jTextFieldMes.getText());
          p.getProcedimentoRealizadoPK().setNumeroFolha(jTextFieldFolha.getText());
          
      }
      
      /**
       * Pega os valores dos campos que ainda não foram colocados no modelo procedimentoRealizado
       */
      private void getValuesOfFieldsForModel(){
        Procedimento procedimento = new Procedimento();
       
        String competencia = jTextFieldAno.getText()+jTextFieldMes.getText();
         
         int indexCarater = jComboBoxProcCaraterAtend.getSelectedIndex();
         CaraterAtendimento c = (CaraterAtendimento) this.objectComboBoxModelCaraterAtend.getData().get(indexCarater);
         int indexRaca = jComboBoxUsuarioRacaCor.getSelectedIndex();
         Diversas d = (Diversas) this.objectComboBoxModelRacaCor.getData().get(indexRaca);
        //String dataNasc  =     DateUtil.parseToYearMonthDay(jTextFieldUsarioDatNasc.getText());
        //String dataAtend  =    DateUtil.parseToYearMonthDay(jTextFieldProcDataAtend.getText());
        this.procedimentoRealizado.setCnsPaciente(jTextFieldUsuarioCns.getText());
        this.procedimentoRealizado.setSexoPaciente(jTextFieldUsuarioSexo.getText());
        //this.procedimentoRealizado.setDataNascimentoPaciente(dataNasc);  
        this.procedimentoRealizado.setCodigoIBGECidadePaciente(jTextFieldUsuarioCodMunicip.getText()); 
        this.procedimentoRealizado.setNacionalidadePaciente(jTextFieldUsuarioCodNac.getText());
        this.procedimentoRealizado.setRacaPaciente(d.getDiversasPK().getCodigoItemTabela()); 
        if(this.procedimentoRealizado.getRacaPaciente().equals(Diversas.COD_RACA_COR_INDIGENA)){
            this.procedimentoRealizado.setEtniaPaciente(jTextFieldUsuarioCodEtnia.getText());
        }
        
        //this.procedimentoRealizado.setDataAtendimento(dataAtend);
        this.procedimentoRealizado.setCaracterizacaoAtendimento(c.getCodigo());
       
        this.procedimentoRealizado.getProcedimentoRealizadoPK().setCompetencia(competencia);
        this.procedimentoRealizado.getProcedimentoRealizadoPK().setNumeroFolha(jTextFieldFolha.getText());
        this.procedimentoRealizado.getProcedimentoRealizadoPK().setSequenciaFolha(String.valueOf(sequencia));
        
       
        
        Character digitoVerificador = this.procedimentoRealizado.getCodigoProcedimento().charAt(9);
        procedimento.getProcedimentoPk().setId(this.procedimentoRealizado.getCodigoProcedimento().substring(0,9));
        procedimento.getProcedimentoPk().setCompetencia(this.procedimentoRealizado.getProcedimentoRealizadoPK().getCompetencia());
        procedimento.setDigitoVerificador(digitoVerificador);
        //realiza uma busca pelo procedimento
        Procedimento pEncontrado = procedimentoController.findEqual(procedimento);
        if(pEncontrado!=null){
            String  tipo = pEncontrado.typeProcedimento();    
            //seta o tipo do procedimento (BPA ou BPAI)
            this.procedimentoRealizado.setOrigemProcedimento(tipo);
        }
      }
      
      /**
       * Insere os procedimentos nas bases de dados e todos as outras
       * entidades, como paciente, Medico e MedicoCboCnes
       */
      private void insertInDatabase(){
          
         
         //insere o modelo no banco de dados do nosso banco de dados
          List<ProcedimentoRealizado> l=this.tableModelDados.getListWithOutEmptyElements();
          
          //vai pegar os médicos e os pacientes
          int size=l.size();
          ProcedimentoRealizado p=null;
          for(int i=0;i<size;i++){
              p=l.get(i);
              //pega o paciente
              Paciente pa=p.getPaciente();
              //se tem um CNS vai gravar no banco de dados
              if(!pa.getCns().isEmpty()){
                    this.setPaciente.add(pa);
              }
              //pega o médico
              Medico m=p.getMedico();
              //caso nao exista um nome preenche com espaços
              m.setNome( m.getNome()==null?"      ":m.getNome());
              this.setMedico.add(m);
              //pega o MedicoCboCnes e adiciona no Set
              this.setMedicoCboCnes.add(p.getMedicoCboCnes());
              //cria um procedimentoRealizado a ser salvo no bando do sistema
              this.lBi.add(new BIProcedimentoRealizado(p));
          }
          //salva todos os pacientes ou senão atualiza
          this.pacienteController.merge(new ArrayList<Paciente>(this.setPaciente));
          //salva todos os médicos ou senão atualiza
          this.medicoController.merge(new ArrayList<Medico>(this.setMedico));
          //salva todos os médicosCbosCnes ou senão atualiza
          this.medicoCboCnesController.merge(new ArrayList<MedicoCboCnes>(this.setMedicoCboCnes));
          //salva todos os procedimentos no banco próprio do sistema
          this.bIProcedimentoRealizadoController.merge(this.lBi);
          
          
          
          
          //vai limpar os Sets
          this.setPaciente.clear();
          this.setMedico.clear();
          this.setMedicoCboCnes.clear();
      }
      
      /**
       * Limpa todos os campos da tela
       */
      private void clearFields(){
        //jTextFieldAno.setText("");
        //jTextFieldCBO.setText("");
        //jTextFieldCnes.setText("");
        //jTextFieldCnsProfiss.setText("");
        //jTextFieldFolha.setText("");
       // jTextFieldMes;
        //jTextFieldNomeProfiss.setText("");
        jTextFieldProcCID.setText("");
        jTextFieldProcDescriDoenca.setText("");
        jTextFieldProcCod.setText("");
        jTextFieldProcDataAtend.setText("");
        jTextFieldProcDescriDoenca.setText("");
        jTextFieldProcDescricao.setText("");
        jTextFieldProcNumAut.setText("");
        jTextFieldProcQuant.setText("");
        jTextFieldUsarioDatNasc.setText("");
        jTextFieldUsuarioCns.setText("");
        jTextFieldUsuarioCodEtnia.setText("");
        jTextFieldUsuarioCodMunicip.setText("");
        //jTextFieldUsuarioCodNac.setText("");
        jTextFieldUsuarioDescEtnia.setText("");
        jTextFieldUsuarioNome.setText("");
        jTextFieldUsuarioNomeMunicip.setText("");
        jTextFieldUsuarioNomeNac.setText("");
        jTextFieldUsuarioSexo.setText("");
        
        jComboBoxProcCaraterAtend.setSelectedIndex(0);
        jComboBoxUsuarioRacaCor.setSelectedIndex(0);

      }
      
      /**
       * Dada um procedimento com a folha, cbo, cnes, cns e competência, vai buscar outros procedimentos, caso exista.
       * A tabela é preenchida e os campos também.
       * @param procedimentoRealizado 
       */
      public void findAllProcedimentosFolha(ProcedimentoRealizado procedimentoRealizado){
          List<BIProcedimentoRealizado> t=this.bIProcedimentoRealizadoController.findAllEqual(new BIProcedimentoRealizado(procedimentoRealizado));
          List<ProcedimentoRealizado> l=this.bIProcedimentoRealizadoController.parserBIProcedimentoRealizadoToProcedimentoRealizado(t);
          t.clear();
          //muda a lista presente na tabela
          int size=l.size();
           if(size>0){
               for(int i=size;i<20;i++){
                   ProcedimentoRealizado p=new ProcedimentoRealizado();
                   p.setProcedimentoRealizadoPK(new ProcedimentoRealizadoPK());
                   p.getProcedimentoRealizadoPK().setSequenciaFolha(""+(i+1));
                   l.add(p);
               }
               //limpa a lista atual
               this.tableModelDados.clean();
               //seta a nova lista
               this.tableModelDados.getList().addAll(l);
               //atualiza a referência o procedimentoRealizado "global"
               this.procedimentoRealizado=CadastroIndividualizado.this.tableModelDados.getCloneElementList(0);
               this.jTable1.setRowSelectionInterval(0, 0);
               this.fillFields(CadastroIndividualizado.this.procedimentoRealizado, true);
           }
      
      }
      /**
       *Preenche os campos da tela baseado em um objeto procedimento realizado passado 
       */
      private void  fillFields(ProcedimentoRealizado p,boolean flag){
          //se o flag for true o cabecalho também sera preenchido
          if(flag==true){
              jTextFieldCnes.setText(p.getProcedimentoRealizadoPK().getCnesUnidade());
              jTextFieldCnsProfiss.setText(p.getProcedimentoRealizadoPK().getCnsMedico());
              jTextFieldNomeProfiss.setText(p.getNomeProfissional());
              jTextFieldCBO.setText(p.getProcedimentoRealizadoPK().getCboMedico());
              if(p.getProcedimentoRealizadoPK().getCompetencia()!=null){
                jTextFieldMes.setText(p.getProcedimentoRealizadoPK().getCompetencia().substring(4));
                jTextFieldAno.setText(p.getProcedimentoRealizadoPK().getCompetencia().substring(0, 4));
              }
              jTextFieldFolha.setText(p.getProcedimentoRealizadoPK().getNumeroFolha());
             
              
          }
          String sequenciaFolha = p.getProcedimentoRealizadoPK().getSequenciaFolha();
          jLabelUsuarioSeq.setText(sequenciaFolha);
          jLabelProcSeq.setText(sequenciaFolha);
          jTextFieldUsuarioCns.setText(p.getCnsPaciente());
          jTextFieldUsuarioNome.setText(p.getNomePaciente());
          jTextFieldUsuarioSexo.setText(p.getSexoPaciente());
          jTextFieldUsarioDatNasc.setText(DateUtil.parseToDayMonthYear(p.getDataNascimentoPaciente(),true));
          jTextFieldUsuarioCodMunicip.setText(p.getCodigoIBGECidadePaciente());
         // jTextFieldUsuarioCodNac.setText(p.getNacionalidadePaciente());
          
          //jComboBoxUsuarioRacaCor.setSelectedItem();
          if(p.getRacaPaciente()!=null)
            this.selectItemJComboBoxRacaCor(p.getRacaPaciente());
          else
            this.selectItemJComboBoxRacaCor(Diversas.COD_RACA_COR_SEM_INFORMACAO);  
          if((jComboBoxUsuarioRacaCor.getSelectedItem()!=null) && (jComboBoxUsuarioRacaCor.getSelectedItem().toString().substring(0, 2).equals(Diversas.COD_RACA_COR_INDIGENA))){
              jTextFieldUsuarioCodEtnia.setText(p.getEtniaPaciente());
          }
          jTextFieldProcDataAtend.setText(DateUtil.parseToDayMonthYear(p.getDataAtendimento(),true));
          jTextFieldProcCod.setText(p.getCodigoProcedimento());
          if(p.getQuantidadeRealizada()==null){
              jTextFieldProcQuant.setText("");
          }else
            jTextFieldProcQuant.setText(String.valueOf(p.getQuantidadeRealizada()));
          
          jTextFieldProcCID.setText(p.getCidDoencaprocedimento());
          
          if(p.getCaracterizacaoAtendimento()!=null){
            this.selectItemJComboBoxCaraterAtend(p.getCaracterizacaoAtendimento());
          }
          else{
            this.selectItemJComboBoxCaraterAtend(CaraterAtendimento.SEM_INFORMACAO);
          }
          if(p.getCodigoServico()!=null){
               focusLostComboboxServico();
               this.selectItemJComboBoxServico(p.getCodigoServico());
               
          }else{
             initComboBoxServico();
          }
          
          if(p.getCodigoClassificacaoServico()!=null){
              //this.selectItemJComboBoxClassificacao(p.getCodigoServico()+p.getCodigoClassificacaoServico());
          
          }else{
            initComboBoxClassificacao();
           }
          jTextFieldProcNumAut.setText(p.getNumeroAutorizacao());
          
          
          jTextFieldUsuarioNomeNac.setText("");
          jTextFieldProcDescricao.setText("");
          jTextFieldUsuarioNomeMunicip.setText("");
          jTextFieldProcDescriDoenca.setText("");
          
      }
    
      private void selectItemJComboBoxRacaCor(String codigoItem){
          Diversas d= new Diversas(new DiversasPK(Diversas.TABELA_COR_INDIVIDUO,codigoItem ));
          
//          for(Diversas di: this.objectComboBoxModelRacaCor.getData()){
//              if(di.equals(di)){
//                  this.objectComboBoxModelRacaCor.setSelectedObject(di);
//              }
//          }
//          
          this.objectComboBoxModelRacaCor.setSelectedObject(d);
      }
      
      private void selectItemJComboBoxCaraterAtend(String codigoItem){
          CaraterAtendimento c= new CaraterAtendimento(codigoItem,"");
          
          this.objectComboBoxModelCaraterAtend.setSelectedObject(c);
      }
      
       private void selectItemJComboBoxServico(String codigoItem){
           Diversas d= new Diversas(new DiversasPK(Diversas.TABELA_SERVICO,codigoItem ));
          
          this.objectComboBoxModelServico.setSelectedObject(d);
      }
       
       private void selectItemJComboBoxClassificacao(String codigoItem){
          Diversas d= new Diversas(new DiversasPK(Diversas.TABELA_CLASSIFICACAO_SERVICO,codigoItem));
          
          this.objectComboBoxModelClassificaoServico.setSelectedObject(d);
      } 
          
      //métodos focusLost
      
      private void focusLostComboboxServico(){
           String codigo=this.jTextFieldProcCod.getText();
           this.procedimentoRealizado.setCodigoProcedimento(codigo);
           HashMap<String, Object> res=new HashMap<String, Object> ();
           res.put("procedimentoServicoPK.codigoProcedimento", this.procedimentoRealizado.getCodigoProcedimento().substring(0, 9));
           res.put("procedimentoServicoPK.competencia", CadastroIndividualizado.this.procedimentoRealizado.getProcedimentoRealizadoPK().getCompetencia());
           //preenche os combobox
           if(this.procedimentoServicoController.findEqual(res)!=null){

               //busca as classificaçoes dos serviços que o procedimento tem
               List<Diversas> d=this.diversasController.findAllClassificacaoServico(CadastroIndividualizado.this.procedimentoRealizado);
               this.objectComboBoxModelClassificaoServico.setData(d);
               //seleciona a primeira classificação
               if(!d.isEmpty()){
                    this.jComboBoxUsuarioClassificacao.setSelectedIndex(0);
               }
               //busca todos os serviços que o procedimento tem
               d=this.diversasController.findAllServicos(CadastroIndividualizado.this.procedimentoRealizado);
               this.objectComboBoxModelServico.setData(d);
               //seleciona o primeiro serviço
               if(!d.isEmpty()){
                    this.jComboBoxUsuarioServico.setSelectedIndex(0);
               }

               }
      }
      
      private void focusLostFieldUsuarioCns(){
            CadastroIndividualizado.this.procedimentoRealizado.setCnsPaciente(this.jTextFieldUsuarioCns.getText());
            //pega um paciente
            Paciente p= new Paciente(this.procedimentoRealizado.getCnsPaciente());
            if(!p.getCns().isEmpty()){
                Paciente pa=CadastroIndividualizado.MAP_PACIENTE.get(p.getCns());
                //não achou nos pacientes já encontrados
                if(pa==null){
                    //pega no banco de dados
                    pa=this.pacienteController.findEqual(p);
                }
                if(pa!=null){
                    CadastroIndividualizado.MAP_PACIENTE.put(pa.getCns(), pa);
                    this.jTextFieldUsuarioNome.setText(pa.getNome());
                    this.jTextFieldUsuarioCodEtnia.setText(pa.getEtnia());
                    this.jTextFieldUsuarioCodMunicip.setText(pa.getCodigoIbgeCidade());
                    this.jTextFieldUsuarioCodNac.setText(pa.getNacionalidade());
                    this.jTextFieldUsuarioSexo.setText(pa.getSexo().toString());
                    this.jTextFieldUsarioDatNasc.setText(DateUtil.parseToDayMonthYear(pa.getDataNascimento(), false));
                }
            }
      }

  private void focusLostFieldCnes(){
        String cnes=this.jTextFieldCnes.getText();
        this.procedimentoRealizado.getProcedimentoRealizadoPK().setCnesUnidade(cnes);
        //vai buscar a equipe caso exista
        //criação de restrições
        String competencia=this.procedimentoRealizado.getProcedimentoRealizadoPK().getCompetencia();
        
        HashMap<String,Object> res= new HashMap<String, Object>();
        res.put("equipePK.cnes", cnes);
        res.put("equipePK.competencia", competencia);
        List<Equipe> equipes=this.equipeController.findAllEqual(res);
        //devolveu algo
        if(!equipes.isEmpty()){
            this.objectComboBoxModelEquipe.setSelectedItem(equipes.get(0));
            this.objectComboBoxModelEquipe.setData(equipes);
        }
  }


}
