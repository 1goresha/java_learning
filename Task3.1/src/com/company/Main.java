package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Number[] numbers = new Number[]{0, 1, 2, 3, 4};
        MathBox<Integer> mathBox = new MathBox(numbers);
        mathBox.splitter(2);
        mathBox.deleteObject(0);
        for (Object n:mathBox.getList()
             ) {
            System.out.println(n);
        }

        ObjectBox o = new ObjectBox();
        o.addObject(new MathBox(new Number[]{0, 1, 2}));
        o.addObject(new MathBox(new Number[]{3,4,5}));
        o.addObject(new MathBox(new Number[]{6,7,8}));
        o.deleteObject(0);

        System.out.println(o.dump());
    }
}
