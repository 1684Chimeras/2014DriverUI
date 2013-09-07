/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javacvtesting;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Hashtable;
import org.opencv.core.Mat;


//import static javacvtesting.JavaCVTesting.dilate;
/**
 *
 * @author Arhowk
 */
public class NewBlobDetection {
    public static class Blob{
        
        public int left = 5000,top = 5000; //Makes sure that the first pixel that the renderer collects 
        public int bottom = -5000,right = -5000;  //all edges are collected.
        
        private Blob(){} //shouldn't initialize them outside of this class you silly.
        
        void add(int x, int y){ 
            
            if(x < left)
                left = x;
            
            if(x > right)
                right = x;
            
            if(y < top)
                top = y;
            
            if(y > bottom)
                bottom = y;
            
        }
    }
    
    static boolean[][] attaches;
    
    static int currImageWidth = 0;
    static int currImageHeight = 0;
    
    static long start;
    
    /*
     * Simply attaches a boolean to a x/y combination pair for making sure
     * that a pixel hasn't been processed before collecting it. 
     */
    
    private static boolean getAttached(int x, int y){
        return x < currImageWidth && y < currImageHeight && !attaches[x][y];
        
    }
    
    private static void setAttached(int x, int y){
        attaches[x][y] = true;
    }
    
    /*
     * TODO: remove
     */
    
    static class at{
        int x;
        int y;
        at(int xx, int yy){
            x=xx;
            y=yy;
        }
    }
    
    /*
     * Every time that the main renderer detects a pixel that hasn't been picked up by setAttached,
     * it will be sent to this function which will not only attach the pixel
     * to a blob but also use four-pin connectivity to find nearby
     * pixels and add them to the same blob.
     */
    
    private static Blob cycle(BufferedImage i, int x, int y){
        ArrayList<at> nextIteration = new ArrayList();
        ArrayList<at> tempList = new ArrayList(); //Why two array lists? You can't modify a list inside of a while loop, so you have to make the 
                                                  //modifications in a temporary list than update the real one with the changed vaulues.
        Blob current = new Blob(); //Bl000000000000b
        
        setAttached(x,y); //Attaches the origin pixel
        
        nextIteration.add(new at(x,y)); //Adds the current pixel to the four-pin cycler agent. //TODO: remove class "at"
        
        for(;;){ //essentially a while(true) loop
            
            tempList = (ArrayList)nextIteration.clone(); //Obtains a clone of the pixel list before it is sent to be looped through
            
            for(at a : nextIteration){ //Loops through all of the pixels currently in the cycle
                tempList.remove(a); //Don't want to loop through the same pixel twice
                
                if(get(i,a.x+1, a.y) == 255 && getAttached(a.x+1,a.y)){ //Topleft is 0,0 so x+1 would be to the right
                    
                    setAttached(a.x+1,a.y);
                    tempList.add(new at(a.x+1,a.y));
                    current.add(a.x+1, a.y)
                            ;
                }if(get(i,a.x, a.y+1) == 255 && getAttached(a.x,a.y+1)){ //see above. get() returns 255 if white, 0 if black. 
                    
                    setAttached(a.x,a.y+1);
                    tempList.add(new at(a.x,a.y+1));
                    current.add(a.x, a.y+1);
                    
                }if(x != 0 && get(i,a.x-1, a.y) == 255 && getAttached(a.x-1,a.y)){
                    
                    setAttached(a.x-1,a.y);
                    tempList.add(new at(a.x-1,a.y));
                    current.add(a.x-1, a.y);
                    
                }if(y != 0 && get(i,a.x, a.y-1) == 255 && getAttached(a.x,a.y-1)){
                    
                    setAttached(a.x,a.y-1);
                    tempList.add(new at(a.x,a.y-1));
                    current.add(a.x, a.y-1);
                    
                }
                
            }
            
            if(tempList.isEmpty()){
                
                return current;
                
            }else{
                
                nextIteration = (ArrayList)tempList.clone();
                
            }
            
        }
    }
    /*
     * Preferred that the iterations only take .3 seconds. Never really works because its only checked once lol
     */
    public static boolean shouldCancel(){
        return System.currentTimeMillis() - start > 300; //TODO : Customize 300
    }
    public static ArrayList<Blob> generate(BufferedImage i){
        ArrayList<Blob> results = new ArrayList();
        
        if(get(i,0,0) == 255 && get(i,i.getWidth(), 0) == 255
                && get(i,i.getWidth(), i.getHeight()) == 255
                && get(i,0,i.getHeight()) == 255){
            return results; //BufferedImage is wierd in that if the entire image is black, all pixels will return 255 instead of 0 so im making sure the image
                            //has atleast 1 white pixel
        }
        
        currImageWidth = i.getWidth(); //saves the width and the height to variables
        currImageHeight = i.getHeight(); //so getAttached doesn't overflow
        
        start = System.currentTimeMillis(); //saves the start ime of the iteration
        
        attaches = new boolean[i.getWidth()][i.getHeight()]; //resets the attaches boolean darray so all pixels are unprocessed.
        
        for(int x = 0; x < i.getWidth()/CVAgent.informationPanel.dilate; x++){ //loops over all of the X pixels. Skips (dilate-1) pixels every time because
                                                                               //dilate expands pixels so it makes it ALOT faster
            
            for(int y = 0; y < i.getHeight()/CVAgent.informationPanel.dilate; y++){ //loops over Y pixels
                
                try{
                    
                    if(get(i,x*CVAgent.informationPanel.dilate, y*CVAgent.informationPanel.dilate) != 0){ //Checks if the chosen pixel is white
                        
                        if(getAttached(x*CVAgent.informationPanel.dilate,y*CVAgent.informationPanel.dilate)){ //Checks if the pixel isn't attached
                            
                            Blob b = cycle(i,x*CVAgent.informationPanel.dilate,y*CVAgent.informationPanel.dilate); //Sends the pixel through the cycle loop
                            
                            results.add(b); //Add it to the results array
                            
                        }
                        
                    }
                    
                }catch(Exception e){
                    e.printStackTrace(); //catchin dem exceptions
                }
                
                if(shouldCancel())return results; //quits after 300ms
                    
            }
        }
        return results;
    }
    private static int get(BufferedImage i, int x, int y){
        try {
        return ((i.getRGB(x, y)  >> 16) & 0xFF); //getRGB returns an int in this format = 0xAARRGGBB. I chose red because... i felt like it.
        } catch (Exception e) {
            return 0;
        }
    }
    
    
    
}
