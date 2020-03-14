package com.company.jenericArrayList;

public interface List <V>{
    void add(V element);
    void addToBegin(V element);
    V get(int index);
    void insert(V element, int index);
    void reverse();
    int getSize();
    <T extends Comparable<T>> void sort();
    boolean contains(V element);
    int indexOf(V element);
}
