import greenfoot.GreenfootImage;

/**
 * Write a description of class RedEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedEnemy extends Enemy {

   final GreenfootImage RedEnemy;

   public RedEnemy(int xFinal, int yFinal, int speed) {
      super(xFinal, yFinal);
      RedEnemy = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\RedEnemy.png");
      RedEnemy.scale(100, 100);
      setImage(RedEnemy);

      setRotation(90);
      dy = 0;
      dx = speed;
      initialVx = speed;
      initialVy = 0;
      finalVx = 0;
      finalVy = speed;

      setAccelerationX();
      setAccelerationY();
      setRotation(0);
   }

   public void act() {
      moveLeftThenTurnUp();
      setFinalPosition();
   }
}
