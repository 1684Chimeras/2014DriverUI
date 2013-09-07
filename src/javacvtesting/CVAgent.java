/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacvtesting;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.highgui.Highgui;
/**
 *
 * @author Arhowk
 */
public class CVAgent {
    
    public static int curTop = 0,
        curLeft = 0,
        curRight = 0,
        curBottom = 0,
        curXErr = 0,
        curYErr = 0; //current processed variables

    public static int maxThresh = 800; //Maximum number of pixels for a blob to be classified as a blob
     
    public static  Panel informationPanel = new Panel(); //Slider panel for debugging
    
    /*
     * Converts the open-CV variable Mat to Java variable BufferedImage
     * Don't worry about any of this code, if this code is causing
     * errors than it most likely has a different cause
     * (bad OpenCV/JavaCPP versions, not enough memory, etc)
     */
    public static BufferedImage convert(Mat m){ 
        Mat image_tmp = m;

        MatOfByte matOfByte = new MatOfByte();

        Highgui.imencode(".png", image_tmp, matOfByte); 

        byte[] byteArray = matOfByte.toArray();
        BufferedImage bufImage = null;

        try {

            InputStream in = new ByteArrayInputStream(byteArray);
            bufImage = ImageIO.read(in);
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            return bufImage;
        }
    }
    
    /*
     * Converts the Java variable BufferedImage to OpenCV variable Mat
     * Don't worry about any of this code, if this code is causing
     * errors than it most likely has a different cause
     * (bad OpenCV/JavaCPP versions, not enough memory, etc)
     */
    public static Mat convert(BufferedImage i){
        BufferedImage image = i; //Because I didn't want to change the variable name.
        byte[] data = ((DataBufferByte) image.getRaster().getDataBuffer()).getData(); //Converts BufferedImage to a byte array
        Mat mat = new Mat(image.getHeight(),image.getWidth(), CvType.CV_8UC3); //Creates a new mat with original image width, height, and image data type.
        mat.put(0, 0, data);//Draws the pixel array from the buffered image onto the Mat
        return mat;
    }
    /*
     * Main rendering function. 
     * 
     * Renders : Converts to HSV, threshholds based on the slider data, erodes away pixels on the edges of blobs,
     * dilates the image to reshape the eroded blobs to their original form. I made the custon fumction NewBlobDetection
     * thats a simple 4-pixel connectivity tracking method.
     * 
     */
    public static BufferedImage render(int type, boolean camera, boolean writeToPanel){
        if(!informationPanel.isVisible){
            informationPanel.show(); //TODO : Move this to its own, nicer function
        }
        
        Mat src;
        
        if(camera){
            BufferedImage srcc = null;
            
            try {
                srcc = ImageIO.read(new URL("http://10.20.13.11/axis-cgi/jpg/image.cgi?resolution=352x240"));
            } catch (Exception e) {
                return new BufferedImage(640,480,1);
            }
            
            src = convert(srcc);
            
        }else{
            
            src = Highgui.imread("D:\\0_image.png");
            
            Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2HSV);
            
        }
        
        
        Mat dest = new Mat();
        
        Core.inRange(src, new Scalar(informationPanel.hue,informationPanel.sat,informationPanel.val), new Scalar(informationPanel.huem,informationPanel.satm,informationPanel.valm), dest);
        
        if(informationPanel.erode > 0){
            
            Mat erode = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(informationPanel.erode,informationPanel.erode));
            
            Imgproc.erode(dest, dest, erode);
            Imgproc.erode(dest, dest, erode);
            
            erode.release();
            
        }
        if(informationPanel.dilate > 0){
            
            Mat dilateFunc = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(informationPanel.dilate,informationPanel.dilate));

            Imgproc.dilate(dest, dest, dilateFunc);
            
            dilateFunc.release();
            
        }
        
        BufferedImage returnGraphic = null;     
        
        if(type == 0){
           returnGraphic = convert(dest);
        }else if(type == 1){
            Imgproc.cvtColor(src, src, Imgproc.COLOR_HSV2BGR);
            returnGraphic = convert(src);
        }else{
            returnGraphic = convert(src);
        }
        
        curTop = 0;
        curLeft = 0;
        curRight = 0;
        curBottom = 0;
        curXErr = 0;
        curYErr = 0;
        
        BufferedImage renderGraphic = convert(dest);
        ArrayList<NewBlobDetection.Blob> bb = NewBlobDetection.generate(renderGraphic);
        
        for(NewBlobDetection.Blob b : bb){
            
            if (((b.top+b.bottom)/2) * ((b.left+b.right)/2) < maxThresh || (b.bottom - b.top)*1.1 > b.right - b.left) {
                continue;
            }
            
            Graphics2D  g = returnGraphic.createGraphics();
            g.setColor(Color.GREEN);
            g.setStroke(new BasicStroke(informationPanel.line));
            
            g.drawLine(b.left, b.top,b.right, b.top);
            g.drawLine(b.right,b.top,b.right,b.bottom);
            g.drawLine(b.right,b.bottom,b.left,b.bottom);
            g.drawLine(b.left, b.bottom, b.left, b.top);
            
            g.dispose();
        
            if(b.top > curTop){
                
                curTop = b.top;
                curLeft = b.left;
                curRight = b.right;
                curBottom = b.bottom;
                curXErr = ((b.left+b.right)/2)-returnGraphic.getWidth()/2;
                curYErr = ((b.top+b.bottom)/2)-returnGraphic.getHeight()/2;
                
            }
            
        }
        
        src.release();
        dest.release();
        
        if (writeToPanel) {
            
             informationPanel.setImage(returnGraphic);
             
        }
        
        return returnGraphic;
    }
    /*
     * Nicer function name for function render
     */
    public static BufferedImage getNextImage(int typee){
        return render(typee, false, false);
        
    }
}
