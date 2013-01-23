/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.business.model.BIFamilia;
import br.gov.saudecaruaru.bpai.gui.interfaces.FamiliaView;
import com.towel.bind.Binder;
import com.towel.bind.annotation.AnnotatedBinder;
import com.towel.bind.annotation.Bindable;
import com.towel.bind.annotation.Form;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JDialog;
import javax.swing.JTextField;

/**
 *
 * @author juniorpires
 */
@Form(BIFamilia.class)
public class FamiliaWindow extends javax.swing.JFrame implements FamiliaView{
     private Binder binder;
    /**
     * Creates new form FamiliaWindow
     */
    public FamiliaWindow() {
        initComponents();
        initInstances();
        this.initMyComponents();
    }

     private void initMyComponents(){
         
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.initInstances();
    }
     
    private void initInstances(){
        //centralizará a tela
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
        jTxtSegmento = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTxtArea = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtMicroArea = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTxtFamilia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTxtendereco = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtNumero = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTxtBairro = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTxtCep = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTxtMunicipio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTxtUF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTxtDataCadastro = new javax.swing.JTextField();
        jBtNovo = new javax.swing.JButton();
        jBtEditar = new javax.swing.JButton();
        jBtConfirmar = new javax.swing.JButton();
        jBtCancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbFamilias = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Segmento");

        jLabel2.setText("Área");

        jLabel3.setText("Microarea");

        jLabel4.setText("Família");

        jLabel5.setText("Endereço");

        jLabel6.setText("Número");

        jLabel7.setText("Bairro");

        jLabel8.setText("CEP");

        jLabel9.setText("Município");

        jLabel10.setText("UF");

        jLabel11.setText("Data");

        jBtNovo.setText("Novo");

        jBtEditar.setText("Editar");

        jBtConfirmar.setText("Confirmar");

        jBtCancelar.setText("Cancelar");

        jTbFamilias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTbFamilias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(22, 22, 22))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jTxtMunicipio))
                                        .addComponent(jTxtendereco, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1)
                                                .addComponent(jTxtSegmento, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3)
                                                .addComponent(jTxtMicroArea, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel4)
                                                .addComponent(jTxtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(0, 13, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel9)
                                .addGap(168, 168, 168)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTxtNumero)
                            .addComponent(jTxtUF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jTxtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
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
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtSegmento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMicroArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtNovo)
                    .addComponent(jBtEditar)
                    .addComponent(jBtConfirmar)
                    .addComponent(jBtCancelar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FamiliaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FamiliaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FamiliaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FamiliaWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FamiliaWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtCancelar;
    private javax.swing.JButton jBtConfirmar;
    private javax.swing.JButton jBtEditar;
    private javax.swing.JButton jBtNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbFamilias;
    @Bindable(field="area")
    private javax.swing.JTextField jTxtArea;
    @Bindable(field="bairro")
    private javax.swing.JTextField jTxtBairro;
    @Bindable(field="cep")
    private javax.swing.JTextField jTxtCep;
    @Bindable(field="dataCadastro")
    private javax.swing.JTextField jTxtDataCadastro;
    @Bindable(field="familia")
    private javax.swing.JTextField jTxtFamilia;
    @Bindable(field="microArea")
    private javax.swing.JTextField jTxtMicroArea;
    @Bindable(field="municipio")
    private javax.swing.JTextField jTxtMunicipio;
    @Bindable(field="numero")
    private javax.swing.JTextField jTxtNumero;
    @Bindable(field="segmento")
    private javax.swing.JTextField jTxtSegmento;
    @Bindable(field="uf")
    private javax.swing.JTextField jTxtUF;
    @Bindable(field="endereco")
    private javax.swing.JTextField jTxtendereco;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setSelecionarLinhaJTableActionListener(MouseListener listener) {
        this.jTbFamilias.addMouseListener(listener);
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
    public FamiliaTableModel getFamiliaTableModel() {
       return (FamiliaTableModel) this.jTbFamilias.getModel();
    }

    @Override
    public void setFamiliaTableModel(FamiliaTableModel model) {
        this.jTbFamilias.setModel(model);
    }

    @Override
    public int linhaSelecionadaTableFamilias() {
      return this.jTbFamilias.getSelectedRow();
    }

    @Override
    public void refreshTableFamilias() {
        this.jTbFamilias.updateUI();
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
    public void enableTxtSegmento(boolean arg) {
       this.jTxtSegmento.setEnabled(arg);
    }

    @Override
    public void enableTxtArea(boolean arg) {
        this.jTxtArea.setEnabled(arg);
    }

    @Override
    public void enableTxtMicroarea(boolean arg) {
       this.jTxtMicroArea.setEnabled(arg);
    }

    @Override
    public void enableTxtFamilia(boolean arg) {
       this.jTxtFamilia.setEnabled(arg);
    }

    @Override
    public void enableTxtEndereco(boolean arg) {
       this.jTxtendereco.setEnabled(arg);
    }

    @Override
    public void enableTxtNumero(boolean arg) {
        this.jTxtNumero.setEnabled(arg);
    }

    @Override
    public void enableTxtBairro(boolean arg) {
       this.jTxtBairro.setEnabled(arg);
    }

    @Override
    public void enableTxtCep(boolean arg) {
       this.jTxtCep.setEnabled(arg);
    }

    @Override
    public void enableTxtMunicipio(boolean arg) {
      this.jTxtMunicipio.setEnabled(arg);
    }

    @Override
    public void enableTxtUF(boolean arg) {
       this.jTxtUF.setEnabled(arg);
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
    public void enableTxtDataCadastro(boolean arg) {
        this.jTxtDataCadastro.setEnabled(arg);
    }
}
