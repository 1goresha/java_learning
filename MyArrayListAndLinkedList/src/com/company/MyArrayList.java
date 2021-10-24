package com.company;

import java.util.*;

public class MyArrayList<E> implements MyList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private int currentIndex;

    private Object[] elementData;

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    public MyArrayList() {

        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
        this.currentIndex = 0;
    }


    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    @Override
    public MyIterator<E> myIterator() {

        MyIterator<E> myIterator = new MyIterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {

                return currentIndex < size && elementData[currentIndex] != null;
            }

            @Override
            public E next() {

                try {

                    return (E) elementData[currentIndex++];
                } catch (ClassCastException e) {

                    System.out.println(e.getMessage());
                    return null;
                }
            }
        };

        return myIterator;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void fastRemove(int index) {

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index + 1, elementData, index,
                    numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }

    public void trimToSize() {

        if (size < elementData.length) {
            elementData = (size == 0)
                    ? EMPTY_ELEMENTDATA
                    : Arrays.copyOf(elementData, size);
        }
    }

    @Override
    public boolean add(E e) {

        if (currentIndex >= this.elementData.length) {

            grow(5);
            trimToSize();
        }

        rangeCheckForAdd(currentIndex);
        this.elementData[currentIndex++] = e;

        size++;

        return true;
    }

    @Override
    public boolean remove(E e) {

        for (int i = 0; i < size; i++) {

            if (e.equals(this.elementData[i])) {

                fastRemove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    @Override
    public E get(int index) {

        rangeCheck(index);

        try {

            return (E) elementData[index];
        } catch (ClassCastException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public E set(int index, E element) {

        rangeCheck(index);

        try {

            elementData[index] = element;
            return element;
        } catch (ClassCastException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int size() {

        return size;
    }
}
