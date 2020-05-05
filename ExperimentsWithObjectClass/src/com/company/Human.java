package com.company;

import java.util.Objects;

public class Human {
    private String name;
    private int age;
    private int height;

    public Human(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Human h = (Human) o;
        return this.age == h.age &&
                this.height == h.height &&
                Objects.equals(this.name, h.name);
    }


}
