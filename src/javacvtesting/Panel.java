/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacvtesting;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Arhowk
 */
public class Panel
{
    public boolean isVisible = false;
    public static final int 
            minH = 0,
            minS = 0,
            minV = 0,
            minHM = 0,
            minSM = 0,
            minVM = 0,
            strtH = 0,
            strtS = 0,
            strtV = 0,
            strtHM = 255,
            strtSM = 255,
            strtVM = 255,
            maxH = 255,
            maxS = 255,
            maxV = 255,
            maxHM = 255,
            maxSM = 255,
            maxVM = 255,
            
            minEr = 0,
            minDi = 0,
            minLi = 0,
            strtEr = 3,
            strtDi = 5,
            strtLi = 5,
            maxEr = 26,
            maxDi = 26,
            maxLi = 26;
    
    public final String durak = "Durakon";
    public final String kickoff = "Kickoff";
    public final String test = "Test";
    public int[] durakNumbers = new int[]{
        62, 24, 137,
        97,108,256,
        3,17
    };public int[] kickoffNumbers = new int[]{
        62, 24, 137,
        97,108,256,
        3,17
    };public int[] testNumbers  = new int[]{
        74, 106, 0 ,
        99,256,256,
        3,5
    };
    public static class InnerPanel{
        JPanel window;
        InnerPanel(JSlider a, JSlider b, JSlider c){
            window = new JPanel();
            window.setLayout(new ModifiedFlowLayout());
            window.add(a);
            window.add(b);
            window.add(c);
        }
    }
    public JFrame frame;
    JPanel checkbahx;
    JLabel image;

    JSlider h;
    JSlider s;
    JSlider v;

    int hue;
    int sat;
    int val;

    JLabel hText;
    JLabel sText;
    JLabel vText;

    JSlider hm;
    JSlider sm;
    JSlider vm;

    int huem;
    int satm;
    int valm;

    JLabel hTextm;
    JLabel sTextm;
    JLabel vTextm;

    JLabel erodeText;
    JLabel dilateText;
    JLabel lineText;

    JSlider e;
    JSlider d;
    JSlider l;

    int erode;
    int dilate;
    int line;

    JLabel eText;
    JLabel dText;
    JLabel lText;

    Panel(){
        frame = new JFrame();
        image = new JLabel();
        
        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        
        table.put(minH, new JLabel(""+minH));
        hText = new JLabel("Hue : 00000");
        table.put((minH + maxH) / 2, hText);
        table.put(maxH, new JLabel(""+maxH));
        
        Hashtable<Integer, JLabel> table2 = new Hashtable<>();
        
        table2.put(minS, new JLabel(""+minS));
        sText = new JLabel("Saturation : 00000");
        table2.put((minS+maxS)/2, sText);
        table2.put(maxS, new JLabel(""+maxS));
        Hashtable<Integer, JLabel> table3 = new Hashtable<Integer, JLabel>();
        
        table3.put(minV, new JLabel(""+minV));
        vText = new JLabel("Value : 00000");
        table3.put((minV+maxV)/2, vText);
        table3.put(maxV, new JLabel(""+maxV));
        
        
        Hashtable<Integer, JLabel> table4 = new Hashtable<Integer, JLabel>();
        
        table4.put(minHM, new JLabel(""+minHM));
        hTextm = new JLabel("Max Hue : 00000");
        table4.put((minHM + maxHM)/2, hTextm);
        table4.put(maxHM, new JLabel(""+maxHM));
        
        Hashtable<Integer, JLabel> table5 = new Hashtable<Integer, JLabel>();
        
        table5.put(minSM, new JLabel(""+minSM));
        sTextm = new JLabel("Max Sat : 00000");
        table5.put((minSM + maxSM)/2, sTextm);
        table5.put(maxSM, new JLabel(""+maxSM));
        
        Hashtable<Integer, JLabel> table6 = new Hashtable<Integer, JLabel>();
        
        table6.put(minVM, new JLabel(""+minVM));
        vTextm = new JLabel("Max Val : 00000");
        table6.put((minVM + maxVM)/2, vTextm);
        table6.put(maxVM, new JLabel(""+maxVM));
        
        Hashtable<Integer, JLabel> table7 = new Hashtable<Integer, JLabel>();
        
        table7.put(minEr, new JLabel(""+minEr));
        eText = new JLabel("Erode : 00000");
        table7.put((minEr + maxEr)/2, eText);
        table7.put(maxEr, new JLabel(""+maxEr));
        
        Hashtable<Integer, JLabel> table8 = new Hashtable<Integer, JLabel>();
        
        table8.put(minDi, new JLabel(""+minDi));
        dText = new JLabel("Dilate : 00000");
        table8.put((minDi + maxDi)/2, dText);
        table8.put(maxDi, new JLabel(""+maxDi));
        Hashtable<Integer, JLabel> table9 = new Hashtable<Integer, JLabel>();
        
        table9.put(minLi, new JLabel(""+minLi));
        lText = new JLabel("Line Width : 00000");
        table9.put(13, lText);
        table9.put(maxLi, new JLabel(""+maxLi));
        
        h = new JSlider(0,minH,maxH,strtH);
        s = new JSlider(0,minS,maxS,strtS);
        v = new JSlider(0,minV,maxV,strtV);
        h.setPaintLabels(true);
        h.setLabelTable(table);
        s.setPaintLabels(true);
        s.setLabelTable(table2);
        v.setPaintLabels(true);
        v.setLabelTable(table3);
        hm = new JSlider(0,minHM,maxHM,strtHM);
        sm = new JSlider(0,minSM,maxSM,strtSM);
        vm = new JSlider(0,minVM,maxVM,strtVM);
        hm.setPaintLabels(true);
        hm.setLabelTable(table4);
        sm.setPaintLabels(true);
        sm.setLabelTable(table5);
        vm.setPaintLabels(true);
        vm.setLabelTable(table6);
        e = new JSlider(0,minEr,maxEr,strtEr);
        d = new JSlider(0,minDi,maxDi,strtDi);
        l = new JSlider(0,minLi,maxLi,strtLi);
        e.setPaintLabels(true);
        e.setLabelTable(table7);
        d.setPaintLabels(true);
        d.setLabelTable(table8);
        l.setPaintLabels(true);
        l.setLabelTable(table9);
        
        h.addChangeListener(new ChangeListener(){ //wtf probably shouldve put these in a function
            @Override
            public void stateChanged(ChangeEvent e) {
                hText.setText("Hue : " + ((JSlider)e.getSource()).getValue());
                hue = ((JSlider)e.getSource()).getValue();
                CVAgent.getNextImage(1);
                frame.repaint();
            }
        });
        
        s.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                sText.setText("Saturation : " + ((JSlider)e.getSource()).getValue());
                sat = ((JSlider)e.getSource()).getValue();
               // JavaCVTesting.render();
                frame.repaint();
            }
        });
        
        v.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                vText.setText("Value : " + ((JSlider)e.getSource()).getValue());
                val = ((JSlider)e.getSource()).getValue();
              //  JavaCVTesting.render();
                frame.repaint();
            }
        });
        hm.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                hTextm.setText("Max Hue : " + ((JSlider)e.getSource()).getValue());
                huem= ((JSlider)e.getSource()).getValue();
               // JavaCVTesting.render();
                frame.repaint();
            }
        });
        
        sm.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                sTextm.setText("Max Sat : " + ((JSlider)e.getSource()).getValue());
                satm = ((JSlider)e.getSource()).getValue();
                //JavaCVTesting.render();
                frame.repaint();
            }
        });
        
        vm.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                vTextm.setText("Max Val : " + ((JSlider)e.getSource()).getValue());
                valm = ((JSlider)e.getSource()).getValue();
               // JavaCVTesting.render();
                frame.repaint();
            }
        });
        e.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                eText.setText("Erode : " + ((JSlider)e.getSource()).getValue());
                erode= ((JSlider)e.getSource()).getValue();
               // JavaCVTesting.render();
                frame.repaint();
            }
        });
        
        d.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                dText.setText("Dilate : " + ((JSlider)e.getSource()).getValue());
                dilate = ((JSlider)e.getSource()).getValue();
              //  JavaCVTesting.render();
                frame.repaint();
            }
        });
        
        l.addChangeListener(new ChangeListener(){
            @Override
            public void stateChanged(ChangeEvent e) {
                lText.setText("Line Width : " + ((JSlider)e.getSource()).getValue());
                line = ((JSlider)e.getSource()).getValue();
              //  JavaCVTesting.render();
                frame.repaint();
            }
        });
        InnerPanel p = new InnerPanel(h,s,v);
        InnerPanel p2 = new InnerPanel(hm,sm,vm);
        InnerPanel p3 = new InnerPanel(e,d,l);
        
        checkbahx = new JPanel();
        
        final String[] typeStrings = { durak, test, kickoff };

        //Create the combo box, select item at index 4.
        //Indices start at 0, so 4 specifies the pig.
        JComboBox petList = new JComboBox(typeStrings);
        petList.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ee) {
                JComboBox cb = (JComboBox)ee.getSource();
                String selectedd = (String)cb.getSelectedItem();
                hue = strtH;
                sat = strtS;
                val = strtV;
                huem = strtHM;
                satm = strtSM;
                valm = strtVM;
                erode = strtEr;
                dilate = strtDi;
                line = strtLi;
                switch(selectedd){
                    case durak:
                        set(durakNumbers);
                        updateToolbars();
                        break;
                    case test:
                        set(testNumbers);
                        updateToolbars();
                        break;
                    case kickoff:
                        set(kickoffNumbers);
                        updateToolbars();
                        break;
                }
                CVAgent.getNextImage(0);
            }
            
        });
        checkbahx.add(petList);
        
        
        frame.getContentPane().setLayout(new ModifiedFlowLayout());
        frame.getContentPane().add(p.window);
        frame.getContentPane().add(p2.window);
        frame.getContentPane().add(p3.window);
        frame.getContentPane().add(checkbahx);
        frame.getContentPane().add(image);
        frame.pack();
        frame.setSize(700,306);
      //  frame.setResizable(false);
        
        hText.setText("Hue : "+strtH);
        sText.setText("Saturation : "+strtS);
        vText.setText("Value : "+strtV);
        hTextm.setText("Max Hue : "+strtHM);
        sTextm.setText("Max Sat : "+strtSM);
        vTextm.setText("Max Val : "+strtVM);
        eText.setText("Erode : "+strtEr);
        dText.setText("Dilate : "+strtDi);
        lText.setText("Line Width : "+strtLi);
        
        hue = strtH;
        sat = strtS;
        val = strtV;
        huem = strtHM;
        satm = strtSM;
        valm = strtVM;
        erode = strtEr;
        dilate = strtDi;
        line = strtLi;
        }
        
        public void setImage(BufferedImage i){
            image.setIcon(new ImageIcon(i));
        }
        
        public void show(){
       // frame.pack();
            frame.setVisible(true);
            isVisible = true;
        }
        private void set(int[] num){
            hue = num[0];
            sat = num[1];
            val = num[2];
            huem = num[3];
            satm = num[4];
            valm = num[5];
            erode = num[6];
            dilate = num[7];
        }
        public void updateToolbars(){
            h.setValue(hue);
            s.setValue(sat);
            v.setValue(val);
            hm.setValue(huem);
            sm.setValue(satm);
            vm.setValue(valm);
            e.setValue(erode);
            d.setValue(dilate);
            l.setValue(line);
            hText.setText("Hue : "+hue);
            sText.setText("Saturation : "+sat);
            vText.setText("Value : "+val);
            hTextm.setText("Max Hue : "+huem);
            sTextm.setText("Max Sat : "+satm);
            vTextm.setText("Max Val : "+valm);
            eText.setText("Erode : "+erode);
            dText.setText("Dilate : "+dilate);
            lText.setText("Line Width : "+line);
            frame.repaint();
        }
    }
