import greenfoot.*;

/**
 * Write a description of class Fighter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fighter extends Actor {

   private GreenfootImage fighter;
   private boolean inUse;
   private static final float GRAVITY = 0.5f;
   float dy;
   int initialY;

   public Fighter(boolean inUse) {
      this.inUse = inUse;
      fighter = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\fighter.png");
      setImage(fighter);
      dy = -20;
      initialY = 1205;
   }

   public void act() {
      moveLeft();
      moveRight();
      if (inUse && Greenfoot.isKeyDown("up")) {
         jump();
      }
   }

   public void moveLeft() {
      if (Greenfoot.isKeyDown("left") && inUse) {
         setLocation(this.getX() - 10, this.getY());
      }
   }

   public void moveRight() {
      if (Greenfoot.isKeyDown("right") && inUse) {
         setLocation(this.getX() + 10, this.getY());
      }
   }

   public void jump() {
      dy += 0.5;
      setLocation(this.getX(), this.getY() + (int) dy);
   }
}

