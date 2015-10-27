import greenfoot.GreenfootImage;

/**
 * Write a description of class RedEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RedEnemy extends Enemy {

   final GreenfootImage RedEnemy;

   public RedEnemy(int xFinal, int yFinal) {
      super(xFinal, yFinal);
      RedEnemy = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\RedEnemy.png");
      RedEnemy.scale(100, 100);
      setImage(RedEnemy);
   }

   public void act() {
      // Add your action code here.
   }
}
