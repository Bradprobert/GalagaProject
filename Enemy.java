import greenfoot.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Enemy here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Enemy extends Actor {

   private int xFinal;
   private int yFinal;
   private ArrayList<Enemy> enemyList;
   private int angle;

   public Enemy(int xFinal, int yFinal) {
      this.xFinal = xFinal;
      this.yFinal = yFinal;
      enemyList = new ArrayList<Enemy>();
      angle = 0;


   }

   public void act() {
      enemyList.get(0).setLocation(this.getX() + 5, this.getY());

   }

   public int getxFinal() {
      return xFinal;
   }

   public int getyFinal() {
      return yFinal;
   }
}
