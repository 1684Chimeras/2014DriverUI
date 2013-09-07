/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chimeras1684.ui.panels;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Arhowk
 */
public final class Transistor extends javax.swing.JFrame {

    /**
     * Creates new form test
     */
    public enum TDirection{
        MOVING_TO_LEFT,
        MOVING_TO_RIGHT,
        MOVING_TO_TOP,
        MOVING_TO_BOTTOM;
    }
    private static Transistor instance;
    static{
        instance = new Transistor();
    }
    public static Transistor getInstance(){
        return instance;
    }
    private Transistor() {
        initComponents();
        setVisible(true);
//        JPanel j2 = new JPanel();
//        j2.setSize(200,200);
        slide(TDirection.MOVING_TO_TOP, this, jPanel2, jPanel1);
    }
    
    public void slide(final TDirection dir, final JFrame root, final JPanel in, final JPanel out){
        if(in.getSize().height != out.getSize().height ||  out.getSize().width != in.getSize().width ){
            throw new IllegalArgumentException("Dimension in is not equal to dimension of out");
        }
        panelTL.removeAll();
        panelBL.removeAll();
        panelBR.removeAll();
        panelTR.validate();
        panelTR.repaint();
        panelTL.validate();
        panelTL.repaint();
        panelBR.validate();
        panelBR.repaint();
        panelBL.validate();
        panelBL.repaint();
        final double width = in.getSize().width;
        final double height = in.getSize().height;
        int x = out.getLocation().x;
        int y = out.getLocation().y;
        
        final double speedWidthModifier = (dir == TDirection.MOVING_TO_LEFT) ? -1 : (dir == TDirection.MOVING_TO_RIGHT) ? 1 : 0;
        final double speedHeightModifier = (dir == TDirection.MOVING_TO_BOTTOM) ? -1 : (dir == TDirection.MOVING_TO_TOP) ? 1 : 0;
        
        final double xAtEnd = (dir == TDirection.MOVING_TO_RIGHT) ? width : 0;
        final double yAtEnd = (dir == TDirection.MOVING_TO_BOTTOM) ? height : 0;
        
        if(dir == TDirection.MOVING_TO_LEFT){
            innerPanel.setSize((int)width*2,(int)height);
            panelTR.setSize((int)width,(int)height);
            panelTL.setSize((int)width,(int)height);
            panelTR.setLocation((int)width,0);
            panelTL.setLocation(0,0);
            panelTL.add(in);
            panelTR.add(out);
        }
        if(dir == TDirection.MOVING_TO_RIGHT){
            innerPanel.setSize((int)width*2,(int)height);
            panelTR.setSize((int)width,(int)height);
            panelTL.setSize((int)width,(int)height);
            panelTR.setLocation((int)width,0);
            panelTL.setLocation(0,0);
            panelTL.add(out);
            panelTR.add(in);
        }
        if(dir == TDirection.MOVING_TO_BOTTOM){
            innerPanel.setSize((int)width,(int)height*2);
            panelBL.setSize((int)width,(int)height);
            panelTL.setSize((int)width,(int)height);
            panelBL.setLocation(0,(int)height);
            panelTL.setLocation(0,0);
            panelBL.add(in);
            panelTL.add(out);
        }
        if(dir == TDirection.MOVING_TO_TOP){
            innerPanel.setSize((int)width,(int)height*2);
            panelBL.setSize((int)width,(int)height);
            panelTL.setSize((int)width,(int)height);
            panelBL.setLocation(0,(int)height);
            panelTL.setLocation(0,0);
            panelBL.add(out);
            panelTL.add(in);
        }
        root.remove(out);
        scrollPanel.setSize(in.getSize());
        innerPanel.setSize(in.getSize().width * 2, in.getSize().height);
        root.add(scrollPanel);
        scrollPanel.setLocation(x, y);
        if(speedWidthModifier == 0 && speedHeightModifier == 0){
            throw new NullPointerException("TDirection dir");
        }
        final Timer t = new Timer(100, null);
        t.addActionListener(new ActionListener(){
            Timer t2 = t;
            @Override
            public void actionPerformed(ActionEvent a) {
                Point viewport = scrollPanel.getViewport().getViewPosition();
                
                double currentX = viewport.x;
                double currentY = viewport.y;   

                double speed = 50;
                
                double newX = currentX + (speed * speedWidthModifier);
                double newY = currentY + (speed * speedHeightModifier);
                
                System.out.println("point : " + viewport);
                viewport.x = (int)newX;
                viewport.y = (int)newY;
                System.out.println("point2 : " + viewport);
                scrollPanel.repaint();
                root.repaint();
                scrollPanel.validate();
                System.out.println("point1 : " + viewport);
                if((xAtEnd != 0 && newX > xAtEnd) || (yAtEnd != 0 && newY > yAtEnd)){
//                    this.cancel();
                    t.stop();
                }
                
            }
            
        });
        t.setDelay(0);
        t.setRepeats(true);
        t.start();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanel = new javax.swing.JScrollPane();
        innerPanel = new javax.swing.JPanel();
        panelTL = new javax.swing.JPanel();
        panelTR = new javax.swing.JPanel();
        panelBL = new javax.swing.JPanel();
        panelBR = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        scrollPanel.setBorder(null);
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        innerPanel.setBackground(new java.awt.Color(255, 0, 153));
        innerPanel.setLayout(null);

        panelTL.setAutoscrolls(true);
        panelTL.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelTLLayout = new javax.swing.GroupLayout(panelTL);
        panelTL.setLayout(panelTLLayout);
        panelTLLayout.setHorizontalGroup(
            panelTLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTLLayout.setVerticalGroup(
            panelTLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        innerPanel.add(panelTL);
        panelTL.setBounds(0, 0, 0, 0);

        panelTR.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelTRLayout = new javax.swing.GroupLayout(panelTR);
        panelTR.setLayout(panelTRLayout);
        panelTRLayout.setHorizontalGroup(
            panelTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTRLayout.setVerticalGroup(
            panelTRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        innerPanel.add(panelTR);
        panelTR.setBounds(0, 0, 0, 0);

        panelBL.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelBLLayout = new javax.swing.GroupLayout(panelBL);
        panelBL.setLayout(panelBLLayout);
        panelBLLayout.setHorizontalGroup(
            panelBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBLLayout.setVerticalGroup(
            panelBLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        innerPanel.add(panelBL);
        panelBL.setBounds(0, 0, 0, 0);

        panelBR.setBackground(new java.awt.Color(204, 0, 51));
        panelBR.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelBRLayout = new javax.swing.GroupLayout(panelBR);
        panelBR.setLayout(panelBRLayout);
        panelBRLayout.setHorizontalGroup(
            panelBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelBRLayout.setVerticalGroup(
            panelBRLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        innerPanel.add(panelBR);
        panelBR.setBounds(0, 0, 0, 0);

        scrollPanel.setViewportView(innerPanel);

        jPanel1.setBackground(new java.awt.Color(204, 153, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transistor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transistor().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel innerPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBL;
    private javax.swing.JPanel panelBR;
    private javax.swing.JPanel panelTL;
    private javax.swing.JPanel panelTR;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
