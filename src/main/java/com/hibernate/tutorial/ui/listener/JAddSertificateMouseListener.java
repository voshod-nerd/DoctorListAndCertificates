/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.listener;

import com.hibernate.tutorial.app.interfaces.ObserverChangeDatabaseContent;
import com.hibernate.tutorial.ui.AddCertificateJDialog;
import com.hibernate.tutorial.ui.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Талалаев
 */
public class JAddSertificateMouseListener  extends MouseAdapter {
      private MainFrame frame;
    
    public JAddSertificateMouseListener(MainFrame frame) {
    this.frame = frame;
    } 
    
    
    @Override
    public void mousePressed(MouseEvent me) {
        AddCertificateJDialog jdialog =new AddCertificateJDialog(getFrame(),true);
         jdialog.addObserver((ObserverChangeDatabaseContent)getFrame());
                    jdialog.setVisible(true);
    
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
