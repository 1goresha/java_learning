package com.company;

public class ArrayIntegerList implements IntegerList {
    private int[] array;
    private int count;

    public ArrayIntegerList(int size) {
        array = new int[size];
        count = 0;
    }

    @Override
    public void add(int element) {
        if (count >= this.array.length) {
            System.out.println("превышен максимальный размер массива");
            return;
        }
        array[count] = element;
        count++;
    }

    @Override
    public void addToBegin(int element) {
        if (count >= this.array.length) {
            System.out.println("превышен максимальный размер массива");
            return;
        }
        for (int i = 0; i < array.length - 1; i++) {
//            if ((array.length - i - 2) == 0) return;
            array[array.length - i - 1] = array[array.length - i - 2];
        }
        array[0] = element;
        count++;
    }

    @Override
    public int get(int index) {
        return array[index];
    }

    @Override
    public void insert(int element, int index) {
        array[index] = element;
    }

    @Override
    public void reverse() {
        int temp;
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
    public void sort() {
        int temp;
        for (int j = 0; j < array.length; j++) {
            for (int i = j; i < array.length; i++) {
                if (array[j] > array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    @Override
    public boolean contains(int element) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == element) return true;
        }
        return false;
    }

    @Override
    public int indexOf(int element) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == element) return i;
        }
        return -1;
    }
}
