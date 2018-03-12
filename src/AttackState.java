import processing.core.PApplet;

public class AttackState {
    private PApplet parent;
    private String infoText = "Get ready for battle ...";


    public AttackState(PApplet parent) {
        this.parent = parent;
    }
    public void load(Pokemon pokemon){
        pokemon.loadPokemon(30,125);
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


        if(parent.mousePressed){
            handleClick();
        }

    }
    public void handleClick(){
        if(parent.mouseX > 400 && parent.mouseX < 480 && parent.mouseY > 400 && parent.mouseY < 420){
            infoText = "You have attacked!";
        }else if(parent.mouseX > 500 && parent.mouseX < 580 && parent.mouseY > 400 && parent.mouseY < 420){
            infoText = "You have healed your pokemon";
        }else if(parent.mouseX > 600 && parent.mouseX < 680 && parent.mouseY > 400 && parent.mouseY < 420){
            infoText = "You have ran away to safety";
        }
    }

}
