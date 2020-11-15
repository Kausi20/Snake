package spiel;

import clocks.GameClock;
import gui.GameGUI;

import java.awt.*;
import java.util.ArrayList;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 14.11.2020
 */

public class Snake {

    public static int score = 0;
    public static int bestscore = 0;

    public static boolean waitToMove = false;

    public static Head head = new Head(7,7);
    public static ArrayList<Tail> tails = new ArrayList<>();
    public static PickUp pickUp = new PickUp();

    public static void addTail(){
        if(tails.size()<1){
            tails.add(new Tail(head.getX(),head.getY()));
        } else{
            tails.add(new Tail(tails.get(tails.size()-1).x,tails.get(tails.size()-1).y));
        }
        GameClock.speed = GameClock.speed -3;
    }

    public static void move(){
        if (tails.size()>=2){
            for (int i = tails.size()-1; i>=1; i--){
                if(tails.get(i).isWait()){
                    tails.get(i).setWait(false);
                }else{
                    tails.get(i).setX(tails.get(i-1).getX());
                    tails.get(i).setY(tails.get(i-1).getY());
                }
            }
        }

        //Move first tail to head
        if(tails.size()>=1){
            if(tails.get(0).isWait()){
                tails.get(0).setWait(false);
            }else{
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        //Move head
        switch (head.getDirection()){
            case RIGHT: head.setX(head.getX() + 1);
                break;
            case LEFT: head.setX(head.getX() - 1);
                break;
            case UP: head.setY(head.getY() - 1);
                break;
            case DOWN: head.setY(head.getY()+ 1);
                break;

        }
    }

    //Position to Coordinates
    public static Point point(int x, int y){
        Point point = new Point(0,0);
        point.x = x * 32 + GameGUI.xoff;
        point.y = y * 32 + GameGUI.yoff;

        return point;
    }
}
