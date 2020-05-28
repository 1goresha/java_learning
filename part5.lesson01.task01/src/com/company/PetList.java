package com.company;

import java.util.*;

public class PetList {
    private int petId;
    private Map<Integer, Pet> list;

    public PetList() {
        this.list = new HashMap<>();
    }

    public void add(Pet value) {
        if (list.containsValue(value)) {
            throw new IllegalArgumentException("такой питомец уже существует");
        }
//        int key = petId++;
        int key = value.hashCode();
        value.setUuid(key);
        list.put(key, value);
    }

    public Pet findByPetName(String petName) {
        for (Map.Entry<Integer, Pet> entry :
                list.entrySet()) {
            Pet currentPet = entry.getValue();
            if (currentPet.getName().equals(petName)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public boolean changePetParameters(int petId, String name, Person person, double weight) {
        if (!list.containsKey(petId)) {
            return false;
        }
        list.get(petId).setName(name);
        list.get(petId).setPerson(person);
        list.get(petId).setWeight(weight);
        return true;
    }

    public void showAllWithSortByPersonAndNameAndWeight() {
        Comparator<Pet> comparatorByPerson = new ComparatorByPerson();
        Comparator<Pet> comparatorByName = new ComparatorByName();
        Comparator<Pet> comparatorByWeight = new ComparatorByWeight();
        List<Pet> petList = new ArrayList<>(this.list.values());
        petList.sort(comparatorByPerson);
        petList.sort(comparatorByName);
        petList.sort(comparatorByWeight);
        for (Pet pet : petList
        ) {
            System.out.println(pet.toString());
        }
    }

    public void showAllElements(){
        List<Pet> petList = new ArrayList<>(this.list.values());
        for (Pet pet : petList
        ) {
            System.out.println(pet.toString());
        }
    }

}
