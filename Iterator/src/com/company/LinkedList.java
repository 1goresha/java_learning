//package com.company;
//
//public class LinkedList<T> {
//    Node<T> top;
//    Node<T> tail;
//    int count;
//
//    public LinkedList() {
//        this.count = 0;
//    }
//
//    public void add(T value) {
//        Node<T> node = new Node<>(value);
//        Node<T> current = top;
//        if (top == null) {
//            top = node;
//            tail = node;
//        } else {
//            tail.setNext(node);
//            tail = node;
//        }
//        count++;
//    }
//
//    public T get(int index) {
//        Node<T> current = top;
//        int i = 1;
//        if (index <= this.count || index > 0) {
//            while (i < index) {
//                current = current.getNext();
//                i++;
//            }
//        } else throw new IllegalArgumentException();
//        return current.getValue();
//    }
//
//    private class IteratorForLinkedList implements Iterator{
//        Node<T> node = top;
//
//        @Override
//        public boolean hasNext() {
//            if (node)
//        }
//
//        @Override
//        public int next() {
//            return 0;
//        }
//    }
//
//    public Iterator iterator(){
//
//    }
//}
