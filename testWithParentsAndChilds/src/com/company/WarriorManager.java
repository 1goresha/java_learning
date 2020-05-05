package com.company;

import java.util.List;

public class WarriorManager {

    public static boolean fight(Warrior w1, Warrior w2) {
        return w1.getPower() < w2.getPower();
    }

    public static boolean fight(List<Warrior> warriors1, List<Warrior> warriors2) {
        int sumOfPower1 = 0;
        int sumOfPower2 = 0;

        for (Warrior w :
                warriors1) {
            sumOfPower1 += w.getPower();
        }

        for (Warrior w :
                warriors2) {
            sumOfPower2 += w.getPower();
        }

        return sumOfPower1 > sumOfPower2;
    }
}
