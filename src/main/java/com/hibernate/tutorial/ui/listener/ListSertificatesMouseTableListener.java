/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.listener;

import com.hibernate.tutorial.ui.EditSertificateJDialog;
import com.hibernate.tutorial.ui.MainFrame;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;

/**
 *
 * @author Талалаев
 */
public class ListSertificatesMouseTableListener extends MouseAdapter {
    private MainFrame frame;
    
     
    
    
    
    public  ListSertificatesMouseTableListener(MainFrame fr){
    this.frame=fr;
    }
   
    @Override
    public void mousePressed(MouseEvent me) {
     JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    EditSertificateJDialog jdialog =new EditSertificateJDialog(getFrame(),true);
                    jdialog.addObserver(getFrame());
                    jdialog.setVisible(true);
                }
    
    }

    /**
     * @return the frame
     */
    public MainFrame getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(MainFrame frame) {
        this.frame = frame;
    } 
}
