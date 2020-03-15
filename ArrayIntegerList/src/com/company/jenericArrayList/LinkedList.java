package com.company.jenericArrayList;

import java.util.Comparator;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node top;
    private Node tail;
    private int count;

    public LinkedList() {
        this.count = 0;
    }

    private Node getPrevious(Node n) {
        Node current = top;
        Node previous = null;
        for (int i = 1; i <= this.count; i++) {
            previous = current;
            current = current.getNext();
            if (n == top) return top;
            if (n == current) return previous;
        }
        return previous;
    }

    private void swap(Node a, Node b) {
        Node previousA = this.getPrevious(a);
        Node previousB = this.getPrevious(b);
        Node nextA = a.getNext();
        Node nextB = b.getNext();

        if (a == top && b == a.getNext()) {
            a.setNext(nextB);
            b.setNext(a);
            top = b;
            return;
        }

        if (b == a.getNext()) {
            previousA.setNext(b);
            b.setNext(a);
            a.setNext(nextB);
            return;
        }

        if (a == top) {
            b.setNext(nextA);
            previousB.setNext(a);
            a.setNext(nextB);
            top = b;
            if (b == tail) tail = a;
            return;
        }
        if (b == top) {
            a.setNext(nextB);
            previousA.setNext(b);
            b.setNext(nextA);
            top = a;
            if (a == tail) tail = b;
            return;
        }

        previousA.setNext(b);
        b.setNext(nextA);
        previousB.setNext(a);
        a.setNext(nextB);


    }

    private Node getNode(int index) {
        Node current = top;
        int thisCount = 1;
        while (thisCount <= this.count) {
            if (thisCount == index) return current;
            current = current.getNext();
            thisCount++;
        }
        return null;
    }

    @Override
    public void add(T value) {
        Node<T> node = new Node<T>(value);
        if (tail != null) {
            tail.setNext(node);
            tail = node;
            count++;
        } else {
            top = node;
            tail = node;
            count++;
        }
    }

    @Override
    public void addToBegin(T value) {
        Node<T> node = new Node<T>(value);
        node.setNext(top);
        count++;
        if (top == null) tail = node;
        top = node;
    }

    @Override
    public T get(int index) {
        Node current = top;
        int thisCount = 1;
        while (thisCount != this.count) {
            if (thisCount == index) return (T) current.getValue();
            current = current.getNext();
            thisCount++;
        }
        return null;
    }

    @Override
    public void insert(T element, int index) {
        Node<T> node = new Node<T>(element);
        Node current = top;
        Node currentNext;
        int thisCount = 1;
        if (index > this.count) {
            System.out.println("запрос за пределом массива");
            return;
        }
        while (thisCount != this.count) {
            if (thisCount == index - 1) {
                currentNext = current.getNext();
                current.setNext(node);
                node.setNext(currentNext);
                return;
            }
            current = current.getNext();
            thisCount++;
        }
    }

    @Override
    public void reverse() {
        Node current = tail;
        Node previous;
        for (int i = 1; i <= this.count; i++) {
            previous = this.getPrevious(current);
            current.setNext(previous);
            current = previous;
        }
        top = tail;
        current.setNext(null);
        tail = current;
    }

    @Override
    public int getSize() {
        return this.count;
    }

    private void sort0(Comparator<Node<T>> comparator){             //сделал ненужные новороты, без которых и так все прекрасно работает :)
        Node current;
        Node previous;
        if (comparator == null){
            for (int i = 1; i <= this.count; i++) {
                current = top;
                for (int j = i; j <= this.count; j++) {
                    previous = this.getPrevious(current);
//                previous = current;//обновим указатель на предыдущий Node
                    if (previous.compareTo(current) > 0) {
                        this.swap(previous, current);
                        current = previous;//обновим указатель текущего Node
                    }
                    current = current.getNext();//а здесь из обновленного текущего Node заберем следущий тукущий Node после иттерации
                }
            }
        }else{
            for (int i = 1; i <= this.count; i++) {
                current = top;
                for (int j = i; j <= this.count; j++) {
                    previous = this.getPrevious(current);
                    if (comparator.compare(current,previous) < 0) {
                        this.swap(previous, current);
                        current = previous;//обновим указатель текущего Node
                    }
                    current = current.getNext();//а здесь из обновленного текущего Node заберем следущий тукущий Node после иттерации
                }
            }
        }
    }

        @Override
    public void sort() {
        sort0(null);
    }


    public void sort(Comparator<Node<T>> comparator) {
        sort0(comparator);
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
//        Node current = top;
//        for (int i = 1; i <= this.count; i++) {
//            if (current.getValue() == element) return true;
//            current = current.getNext();
//        }
//        return false;
    }

    @Override
    public int indexOf(T element) {
        Node current = top;
        for (int i = 1; i <= this.count; i++) {
            if (current.getValue() == element) return i;
            current = current.getNext();
        }
        return -1;
    }

}
