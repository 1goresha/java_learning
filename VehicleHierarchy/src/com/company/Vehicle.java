package com.company;

public abstract class Vehicle {
    protected String name;
    protected int weight;
    protected int distance;

    public Vehicle(String name, int weight){
        this.name = name;
        this.weight =weight;
        this.distance = 0;
    }

    public abstract void go();
}
