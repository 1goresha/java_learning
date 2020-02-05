package com.company;

public class Main {

    public static void mathOperation(int a, int b){
        System.out.println(a / b);
    }

    public static void main(String[] args) {
	// write your code here
        SimpleClass.saySomethingInStatic();

        SimpleClass simpleClass = new SimpleClass();
        simpleClass.saySomethingInNotStatic();

        try{
            mathOperation(5, 0);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
