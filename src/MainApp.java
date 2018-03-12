import processing.core.PApplet;
import processing.core.PImage;

public class MainApp extends PApplet {
    private Remote r1;
    private PImage plaingrass;
    private Character player;
    private int playerX = 0;
    private int playerY = 0;
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
        r1 = new Remote(this);
        player = new Character(this);
    }
    public void draw(){
        handleMovements();
        plaingrass.resize(width,height);
        image(plaingrass,0,0);
        player.loadCharacter(playerX,playerY);
    }
    private void reset(){
        playerX = 0;
        playerY = 0;
    }

    private void handleMovements(){
        if (keyPressed) {
            if (keyCode == 38) {
                player.playerMovesUp();
                playerY -= 2;
            } else if (keyCode == 40) {
                player.playerMovesDown();
                playerY += 2;
            }else if(keyCode == 39){
                player.playerMovesRight();
                playerX += 2;
            }else if(keyCode == 37){
                player.playerMovesLeft();
                playerX -= 2;
            }
        }
    }

}