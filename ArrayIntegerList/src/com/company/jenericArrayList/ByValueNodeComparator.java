package com.company.jenericArrayList;

import java.util.Comparator;

public class ByValueNodeComparator<T extends Comparable<T>> implements Comparator<Node<T>> {
    @Override
    public int compare(Node<T> o1, Node<T> o2) {
        return o1.value.compareTo(o2.value);
    }

}
