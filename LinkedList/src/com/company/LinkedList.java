package com.company;

public class LinkedList {
    private Node top;
    private Node tail;

    public void addToBegin(int value) {
        Node node = new Node(value);
        if (top == null) tail = node;
        node.setNext(top);
        top = node;
    }

    public void add(int value) {
        Node node = new Node(value);
//        Node current = this.top;
//        while (current.getNext() != null) {
//            current = current.getNext();
//        }
        if (tail == null) {
            top = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }
}
