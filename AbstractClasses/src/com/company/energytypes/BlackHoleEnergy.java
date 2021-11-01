package com.company.energytypes;

public class BlackHoleEnergy implements Energy {

//    public BlackHoleEnergy(String name, int price, String state, byte efficiency) {
//        super(name, price, state, efficiency);
//    }

    @Override
    public String aboutEnergySource() {
        return "infinity energy";
    }

    @Override
    public String processing() {
        return "@#_+*&^^%$$@#$!+__**!&@&^%^!%!++_@_!^%@^!_@+_!&#&^%#^@*&@#+_#";
    }

    @Override
    public String stopProcessing() {

        return "это нельзя остановить, процесс не обратим";
    }
}
