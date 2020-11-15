package spiel;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 14.11.2020
 */

public class PickUp {

    int x;
    int y;

    public PickUp(){
        this.x = ThreadLocalRandom.current().nextInt(0,15);
        this.y = ThreadLocalRandom.current().nextInt(0,15);
    }

    public void reset(){
        this.x = ThreadLocalRandom.current().nextInt(0,15);
        this.y = ThreadLocalRandom.current().nextInt(0,15);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
