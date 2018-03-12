import processing.core.PApplet;

public class AttackState {
    private PApplet parent;
    private String infoText = "Get ready for battle ...";
    private String enemyHealthStatus;
    private String playerHealthStatus;
    private Pokemon enemy;

    public AttackState(PApplet parent) {
        this.parent = parent;
        this.enemy = new Pokemon(parent,"assets/weedle.png","Weedle");
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

        if(parent.mousePressed){
            handleClick(pokemon);
        }

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
    public void handleClick(Pokemon pokemon){
        if(parent.mouseX > 400 && parent.mouseX < 480 && parent.mouseY > 400 && parent.mouseY < 420){
            infoText = "You have attacked!";
            enemy.reduceHealth();
        }else if(parent.mouseX > 500 && parent.mouseX < 580 && parent.mouseY > 400 && parent.mouseY < 420){
            infoText = "You have healed your pokemon";
            pokemon.increaseHealth();

        }
    }

}