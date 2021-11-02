package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        for (byte i = 1; i <= 10; i++) {

            for (byte j = 1; j <= 10; j++) {

                byte result = (byte) (i * j);

                if (result > 9) {

                    System.out.print(j * i + "  ");

                } else {

                    System.out.print(j * i + "   ");
                }
            }

            System.out.println();
        }
    }
}
