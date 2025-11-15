package Lesson.Two.Contacts;

import java.util.HashSet;
import java.util.Set;

public class Contact {
    private String name;
    private Set<String> emails = new HashSet<>();
    private Set<String> phones = new HashSet<>();

    public Contact(String name) {
        this(name, null);
    }

    public Contact(String name, String email) {
        this(name, email, 0);
    }

    public Contact(String name, long phone) {
        this(name, null, phone);
    }

    public Contact(String name, String email, long phone) {
        this.name = name;
        if (email != null){
            emails.add(email);
        }
        if (phone > 0){
            String p = String.valueOf(phone);
            p = "(%s) %s-%s".formatted(p.substring(0,3), p.substring(3, 6),
                    p.substring(6));
            phones.add(p);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%s: %s %s".formatted(name, emails, phones);
    }

    public Contact mergeContactData(Contact contact){
        Contact newContact = new Contact(name);

        //Clone data to create contact
        newContact.emails = new HashSet<>(this.emails);
        newContact.phones = new HashSet<>(this.phones);
        newContact.emails.addAll(contact.emails);
        newContact.phones.addAll(contact.phones);

        return newContact;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;
        return getName().equals(contact.getName());
    }

    @Override
    public int hashCode() {
        // Add a mulitiplier because a contact instance and a string
        // with the same value (say Mickey Mouse) will have the same
        // hash code. It's generally a good idea to add a multiplier
        // to differentiate. Use a small composite number.
        return 33 * getName().hashCode();
    }

    /**
     * Adds company email to contact name. This resolves the issues
     * of contacts with multiple emails - the set will remove any
     * object with the same name.
     * @param companyName
     */
    public void addEmail(String companyName){
        String[] names = name.split(" ");
        String email = "%c%s@%s.com".formatted(
                name.charAt(0), names[names.length-1],
                companyName.replaceAll(" ", "").toLowerCase()
        );
        if (!emails.add(email)){
            System.out.println(name + " already has email " + email);
        } else {
            System.out.println(name + " now has email " + email);
        }
    }

    public void replaceEmailIfExists(String oldEmail, String newEmail){
        if (emails.contains(oldEmail)){
            emails.remove(oldEmail);
            emails.add(newEmail);
            System.out.println("Replaced email address for " + name + " | Old email: " + oldEmail + " | New email: " + newEmail);
        }
    }
}
