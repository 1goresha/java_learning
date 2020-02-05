package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Parking parking = new Parking();
        AirVehicle mi24 = new AirVehicle("111", "ми 24");
        GroundVehicle armata = new GroundVehicle("222", "Армата");

        parking.park(mi24);
        parking.park(armata);
    }
}
