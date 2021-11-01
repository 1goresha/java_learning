package com.company.engines;

import com.company.energytypes.Energy;

public class ElectroEngine extends Engine{

    public ElectroEngine(Energy energy) {
        super(energy);
    }

    @Override
    public void aboutEngine() {

        System.out.println(energy.aboutEnergySource());
    }

    @Override
    public void startEngine() {

        System.out.println(energy.processing());
    }

    @Override
    public void stopEngine() {

//        System.out.println("-----------silence----------");
        System.out.println(energy.stopProcessing());

    }
}
