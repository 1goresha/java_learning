package com.company;

import com.company.beeps.Music;
import com.company.energytypes.Diesel;
import com.company.engines.Engine;
import com.company.engines.V12Engine;
import com.company.transmission.FullWheelDrive;
import com.company.vehicles.Car;
import com.company.vehicles.Vehicle;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Diesel diesel = new Diesel();
        V12Engine v12Engine = new V12Engine(diesel);
        Music musicBeep = new Music();
        FullWheelDrive fullWheelDrive = new FullWheelDrive();

        Car car = new Car(240, 1500, 1500000, (byte)4, "black", "porsche",  50,  v12Engine, musicBeep, fullWheelDrive);
        car.letIn((byte) 1);
        car.upLoad((float) 123.456);
        car.startTheEngine();
        car.move();
        car.makeBeep();
        car.fly();
        car.shoot();
        car.letOut((byte) 1);
        car.unLoad((float) 123.456);
        car.stopTheEngine();
    }
}
