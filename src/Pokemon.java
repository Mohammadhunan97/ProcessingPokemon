import processing.core.PApplet;
import processing.core.PImage;

public class Pokemon {
    private PApplet parent;
    private PImage sprite;


    public Pokemon(PApplet parent) {
        this.parent = parent;
        sprite = parent.loadImage("assets/pikachu.png");
    }
    public void loadPokemon(int x, int y){
        sprite.resize(284,202);
        parent.image(sprite,x,y);
    }
}
