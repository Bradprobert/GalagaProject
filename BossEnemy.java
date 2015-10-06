import greenfoot.GreenfootImage;

/**
 * Write a description of class BossEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BossEnemy extends Enemy {

   private GreenfootImage bossEnemy;


   public BossEnemy(int xFinal, int yFinal) {
      super(xFinal, yFinal);
      bossEnemy = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\BossEnemy1.png");
      bossEnemy.scale(100, 100);
      setImage(bossEnemy);

   }

   public void act() {

   }

}
