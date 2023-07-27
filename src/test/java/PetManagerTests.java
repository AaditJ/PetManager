import org.junit.jupiter.api.*;
import org.sky.Pet;
import org.sky.PetManager;
import org.sky.animal;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class PetManagerTests {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static PetManager pm;

    private static Pet p1;
    private static Pet p2;
    private static Pet p3;
    private static Pet p4;
    private static Pet p5;

    private static List<Pet> list = new ArrayList<>();

    @BeforeEach
    private void setUp(){
        System.setOut(new PrintStream(outContent));

        pm = new PetManager();

        p1 = new Pet();
        p2 = new Pet();
        p3 = new Pet();
        p4 = new Pet();
        p5 = new Pet();

        p1.setName("Luna");
        p2.setName("Max");
        p3.setName("Bella");
        p4.setName("Charlie");
        p5.setName("Daisy");

        p1.setAge(1);
        p2.setAge(2);
        p3.setAge(2);
        p4.setAge(3);
        p5.setAge(5);

        p1.setAnimal(animal.DOG);
        p2.setAnimal(animal.DOG);
        p3.setAnimal(animal.DOG);
        p4.setAnimal(animal.CAT);
        p5.setAnimal(animal.CAT);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        pm.addPets(p1);
        pm.addPets(p4);
        pm.addPets(p3);
        pm.addPets(p2);
        pm.addPets(p5);
    }

    @Test
    public void printAllPets(){
        pm.printAllPets();
        String printString = "All Pets:\n"+ "---------\n" +
                                "Pet{Age=1, Name='Luna', Animal=DOG}\n" +
                                "Pet{Age=2, Name='Charlie', Animal=CAT}\n" +
                                "Pet{Age=2, Name='Bella', Animal=DOG}\n" +
                                "Pet{Age=2, Name='Max', Animal=DOG}\n" +
                                "Pet{Age=5, Name='Daisy', Animal=CAT}";

        //Assertions.assertTrue(printString.equals(outContent.toString()));
    }

    @Test
    public void getCount(){
        Assertions.assertEquals(pm.getCount(),5L);
    }

    @Test
    public void getCountExtra(){
        pm.addPets(new Pet());
        Assertions.assertEquals(pm.getCount(),6L);
    }

    @Test
    public void totalAge(){
        Assertions.assertEquals(pm.totalAge(), 13L);
    }

    @Test
    public void totalAgeExtra(){
        pm.addPets(new Pet(4, "Name", animal.PARROT));
        Assertions.assertEquals(pm.totalAge(), 17L);
    }

    @Test
    public void sortByAge(){

        List<Pet> list = new ArrayList<>();
        list.add(p1);
        list.add(p3);
        list.add(p2);
        list.add(p4);
        list.add(p5);
        Assertions.assertEquals(pm.sortByAge(),list);
    }

    @Test
    public void sortByAgeExtra(){
        Pet newPet = new Pet(1, "Name", animal.DOG);

        pm.addPets(newPet);
        List<Pet> list = new ArrayList<>();
        list.add(p1);
        list.add(newPet);
        list.add(p3);
        list.add(p2);
        list.add(p4);
        list.add(p5);

        Assertions.assertEquals(pm.sortByAge(), list);
    }

    @Test
    public void sortByAgeAndName(){

        List<Pet> list = new ArrayList<>();
        list.add(p1);
        list.add(p3);
        list.add(p2);
        list.add(p4);
        list.add(p5);
        Assertions.assertEquals(pm.sortByAge(),list);
    }

    @Test
    public void sortByAgeAndNameExtra(){
        Pet newPet = new Pet(1, "Name", animal.DOG);

        pm.addPets(newPet);
        List<Pet> list = new ArrayList<>();
        list.add(p1);
        list.add(newPet);
        list.add(p3);
        list.add(p2);
        list.add(p4);
        list.add(p5);

        Assertions.assertEquals(pm.sortByAge(), list);
    }

    @Test
    public void filterByAnimal(){
        List<Pet> list = new ArrayList<>();
        list.add(p1);
        list.add(p3);
        list.add(p2);

        Assertions.assertEquals(pm.filterByAnimal(animal.DOG), list);
    }

    @Test
    public void filterByAnimalExtra(){
        Pet newPet = new Pet(1, "Name", animal.DOG);

        pm.addPets(newPet);
        List<Pet> list = new ArrayList<>();
        list.add(p1);
        list.add(p3);
        list.add(p2);
        list.add(newPet);

        Assertions.assertEquals(pm.filterByAnimal(animal.DOG), list);
    }

    @Test
    public void countOfEach(){

        Dictionary<animal, Integer> enumCount = new Hashtable<>();
        enumCount.put(animal.PARROT,0);
        enumCount.put(animal.DOG,3);
        enumCount.put(animal.CAT,2);
        enumCount.put(animal.SNAKE,0);

        Assertions.assertEquals(pm.countOfEachAnimal(), enumCount);
    }

    @Test
    public void countOfEachExtra(){

        pm.addPets(new Pet(5,  "Name", animal.PARROT));

        Dictionary<animal, Integer> enumCount = new Hashtable<>();
        enumCount.put(animal.PARROT,1);
        enumCount.put(animal.DOG,3);
        enumCount.put(animal.CAT,2);
        enumCount.put(animal.SNAKE,0);

        Assertions.assertEquals(pm.countOfEachAnimal(), enumCount);
    }

    @AfterAll
    private static void restore(){
        System.setOut(originalOut);

    }
}
