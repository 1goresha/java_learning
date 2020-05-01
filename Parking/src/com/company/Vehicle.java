package com.company;

public abstract class Vehicle {
    protected String name;
    protected int weight;
    protected String gosNumber;
    protected int km;
    protected boolean canShoot;


    public Vehicle(String name, int weight, String gosNumber, boolean canShoot){
        this.name = name;
        this.weight = weight;
        this.gosNumber = gosNumber;
        this.canShoot = canShoot;
        this.km = 0;
    }

    public abstract void go(int km);


}
