package com.company;

public abstract class Vehicle {
    protected String gosNumber;
    protected String name;

    public Vehicle(String gosNumber, String name){
        this.gosNumber = gosNumber;
        this.name = name;
    }

    public void park(Parking parking){
        parking.park(this);
    }

    public String getName(){
        return this.name;
    }

}
