package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(5);
        int a = 5;

//        arrayList.add(1);
//        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.addToTheBegin(5);
        arrayList.addToTheBegin(6);
        arrayList.deleteDigitByIndex(1);
        arrayList.insert(9,3);
        arrayList.sort();
        arrayList.reverse();
        int i = 0;
    }
}
