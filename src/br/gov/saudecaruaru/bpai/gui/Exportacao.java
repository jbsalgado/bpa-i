/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Exportacao.java
 *
 * Created on 20/09/2012, 16:41:22
 */
package br.gov.saudecaruaru.bpai.gui;


import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoController;
import br.gov.saudecaruaru.bpai.business.controller.BIProcedimentoRealizadoController;
import br.gov.saudecaruaru.bpai.gui.interfaces.IExportacaoStrategy;
import br.gov.saudecaruaru.bpai.gui.formatter.CompetenciaFormatter;
import br.gov.saudecaruaru.bpai.gui.formatter.UnidadeFormatter;
import br.gov.saudecaruaru.bpai.gui.verifiers.ComboBoxVerifier;
import com.towel.bean.Formatter;
import com.towel.swing.combo.ObjectComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Albuquerque
 */
public class Exportacao extends javax.swing.JDialog {
    
    private IExportacaoStrategy exportacao;
    private FocusListener listenerFieldsChangeBackground;
    private ObjectComboBoxModel<String> comboboxCompetenciaModel= new ObjectComboBoxModel<String>();
    private ObjectComboBoxModel<String> comboboxCnesModel= new ObjectComboBoxModel<String>();
    private BIProcedimentoRealizadoController bIProcedimentoRealizadoController= new BIProcedimentoRealizadoController();

    /** Creates new form Exportacao */
    public Exportacao(java.awt.Frame parent, IExportacaoStrategy exportacao) {
        super(parent);
        initComponents();
        this.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dispose();
                    }
                });
        this.exportacao=exportacao;
        this.comboboxCompetenciaModel.setFormatter(new CompetenciaFormatter());
        this.comboboxCnesModel.setFormatter(new UnidadeFormatter());
        
        List<String> lis=this.bIProcedimentoRealizadoController.getTodasCompetenciaMovimento();
        List<String> list=this.bIProcedimentoRealizadoController.getAllUnidade();
       // lis.add(this.gestorCompetenciaController.getCompetenciaAtual());
        this.comboboxCompetenciaModel.setData(lis);
        this.comboboxCnesModel.setData(list);
        
        this.jComboBoxCompetencia.setModel(comboboxCompetenciaModel);
        this.jComboBoxCnes.setModel(this.comboboxCnesModel);
        
        if(!lis.isEmpty()){
            this.jComboBoxCompetencia.setSelectedIndex(0);
        }
        if(!list.isEmpty()){
            this.jComboBoxCnes.setSelectedIndex(0);
        }
        
        this.jComboBoxCompetencia.setInputVerifier(new ComboBoxVerifier(this, "Competência"));
        this.jComboBoxCnes.setInputVerifier(new ComboBoxVerifier(this, "CNES/Unidade"));
        
        listenerFieldsChangeBackground = new FocusListener() {

            @Override
            public void focusGained(FocusEvent e) {
                Component c = ((Component)e.getComponent());
                if(!c.getBackground().equals(Color.RED) || !c.getBackground().equals(Color.red))
                    ((Component)e.getComponent()).setBackground(Color.GREEN);
            }

            @Override
            public void focusLost(FocusEvent e) {
               ((Component)e.getComponent()).setBackground(Color.WHITE);
            }
        };
        
        this.jComboBoxCnes.addFocusListener(this.listenerFieldsChangeBackground);
        this.jComboBoxCompetencia.addFocusListener(this.listenerFieldsChangeBackground);
    }
    
    public void enabledComboBoxs(boolean abilitar){
        this.jComboBoxCnes.setEnabled(abilitar);
        this.jComboBoxCompetencia.setEnabled(abilitar);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jButtonIniciar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxCompetencia = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCnes = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonIniciar.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonIniciar.setText("Iniciar");
        jButtonIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarActionPerformed(evt);
            }
        });

        jButtonSair.setFont(new java.awt.Font("Tahoma", 0, 14));
        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLabel1.setText("CNES");

        jComboBoxCompetencia.setFont(new java.awt.Font("Tahoma", 0, 14));
        jComboBoxCompetencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Competência");

        jComboBoxCnes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxCnes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jButtonIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxCnes, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBoxCompetencia, 0, 150, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCompetencia, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                    .addComponent(jComboBoxCnes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSair)
                    .addComponent(jButtonIniciar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarActionPerformed
        // TODO add your handling code here:
        BIProcedimentoController bipc = new BIProcedimentoController();
        //antes da exportação atualiza a base de procedimentos com os procedimentos digitados
         try{
            bipc.insereProcedimentosSemReferencia();
        }catch(Exception ex){
            ex.printStackTrace();
        }
         
        this.jProgressBar1.setIndeterminate(true);
        this.jButtonIniciar.setEnabled(true);
        
        String res=this.exportacao.execute(this.comboboxCompetenciaModel.getSelectedObject(),this.comboboxCnesModel.getSelectedObject());
       
        JOptionPane.showMessageDialog(this, res);
        this.jProgressBar1.setIndeterminate(false);
        this.jProgressBar1.setString(null);
        this.jProgressBar1.setValue(100);
    }//GEN-LAST:event_jButtonIniciarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Exportacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Exportacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Exportacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Exportacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//
//            public void run() {
//                Exportacao dialog = new Exportacao(new javax.swing.JFrame());
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciar;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JComboBox jComboBoxCnes;
    private javax.swing.JComboBox jComboBoxCompetencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
