package com.company.vehicles;

import com.company.beeps.Beep;
import com.company.engines.Engine;
import com.company.transmission.Transmission;

public abstract class Vehicle {

    int speed;
    int weight;
    int price;
    byte numberOfPassengers;
    String color;
    String name;
    float cargo;

    Engine engine;
    Beep beep;
    Transmission transmission;

    public Vehicle(int speed, int weight, int price, byte numberOfPassengers, String color, String name, float cargo, Engine engine, Beep beep, Transmission transmission) {
        this.speed = speed;
        this.weight = weight;
        this.price = price;
        this.numberOfPassengers = numberOfPassengers;
        this.color = color;
        this.name = name;
        this.cargo = cargo;
        this.engine = engine;
        this.beep = beep;
        this.transmission = transmission;
    }


    abstract void startTheEngine();
    abstract void stopTheEngine();
    abstract void move();
    abstract void makeBeep();
}
