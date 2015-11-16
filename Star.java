import greenfoot.*;

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
      star = new GreenfootImage("star.png");
      star.scale(3, 3);
      addDepthToStars();
      colorStars();
      setImage(star);
   }

   public void act() {
      setLocation(this.getX(), this.getY() + 4);
      if (this.getY() >= getWorld().getHeight() - 142) {
         setLocation(this.getX(), 100);
      }

   }

   private void addDepthToStars() {
      if (Greenfoot.getRandomNumber(100) < 20) {
         star.setTransparency(40);
      }
      if (Greenfoot.getRandomNumber(100) < 20) {
         star.setTransparency(80);
      }
      if (Greenfoot.getRandomNumber(100) < 20) {
         star.setTransparency(100);
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
