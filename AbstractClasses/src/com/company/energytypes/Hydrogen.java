package com.company.energytypes;

public class Hydrogen implements Energy {

//    public Hydrogen(String name, int price, String state, byte efficiency) {
//        super(name, price, state, efficiency);
//    }

    @Override
    public String aboutEnergySource() {

        return "it is hydrogen and it has crazy efficiency, your car can blow up, be careful";
    }

    @Override
    public String processing() {

        return "dripping water sound";//звуки капающей воды
    }

    @Override
    public String stopProcessing() {
        return "звуки капающей воды";
    }
}
