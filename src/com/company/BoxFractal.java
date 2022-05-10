package com.company;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  Square Rose, a recursive algorithm
 */

public class BoxFractal extends JPanel
{
    private int levels;
    public BoxFractal(int lev)
    {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;


        int x = xCenter;
        int y = yCenter;
        int length = 486;
        int height = 486;

        g.setColor(Color.BLUE);
        drawAndSplit(g, x, y, length, height, levels);

    }

    public void drawAndSplit(Graphics g, int startX, int startY,
                             int length, int height, int times) {

        if(times != 0){
            System.out.println("run if");
            //Middle
            drawAndSplit(g, startX, startY, length/3, height/3, times-1);
            //Bottom Right
            drawAndSplit(g, startX + length/3, startY + height/3, length/3, height/3, times-1);
            //Bottom Left
            drawAndSplit(g, startX - length/3, startY + height/3, length/3, height/3, times-1);
            //Top Right
            drawAndSplit(g, startX + length/3, startY - height/3, length/3, height/3, times-1);
            //Top Left
            drawAndSplit(g, startX - length/3, startY - height/3, length/3, height/3, times-1);
        }

        else{
            System.out.println("run else");
            g.fillRect(startX, startY, height, length);
        }

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("BoxFractal");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxFractal panel = new BoxFractal(5);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}