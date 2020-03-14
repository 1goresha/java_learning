package com.company.jenericArrayList;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.concurrent.LinkedTransferQueue;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    public T value;
    private Node<T> next;

    public Node(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<T> node = (Node<T>) o;
        return value == node.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }


    @Override
    public int compareTo(Node<T> o) {
        return this.value.compareTo(o.value) ;
    }

}
