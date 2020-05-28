package com.company;

public class Dog extends Animal {

    public Dog(String name, int weight) {
        super.name = name;
        super.weight = weight;
    }

    @Override
    public String makeSomeNoise() {
        return "gav gav gav";
    }

}
