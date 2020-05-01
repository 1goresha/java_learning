package com.company;

public abstract class Figure {
    private int x;
    private int y;
    private int z;

    public Figure(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void move(int x, int y, int z){
        this.x += x;
        this.y += y;
        this.z += z;
    }

}
