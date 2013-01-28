/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ListaProcedimento.java
 *
 * Created on 07/09/2012, 22:03:00
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.gui.exportacao.ImportacaoBackup;
import br.gov.saudecaruaru.bpai.gui.exportacao.Exportacao;
import br.gov.saudecaruaru.bpai.gui.exportacao.ExportacaoXML;
import br.gov.saudecaruaru.bpai.gui.exportacao.ExportacaoBPAMagnetico;
import br.gov.saudecaruaru.bpai.gui.exportacao.ExportacaoCentralEnvio;
import br.gov.saudecaruaru.bpai.gui.exportacao.ExportacaoCentralAtualizacao;
import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.BIGestorCompetenciaController;
import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoController;
import br.gov.saudecaruaru.bpai.business.controller.ProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimento;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.business.model.Procedimento;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.presenter.familia.FamiliaPresenter;
import br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop;
import br.gov.saudecaruaru.bpai.gui.FocusListener.ChangeBackgroundFieldFocusListener;
import br.gov.saudecaruaru.bpai.gui.exportacao.ExportacaoCentralViaXML;
import br.gov.saudecaruaru.bpai.util.ProcedimentoRealizadoTableModelBody;
import br.gov.saudecaruaru.bpai.util.ProcedimentoRealizadoTableModelHeader;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Albuquerque
 */
public class ListaProcedimento extends javax.swing.JFrame {
    
    private static final String COMPETENCIA="COMPETÊNCIA";
    private static final String CNS="CNS DO PROFISSIONAL";
    private static final String CNES= "CNES";
    private static final String CBO="CBO";
    
    
    private ProcedimentoRealizadoTableModelHeader tableModelHeader;
    private ProcedimentoRealizadoTableModelBody tableModelBody;
    private BIProcedimentoRealizadoController biProcedimentoRealizadoController;
    private BIProcedimentoController bIProcedimentoController=new BIProcedimentoController();
    private ProcedimentoController procedimentoController=new ProcedimentoController();
    private BIGestorCompetenciaController gestorCompetenciaController;
    private FocusListener listenerFieldsChangeBackground ;
    private static final HashMap<String,String> mapFiltro = new HashMap<String, String>();
    static{
        mapFiltro.put("COMPETÊNCIA","competencia");
    }
    /** Creates new form ListaProcedimento */
    public ListaProcedimento(java.awt.Frame parent, boolean modal) {
        //super(parent);
        this.initComponents();
        this.myInitComponents();
    }
    public ListaProcedimento() {
        //super(parent);
        this.initComponents();
        this.myInitComponents();
        
        //vai pedir o login
        this.login();
    }
    private void myInitComponents(){
        
        this.biProcedimentoRealizadoController= new BIProcedimentoRealizadoController();
        this.gestorCompetenciaController = new BIGestorCompetenciaController();
        this.listenerFieldsChangeBackground = new ChangeBackgroundFieldFocusListener();
        this.jcomboBoxFiltroActionPerformed(null);
        this.initJTableBody();
        this.initJTableHeader();
        
        jcomboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[]{ListaProcedimento.CNS,
                                                                                    ListaProcedimento.CNES,
                                                                                    ListaProcedimento.COMPETENCIA,
                                                                                    ListaProcedimento.CBO}));
        
        if(!this.gestorCompetenciaController.haveCompetencia()){
             AlteraCompetencia alt = new AlteraCompetencia(this, true);
             alt.initCritical();
         }
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
        
      //vai adicionar os labels aos menus e botões
        this.jMenuOperacao.setText("Operações");
        this.jMenuItemAlteraCompetencia.setText("Alterar Competência");
        this.jcomboBoxFiltro.addFocusListener(this.listenerFieldsChangeBackground );
        this.jTextFieldPesquisa.addFocusListener(this.listenerFieldsChangeBackground);
        
        try{
            this.bIProcedimentoController.insereProcedimentosSemReferencia();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

  
    private void login(){
        Login login= new Login(this, true);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        login.setVisible(true);
    }
    /**
     * Configura a tabela que armazena o cabeÃ§alho
     */
    public void initJTableHeader(){
        String competencia=this.gestorCompetenciaController.getCompetenciaAtual();
        this.tableModelHeader= new ProcedimentoRealizadoTableModelHeader(this.biProcedimentoRealizadoController.findAllOnlyHeader(competencia));
        this.jTableHeader.setModel(tableModelHeader);
        this.jTableHeader.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //quando a linha selecionada for mudada
        this.jTableHeader.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //as mudanÃ§as da seleÃ§Ã£o ainda estÃ£o ocorrendo
                if(!e.getValueIsAdjusting()){
                    int row=ListaProcedimento.this.jTableHeader.getSelectedRow();
                    //tem linha selecionada
                    if(row>=0){

                        //Pega o procedimento realizado de acordo com a linha selecionada na tabela
                        ProcedimentoRealizado pro=ListaProcedimento.this.tableModelHeader.getProcedimentoRealizado(row);
                        //zera a quantidade padrÃ£o
                        pro.setQuantidadeRealizada(null);
                        //substitui a lista
                        BIProcedimentoRealizado bp= new BIProcedimentoRealizado(pro);
                        List<BIProcedimentoRealizado> l=ListaProcedimento.this.biProcedimentoRealizadoController.findAllEqualOrderBy(bp,"biProcedimentoRealizadoPK.sequenciaFolha");
                        
                        final List<ProcedimentoRealizado> lista=ListaProcedimento.this.biProcedimentoRealizadoController.parserBIProcedimentoRealizadoToProcedimentoRealizado(l);
                        SwingUtilities.invokeLater(new Runnable() {

                            @Override
                            public void run() {
                                ListaProcedimento.this.tableModelBody.clean();
                                ListaProcedimento.this.tableModelBody.replaceAllProcedimentoRealizado(lista);
                            }
                        });
                        l.clear();
                    }
                    //coloca uma lista vazia
                    else{
                        ListaProcedimento.this.tableModelBody.replaceAllProcedimentoRealizado(new ArrayList<ProcedimentoRealizado>());
                    }
                }
               
            }
        });
        tableHeaderRedimendionaColunas();
       
       //seleciona a primeira linha
       if(!this.tableModelHeader.isEmpty()){
            this.jTableHeader.setRowSelectionInterval(0, 0);
       }
    }

    private void tableHeaderRedimendionaColunas() {
        TableColumnModel columns=this.jTableHeader.getColumnModel();
       
       //coluna CNES
       columns.getColumn(0).setPreferredWidth(60);
       //coluna competÃªncia
       columns.getColumn(1).setPreferredWidth(110);
       //coluna CNS do profissional de saÃºde
       columns.getColumn(2).setPreferredWidth(130);
       //coluna nome do profissional
       columns.getColumn(3).setPreferredWidth(300);
       //coluna CBO
       columns.getColumn(4).setPreferredWidth(60);
       //coluna folha
       columns.getColumn(5).setPreferredWidth(50);
    }
    
    /**
     * Configura a tabela que armazena o corpo de procedimentoRealizado
     */
    private void initJTableBody(){
        //inicia o modelo da tabela
        this.tableModelBody=new ProcedimentoRealizadoTableModelBody(new ArrayList<ProcedimentoRealizado>());
        this.jTableBody.setModel(this.tableModelBody);
        this.jTableBody.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        this.TableBodyAjustarTamanhoTabelas();

    }
    
    private void TableBodyAjustarTamanhoTabelas(){
        
       TableColumnModel columns=this.jTableBody.getColumnModel();
        //coluna sequÃªncia
       columns.getColumn(0).setPreferredWidth(40);
       //coluna cns do paciente
       columns.getColumn(1).setPreferredWidth(120);
       //coluna nome do paciente
       columns.getColumn(2).setPreferredWidth(300);
       //coluna data de nascimento do paciente
       columns.getColumn(3).setPreferredWidth(120);
       //coluna sexo do paciente
       columns.getColumn(4).setPreferredWidth(50);
       //coluna municÃ­pio de residÃªncia do paciente
       columns.getColumn(5).setPreferredWidth(120);
       //coluna data de atendimento
       columns.getColumn(6).setPreferredWidth(120);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHeader = new javax.swing.JTable();
        jcomboBoxFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jbtnPesquisar = new javax.swing.JButton();
        jLabelTipoPesquisa = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableBody = new javax.swing.JTable();
        jbtnIncluirFolha = new javax.swing.JButton();
        jbtnSair = new javax.swing.JButton();
        jButtonAtualizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuOperacao = new javax.swing.JMenu();
        jMenuItemExportarBPA = new javax.swing.JMenuItem();
        jMenuItemExportarXML = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItemExportarEnvio = new javax.swing.JMenuItem();
        jMenuItemExportarAtualizacao = new javax.swing.JMenuItem();
        jMenuItemAlteraCompetencia = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jTableHeader.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableHeaderMouseClicked(evt);
            }
        });
        jTableHeader.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTableHeaderKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTableHeader);

        jcomboBoxFiltro.setFont(new java.awt.Font("Tahoma", 0, 14));
        jcomboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CNS DO PROFISSIONAL", "CNES", "COMPETÊNCIA", "CBO", "PROFISSIONAL" }));
        jcomboBoxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboBoxFiltroActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Filtro de Pesquisa");

        jTextFieldPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextFieldPesquisa.setToolTipText("");

        jbtnPesquisar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jbtnPesquisar.setText("Pesquisar");
        jbtnPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnPesquisarMouseClicked(evt);
            }
        });

        jLabelTipoPesquisa.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabelTipoPesquisa.setText("tipo");

        jTableBody.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableBody);

        jbtnIncluirFolha.setFont(new java.awt.Font("Tahoma", 0, 14));
        jbtnIncluirFolha.setText("Incluir folha");
        jbtnIncluirFolha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnIncluirFolhaMouseClicked(evt);
            }
        });

        jbtnSair.setFont(new java.awt.Font("Tahoma", 0, 14));
        jbtnSair.setText("Sair");
        jbtnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtnSairMouseClicked(evt);
            }
        });

        jButtonAtualizar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonAtualizar.setText("Atualizar");
        jButtonAtualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAtualizarMouseClicked(evt);
            }
        });
        jButtonAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizarActionPerformed(evt);
            }
        });

        jMenu1.setText("Arquivo");
        jMenuBar1.add(jMenu1);

        jMenuOperacao.setText("Operações");

        jMenuItemExportarBPA.setText("Exportar para o BPA");
        jMenuItemExportarBPA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemExportarBPAMouseClicked(evt);
            }
        });
        jMenuItemExportarBPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarBPAActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItemExportarBPA);

        jMenuItemExportarXML.setText("Exportar para Backup");
        jMenuItemExportarXML.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemExportarXMLMouseClicked(evt);
            }
        });
        jMenuItemExportarXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarXMLActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItemExportarXML);

        jMenuItem1.setText("Importar Backup");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItem1);

        jMenuItemExportarEnvio.setText("Enviar procedimentos (Base Central)");
        jMenuItemExportarEnvio.setEnabled(false);
        jMenuItemExportarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarEnvioActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItemExportarEnvio);

        jMenuItemExportarAtualizacao.setText("Enviar SOMENTE procedimentos desatualizados (Base Central)");
        jMenuItemExportarAtualizacao.setEnabled(false);
        jMenuItemExportarAtualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarAtualizacaoActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItemExportarAtualizacao);

        jMenuItemAlteraCompetencia.setText("Alterar Competência");
        jMenuItemAlteraCompetencia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItemAlteraCompetenciaMouseClicked(evt);
            }
        });
        jMenuItemAlteraCompetencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAlteraCompetenciaActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItemAlteraCompetencia);

        jMenuItem2.setText("Enviar Produção ");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuOperacao.add(jMenuItem2);

        jMenuBar1.add(jMenuOperacao);

        jMenu2.setText("Cadastro");

        jMenuItem3.setText("Familia");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jcomboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jbtnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelTipoPesquisa)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnIncluirFolha)
                        .addGap(483, 483, 483)
                        .addComponent(jbtnSair))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelTipoPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcomboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPesquisar)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAtualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnIncluirFolha, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jbtnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcomboBoxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboBoxFiltroActionPerformed
        // TODO add your handling code here:
        this.jLabelTipoPesquisa.setText(this.jcomboBoxFiltro.getSelectedItem().toString());
    }//GEN-LAST:event_jcomboBoxFiltroActionPerformed

    private void jbtnSairMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnSairMouseClicked
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnSairMouseClicked

    private void jbtnIncluirFolhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnIncluirFolhaMouseClicked
        // TODO add your handling code here:
        CadastroIndividualizado cad=new CadastroIndividualizado(this);
        //cad.setVisible(true);
        cad.setLocationRelativeTo(null);
        cad.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        cad.setModal(true);
        cad.setVisible(true);
    
    }//GEN-LAST:event_jbtnIncluirFolhaMouseClicked

    private void jTableHeaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableHeaderMouseClicked
        // TODO add your handling code here:
        //evento de duplo clique
        if(evt.getClickCount()==2){
            this.abrirTelaCadastroIndividualizado();
            
        }
    }//GEN-LAST:event_jTableHeaderMouseClicked

    
    private void abrirTelaCadastroIndividualizado(){
        int row=ListaProcedimento.this.jTableHeader.getSelectedRow();
        //tem linha selecionada
        if(row>=0){
            CadastroIndividualizado cad=new CadastroIndividualizado(this);
            ProcedimentoRealizado pro=this.tableModelHeader.getProcedimentoRealizado(row);
            //zera a quantidade padrÃ£o
            pro.setQuantidadeRealizada(null);
            cad.findAllProcedimentosFolha(pro);
            //desabilita os campos do cabeÃ§alho
            cad.disableFieldsHeader();
            cad.setLocationRelativeTo(null);
            cad.setModal(true);
            cad.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            cad.setVisible(true);
        }
    }
    
    private void jMenuItemExportarBPAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExportarBPAMouseClicked
        // TODO add your handling code here:
        IExportacaoStrategy expo=new ExportacaoBPAMagnetico(new BIProcedimentoRealizado(new BIProcedimentoRealizadoPK()));
        Exportacao ex=new  Exportacao(this,expo);
        ex.setTitle("Exportações da produção para o banco do BPA Magnético.");
        ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ex.setLocationRelativeTo(null);
        ex.setModal(true);
        ex.setVisible(true);
    }//GEN-LAST:event_jMenuItemExportarBPAMouseClicked

    private void jMenuItemExportarBPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarBPAActionPerformed
        // TODO add your handling code here:
        this.jMenuItemExportarBPAMouseClicked(null);
    }//GEN-LAST:event_jMenuItemExportarBPAActionPerformed

    private void jButtonAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAtualizarActionPerformed

    private void jButtonAtualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAtualizarMouseClicked
        // TODO add your handling code here:
        String competencia=this.gestorCompetenciaController.getCompetenciaAtual();
        this.tableModelHeader.replaceAllProcedimentoRealizado(this.biProcedimentoRealizadoController.findAllOnlyHeader(competencia));
        if(!this.tableModelHeader.isEmpty()){
            this.jTableHeader.setRowSelectionInterval(0, 0);
        }
       this.TableBodyAjustarTamanhoTabelas(); 
    }//GEN-LAST:event_jButtonAtualizarMouseClicked

    private void jMenuItemAlteraCompetenciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemAlteraCompetenciaMouseClicked
        AlteraCompetencia alt = new AlteraCompetencia(this, true);
        alt.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        alt.setLocationRelativeTo(this);
        alt.setVisible(true);        
    }//GEN-LAST:event_jMenuItemAlteraCompetenciaMouseClicked

    private void jMenuItemAlteraCompetenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAlteraCompetenciaActionPerformed
            this.jMenuItemAlteraCompetenciaMouseClicked(null);      
    }//GEN-LAST:event_jMenuItemAlteraCompetenciaActionPerformed

    private void jMenuItemExportarXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarXMLActionPerformed
        // TODO add your handling code here:
        this.jMenuItemExportarXMLMouseClicked(null);
    }//GEN-LAST:event_jMenuItemExportarXMLActionPerformed

    private void jMenuItemExportarXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExportarXMLMouseClicked
        // TODO add your handling code here:
        
        SimpleDateFormat format= new SimpleDateFormat("dd_MM_yyyy_HH_mm");
        //cria o arquivo para exportar os dados
        JFileChooser fil= new JFileChooser();
        fil.setDialogType(JFileChooser.SAVE_DIALOG);
        fil.setSelectedFile(new File("backup_"+ format.format( new Date())+".xml"));
        fil.setFileFilter(new FileNameExtensionFilter("xml", ".xml"));
        fil.showSaveDialog(this);
        //arquivo foi criado com sucesso, entÃ£o deve-se pegar o caminho dele.
        String path=fil.getSelectedFile() != null ? fil.getSelectedFile().getAbsolutePath() : null;
        if( path!=null){
            IExportacaoStrategy expo=new ExportacaoXML(path, new BIProcedimentoRealizado(new BIProcedimentoRealizadoPK()));
            Exportacao ex=new  Exportacao(this,expo);
            ex.setTitle("Exportação para arquivo Backup.");
            ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            ex.setLocationRelativeTo(null);
            ex.setModal(true);
            ex.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemExportarXMLMouseClicked

    private void jMenuItemExportarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarEnvioActionPerformed
        // TODO add your handling code here:
        //ATENÃ‡ÃƒO: CORRRIGIRA CRIAÃ‡ÃƒO DO USUÃ�RIO DESKTOP
                SUsuarioDesktop desk=new SUsuarioDesktop();
                desk.setSerial_aplicacao("324324324");
                desk.setServidor_cpf("00000000098");
                desk.setToken("324324");
                desk.setUsuario_sistema("cesar");
        //============================================
        IExportacaoStrategy expo=new ExportacaoCentralEnvio(desk, null);
        Exportacao ex=new  Exportacao(this,expo);
        ex.setTitle("Envio dos procedimentos realizados para a base central.");
        ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ex.setLocationRelativeTo(null);
        ex.setModal(true);
        ex.setVisible(true);
    }//GEN-LAST:event_jMenuItemExportarEnvioActionPerformed

    private void jMenuItemExportarAtualizacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarAtualizacaoActionPerformed
        // TODO add your handling code here:
                //ATENÃ‡ÃƒO: CORRRIGIRA CRIAÃ‡ÃƒO DO USUÃ�RIO DESKTOP
                SUsuarioDesktop desk=new SUsuarioDesktop();
                desk.setSerial_aplicacao("324324324");
                desk.setServidor_cpf("00000000098");
                desk.setToken("324324");
                desk.setUsuario_sistema("cesar");
        //============================================
        IExportacaoStrategy expo=new ExportacaoCentralAtualizacao(desk);
        Exportacao ex=new  Exportacao(this,expo);
        ex.setTitle("Envio dos procedimentos realizados (ainda não atualizados) para a base central.");
        ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ex.setLocationRelativeTo(null);
        ex.setModal(true);
        ex.setVisible(true);
    }//GEN-LAST:event_jMenuItemExportarAtualizacaoActionPerformed

    private void jbtnPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtnPesquisarMouseClicked
        String itemBusca = this.jcomboBoxFiltro.getSelectedItem().toString();
        BIGestorCompetenciaController competenciaController = new BIGestorCompetenciaController();
       
        BIProcedimentoRealizadoPK biPK =new BIProcedimentoRealizadoPK();
        
        BIProcedimentoRealizado bipr = new BIProcedimentoRealizado(biPK);
        
        String competencia = competenciaController.getCompetenciaAtual();
        if(itemBusca.equals(ListaProcedimento.COMPETENCIA)){
           biPK.setCompetencia(jTextFieldPesquisa.getText());
        }
        if(itemBusca.equals(ListaProcedimento.CNS)){
           biPK.setCompetencia(competencia); 
           biPK.setCnsMedico(jTextFieldPesquisa.getText());
        }
        if(itemBusca.equals(ListaProcedimento.CNES)){
           biPK.setCompetencia(competencia);  
           biPK.setCnesUnidade(jTextFieldPesquisa.getText());
        }
        if(itemBusca.equals(ListaProcedimento.CBO)){
           biPK.setCompetencia(competencia);  
           biPK.setCboMedico(jTextFieldPesquisa.getText());
        }
        List<ProcedimentoRealizado> list= biProcedimentoRealizadoController.findAllOnlyHeaderEqual(bipr);
        if(list!=null){  
            this.tableModelHeader= new ProcedimentoRealizadoTableModelHeader(list);
            
            this.jTableHeader.setModel(tableModelHeader);
            //redimensiona as colunas das Tabelas
            this.tableHeaderRedimendionaColunas();
            this.TableBodyAjustarTamanhoTabelas();
            //seleciona a primeira linha
            if(!this.tableModelHeader.isEmpty()){
                this.jTableHeader.setRowSelectionInterval(0, 0);
             }
         }
    }//GEN-LAST:event_jbtnPesquisarMouseClicked

    private void jTableHeaderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableHeaderKeyPressed
        // TODO add your handling code here:
        if ( evt.getKeyCode() == KeyEvent.VK_ENTER ){
            this.abrirTelaCadastroIndividualizado();
        }
        
         if ( evt.getKeyCode() == KeyEvent.VK_DELETE ){
             int row=ListaProcedimento.this.jTableHeader.getSelectedRow();
                if(row>=0){
                    ProcedimentoRealizado pro=this.tableModelHeader.getProcedimentoRealizado(row);
                   
                    StringBuilder msg = new StringBuilder();
                    msg.append("\n FOLHA: ").append(pro.getProcedimentoRealizadoPK().getNumeroFolha());
                    msg.append("\n CNES: ").append(pro.getProcedimentoRealizadoPK().getCnesUnidade());
                    msg.append("\n CNS PROFISSIONAL: ").append(pro.getProcedimentoRealizadoPK().getCnsMedico());
                    msg.append("\n CBO: ").append(pro.getProcedimentoRealizadoPK().getCboMedico());
                    msg.append("\n COMPETÊNCIA: ").append(pro.getProcedimentoRealizadoPK().getCompetencia());
                    
                    if(JOptionPane.showOptionDialog(this,"DESEJA REALMENTE DELETAR ESTA FOLHA?"+msg.toString(),"ATENÇÃO!",
                               JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null)==JOptionPane.YES_OPTION){
                        //remove a folha
                        this.biProcedimentoRealizadoController.removeAll(new BIProcedimentoRealizado(pro));
                        //atualiza a tabela
                        this.jButtonAtualizarMouseClicked(null);
                    
                
                }
             
          }
        }
    }//GEN-LAST:event_jTableHeaderKeyPressed

    
    private void atualizarBaseDeDados(){
            int maxRes=500;
        int first=0;
        int size=maxRes;
        while(size==maxRes){
            List<Procedimento> list=this.procedimentoController.findAllEqual(new HashMap<String,Object>(), first, maxRes);
            List<BIProcedimento> l=new ArrayList<BIProcedimento>();
            size=list.size();
            for(Procedimento p:list){
                BIProcedimento bi=new BIProcedimento(p);
                l.add(bi);
            }
            this.bIProcedimentoController.merge(l);
            first+=size;
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        JFileChooser fil= new JFileChooser();
        //fil.setDialogType(JFileChooser.OPEN_DIALOG);
        //fil.setFileFilter(new FileNameExtensionFilter("xml", ".xml"));
        fil.showSaveDialog(this);
        //arquivo foi encontrado
        String path=fil.getSelectedFile() != null ? fil.getSelectedFile().getAbsolutePath() : null;
        if( path!=null){
            IExportacaoStrategy expo=new ImportacaoBackup(path, new BIProcedimentoRealizado(new BIProcedimentoRealizadoPK()));
            Exportacao ex=new  Exportacao(this,expo);
            ex.enabledComboBoxs(false);
            ex.setTitle("Importação para o arquivo de Backup.");
            ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            ex.setLocationRelativeTo(null);
            ex.setModal(true);
            ex.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here
        this.enviarProducao();

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void enviarProducao(){
        IExportacaoStrategy expo= new ExportacaoCentralViaXML();
        Exportacao ex=new  Exportacao(this,expo);
        ex.setTitle("Envio da produção via Arquivo.");
        ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ex.setLocationRelativeTo(null);
        ex.setModal(true);
        ex.setVisible(true);
    }
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FamiliaPresenter familiaPresenter = new FamiliaPresenter();
        familiaPresenter.createView();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTipoPesquisa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItemAlteraCompetencia;
    private javax.swing.JMenuItem jMenuItemExportarAtualizacao;
    private javax.swing.JMenuItem jMenuItemExportarBPA;
    private javax.swing.JMenuItem jMenuItemExportarEnvio;
    private javax.swing.JMenuItem jMenuItemExportarXML;
    private javax.swing.JMenu jMenuOperacao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableBody;
    private javax.swing.JTable jTableHeader;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JButton jbtnIncluirFolha;
    private javax.swing.JButton jbtnPesquisar;
    private javax.swing.JButton jbtnSair;
    private javax.swing.JComboBox jcomboBoxFiltro;
    // End of variables declaration//GEN-END:variables
}
