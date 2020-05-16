package com.company;

import java.util.ArrayList;
import java.util.List;

public class ObjectBox<T> {
    protected List<T> list =new ArrayList<>();

    public List getList(){
        return list;
    }

    public void addObject(T o){
        list.add(o);
    }

    public void deleteObject(T o){
        if (list.remove(o)){
            System.out.println("элемент "+ o + "был удален");
        }else System.out.println("такого элемента нет");
    }

    public void deleteObject(int i){
        list.remove(i);
    }

    public String dump(){
        String s = "";
        for (Object o :
                list) {
            s += o.toString();
            s += " ; ";
        }
        return s;
    }
}
