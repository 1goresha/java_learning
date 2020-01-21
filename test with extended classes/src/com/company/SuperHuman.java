package com.company;

public class SuperHuman extends Human {
    private String superAbility;

    public SuperHuman(String name, int age, String superAbility){
        super(name, age);
        this.superAbility = superAbility;
    }

    public int fly(int distance){
        return this.distance += distance;
    }

    public int go(int distance){
        return this.distance += distance + 100;
    }

    public void say(){
        System.out.println("ha ha ha, i can " + this.superAbility + "!!!");
    }
}
