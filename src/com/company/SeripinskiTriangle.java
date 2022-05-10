package com.company;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *  Square Rose, a recursive algorithm
 */
public class SeripinskiTriangle extends JPanel
{
    private int levels;
    public SeripinskiTriangle(int lev)
    {
        levels = lev;
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);  // Call JPanel's paintComponent method
        //   to paint the background
        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;


        int [] xcoord = {xCenter, xCenter - 128, xCenter + 128};
        int [] ycoord = {yCenter, yCenter + 128, yCenter + 128};

        g.setColor(Color.BLACK);
        drawAndSplit(g, xcoord, ycoord, levels);

    }

    public int [] midpoints(int [] x)
    {
        int [] m = new int [3];

        m[0] = (x[0]+x[1])/2;
        m[1] = (x[1]+x[2])/2;
        m[2] = (x[2]+x[0])/2;

        return m;
    }

    public void drawAndSplit(Graphics g, int [] x, int [] y, int times)
    {

        if(times != 0){
            int[] xCoords = midpoints(x);
            int[] yCoords = midpoints(y);

            //Top Section
            int[] recurseX = {x[0], xCoords[0], xCoords[2]};
            int[] recurseY = {y[0], yCoords[0], yCoords[2]};
            drawAndSplit(g, recurseX, recurseY, times-1);

            //Bottom Left Section
            int[] recurseXtwo = {x[1], xCoords[0], xCoords[1]};
            int[] recurseYtwo = {y[1], yCoords[0], yCoords[1]};
            drawAndSplit(g, recurseXtwo, recurseYtwo, times-1);

            //Bottom Right Section
            int[] recurseXthree = {xCoords[1], xCoords[2], x[2]};
            int[] recurseYthree = {yCoords[1], yCoords[2], y[2]};
            drawAndSplit(g, recurseXthree, recurseYthree, times-1);
        }

        g.drawPolygon(x, y, 3);

    }
    public static void main(String[] args)
    {
            JFrame window = new JFrame("SeripinskiTriangle");
            window.setBounds(200, 200, 500, 500);
            window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            SeripinskiTriangle panel = new SeripinskiTriangle(5);
            panel.setBackground(Color.WHITE);
            Container c = window.getContentPane();
            c.add(panel);
            window.setVisible(true);
    }
}