/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.gui.tablemodel.PacienteTableModel;
import br.gov.saudecaruaru.bpai.business.model.BIPaciente;
import br.gov.saudecaruaru.bpai.business.model.DoencaCondicao;
import br.gov.saudecaruaru.bpai.business.model.Escolha;
import br.gov.saudecaruaru.bpai.business.model.Observer;
import br.gov.saudecaruaru.bpai.business.model.Subject;
import br.gov.saudecaruaru.bpai.gui.documents.DataDocument;
import br.gov.saudecaruaru.bpai.gui.formatter.*;
import br.gov.saudecaruaru.bpai.gui.interfaces.PacienteView;
import com.towel.bind.Binder;
import com.towel.bind.annotation.AnnotatedBinder;
import com.towel.bind.annotation.Bindable;
import com.towel.bind.annotation.Form;
import com.towel.swing.combo.ObjectComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.text.Document;

/**
 *
 * @author juniorpires
 */
@Form(BIPaciente.class)
public class PacienteWindow extends javax.swing.JFrame implements PacienteView,Observer{
    private Binder binder;
    /**
     * Creates new form PacienteWindow
     */
    public PacienteWindow() {
      initComponents();
      initInstances();  
      this.initMyComponents();
    }

     private void initMyComponents(){
         
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.initInstances();
        
        modelEscolha = new ObjectComboBoxModel<Character>();
        modelDoencaCondicao = new ObjectComboBoxModel<DoencaCondicao>();

        modelEscolha.setFormatter(new EscolhaFormatter());
        modelDoencaCondicao.setFormatter(new DoencaCondicaoFormatter());

        List<Character> lis= new ArrayList<Character>();
        lis.add(new Character('S'));
        lis.add(new Character('N'));
        modelEscolha.setData(lis);
        modelDoencaCondicao.setData(DoencaCondicao.LIST);
        
        jCbalfabetizado.setModel(modelEscolha);
        jCbDoencaCondicao.setModel(modelDoencaCondicao);
        
        this.jDtCDataNascimento.setDateFormatString("dd/MM/yyyy");
        //jTxtDataNascimento.setDocument(new DataDocument());
        
    }
     
    private void initInstances(){
        //centralizarÃ¡ a tela
        this.setLocationRelativeTo(null);
        this.binder=new AnnotatedBinder(this);
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
        jTxtCns = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jCbalfabetizado = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtIdade = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtSexo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtOcupacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTxtFamilia = new javax.swing.JTextField();
        jBtFamilia = new javax.swing.JButton();
        jBtNovo = new javax.swing.JButton();
        jBtEditar = new javax.swing.JButton();
        jBtConfirmar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbPacientes = new javax.swing.JTable();
        jCbDoencaCondicao = new javax.swing.JComboBox();
        jDtCDataNascimento = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("CNS: ");

        jLabel2.setText("Alfabetizado: ");

        jCbalfabetizado.setModel(new DefaultComboBoxModel(new String[]{"Sim","Não"}));
        jCbalfabetizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbalfabetizadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Data Nascimento: ");

        jLabel4.setText("Nome: ");

        jLabel5.setText("Idade: ");

        jLabel6.setText("Sexo: ");

        jLabel7.setText("Ocupação: ");

        jLabel8.setText("Doença ou Condição Referida: ");

        jLabel9.setText("Familia: ");

        jBtFamilia.setText("...");

        jBtNovo.setText("Novo");

        jBtEditar.setText("Editar");

        jBtConfirmar.setText("Confirmar");

        jBtCancelar.setText("Cancelar");

        jTbPacientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTbPacientes);

        jCbDoencaCondicao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtConfirmar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtCancelar)
                                .addGap(0, 314, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTxtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBtFamilia)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbDoencaCondicao, 0, 201, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(25, 25, 25)
                        .addComponent(jTxtNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(32, 32, 32)
                                .addComponent(jTxtCns, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTxtIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTxtOcupacao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCbalfabetizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDtCDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTxtCns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTxtIdade)
                            .addComponent(jLabel6)
                            .addComponent(jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jCbalfabetizado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTxtOcupacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jDtCDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTxtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtFamilia)
                    .addComponent(jLabel8)
                    .addComponent(jCbDoencaCondicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovo)
                    .addComponent(jBtEditar)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCbalfabetizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbalfabetizadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCbalfabetizadoActionPerformed

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
            java.util.logging.Logger.getLogger(PacienteWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PacienteWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PacienteWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PacienteWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new PacienteWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtEditar;
    private javax.swing.JButton jBtFamilia;
    private javax.swing.JButton jBtNovo;
    @Bindable(field="doencaCondicao",formatter=DoencaCondicaoFormatter.class)
    private javax.swing.JComboBox jCbDoencaCondicao;
    @Bindable(field="alfabetizado",formatter=EscolhaFormatter.class)
    private javax.swing.JComboBox jCbalfabetizado;
    private com.toedter.calendar.JDateChooser jDtCDataNascimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbPacientes;
    @Bindable(field="cns")
    private javax.swing.JTextField jTxtCns;
    @Bindable(field="familia.id",formatter=IntFormatter.class)
    private javax.swing.JTextField jTxtFamilia;
    @Bindable(field="idade",formatter=IntFormatter.class)
    private javax.swing.JTextField jTxtIdade;
    @Bindable(field="nome")
    private javax.swing.JTextField jTxtNome;
    @Bindable(field="ocupacao")
    private javax.swing.JTextField jTxtOcupacao;
    @Bindable(field="sexo",formatter=CharFormatter.class)
    private javax.swing.JTextField jTxtSexo;
    // End of variables declaration//GEN-END:variables
    private ObjectComboBoxModel<Character> modelEscolha;
    private ObjectComboBoxModel<DoencaCondicao> modelDoencaCondicao;

    @Override
    public boolean validaCamposVazios() {
      boolean verifica = false;   
      Component[] componentes = this.getContentPane().getComponents();  
        for (int i = 0; i < componentes.length; i++) {  
            if (componentes[i] instanceof JTextField) {  
                JTextField field = (JTextField)componentes[i];  
                field.setBackground(Color.white);
                
                //se o campo estiver vazio colore o campo de vermelho
                if(field.getText().equals("")){
                   //field.requestFocusInWindow();
                   field.setBackground(Color.red);
                   verifica  = true;
                   
                }  
            }else{
                        if (componentes[i] instanceof JComboBox) {  
                            JComboBox fieldC = (JComboBox)componentes[i];
                            fieldC.setBackground(Color.gray);
                            //se o campo estiver vazio colore o campo de vermelho
                            if(fieldC.getSelectedItem().equals("")){
                                //fieldC.requestFocusInWindow();
                                fieldC.setBackground(Color.red);
                                verifica  = true;
                        }
                }
                    
            }  
            
             
        }
        if(verifica){
            return false;
        }
        return true;
    }
        
    @Override
    public String getCns(){
        return this.jTxtCns.getText();
    }
//    @Override
//    public String getDataNascimento(){
//        return this.jTxtDataNascimento.getText().replaceAll("[/]","");
//    }
    
    @Override
    public Date getDataNascimento(){
        return this.jDtCDataNascimento.getDate();
    }
    
    @Override
    public void setDataNascimento(Date dataNascimento){
        this.jDtCDataNascimento.setDate(dataNascimento);
    }
    @Override
    public void setSelecionarLinhaJTableActionListener(MouseListener listener) {
        this.jTbPacientes.addMouseListener(listener);
    }

    @Override
    public void clearFields() {
      Component[] componentes = this.getContentPane().getComponents();  
          
        for (int i = 0; i < componentes.length; i++) {  
            if (componentes[i] instanceof JTextField) {  
                JTextField field = (JTextField)componentes[i];  
                field.setText("");  
            }  
        }  
    }

    @Override
    public void packAndShow() {
        this.pack();  
        this.setVisible(true);  
    }

    @Override
    public PacienteTableModel getPacienteTableModel() {
       return (PacienteTableModel) this.jTbPacientes.getModel();
    }

    @Override
    public void setPacienteTableModel(PacienteTableModel model) {
        this.jTbPacientes.setModel(model);
        
        // Configura as colunas da JTable  
        TableColumnModel columnModel = this.jTbPacientes.getColumnModel();  
          
        
        columnModel.getColumn(0).setHeaderValue("Cns");  
        columnModel.getColumn(0).setPreferredWidth(200);  
          
        columnModel.getColumn(1).setHeaderValue("Nome");  
        columnModel.getColumn(1).setPreferredWidth(200);  
        
        columnModel.getColumn(2).setHeaderValue("FamÃ­lia");  
        columnModel.getColumn(2).setPreferredWidth(200);  
        
    }

    @Override
    public int linhaSelecionadaTablePacientes() {
      return this.jTbPacientes.getSelectedRow();
    }

    @Override
    public void refreshTablePacientes() {
        this.jTbPacientes.updateUI();
    }

    @Override
    public void setVerifiers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setDocuments() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Binder getBinder() {
       return this.binder;
    }


    @Override
    public void enableTxtCns(boolean arg) {
       this.jTxtCns.setEnabled(arg);
    }

    @Override
    public void enableTxtNome(boolean arg) {
        this.jTxtNome.setEnabled(arg);
    }

    @Override
    public void enableTxtIdade(boolean arg) {
       this.jTxtIdade.setEnabled(arg);
    }

    @Override
    public void enableTxtSexo(boolean arg) {
     this.jTxtSexo.setEnabled(arg);
    }

    @Override
    public void enableJCbAlfabetizado(boolean arg) {
       this.jCbalfabetizado.setEnabled(arg);
    }

    @Override
    public void enableTxtDataNascimento(boolean arg) {
       //this.jTxtDataNascimento.setEnabled(arg);
       this.jDtCDataNascimento.setEnabled(arg); 
    }

    @Override
    public void enableTxtOcupacao(boolean arg) {
        this.jTxtOcupacao.setEnabled(arg);
    }

    @Override
    public void enableTxtFamilia(boolean arg) {
       this.jTxtFamilia.setEnabled(arg);
    }

    @Override
    public void enableCbDoencaCondicao(boolean arg) {
        this.jCbDoencaCondicao.setEnabled(arg);
    }

  @Override
    public void enableBtnNovo(boolean arg) {
       this.jBtNovo.setEnabled(arg);
    }

    @Override
    public void enableBtnEditar(boolean arg) {
       this.jBtEditar.setEnabled(arg);
    }

    @Override
    public void enableBtnConfirmar(boolean arg) {
       this.jBtConfirmar.setEnabled(arg);
    }

    @Override
    public void enableBtnCancelar(boolean arg) {
        this.jBtCancelar.setEnabled(arg);
    }
    
    @Override
    public void enableBtnFamilia(boolean arg) {
        this.jBtFamilia.setEnabled(arg);
    }

    @Override
    public void setNovoActionListener(ActionListener listener) {
        this.jBtNovo.addActionListener(listener);
    }

    @Override
    public void setEditarActionListener(ActionListener listener) {
        this.jBtEditar.addActionListener(listener);
    }

    @Override
    public void setConfirmarActionListener(ActionListener listener) {
       this.jBtConfirmar.addActionListener(listener);
    }

    @Override
    public void setCancelarActionListener(ActionListener listener) {
        this.jBtCancelar.addActionListener(listener);
    }
    
    @Override
    public void setFamiliaActionListener(ActionListener listener) {
        this.jBtFamilia.addActionListener(listener);
    }

    @Override
    public Character getAlfabetizado() {
        return this.jCbalfabetizado.getSelectedItem().toString().charAt(0);
    }

    @Override
    public Integer getIdFamilia() {
        return Integer.parseInt(this.jTxtFamilia.getText());
    }
    
    @Override
    public void setSelectedAlfabetizado(Character c){
        this.modelEscolha.setSelectedObject(c);
    }
    
    
    @Override
    public void setSelectedIndexAlfabetizado(int i){
        this.jCbalfabetizado.setSelectedIndex(i);
    }
    
    @Override
    public void setSelectedDoencaCondicao(DoencaCondicao c){
        this.modelDoencaCondicao.setSelectedObject(c);
    }
    
    
    @Override
    public void setSelectedIndexDoencaCondicao(int i){
        this.jCbDoencaCondicao.setSelectedIndex(i);
    }
    @Override
    public void setTxtCnsDocument(Document d){
        this.jTxtCns.setDocument(d);
    }
    @Override
    public void setTxtNomeDocument(Document d){
        this.jTxtNome.setDocument(d);
    }
    @Override
    public void setTxtIdadeDocument(Document d){
        this.jTxtIdade.setDocument(d);
    }
    @Override
    public void setTxtSexoDocument(Document d){
        this.jTxtSexo.setDocument(d);
    }
    @Override
    public void setTxtOcupacaoDocument(Document d){
        this.jTxtOcupacao.setDocument(d);
    }
    
    
    @Override
    public void setTxtCnsVerifier(InputVerifier verifier){
        this.jTxtCns.setInputVerifier(verifier);
    }
    
//    @Override
//    public void setTxtDatanascimentoVerifier(InputVerifier verifier){
//        this.jTxtDataNascimento.setInputVerifier(verifier);
//    }

    @Override
    public void update(Subject sub, Object arg) {
        if(arg!=null){
            if(arg instanceof Integer){
                //atualiza o valor do campo com o valor vindo do observado
                this.jTxtFamilia.setText(String.valueOf(arg));
            }
        }
    }

//    @Override
//    public void setTxtDataNascimentoDocument(Document d) {
//        this.jTxtDataNascimento.setDocument(d);
//    }
    
    @Override
    public void setCnsFocusListener(FocusListener listener){
        this.jTxtCns.addFocusListener(listener);
    }

  
}
