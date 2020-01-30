package com.company;

public class MilitaryGroundVehicle extends GroundVehicle implements Shootable {
    public MilitaryGroundVehicle(String name, int weight) {
        super(name, weight);
    }

    @Override
    public void go(){
        System.out.println("this military groundVehicle can go on the ground");
    }

    @Override
    public void shoot() {
        System.out.println("piu piu on the ground");
    }
}
