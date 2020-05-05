package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
        MagicWarrior magicWarrior = new MagicWarrior();
        ArcherWarrior archerWarrior = new ArcherWarrior();

        Warrior warrior1 = new MagicWarrior();
        Warrior warrior2 = new ArcherWarrior();

        ArrayList<MagicWarrior> magicWarriors = new ArrayList<>();
        ArrayList<ArcherWarrior> archerWarriors = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            magicWarriors.add(new MagicWarrior());
        }

        for (int i = 0; i < 10; i++) {
            archerWarriors.add(new ArcherWarrior());
        }

        WarriorManager.fight(magicWarrior, archerWarrior);
//        WarriorManager.fight(magicWarriors, archerWarriors);

//        for (Warrior w :
//                magicWarriors) {
//            w.saySomething();
//        }
//
//        for (Warrior w :
//                archerWarriors) {
//            w.saySomething();
//        }

        magicWarrior.saySomething();
        archerWarrior.saySomething();

        System.out.println();

        magicWarrior.sayOnlyAboutMagicWarrior();
        archerWarrior.sayOnlyAboutArcherWarrior();

        System.out.println();

        warrior1.sayOnlyAboutWarrior();
        warrior2.sayOnlyAboutWarrior();


    }
}
