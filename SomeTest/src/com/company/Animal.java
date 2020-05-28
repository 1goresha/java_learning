package com.company;

public abstract class Animal {

    String name;
    int weight;

    public String makeSomeNoise(){
        return "bla bla bla";
    }


    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
