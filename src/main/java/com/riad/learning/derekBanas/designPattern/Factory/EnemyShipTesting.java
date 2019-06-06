package com.riad.learning.derekBanas.designPattern.Factory;

import java.util.Scanner;

public class EnemyShipTesting {

    public static void main(String[] args) {

        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;

        Scanner userInput  = new Scanner(System.in);
        String enemyShipOption = "";
        System.out.println("What type of Ship? (U/R)");

        if(userInput.hasNextLine()) {
            enemyShipOption = userInput.nextLine();
            theEnemy = shipFactory.makeEnemyShip(enemyShipOption);
        }

        if (theEnemy != null) {
            doStuffEnemy(theEnemy);
        }else {
            System.out.println("Enter U or R next time");
        }



    }

    private static void doStuffEnemy(EnemyShip anEnemyShip) {

        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();

    }
}
