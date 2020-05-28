package com.company;

import java.util.Comparator;

public class ComparatorByPerson implements Comparator<Pet> {
    @Override
    public int compare(Pet o1, Pet o2) {
        String person1Name = o1.getPerson().getName();
        String person2Name = o2.getPerson().getName();

//        String petName1 = o1.getName();
//        String petName2 = o2.getName();
//
//        double petWeight1 = o1.getWeight();
//        double petWeight2 = o2.getWeight();
        return person1Name.compareTo(person2Name);
    }
}
