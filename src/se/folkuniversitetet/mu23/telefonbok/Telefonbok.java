package se.folkuniversitetet.mu23.telefonbok;

import java.util.ArrayList;
import java.util.List;

public class Telefonbok {
    private final List<Kontakt> contacts;

    public Telefonbok() {
        contacts = new ArrayList<>();
    }

    public void addContact(Kontakt contact) {
        contacts.add(contact);
    }

    public void viewContacts() {
        for (Kontakt contact : contacts) {
            System.out.println(contact);
        }
    }

    public Kontakt findContactBySurname(String surname) {
        for (Kontakt contact : contacts) {
            if (contact.getSurname().contains(surname)) {
                System.out.println("Contact found: " + contact);
                return contact;
            }
        }
        System.out.println("Contact not found");
        return null;
    }

    public void findContactsByName(String name) {
        int count = 0;
        for (Kontakt contact : contacts) {
            if (contact.getName().contains(name)) {
                System.out.println("Contact found: " + contact);
                count++;
            }
        }
        if (count == 0) System.out.println("No contacts are found");
    }

    public void findContactsByAddress(String address) {
        int count = 0;
        for (Kontakt contact : contacts) {
            if (contact.getAddress().toLowerCase().contains(address.toLowerCase())) {
                System.out.println("Contact found: " + contact);
                count++;
            }
        }
        if (count == 0) System.out.println("No contacts are found");
    }

    public Kontakt findContactsFreeSearch(String input) {
        int count = 0;
        for (Kontakt contact : contacts) {
            if (contact.getName().contains(input)) {
                System.out.println("Contact found: " + contact);
                count++;
                continue;
            }
            if (contact.getSurname().contains(input)) {
                System.out.println("Contact found: " + contact);
                count++;
                continue;
            }
            if (contact.getAge() == Integer.parseInt(input)) {
                System.out.println("Contact found: " + contact);
                count++;
                continue;
            }
            if (contact.getAddress().contains(input)) {
                System.out.println("Contact found: " + contact);
                count++;
                continue;
            }
            if (contact.getPhoneNumber().contains(input)) {
                System.out.println("Contact found: " + contact);
                count++;
            }
        }
        if (count == 0) System.out.println("No contacts are found");
        return null;
    }

    public void updateContact(Kontakt contactToUpdate, String nameEdited, String surnameEdited, int ageEdited, String addressEdited, String phoneNumberEdited) {

        if (nameEdited != null && !nameEdited.trim().equals("")) {
            contactToUpdate.setName(nameEdited);
        }

        if (surnameEdited != null && !surnameEdited.trim().equals("")) {
            contactToUpdate.setSurname(surnameEdited);
        }

        if (ageEdited != 0 && ageEdited > 0) {
            contactToUpdate.setAge(ageEdited);
        }

        if (addressEdited != null && !addressEdited.trim().equals("")) {
            contactToUpdate.setAddress(addressEdited);
        }

        if (phoneNumberEdited != null && !phoneNumberEdited.trim().equals("")) {
            contactToUpdate.setPhoneNumber(phoneNumberEdited);
        }
        System.out.println("Contact is updated: " + contactToUpdate);

    }


    public void deleteContactByName(String name) {
        Kontakt contactToDelete = findContactBySurname(name);
        if (contactToDelete != null) {
            contacts.remove(contactToDelete);
            System.out.println("Deleted contact: " + contactToDelete.getName());
        } else {
            System.out.println("Contact not found");
        }
    }


    public void createDefaultProfiles() {
        // create default profiles
        Kontakt kontakt1 = new Kontakt("name1", "surname1", 25, "Address 1", "100");
        Kontakt kontakt2 = new Kontakt("name2", "surname2", 26, "Address 2", "101");
        addContact(kontakt1);
        addContact(kontakt2);
    }

}

