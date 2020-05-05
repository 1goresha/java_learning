package part1.lesson02;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> personArrayList = new ArrayList<>();
        ComparatorByAge comparatorByAge = new ComparatorByAge();
        ComparatorByName comparatorByName = new ComparatorByName();
        ComparatorBySex comparatorBySex = new ComparatorBySex();

        Random random = new Random();
        Sex[] sexs = Sex.values();
        Name[] names = Name.values();

        for(int i = 0; i < 20; i ++){
            int age = random.nextInt(10);
            Sex sex;
            if (Math.random() < 0.5){
                sex = Sex.MAN;
            }else{
                sex = Sex.WOMAN;
            }
            Name name;
            if (sex.equals(Sex.MAN)) {
                name = names[random.nextInt(10)];
            } else {
                name = names[random.nextInt(10) + 13];
            }
            personArrayList.add(new Person(age, sex, name));
        }


        SortByMethod.sort(comparatorByName, personArrayList);
//        for (Person p : personArrayList) {
//            System.out.println(p);
//        }
        SortByMethod.sort(comparatorByAge, personArrayList);
//        for (Person p : personArrayList) {
//            System.out.println(p);
//        }
        SortByMethod.sort(comparatorBySex, personArrayList);
        SortByMethod.checkingForTheSameNameAndAge(personArrayList);

        for (Person p : personArrayList) {
            System.out.println(p);
        }


//        ArrayList<Person> arr = SortByMethod1.sortMerge(personArrayList, comparatorByName );
//        ArrayList<Person> arr1 = SortByMethod1.sortMerge(arr, comparatorByAge );
//        ArrayList<Person> arr2 = SortByMethod1.sortMerge(arr1, comparatorBySex );
        int k = 0;

//        for (Person p : arr2) {
////            System.out.println(p);
////        }


        int i =0;

    }
}
