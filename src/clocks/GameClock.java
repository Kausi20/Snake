package clocks;

import actions.Collision;
import spiel.Snake;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 14.11.2020
 */

public class GameClock extends Thread{

    public static int speed = 200;

    public static boolean running = true;

    public void run(){
        while (running){
            try {
                sleep(speed);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();
                if (Collision.collideSelf()){
                    Snake.tails.clear();
                    Snake.score=0;
                    GameClock.speed = 200;
                }
                if (Collision.collideWall()){
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    Snake.score=0;
                    GameClock.speed = 200;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
