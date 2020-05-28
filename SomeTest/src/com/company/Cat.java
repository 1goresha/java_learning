package com.company;

public class Cat extends Animal {

    public Cat(String name, int weight) {
        super.name = name;
        super.weight = weight;
    }

    @Override
    public String makeSomeNoise() {
        return "may may may";
    }
}
