import greenfoot.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class GalagaWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GalagaWorld extends World {

   private Score score;
   private GreenfootImage background;
   private int level;
   private int speed;
   private ArrayList<Enemy> enemyList;

   public GalagaWorld() {
      super(1120, 1440, 1, false);
      background = new GreenfootImage("C:\\Users\\Bradley\\Desktop\\ENGR 1110\\Project\\Galaga\\images\\galaga-background.png");
      setBackground(background);
      level = 1;
      createStarsAtRandom();

      addObject(new Fighter(true), this.getWidth() / 2, this.getHeight() - 195);
      addObject(new Fighter(false), 70, this.getHeight() - 70);
      addObject(new Fighter(false), 195, this.getHeight() - 70);
      createScore();
      speed = 20;
      enemyList = new ArrayList<Enemy>();
      try {
         createEnemiesFromFile();
      } catch (FileNotFoundException e) {
      }
      for (Enemy e : enemyList)
         addObject(e, 0, 1100);
   }

   public void act() {
      createScore();
   }

   private void createEnemiesFromFile() throws FileNotFoundException {
      Scanner file = new Scanner(new File("Stage_1"));

      while (file.hasNextLine()) {
         String type = file.next();
         int x = Integer.parseInt(file.next());
         int y = Integer.parseInt(file.next());

         if (type.equals("BossEnemy")) {
            enemyList.add(new BossEnemy(x, y, speed));
         } else if (type.equals("RedEnemy")) {
            enemyList.add(new RedEnemy(x, y, speed));
         } else if (type.equals("YellowEnemy")) {
            enemyList.add(new YellowEnemy(x, y, speed));
         }
      }

   }

   private void createStarsAtRandom() {
      for (int i = 0; i < 400; i++) {
         addObject(new Star(), Greenfoot.getRandomNumber(this.getWidth()), 100 + Greenfoot.getRandomNumber(this.getHeight() - 242));
      }
   }

   private void createScore() {
      GreenfootImage bg = getBackground();
      bg.setColor(Color.RED);
      bg.setFont(new Font("OCR A Extended", Font.BOLD, 60));
      bg.drawString("1UP", 40, 60);
      bg.setColor(Color.WHITE);
      bg.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
      bg.drawString("225", 60, 100);
      bg.setColor(Color.RED);
      bg.setFont(new Font("OCR A Extended", Font.BOLD, 60));
      bg.drawString("HIGH SCORE", this.getWidth() / 2 - 225, 60);
      bg.setColor(Color.WHITE);
      bg.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
      bg.drawString("20000", this.getWidth() / 2 - 110, 100);
   }

   private void gameOver() {
      Greenfoot.stop();
   }

}
