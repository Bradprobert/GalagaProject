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
   private float initialYVelocity;
   int initialY;

   /**
    * Constructor for the fighter class to create a new fighter
    *
    * @param inUse
    */
   public Fighter(boolean inUse) {
      this.inUse = inUse;
      fighter = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\fighter.png");
      setImage(fighter);
      initialYVelocity = -20;
      initialY = 1205;
   }

   /**
    * allows the fighter to move around the screen
    */
   public void act() {
      moveLeft();
      moveRight();
      if (inUse && Greenfoot.isKeyDown("up")) {
         jump();
      } else if (inUse) {
         setLocation(this.getX(), getWorld().getHeight() - 195);
         initialYVelocity = -20;
      }
   }

   /**
    * Will move the fighter left across the screen when the left arrow key is pressed down.
    */
   public void moveLeft() {
      if (Greenfoot.isKeyDown("left") && inUse) {
         setLocation(this.getX() - 10, this.getY());
      }
   }

   /**
    * Will move the fighter right across the screen when the right arrow key is pressed down.
    */
   public void moveRight() {
      if (Greenfoot.isKeyDown("right") && inUse) {
         setLocation(this.getX() + 10, this.getY());
      }
   }

   /**
    * will move the fighter up and down with a parabolic path.
    */
   public void jump() {
      initialYVelocity += 0.5;
      setLocation(this.getX(), this.getY() + (int) initialYVelocity);
   }
}

