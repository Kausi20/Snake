package gui;

import spiel.Direction;
import spiel.Snake;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 01.09.2020
 */

public class GameGUI extends JFrame {

        Field f;
        public static int width = 800,height = 600;

        public static int xoff= 130, yoff = 20;

        public GameGUI(){
                setTitle("Snake");
                setSize(800,600);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setLayout(null);
                setResizable(false);

                create();
                listener();

                setVisible(true);
        }

        public void create(){

                f = new Field();
                f.setBounds(0,0,800,600);
                f.setVisible(true);
                add(f);

                requestFocus();
        }

        public void listener(){
                addKeyListener(new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent keyEvent) {

                        }

                        @Override
                        public void keyPressed(KeyEvent keyEvent) {
                                switch (keyEvent.getKeyCode()){
                                        case KeyEvent.VK_W:
                                                if (!(Snake.head.getDirection() == Direction.DOWN && !Snake.waitToMove)){
                                                        Snake.head.setDirection(Direction.UP);
                                                        Snake.waitToMove = true;
                                                }
                                                break;

                                        case KeyEvent.VK_A:
                                                if (!(Snake.head.getDirection() == Direction.RIGHT && !Snake.waitToMove)){
                                                        Snake.head.setDirection(Direction.LEFT);
                                                        Snake.waitToMove = true;
                                                }
                                                break;
                                        case KeyEvent.VK_S:
                                                if (!(Snake.head.getDirection() == Direction.UP && !Snake.waitToMove)){
                                                        Snake.head.setDirection(Direction.DOWN);
                                                        Snake.waitToMove = true;
                                                }
                                                break;
                                        case KeyEvent.VK_D:
                                                if (!(Snake.head.getDirection() == Direction.LEFT && !Snake.waitToMove)){
                                                        Snake.head.setDirection(Direction.RIGHT);
                                                        Snake.waitToMove = true;
                                                }
                                                break;
                                }
                        }

                        @Override
                        public void keyReleased(KeyEvent keyEvent) {

                        }
                });
        }
}
