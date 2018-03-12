import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends PApplet {
    private PImage plaingrass;

    public static void main(String args[]){
        PApplet.main("MainApp",args);
    }
    public void settings(){
       size(720, 480);
      //  fullScreen();
        plaingrass = loadImage("assets/plaingrass.png");
    }
    public void setup(){
        background(255);
    }
    public void draw(){
        plaingrass.resize(width,height);
        image(plaingrass,0,0);

    }
    void reset(){
    }

}