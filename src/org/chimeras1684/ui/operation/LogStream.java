/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chimeras1684.ui.operation;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 *
 * @author Arhowk
 */

public class LogStream extends ByteArrayOutputStream {

    private JTextArea area;
    public LogStream(JTextArea area) {
        super();
        this.area = area;
        area.setEditable(false);
        System.setOut(new PrintStream(this,true));
        System.setErr(new PrintStream(this, true));
    }

    /*
     * (non-Javadoc)
     * @see java.io.OutputStream#flush()
     */
    public void flush() throws IOException {     
        String record; 
        synchronized(this) { 
            super.flush(); 
            record = this.toString(); 
            super.reset(); 

            if (record.length() == 0) { 
                // avoid empty records 
                return; 
            }
            area.append(record);
            area.setCaretPosition(area.getText().length());
        } 
    } 
}