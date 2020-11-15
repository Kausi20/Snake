package gui;

import spiel.Snake;

import javax.swing.*;
import java.awt.*;

/**
 * @author: Kaushican Uthayakumaran
 * @version: 1.0
 * @date: 31.10.2020
 */

public class Field extends JLabel {

    Point p;

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);

        //Background
        Color pink = Color.decode("#98e081");
        g.setColor(pink);
        g.fillRect(0,0,GameGUI.width,GameGUI.height);

        //SnakeTails
        Color tail = Color.decode("#8bc4fc");
        g.setColor(tail);
        for (int i = 0; i < Snake.tails.size(); i++) {
            p = Snake.point(Snake.tails.get(i).getX(),Snake.tails.get(i).getY());
            g.fillRect(p.x,p.y,32,32);
        }

        //Head
        Color head = Color.decode("#5d24c8");
        g.setColor(head );
        p = Snake.point(Snake.head.getX(),Snake.head.getY());
        g.fillRect(p.x,p.y,32,32);

        //Pickup
        g.setColor(Color.darkGray);
        p = Snake.point(Snake.pickUp.getX(),Snake.pickUp.getY());
        g.fillRect(p.x,p.y,32,32);

        //Grid
        g.setColor(Color.white);
        for (int x = 0; x < 16; x++) {
            for (int y = 0 ; y < 16; y++ ){
                g.drawRect(x * 32+ GameGUI.xoff, y * 32+ GameGUI.yoff,32,32);
            }
        }

        //Border
        g.setColor(Color.black);
        g.drawRect(GameGUI.xoff,GameGUI.yoff,512,512);

        repaint();

        //Score
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.drawString("Score:" +Snake.score,5,25);
        g.drawString("Score:" +Snake.score,680,25);
    }

}
