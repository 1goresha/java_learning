package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        try{
            FileProperties fileProperties = new FileProperties();
            System.out.println(fileProperties.getAbsolute("input_1.txt"));
            System.out.println(fileProperties.getAbsolute("output.txt"));
        }catch(FileNotFoundException e){
            System.out.println("все плохо");
            throw new IllegalArgumentException(e);
        }
    }
}
