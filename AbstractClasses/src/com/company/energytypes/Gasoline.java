package com.company.energytypes;

public class Gasoline implements Energy {

//    public Gasoline(String name, int price, String state, byte efficiency) {
//        super(name, price, state, efficiency);
//    }

    @Override
    public String aboutEnergySource() {

        return "this kind of energy is like diesel";
    }

    @Override
    public String processing() {

        return "brrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr";
    }

    @Override
    public String stopProcessing() {

        return "тырых";
    }
}
