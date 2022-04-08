package com.company;

public class HanoiTower {
    private Peg peg1;
    private Peg peg2;
    private Peg peg3;
    private int numDiscs;

    public HanoiTower(int num)
    {
        peg1 = new Peg(1, num);
        peg2 = new Peg(2, num);
        peg3 = new Peg(3, num);
        for(int i = num; i > 0; i--) {
            peg1.addDisc(i);
            System.out.println("placed disc " + i + " on " + peg1);
        }
        numDiscs = num;
    }
    public void solveTower()
    {
        moveTower(peg1, peg3, peg2, numDiscs);
    }

    private void moveTower(Peg startPeg, Peg endPeg, Peg extraPeg, int numtoMove)
    {
        if(numtoMove == 1){
            startPeg.moveTopDisc(endPeg);
        }
        else{
            moveTower(startPeg, extraPeg, endPeg, numtoMove -1);
            startPeg.moveTopDisc(endPeg);
            moveTower(extraPeg,endPeg,startPeg,numtoMove-1);
        }
    }
    public static void main(String[] args) {
        HanoiTower ht = new HanoiTower(5);
        ht.solveTower();
    }

}