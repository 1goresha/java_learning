package com.company;

public class SimpleCar extends Vehicle {

    public SimpleCar(String model, int weight, int coast, int horsePower) {
        super.model = model;
        super.weight = weight;
        super.coast = coast;
        super.horsePower = horsePower;
    }

    @Override
    public String aboutThisVehicle() {
        return super.aboutThisVehicle();
    }

}
