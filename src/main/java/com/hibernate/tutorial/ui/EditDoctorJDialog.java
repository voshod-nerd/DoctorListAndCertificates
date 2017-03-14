/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui;

import com.hibernate.tutorial.config.SpringContext;
import com.hibernate.tutorial.entity.SpisokVrach;
import com.hibernate.tutorial.service.HibernateMain;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author
 */
public class EditDoctorJDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditDoctorJDialog
     */
    private SpisokVrach doctor;
    private HibernateMain hiber;
    private ApplicationContext context;
    private MainFrame frame;

    public EditDoctorJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        frame = (MainFrame) parent;

        SpisokVrach doctor = frame.getSelectedDoctor();
        if (doctor.getIddokt() != null) {
            jTextFieldIdDoct.setText(doctor.getIddokt().toString());
        }
        if (doctor.getFam() != null) {
            jTextFieldFam.setText(doctor.getFam());
        }
        if (doctor.getIm() != null) {
            jTextFieldIm.setText(doctor.getIm());
        }
        if (doctor.getOt() != null) {
            jTextFieldOt.setText(doctor.getOt());
        }
        if (doctor.getLpukod() != null) {
            jTextFieldLpu.setText(doctor.getLpukod().toString());
        }
        if (doctor.getIdOtd() != null) {
            jTextFieldOtd.setText(doctor.getIdOtd().toString());
        }
        if (doctor.getIdPodr() != null) {
            jTextFieldPodr.setText(doctor.getIdPodr().toString());
        }
        if (doctor.getDokt() != null) {
            jCheckBox1.setSelected(doctor.getDokt());
        }
        if (doctor.getDateVn() != null) {
            jDateChooser1.setDate(doctor.getDateVn());
        }
        if (doctor.getDateUv() != null) {
            jDateChooser2.setDate(doctor.getDateUv());
        }

        // init spring cotext
        context = new AnnotationConfigApplicationContext(SpringContext.class);
        hiber = (HibernateMain) context.getBean("HibernateMain");

    }

    EditDoctorJDialog() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldIdDoct = new javax.swing.JTextField();
        jTextFieldLpu = new javax.swing.JTextField();
        jTextFieldPodr = new javax.swing.JTextField();
        jTextFieldOtd = new javax.swing.JTextField();
        jTextFieldFam = new javax.swing.JTextField();
        jTextFieldIm = new javax.swing.JTextField();
        jTextFieldOt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextFieldIdDoct.setName("jIdDoctTextField"); // NOI18N

        jTextFieldLpu.setName("jLpuCodeTextField"); // NOI18N

        jTextFieldPodr.setName("jIdPodrTextField"); // NOI18N

        jTextFieldOtd.setName("jOtdTextField"); // NOI18N

        jTextFieldFam.setName("jFamTextField"); // NOI18N

        jTextFieldIm.setName("jImTextField"); // NOI18N

        jTextFieldOt.setName("jOtTextField"); // NOI18N

        jLabel1.setText("��� �������");

        jLabel2.setText("���");

        jLabel3.setText("�������������");

        jLabel4.setText("���������");

        jLabel5.setText("�������");

        jLabel6.setText("���");

        jLabel7.setText("��������");

        jCheckBox1.setText("������� �����");
        jCheckBox1.setActionCommand("jDoctorCheckBox");

        jLabel8.setText("���� ��������");

        jLabel9.setText("���� ����������");

        jButton1.setText("��������");
        jButton1.setName("jUpdateButton"); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldLpu, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(jTextFieldIdDoct))
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldPodr, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(jTextFieldOtd)
                                .addComponent(jTextFieldOt)
                                .addComponent(jTextFieldIm)
                                .addComponent(jTextFieldFam))
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jCheckBox1)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jTextFieldIdDoct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldLpu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldPodr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel4)
                .addGap(2, 2, 2)
                .addComponent(jTextFieldOtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(3, 3, 3)
                .addComponent(jTextFieldIm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(jTextFieldOt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        SpisokVrach doctor = new SpisokVrach();  
        if (!jTextFieldIdDoct.getText().equals("")) {
            
            
          
            doctor.setPrvs(frame.getSelectedDoctor().getPrvs());
            doctor.setIddokt(Integer.parseInt(jTextFieldIdDoct.getText()));
            if (!jTextFieldOtd.getText().equals("")) doctor.setIdOtd(Integer.parseInt(jTextFieldOtd.getText()));
            if (!jTextFieldLpu.getText().equals("")) doctor.setLpukod(Integer.parseInt(jTextFieldLpu.getText()));
            if (!jTextFieldPodr.getText().equals("")) doctor.setIdPodr(Integer.parseInt(jTextFieldPodr.getText()));
            if (!jTextFieldFam.getText().equals("")) doctor.setFam(jTextFieldFam.getText());
            if (!jTextFieldIm.getText().equals("")) doctor.setIm(jTextFieldIm.getText());
            if (!jTextFieldOt.getText().equals("")) doctor.setOt(jTextFieldOt.getText());
            doctor.setDokt(jCheckBox1.isSelected());
            if (jDateChooser1.getDate()!=null) doctor.setDateVn(jDateChooser1.getDate());
            if (jDateChooser2.getDate()!=null) doctor.setDateUv(jDateChooser2.getDate()); 
            
            List<SpisokVrach> list = new ArrayList<>();
            list.add(doctor);
            hiber.UpdateSpisokVrach(list);
             this.dispose();
        } else {
        JFrame frame = new JFrame("���������");
            JOptionPane.showMessageDialog(frame,
                    "�� �� ������� �������������"
                    );
        
        }
       
        
       
       
        
        
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(EditDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditDoctorJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditDoctorJDialog dialog = new EditDoctorJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldFam;
    private javax.swing.JTextField jTextFieldIdDoct;
    private javax.swing.JTextField jTextFieldIm;
    private javax.swing.JTextField jTextFieldLpu;
    private javax.swing.JTextField jTextFieldOt;
    private javax.swing.JTextField jTextFieldOtd;
    private javax.swing.JTextField jTextFieldPodr;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the doctor
     */
    public SpisokVrach getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(SpisokVrach doctor) {
        this.doctor = doctor;
    }
}