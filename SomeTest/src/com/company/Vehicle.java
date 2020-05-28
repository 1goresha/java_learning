package com.company;

public abstract class Vehicle {

    String model;
    int weight;
    int coast;
    int horsePower;

    public String aboutThisVehicle(){
        return this.toString();
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", weight=" + weight +
                ", coast=" + coast +
                ", horsePower=" + horsePower +
                '}';
    }
}
