package com.company.engines;

import com.company.energytypes.Energy;

public class UnrealEngine extends Engine{

    public UnrealEngine(Energy energy) {
        super(energy);
    }

    @Override
    public void aboutEngine() {

        System.out.println("Unrealllllllllllllllll");
    }

    @Override
    public void startEngine() {

        System.out.println(energy.processing());
    }

    @Override
    public void stopEngine() {

        System.out.println(energy.stopProcessing());
    }
}
