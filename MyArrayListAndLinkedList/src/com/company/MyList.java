package com.company;

public interface MyList<E> extends MyCollection<E>{

    MyIterator<E> myIterator();

    boolean add(E e);
    boolean remove(E e);
    void clear();
    int size();
    E get(int index);
    E set(int index, E element);
}
