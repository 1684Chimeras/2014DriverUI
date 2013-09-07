/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chimeras1684.ui.operation;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.ITable;
import edu.wpi.first.wpilibj.tables.ITableListener;
import java.util.regex.Pattern;
import org.chimeras1684.ui.panels.pdebug;
/**
 *
 * @author Arhowk
 */
public class SerialByteStreamReciever {
    private static NetworkTable t;
    public static void init(){}
    static{
        NetworkTable.setClientMode();
        NetworkTable.setTeam(2012);
        try {
            NetworkTable.initialize();
        t = NetworkTable.getTable("zzz");
        } catch (Exception e) {
            e.printStackTrace();
        }
        t.addTableListener(new ITableListener(){
            @Override
            public void valueChanged(ITable source, String key, Object value, boolean isNew) {
                System.out.println("valueChanged");
                byte[] incoming = ((String)value).getBytes();
                byte[] transfer = new byte[incoming.length-1];
                String incomingString;
                if(incoming[0] == 0x2){
                    System.out.println("incoming string");
                    System.arraycopy(incoming, 1, transfer, 0, incoming.length);
                }else{
                    System.out.println("incoming else");
                }
                incomingString = new String(transfer);
                String incomingKey;
                String incomingValue;
                for(int i = 0; i < incomingString.length(); i++){
                    if(incomingString.substring(i, i+2).equals("#%")){
                        incomingKey = incomingString.substring(0,i);
                        incomingValue = incomingString.substring(i+2,incomingString.length());
                        pdebug.getInstance().update(incomingKey,incomingValue);
                        source.putString(key, "");
                    }
                }
            }
            
        });
    }
}
