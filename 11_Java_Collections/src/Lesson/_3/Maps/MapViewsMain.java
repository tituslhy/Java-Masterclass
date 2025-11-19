package Lesson._3.Maps;

import Lesson._2.Contacts.Contact;
import Lesson._2.Contacts.ContactData;

import java.util.*;

public class MapViewsMain {
    public static void main(String[] args) {
        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        //View of the keys in the HashMap
        Set<String> keysView = contacts.keySet();
        System.out.println(keysView);

        // Ordered view
        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());
        System.out.println(copyOfKeys);

        if (contacts.containsKey("Linus Van Pelt")){
            System.out.println("Linus is in the set");
        }

        // Removing the key in a keyset also edits the map.
        System.out.println("-".repeat(50));
        keysView.remove("Daffy Duck");
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        // This won't edit the main hashmap because copyOfKeys is a copy of the keySet.
        System.out.println("-".repeat(50));
        copyOfKeys.remove("Linus Van Pelt");
        System.out.println(copyOfKeys);
        contacts.forEach((k, v) -> System.out.println(v));

        // Retain all - keep these keys only (and remove the rest - in the key set.
        System.out.println("-".repeat(50));
        keysView.retainAll(List.of("Linus Van Pelt", "Charlie Brown", "Robin Hood", "Mickey Mouse"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        // Clear the entire map
        System.out.println("-".repeat(50));
        keysView.clear();
        System.out.println(contacts);

        // Repopulate the view by re-populating the map.
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keysView);

        // Get values of the map
        var values = contacts.values();
        values.forEach(System.out::println);

        // Retain only emails in the map - i.e. all phone numbers are deleted.
        System.out.println("-".repeat(50));
        values.retainAll(ContactData.getData("email"));
        System.out.println(keysView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("-".repeat(50));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        // Notice Daffy Duck and Duck Daffy
        System.out.println("-".repeat(50));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first);
        values.forEach(System.out::println);
        keysView.forEach(System.out::println);

        System.out.println("-".repeat(50));
        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if (set.size() < contacts.keySet().size()){
            System.out.println("Duplicate values are in my map");
        }

        // Entry Set - key value pair sets
        var nodeSet = contacts.entrySet();
        for (var node: nodeSet){
            if (!node.getKey().equals(node.getValue().getName())){
                System.out.println(
                        "Key does not match the given name: " + node.getKey() + ": " + node.getValue()
                );
            }
        }
    }
}
