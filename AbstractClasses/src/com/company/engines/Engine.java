package com.company.engines;

import com.company.energytypes.Energy;

public abstract class Engine {

    Energy energy;

    public Engine(Energy energy) {

        this.energy = energy;
    }

    public abstract void aboutEngine();
    public abstract void startEngine();
    public abstract void stopEngine();

}
