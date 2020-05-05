package com.company;

public class MagicWarrior extends Warrior {

    private int magicIndexOfPower = 3;

    public int getPower() {
        return super.getPower() * magicIndexOfPower;
    }

    public void saySomething(){
        System.out.println("i am magicWarrior and my power = " + getPower());
    }

    public void sayOnlyAboutMagicWarrior(){
        System.out.println("PS : magicWarrior have just power = " + getPower());
    }
}
