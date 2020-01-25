package com.company;

public class Ellipse extends Shape{
    private double r1;
    private double r2;
    public Ellipse(int x, int y, double r1, double r2){
        super(x, y);
        this.r1 = r1;
        this.r2 = r2;
    }


    @Override
    public double calcPerimeter() {
        return 2 * Math.PI * Math.sqrt((r1 * r1 + r2 * r2) / 2);
    }

    @Override
    public double calcArea() {
        return 0;
    }
}
