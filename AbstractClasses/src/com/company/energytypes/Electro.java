package com.company.energytypes;

public class Electro implements Energy {

//    public Electro(String name, int price, String state, byte efficiency) {
//        super(name, price, state, efficiency);
//    }

    @Override
     public String aboutEnergySource() {

        return "it is electro engine and it is absolutely silence engine, by the way, hello to Elon Mask";
    }

    @Override
    public String processing() {

        return "......................................";
    }

    @Override
    public String stopProcessing() {

        return ".....................";
    }
}
