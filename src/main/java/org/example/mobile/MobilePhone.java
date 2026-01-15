package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(myContacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return false;
        }

        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundIndex = findContact(oldContact);

        if (foundIndex < 0) {
            return false;
        }

        int existingIndex = findContact(newContact);
        if (existingIndex >= 0 && existingIndex != foundIndex) {
            return false;
        }

        myContacts.set(foundIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundIndex = findContact(contact);

        if (foundIndex < 0) {
            return false;
        }

        myContacts.remove(foundIndex);
        return true;
    }

    public int findContact(Contact contact) {
        return myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(contactName)) {
                return i;
            }
        }

        return -1;
    }

    public Contact queryContact(String contactName) {
        int foundIndex = findContact(contactName);

        if (foundIndex < 0) {
            return null;
        }

        return myContacts.get(foundIndex);
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}