package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
//        ArrayIntegerList arrayIntegerList = new ArrayIntegerList(6);
//        arrayIntegerList.addToBegin(4);
//        arrayIntegerList.addToBegin(1);
//        arrayIntegerList.addToBegin(5);
//        arrayIntegerList.addToBegin(2);
//        arrayIntegerList.addToBegin(6);
//        arrayIntegerList.addToBegin(3);
//        arrayIntegerList.reverse();
//        arrayIntegerList.sort();
//        int i = 0;

        LinkedIntegerList linkedIntegerList = new LinkedIntegerList();
        linkedIntegerList.add(1);
        linkedIntegerList.add(2);
        linkedIntegerList.add(3);
        linkedIntegerList.add(4);
        linkedIntegerList.add(5);
//        int a = linkedIntegerList.get(2);
//        linkedIntegerList.insert(6,2);
//        boolean b = linkedIntegerList.contains(3);
//        int c = linkedIntegerList.indexOf(6);
        linkedIntegerList.reverse();
        Node a = linkedIntegerList.getNode(linkedIntegerList.indexOf(4));
        Node b = linkedIntegerList.getNode(linkedIntegerList.indexOf(3));
//        linkedIntegerList.swap(a,b);
        linkedIntegerList.sort();
        int i = 0;
    }
}
