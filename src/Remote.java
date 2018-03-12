import processing.core.PApplet;

public class Remote {
    private PApplet parent;
    public Remote(PApplet parent){
        this.parent = parent;
    }

    public void handlePlayerMovements(){
        if (parent.keyPressed) {
            if (parent.keyCode == 38) {
                System.out.println("up");
                //yAxis -= 1;
            } else if (parent.keyCode == 40) {
                System.out.println("down");
                //yAxis += 1;
            }
        }
    }

}
