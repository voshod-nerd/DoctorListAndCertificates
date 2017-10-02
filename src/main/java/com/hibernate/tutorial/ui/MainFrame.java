/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui;

import com.hibernate.tutorial.app.interfaces.ObserverChangeDatabaseContent;
import com.hibernate.tutorial.config.SpringContext;
import com.hibernate.tutorial.entity.Sertif;
import com.hibernate.tutorial.entity.SkV015;
import com.hibernate.tutorial.entity.SpisokVrach;
import com.hibernate.tutorial.service.HibernateMain;
import com.hibernate.tutorial.ui.listener.JAddDoctorMouseListener;
import com.hibernate.tutorial.ui.listener.JAddSertificateMouseListener;
import com.hibernate.tutorial.ui.listener.JCreateXmlMouseListener;
import com.hibernate.tutorial.ui.model.SerificateTableModel;
import com.hibernate.tutorial.ui.model.SpisokVrachTableModel;
import com.hibernate.tutorial.ui.listener.ListDoctorsMouseTableListener;
import com.hibernate.tutorial.ui.listener.ListSertificatesMouseTableListener;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ????????
 */
public class MainFrame extends javax.swing.JFrame implements ObserverChangeDatabaseContent {

    HibernateMain hiber;
    private javax.swing.JTable tblSpisokVrach;
    private javax.swing.JTable tblSertif;
    private String[] args;
    private ApplicationContext context;
    private javax.swing.JMenuBar jMenuBar1;
    //private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private TableRowSorter<SpisokVrachTableModel> sorterVr;
    private TableRowSorter<SerificateTableModel> sorterSertif;
    private JTextField filterText;
    private SpisokVrachTableModel doctorTableModel;
    private SerificateTableModel sertificateTableModel;
    private SpisokVrach selectedDoctor;
    private Sertif selectedSertificate;

    /**
     * Creates new form MainFrame
     */
    public void init() {

        context = new AnnotationConfigApplicationContext(SpringContext.class);
        hiber = (HibernateMain) context.getBean("HibernateMain");

        setDoctorTableModel(new SpisokVrachTableModel(hiber.getSpisokVrach()));
        tblSpisokVrach = new JTable(doctorTableModel);
        setSertificateTableModel(new SerificateTableModel(hiber.getSertifAll()));
        tblSertif = new JTable(sertificateTableModel);

        //Create a table with a sorter.
        sorterVr = new TableRowSorter<>((SpisokVrachTableModel) doctorTableModel);
        tblSpisokVrach.setRowSorter(sorterVr);
        sorterSertif = new TableRowSorter<>((SerificateTableModel) sertificateTableModel);
        tblSertif.setRowSorter(sorterSertif);

        tblSpisokVrach.setSize(new Dimension(900, 150));
        tblSertif.setSize(new Dimension(900, 150));

        tblSpisokVrach.addMouseListener(new ListDoctorsMouseTableListener(this));
        tblSertif.addMouseListener(new ListSertificatesMouseTableListener(this));

        //Create the menu bar.
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu("Меню");
        jMenuBar1.add(jMenu1);

        jMenuItem1 = new JMenuItem("Добавить врача",
                KeyEvent.VK_T);
        jMenuItem3 = new JMenuItem("Добавить сертификат",
                KeyEvent.VK_T);

        jMenuItem2 = new JMenuItem("Экспорт в xml"
                + "",
                KeyEvent.VK_T);
        jMenu1.add(jMenuItem1);
        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem2);

        jMenuItem1.addMouseListener(new JAddDoctorMouseListener(this));
        jMenuItem3.addMouseListener(new JAddSertificateMouseListener(this));
        jMenuItem2.addMouseListener(new JCreateXmlMouseListener(this));

        filterText = new JTextField();
        //Whenever filterText changes, invoke newFilter.
        filterText.getDocument().addDocumentListener(
                new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                newFilterDoctor();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                newFilterDoctor();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                newFilterDoctor();
            }
        });

        JLabel label = new JLabel("Поиск по фамилии");

        this.setJMenuBar(jMenuBar1);
        Box contents = new Box(BoxLayout.Y_AXIS);

        contents.add(new JScrollPane(tblSpisokVrach));
        contents.add(label);
        contents.add(filterText);
        contents.add(new JScrollPane(tblSertif));

        this.getContentPane().add(contents);
        setPreferredSize(new Dimension(910, 700));
        this.pack();
        MainFrame.setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        //For the purposes of this example, better to have a single
        //selection.
        tblSpisokVrach.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //When selection changes, provide user with row numbers for
        //both view and model.
        tblSpisokVrach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                int viewRow = tblSpisokVrach.getSelectedRow();
                if (viewRow < 0) {
                    //Selection got filtered away.
                    //statusText.setText("");
                } else {
                    int modelRow = tblSpisokVrach.convertRowIndexToModel(viewRow);
                    SpisokVrachTableModel model;
                    model = (SpisokVrachTableModel) doctorTableModel;

                    SpisokVrach value = model.getRowByIndex(modelRow);
                    setSelectedDoctor(value);
                    newFilterSertif(value);
                }
            }
        }
        );
        // selection one of list of certificate 
        tblSertif.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                int viewRow = tblSertif.getSelectedRow();
                if (viewRow < 0) {
                    //Selection got filtered away.
                    //statusText.setText("");
                } else {
                    int modelRow = tblSertif.convertRowIndexToModel(viewRow);
                    SerificateTableModel model;
                    model = (SerificateTableModel) sertificateTableModel;

                    Sertif value = model.getRowByIndex(modelRow);
                    setSelectedSertificate(value);
                    //newFilterSertif(value);
                }
            }
        }
        );

    }

    private void newFilterDoctor() {
        RowFilter<SpisokVrachTableModel, Object> rf = null;
        //If current expression doesn't parse, don't update.
        try {
            rf = RowFilter.regexFilter(filterText.getText(), 4);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorterVr.setRowFilter(rf);
    }

    private void newFilterSertif(SpisokVrach value) {
        RowFilter<SerificateTableModel, Object> rf = null;

        try {
            rf = RowFilter.regexFilter(value.getIddokt().toString(), 5);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorterSertif.setRowFilter(rf);
    }

    public MainFrame() {

    }

    public void UpdateTableSpisokVrach() {
        doctorTableModel.setListDoctors(hiber.getSpisokVrach());
        sertificateTableModel.fireTableDataChanged();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged


    }//GEN-LAST:event_formWindowStateChanged

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:


    }//GEN-LAST:event_formWindowGainedFocus


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the selectedDoctor
     */
    public SpisokVrach getSelectedDoctor() {
        return selectedDoctor;
    }

    /**
     * @param selectedDoctor the selectedDoctor to set
     */
    public void setSelectedDoctor(SpisokVrach selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }

    /**
     * @return the selectedSertificate
     */
    public Sertif getSelectedSertificate() {
        return selectedSertificate;
    }

    /**
     * @param selectedSertificate the selectedSertificate to set
     */
    public void setSelectedSertificate(Sertif selectedSertificate) {
        this.selectedSertificate = selectedSertificate;
    }

    @Override
    public void handleEventChageDatabaseContent() {
        doctorTableModel.setListDoctors(hiber.getSpisokVrach());
        sertificateTableModel.setListSertificates(hiber.getSertifAll());
        tblSpisokVrach.updateUI();
        tblSertif.updateUI();;
    }

    /**
     * @param doctorTableModel the doctorTableModel to set
     */
    public void setDoctorTableModel(SpisokVrachTableModel doctorTableModel) {
        this.doctorTableModel = doctorTableModel;
    }

    /**
     * @param sertificateTableModel the sertificateTableModel to set
     */
    public void setSertificateTableModel(SerificateTableModel sertificateTableModel) {
        this.sertificateTableModel = sertificateTableModel;
    }

    
}
