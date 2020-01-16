package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int[] intArray = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i <= intArray.length - 1; i++) {
            intArray[i] = scanner.nextInt();
        }

        int min = intArray[0];
        for (int i = 0; i <= intArray.length - 1; i++) {
            if (min >= intArray[i]){
                min = intArray[i];
            }
        }

        int max = intArray[intArray.length - 1];
        for (int i = 0; i <= intArray.length - 1; i++){
            if (max <= intArray[i]){
                max = intArray[i];
            }
        }

        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }
}
