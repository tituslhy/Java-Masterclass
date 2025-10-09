import java.util.ArrayList;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        Contact c = queryContact(contact.getName());
        if (c == null){
            myContacts.add(contact);
            return true;
        }
        return false;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        Contact c = queryContact(oldContact.getName());
        if (c == null){
            return false;
        }
        myContacts.remove(oldContact);
        myContacts.add(newContact);
        return true;
    }

    public boolean removeContact(Contact contact){
        if (!myContacts.contains(contact)){
            return false;
        }
        myContacts.remove(contact);
        return true;
    }

    private int findContact(Contact contact){
        for (int i = 0; i < myContacts.size(); i++){
            Contact c = myContacts.get(i);
            if (c.getName().equals(contact.getName())){
                return i;
            }
        }
        if (myContacts.contains(contact)){
            return myContacts.indexOf(contact);
        }
        return -1;
    }

    private int findContact(String contactName){
        Contact contact = queryContact(contactName);
        return findContact(contact);
    }

    public Contact queryContact(String contactName){
        for (Contact contact: myContacts){
            if (contact.getName().equals(contactName)){
                return contact;
            }
        }
        return null;
    }

    public void printContacts(){
        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            System.out.println(
                    i+1 + ". " + contact.getName() + " -> " + contact.getPhoneNumber()
            );
        }
    }
}
