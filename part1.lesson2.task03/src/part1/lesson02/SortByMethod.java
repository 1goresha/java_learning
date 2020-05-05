package part1.lesson02;

import java.util.ArrayList;
import java.util.Comparator;

public class SortByMethod {
    static int comparatorBy;

    static long timeStart;
    static long timeFinish;


    static void sort(Comparator<Person> comparatorBy, ArrayList<Person> personArrayList, Comparator<Person> comparatorByName, Comparator<Person> comparatorByAge) {
        timeStart = System.nanoTime();
        for (int i = personArrayList.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                SortByMethod.comparatorBy = comparatorBy.compare(personArrayList.get(j), personArrayList.get(j + 1));
                if (SortByMethod.comparatorBy > 0) {
                    Person temp = personArrayList.get(j);
                    personArrayList.set(j, personArrayList.get(j + 1));
                    personArrayList.set(j + 1, temp);
                }
            }
        }
        timeFinish = System.nanoTime();
    }

    static long calculateCompilingTime() {
        return (timeFinish - timeStart);
    }


    public static void checkingForTheSameNameAndAge(ArrayList<Person> personArrayList) {
        Comparator<Person> comparatorByName = new ComparatorByName();
        Comparator<Person> comparatorByAge = new ComparatorByAge();
        int k = 0;
        for (int i = personArrayList.size() - 1; i >= 0; i--) {
            for (int j = k; j < i; j++) {
                try {
                    if (comparatorByName.compare(personArrayList.get(j), personArrayList.get(j + 1)) == 0
                            && comparatorByAge.compare(personArrayList.get(j), personArrayList.get(j + 1)) == 0) {
                        k = j + 1;
                        throw new NameEqualsAgeException("Клон --- " + personArrayList.get(j) + " == " + personArrayList.get(j + 1));
                    }
                } catch (NameEqualsAgeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}



