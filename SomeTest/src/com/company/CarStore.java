package com.company;

import java.util.ArrayList;
import java.util.List;

public class CarStore<T extends Vehicle> {

    private List<? super T> vehicleStore = new ArrayList<>();//Указываем <? super T> для того чтобы можно было не толко читать,
                                                             //но и записывать. Если укажем <? extends T> то сможем только прочитать.

    public void addNewVehicle(T vehicle){
        vehicleStore.add(vehicle);
    }

    public T getVehicle(int index){
        return (T)vehicleStore.get(index);
    }

    public List<? super T> getVehicleStore(){
        return this.vehicleStore;
    }

}
