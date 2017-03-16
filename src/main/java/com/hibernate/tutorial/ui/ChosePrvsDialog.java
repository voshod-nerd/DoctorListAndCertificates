/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui;

import com.hibernate.tutorial.app.interfaces.SetGetSkv015;
import com.hibernate.tutorial.config.SpringContext;
import com.hibernate.tutorial.service.HibernateMain;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import com.hibernate.tutorial.entity.SkV015;
import com.hibernate.tutorial.ui.model.PrvsTableModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ��������
 */
public class ChosePrvsDialog extends javax.swing.JDialog {

    private HibernateMain hiber;
    private ApplicationContext context;
    private PrvsTableModel tablemodel;
    private TableRowSorter<PrvsTableModel> sorter;
    private JDialog parent;
    private SkV015 chosenPrvs;

    /**
     * Creates new form JChosePRVSDialog
     */
    public ChosePrvsDialog(java.awt.Dialog parent, boolean modal) {

        super(parent, modal);
        //parent = (java.awt.Dialog)parent;

        context = new AnnotationConfigApplicationContext(SpringContext.class);
        hiber = (HibernateMain) context.getBean("HibernateMain");
        List<SkV015> listPRVS = hiber.getSpisokSkV015();
        tablemodel = new PrvsTableModel(listPRVS);

        initComponents();
        jTable1.setFillsViewportHeight(true);
        //---------------------------- Sorted and filter
        sorter = new TableRowSorter<PrvsTableModel>(tablemodel);
        jTable1.setRowSorter(sorter);

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int viewRow = jTable1.getSelectedRow();
                if (viewRow < 0) {
                    //Selection got filtered away.
                    statusText.setText("");
                } else {
                    int modelRow
                            = jTable1.convertRowIndexToModel(viewRow);
                    setChosenPrvs(tablemodel.getRowByIndex(modelRow));
                    
                    //SetGetSkv015 p = (SetGetSkv015) parent;
                    //p.setChosenPrvs(tablemodel.getRowByIndex(modelRow));
                   
                    statusText.setText(getChosenPrvs().getName());
                }
            }
        }
        );
        //For the purposes of this example, better to have a single
        //selection.
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // jTable1.setAutoCreateRowSorter(true);
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {

                newFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilter();
            }

            private void newFilter() {
                RowFilter<PrvsTableModel, Object> rf = null;

                //If current expression doesn't parse, don't update.
                try {
                    rf = RowFilter.regexFilter(filterText.getText());

                } catch (java.util.regex.PatternSyntaxException e) {
                    return;
                }
                System.out.println("Why it doesnt work?");
                sorter.setRowFilter(rf);

            }
        });

    }

    /*
    private void newFilter() {
        RowFilter<PrvsTableModel, Object> rf = null;

        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 2);

        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        System.out.println("Why it doesnt work?");
        sorter.setRowFilter(rf);

    }
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        filterText = new javax.swing.JTextField();
        statusText = new javax.swing.JTextField();
        ChooseButton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane1.setToolTipText("");

        jTable1.setModel(tablemodel);
        jTable1.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("����� �� �������� �������������");

        ChooseButton.setText("�������");
        ChooseButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ChooseButtonMouseClicked(evt);
            }
        });
        ChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusText)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addComponent(filterText))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 724, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(filterText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ChooseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ChooseButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ChooseButtonMouseClicked
        // TODO add your JOpthandling code here:

        if (chosenPrvs != null) {    
            SetGetSkv015 window = (SetGetSkv015)this.getParent();
            window.setChosenPrvs(chosenPrvs);
            dispose();
        } else {
            // show a joptionpane dialog using showMessageDialog

            JFrame frame = new JFrame("���������");
            JOptionPane.showMessageDialog(frame,
                    "�� �� ������� �������������"
                    );

        }

    }//GEN-LAST:event_ChooseButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
      
        
    }//GEN-LAST:event_formWindowClosing

    private void ChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooseButtonActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_ChooseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChosePrvsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChosePrvsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChosePrvsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChosePrvsDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChosePrvsDialog dialog = new ChosePrvsDialog(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton ChooseButton;
    private javax.swing.JTextField filterText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField statusText;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the chosenPrvs
     */
    public SkV015 getChosenPrvs() {
        return chosenPrvs;
    }

    /**
     * @param chosenPrvs the chosenPrvs to set
     */
    public void setChosenPrvs(SkV015 chosenPrvs) {
        this.chosenPrvs = chosenPrvs;
    }
}
