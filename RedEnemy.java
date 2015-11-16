import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Write a description of class RedEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedEnemy extends Enemy {

   final GreenfootImage RedEnemy;

   public RedEnemy(int xFinal, int yFinal, int speed, int spawnGroup) {
      super(xFinal, yFinal);
      RedEnemy = new GreenfootImage("RedEnemy.png");
      RedEnemy.scale(100, 100);
      setImage(RedEnemy);

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
