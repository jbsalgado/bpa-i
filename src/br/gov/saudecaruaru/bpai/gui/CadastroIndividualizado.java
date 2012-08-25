
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.controller.DoencaController;
import br.gov.saudecaruaru.bpai.business.controller.GestorCompetenciaController;
import br.gov.saudecaruaru.bpai.business.controller.MedicoController;
import br.gov.saudecaruaru.bpai.business.controller.MunicipioController;
import br.gov.saudecaruaru.bpai.business.controller.PacienteController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.CaraterAtendimento;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.gui.validators.*;
import br.gov.saudecaruaru.bpai.util.ProcedimentoRealizadoTableModel;
import br.gov.saudecaruaru.bpai.util.Search;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Junior Pires
 */
public class CadastroIndividualizado extends javax.swing.JFrame implements TelaCadastroI{
    
     private MaskFormatter mCBO=null; 
     private MaskFormatter mData=null; 
     private MaskFormatter mNome=null; 
     private MaskFormatter mMes=null; 
     private MaskFormatter mCodMun=null; 
     private MaskFormatter mCodNac=null; 
     private MaskFormatter mCodProc=null; 
     private MaskFormatter mCID=null; 
     private MaskFormatter mAno=null; 
     private MaskFormatter mFolha=null; 
     private MaskFormatter mEtnia=null; 
     private MaskFormatter mNumAutoriz=null; 
     private MaskFormatter mCNS=null; 
     
     private Diversas diversas;
     private DiversasPK diversasPk;
     //controladores
     private DiversasController diversasController;
     private MedicoController medicoController;
     private PacienteController pacienteController;
     private MunicipioController municipioController;
     private ProcedimentoController procedimentoController;
     private DoencaController doencaController;
     
     private ProcedimentoRealizado procedimentoRealizado;
     private GestorCompetenciaController gestorCompetenciaController;
     
     private ProcedimentoRealizadoTableModel tableModelDados;
   
    
     
 
     
    
     
    /**
     * Creates new form CadastroIndividualizado
     */
    public CadastroIndividualizado() {
        //inicializa as opcoes do JOptionPane
        UIManager.put("OptionPane.yesButtonText", "Sim");     
        UIManager.put("OptionPane.noButtonText", "Não");   
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        
        initComponents();
        
        //instancia o modelo usado para o cadastro
        this.procedimentoRealizado = new ProcedimentoRealizado();
         
        this.gestorCompetenciaController = new GestorCompetenciaController(); 
        this.diversasController = new DiversasController();
        this.medicoController= new MedicoController();
        this.pacienteController=new PacienteController();
        this.municipioController= new MunicipioController();
        this.procedimentoController= new ProcedimentoController();
        this.doencaController=new DoencaController();
        
        
        //instancia o modelo DiversasPk
        diversas = new  Diversas();
        diversasPk = new DiversasPK();
        diversas.setDiversasPK(diversasPk);
       
        myInitComponents();
        
        //seta o estado do frame para ocupar toda a tela
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void myInitComponents(){
        
     
       this.jPanel2.setSize(1200, 400);
       this.jPanel1.setSize(1200,this.jPanel1.getSize().height);
       this.jSeparator1.setSize(1200,this.jSeparator1.getSize().width);
        this.jSeparator2.setSize(1200,this.jSeparator2.getSize().width);
       System.out.print(this.jPanel1.getSize());
       this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
        this.initComboBoxs();
        
        //incializa os campos com busca por F2
        this.initKeyPresseds();
        
        this.initJTableDados();
        
        //adicionando listeners
        this.addListenersFields();
        
        //this.jPanel2.setp
        
        //adicionando listeners aos campos 
        addListenersFields();
        
        //desabilita alguns campos do usuario
        jTextFieldUsuarioNomeMunicip.setEnabled(false);
        jTextFieldUsuarioNomeNac.setEnabled(false);
        jTextFieldUsuarioDescEtnia.setEnabled(false);
        
        //desabilita alguns campos do procedimento
        jTextFieldProcDescricao.setEnabled(false);
        //jTextFieldProcDescricaoProc.setText("ANALISE DE ALGUMA COISA");
        jTextFieldProcDescriDoenca.setEnabled(false);
        
        //inicializando campos 
        //inicializando competencia
        String competencia = gestorCompetenciaController.getCompetenciaAtual();
        jTextFieldMes.setText(competencia.substring(4));
        jTextFieldAno.setText(competencia.substring(0, 4));
        //seta a competencia vinda do banco
        procedimentoRealizado.getProcedimentoRealizadoPK().setCompetencia(competencia);
        //inicializando nacionalidade: BRASIL
        jTextFieldUsuarioCodNac.setText(Diversas.CODIGO_NACIONALIDADE_BRASIL);
        procedimentoRealizado.setNacionalidadePaciente(Diversas.CODIGO_NACIONALIDADE_BRASIL);
        //desabilitando etnia
        jTextFieldUsuarioCodEtnia.setEnabled(false);
        
        
        //atribui mascaras a campos de texto
        
        //jTextFieldCBO =  new JFormattedTextField(getMCBO());
         
        //atribui validadores
        jTextFieldNomeProfiss.setInputVerifier(new OnlyLettersVerifier(this, "Nome"));
        jTextFieldUsuarioNome.setInputVerifier(new OnlyLettersVerifier(this, "Nome"));
        jTextFieldProcQuant.setInputVerifier(new OnlyNumbers(this,"Quantidade"));
        jTextFieldCnsProfiss.setInputVerifier(new CnsVerifier(this,"CNS"));
        jTextFieldUsuarioCns.setInputVerifier(new CNSUsuarioVerifier(this, "CNS"));
        jTextFieldCBO.setInputVerifier(new CBOVerifier(this, "CBO"));
        jTextFieldUsuarioCodNac.setInputVerifier(new NacionalidadeVerifier(this, "Nacionalidade",jTextFieldUsuarioNomeNac));
        jTextFieldUsuarioCodMunicip.setInputVerifier(new MunicipioVerifier(this,"Municipio",jTextFieldUsuarioNomeMunicip));
        jTextFieldUsuarioCodEtnia.setInputVerifier(new EtniaVerifier(this,"Etnia", jTextFieldUsuarioDescEtnia));
        jTextFieldProcCod.setInputVerifier(new ProcedimentoVerifier(this, "Procedimento", jTextFieldProcDescricao,this));
        jTextFieldProcCID.setInputVerifier(new DoencaVerifier(this, "CID", jTextFieldProcDescriDoenca,this));
        jComboBoxProcCaraterAtend.setInputVerifier(new CaraterAtendVerifier(this,"Caráter de Atendimento"));
        jTextFieldUsarioDatNasc.setInputVerifier(new DataVerifier(this, "Data de Nascimento"));
        jTextFieldProcQuant.setInputVerifier(new QuantProcedimentoVerifier(this, "Quantidade",this));
        jTextFieldProcDataAtend.setInputVerifier(new DataAtendimentoVerifier(this, "Data Atendimento",this));
        jTextFieldAno.setInputVerifier(new CompetenciaVerifier(this,"Ano", jTextFieldMes));
        jTextFieldFolha.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField textField = (JTextField) input;
                String valor = textField.getText().trim();
                if (valor.equals("000") || valor.isEmpty()) {  
                      JOptionPane.showMessageDialog(CadastroIndividualizado.this," Folha Inválida!",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                //seta cor vermelha
                textField.setBackground(Color.RED);  
                return false;  
                } 
                //seta cor branca
                textField.setBackground(Color.WHITE); 
                return true;
            }
        });
        
        
        jTextFieldMes.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField mes = (JTextField) input;
                //expressão regular para mês
                Pattern p = Pattern.compile("([0-9]|0[1-9]|[1][0-2])");  
                Matcher m = p.matcher(mes.getText());  
                if (!m.find()) {  
                      JOptionPane.showMessageDialog(CadastroIndividualizado.this," Mês Inválido!",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                //seta cor vermelha
                mes.setBackground(Color.RED);  
                return false;  
                } 
                //seta cor branca
                mes.setBackground(Color.WHITE); 
                return true;
           }
        });
        
        jTextFieldUsuarioSexo.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField sexo = (JTextField) input;
                //expressão regular para sexo (só permite M ou F)
                Pattern p = Pattern.compile("^[M|F]$");  
                Matcher m = p.matcher(sexo.getText());  
                if (!m.find()) {  
                      JOptionPane.showMessageDialog(CadastroIndividualizado.this," Sexo Inválido!",   
                "Erro de validação!", JOptionPane.ERROR_MESSAGE);  
                sexo.setBackground(Color.RED); 
                return false;  
                } 
                sexo.setBackground(Color.WHITE); 
                return true;
           }
        });
    }
   
    private void initKeyPresseds(){
        //para cns do médico
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
            }
             
        
        });
        
        //para pacientes/cnd do paciente
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
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.medicoController, "cns", "nome","CNS", "Nome");
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
        
        return SearchGeneric.getInstance().initModeSearch(CadastroIndividualizado.this.pacienteController, "cns", "nome","CNS", "Nome");
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
                                                        "Código", "Descrição");
    }
    
    
        
    private MaskFormatter getMCBO(){
			if(mCBO==null){
				try {
					mCBO = new MaskFormatter("######");
					mCBO.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mCBO;
		}
    private MaskFormatter getMMes(){
			if(mMes==null){
				try {
					mMes = new MaskFormatter("##");
					mMes.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mMes;
		}
    private MaskFormatter getMAno(){
			if(mAno==null){
				try {
					mAno = new MaskFormatter("####");
					mAno.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mAno;
		}
             private MaskFormatter getMData(){
			if(mData==null){
				try {
					mData = new MaskFormatter("##/##/####");
					mData.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mData;
		}
             private MaskFormatter getMCodNac(){
			if(mCodNac==null){
				try {
					mCodNac = new MaskFormatter("###");
					mCodNac.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mCodNac;
		}
             
            private MaskFormatter getMCodMun(){
			if(mCodMun==null){
				try {
					mCodMun = new MaskFormatter("######");
					mCodMun.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mCodMun;
		}
            
             private MaskFormatter getMCodProc(){
			if(mCodProc==null){
				try {
					mCodProc = new MaskFormatter("##########");
					mCodProc.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mCodProc;
		}
             private MaskFormatter getMCID(){
			if(mCID==null){
				try {
					mCID = new MaskFormatter("****");
					mCID.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mCID;
		}
             
              private MaskFormatter getMFolha(){
			if(mFolha==null){
				try {
					mFolha = new MaskFormatter("###");
					mFolha.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mFolha;
		}
              
              private MaskFormatter getMEtnia(){
			if(mEtnia==null){
				try {
					mEtnia= new MaskFormatter("####");
					mEtnia.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mEtnia;
		}
              
              private MaskFormatter getMNumAutoriz(){
			if(mNumAutoriz==null){
				try {
					mNumAutoriz = new MaskFormatter("*************");
					mNumAutoriz.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mNumAutoriz;
		}
              private MaskFormatter getMCNS(){
			if(mCNS==null){
				try {
					mCNS = new MaskFormatter("###############");
					mCNS.setPlaceholder("");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
			return mCNS;
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
        jSeparator1 = new javax.swing.JSeparator();
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
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldCnes = new javax.swing.JFormattedTextField();
        jTextFieldCnsProfiss = new javax.swing.JFormattedTextField();
        jTextFieldMes = new javax.swing.JFormattedTextField();
        jTextFieldAno = new javax.swing.JFormattedTextField();
        jTextFieldFolha = new javax.swing.JFormattedTextField();
        jTextFieldCBO = new javax.swing.JFormattedTextField();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("CNES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("CNS Profissional");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Nome Profissional");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel5.setText("Mês/Ano");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel6.setText("Folha");

        jTextFieldNomeProfiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeProfissActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel7.setText(" /");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel9.setText("CNS");

        jLabel8.setText("Usuário Sequência :");

        jLabelUsuarioSeq.setText("01");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel10.setText("Nome ");

        jTextFieldUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel4.setText("Sexo");

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel11.setText(" F/M");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel12.setText("Dt. Nascimento");

        jTextFieldUsuarioNomeNac.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioNomeNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeNacActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel14.setText("Nacionalidade");

        jTextFieldUsuarioNomeMunicip.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioNomeMunicip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeMunicipActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel13.setText("Município de Residência");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14));
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel17.setText("Etnia");

        jTextFieldUsuarioCns.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###############"))));

        try {
            jTextFieldUsuarioSexo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("*")));
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
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioCodEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsuarioDescEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(jTextFieldUsuarioNomeNac, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabelUsuarioSeq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUsuarioCns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jTextFieldUsuarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsarioDatNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuarioNomeMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioNomeNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioCodMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioCodNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel20.setText("Dt. Atendimento");

        jTextFieldProcQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcQuantActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel22.setText("Quantidade");

        jTextFieldProcDescriDoenca.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldProcDescriDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcDescriDoencaActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel23.setText("Código");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14));
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

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel19.setText("Nº Autorização");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel18.setText("Caráter Atendimento");

        jButtonIncluir.setFont(new java.awt.Font("Tahoma", 0, 14));
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

        jButtonLimpar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonLimpar.setText("Limpar");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelProcSeq, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jTextFieldProcDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldProcCod, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)
                                        .addComponent(jTextFieldProcDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldProcQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldProcCID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(35, 35, 35)
                                        .addComponent(jTextFieldProcDescriDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxProcCaraterAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldProcNumAut))))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabelProcSeq))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel23))
                                .addGap(26, 26, 26))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldProcDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldProcDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldProcCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldProcQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcDescriDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProcCaraterAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcNumAut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        try {
            jTextFieldCnes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldCnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCnesActionPerformed(evt);
            }
        });

        try {
            jTextFieldCnsProfiss.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jTextFieldMes.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##"))));
        jTextFieldMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMesActionPerformed(evt);
            }
        });

        jTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));

        jTextFieldFolha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("###"))));

        jTextFieldCBO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));

        jLabel21.setText("CBO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldCnes, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCnsProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jTextFieldCBO, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
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
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCnsProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldCnesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCnesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCnesActionPerformed

    private void jTextFieldMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMesActionPerformed

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
        // TODO add your handling code here:
        this.procedimentoRealizado.getProcedimentoRealizadoPK().setSequenciaFolha("0");
        this.tableModelDados.setValueAt(procedimentoRealizado, 0);
        System.out.println(this.procedimentoRealizado);
    }//GEN-LAST:event_jButtonIncluirMouseClicked
                                          

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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroIndividualizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroIndividualizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroIndividualizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroIndividualizado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new CadastroIndividualizado().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JComboBox jComboBoxProcCaraterAtend;
    private javax.swing.JComboBox jComboBoxUsuarioRacaCor;
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
    private javax.swing.JSeparator jSeparator1;
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



    //classe validadora para o campo CNSUsuario
    private class CNSUsuarioVerifier extends CnsVerifier{
        private Component component=null;
        public CNSUsuarioVerifier(Component component, String fieldName) {
            super(component, fieldName);
            this.component=component;
        }

        @Override
        public boolean verify(JComponent input) {
             JTextComponent txtField = (JTextField) input; 
             String valor = txtField.getText().trim();
             if(!valor.isEmpty()){
             if(valor.equals(jTextFieldCnsProfiss.getText())){
                  JOptionPane.showMessageDialog(this.component," CNS do Usuário é igual ao CNS do profissional!", 
                "Erro de validação!", JOptionPane.ERROR_MESSAGE); 
                txtField.setBackground(Color.RED);
                return false;
             }
            return super.verify(input);
            }
             return true;
        }
}
    
    private void initComboBoxs(){
        //inicializar comboBox Cor
        //seta no modelo Diversas o codigo referente a tabela Cor no banco
        diversas.getDiversasPK().setCodigoTabela(Diversas.TABELA_COR_INDIVIDUO);
        //realiza a busca no banco 
        List<Diversas> list = diversasController.findAllEqual(diversas);
        //cria um vetor de string para popular o combobox
        String[] comboListCor = new String[list.size()];
        //preenche o vetor de String com os valores retornados do banco
        for (int i=0;i<list.size();i++) {
            //concatena o codigo e a descriacao da Cor e atribui ao vetor de String
            comboListCor[i] = list.get(i).getDiversasPK().getCodigoItemTabela()+list.get(i).getDescricaoItemTabela();
        }
        //cria o modelo do combobox com as informações do banco
        ComboBoxModel model = new DefaultComboBoxModel(comboListCor);
        //seta o modelo no combobox Cor
        jComboBoxUsuarioRacaCor.setModel(model);
        
        
      
        //inicializar comboBox Carater de Atendimento
        String[] comboListCaraterAtend ={CaraterAtendimento.SEM_INFORMACAO.desc(),CaraterAtendimento.ELETIVO.desc(),CaraterAtendimento.URGENCIA.desc(),CaraterAtendimento.ACIDENTE_LOCAL.desc(),
                                         CaraterAtendimento.ACIDENTE_EXTERNO.desc(),CaraterAtendimento.ACIDENTE_OUTROS.desc(),CaraterAtendimento.LESOES_OUTRAS.desc()};
        
        //cria o modelo do combobox com as informações do banco
        ComboBoxModel modelCarater = new DefaultComboBoxModel(comboListCaraterAtend);
        //seta o modelo no combobox Cor
        jComboBoxProcCaraterAtend.setModel(modelCarater);
    }
    
    
   
    
     
      
      
      private void addListenersFields(){
          
          
          jComboBoxUsuarioRacaCor.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                 String itemRacaCor =  e.getItem().toString();
                       
                     
                       //caso a cor/raca seja indigena habilita o campo etnia e faz ele ganhar o foco
                       if(itemRacaCor.substring(0, 2).equals(Diversas.COD_RACA_COR_INDIGENA)){
                           jTextFieldUsuarioCodEtnia.setEnabled(true);
                          // jTextFieldUsuarioCodEtnia.requestFocus();
                           
                       }else{
                           jTextFieldUsuarioCodEtnia.setEnabled(false);
                           
                       }
               
            }
        });
          
          
          
          jTextFieldCnes.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
               procedimentoRealizado.getProcedimentoRealizadoPK().setCnesUnidade(jTextFieldCnes.getText());
              
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
            
               procedimentoRealizado.getProcedimentoRealizadoPK().setCompetencia(((JTextField)e.getComponent()).getText()+jTextFieldMes.getText());
            }
        }); 
        
         jTextFieldFolha.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.getProcedimentoRealizadoPK().setNumeroFolha(((JTextField)e.getComponent()).getText());
               
               if(jTextFieldFolha.getInputVerifier().shouldYieldFocus(jTextFieldFolha)){
                            jTextFieldCnes.setEnabled(false);
                            jTextFieldCnsProfiss.setEnabled(false);
                            jTextFieldNomeProfiss.setEnabled(false);
                            jTextFieldCBO.setEnabled(false);
                            jTextFieldMes.setEnabled(false);
                            jTextFieldAno.setEnabled(false);
                            jTextFieldFolha.setEnabled(false);
                            
                            jTextFieldUsuarioCns.requestFocus();
                            
                            
                        }
            }
        });
         
          jTextFieldUsuarioCns.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setCnsPaciente(((JTextField)e.getComponent()).getText());
            }
        });
          
           jTextFieldUsuarioNome.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setNomePaciente(((JTextField)e.getComponent()).getText());
            }
        });
           
            jTextFieldUsuarioSexo.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setSexoPaciente(((JTextField)e.getComponent()).getText());
            }
        });
          
            
             jTextFieldUsarioDatNasc.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setDataNascimentoPaciente(((JTextField)e.getComponent()).getText());
            }
        });
            
           jTextFieldUsuarioCodMunicip.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setCodigoIBGECidadePaciente(((JTextField)e.getComponent()).getText());
            }
        });
           
            jTextFieldUsuarioCodNac.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setNacionalidadePaciente(((JTextField)e.getComponent()).getText());
            }
        });
             jComboBoxUsuarioRacaCor.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setRacaPaciente(((JComboBox)e.getComponent()).getSelectedItem().toString());
            }
        });
             
          jTextFieldUsuarioCodEtnia.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setEtniaPaciente(((JTextField)e.getComponent()).getText());
            }
        });
          
           jTextFieldProcDataAtend.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.getProcedimentoRealizadoPK().setDataAtendimento(((JTextField)e.getComponent()).getText());
            }
        });
           
         jTextFieldProcCod.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.getProcedimentoRealizadoPK().setCodigoProcedimento(((JTextField)e.getComponent()).getText());
            }
        });
          
          jTextFieldProcQuant.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setQuantidadeRealizada(Double.valueOf(((JTextField)e.getComponent()).getText()));
            }
        });
          
         jTextFieldProcCID.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setCidDoencaprocedimento(((JTextField)e.getComponent()).getText());
            }
        });
         
          jComboBoxProcCaraterAtend.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setCaracterizacaoAtendimento(((JComboBox)e.getComponent()).getSelectedItem().toString());
            }
        });
          
         jTextFieldProcNumAut.addFocusListener(new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
               
            }

            @Override
            public void focusLost(FocusEvent e) {
            
               procedimentoRealizado.setNumeroAutorizacao(((JTextField)e.getComponent()).getText());
            }
        });
          
        
      }
    
    



}
