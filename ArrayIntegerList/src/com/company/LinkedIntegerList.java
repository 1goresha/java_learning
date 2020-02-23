package com.company;

public class LinkedIntegerList implements IntegerList {
    private Node top;
    private Node tail;
    private int count;

    public LinkedIntegerList() {
        this.count = 0;
    }

//    public Node getPreviousNodeByIndex(int index){
//        Node current = top;
//        Node previousNode = current;
//        for (int i = 1; i <= this.count; i++){
//            previousNode = current;
//            current = current.getNext();
//            if (index == i) return previousNode;
//        }
//        return previousNode;
//    }

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

    public void swap(Node a, Node b) {
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

    public Node getNode(int index) {
        Node current = top;
        int thisCount = 1;
        while (thisCount <= this.count) {
            if (thisCount == index) return current;
            current = current.getNext();
            thisCount++;
        }
        return null;
    }

    public void add(int value) {
        Node node = new Node(value);
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

    public void addToBegin(int value) {
        Node node = new Node(value);
        node.setNext(top);
        count++;
        if (top == null) tail = node;
        top = node;
    }

    @Override
    public int get(int index) {
        Node current = top;
        int thisCount = 1;
        while (thisCount != this.count) {
            if (thisCount == index) return current.getValue();
            current = current.getNext();
            thisCount++;
        }
        return -1;
    }

    @Override
    public void insert(int element, int index) {
        Node node = new Node(element);
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

    @Override
    public void sort() {
        Node current;
        Node temp;
        Node previous;
        for (int i = 1; i <= this.count; i++) {
            current = top;
            previous = this.getPrevious(current);
            for (int j = i; j <= this.count ; j++) {
                if (previous.getValue() > current.getValue()) {
                    this.swap(previous, current);
                }
                current = previous;//обновим указатель текущего Node
                previous = current;//обновим указатель на предыдущий Node
                current = current.getNext();//а здесь из обновленного текущего Node заберем следущий тукущий Node после иттерации
            }
        }

//        Node current;
//        Node previous;
//
//        for (int i = 1; i <= this.count; i ++){
//            for (int j = i; j <=this.count; j++){
//            }
//        }

    }

    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
//        Node current = top;
//        for (int i = 1; i <= this.count; i++) {
//            if (current.getValue() == element) return true;
//            current = current.getNext();
//        }
//        return false;
    }

    @Override
    public int indexOf(int element) {
        Node current = top;
        for (int i = 1; i <= this.count; i++) {
            if (current.getValue() == element) return i;
            current = current.getNext();
        }
        return -1;
    }

}
