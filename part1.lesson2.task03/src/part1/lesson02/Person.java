package part1.lesson02;

import java.util.Objects;

public class Person{
    int age;
    Sex sex;
    Name name;

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", sex=" + sex +
                ", name=" + name +
                '}';
    }

    public Person(int age, Sex sex, Name name) {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }


}
