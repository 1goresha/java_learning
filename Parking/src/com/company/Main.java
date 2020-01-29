package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GroundVehicle car = new GroundVehicle("lada", 1000, "о018кр" , false);
        GroundVehicle tank = new GroundVehicle("armata" , 30000, "o000oo", true);
        AirVehicle boeing = new AirVehicle("Боинг", 50000, "j111jj", false);
        AirVehicle mi24 = new AirVehicle("МИ24", 20000, "h222hh", true);
        GroundVehicle bicycle = new GroundVehicle("школьник", 10, "y999yy", false);

        car.go(5);
        car.go(10);

        mi24.go(100);
        mi24.go(200);

        mi24.shoot();
        car.shoot();

        Parking.parkIn(car);
        Parking.parkIn(tank);
        Parking.parkIn(boeing);
        Parking.parkIn(mi24);
        Parking.parkIn(bicycle);

        Parking.parkOut(tank);
        Parking.parkOut(tank);
    }
}
