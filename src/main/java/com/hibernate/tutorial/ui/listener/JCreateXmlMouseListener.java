/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.ui.listener;

import com.hibernate.tutorial.ui.CreateXMlJDialog;
import com.hibernate.tutorial.ui.MainFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Талалаев
 */
public class JCreateXmlMouseListener extends MouseAdapter {

    private MainFrame frame;

    public JCreateXmlMouseListener(MainFrame fr) {
        this.frame = fr;
    }

    @Override
    public void mousePressed(MouseEvent me) {

        CreateXMlJDialog jdialog = new CreateXMlJDialog(getFrame(), true);
        //frame.getDoctorTableModel().g
        jdialog.setVisible(true);

    }

    public MainFrame getFrame() {
        return frame;
    }

}
