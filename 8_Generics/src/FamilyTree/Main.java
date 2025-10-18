package FamilyTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var dad = new Dad("Titus", 35);
        var mum = new Mum("Dawn", 31);
        var girl1 = new Daughter("Princess", 4);
        var girl2 = new Daughter("Princess2", 2);
        var bob = new Pet("Bob");

        var familyMembers = new ArrayList<FamilyMember>(Arrays.asList(
                dad, mum, girl1, girl2
        ));
        var registry = new FamilyRegistry<FamilyMember>(familyMembers);
        registry.printAllMembers();

//        familyMembers.add(bob); // this results in an error
    }
}
