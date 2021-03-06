/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SIABPrincipalWindow.java
 *
 * Created on 05/02/2013, 17:27:42
 */
package br.gov.saudecaruaru.bpai.gui;

import br.gov.saudecaruaru.bpai.gui.interfaces.SIABPrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author Albuquerque
 */
public class SIABPrincipalWindow extends javax.swing.JFrame implements SIABPrincipalView{

    /** Creates new form SIABPrincipalWindow */
    public SIABPrincipalWindow() {
        initComponents();
        this.myInitComponents();
    }
    
    private void myInitComponents(){
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
            
        });
        //vai sair do sistema
        this.setMenuItemSairActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemFamilia = new javax.swing.JMenuItem();
        menuItemPaciente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        MenuItemImportarCnes = new javax.swing.JMenuItem();
        MenuItemImportarOcupacao = new javax.swing.JMenuItem();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMenu1.setText("Sistema");

        menuItemSair.setText("Sair");
        jMenu1.add(menuItemSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Cadastro");

        menuItemFamilia.setText("Família");
        jMenu2.add(menuItemFamilia);

        menuItemPaciente.setText("Paciente");
        jMenu2.add(menuItemPaciente);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Operações");

        MenuItemImportarCnes.setText("Importar Arquivo Cnes");
        jMenu3.add(MenuItemImportarCnes);

        MenuItemImportarOcupacao.setText("Importar Arquivo Ocupação");
        jMenu3.add(MenuItemImportarOcupacao);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SIABPrincipalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIABPrincipalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIABPrincipalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIABPrincipalWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SIABPrincipalWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuItemImportarCnes;
    private javax.swing.JMenuItem MenuItemImportarOcupacao;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JMenuItem menuItemFamilia;
    private javax.swing.JMenuItem menuItemPaciente;
    private javax.swing.JMenuItem menuItemSair;
    // End of variables declaration//GEN-END:variables

    @Override
    public void packAndShow() {
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void setMenuItemFamiliaActionListener(ActionListener actionListener) {
        this.menuItemFamilia.addActionListener(actionListener);
    }

    @Override
    public void setMenuItemPacienteActionListener(ActionListener actionListener) {
        this.menuItemPaciente.addActionListener(actionListener);
    }

    @Override
    public void setMenuItemFamiliaMouseListener(MouseListener mouseListener) {
        this.menuItemFamilia.addMouseListener(mouseListener);
    }

    @Override
    public void setMenuItemPacienteMouseListener(MouseListener mouseListener) {
        this.menuItemPaciente.addMouseListener(mouseListener);
    }

    @Override
    public void setMenuItemSairActionListener(ActionListener actionListener) {
        this.menuItemSair.addActionListener(actionListener);
    }

    @Override
    public void setMenuItemSairMouseListener(MouseListener mouseListener) {
        this.menuItemSair.addMouseListener(mouseListener);
    }
    
     @Override
    public void setMenuItemImportarCnesActionListener(ActionListener actionListener) {
        this.MenuItemImportarCnes.addActionListener(actionListener);
    }

    @Override
    public void setMenuItemImportarOcupacaoActionListener(ActionListener actionListener) {
        this.MenuItemImportarOcupacao.addActionListener(actionListener);
    }
}
