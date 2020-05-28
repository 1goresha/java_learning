package com.company;

import java.util.Comparator;

public class ComparatorByWeight implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        double petWeight1 = o1.getWeight();
        double petWeight2 = o2.getWeight();
        return Double.compare(petWeight1, petWeight2);
    }
}
