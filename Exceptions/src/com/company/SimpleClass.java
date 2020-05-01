package com.company;

public class SimpleClass {
    private int a;
    public static int b;

    public void saySomethingInNotStatic(){
        System.out.println("not static");
    }

    public static void saySomethingInStatic(){
        System.out.println("static");
    }

}
