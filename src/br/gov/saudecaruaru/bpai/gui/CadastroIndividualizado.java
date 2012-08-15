/*//GEN-FIRST:event_jTextFieldUsuarioCodMunicipActionPerformed
 * To change this template, choose Tools | Templates//GEN-LAST:event_jTextFieldUsuarioCodMunicipActionPerformed
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.controller.DiversasController;
import br.gov.saudecaruaru.bpai.business.model.CaraterAtendimento;
import br.gov.saudecaruaru.bpai.business.model.Diversas;
import br.gov.saudecaruaru.bpai.business.model.DiversasPK;
import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Junior Pires
 */
public class CadastroIndividualizado extends javax.swing.JFrame {
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
     private DiversasController diversasController;
     
    
     
    /**
     * Creates new form CadastroIndividualizado
     */
    public CadastroIndividualizado() {
        initComponents();
        diversasController = new DiversasController();
        //instancia o modelo DiversasPk
        diversas = new  Diversas();
        diversasPk = new DiversasPK();
        diversas.setDiversasPK(diversasPk);
        
        myInitComponents();
        
        
        //seta o estado do frame para ocupar toda a tela
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void myInitComponents(){
        
        initComboBoxs();
        
        //desabilita alguns campos do usuario
        jTextFieldUsuarioNomeMunicip.setEnabled(false);
        jTextFieldUsuarioNomeNac.setEnabled(false);
        jTextFieldUsuarioDescEtnia.setEnabled(false);
        
        //desabilita alguns campos do procedimento
        jTextFieldProcDescricao.setEnabled(false);
        //jTextFieldProcDescricaoProc.setText("ANALISE DE ALGUMA COISA");
        jTextFieldProcDescriDoenca.setEnabled(false);
        
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
        jTextFieldProcCod.setInputVerifier(new ProcedimentoVerifier(this, "Procedimento", jTextFieldProcDescricao,jTextFieldCBO));
        jTextFieldProcCID.setInputVerifier(new DoencaVerifier(this, "CID", jTextFieldProcDescriDoenca,jTextFieldProcCod));
        jTextFieldMes.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField mes = (JTextField) input;
                //expressão regular para mês
                Pattern p = Pattern.compile("(0[1-9]|[1][0-2])");  
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldCnes = new javax.swing.JTextField();
        jTextFieldCnsProfiss = new JFormattedTextField(getMCNS());
        jTextFieldNomeProfiss = new javax.swing.JTextField();
        jTextFieldMes = new JFormattedTextField(getMMes());
        jTextFieldAno = new JFormattedTextField(getMAno());
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFolha = new JFormattedTextField(getMFolha());
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldUsuarioCns = new JFormattedTextField(getMCNS());
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelUsuarioSeq = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldUsuarioNome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldUsuarioSexo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldUsarioDatNasc =  new JFormattedTextField(getMData());
        jTextFieldUsuarioCodNac = new JFormattedTextField(getMCodNac());
        jTextFieldUsuarioNomeNac = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldUsuarioNomeMunicip = new javax.swing.JTextField();
        jTextFieldUsuarioCodMunicip = new JFormattedTextField(getMCodMun());
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldUsuarioCodEtnia = new JFormattedTextField(getMEtnia());
        jTextFieldUsuarioDescEtnia = new javax.swing.JTextField();
        jComboBoxUsuarioRacaCor = new javax.swing.JComboBox();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabelProcSeq = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jTextFieldProcDataAtend = new JFormattedTextField(getMData());
        jTextFieldProcQuant = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextFieldProcDescriDoenca = new javax.swing.JTextField();
        jTextFieldProcCod = new JFormattedTextField(getMCodProc());
        jLabel23 = new javax.swing.JLabel();
        jTextFieldProcCID = new JFormattedTextField(getMCID());
        jLabel24 = new javax.swing.JLabel();
        jTextFieldProcDescricao = new javax.swing.JTextField();
        jTextFieldProcNumAut = new JFormattedTextField(getMNumAutoriz());
        jComboBoxProcCaraterAtend = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jButtonIncluir = new javax.swing.JButton();
        jButtonLimpar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldCBO = new JFormattedTextField(getMCBO());
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("CNES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("CNS Profissional");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Nome Profissional");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mês/Ano");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Folha");

        jTextFieldCnes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCnesActionPerformed(evt);
            }
        });

        jTextFieldCnsProfiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCnsProfissActionPerformed(evt);
            }
        });

        jTextFieldNomeProfiss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeProfissActionPerformed(evt);
            }
        });

        jTextFieldMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMesActionPerformed(evt);
            }
        });

        jTextFieldAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText(" /");

        jTextFieldFolha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldFolhaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jTextFieldUsuarioCns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioCnsActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("CNS");

        jLabel8.setText("Usuário Sequência :");

        jLabelUsuarioSeq.setText("01");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nome ");

        jTextFieldUsuarioNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Sexo");

        jTextFieldUsuarioSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioSexoActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText(" F/M");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Dt. Nascimento");

        jTextFieldUsarioDatNasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsarioDatNascActionPerformed(evt);
            }
        });

        jTextFieldUsuarioCodNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioCodNacActionPerformed(evt);
            }
        });

        jTextFieldUsuarioNomeNac.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioNomeNac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeNacActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Nacionalidade");

        jTextFieldUsuarioNomeMunicip.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldUsuarioNomeMunicip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioNomeMunicipActionPerformed(evt);
            }
        });

        jTextFieldUsuarioCodMunicip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioCodMunicipActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Município de Residência");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Raça/Cor");

        jTextFieldUsuarioCodEtnia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsuarioEtniaActionPerformed(evt);
            }
        });

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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Etnia");

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
                            .addComponent(jTextFieldUsuarioCns, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldUsarioDatNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                .addComponent(jTextFieldUsuarioCodMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsuarioNomeMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldUsuarioCodNac, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldUsuarioNomeNac, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(725, Short.MAX_VALUE))
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
                            .addComponent(jTextFieldUsuarioSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldUsarioDatNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuarioCodMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioNomeMunicip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioCodNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioNomeNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldUsuarioCodEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldUsuarioDescEtnia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxUsuarioRacaCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel16.setText("Procedimento Sequência :");

        jLabelProcSeq.setText("01");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Dt. Atendimento");

        jTextFieldProcDataAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcDataAtendActionPerformed(evt);
            }
        });

        jTextFieldProcQuant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcQuantActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Quantidade");

        jTextFieldProcDescriDoenca.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldProcDescriDoenca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcDescriDoencaActionPerformed(evt);
            }
        });

        jTextFieldProcCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcCodActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Código");

        jTextFieldProcCID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcCIDActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("CID");

        jTextFieldProcDescricao.setBackground(new java.awt.Color(153, 153, 153));
        jTextFieldProcDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcDescricaoProcActionPerformed(evt);
            }
        });

        jTextFieldProcNumAut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldProcNumAutActionPerformed(evt);
            }
        });

        jComboBoxProcCaraterAtend.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxProcCaraterAtend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxProcCaraterAtendActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Nº Autorização");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Caráter Atendimento");

        jButtonIncluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonIncluir.setText("Incluir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });

        jButtonLimpar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
                                    .addComponent(jTextFieldProcDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldProcCod, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldProcDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldProcQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTextFieldProcCID, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldProcDescriDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxProcCaraterAtend, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldProcNumAut))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 379, Short.MAX_VALUE)
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(158, 158, 158))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldProcDataAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldProcCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldProcDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldProcQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldProcDescriDoenca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldProcNumAut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxProcCaraterAtend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldCBO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCBOActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("CBO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1503, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCnes, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCnsProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNomeProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCBO, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(31, 31, 31)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jTextFieldFolha, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldCnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldCnsProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldNomeProfiss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldCBO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldFolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jTextFieldCnesActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jTextFieldCnsProfissActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jTextFieldNomeProfissActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void jTextFieldUsuarioSexoActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
    }                                                     

    private void jTextFieldMesActionPerformed(java.awt.event.ActionEvent evt) {                                              
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

    private void jTextFieldProcQuantActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void jTextFieldProcDescriDoencaActionPerformed(java.awt.event.ActionEvent evt) {                                                           
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

    private void jComboBoxProcCaraterAtendActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void jTextFieldProcNumAutActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {                                              
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
    // Variables declaration - do not modify                     
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
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldFolha;
    private javax.swing.JTextField jTextFieldCBO;
    private javax.swing.JTextField jTextFieldCnes;
    private javax.swing.JTextField jTextFieldCnsProfiss;
    private javax.swing.JTextField jTextFieldMes;
    private javax.swing.JTextField jTextFieldNomeProfiss;
    private javax.swing.JTextField jTextFieldProcCID;
    private javax.swing.JTextField jTextFieldProcCod;
    private javax.swing.JTextField jTextFieldProcDataAtend;
    private javax.swing.JTextField jTextFieldProcDescriDoenca;
    private javax.swing.JTextField jTextFieldProcDescricao;
    private javax.swing.JTextField jTextFieldProcNumAut;
    private javax.swing.JTextField jTextFieldProcQuant;
    private javax.swing.JTextField jTextFieldUsarioDatNasc;
    private javax.swing.JTextField jTextFieldUsuarioCns;
    private javax.swing.JTextField jTextFieldUsuarioCodMunicip;
    private javax.swing.JTextField jTextFieldUsuarioCodNac;
    private javax.swing.JTextField jTextFieldUsuarioDescEtnia;
    private javax.swing.JTextField jTextFieldUsuarioCodEtnia;
    private javax.swing.JTextField jTextFieldUsuarioNome;
    private javax.swing.JTextField jTextFieldUsuarioNomeMunicip;
    private javax.swing.JTextField jTextFieldUsuarioNomeNac;
    private javax.swing.JTextField jTextFieldUsuarioSexo;
    // End of variables declaration                   

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
            comboListCor[i] = list.get(i).getDiversasPK().getCodigoItemTabela()+" "+list.get(i).getDescricaoItemTabela();
        }
        //cria o modelo do combobox com as informações do banco
        ComboBoxModel model = new DefaultComboBoxModel(comboListCor);
        //seta o modelo no combobox Cor
        jComboBoxUsuarioRacaCor.setModel(model);
        
        
      
         //inicializar comboBox Carater de Atendimento
        //seta no modelo Diversas o codigo referente a tabela Cor no banco
        
        String[] comboListCaraterAtend ={CaraterAtendimento.SEM_INFORMACAO.desc(),CaraterAtendimento.ELETIVO.desc(),CaraterAtendimento.URGENCIA.desc(),CaraterAtendimento.ACIDENTE_LOCAL.desc(),
                                         CaraterAtendimento.ACIDENTE_EXTERNO.desc(),CaraterAtendimento.ACIDENTE_OUTROS.desc(),CaraterAtendimento.LESOES_OUTRAS.desc()};
        
        //cria o modelo do combobox com as informações do banco
        ComboBoxModel modelCarater = new DefaultComboBoxModel(comboListCaraterAtend);
        //seta o modelo no combobox Cor
        jComboBoxProcCaraterAtend.setModel(modelCarater);
        
        
        
        
    }
    
    



}
