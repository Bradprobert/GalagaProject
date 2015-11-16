import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;
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

   private static int score;
   private GreenfootImage background = new GreenfootImage("beginning.png");
   private int level;
   private int speed;
   private ArrayList<Enemy> enemyList;
   private int count = 0;
   public static int fighterNum = 0;
   Fighter fighter1 = new Fighter(true);
   Fighter fighter2 = new Fighter(false);
   Fighter fighter3 = new Fighter(false);

   public GalagaWorld() {
      super(1120, 1440, 1, false);
      setPaintOrder(GameOver.class, Fighter.class, Enemy.class,
            FighterBullet.class, EnemyBullet.class, Star.class);
      setBackground(background);
   }

   public void act() {
      fighterSwitch();
      if (Greenfoot.isKeyDown("space")) {
         buildWorld();
         createScore();
         count++;
      }
   }

   private void createEnemiesFromFile() throws FileNotFoundException {
      Scanner file = new Scanner(new File("Stage_1"));

      while (file.hasNextLine()) {
         String type = file.next();
         int x = Integer.parseInt(file.next());
         int y = Integer.parseInt(file.next());
         int spawnGroup = Greenfoot.getRandomNumber(5);

         if (type.equals("BossEnemy")) {
            enemyList.add(new BossEnemy(x, y, speed, spawnGroup));
         } else if (type.equals("RedEnemy")) {
            enemyList.add(new RedEnemy(x, y, speed, spawnGroup));
         } else if (type.equals("YellowEnemy")) {
            enemyList.add(new YellowEnemy(x, y, speed, spawnGroup));
         }
      }

   }

   private void createStarsAtRandom() {
      for (int i = 0; i < 400; i++) {
         addObject(new Star(), Greenfoot.getRandomNumber(this.getWidth()),
               100 + Greenfoot.getRandomNumber(this.getHeight() - 242));
      }
   }

   private void createScore() {
      GreenfootImage bg = getBackground();
      bg.setColor(Color.RED);
      bg.setFont(new Font("OCR A Extended", Font.BOLD, 60));
      bg.drawString("1UP", 40, 60);
      bg.setColor(Color.WHITE);

      GreenfootImage ImageText = new GreenfootImage(Integer.toString(score),
            50, Color.WHITE, Color.BLACK);
      ImageText.setFont(new Font("OCR A Extended", Font.PLAIN, 40));

      bg.drawImage(ImageText, 70, 65);
      bg.setColor(Color.RED);
      bg.setFont(new Font("OCR A Extended", Font.BOLD, 60));
      bg.drawString("HIGH SCORE", this.getWidth() / 2 - 225, 60);
      bg.setColor(Color.WHITE);
      bg.setFont(new Font("OCR A Extended", Font.PLAIN, 40));
      bg.drawString("20000", this.getWidth() / 2 - 110, 100);

   }

   private void fighterSwitch() {
      if (fighterNum == 1) {
         fighter2.setInUse(true);
      } else if (fighterNum == 2) {
         fighter3.setInUse(true);
      } else if (fighterNum >= 3) {
         addObject(new GameOver(), getWidth() / 2, getHeight() / 2);
         Greenfoot.stop();
      }
   }

   private void gameOver() {
      Greenfoot.stop();
   }

   private void buildWorld() {
      if (count < 1) {
         background = new GreenfootImage("galaga-background.png");
         setBackground(background);
         level = 1;
         createStarsAtRandom();

         addObject(fighter1, this.getWidth() / 2, this.getHeight() - 195);

         addObject(fighter3, 70, this.getHeight() - 70);

         addObject(fighter2, 195, this.getHeight() - 70);

         createScore();

         speed = 15;

         enemyList = new ArrayList<Enemy>();
         try {
            createEnemiesFromFile();
         } catch (FileNotFoundException e) {
         }
         for (Enemy e : enemyList)
            addObject(e, 0, Greenfoot.getRandomNumber(500) + 600);
      }
   }

   public static void setScore(int scoreIn) {
      score += scoreIn;
   }
}
