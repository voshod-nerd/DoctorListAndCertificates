/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.listener;


import com.hibernate.tutorial.ui.AddDoctorJDialog;
import com.hibernate.tutorial.ui.ChosePrvsDialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Талалаев
 */
public class JChosePRVSMouseListener extends MouseAdapter {
     private AddDoctorJDialog frame;
    
     
    public  JChosePRVSMouseListener(AddDoctorJDialog frame) {
    this.frame=frame;
    } 
    
    
    
     
    @Override
    public void mousePressed(MouseEvent me) {
       
        ChosePrvsDialog jdialog =new ChosePrvsDialog(getFrame(),true);
                    jdialog.setVisible(true);
    
    }

    /**
     * @return the frame
     */
    public AddDoctorJDialog getFrame() {
        return frame;
    }

    /**
     * @param frame the frame to set
     */
    public void setFrame(AddDoctorJDialog frame) {
        this.frame = frame;
    }
    
}
