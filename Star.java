import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.awt.*;

/**
 * Write a description of class Star here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Star extends Actor {
    GreenfootImage star;


    public Star() {
        star = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\star.png");
        star.scale(5, 5);
        if (Greenfoot.getRandomNumber(100) < 40) {
            star.setTransparency(80);
        }

        colorStars();
        setImage(star);
    }

    public void act() {
        setLocation(this.getX(), this.getY() + 3);
        if (this.getY() >= getWorld().getHeight() - 2) {
            setLocation(this.getX(), 0);
        }

    }

    private void colorStars() {
        if (Greenfoot.getRandomNumber(100) < 20) {
            for (int i = 0; i < star.getWidth(); i++) {
                for (int j = 0; j < star.getHeight(); j++) {
                    star.setColorAt(i, j, Color.CYAN);
                }
            }
        }

        if (Greenfoot.getRandomNumber(100) < 20) {
            for (int i = 0; i < star.getWidth(); i++) {
                for (int j = 0; j < star.getHeight(); j++) {
                    star.setColorAt(i, j, Color.RED);
                }
            }
        }
        if (Greenfoot.getRandomNumber(100) < 20) {
            for (int i = 0; i < star.getWidth(); i++) {
                for (int j = 0; j < star.getHeight(); j++) {
                    star.setColorAt(i, j, Color.GREEN);
                }
            }
        }
    }
}
