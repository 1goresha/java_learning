package com.company;

public class ParkingPlace {
    private String gosNumber;
    private Vehicle vehicle;

    public ParkingPlace(){
        this.gosNumber = "";
        this.vehicle = null;
    }

    public String getGosNumber() {
        return gosNumber;
    }

    public void setGosNumber(String gosNumber) {
        this.gosNumber = gosNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
