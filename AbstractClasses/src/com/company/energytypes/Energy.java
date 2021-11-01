package com.company.energytypes;

public interface Energy {

//    String name;
//    int price;
//    String state;
//    byte efficiency;
//
//    public EnergySource(String name, int price, String state, byte efficiency){
//
//        this.name = name;
//        this.price = price;
//        this.state = state;
//        this.efficiency = efficiency;
//    }

    public abstract String aboutEnergySource();
    public abstract String processing();
    public abstract String stopProcessing();
}
