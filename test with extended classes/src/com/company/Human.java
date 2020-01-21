package com.company;

public class Human {
    private String name;
    private int age;
    protected int distance;

    public Human(String name, int age){
        this.name = name;
        this.age = age;
        this.distance = 0;
    }

    public int go(int distance){
        return this.distance += distance;
    }

    public void say(){
        System.out.println("i can go!!!");
    }
}
