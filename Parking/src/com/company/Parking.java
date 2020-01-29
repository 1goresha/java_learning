package com.company;

public class Parking {
    private static final int MaxCountOfParkingPlace = 5;
    private static int currentCountOfParkingPlace = 0;
    private static Vehicle[] vehicles = new Vehicle[MaxCountOfParkingPlace];


    public static void parkIn(Vehicle vehicle) {
        if (currentCountOfParkingPlace > MaxCountOfParkingPlace) {
            System.out.println("больше нет мест, сорян");
            return;
        }
        vehicles[currentCountOfParkingPlace] = vehicle;
        System.out.println(vehicle.name + " с гос номером " + vehicle.gosNumber + " припарковался");
        currentCountOfParkingPlace++;
    }

    public static void parkOut(Vehicle vehicle) {
        for (int i = 0; i < vehicles.length - 1; i++) {
            if (vehicles[i] != null && vehicles[i].gosNumber.equals(vehicle.gosNumber)) {
                System.out.println(vehicles[i].name + " с гос номером " + vehicles[i].gosNumber + " отпарковался");
                vehicles[i] = null;
                return;
            }
        }
        System.out.println("такое ТС не найдено на парковке");
    }

}
