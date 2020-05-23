package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        for (int i = 0 ; i < arrayList.size(); i ++){
            arrayList.add(i);
        }

//        ArrayList.ArrayListIterator arrayListIterator = arrayList.new ArrayListIterator();
        ArrayList.ArrayListIterator arrayListIterator = arrayList.getArrayListIterator();
//        Iterator iterator = arrayListIterator.iterator();
        for (Object a :
                arrayListIterator) {
            System.out.println(a);
        }
    }
}
