package com.company;

public class GroundVehicle extends Vehicle {
    public GroundVehicle(String name, int weight) {
        super(name, weight);

    }

    @Override
    public void go() {
        System.out.println("this peaceful vehicle can go in the ground");
    }
}
