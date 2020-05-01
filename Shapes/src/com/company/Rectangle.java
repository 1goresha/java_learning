package com.company;

public class Rectangle extends Shape{

    private int a;
    private int b;

    public Rectangle(int x, int y, int a, int b) {
        super(x,y);
        this.a = a;
        this.b = b;
    }


    @Override
    public double calcPerimeter() {
        return 2*(a + b);
    }

    @Override
    public double calcArea() {
        return 0;
    }
}
