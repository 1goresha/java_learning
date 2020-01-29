package com.company;

public class Box extends Figure implements Scalable{
    private int length;
    private int height;
    private int width;


    public Box(int x, int y, int z, int length, int height, int width) {
        super(x, y, z);
        this.length = length;
        this.height = height;
        this.width = width;
    }


    @Override
    public void scale(double size) {
        this.length *= size;
        this.height *= size;
        this.width *= size;
    }
}
