/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import eksploator.ui.MainPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author michal
 */
public class Eksploracja_Danych {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        MainPanel mainPanel = MainPanel.getInstance();
        //mainPanel.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainPanel.setVisible(true);
    }

}
