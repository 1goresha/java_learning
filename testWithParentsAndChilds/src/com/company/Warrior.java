package com.company;

public class Warrior {
    private int power = 1;

    public int getPower() {
        return power;
    }

    public void saySomething(){
        System.out.println("i am warrior and my power = " + getPower());
    }

    public void sayOnlyAboutWarrior(){
        System.out.println("PS : warrior have just power = " + this.power);
    }
}
