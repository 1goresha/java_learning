package com.company;

import java.util.Objects;

public class Pet {
    private int uUid;
    private String name;
    private Person person;
    private double weight;

    public Pet(String name, Person person, double weight) {
//        Pet.uUid = this.hashCode(name, person, weight);
//        this.uUid ++;
        this.name = name;
        this.person = person;
        this.weight = weight;
    }

    public void setUuid(int uUid) {
        this.uUid = uUid;
    }

    public int getUuid() {
        return uUid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Person getPerson() {
        return person;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + uUid +
                ", name='" + name + '\'' +
                ", person=" + person +
                ", weight=" + weight +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return uUid == pet.uUid &&
                Double.compare(pet.weight, weight) == 0 &&
                Objects.equals(name, pet.name) &&
                Objects.equals(person, pet.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, person, weight);
    }

}
