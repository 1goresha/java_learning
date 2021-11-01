package com.company.vehicles;

import com.company.beeps.Beep;
import com.company.energytypes.Energy;
import com.company.engines.Engine;
import com.company.features.Cargo;
import com.company.features.Flying;
import com.company.features.PutPassengers;
import com.company.features.Weapon;
import com.company.transmission.Transmission;

public class Car extends Vehicle implements Weapon, Flying, PutPassengers, Cargo {

    public Car(int speed, int weight, int price, byte numberOfPassengers, String color, String name, float cargo, Engine engine, Beep beep, Transmission transmission) {
        super(speed, weight, price, numberOfPassengers, color, name, cargo, engine, beep, transmission);
    }

    @Override
    public void startTheEngine() {

        engine.startEngine();
    }

    @Override
    public void stopTheEngine() {

        engine.stopEngine();
    }

    @Override
    public void move() {

        System.out.println("here are we go...");
    }

    @Override
    public void makeBeep() {

        beep.makeSound();
    }

    @Override
    public void fly() {

        System.out.println("my car can fly....");
    }

    @Override
    public void shoot() {

        System.out.println("пиу пиу пиу");
    }

    @Override
    public byte letIn(byte count) {
        return numberOfPassengers += count;
    }

    @Override
    public byte letOut(byte count) {
        return numberOfPassengers -= count;
    }

    @Override
    public float upLoad(float carg) {
        return cargo += carg;
    }

    @Override
    public float unLoad(float carg) {
        return cargo -= carg;
    }
}
