import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

import java.util.Timer;
import java.util.concurrent.Delayed;

/**
 * Write a description of class BossEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BossEnemy extends Enemy {

   private GreenfootImage bossEnemy;
   public int count = 0;

   public BossEnemy(int xFinal, int yFinal, int speed, int spawnGroup) {
      super(xFinal, yFinal);
      bossEnemy = new GreenfootImage("BossEnemy1.png");
      bossEnemy.scale(100, 100);
      setImage(bossEnemy);

      setRotation(90);
      dy = 0;
      dx = speed;
      initialVx = speed;
      initialVy = 0;
      finalVx = 0;
      finalVy = speed;
      cycles = spawnGroup * super.cycles;

      setAccelerationX();
      setAccelerationY();
      setRotation(0);
      makeBgTransparent();

   }

   public void act() {
      if (cycles != 0) {
         cycles--;
      } else {
         moveLeftThenTurnUp();
         setFinalPosition();
      }
      makeInvisible();
      if (Greenfoot.getRandomNumber(1000) < 1) {
         fire();
      }
   }

}
