package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Point point = new Point(1, 1, 1);
        Box box = new Box(1, 1, 1, 1, 1, 1);
        Sphere sphere = new Sphere(1, 1, 1, 3);

        point.move(1,1,1);
        box.scale(0.2);
        box.move(1,1,1);

        Figure[] figures = {point, box, sphere};
        Scalable[] scalables = {box, sphere};

        SpaceOperations.moveAll(figures, 2,2,2 );
        SpaceOperations.scaleAll(scalables, 2);
    }
}
