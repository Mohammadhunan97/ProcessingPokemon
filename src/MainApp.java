import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends PApplet {
    private PImage plaingrass;
    private Character player;
    public static void main(String args[]){
        PApplet.main("MainApp",args);
    }
    public void settings(){
       size(720, 480);
        plaingrass = loadImage("assets/plaingrass.png");
    }
    public void setup(){
        background(255);
        surface.setResizable(true);
        frameRate(30);
        player = new Character(this);
    }
    public void draw(){
        plaingrass.resize(width,height);
        image(plaingrass,0,0);
        player.loadCharacter();
    }
    void reset(){
    }

}