import greenfoot.*;

import java.awt.*;

/**
 * Write a description of class Fighter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Fighter extends Actor {

   private GreenfootImage fighter;
   private boolean inUse;
   private int count = 0;

   /**
    * Constructor for the fighter class to create a new fighter
    *
    * @param inUse
    */
   public Fighter(boolean inUse) {
      this.inUse = inUse;
      fighter = new GreenfootImage("fighter.png");
      setImage(fighter);
      makeBgTransparent();
   }

   /**
    * allows the fighter to move around the screen
    */
   public void act() {
      moveLeft();
      moveRight();
      spacebarFire();
   }

   public void spacebarFire() {
      int count = 0;
      if ("space".equals(Greenfoot.getKey()) && inUse) {
         fire();
         count++;
      }
   }

   /**
    * Will move the fighter left across the screen when the left arrow key is pressed down.
    */
   public void moveLeft() {
      if (Greenfoot.isKeyDown("left") && inUse) {
         setLocation(this.getX() - 15, this.getY());
      }
   }

   /**
    * Will move the fighter right across the screen when the right arrow key is pressed down.
    */
   public void moveRight() {
      if (Greenfoot.isKeyDown("right") && inUse) {
         setLocation(this.getX() + 15, this.getY());
      }
   }

   public boolean getInUse() {
      return inUse;
   }

   public void setInUse(boolean inUse) {
      this.inUse = inUse;

      if (count == 0)
         this.setLocation(1120 / 2, 1440 - 195);
      count++;
   }

   private void makeBgTransparent() {
      for (int i = 0; i < this.getImage().getWidth(); i++) {
         for (int j = 0; j < this.getImage().getHeight(); j++) {
            Color color = this.getImage().getColorAt(i, j);
            if (color.equals(new Color(0, 0, 0))) {
               this.getImage().setColorAt(i, j, new Color(0, 0, 0, 0));
            }
         }
      }
   }

   private void fire() {
      FighterBullet b = new FighterBullet();
      getWorld().addObject(b, getX(), getY());
      b.setRotation(270);
   }
}

