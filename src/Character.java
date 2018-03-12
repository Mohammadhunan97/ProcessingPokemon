import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    private PApplet parent;
    private PImage Character;

    public Character(PApplet parent) {
        this.parent = parent;
        Character = parent.loadImage("assets/player_right.png");
    }

    public void loadCharacter(){
        parent.image(Character,0,0);
    }

}
