package org.sky;

public class Main {
    public static void main(String[] args) {

        Pet p1 = new Pet();
        Pet p2 = new Pet();
        Pet p3 = new Pet();
        Pet p4 = new Pet();
        Pet p5 = new Pet();

        p1.setName("Luna");
        p2.setName("Max");
        p3.setName("Bella");
        p4.setName("Charlie");
        p5.setName("Daisy");

        p1.setAge(1);
        p2.setAge(2);
        p3.setAge(2);
        p4.setAge(2);
        p5.setAge(5);

        p1.setAnimal(animal.DOG);
        p2.setAnimal(animal.DOG);
        p3.setAnimal(animal.DOG);
        p4.setAnimal(animal.CAT);
        p5.setAnimal(animal.CAT);


        PetManager pm = new PetManager();
        pm.addPets(p1);
        pm.addPets(p4);
        pm.addPets(p3);
        pm.addPets(p2);
        pm.addPets(p5);

        pm.printAllPets();
        //System.out.println(pm.getCount());
        System.out.println(pm.sortByAge());

        System.out.println(pm.sortByAgeThenName());

        System.out.println(pm.countOfEachAnimal());
//
//        System.out.println(pm.filterByAnimal(animal.DOG));


    }
}