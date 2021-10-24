package com.company;

import java.util.LinkedList;

public class MyLinkedList<E> implements MyList<E>{


    int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    Node<E> last;


    @Override
    public MyIterator<E> myIterator() {
        return null;
    }

    @Override
    public boolean add(E e) {

        if (first == null){

            last = new Node<>(null, e, null);
            first = last;

        }else{

            Node<E> node = new Node<>(last, e, null);
            last.next = node;
            last = node;

        }
        size++;
        return true;

    }

    @Override
    public boolean remove(E e) {

        Node<E> node = first;

        while (node.next != null){

            if (node.item.equals(e)){

                Node<E> next = node.next;
                Node<E> prev = node.prev;

                if (prev == null){

                    next.prev = null;

                }else {

                    next.prev = prev;
                    prev.next = next;

                    node.item = null;
                    node.next = null;
                    node.prev = null;

                }
                size--;
                return true;

            }
        }

        return false;
    }

    @Override
    public void clear() {

        Node<E> node = first;

        while (node != null){

            Node<E> temp = node.next;
            node.next = null;
            node.prev = null;
            node.item = null;
            node = temp;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {

        int tempCount = 0;
        Node<E> node = first;
        E e = null;

        while(node != null){

            if (tempCount == index){

                e = node.item;
            }

            tempCount++;
            node = node.next;
        }

        return e;
    }

    @Override
    public E set(int index, E element) {

        int tempCount = 0;
        Node<E> node = first;

        while(node != null){

            if (tempCount == index){

                node.item = element;
//                size++;
                return element;
            }

            tempCount++;
            node = node.next;
        }

        return null;
    }

    private static class Node<E> {
        E item;
        MyLinkedList.Node<E> next;
        MyLinkedList.Node<E> prev;

        Node(MyLinkedList.Node<E> prev, E element, MyLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
