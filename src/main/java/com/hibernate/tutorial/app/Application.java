/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hibernate.tutorial.app;

import com.hibernate.tutorial.ui.MainFrame;

/**
 *
 * @author Талалаев
 */
public class Application {
    
    
    private static void createAndShowGUI() {
        MainFrame mainFrame = new MainFrame();
        mainFrame.init();
    }
    
    

    public static void main(String[] args) {
       //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
