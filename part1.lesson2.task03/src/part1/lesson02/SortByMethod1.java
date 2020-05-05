package part1.lesson02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class SortByMethod1 {
    static long timeStart;
    static long timeFinish;

    public static ArrayList<Person> sortMerge(ArrayList<Person> arrayList, Comparator<Person> comparator) {
        if (arrayList.size() < 2) {
            return arrayList;
        } else {
            ArrayList<Person> arrayList1 = returnFirstSubArray(arrayList);
            ArrayList<Person> arrayList2 = returnLastSubArray(arrayList);

            arrayList1 = sortMerge(arrayList1, comparator);
            arrayList2 = sortMerge(arrayList2, comparator);

            return merge(arrayList1, arrayList2, comparator);
        }
    }

    private static ArrayList<Person> returnFirstSubArray(ArrayList<Person> arrayList) {
        ArrayList<Person> firstSubArray = new ArrayList<>();
        for (int i = 0; i < arrayList.size() / 2; i++) {
            firstSubArray.add(arrayList.get(i));
        }
        return firstSubArray;
    }

    private static ArrayList<Person> returnLastSubArray(ArrayList<Person> arrayList) {
        ArrayList<Person> lastSubArray = new ArrayList<>();
        for (int i = (arrayList.size() / 2); i < arrayList.size(); i++) {
            lastSubArray.add(arrayList.get(i));
        }
        return lastSubArray;
    }

    private static ArrayList<Person> merge(ArrayList<Person> arrayList1, ArrayList<Person> arrayList2, Comparator<Person> comparator){
        ArrayList<Person> personArrayList = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
//        for (int i = 0; i < arrayList1.size(); i++) {
//            if (comparator.compare(arrayList1.get(i), arrayList2.get(i)) > 0) {
//                personArrayList.add(arrayList1.get(i));
//                personArrayList.add(arrayList2.get(i));
//            } else {
//                personArrayList.add(arrayList2.get(i));
//                personArrayList.add(arrayList1.get(i));
//            }
//        }

        for (int i = 0; i < arrayList1.size() + arrayList2.size(); i++) {
                if (index1 == arrayList1.size()){
                    personArrayList.add(arrayList2.get(index2));
                    index2++;
                } else if (index2 == arrayList2.size()) {
                    personArrayList.add(arrayList1.get(index1));
                    index1++;
                } else if (comparator.compare(arrayList1.get(index1), arrayList2.get(index2)) > 0) {
                    personArrayList.add(arrayList1.get(index1));
                    index1++;
                } else {
                    personArrayList.add(arrayList2.get(index2));
                    index2++;
                }
            }
        return personArrayList;
    }

    static long calculateCompilingTime() {
        return (timeFinish - timeStart);
    }

}
