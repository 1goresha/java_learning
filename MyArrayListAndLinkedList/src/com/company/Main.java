package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
	// write your code here

//        MyArrayList<String> myArrayList = new MyArrayList<>();
//
//        MyIterator<String> myIterator = myArrayList.myIterator();
//
//        myArrayList.add("one");
//        myArrayList.add("two");
//        myArrayList.add("three");
//        myArrayList.add("four");
//        myArrayList.add("five");
//        myArrayList.add("six");
//        myArrayList.add("seven");
//
////        while (myIterator.hasNext()){
////
////            System.out.println(myIterator.next());
////        }
//
//
//        myArrayList.remove("one");
//        myArrayList.remove("five");
//
////        while (myIterator.hasNext()){
////
////            System.out.println(myIterator.next());
////        }
//
//        myArrayList.set(0, "ONE");
//        myArrayList.set(myArrayList.size() - 1, "SEVEN");
//
//        while (myIterator.hasNext()){
//
//            System.out.println(myIterator.next());
//        }

        MyLinkedList<String>  myLinkedList = new MyLinkedList<>();
        myLinkedList.add("1");
        myLinkedList.add("2");
        myLinkedList.add("3");
        myLinkedList.add("4");
        myLinkedList.add("5");

//        myLinkedList.clear();

//        myLinkedList.set(5, "6");
        System.out.println(myLinkedList.set(4, "6"));

        for (int i = 0; i < myLinkedList.size(); i++){

            System.out.println(myLinkedList.get(i));
        }

    }
}
