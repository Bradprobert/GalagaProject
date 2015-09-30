import greenfoot.*;

/**
 * Write a description of class GalagaWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GalagaWorld extends World {

    GreenfootImage background;
    /**
     * Constructor for objects of class GalagaWorld.
     */
    public GalagaWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1);
        background = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\galaga-background.png");
        setBackground(background);
    }
}
