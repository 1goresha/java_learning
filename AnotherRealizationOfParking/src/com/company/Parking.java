package com.company;

public class Parking {
    private ParkingPlace[] parkingPlaces;

    public Parking() {
        this.parkingPlaces = new ParkingPlace[5];
//        for (ParkingPlace parkingPlace :
//                parkingPlaces) {
//            parkingPlace = new ParkingPlace();
//            parkingPlace.setVehicle(null);
//            parkingPlace.setGosNumber("");
//        }
        for (int i = 0; i < parkingPlaces.length; i ++){
            parkingPlaces[i] = new ParkingPlace();
        }
    }

    public void park(Vehicle vehicle) {
        for (ParkingPlace parkingPlace :
                parkingPlaces) {
            if (parkingPlace.getGosNumber().equals("")) {
                parkingPlace.setGosNumber(vehicle.gosNumber);
                parkingPlace.setVehicle(vehicle);
            }
            System.out.println(vehicle.name + " припарковался");
            return;
        }


//        for (int i = 0; i < parkingPlaces.length - 1; i++) {
//            if (parkingPlaces[i].getGosNumber().equals("")) {
//                parkingPlaces[i].setGosNumber(vehicle.gosNumber);
//                parkingPlaces[i].setVehicle(vehicle);
//                return;
//            }
//        }
    }

    public void unPark(String gosNumber) {
        String tempVehicleName;
        String tempVehicleGosNumber;
        for (ParkingPlace parkingPlace :
                parkingPlaces) {
            if (parkingPlace.getGosNumber().equals(gosNumber)) {
                tempVehicleName = parkingPlace.getVehicle().getName();
                tempVehicleGosNumber = parkingPlace.getGosNumber();
                parkingPlace.setGosNumber(null);
                parkingPlace.setVehicle(null);
                System.out.println(tempVehicleName + " с гос номером " + tempVehicleGosNumber + " выезжает с парковки");
            }
            return;
        }
    }
}
