import greenfoot.Actor;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

    private int xFinal;
    private int yFinal;

    public Enemy(int xFinal, int yFinal) {
        this.xFinal = xFinal;
        this.yFinal = yFinal;
    }

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // Add your action code here.
    }

    public int getxFinal() {
        return xFinal;
    }

    public int getyFinal() {
        return yFinal;
    }
}
