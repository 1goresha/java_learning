package com.company;

public class Triangle extends Shape{
    private int a;
    private int b;
    private int c;

    public Triangle(int x, int y, int a, int b, int c) {
        super(x,y);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calcPerimeter() {
        return a + b + c;
    }

    @Override
    public double calcArea() {
        return 0;
    }
}
