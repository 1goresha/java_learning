package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Human igor = new Human("Игорь", 30);
        Human igor2;
        Human neIgor = new Human("Не Игорь", 99);

        igor2 = igor;

        System.out.println(igor.getAge());
        igor.setAge(100);
        System.out.println(igor.getAge());
        System.out.println(igor2.getAge());
        System.out.println(neIgor.getAge());
    }
}
