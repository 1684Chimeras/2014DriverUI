/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chimeras1684.ui.panels;

import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JLabel;

/**
 *
 * @author Arhowk
 */
public class Portal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    String javascript;
    public static  Color backgroundColor;
    public static Portal instance;
    static{
        System.out.println("init");
        instance = new Portal();
    }
    public static void init(){}
    private Portal() {
        
        initComponents();
        main(null);
        
        backgroundColor = jPanel5.getBackground();
        System.out.println(backgroundColor);
        setBackground(backgroundColor);
        gap1.setBackground(backgroundColor);
        gap2.setBackground(backgroundColor);
        gap3.setBackground(backgroundColor);
        gap4.setBackground(backgroundColor);
        gap5.setBackground(backgroundColor);
        modeSelectorTitle.setSize(50, 50);
        modeSelectorTitle.updateUI();
        setVisible(true);
        jLabel9.setText("<html><p><u>" + jLabel9.getText() + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&"
                + "nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&n"
                + "bsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</u></p></html>");
        jLabel12.setText("<html><p><u>" + jLabel12.getText() + "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&"
                + "nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&n"
                + "bsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</u></p></html>");
//        setResizable(false);
    }
    public static Portal getInstance(){
        return instance;
    }
    public static String getStringFromInputStream(InputStream is) {
 
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
 
		String line;
		try {
 
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
 
		return sb.toString();
 
	}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel5 = new javax.swing.JPanel();
        modeSelectorTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        gap1 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        gap2 = new javax.swing.JPanel();
        modeSelecterHeader = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        modeSelecterBody = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        gap3 = new javax.swing.JPanel();
        gap5 = new javax.swing.JPanel();
        gap4 = new javax.swing.JPanel();
        midColumnTtitle = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        midColumnHeader = new javax.swing.JPanel();
        midColumnBody = new javax.swing.JPanel();
        settingsTitle = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        settingsHeader = new javax.swing.JPanel();
        settingsBody = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        modeSelectorTitle.setBackground(new java.awt.Color(51, 0, 255));
        modeSelectorTitle.setPreferredSize(new java.awt.Dimension(333, 50));

        jLabel1.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODE SELECTION");

        javax.swing.GroupLayout modeSelectorTitleLayout = new javax.swing.GroupLayout(modeSelectorTitle);
        modeSelectorTitle.setLayout(modeSelectorTitleLayout);
        modeSelectorTitleLayout.setHorizontalGroup(
            modeSelectorTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeSelectorTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        modeSelectorTitleLayout.setVerticalGroup(
            modeSelectorTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeSelectorTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel5.add(modeSelectorTitle, gridBagConstraints);

        jButton9.setText("jButton9");

        javax.swing.GroupLayout gap1Layout = new javax.swing.GroupLayout(gap1);
        gap1.setLayout(gap1Layout);
        gap1Layout.setHorizontalGroup(
            gap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gap1Layout.createSequentialGroup()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 50, Short.MAX_VALUE))
        );
        gap1Layout.setVerticalGroup(
            gap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gap1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel5.add(gap1, gridBagConstraints);

        javax.swing.GroupLayout gap2Layout = new javax.swing.GroupLayout(gap2);
        gap2.setLayout(gap2Layout);
        gap2Layout.setHorizontalGroup(
            gap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        gap2Layout.setVerticalGroup(
            gap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        jPanel5.add(gap2, gridBagConstraints);

        modeSelecterHeader.setBackground(new java.awt.Color(102, 102, 255));
        modeSelecterHeader.setPreferredSize(new java.awt.Dimension(333, 100));

        jLabel4.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jLabel4.setText("Select what mode you would like to enable to change the dash.");

        jLabel5.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jLabel5.setText("Debug mode and object debug mode should only be used for");

        jLabel6.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jLabel6.setText("                   programmers testing the functions of the robots.");

        jLabel7.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jLabel7.setText("Practice and competition should be used to test motor functions,");

        jLabel8.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jLabel8.setText("practice driving skills, or compete.");

        javax.swing.GroupLayout modeSelecterHeaderLayout = new javax.swing.GroupLayout(modeSelecterHeader);
        modeSelecterHeader.setLayout(modeSelecterHeaderLayout);
        modeSelecterHeaderLayout.setHorizontalGroup(
            modeSelecterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeSelecterHeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modeSelecterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)))
            .addGroup(modeSelecterHeaderLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel8))
        );
        modeSelecterHeaderLayout.setVerticalGroup(
            modeSelecterHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeSelecterHeaderLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel5.add(modeSelecterHeader, gridBagConstraints);

        modeSelecterBody.setPreferredSize(new java.awt.Dimension(334, 350));

        jLabel9.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        jLabel9.setText("Drive Modes                                            ");

        jLabel10.setFont(new java.awt.Font("Eurostile", 0, 14)); // NOI18N
        jLabel10.setText("Practice Driver Mode . . . . . . . . . . .  . . .");

        jLabel11.setFont(new java.awt.Font("Eurostile", 0, 14)); // NOI18N
        jLabel11.setText("Competition Driver Mode . . . . . . . . . . . .");

        jLabel12.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        jLabel12.setText("Debug Modes");

        jLabel13.setFont(new java.awt.Font("Eurostile", 0, 14)); // NOI18N
        jLabel13.setText("Functionality Debug Mode . . . . . . . . . . . . ");

        jLabel14.setFont(new java.awt.Font("Eurostile", 0, 14)); // NOI18N
        jLabel14.setText("Object Debug Mode . . . . . . . . . . . . . . . . .");

        jButton5.setBackground(new java.awt.Color(153, 153, 153));
        jButton5.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jButton5.setText("SELECT");

        jButton6.setBackground(new java.awt.Color(153, 153, 153));
        jButton6.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jButton6.setText("SELECT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(153, 153, 153));
        jButton7.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jButton7.setText("SELECT");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(153, 153, 153));
        jButton8.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        jButton8.setText("SELECT");

        javax.swing.GroupLayout modeSelecterBodyLayout = new javax.swing.GroupLayout(modeSelecterBody);
        modeSelecterBody.setLayout(modeSelecterBodyLayout);
        modeSelecterBodyLayout.setHorizontalGroup(
            modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8))
                    .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5))
                    .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        modeSelecterBodyLayout.setVerticalGroup(
            modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(modeSelecterBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(37, 37, 37)
                .addGroup(modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jButton5))
                .addGap(18, 18, 18)
                .addGroup(modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jButton6))
                .addGap(64, 64, 64)
                .addComponent(jLabel12)
                .addGap(34, 34, 34)
                .addGroup(modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addGroup(modeSelecterBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jButton8))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel5.add(modeSelecterBody, gridBagConstraints);

        javax.swing.GroupLayout gap3Layout = new javax.swing.GroupLayout(gap3);
        gap3.setLayout(gap3Layout);
        gap3Layout.setHorizontalGroup(
            gap3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        gap3Layout.setVerticalGroup(
            gap3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel5.add(gap3, gridBagConstraints);

        javax.swing.GroupLayout gap5Layout = new javax.swing.GroupLayout(gap5);
        gap5.setLayout(gap5Layout);
        gap5Layout.setHorizontalGroup(
            gap5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        gap5Layout.setVerticalGroup(
            gap5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel5.add(gap5, gridBagConstraints);

        javax.swing.GroupLayout gap4Layout = new javax.swing.GroupLayout(gap4);
        gap4.setLayout(gap4Layout);
        gap4Layout.setHorizontalGroup(
            gap4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        gap4Layout.setVerticalGroup(
            gap4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel5.add(gap4, gridBagConstraints);

        midColumnTtitle.setBackground(new java.awt.Color(51, 0, 255));
        midColumnTtitle.setPreferredSize(new java.awt.Dimension(334, 50));

        jLabel2.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("MIDDLE COLUMN");

        javax.swing.GroupLayout midColumnTtitleLayout = new javax.swing.GroupLayout(midColumnTtitle);
        midColumnTtitle.setLayout(midColumnTtitleLayout);
        midColumnTtitleLayout.setHorizontalGroup(
            midColumnTtitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midColumnTtitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(145, 145, 145))
        );
        midColumnTtitleLayout.setVerticalGroup(
            midColumnTtitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(midColumnTtitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel5.add(midColumnTtitle, gridBagConstraints);

        midColumnHeader.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout midColumnHeaderLayout = new javax.swing.GroupLayout(midColumnHeader);
        midColumnHeader.setLayout(midColumnHeaderLayout);
        midColumnHeaderLayout.setHorizontalGroup(
            midColumnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );
        midColumnHeaderLayout.setVerticalGroup(
            midColumnHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPanel5.add(midColumnHeader, gridBagConstraints);

        javax.swing.GroupLayout midColumnBodyLayout = new javax.swing.GroupLayout(midColumnBody);
        midColumnBody.setLayout(midColumnBodyLayout);
        midColumnBodyLayout.setHorizontalGroup(
            midColumnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 334, Short.MAX_VALUE)
        );
        midColumnBodyLayout.setVerticalGroup(
            midColumnBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        jPanel5.add(midColumnBody, gridBagConstraints);

        settingsTitle.setBackground(new java.awt.Color(51, 0, 255));
        settingsTitle.setPreferredSize(new java.awt.Dimension(333, 50));

        jLabel3.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ADDITIONAL SETTINGS");

        javax.swing.GroupLayout settingsTitleLayout = new javax.swing.GroupLayout(settingsTitle);
        settingsTitle.setLayout(settingsTitleLayout);
        settingsTitleLayout.setHorizontalGroup(
            settingsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        settingsTitleLayout.setVerticalGroup(
            settingsTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsTitleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        jPanel5.add(settingsTitle, gridBagConstraints);

        settingsHeader.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout settingsHeaderLayout = new javax.swing.GroupLayout(settingsHeader);
        settingsHeader.setLayout(settingsHeaderLayout);
        settingsHeaderLayout.setHorizontalGroup(
            settingsHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        settingsHeaderLayout.setVerticalGroup(
            settingsHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        jPanel5.add(settingsHeader, gridBagConstraints);

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setFont(new java.awt.Font("Eurostile", 0, 36)); // NOI18N
        jButton1.setText("SHOOTER");

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Eurostile", 0, 36)); // NOI18N
        jButton2.setText("DRIVE TRAIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
        jButton3.setFont(new java.awt.Font("Eurostile", 0, 36)); // NOI18N
        jButton3.setText("MISC");

        jButton4.setBackground(new java.awt.Color(102, 102, 102));
        jButton4.setFont(new java.awt.Font("Eurostile", 0, 36)); // NOI18N
        jButton4.setText("CONTROLS");

        javax.swing.GroupLayout settingsBodyLayout = new javax.swing.GroupLayout(settingsBody);
        settingsBody.setLayout(settingsBodyLayout);
        settingsBodyLayout.setHorizontalGroup(
            settingsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        settingsBodyLayout.setVerticalGroup(
            settingsBodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(settingsBodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        jPanel5.add(settingsBody, gridBagConstraints);

        getContentPane().add(jPanel5);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //Show ui
        (pdebug.getInstance()).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        (new PrimaryDriver()).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Portal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new NewJFrame().setVisible(true);
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel gap1;
    private javax.swing.JPanel gap2;
    private javax.swing.JPanel gap3;
    private javax.swing.JPanel gap4;
    private javax.swing.JPanel gap5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel midColumnBody;
    private javax.swing.JPanel midColumnHeader;
    private javax.swing.JPanel midColumnTtitle;
    private javax.swing.JPanel modeSelecterBody;
    private javax.swing.JPanel modeSelecterHeader;
    private javax.swing.JPanel modeSelectorTitle;
    private javax.swing.JPanel settingsBody;
    private javax.swing.JPanel settingsHeader;
    private javax.swing.JPanel settingsTitle;
    // End of variables declaration//GEN-END:variables
}