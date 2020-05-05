package part1.lesson02;

import java.util.Comparator;

public class ComparatorBySex implements Comparator<Person>{


    @Override
    public int compare(Person o1, Person o2) {
        String s1 = o1.sex.name();
        String s2 = o2.sex.name();
        return s1.compareTo(s2);
    }
}
