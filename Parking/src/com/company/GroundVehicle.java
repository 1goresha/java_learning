package com.company;

public class GroundVehicle extends Vehicle implements Rideble, Shootable {

    public GroundVehicle(String name, int weight, String gosNumber, boolean canShoot) {
        super(name, weight, gosNumber, canShoot);
    }


    @Override
    public int ride(int km) {
        return this.km += km;
    }

    @Override
    public void go(int km) {
        System.out.println(ride(km));
    }

    @Override
    public void shoot() {
        if (this.canShoot) {
            System.out.println("Пиу - Пиу");
            return;
        }
        System.out.println("Не могу стрелять, нет такой возможности");
    }
}
