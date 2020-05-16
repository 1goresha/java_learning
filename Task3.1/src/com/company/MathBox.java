package com.company;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MathBox<T extends Number> extends ObjectBox<Object>{
//    private List<T> list = new ArrayList<>();

//    public List<Number> getList() {
//        return list;
//    }

    public MathBox(T[] numbers) {
        super();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }
    }

    public int summator() {
        int sum = 0;
        List<? extends T> list1 = getList();
        for (T a : list1
        ) {
            sum += a.intValue();
        }
        return sum;
    }

    public void splitter(int divider) {
        int temp;
        List<? extends T> list1 = getList();
        for (int i = 0; i < list1.size(); i++) {
            temp = list1.get(i).intValue() / divider;
            list.set(i, temp);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(list, mathBox.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "list=" + list +
                '}';
    }

//    public Integer delete(Integer a) {
//        if (list.remove(a)) return a;
//        return -1;
//    }
}
