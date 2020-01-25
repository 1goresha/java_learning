package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Shape circle = new Circle(1,1,3);
        Shape ellipse = new Ellipse(1,1,3,3);
        Shape triangle = new Triangle(1,1, 2,3,4);
        Shape square = new Square(1,1,4);
        Shape rectangle = new Rectangle(1,1, 2,3);

        Shape[] shapes = {circle, ellipse, triangle, square, rectangle};

        for (Shape shape:shapes) {
            System.out.println(shape.calcPerimeter());
        }
    }
}
