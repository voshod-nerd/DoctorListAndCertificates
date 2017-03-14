/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.listener;

import com.hibernate.tutorial.ui.AddDoctorJDialog;
import com.hibernate.tutorial.ui.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Талалаев
 */
public class JAddDoctorMouseListener extends MouseAdapter {
     private MainFrame frame;
     
     
     
    public JAddDoctorMouseListener(MainFrame frame) {
    this.frame = frame;
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
    
    @Override
    public void mousePressed(MouseEvent me) {
        AddDoctorJDialog jdialog =new AddDoctorJDialog(getFrame(),true);
                    jdialog.setVisible(true);
    
    }
    
    
}
