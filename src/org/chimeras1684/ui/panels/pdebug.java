/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.chimeras1684.ui.panels;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import static java.lang.Thread.sleep;
import javacvtesting.CVAgent;
import org.chimeras1684.ui.operation.LogStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import org.imgscalr.Scalr;

/**
 *
 * @author Arhowk
 */
public class pdebug extends JFrame{
    static pdebug instance;
    static int type = 0;
    static String btShooterSetpoint,btShooterRPM,btShooterMPH,btShooterPIDIn,btShooterPIDOut,btShooterMotor,
            btDeckSetpoint, btDeckEncoder, btDeckMotor, btDriveInputType, btDriveInputValue,btDriverX,btDriverY,
            btTopLeftDrive, btTopRightDrive, btBottomLeftDrive, btBottomRightDrive,btLeftEncoder, btRightEncoder,
            btDiscInputType, btDiscInputVal, btArmSolenoid, btArmPinSolenoid, btHopperSolenoid, btFireSolenoid,
            btOperatorX, btOperatorY, btAuton;
    static{
        instance = new pdebug();
    }
    static class PopUpDemo extends JPopupMenu implements ActionListener{
        JMenuItem threshhold;
        JMenuItem hsv;
        JMenuItem camera;
        public PopUpDemo(){
            threshhold = new JMenuItem("Threshhold");
            add(threshhold);
            threshhold.addActionListener(this);
            hsv = new JMenuItem("HSV");
            add(hsv);
            hsv.addActionListener(this);
            camera = new JMenuItem("Camera");
            add(camera);
            camera.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == threshhold){
                try {
                //    setCurrentRequest("thr");
                    type = 0;
                } catch (Exception ee) {
                }
                System.out.println("threshhold");
            }else if(e.getSource() == camera){
                try {
                //    setCurrentRequest("cam");
                    type = 1;
                } catch (Exception ee) {
                }
                System.out.println("camea");
            }else if(e.getSource() == hsv){
                
                try {
                //    setCurrentRequest("hsv");
                } catch (Exception ee) {
                }
            }else{
                System.out.println("fail");
            }
        }
    }
    class PopClickListener extends MouseAdapter {
        public void mousePressed(MouseEvent e){
            if (e.isPopupTrigger())
                doPop(e);
        }

        public void mouseReleased(MouseEvent e){
            if (e.isPopupTrigger())
                doPop(e);
        }

        private void doPop(MouseEvent e){
            PrimaryDriver.PopUpDemo menu = new PrimaryDriver.PopUpDemo();
            menu.show(e.getComponent(), e.getXOnScreen(), e.getYOnScreen());
        }
    }
    public static pdebug getInstance(){
        return instance;
    }
    private pdebug() {
//        main();
        initComponents();
        try {
   //         setCurrentRequest("cam");
        } catch (Exception e) {
        }
        image.add(new PrimaryDriver.PopUpDemo());
        image.addMouseListener(new PopClickListener());
        System.out.println("primdebug");
        (new Thread(){
            public void run(){
                while(true){
                    try {
                        sleep(100);
                        System.out.println("setting icon");
                        image.setIcon(new ImageIcon(Scalr.resize(CVAgent.getNextImage(type), Scalr.Method.SPEED, 300, 263, Scalr.OP_ANTIALIAS)));
                    } catch (Exception e) {
                    }
                    
                }
            }
        }).start();
        LogStream s = new LogStream(psPrintArea);
        stack(dcRawTitle,20);
        stack(dcInputName,18);
        stack(dtInTitle,17);
        stack(dtRawTitle,20);
        stack(shDeckTiltTitle,17);
        stack(shooterControlTitle,7);
        disc.setSize(238, 263);
        setSize(1200, 650);
        setResizable(false);
        jPanel3.setSize(0, 0);
        setBackground(Color.CYAN);
        set();
    }
    public void set(){
        btShooterSetpoint = shSetpoint.getText() + " ";
        btShooterRPM = shRPM.getText() + " ";
        btShooterMPH = shMPH.getText() + " ";
        btShooterPIDIn = shPIDIn.getText() + " ";
        btShooterPIDOut = shPidOut.getText() + " ";
        btShooterMotor = shMotor.getText() + " ";
        btDeckSetpoint = shdkCSet.getText() + " ";
        btDeckEncoder = shdkCEnco.getText() + " ";
        btDeckMotor = shdkCMotor.getText() + " ";
        btDriveInputType = dtInType.getText() + " ";
        btDriveInputValue = dtInVal.getText() + " ";
        btDriverX = dtJoyX.getText() + " ";
        btDriverY = dtJoyY.getText() + " ";
        btTopLeftDrive = dtTLDrv.getText() + " ";
        btTopRightDrive = dtTRDrv.getText() + " ";
        btBottomLeftDrive = dtBLDrv.getText() + " ";
        btBottomRightDrive = dtBRDrv.getText() + " ";
        btLeftEncoder = dtLftEncode.getText() + " ";
        btRightEncoder = dtRightEncode.getText() + " ";
        btDiscInputType = dcInDesc.getText() + " ";
        btDiscInputVal = dcInVal.getText() + " ";
        btArmSolenoid = dcArm.getText() + " ";
        btArmPinSolenoid = dcPin.getText() + " ";
        btHopperSolenoid = dcHopper.getText() + " ";
        btFireSolenoid = dcFire.getText() + " ";
        btOperatorX = mcOpJoyX.getText() + " ";
        btOperatorY = mcOpJoyY.getText() + " ";
        btAuton = mcAuton.getText() + " ";
    }
    public String[] getIdentifiers(){
        return new String[]{"shooterSetpoint","shooterRPM","shooterMPH","shooterPIDIn","shooterPIDOut","shooterMotor","deckSetpoint","deckEncoder","deckMotor"
                ,"driveInputType","driveInputValue","driverX","driverY","operatorX","operatorY","topLeftDrive","topRightDrive","bottomLeftDrive","bottomRightDrive"
                ,"leftEncoder","rightEncoder","discInputType","discInputValue","armSolenoid","armPinSolenoid","hopperSolenoid","fireSolenoid","autonMode"};
    }
    public JLabel[] getMatchedLabels(){
        return new JLabel[]{shSetpoint, shRPM, shMPH, shPIDIn, shPidOut, shMotor, shdkCSet, shdkCEnco, shdkCMotor
        ,dtInType, dtInVal, dtJoyX, dtJoyY,mcOpJoyX, mcOpJoyY, dtTLDrv, dtTRDrv, dtBLDrv, dtBRDrv
        ,dtLftEncode, dtRightEncode, dcInDesc, dcInVal, dcArm, dcPin, dcHopper, dcFire, mcAuton};
    }
    public String[] getMatchedBaseText(){
        return new String[]{btShooterSetpoint,btShooterRPM,btShooterMPH,btShooterPIDIn,btShooterPIDOut,btShooterMotor,
            btDeckSetpoint, btDeckEncoder, btDeckMotor, btDriveInputType, btDriveInputValue,btDriverX,btDriverY,
            btOperatorX, btOperatorY, btTopLeftDrive, btTopRightDrive, btBottomLeftDrive, btBottomRightDrive,btLeftEncoder, btRightEncoder,
            btDiscInputType, btDiscInputVal, btArmSolenoid, btArmPinSolenoid, btHopperSolenoid, btFireSolenoid,
             btAuton};
    }
    public void update(String identifier, String newEntry){
        String[] ids = getIdentifiers();
        for(int i = 0; i < ids.length; i++){
            if(ids[i].equals(identifier)){
                System.out.println("i " + i + "text = " + getMatchedBaseText()[i]);
                getMatchedLabels()[i].setText(getMatchedBaseText()[i] + newEntry);
            }
        }
    }
    public final void stack(JLabel j, int count){
        String s = "<html><p><b><u>"+j.getText();
        for(int i = 0; i < count; i++){
            s = s + "&nbsp";
        }
        s = s + "</p></b></u></html>";
        j.setText(s);
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

        jPanel3 = new javax.swing.JPanel();
        gap1 = new javax.swing.JPanel();
        camera = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        gap2 = new javax.swing.JPanel();
        debugInfo = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        psTitle = new javax.swing.JLabel();
        psIDK = new javax.swing.JScrollPane();
        psPrintArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        gap3 = new javax.swing.JPanel();
        camInfo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cmTitle = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        gap4 = new javax.swing.JPanel();
        gap5 = new javax.swing.JPanel();
        gap6 = new javax.swing.JPanel();
        gap7 = new javax.swing.JPanel();
        shooter = new javax.swing.JPanel();
        shTitlePanel = new javax.swing.JPanel();
        shTitle = new javax.swing.JLabel();
        shSetpoint = new javax.swing.JLabel();
        shPIDIn = new javax.swing.JLabel();
        shooterControlTitle = new javax.swing.JLabel();
        shRPM = new javax.swing.JLabel();
        shMPH = new javax.swing.JLabel();
        shPidOut = new javax.swing.JLabel();
        shDeckTiltTitle = new javax.swing.JLabel();
        shMotor = new javax.swing.JLabel();
        shdkCSet = new javax.swing.JLabel();
        shdkCEnco = new javax.swing.JLabel();
        shdkCMotor = new javax.swing.JLabel();
        disc = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        dcInputName = new javax.swing.JLabel();
        dcInDesc = new javax.swing.JLabel();
        dcInVal = new javax.swing.JLabel();
        dcRawTitle = new javax.swing.JLabel();
        dcArm = new javax.swing.JLabel();
        dcPin = new javax.swing.JLabel();
        dcHopper = new javax.swing.JLabel();
        dcFire = new javax.swing.JLabel();
        drivetrain = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dtRawTitle = new javax.swing.JLabel();
        dtInType = new javax.swing.JLabel();
        dtInVal = new javax.swing.JLabel();
        dtJoyX = new javax.swing.JLabel();
        dtJoyY = new javax.swing.JLabel();
        dtInTitle = new javax.swing.JLabel();
        dtTLDrv = new javax.swing.JLabel();
        dtTRDrv = new javax.swing.JLabel();
        dtBLDrv = new javax.swing.JLabel();
        dtBRDrv = new javax.swing.JLabel();
        dtLftEncode = new javax.swing.JLabel();
        dtRightEncode = new javax.swing.JLabel();
        misc = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        dcRawTitle1 = new javax.swing.JLabel();
        mcOpJoyX = new javax.swing.JLabel();
        mcOpJoyY = new javax.swing.JLabel();
        mcAuton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        gap1.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap1Layout = new javax.swing.GroupLayout(gap1);
        gap1.setLayout(gap1Layout);
        gap1Layout.setHorizontalGroup(
            gap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap1Layout.setVerticalGroup(
            gap1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel3.add(gap1, gridBagConstraints);

        camera.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout cameraLayout = new javax.swing.GroupLayout(camera);
        camera.setLayout(cameraLayout);
        cameraLayout.setHorizontalGroup(
            cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        cameraLayout.setVerticalGroup(
            cameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(image, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel3.add(camera, gridBagConstraints);

        gap2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap2Layout = new javax.swing.GroupLayout(gap2);
        gap2.setLayout(gap2Layout);
        gap2Layout.setHorizontalGroup(
            gap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap2Layout.setVerticalGroup(
            gap2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel3.add(gap2, gridBagConstraints);

        debugInfo.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));

        psTitle.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        psTitle.setForeground(new java.awt.Color(255, 153, 0));
        psTitle.setText("PRINT STREAM");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(psTitle)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(psTitle)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        psPrintArea.setColumns(20);
        psPrintArea.setRows(5);
        psPrintArea.setBorder(null);
        psIDK.setViewportView(psPrintArea);

        jButton1.setFont(new java.awt.Font("Eurostile", 1, 18)); // NOI18N
        jButton1.setText("STOP");

        jButton2.setFont(new java.awt.Font("Eurostile", 1, 18)); // NOI18N
        jButton2.setText("PORTAL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout debugInfoLayout = new javax.swing.GroupLayout(debugInfo);
        debugInfo.setLayout(debugInfoLayout);
        debugInfoLayout.setHorizontalGroup(
            debugInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(psIDK)
            .addGroup(debugInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        debugInfoLayout.setVerticalGroup(
            debugInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(debugInfoLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(psIDK, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(debugInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 3;
        jPanel3.add(debugInfo, gridBagConstraints);

        gap3.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap3Layout = new javax.swing.GroupLayout(gap3);
        gap3.setLayout(gap3Layout);
        gap3Layout.setHorizontalGroup(
            gap3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap3Layout.setVerticalGroup(
            gap3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel3.add(gap3, gridBagConstraints);

        camInfo.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        cmTitle.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        cmTitle.setForeground(new java.awt.Color(255, 153, 0));
        cmTitle.setText("CAMERA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmTitle)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        jLabel18.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        jLabel18.setText("STATUS");

        jLabel19.setText("jLabel19");

        javax.swing.GroupLayout camInfoLayout = new javax.swing.GroupLayout(camInfo);
        camInfo.setLayout(camInfoLayout);
        camInfoLayout.setHorizontalGroup(
            camInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(camInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(camInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        camInfoLayout.setVerticalGroup(
            camInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(camInfoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addGap(0, 171, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        jPanel3.add(camInfo, gridBagConstraints);

        gap4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap4Layout = new javax.swing.GroupLayout(gap4);
        gap4.setLayout(gap4Layout);
        gap4Layout.setHorizontalGroup(
            gap4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap4Layout.setVerticalGroup(
            gap4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        jPanel3.add(gap4, gridBagConstraints);

        gap5.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap5Layout = new javax.swing.GroupLayout(gap5);
        gap5.setLayout(gap5Layout);
        gap5Layout.setHorizontalGroup(
            gap5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap5Layout.setVerticalGroup(
            gap5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel3.add(gap5, gridBagConstraints);

        gap6.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap6Layout = new javax.swing.GroupLayout(gap6);
        gap6.setLayout(gap6Layout);
        gap6Layout.setHorizontalGroup(
            gap6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap6Layout.setVerticalGroup(
            gap6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel3.add(gap6, gridBagConstraints);

        gap7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout gap7Layout = new javax.swing.GroupLayout(gap7);
        gap7.setLayout(gap7Layout);
        gap7Layout.setHorizontalGroup(
            gap7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        gap7Layout.setVerticalGroup(
            gap7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel3.add(gap7, gridBagConstraints);

        shooter.setBackground(new java.awt.Color(255, 255, 255));

        shTitlePanel.setBackground(new java.awt.Color(102, 102, 102));

        shTitle.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        shTitle.setForeground(new java.awt.Color(255, 153, 0));
        shTitle.setText("SHOOTER");

        javax.swing.GroupLayout shTitlePanelLayout = new javax.swing.GroupLayout(shTitlePanel);
        shTitlePanel.setLayout(shTitlePanelLayout);
        shTitlePanelLayout.setHorizontalGroup(
            shTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shTitle)
                .addContainerGap(130, Short.MAX_VALUE))
        );
        shTitlePanelLayout.setVerticalGroup(
            shTitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shTitlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(shTitle)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        shSetpoint.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shSetpoint.setText("Shooter Current Setpoint: ");

        shPIDIn.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shPIDIn.setText("Shooter PID Input: ");

        shooterControlTitle.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        shooterControlTitle.setText("CONTROL LOOPS");

        shRPM.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shRPM.setText("Shooter Current RPM: ");

        shMPH.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shMPH.setText("Shooter Current MPH: ");

        shPidOut.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shPidOut.setText("Shooter PID Output: ");

        shDeckTiltTitle.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        shDeckTiltTitle.setText("DECK TILT");

        shMotor.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shMotor.setText("Shooter Motor Speed:");

        shdkCSet.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shdkCSet.setText("Deck Current Setpoint:");

        shdkCEnco.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shdkCEnco.setText("Deck Current Encoder:");

        shdkCMotor.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        shdkCMotor.setText("Deck Motor Speed:");

        javax.swing.GroupLayout shooterLayout = new javax.swing.GroupLayout(shooter);
        shooter.setLayout(shooterLayout);
        shooterLayout.setHorizontalGroup(
            shooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shooterLayout.createSequentialGroup()
                .addComponent(shTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(shooterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(shooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(shSetpoint)
                    .addComponent(shPIDIn)
                    .addComponent(shooterControlTitle)
                    .addComponent(shRPM)
                    .addComponent(shMPH)
                    .addComponent(shPidOut)
                    .addComponent(shDeckTiltTitle)
                    .addComponent(shMotor)
                    .addComponent(shdkCSet)
                    .addComponent(shdkCEnco)
                    .addComponent(shdkCMotor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        shooterLayout.setVerticalGroup(
            shooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shooterLayout.createSequentialGroup()
                .addComponent(shTitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shooterControlTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shSetpoint)
                .addGap(3, 3, 3)
                .addComponent(shRPM)
                .addGap(3, 3, 3)
                .addComponent(shMPH)
                .addGap(3, 3, 3)
                .addComponent(shPIDIn)
                .addGap(3, 3, 3)
                .addComponent(shPidOut)
                .addGap(3, 3, 3)
                .addComponent(shMotor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(shDeckTiltTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shdkCSet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shdkCEnco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(shdkCMotor)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        jPanel3.add(shooter, gridBagConstraints);

        disc.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        jLabel6.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 153, 0));
        jLabel6.setText("DISC HANDLER");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        dcInputName.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        dcInputName.setText("INPUT ");

        dcInDesc.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dcInDesc.setText("Input Description:");

        dcInVal.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dcInVal.setText("Input Value:");

        dcRawTitle.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        dcRawTitle.setText("RAW");

        dcArm.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dcArm.setText("Arm Solenoid:");

        dcPin.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dcPin.setText("Arm Pin Solenoid:");

        dcHopper.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dcHopper.setText("Hopper Solenoid:");

        dcFire.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dcFire.setText("Fire Solenoid:");

        javax.swing.GroupLayout discLayout = new javax.swing.GroupLayout(disc);
        disc.setLayout(discLayout);
        discLayout.setHorizontalGroup(
            discLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(discLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(discLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcInputName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(discLayout.createSequentialGroup()
                        .addGroup(discLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dcInDesc)
                            .addComponent(dcInVal)
                            .addComponent(dcArm)
                            .addComponent(dcPin)
                            .addComponent(dcHopper)
                            .addComponent(dcFire))
                        .addGap(0, 132, Short.MAX_VALUE))
                    .addComponent(dcRawTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        discLayout.setVerticalGroup(
            discLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(discLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcInputName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcInDesc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcInVal)
                .addGap(33, 33, 33)
                .addComponent(dcRawTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcArm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcPin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcHopper)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcFire)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 1;
        jPanel3.add(disc, gridBagConstraints);

        drivetrain.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        jLabel5.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 153, 0));
        jLabel5.setText("DRIVE TRAIN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        dtRawTitle.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        dtRawTitle.setText("RAW");

        dtInType.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtInType.setText("Input Type:");

        dtInVal.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtInVal.setText("Input Value:");

        dtJoyX.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtJoyX.setText("Driver Joystick X:");

        dtJoyY.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtJoyY.setText("Driver Joystick Y: ");

        dtInTitle.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        dtInTitle.setText("INPUT");

        dtTLDrv.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtTLDrv.setText("Top Left Drive: ");

        dtTRDrv.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtTRDrv.setText("Top Right Drive:");

        dtBLDrv.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtBLDrv.setText("Bottom Left Drive:");

        dtBRDrv.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtBRDrv.setText("Bottom Right Drive:");

        dtLftEncode.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtLftEncode.setText("Left Encoder:");

        dtRightEncode.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        dtRightEncode.setText("Right Encoder:");

        javax.swing.GroupLayout drivetrainLayout = new javax.swing.GroupLayout(drivetrain);
        drivetrain.setLayout(drivetrainLayout);
        drivetrainLayout.setHorizontalGroup(
            drivetrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(drivetrainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(drivetrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtInType)
                    .addComponent(dtInVal)
                    .addComponent(dtJoyX)
                    .addComponent(dtJoyY)
                    .addComponent(dtInTitle)
                    .addComponent(dtRawTitle)
                    .addComponent(dtTLDrv)
                    .addComponent(dtTRDrv)
                    .addComponent(dtBLDrv)
                    .addComponent(dtBRDrv)
                    .addComponent(dtLftEncode)
                    .addComponent(dtRightEncode))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        drivetrainLayout.setVerticalGroup(
            drivetrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(drivetrainLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(dtInTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtInType)
                .addGap(3, 3, 3)
                .addComponent(dtInVal)
                .addGap(2, 2, 2)
                .addComponent(dtJoyX)
                .addGap(2, 2, 2)
                .addComponent(dtJoyY)
                .addGap(7, 7, 7)
                .addComponent(dtRawTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtTLDrv)
                .addGap(3, 3, 3)
                .addComponent(dtTRDrv)
                .addGap(3, 3, 3)
                .addComponent(dtBLDrv)
                .addGap(3, 3, 3)
                .addComponent(dtBRDrv)
                .addGap(3, 3, 3)
                .addComponent(dtLftEncode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dtRightEncode)
                .addGap(2, 2, 2))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        jPanel3.add(drivetrain, gridBagConstraints);

        misc.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel7.setFont(new java.awt.Font("Eurostile", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 153, 0));
        jLabel7.setText("MISC");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        dcRawTitle1.setFont(new java.awt.Font("Eurostile", 0, 18)); // NOI18N
        dcRawTitle1.setText("OTHER INPUT DATA");

        mcOpJoyX.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        mcOpJoyX.setText("Operator Joystick X:");

        mcOpJoyY.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        mcOpJoyY.setText("Operator Joystick Y:");

        mcAuton.setFont(new java.awt.Font("Eurostile", 0, 12)); // NOI18N
        mcAuton.setText("Auton Mode:");

        javax.swing.GroupLayout miscLayout = new javax.swing.GroupLayout(misc);
        misc.setLayout(miscLayout);
        miscLayout.setHorizontalGroup(
            miscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(miscLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(miscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mcOpJoyX)
                    .addComponent(mcOpJoyY)
                    .addComponent(mcAuton)
                    .addComponent(dcRawTitle1))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        miscLayout.setVerticalGroup(
            miscLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(miscLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcRawTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mcOpJoyX)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mcOpJoyY)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mcAuton)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 3;
        jPanel3.add(misc, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 618, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        (Portal.getInstance()).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(pdebug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pdebug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pdebug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pdebug.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel camInfo;
    private javax.swing.JPanel camera;
    private javax.swing.JLabel cmTitle;
    private javax.swing.JLabel dcArm;
    private javax.swing.JLabel dcFire;
    private javax.swing.JLabel dcHopper;
    private javax.swing.JLabel dcInDesc;
    private javax.swing.JLabel dcInVal;
    private javax.swing.JLabel dcInputName;
    private javax.swing.JLabel dcPin;
    private javax.swing.JLabel dcRawTitle;
    private javax.swing.JLabel dcRawTitle1;
    private javax.swing.JPanel debugInfo;
    private javax.swing.JPanel disc;
    private javax.swing.JPanel drivetrain;
    private javax.swing.JLabel dtBLDrv;
    private javax.swing.JLabel dtBRDrv;
    private javax.swing.JLabel dtInTitle;
    private javax.swing.JLabel dtInType;
    private javax.swing.JLabel dtInVal;
    private javax.swing.JLabel dtJoyX;
    private javax.swing.JLabel dtJoyY;
    private javax.swing.JLabel dtLftEncode;
    private javax.swing.JLabel dtRawTitle;
    private javax.swing.JLabel dtRightEncode;
    private javax.swing.JLabel dtTLDrv;
    private javax.swing.JLabel dtTRDrv;
    private javax.swing.JPanel gap1;
    private javax.swing.JPanel gap2;
    private javax.swing.JPanel gap3;
    private javax.swing.JPanel gap4;
    private javax.swing.JPanel gap5;
    private javax.swing.JPanel gap6;
    private javax.swing.JPanel gap7;
    private javax.swing.JLabel image;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel mcAuton;
    private javax.swing.JLabel mcOpJoyX;
    private javax.swing.JLabel mcOpJoyY;
    private javax.swing.JPanel misc;
    private javax.swing.JScrollPane psIDK;
    private javax.swing.JTextArea psPrintArea;
    private javax.swing.JLabel psTitle;
    private javax.swing.JLabel shDeckTiltTitle;
    private javax.swing.JLabel shMPH;
    private javax.swing.JLabel shMotor;
    private javax.swing.JLabel shPIDIn;
    private javax.swing.JLabel shPidOut;
    private javax.swing.JLabel shRPM;
    private javax.swing.JLabel shSetpoint;
    private javax.swing.JLabel shTitle;
    private javax.swing.JPanel shTitlePanel;
    private javax.swing.JLabel shdkCEnco;
    private javax.swing.JLabel shdkCMotor;
    private javax.swing.JLabel shdkCSet;
    private javax.swing.JPanel shooter;
    private javax.swing.JLabel shooterControlTitle;
    // End of variables declaration//GEN-END:variables
}
