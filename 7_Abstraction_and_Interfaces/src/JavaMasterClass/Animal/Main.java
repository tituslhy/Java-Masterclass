package JavaMasterClass.Animal;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Wolf", "big", 100);
        dog.makeNoise();
        doAnimalStuff(dog);

        // this list can hold any type of animal including Fish and Dog
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Dog("German Shepherd", "big", 150));
        animals.add(new Fish("Goldfish", "small", 1));
        animals.add(new Fish("Barracuda", "big", 75));
        animals.add(new Dog("Pug", "small", 20));

        animals.add(new Horse("Clydesdale", "large", 1000));

        for (Animal animal : animals){
            doAnimalStuff(animal);
            if (animal instanceof Mammal currentMammal){
                currentMammal.shedHair();
            }
        }
    }

    /*
    You can't initialize abstract classes but can still pass it in as an argument.
    When running the abstract class' methods you're actually invoking the extended class.
    Pretty cool!
     */
    private static void doAnimalStuff(Animal animal){
        animal.makeNoise();
        animal.move("slow");
    }
}
