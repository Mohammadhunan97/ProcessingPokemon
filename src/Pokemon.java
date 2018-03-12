import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Pokemon {
    private PApplet parent;
    private PImage sprite;
    private String name;
    private int health = 100;


    public Pokemon(PApplet parent,String imageFile, String name) {
        this.parent = parent;
        this.sprite = parent.loadImage(imageFile);
        this.name = name;
    }
    public void loadPokemon(int x, int y){
        sprite.resize(284,202);
        parent.image(sprite,x,y);
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(){
        Random rand = new Random();
        int  n = rand.nextInt(25) + 1; // 1 to 25 life less inclusive
        health -= n;
    }

    public void increaseHealth(){
        Random rand = new Random();
        int  n = rand.nextInt(10) + 1; // 1 to 25 life less inclusive
        health += n;
    }
}
