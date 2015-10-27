import greenfoot.GreenfootImage;

/**
 * Write a description of class BossEnemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BossEnemy extends Enemy {

   private GreenfootImage bossEnemy;
   private int angle;
   int degrees = 0;
   float dx;
   float dy;

   public BossEnemy(int xFinal, int yFinal) {
      super(xFinal, yFinal);
      bossEnemy = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\BossEnemy1.png");
      bossEnemy.scale(100, 100);
      setImage(bossEnemy);
      angle = 0;
      setRotation(90);
      dy = 0;
      dx = 10;
   }

   public void act() {
      moveThenTurnUp();
   }

   public void moveThenTurnUp() {
      setLocation((int) (this.getX() + dx), (int) (this.getY() - dy));
      if (dx == 0) {
         setRotation(0);
      } else {
         //setRotation((int) -(Math.toDegrees(Math.atan(dy / dx)) - 90));
      }
      if (dy < 10)
         dy += 1;
      if (dx > 0)
         dx -= 1;

   }
}
