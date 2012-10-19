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

import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.business.controller.GestorCompetenciaController;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.model.BIProcedimentoRealizadoPK;
import br.gov.saudecaruaru.bpai.business.model.ProcedimentoRealizado;
import br.gov.saudecaruaru.bpai.business.service.SUsuarioDesktop;
import br.gov.saudecaruaru.bpai.util.ProcedimentoRealizadoTableModelBody;
import br.gov.saudecaruaru.bpai.util.ProcedimentoRealizadoTableModelHeader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Albuquerque
 */
public class ListaProcedimento extends javax.swing.JFrame {
    
    private ProcedimentoRealizadoTableModelHeader tableModelHeader;
    private ProcedimentoRealizadoTableModelBody tableModelBody;
    private BIProcedimentoRealizadoController biProcedimentoRealizadoController;
    private GestorCompetenciaController gestorCompetenciaController;
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
    }
    private void myInitComponents(){
        
        this.biProcedimentoRealizadoController= new BIProcedimentoRealizadoController();
        this.gestorCompetenciaController = new GestorCompetenciaController();
        this.jcomboBoxFiltroActionPerformed(null);
        this.initJTableBody();
        this.initJTableHeader();
        
        
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
    }

    /**
     * Configura a tabela que armazena o cabeçalho
     */
    public void initJTableHeader(){
        this.tableModelHeader= new ProcedimentoRealizadoTableModelHeader(this.biProcedimentoRealizadoController.findAllOnlyHeader());
        this.jTableHeader.setModel(tableModelHeader);
        this.jTableHeader.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //quando a linha selecionada for mudada
        this.jTableHeader.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //as mudanças da seleção ainda estão ocorrendo
                if(!e.getValueIsAdjusting()){
                    int row=ListaProcedimento.this.jTableHeader.getSelectedRow();
                    //tem linha selecionada
                    if(row>=0){

                        //Pega o procedimento realizado de acordo com a linha selecionada na tabela
                        ProcedimentoRealizado pro=ListaProcedimento.this.tableModelHeader.getProcedimentoRealizado(row);
                        //zera a quantidade padrão
                        pro.setQuantidadeRealizada(null);
                        //substitui a lista
                        List<BIProcedimentoRealizado> l=ListaProcedimento.this.biProcedimentoRealizadoController.findAllEqual(new BIProcedimentoRealizado(pro));

                        ListaProcedimento.this.tableModelBody.replaceAllProcedimentoRealizado(ListaProcedimento.this.biProcedimentoRealizadoController.parserBIProcedimentoRealizadoToProcedimentoRealizado(l));
                        l.clear();
                    }
                    //coloca uma lista vazia
                    else{
                        ListaProcedimento.this.tableModelBody.replaceAllProcedimentoRealizado(new ArrayList<ProcedimentoRealizado>());
                    }
                }
               
            }
        });
        TableColumnModel columns=this.jTableHeader.getColumnModel();
       
       //coluna CNES
       columns.getColumn(0).setPreferredWidth(60);
       //coluna competência
       columns.getColumn(1).setPreferredWidth(110);
       //coluna CNS do profissional de saúde
       columns.getColumn(2).setPreferredWidth(130);
       //coluna nome do profissional
       columns.getColumn(3).setPreferredWidth(300);
       //coluna CBO
       columns.getColumn(4).setPreferredWidth(60);
       //coluna folha
       columns.getColumn(5).setPreferredWidth(50);
       
       //seleciona a primeira linha
       if(!this.tableModelHeader.isEmpty()){
            this.jTableHeader.setRowSelectionInterval(0, 0);
       }
    }
    
    /**
     * Configura a tabela que armazena o corpo de procedimentoRealizado
     */
    private void initJTableBody(){
        //inicia o modelo da tabela
        this.tableModelBody=new ProcedimentoRealizadoTableModelBody(new ArrayList<ProcedimentoRealizado>());
        this.jTableBody.setModel(this.tableModelBody);
        this.jTableBody.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        this.ajustarTamanhoTabelas();

    }
    
    private void ajustarTamanhoTabelas(){
        
       TableColumnModel columns=this.jTableBody.getColumnModel();
        //coluna sequência
       columns.getColumn(0).setPreferredWidth(40);
       //coluna cns do paciente
       columns.getColumn(1).setPreferredWidth(120);
       //coluna nome do paciente
       columns.getColumn(2).setPreferredWidth(300);
       //coluna data de nascimento do paciente
       columns.getColumn(3).setPreferredWidth(120);
       //coluna sexo do paciente
       columns.getColumn(4).setPreferredWidth(50);
       //coluna município de residência do paciente
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
        jMenu2 = new javax.swing.JMenu();
        jMenuItemExportarBPA = new javax.swing.JMenuItem();
        jMenuItemExportarXML = new javax.swing.JMenuItem();
        jMenuItemExportarEnvio = new javax.swing.JMenuItem();
        jMenuItemExportarAtualizacao = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

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

        jMenu2.setText("Operações");

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
        jMenu2.add(jMenuItemExportarBPA);

        jMenuItemExportarXML.setText("Exportar para XML procedimentos NÃO ENVIADOS");
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
        jMenu2.add(jMenuItemExportarXML);

        jMenuItemExportarEnvio.setText("Exportar/Enviar procedimentos NÃO ENVIADOS");
        jMenuItemExportarEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarEnvioActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExportarEnvio);

        jMenuItemExportarAtualizacao.setText("Exportar/Enviar procedimento NÃO ATUALIZADOS");
        jMenuItemExportarAtualizacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarAtualizacaoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemExportarAtualizacao);

        jMenuItem2.setText("Alterar Competência");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseClicked(evt);
            }
        });
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnIncluirFolha)
                                .addGap(483, 483, 483)
                                .addComponent(jbtnSair))
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
                                    .addComponent(jLabelTipoPesquisa))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
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
            int row=ListaProcedimento.this.jTableHeader.getSelectedRow();
            //tem linha selecionada
            if(row>=0){
                CadastroIndividualizado cad=new CadastroIndividualizado(this);
                ProcedimentoRealizado pro=this.tableModelHeader.getProcedimentoRealizado(row);
                //zera a quantidade padrão
                pro.setQuantidadeRealizada(null);
                cad.findAllProcedimentosFolha(pro);
                //desabilita os campos do cabeçalho
                cad.disableFieldsHeader();
                cad.setLocationRelativeTo(null);
                cad.setModal(true);
                cad.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                cad.setVisible(true);
            }
            
        }
    }//GEN-LAST:event_jTableHeaderMouseClicked

    private void jMenuItemExportarBPAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExportarBPAMouseClicked
        // TODO add your handling code here:
        IExportacaoStrategy expo=new ExportacaoBPAMagnetico(new BIProcedimentoRealizado(new BIProcedimentoRealizadoPK()));
        Exportacao ex=new  Exportacao(this,expo);
        ex.setTitle("Exportação dos procedimentos para o banco do BPA Magnético.");
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
        this.tableModelHeader.replaceAllProcedimentoRealizado(this.biProcedimentoRealizadoController.findAllOnlyHeader());
        if(!this.tableModelHeader.isEmpty()){
            this.jTableHeader.setRowSelectionInterval(0, 0);
        }
       this.ajustarTamanhoTabelas(); 
    }//GEN-LAST:event_jButtonAtualizarMouseClicked

    private void jMenuItem2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseClicked
        AlteraCompetencia alt = new AlteraCompetencia(this, true);
        alt.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        alt.setLocationRelativeTo(this);
        alt.setVisible(true);        
    }//GEN-LAST:event_jMenuItem2MouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
            this.jMenuItem2MouseClicked(null);      
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemExportarXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarXMLActionPerformed
        // TODO add your handling code here:
        this.jMenuItemExportarXMLMouseClicked(null);
    }//GEN-LAST:event_jMenuItemExportarXMLActionPerformed

    private void jMenuItemExportarXMLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItemExportarXMLMouseClicked
        // TODO add your handling code here:
        //cria o arquivo para exportar os dados
        JFileChooser fil= new JFileChooser();
        fil.setDialogType(JFileChooser.SAVE_DIALOG);
        fil.setFileFilter(new FileNameExtensionFilter("xml", ".xml"));
        fil.showSaveDialog(this);
        //arquivo foi criado com sucesso, então deve-se pegar o caminho dele.
        String path=fil.getSelectedFile() != null ? fil.getSelectedFile().getAbsolutePath() : null;
        if( path!=null){
            IExportacaoStrategy expo=new ExportacaoXML(path, new BIProcedimentoRealizado(new BIProcedimentoRealizadoPK()));
            Exportacao ex=new  Exportacao(this,expo);
            ex.setTitle("Exportação para arquivo XML dos procedimentos não enviados para o servidor central.");
            ex.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            ex.setLocationRelativeTo(null);
            ex.setModal(true);
            ex.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItemExportarXMLMouseClicked

    private void jMenuItemExportarEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarEnvioActionPerformed
        // TODO add your handling code here:
        //ATENÇÃO: CORRRIGIRA CRIAÇÃO DO USUÁRIO DESKTOP
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
                //ATENÇÃO: CORRRIGIRA CRIAÇÃO DO USUÁRIO DESKTOP
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelTipoPesquisa;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemExportarAtualizacao;
    private javax.swing.JMenuItem jMenuItemExportarBPA;
    private javax.swing.JMenuItem jMenuItemExportarEnvio;
    private javax.swing.JMenuItem jMenuItemExportarXML;
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
