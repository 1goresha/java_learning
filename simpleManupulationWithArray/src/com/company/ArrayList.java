package com.company;

public class ArrayList {
    private int[] array;

    public ArrayList(int arraySize) {
        this.array = new int[arraySize];
    }

    private int returnIndexOfLastDigit() {
        int j = -1;
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != 0) {
                j++;
            }
        }
        return j;
    }

    private int returnIndexOfFirstDigit() {
        int j = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (array[i] != 0) {
                return j;
            }
        }
        return j;
    }

    public void addToTheBegin(int digit) {
        for (int i = this.array.length - 1; i > 0; i--) {
            this.array[i] = this.array[i - 1];
        }
        this.array[0] = digit;
    }


    public void deleteDigitByIndex(int index) {
        if (array[index] == 0) {
            return;
        }
        for (int i = index; i < this.array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
    }


    public void add(int digit) {
        if (returnIndexOfLastDigit() == -1) {
            this.array[0] = digit;
            return;
        } else if (returnIndexOfLastDigit() == this.array.length - 1) {
            System.out.println("the end of array!");
            return;
        }
        this.array[returnIndexOfLastDigit() + 1] = digit;
    }

    public void insert(int digit, int index) {
        if (returnIndexOfLastDigit() < array.length) {
            for (int i = this.array.length - 1; i > index; i--) {
                this.array[i] = this.array[i - 1];
            }
            array[index] = digit;
        }
    }

    public void sort() {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[j] <= array[i]) {
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public void reverse() {
        for (int i = 0; i < array.length/2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

}
