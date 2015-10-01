import greenfoot.*;

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

   }

   public void act() {
      setLocation(this.getX(), this.getY() + 3);
   }

   @Override
   public void setLocation(int x, int y) {
      super.setLocation(x, y);
   }
}
