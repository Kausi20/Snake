package actions;

import clocks.GameClock;
import gui.GameGUI;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 01.09.2020
 */

public class App {

    public static void main(String[] args) {
        GameGUI gameGUI = new GameGUI();
        GameClock gameClock = new GameClock();

        gameClock.start();
    }
}
