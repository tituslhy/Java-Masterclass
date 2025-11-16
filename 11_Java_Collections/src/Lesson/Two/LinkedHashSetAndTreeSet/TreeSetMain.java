package Lesson.Two.LinkedHashSetAndTreeSet;

import Lesson.Two.Contacts.Contact;
import Lesson.Two.Contacts.ContactData;

import java.sql.Array;
import java.util.*;

public class TreeSetMain {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        // When using objects in a tree set, you need to use Comparator to specify
        // the order of sorting so that the elements can be coerced to a tree
        // structure - specifically a red black tree.
        Comparator<Contact> mySort = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(mySort);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);
        System.out.println("-".repeat(50));

        // Strings have natural order so they don't need a pre-defined comparator
        NavigableSet<String> justNames = new TreeSet<>();
        phones.forEach(c -> justNames.add(c.getName()));
        System.out.println(justNames);
        System.out.println("-".repeat(50));

        // Merging both contact lists to get only unique contacts
        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);

        // Creating a list that has duplicates because we are merging both contact types
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("-".repeat(50));
        fullList.forEach(System.out::println);

        /// You can find min and max in a tree set because it's ordered.
        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());
        // This is the preferred way to get max and min in a set.
        Contact first = fullSet.first();
        Contact last = fullSet.last();
        System.out.println("-".repeat(50));
        System.out.printf("min = %s, first = %s %n", min.getName(), first.getName());
        System.out.printf("max = %s, last = %s %n", max.getName(), last.getName());
        System.out.println("-".repeat(50));

    }
}
