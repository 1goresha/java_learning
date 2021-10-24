package com.company;

import java.util.Collection;
import java.util.List;

public interface MyCollection<E> extends MyIterable<E>{


    MyIterator<E> myIterator();

    boolean add(E e);
    boolean remove(E e);
    void clear();
    int size();
}
