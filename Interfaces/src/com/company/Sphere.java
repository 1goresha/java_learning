package com.company;

public class Sphere extends Figure implements Scalable{
    private int radius;


    public Sphere(int x, int y, int z, int radius) {
        super(x, y, z);
        this.radius = radius;
    }


    @Override
    public void scale(double size) {
        this.radius *= size;
    }
}
