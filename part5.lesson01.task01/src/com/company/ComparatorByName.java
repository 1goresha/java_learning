package com.company;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        String petName1 = o1.getName();
        String petName2 = o1.getName();
        return petName1.compareTo(petName2);
    }
}
