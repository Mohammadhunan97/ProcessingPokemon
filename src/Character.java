import processing.core.PApplet;
import processing.core.PImage;

public class Character {
    private PApplet parent;
    private PImage Character;

    public Character(PApplet parent) {
        this.parent = parent;
        Character = parent.loadImage("assets/player_right.png");
    }

    public void loadCharacter(int x, int y){ // x coordinate, y coordinate
        parent.image(Character,x,y);
    }


    public void playerMovesUp(){
        Character = parent.loadImage("assets/player_up.png");
    }
    public void playerMovesDown(){
        Character = parent.loadImage("assets/player_down.png");
    }

    public void playerMovesRight(){
        Character = parent.loadImage("assets/player_right.png");
    }

    public void playerMovesLeft(){
        Character = parent.loadImage("assets/player_left.png");
    }

}
