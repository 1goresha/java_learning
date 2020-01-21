package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Human simpleHuman = new Human("простой чувак", 30);
        Human superHuman = new SuperHuman("супер мэн", 30, "fly");
        SuperHuman realSuperHuman = new SuperHuman("реальный супер мэн", 30, "i can really fly, mother fucka");

        simpleHuman.say();
        superHuman.say();
        realSuperHuman.say();
        System.out.println(realSuperHuman.fly(100));
    }
}
