package Lesson._2.LinkedHashSetAndTreeSet;

import Lesson._2.Contacts.Contact;
import Lesson._2.Contacts.ContactData;

import java.util.*;

// TreeSets have higher performance costs that come with its built-in functionality.
// Use only when you have a moderate number of elements.

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

        // This method works too - but notice that the element that is being polled
        // no longer belong to the set after polling. They get removed from `copiedSet`
        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("-".repeat(50));

        Contact daffy = new Contact("Daffy Duck");
        Contact daisy = new Contact("Daisy Duck");
        Contact snoopy = new Contact("Snoopy");
        Contact archie = new Contact("Archie");

        // Snoopy isn't in the set so there aren't any methods greater than snoopy.
        // Robin Hood is the last element in the set. Elements in the set get returned
        // as either higher or ceiling.
        // Ceiling returns the least element greater than or equal to the element. If
        // the element is in the set, returns the element.
        // Higher returns the least element strictly greater than the element of interest.
        for (Contact c : List.of(daffy, daisy, last, snoopy)){
            System.out.printf("ceiling(%s)=%s%n", c.getName(), fullSet.ceiling(c));
            System.out.printf("higher(%s)=%s%n", c.getName(), fullSet.higher(c));
        }

        System.out.println("-".repeat(50));
        // The floor method is used to return the greatest element in the set
        // less than or equal to the given element.
        // The lower method returns the greatest element strictly less than the
        // element.
        for (Contact c : List.of(daffy, daisy, first, archie)){
            System.out.printf("floor(%s)=%s%n", c.getName(), fullSet.floor(c));
            System.out.printf("lower(%s)=%s%n", c.getName(), fullSet.lower(c));
        }

        System.out.println("-".repeat(50));

        NavigableSet<Contact> descendingSet = fullSet.descendingSet();
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(50));

        Contact lastContact = descendingSet.pollLast(); //Remove and return Charlie Brown
        System.out.println("Removed " + lastContact);
        descendingSet.forEach(System.out::println);
        System.out.println("-".repeat(50));
        fullSet.forEach(System.out::println); //Charlie brown is removed here too!
        // Whatever you remvoe from the set - the supporting set gets impacted too
        System.out.println("-".repeat(50));

        // headSet returned all the elements less than "maid marion"
        Contact marion = new Contact("Maid Marion");
        var headSet = fullSet.headSet(marion);
        headSet.forEach(System.out::println);
        System.out.println("-".repeat(50));

        // tailSet returned all the elements greater than and including "maid marion"
        var tailSet = fullSet.tailSet(marion);
        tailSet.forEach(System.out::println);
        System.out.println("-".repeat(50));

        // you could pass in an overloaded version to exclude maid marion
        var tailSet2 = fullSet.tailSet(marion, false);
        tailSet2.forEach(System.out::println);
        System.out.println("-".repeat(50));

        // Subsets: Creating a mini set including the first element and excluding
        // the second element by default. Add booleans after the arguments to specify whether
        // to include/exclude them. In this case we want to exclude linus but include marion.
        // we are looking for linus < x <= marion.
        Contact linus = new Contact("Linus Van Pelt");
        var subset = fullSet.subSet(linus, false, marion, true);
        subset.forEach(System.out::println);
    }
}
