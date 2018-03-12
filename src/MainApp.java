import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;

import java.util.Random;

public class MainApp extends PApplet {
    private PImage plaingrass;
    private PImage attackbackground;
    private Character player;
    private Pokemon pikachu;
    private int playerX = 0;
    private int playerY = 0;
    private boolean ATTACK_STATE = true;
    private AttackState a1;

    public static void main(String args[]){
        PApplet.main("MainApp",args);
    }

    public void setATTACK_STATE(boolean ATTACK_STATE) {
        this.ATTACK_STATE = ATTACK_STATE;
    }

    public void settings(){
       size(720, 480);
        plaingrass = loadImage("assets/plaingrass.png");
        attackbackground = loadImage("assets/attackbackground.png");
    }
    public void setup(){
        background(255);
//        surface.setResizable(true);
        frameRate(30);
        a1 = new AttackState(this);
        player = new Character(this);
        pikachu = new Pokemon(this,"assets/pikachu.png","Pikachu");
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
            a1.load(pikachu);

            if(mousePressed){
                handleClick(pikachu);
            }
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

    public void handleClick(Pokemon pokemon){
        if(mouseX > 400 && mouseX < 480 && mouseY > 400 && mouseY < 420){
            a1.enemyAttacked();
            a1.reduceEnemyHealth();
        }else if(mouseX > 500 && mouseX < 580 && mouseY > 400 && mouseY < 420){
            a1.playerHealed();
            pokemon.increaseHealth();
        }else if(mousePressed && mouseX > 600 && mouseX < 680 && mouseY > 400 && mouseY < 420){
            ATTACK_STATE = false;
        }
    }

    public boolean isUnderAttack(){
        Random rand = new Random();
        int  n = rand.nextInt(50) + 1; // 1 to 50 inclusive
        if( n == 5){
            return true;
        }else{
            return false;
        }
    }

}