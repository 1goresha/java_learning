package com.company.simpleArrayList;

public interface IntegerList {
    void add(int element);
    void addToBegin(int element);
    int get(int index);
    void insert(int element, int index);
    void reverse();
    int getSize();
    void sort();
    boolean contains(int element);
    int indexOf(int element);
}
