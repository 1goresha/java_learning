package com.company;

public class ArcherWarrior extends Warrior {

    private int archerIndexOfPower = 2;

    public int getPower(){
        return super.getPower() * archerIndexOfPower;
    }

    public void saySomething(){
        System.out.println("i am archerWarrior and my power = " + getPower());
    }

    public void sayOnlyAboutArcherWarrior(){
        System.out.println("PS : archerWarrior have just power = " + getPower());
    }
}
