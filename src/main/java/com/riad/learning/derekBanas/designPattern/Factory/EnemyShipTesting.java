package com.riad.learning.derekBanas.designPattern.Factory;

import java.util.Scanner;

public class EnemyShipTesting {

    public static void main(String[] args) {

        EnemyShip theEnemy = null;

        Scanner userInput  = new Scanner(System.in);
        String enemyShipOption = "";
        System.out.println("What type of Ship? (U/R)");

        if(userInput.hasNextLine()) {
            enemyShipOption = userInput.nextLine();
        }

        if (enemyShipOption.equals("U")){
            theEnemy = new UFOEnemyShip();
        }

        if (enemyShipOption.equals("R")){
            theEnemy = new RocketEnemyShip();
        }
        doStuffEnemy(theEnemy);
    }

    private static void doStuffEnemy(EnemyShip anEnemyShip) {

        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();

    }
}
