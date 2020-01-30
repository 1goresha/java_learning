package com.company;

public class AirCraft extends Vehicle implements Flyeble {

    public AirCraft(String name, int weight) {
        super(name, weight);
    }


    @Override
    public void go() {
        fly();
    }

    @Override
    public void fly() {
        System.out.println("this peaceful vehicle can fly");
    }
}
