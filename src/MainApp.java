import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

import java.util.Random;

public class MainApp extends PApplet {
    private PImage plaingrass;
    private PImage attackbackground;
    private Character player;
    private int playerX = 0;
    private int playerY = 0;
    private boolean ATTACK_STATE = true;

    public static void main(String args[]){
        PApplet.main("MainApp",args);
    }
    public void settings(){
       size(720, 480);
        plaingrass = loadImage("assets/plaingrass.png");
        attackbackground = loadImage("assets/attackbackground.png");
    }
    public void setup(){
        background(255);
        surface.setResizable(true);
        frameRate(30);
        player = new Character(this);
    }
    public void draw(){

        if(ATTACK_STATE == false){
            handleMovements();
            plaingrass.resize(width,height);
            image(plaingrass,0,0);
            player.loadCharacter(playerX,playerY);
        }else{
            attackbackground.resize(width,height);
            image(attackbackground,0,0);
        }

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
                ATTACK_STATE = isUnderAttack();
            } else if (keyCode == 40) {
                player.playerMovesDown();
                playerY += 4;
                ATTACK_STATE = isUnderAttack();
            }else if(keyCode == 39){
                player.playerMovesRight();
                playerX += 4;
                ATTACK_STATE = isUnderAttack();
            }else if(keyCode == 37){
                player.playerMovesLeft();
                playerX -= 4;
                ATTACK_STATE = isUnderAttack();
            }
        }
    }

    public boolean isUnderAttack(){
        Random rand = new Random();
        int  n = rand.nextInt(50) + 1; // 1 to 100 inclusive
        if( n == 5){
            return true;
        }else{
            return false;
        }
    }

}