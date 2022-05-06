package com.company;

import com.sun.security.jgss.GSSUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Perlin {

    private int[] line;

    public Perlin(){
        line = new int[12];
        line[0] = 0;
        for(int j = 1; j<12; j++){
            line[j] = (int) (Math.random()*11);
        }
        line[11] = 0;
    }

    public void perl(){
        for(int i = 1; i<11; i++){
            if(line[i] == 0 || line[i] == 10){
                line[i] = line[i];
            }
            else {
                line[i] = (line[i - 1] + line[i] + line[i + 1]) / 3;
            }
        }
        System.out.println(Arrays.toString(line));
    }






    public static void main(String[] args)
    {
        Perlin p =  new Perlin();
        System.out.println(Arrays.toString(p.line));

        for(int j = 1; j<12; j++){
            p.perl();
        }
    }
}
