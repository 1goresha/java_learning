package com.company;

import java.util.ArrayList;
import java.util.List;

public class NotMain<T> {
    public T a;

    public static <T> T getElementInList(int index, List<? super T> list){
        return (T)list.get(index);
    }

    public static void main(String[] args) {
        // write your code here
        List<? super Integer> numberList = new ArrayList<Number>();
        numberList.add(10);
        numberList.add(10);
        numberList.add(10);
        numberList.add(10);
//        numberList.forEach(System.out::println);
//        System.out.println(numberList.get(0));
        System.out.println(getElementInList(0, numberList));
    }
}
