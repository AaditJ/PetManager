package org.sky;

import java.util.*;
import java.util.stream.Collectors;


public class PetManager {
    private ArrayList<Pet> pets = new ArrayList<>();

    public ArrayList<Pet> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    public void addPets(Pet pet){
        this.pets.add(pet);
    }

    public void printAllPets(){
        System.out.println("All Pets:");
        System.out.println("---------");
        pets.forEach(x -> System.out.println(x.toString()));
    }

    public long totalAge(){
        return pets.stream().map(x -> x.getAge()).reduce(0, (a,b) -> a+b, Integer::sum);
    }

    public long getCount(){
        return pets.stream().map(x -> 1).reduce(0, (a,b) -> a+b, Integer::sum);
    }

    public List<Pet> sortByAge(){


        return pets.stream().sorted(Comparator.comparing(Pet::getAge)).collect(Collectors.toList());
    }

    public List<Pet> sortByAgeThenName(){

        Comparator<Pet> compareByAgeThenName = Comparator.comparing(Pet::getAge).thenComparing(Pet::getName);
        return pets.stream().sorted(compareByAgeThenName).collect(Collectors.toList());
    }

    public List<Pet> filterByAnimal(animal ae){
       return pets.stream().filter(pet -> pet.getAnimal() == ae).collect(Collectors.toList());
    }

    public Dictionary<animal, Integer> countOfEachAnimal(){
        Dictionary<animal,Integer> dictionary = new Hashtable<>();

        for (animal a:animal.values()) {
            int num = filterByAnimal(a).stream().map(x -> 1).reduce(0, (n,b) -> n+b, Integer::sum);
            dictionary.put(a,num);
        }
        return dictionary;
    }
}
