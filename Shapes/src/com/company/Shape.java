package com.company;

public abstract class Shape {//абстрактный класс, не возможно создать объект, но возможно создать объектную переменную Shape circle = new Circle();
    private int x;
    private int y;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract double calcPerimeter();//абстрактный класс не требует реализации.
    //если в классе есть абстрактный класс, то этот класс должен быть тоже абстрактным!
    //все классы, которые наследуют абстрактный класс с абстрактными методами, должны реализовать эти методы

    public abstract double calcArea();
}
