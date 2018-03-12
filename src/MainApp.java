import processing.core.PApplet;
import processing.core.PImage;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainApp extends PApplet {
    private PImage plaingrass;
    private PImage attackbackground;
    private Character player;
    private Pokemon pikachu;
    private int playerX = 0;
    private int playerY = 0;
    private boolean ATTACK_STATE = false;
    private AttackState a1;
    private Timer myTimer;
    private int victories = 0;
    private String gameStatus;

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
        frameRate(30);
        a1 = new AttackState(this);
        player = new Character(this);
        pikachu = new Pokemon(this,"assets/pikachu.png","Pikachu");
    }
    public void draw(){
        gameStatus = "You have won " + victories + " battles so far";


        if(ATTACK_STATE == false){
            fill(255); // button background white
            handleMovements();
            plaingrass.resize(width,height);
            image(plaingrass,0,0);
            player.loadCharacter(playerX,playerY);

            textSize(16);
            fill(0);
            text(gameStatus,width - 250,20);
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
    public void scheduleHit(){
        myTimer = new Timer();
        TimerTask tt = new TimerTask(){
            public void run(){
                System.out.println("enemy attacked you");
                a1.enemyAttacksPlayer();
                pikachu.reduceHealth();
                if(pikachu.isAbleToFight() == false){
                    ATTACK_STATE = false;
                    gameStatus = "You have died... resetting the game";
                    victories = 0;
                }
            }
        };
        myTimer.schedule(tt, 2000);
    }

    public void handleClick(Pokemon pokemon){
        if(mouseX > 400 && mouseX < 480 && mouseY > 400 && mouseY < 420){
            a1.attackEnemy();
            a1.reduceEnemyHealth();


            if(a1.canEnemyFight() == false){ // if enemy cannot fight
                ATTACK_STATE = false;
                victories += 1;
            }else{
                myTimer = new Timer();
                scheduleHit();
            }
        }else if(mouseX > 500 && mouseX < 580 && mouseY > 400 && mouseY < 420){
            a1.playerHealed();
            pokemon.increaseHealth();
            scheduleHit();
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