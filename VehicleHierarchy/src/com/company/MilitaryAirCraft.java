package com.company;

public class MilitaryAirCraft extends AirCraft implements Shootable {

    public MilitaryAirCraft(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void go(){
        fly();
    }

    @Override
    public void shoot() {
        System.out.println("piu piu in the air");
    }

    @Override
    public void fly(){
        System.out.println("this military aircraft can fly");
    }
}
