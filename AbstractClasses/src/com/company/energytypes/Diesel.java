package com.company.energytypes;

public class Diesel implements Energy {
    @Override
    public String aboutEnergySource() {

        return "this energy pollutes the environment, but almost all vehicles uses this kind of energy";
    }

    @Override
    public String processing() {

        return "брым брым брым брым";
    }

    @Override
    public String stopProcessing() {

        return "тырых тырых тырых";
    }

//    public Diesel(String name, int price,  String state, byte efficiency) {
//        super(name, price, state, efficiency);
//    }
}
