package Lesson._3.Maps;

import Lesson._2.Contacts.Contact;
import Lesson._2.Contacts.ContactData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Main {
    public static void main(String[] args) {
        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        // Merging lists - this will include duplicates
        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(50));

        // Hash maps of name and contact object
        // Notice that there are no duplicate keys (there can't be), and that they are in no order
        // Mickey also only has an email and no phone number! The "put" element
        // always puts the element in the map if the key is not in the map. The
        // last element in your list is always the one you get.
        Map<String, Contact> contacts = new HashMap<>();
        for (Contact contact : fullList){
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value = "  + v));

        // Look up: Just use get
        System.out.println("-".repeat(50));
        System.out.println(contacts.get("Charlie Brown"));
        System.out.println(contacts.get("C Brown")); //returns a null

        // Create a default Contact with no contact details - note that this is never added to the map
        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("C Brown", defaultContact)); //returns a default value if not found

        System.out.println("-".repeat(50));
        contacts.clear(); //clear

        // Hash maps allow for quick merging.
        for (Contact contact : fullList){
            Contact duplicate = contacts.put(contact.getName(), contact);
            // Print out duplicate contacts that weren't added.
            // Merge duplicates using the mergeContactData method in the Contact class
            if (duplicate != null){
                System.out.println("duplicate = " + duplicate);
                System.out.println("current = " + contact);
                contacts.put(
                        contact.getName(),
                        contact.mergeContactData(duplicate)
                );
            }
        }
        System.out.println("-".repeat(50));
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value = "  + v));
        System.out.println("-".repeat(50));
        contacts.clear();

        // Put if Absent - this is the default method for maps.
        // But there is nuance. This method only puts in the first instance and not the rest, it won't
        // update the value. THe "put" method always only replaces with the last element.
        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value = "  + v));

        System.out.println("-".repeat(50));
        contacts.clear();

        // Merge using putIfAbsent
        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null){
                contacts.put(
                        contact.getName(), contact.mergeContactData(duplicate)
                );
            }
        }
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value = "  + v));

        // Can also use Merge. The 3rd parameter is a bifunction interface - i.e. a nested lambda expression
        // Or use Contact::mergeContactData
        System.out.println("-".repeat(50));
        contacts.clear();
        fullList.forEach(
                contact -> contacts.merge(
                        contact.getName(),          //key
                        contact,                    //value
                        Contact::mergeContactData   //same as: (previous, current) -> previous.mergeContactData(current)
                )
        );
        contacts.forEach((k, v) -> System.out.println("key=" + k + ", value = "  + v));

        // Alternatively some people define anonymous functions for verbosity.
        // This is like defining a callback function inline.
        System.out.println("-".repeat(50));
        contacts.clear();
        fullList.forEach(
                contact -> contacts.merge(
                        contact.getName(),
                        contact,
                        new BiFunction<Contact, Contact, Contact>() {
                            @Override
                            public Contact apply(Contact previous, Contact current) {
                                return previous.mergeContactData(current);
                            }
                        }
                )
        );

        // Using the compute method. This requires a bifunction interface callback but overrides
        // everything initially in the hashmap. Daffy Duck got replaced with a Contact that has
        // no name or email.
        // The computeIfAbsent method requires only a function interface for constructing a
        // new Contact class and does not override.
        System.out.println("-".repeat(50));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
//            contacts.compute(contactName, (k, v) -> new Contact(k));
            contacts.computeIfAbsent(contactName, k -> new Contact(k));
        }
        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value = " + v));

        // Compute if present
        System.out.println("-".repeat(50));
        for (String contactName : new String[] {"Daisy Duck", "Daffy Duck", "Scrooge McDuck"}){
            contacts.computeIfPresent(contactName, (k, v) -> {
                v.addEmail("Fun Place");
                return v ;
            });
        }
        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value = " + v));

        // Replace all - needs a bifunction interface
        System.out.println("-".repeat(50));
        contacts.replaceAll(
                (k, v) -> {
                    String newEmail = k.replaceAll(" ", "") + "@funplace.com";
                    v.replaceEmailIfExists("DDuck@funplace.com", newEmail);
                    return v;
                }
        );

        // Replace
        System.out.println("-".repeat(50));
        Contact daisy = new Contact("Daisy Jane Duck", "daisyj@duck.com");
        Contact replacedContact = contacts.replace("Daisy Duck", daisy);
        System.out.println("daisy = " + daisy);
        System.out.println("replacedContact = " + replacedContact);
        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value = " + v));

        // Overloaded replace: this will fail because the value does not match the key.
        System.out.println("-".repeat(50));
        Contact updatedDaisy = replacedContact.mergeContactData(daisy); //merge with two emails.
        System.out.println("updatedDaisy = " + updatedDaisy);
        boolean success = contacts.replace("Daisy Duck", replacedContact, updatedDaisy);
        if (success){
            System.out.println("Successfully replaced element");
        } else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }
        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value = " + v));

        // Remove - returns a boolean. Must find the key in the map.
        System.out.println("-".repeat(50));
        success = contacts.remove("Daisy Duck", daisy);
        if (success){
            System.out.println("Successfully removed element");
        }else {
            System.out.printf("Did not match on both key: %s and value: %s %n"
                    .formatted("Daisy Duck", replacedContact));
        }
        contacts.forEach((k, v) -> System.out.println("key= " + k + ", value = " + v));



    }
}
