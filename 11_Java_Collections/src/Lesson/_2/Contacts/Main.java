package Lesson._2.Contacts;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Contact> emails = ContactData.getData("email");
        List<Contact> phones = ContactData.getData("phone");
        printData("Phone List", phones);
        printData("Email List", emails);

        Set<Contact> emailContacts = new HashSet<>(emails);
        Set<Contact> phoneContacts = new HashSet<>(phones);
        printData("Phone contacts", phoneContacts);
        printData("Email contacts", emailContacts);
        //If you don't generate the equals and hashCode in your Contact class:
        // Notice that duplicates still exist! but the duplicates are identified
        //by hash codes. in our case, the hash codes are unique for each object
        //so they aren't duplicates. we'll have to fix that.

        // Adding another email to Robin hood
        int index = emails.indexOf(new Contact("Robin Hood"));
        Contact robinHood = emails.get(index);
        robinHood.addEmail("Sherwood Forest");
        robinHood.addEmail("Sherwood Forest");
        robinHood.replaceEmailIfExists(
                "RHood@sherwoodforest.com",
                "RHood@sherwoodforest.org"
        );
        System.out.println(robinHood);

        // Set union
        Set<Contact> unionAB = new HashSet<>();
        unionAB.addAll(emailContacts);
        unionAB.addAll(phoneContacts);
        printData(" (A ∪ B) Union of emails (A) with phones (B)", unionAB);

        // Set intersection
        Set<Contact> intersectAB = new HashSet<>(emailContacts);
        intersectAB.retainAll(phoneContacts); //this maintains the emails of the initial set post intersection
        printData(
                "(A ∩ B) Intersection of emails (A) and phones (B)",
                intersectAB
        );

        //
        Set<Contact> intersectBA = new HashSet<>(phoneContacts);
        intersectBA.retainAll(emailContacts); //this maintains the phones of the initial set post intersection
        printData(
                "(A ∩ B) Intersection of phones (A) and emails (B)",
                intersectBA
        );

        // Remove all. THis shows the difference from the intersection
        Set<Contact> AMinusB= new HashSet<>(emailContacts);
        AMinusB.removeAll(phoneContacts); //this maintains the email of the initial set post intersection
        printData(
                "(A - B) Intersection of emails (A) minus phones (B)",
                AMinusB
        );

        Set<Contact> BMinusA= new HashSet<>(phoneContacts);
        BMinusA.removeAll(emailContacts); //this maintains the phone of the initial set post intersection
        printData(
                "(A - B) Intersection of phones (A) minus emails (B)",
                BMinusA
        );

        // Symmetric Diff - This is the union of the two difference sets.
        Set<Contact> symmetricDiff = new HashSet<>(AMinusB);
        symmetricDiff.addAll(BMinusA);
        printData("Symmetric difference: phones and emails", symmetricDiff);
    }

    public static void printData(String header, Collection<Contact> contacts){
        System.out.println("-".repeat(50));
        System.out.println(header);
        System.out.println("-".repeat(50));
        contacts.forEach(System.out::println);
    }
}
