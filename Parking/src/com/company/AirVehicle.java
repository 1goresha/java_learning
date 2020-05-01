package com.company;

public class AirVehicle extends Vehicle implements Flyeble, Shootable {


    public AirVehicle(String name, int weight, String gosNumber, boolean canShoot) {
        super(name, weight, gosNumber, canShoot);
    }

    @Override
    public int fly(int km) {
        return this.km +=km;
    }

    @Override
    public void go(int km){
        System.out.println(fly(km));
    }

    @Override
    public void shoot() {
        if (this.canShoot){
            System.out.println("Пиу - Пиу");
            return;
        }
        System.out.println("Не могу стрелять, нет такой возможности");
    }
}
