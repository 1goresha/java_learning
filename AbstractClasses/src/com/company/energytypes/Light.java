package com.company.energytypes;

public class Light implements Energy{

    @Override
    public String aboutEnergySource() {

        return "it is more powerful king of energy";
    }

    @Override
    public String processing() {

        return "вжуууууууууууууууууууууух";
    }

    @Override
    public String stopProcessing() {

        return "звуки тишины";
    }
}
