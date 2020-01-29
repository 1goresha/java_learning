package com.company;

public class SpaceOperations {

    public static void moveAll(Figure[] figures, int x, int y, int z) {
        for (Figure figure : figures
        ) {
            figure.move(x, y, z);
        }
    }

    public static void scaleAll(Scalable[] scalables, double size){
        for (Scalable scalable : scalables
             ) {
                    scalable.scale(size);
        }
    }
}
