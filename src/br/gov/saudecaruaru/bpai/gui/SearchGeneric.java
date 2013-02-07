/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SearchGeneric.java
 *
 * Created on 14/08/2012, 14:18:10
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.controller.BasecController;
import br.gov.saudecaruaru.bpai.gui.FocusListener.ChangeBackgroundFieldFocusListener;
import br.gov.saudecaruaru.bpai.util.ModelUtil;
import br.gov.saudecaruaru.bpai.util.Search;
import br.gov.saudecaruaru.bpai.gui.tablemodel.SearchTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Albuquerque
 */
public class SearchGeneric extends javax.swing.JDialog {
    
   
    //campo que representa o identificador do objeto
    private String fieldId= "";
    //campo que representa a descrição do objeto
    private String fieldDescription="";
    //cabeçalho da tabela
    private String[] header=new String[]{"Código","Descrição"};
    
    //vai guardar o objeto Search selecionado
    private Search selectedSearch=null; 
    
    //modelTable utlizado para popular a tabela
    private SearchTableModel tableModel;
    //lista com todos os dados
    private List<Search> listAll;
    //implementação do padrão singleton
    public static SearchGeneric instance=null;
    //controlador utilizado para realizar a pesquisa
    private BasecController basicController=null;
    
    private FocusListener listenerFieldsChangeBackground ;
 
    
    
    

    /** Creates new form SearchGeneric */
    private SearchGeneric() {
        initComponents();
        this.initMyComponents();
        this.initTable();
        this.initLookAndFeel();
        this.initTextFieldSearch();
        this.initEventsForm();
        this.initEventsTable();
        
        
    }
    
    private void initMyComponents(){
        this.listenerFieldsChangeBackground = new ChangeBackgroundFieldFocusListener();
        
        this.jTextField1.addFocusListener(this.listenerFieldsChangeBackground);
        this.jComboBox1.addFocusListener(this.listenerFieldsChangeBackground);
    }
    public void selectedModel(){
        //pega o modelo selecionado
        int index=this.tableLista.getSelectedRow();
        this.selectedSearch= index > -1? this.tableModel.getSearch(index): null;
        //modelo existe
        if(this.selectedSearch!=null){
            //encerra a janela
            this.dispose();
        }
        else{
            //não existe nenhum modelo selecionado
            JOptionPane.showMessageDialog(this, "Não existe linha selecionada na tabela!");
        }
    
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLista = new javax.swing.JTable();
        jtoolHint = new javax.swing.JToolBar();
        jLblHint = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel1.setText("Pesquisar por:");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jTextField1.setToolTipText("");
        jTextField1.setName("textFieldPesquisa"); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Pesquisar(evt);
            }
        });

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel2.setText("Pesquisar");
        jLabel2.setName("lbl_pesquisa"); // NOI18N

        tableLista.setFont(new java.awt.Font("Tahoma", 0, 16));
        tableLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableLista.setEditingColumn(1);
        tableLista.setEditingRow(1);
        tableLista.setName("tableLista"); // NOI18N
        tableLista.setOpaque(false);
        tableLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableListaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLista);
        tableLista.getAccessibleContext().setAccessibleName("");

        jtoolHint.setToolTipText("Testando");
        jtoolHint.setFont(new java.awt.Font("Segoe UI", 0, 14));

        jLblHint.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLblHint.setText("Enter - Selecionar Código / Duplo click no registro selecionado / ESC - Sair");
        jLblHint.setToolTipText("");
        jtoolHint.add(jLblHint);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtoolHint, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(76, 76, 76))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtoolHint, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Pesquisar(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Pesquisar

    }//GEN-LAST:event_Pesquisar

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

    }//GEN-LAST:event_formKeyPressed

    private void tableListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableListaMouseClicked
        
        if(evt.getClickCount()==2){
            this.selectedModel();
        }
        
        
    }//GEN-LAST:event_tableListaMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    //realiza  a busca caso o usuário digite algum caractere válido
    private void initTextFieldSearch(){
        this.jTextField1.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                if(SearchGeneric.this.jTextField1.getText().length()>2){
                    SearchGeneric.this.updateTable(SearchGeneric.this.search());
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(SearchGeneric.this.jTextField1.getText().length()>2){
                    SearchGeneric.this.updateTable(SearchGeneric.this.search());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    private void initEventsForm(){
    
        //pega o elemento root
        JRootPane rootPane = this.getRootPane();
        //pega o map que registra as entradas
        InputMap iMap =	rootPane.getInputMap(	 JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "escape");
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "enter");
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

        ActionMap aMap = rootPane.getActionMap();
        //quando clicar em esc vai sair
        aMap.put("escape", new AbstractAction(){
                            public void actionPerformed(ActionEvent e)
                                {
                                    dispose();
                                }});
        
        //quando clicar em F2 vai chamar o método de seleção de registro
        Action selecionarRegistro=new AbstractAction(){
                            public void actionPerformed(ActionEvent e)
                                {
                                    SearchGeneric.this.selectedModel();
                                }};
        aMap.put("enter",selecionarRegistro );
        

    }
    private void initEventsTable(){
     
        //seleciona a linha na tabela
        this.tableLista.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if ( e.getKeyCode() == KeyEvent.VK_ENTER){
                    SearchGeneric.this.selectedModel();
                }
            }
                
         });
        //move a barra vertical de acordo com a seleção
        this.tableLista.getSelectionModel().addListSelectionListener(  
                new ListSelectionListener(){  
                    public void valueChanged(ListSelectionEvent e){  
                        JScrollBar vertBart= jScrollPane1.getVerticalScrollBar();  
                        vertBart.setValue(tableLista.getRowHeight()*tableLista.getSelectedRow());  
                    }  
                }  
         ); 
        //pega o elemento root
        JRootPane rootPane = this.getRootPane();
        //pega o map que registra as entradas
        InputMap iMap =	rootPane.getInputMap(	 JComponent.WHEN_IN_FOCUSED_WINDOW);
        
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");

        ActionMap aMap = rootPane.getActionMap();
        //server para navegar na tabela
 	aMap.put("up", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table=SearchGeneric.this.tableLista;
                //verifica se a tabela tem dados
                if (table.getRowCount() > 0){
                    int index=table.getSelectedRow();
                    //não é a primeira linha selecionada
                    if ( index > -1 && index != 0 ){
                        //decrementa o indice da seleção
                        table.setRowSelectionInterval(index  -1, index-1);
                        //jScrollPane1.getVerticalScrollBar().getModel().
                    }
                }
            }
        });
         //server para navegar na tabela
 	aMap.put("down", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JTable table=SearchGeneric.this.tableLista;
                //verifica se a tabela tem dados
                if (table.getRowCount() > 0){
                    //verifica se a linha selecionada não é a última
                    int tamanho=table.getRowCount()-1 ;
                    int index=table.getSelectedRow();
                    if ( tamanho != index ){
                        //decrementa o indice da seleção
                        table.setRowSelectionInterval(index + 1, index + 1);
                    }
                }
            }
        });
     
    }
    private void initTable(){
        this.tableLista.getColumnModel().getColumn(0).setPreferredWidth(110);
        this.tableLista.getColumnModel().getColumn(1).setPreferredWidth(640);
        this.tableLista.setRowSelectionAllowed(true);
	this.tableLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       //this.tableLista.getModel().
    }
    
    
    
    public static SearchGeneric getInstance(){
        if(SearchGeneric.instance==null){
            SearchGeneric.instance= new SearchGeneric();
        }
        return SearchGeneric.instance;
    }
    
    /**
     * Método que inicializa a tela de pesquisa.
     * Qualquer objeto que seja persistido no banco pode ser pesquisado, desde que tenha um controlador.
     * @param controller controlador utilizado para buscar os dados
     * @param fieldId atributo do objeto que representa uma chave ou um valor a ser retornado
     * @param FieldDescription atributo do objeto que representa ums descrição dele
     * @param labelFieldId um label do para o atributo fieldId
     * @param labelFieldDescription um label para o atributo fieldDescription
     * @return devolve um objeto Search, caso o usuário tenha pesquisado e selecionado algum, senão, devolve null
     */
    public Search initModeSearch(BasecController controller,String fieldId,String FieldDescription, String labelFieldId,String labelFieldDescription, Map<String, Object> restrictions){
        this.selectedSearch=null;
        this.jTextField1.setText(null);
        //monta o cabeçalho da tabela
        this.header[1]=labelFieldId;
        this.header[0]=labelFieldDescription;
        
        //preenche o camboobs de seleção
        ComboBoxModel model=new DefaultComboBoxModel(new String[]{labelFieldDescription,labelFieldId});
        this.fieldDescription=FieldDescription;
        this.fieldId=fieldId;
        this.jComboBox1.setModel(model);
        
        this.basicController=controller;
        //cria um modelo de tabela 
        this.tableModel=new SearchTableModel(labelFieldId, labelFieldDescription);
        this.tableLista.setModel(this.tableModel);
        //inicia algumas oncfigurações da tabela
        this.initTable();
        HashSet<Search > set=new HashSet<Search>(ModelUtil.getListSearch( this.basicController.findAllEqual(restrictions),fieldId,FieldDescription));
        this.listAll=new ArrayList<Search>(set);
        this.tableModel.addSearchAll(this.listAll);
        
        //coloca a pesquisa pelo campo descrição
        this.jComboBox1.setSelectedIndex(0);
        //coloca o foco no campo de pesquisa
        //this.jComboBox1.transferFocus();
        //this.jTextField1.requestFocus();
        this.jTextField1.requestFocus();
        //seleciona o primeiro elemento da tabela
        if (this.tableLista.getModel().getRowCount() > 0){
            this.tableLista.setRowSelectionInterval(0, 0);
        }
        
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setModal(true);
        this.setVisible(true);
        //quando terminar vai retornar o valor da seleção
        return this.selectedSearch;
    }

    private void updateTable(List<Search> rows){
        this.tableModel.clean();
	this.tableModel.addSearchAll(rows);
        if(!rows.isEmpty()){
            this.tableLista.setRowSelectionInterval(0, 0);
        }
        
    }
    
    private String getValueItemSelected(){
        return null;
    }
    
    private List<Search> search(){
        
        List<Search> l=new ArrayList<Search>();
        String search=this.jTextField1.getText().toUpperCase();
        int item=this.jComboBox1.getSelectedIndex();
        for(Search s: this.listAll){
            if(item==1){
                if(s.getId().startsWith(search)){
                    l.add(s);
                }
            }
            else{
                if(s.getDescription().startsWith(search)){
                    l.add(s);
                }
            }
        }

        return l;
        
    }
    
    private void initLookAndFeel(){
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLblHint;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToolBar jtoolHint;
    private javax.swing.JTable tableLista;
    // End of variables declaration//GEN-END:variables
}
