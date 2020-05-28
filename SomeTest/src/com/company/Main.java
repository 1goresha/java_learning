package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        CarStore<SimpleCar> carStore = new CarStore<>();
        carStore.addNewVehicle(new SimpleCar("lada", 1100, 500000, 90));
        carStore.addNewVehicle(new SimpleCar("skoda", 1200, 800000, 100));
        carStore.addNewVehicle(new SimpleCar("kia", 1200, 900000, 110));

        CarStore<Animal> carStore1 = new CarStore<>();
        carStore1.addNewVehicle(new Cat("Pushok", 5));
        carStore1.addNewVehicle(new Cat("Barsik", 7));
        carStore1.addNewVehicle(new Cat("Pirojok", 3));

        carStore.getVehicleStore().forEach(System.out::println);
        carStore1.getVehicleStore().forEach(System.out::println);
    }

}
