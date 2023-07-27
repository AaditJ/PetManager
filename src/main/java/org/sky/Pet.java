package org.sky;

public class Pet {
    private int Age;
    private String Name;

    private animal Animal;

    public Pet(){

    }

    public Pet(int age, String name, animal animal) {
        Age = age;
        Name = name;
        Animal = animal;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public animal getAnimal() {
        return Animal;
    }

    public void setAnimal(animal animal) {
        Animal = animal;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "Age=" + Age +
                ", Name='" + Name + '\'' +
                ", Animal=" + Animal +
                '}';
    }
}

