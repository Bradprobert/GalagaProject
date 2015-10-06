import greenfoot.*;
import java.util.ArrayList;

/**
 * Write a description of class GalagaWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GalagaWorld extends World {

   GreenfootImage background;
   ArrayList<Enemy> enemyList;


   public GalagaWorld() {
      // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
      super(2200, 1400, 1);
      background = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\galaga-background.png");
      setBackground(background);
      for (int i = 0; i < 400; i++) {
         addObject(new Star(), Greenfoot.getRandomNumber(this.getWidth()), Greenfoot.getRandomNumber(this.getHeight()));
      }

      enemyList = new ArrayList<>();
      createEnemies();

      addObject(new Fighter(true), this.getWidth() / 2, this.getHeight() - 195);
      addObject(new Fighter(false), 70, this.getHeight() - 70);
      addObject(new Fighter(false), 195, this.getHeight() - 70);

   }

   private void createEnemies() {
      enemyList.add(new BossEnemy(this.getWidth() / 4, this.getHeight() / 2));
      enemyList.add(new BossEnemy(this.getWidth() / 2, this.getHeight() / 2));
      enemyList.add(new BossEnemy(this.getWidth() * 3 / 4, this.getHeight() / 2));
      //enemyList.add(new BossEnemy());


      for (Enemy e : enemyList)
         addObject(e, e.getxFinal(), e.getyFinal());
   }

   public void act(){

   }


}
