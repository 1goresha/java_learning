package com.company.jenericArrayList;

import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkedList<Integer> stringLinkedList = new LinkedList<>();
        stringLinkedList.add(3);
        stringLinkedList.add(1);
        stringLinkedList.add(4);
        stringLinkedList.add(2);
        stringLinkedList.add(5);
        Comparator<Node<Integer>> comparator = new ByValueNodeComparator<>();
        stringLinkedList.sort(comparator);
        stringLinkedList.reverse();
        int a = 0;
    }
}
