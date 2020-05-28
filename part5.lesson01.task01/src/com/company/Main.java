package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
    Person Igor = new Person("Игорь", 30, "man");
    Person Stas = new Person("Станислав", 30, "man");
    Person Sergei = new Person("Сергей", 24, "man");
    Person Katya = new Person("Катя", 20, "woman");
    Person Nastya = new Person("Настя", 30, "woman");


    PetList petList = new PetList();
    petList.add(new Pet("Пушок", Igor, 3.0 ));
    petList.add(new Pet("Барсик", Stas, 4.0));
    petList.add(new Pet("Пирожок", Sergei, 2.0));
    petList.add(new Pet("Тика", Katya, 5.0));
    petList.add(new Pet("Рыжий", Nastya, 7.0));
//    petList.add(new Pet("Рыжий", Nastya, 7.0));

//    petList.showAllWithSortByPersonAndNameAndWeight();

//    petList.changePetParameters(1257702837, "Бублик", new Person("Аркадий", 100, "ОНО"), 50);
    petList.showAllElements();
//        System.out.println(petList.findByPetName("Барсик"));
    }

}
