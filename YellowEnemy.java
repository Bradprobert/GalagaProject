import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

/**
 * Write a description of class YellowEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class YellowEnemy extends Enemy {

   GreenfootImage yellowEnemy;


   public YellowEnemy(int xFinal, int yFinal, int speed, int spawnGroup) {
      super(xFinal, yFinal);

      yellowEnemy = new GreenfootImage("YellowEnemy.png");
      yellowEnemy.scale(100, 100);
      setImage(yellowEnemy);

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

   /**
    * Act - do whatever the YellowEnemy wants to do. This method is called
    * whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
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
