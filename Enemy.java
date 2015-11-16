import greenfoot.Actor;

import java.awt.*;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

   protected int xFinal;
   protected int yFinal;
   protected float dx;
   protected float dy;
   protected int finalVx;
   protected int initialVx;
   protected int finalVy;
   protected int initialVy;
   protected double accelerationY;
   protected double accelerationX;
   protected int cycles;

   public Enemy(int xFinal, int yFinal) {
      this.xFinal = xFinal;
      this.yFinal = yFinal;
      cycles = 100;
   }

   public void act() {

   }

   protected void moveLeftThenTurnUp() {
      setLocation((int) (this.getX() + dx + .5), (int) (this.getY() + dy));
      if (dx <= 0) {
         setRotation(0);
      } else {
         setRotation((int) -(Math.toDegrees(Math.atan(-dy / dx)) - 90));
      }
      if (dy < finalVy)
         dy += accelerationY;
      if (dx > 0)
         dx += accelerationX;
      else
         dx = 0;

   }

   protected void setAccelerationX() {
      double numerator = Math.pow(finalVx, 2) - Math.pow(initialVx, 2);
      double denominator = 2 * getxFinal();
      accelerationX = numerator / denominator;
   }

   protected void setAccelerationY() {
      double numerator = Math.pow(finalVy, 2) - Math.pow(initialVy, 2);
      double denominator = 2 * (getyFinal() - 700);
      accelerationY = numerator / denominator;
   }

   public void setFinalPosition() {
      if (this.getY() <= this.getyFinal())
         this.setLocation(this.getxFinal(), this.getyFinal());
      if (this.getX() == this.getxFinal() && this.getY() == this.getyFinal()) {
         this.accelerationX = 0;
         this.accelerationY = 0;
         this.setLocation(this.getxFinal(), this.getyFinal());
         this.setRotation(0);
      }
   }

   protected void makeBgTransparent() {
      for (int i = 0; i < this.getImage().getWidth(); i++) {
         for (int j = 0; j < this.getImage().getHeight(); j++) {
            Color color = this.getImage().getColorAt(i, j);
            if (color.equals(new Color(0, 0, 0))) {
               this.getImage().setColorAt(i, j, new Color(0, 0, 0, 0));
            }
         }
      }
   }

   protected void makeInvisible() {
      if (this.getX() == 0) {
         this.getImage().setTransparency(0);
      } else {
         this.getImage().setTransparency(255);
      }
   }

   public int getxFinal() {
      return xFinal;
   }

   public int getyFinal() {
      return yFinal;
   }

   protected void fire() {
      if (getOneObjectAtOffset(0, 100, Enemy.class) == null) {
         EnemyBullet b = new EnemyBullet();
         getWorld().addObject(b, getX(), getY());
         b.setRotation(270);
      }
   }
}
