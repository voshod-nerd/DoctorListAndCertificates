/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui;

import com.hibernate.tutorial.app.interfaces.SetGetSkv015;
import com.hibernate.tutorial.config.SpringContext;
import com.hibernate.tutorial.entity.SkV015;
import com.hibernate.tutorial.entity.SpisokVrach;
import com.hibernate.tutorial.service.HibernateMain;

import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author
 */
public class AddDoctorJDialog extends javax.swing.JDialog implements SetGetSkv015 {

    private HibernateMain hiber;
    private ApplicationContext context;
    private SkV015 chosenPrvs;
    private ChosePrvsDialog forms;

    /**
     * Creates new form AddDoctorJDialog
     */
    public AddDoctorJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

       // jAddPrvsButton.addMouseListener(new JChosePRVSMouseListener(this));

        context = new AnnotationConfigApplicationContext(SpringContext.class);
        hiber = (HibernateMain) context.getBean("HibernateMain");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jIdDoctTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLpuTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPodrTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPodrTextFiield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jFamTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jImTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jOtTextField = new javax.swing.JTextField();
        jDoctCheckBox = new javax.swing.JCheckBox();
        prvsDoctor = new javax.swing.JLabel();
        jSaveButton = new javax.swing.JButton();
        jAddPrvsButton = new javax.swing.JButton();
        PrvsLabel = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("* ��� �������");

        jLabel2.setText("���");
        jLabel2.setToolTipText("");

        jLabel3.setText("�������������");

        jLabel4.setText("���������");

        jLabel5.setText("* �������");

        jLabel6.setText("* ���");

        jLabel7.setText("��������");

        jDoctCheckBox.setText("������� �������");

        prvsDoctor.setText("������������� �����");

        jSaveButton.setText("��������");
        jSaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSaveButtonMouseClicked(evt);
            }
        });
        jSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSaveButtonActionPerformed(evt);
            }
        });

        jAddPrvsButton.setText("������� �������������");
        jAddPrvsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddPrvsButtonActionPerformed(evt);
            }
        });

        jLabel9.setText("* �������� ������������ ����");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOtTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jImTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jFamTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPodrTextFiield, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPodrTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLpuTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jIdDoctTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSaveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jAddPrvsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PrvsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDoctCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prvsDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 220, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jIdDoctTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLpuTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(jPodrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(7, 7, 7)
                .addComponent(jPodrTextFiield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFamTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jImTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jOtTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDoctCheckBox)
                .addGap(6, 6, 6)
                .addComponent(prvsDoctor)
                .addGap(18, 18, 18)
                .addComponent(jAddPrvsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PrvsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jSaveButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSaveButtonActionPerformed
        // TODO add your handling code here:
         try {
            SpisokVrach vrach = new SpisokVrach();
            if (!jIdDoctTextField.getText().isEmpty()) {
                vrach.setIddokt(Integer.parseInt(jIdDoctTextField.getText()));
            }

            if (!jIdDoctTextField.getText().isEmpty()) {
                vrach.setIdOtd(Integer.parseInt(jIdDoctTextField.getText()));
            }

            if (!jLpuTextField.getText().isEmpty()) {
                vrach.setLpukod(Integer.parseInt(jLpuTextField.getText()));
            }

            vrach.setFam(jFamTextField.getText());
            vrach.setIm(jImTextField.getText());

            if (!jOtTextField.getText().equals("")) {
                vrach.setOt(jOtTextField.getText());
            }

            vrach.setDokt(jDoctCheckBox.isSelected());
            
            if (getChosenPrvs()!= null) {
            vrach.setPrvs(getChosenPrvs());}
            
            System.out.println(vrach.getPrvs().getName());
            hiber.InsertSpisokVrach(vrach);
            dispose();
        } catch (Exception er) {
            JFrame frame = new JFrame("������ �����");
            JOptionPane.showMessageDialog(frame, er.fillInStackTrace(), "������ �����",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jSaveButtonActionPerformed

    private void jSaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSaveButtonMouseClicked
        // TODO add your handling code here:

       


    }//GEN-LAST:event_jSaveButtonMouseClicked

    private void jAddPrvsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddPrvsButtonActionPerformed
        // TODO add your handling code here:
        ChosePrvsDialog fr=new ChosePrvsDialog(this,true);
        fr.setVisible(true);
    }//GEN-LAST:event_jAddPrvsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDoctorJDialog dialog = new AddDoctorJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PrvsLabel;
    private javax.swing.JButton jAddPrvsButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JCheckBox jDoctCheckBox;
    private javax.swing.JTextField jFamTextField;
    private javax.swing.JTextField jIdDoctTextField;
    private javax.swing.JTextField jImTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jLpuTextField;
    private javax.swing.JTextField jOtTextField;
    private javax.swing.JTextField jPodrTextField;
    private javax.swing.JTextField jPodrTextFiield;
    private javax.swing.JButton jSaveButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel prvsDoctor;
    // End of variables declaration//GEN-END:variables

    /**
     * @param chosenPrvs the chosenPrvs to set
     */
    public void setChosenPrvs(SkV015 chosenPrvs) {
        this.chosenPrvs = chosenPrvs;
        prvsDoctor.setText(chosenPrvs.getName());
    }

    /**
     * @return the chosenPrvs
     */
    public SkV015 getChosenPrvs() {
        return chosenPrvs;
    }
}
