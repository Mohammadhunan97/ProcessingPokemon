import processing.core.PApplet;

import java.util.Random;

public class AttackState {
    private PApplet parent;
    private String infoText = "Get ready for battle ...";
    private String enemyHealthStatus;
    private String playerHealthStatus;
    private Pokemon enemy;

    public AttackState(PApplet parent) {
        this.parent = parent;
        Random rand = new Random();
        int  n = rand.nextInt(3) + 1; // 1 to 25 life less inclusive
        if(n == 1){
            this.enemy = new Pokemon(parent,"assets/weedle.png","Weedle");
        }else if(n == 2){
            this.enemy = new Pokemon(parent,"assets/pidgey.png","Pidgey");
        }else{
            this.enemy = new Pokemon(parent,"assets/rattata.png","Rattata");
        }

    }
    public void load(Pokemon pokemon){
        this.enemyHealthStatus = "Health: " + this.enemy.getHealth();
        this.playerHealthStatus = "Your Health: " + pokemon.getHealth();

        enemy.loadPokemon(400,20);
        pokemon.loadPokemon(30,125);

        parent.fill(0);
        parent.text(enemy.getName(),40,40);

        parent.fill(0);
        parent.text(enemyHealthStatus,40,70);


        parent.fill(0);
        parent.text(playerHealthStatus,400,380);

        createPlayerButtons();

    }

    public void createPlayerButtons(){
        parent.fill(255);
        parent.rect(400, 400, 80, 20,5); // x,y, width, height, radius
        parent.fill(0); //text background black
        parent.textSize(12);
        parent.text("Attack", 420,415);
        parent.fill(255); // button background white

        parent.rect(500,400, 80, 20,5);
        parent.fill(0);
        parent.textSize(12);
        parent.text("Heal",520,415);
        parent.fill(255);

        parent.rect(600,400,80,20,5);
        parent.fill(0);
        parent.textSize(12);
        parent.text("Run",620,415);
        parent.fill(255);

        parent.textSize(24);
        parent.text(infoText,50, 400);

    }

    public void reduceEnemyHealth(){
        enemy.reduceHealth();
    }

    public boolean canEnemyFight(){
        return enemy.isAbleToFight();
    }

    public void attackEnemy(){
        infoText = "You have attacked!";
    }

    public void playerHealed(){
        infoText = "You have healed your pokemon";
    }

    public void enemyAttacksPlayer(){
        infoText = enemy.getName() + " has attacked!";
    }
}
