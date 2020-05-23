package com.company;

import java.util.Iterator;

public class ArrayList<T> implements List<T>{
    private T[] arrayList;
    private int maxSize;
    int count;

    public ArrayList(int maxSize){
        this.maxSize = maxSize;
        arrayList = (T[]) new Object[this.maxSize];
        count = 0;
    }

    @Override
    public void add(T element) {
        arrayList[count] = element;
        count++;
    }

    @Override
    public T get(int index) {
        try{
            return arrayList[index];
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public int size(){
        return this.maxSize;
    }


    public ArrayListIterator getArrayListIterator() {
        return new ArrayListIterator();
    }

    public class ArrayListIterator implements Iterable<T>{

        ArrayListIterator(){

        }

        int currCount = 0;

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return currCount++ < maxSize;
                }

                @Override
                public T next() {
                    return (T)arrayList[currCount - 1];
                }
            };
        }
    }

}
