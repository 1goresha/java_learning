package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
	// write your code here
    MyScanner myScanner = new MyScanner("input_1.txt");
        System.out.println(myScanner.nextInt());
    }
}
