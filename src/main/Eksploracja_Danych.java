/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author michal
 */
public class Eksploracja_Danych {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MainPanel mainPanel = new MainPanel();
        mainPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setVisible(true);
    }
    
}
