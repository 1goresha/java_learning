package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code  here
//        SomeClass someClass = new SomeClass();
//        someClass.setSomeMessage("hello from object");
//        System.out.println(SomeClass.someMessage);
//        SomeClass.setStaticSomeMessage("hello form static class");
//        System.out.println(SomeClass.someMessage);

        Singleton singleton1 = Singleton.getSingletonObjectVariable();
        Singleton singleton2 = Singleton.getSingletonObjectVariable();

        singleton1.setLog("hello from singleton1");
        System.out.println(singleton1.getLog());
        int a = 1;

        singleton2.setLog("hello from singleton2");
        System.out.println(singleton2.getLog());
        System.out.println(singleton1.getLog());
        int b = 0;
    }
}
