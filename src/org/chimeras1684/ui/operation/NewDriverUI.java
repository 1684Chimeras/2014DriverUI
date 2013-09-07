/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chimeras1684.ui.operation;

import org.chimeras1684.ui.panels.Portal;
import org.opencv.core.Core;

/**
 *
 * @author Arhowk
 */
public class NewDriverUI {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        try {
            //NetworkTable.setIPAddress("10.20.13.2");
           // NetworkTable.setClientMode();
            //NetworkTable.initialize();
        } catch (Exception e) {
        }
        Portal p = Portal.getInstance();
        p.setVisible(true);
    }
}
