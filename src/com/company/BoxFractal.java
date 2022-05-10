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


        int [] xcoord = {xCenter - 128, xCenter - 128, xCenter + 128, xCenter + 128};
        int [] ycoord = {yCenter - 128, yCenter + 128, yCenter + 128, yCenter - 128};

        g.setColor(Color.BLUE);
        drawAndSplit(g, xcoord, ycoord, levels);

    }

    public int [] midpoints(int [] x)
    {
        int [] m = new int [4];

        m[0] = (x[0] + x[1])/3;
        m[1] = (x[1] + x[2])/3;
        m[2] = (x[2] + x[3])/3;
        m[3] = (x[3] + x[0])/3;

        return m;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {

//        int [] xcoord = {xCenter - 128, xCenter - 128, xCenter + 128, xCenter + 128};
//        int [] ycoord = {yCenter - 128, yCenter + 128, yCenter + 128, yCenter - 128};

        if(times != 0){
            int[] xCoords = midpoints(x);
            int[] yCoords = midpoints(y);

            //Top Left Section
            int[] recurseX = {x[0], x[0], xCoords[2], xCoords[2]};
            int[] recurseY = {y[0], yCoords[0], yCoords[2], yCoords[1]};
            drawAndSplit(g, recurseX, recurseY, times-1);

//            //Top Right Section
//            int[] recurseXtwo = {x[1], xCoords[0], xCoords[1]};
//            int[] recurseYtwo = {y[1], yCoords[0], yCoords[1]};
//            drawAndSplit(g, recurseXtwo, recurseYtwo, times-1);
//
//            //Bottom Left Section
//            int[] recurseXthree = {xCoords[1], xCoords[2], x[2]};
//            int[] recurseYthree = {yCoords[1], yCoords[2], y[2]};
//            drawAndSplit(g, recurseXthree, recurseYthree, times-1);
//
//            //Bottom Right Section
//            int[] recurseXfour = {xCoords[1], xCoords[2], x[2]};
//            int[] recurseYfour = {yCoords[1], yCoords[2], y[2]};
//            drawAndSplit(g, recurseXfour, recurseYfour, times-1);
//
//            //Middle Section
//            int[] recurseXfive = {xCoords[1], xCoords[2], x[2]};
//            int[] recurseYfive = {yCoords[1], yCoords[2], y[2]};
//            drawAndSplit(g, recurseXfive, recurseYfive, times-1);
        }

        g.drawPolygon(x, y, 3);

    }
    public static void main(String[] args)
    {
        JFrame window = new JFrame("Fractals");
        window.setBounds(200, 200, 500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoxFractal panel = new BoxFractal(5);
        panel.setBackground(Color.WHITE);
        Container c = window.getContentPane();
        c.add(panel);
        window.setVisible(true);
    }
}