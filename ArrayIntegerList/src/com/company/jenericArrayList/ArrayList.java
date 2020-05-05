package com.company.jenericArrayList;

import java.lang.reflect.Type;
import java.util.Comparator;
import java.util.Objects;

public class ArrayList<T> implements List<T> {
    public T[] array;
    private int count;

    public ArrayList(int size) {
        array = (T[]) new Object[size];
        count = 0;
    }

    @Override
    public void add(T element) {
        if (count >= this.array.length) {
            System.out.println("превышен максимальный размер массива");
            return;
        }
        array[count] = element;
        count++;
    }

    @Override
    public void addToBegin(T element) {
        if (count >= this.array.length) {
            System.out.println("превышен максимальный размер массива");
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
            array[array.length - i - 1] = array[array.length - i - 2];
        }
        array[0] = element;
        count++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void insert(T element, int index) {
        array[index] = element;
    }

    @Override
    public void reverse() {
        T temp;
        for (int i = 0; i < (array.length - 1) / 2; i++) {
            temp = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = temp;

        }
    }

    @Override
    public int getSize() {
        return count;
    }


    @Override
    public <T extends Comparable<T>> void sort() {
        T temp;
        Object[] tArray = this.array;
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = j; i < array.length - 1; i++) {
                if (((T)tArray[i]).compareTo((T)tArray[j]) < 0) {
                    temp = (T)tArray[j];
                    tArray[j] = tArray[i];
                    tArray[i] = temp;
                }
            }
        }
    }

    public void sort(Comparator<T> comparator) {
        T temp;
        Object[] tArray = this.array;
        for (int j = 0; j < array.length - 1; j++) {
            for (int i = j; i < array.length - 1; i++) {
                if (comparator.compare((T)tArray[i],(T)tArray[j]) < 0) {
                    temp = (T)tArray[j];
                    tArray[j] = tArray[i];
                    tArray[i] = temp;
                }
            }
        }
    }

    @Override
    public boolean contains(T element) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == element) return true;
        }
        return false;
    }

    @Override
    public int indexOf(T element) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == element) return i;
        }
        return -1;
    }
}
