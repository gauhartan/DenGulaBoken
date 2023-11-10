package se.folkuniversitetet.mu23.telefonbok;

import user.Admin;
import user.Guest;
import user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHandler {

    private static final List<User> users = new ArrayList<>();


    public static void startGuestMenu() {
        createDefaultUsers();

        Telefonbok telefonbok = new Telefonbok();
        telefonbok.createDefaultProfiles();


        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            PrintHandler.showGuestMenu();
            int operation = scanner.nextInt();

            PrintHandler.showUserInput(operation);

            if (operation == 1) {
                System.out.println("Enter the last name of the contact:");
                String surname = scanner.next();
                telefonbok.findContactBySurname(surname);
            } else if (operation == 2) {
                System.out.println("Enter the name of the contact:");
                String name = scanner.next();
                telefonbok.findContactsByName(name);
            } else if (operation == 3) {
                System.out.println("Enter the address of the contact:");
                String address = scanner.next();
                telefonbok.findContactsByAddress(address);
            } else if (operation == 4) {
                System.out.println("Free Search:");
                String input = scanner.next();
                telefonbok.findContactsFreeSearch(input);
            } else if (operation == 5) {
                System.out.println("Enter username: ");
                String username = scanner.next();
                System.out.println("Enter password: ");
                String password = scanner.next();
                Admin admin = (Admin) loginAsAdmin(username, password);
                if (admin == null) System.out.println("Invalid credentials");
                else startAdminMenu(telefonbok);
            } else if (operation == 6) {
                exit = true;
            }
        }


    }

    public static void startAdminMenu(Telefonbok telefonbok) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {

            PrintHandler.showAdminMenu();
            int operation = scanner.nextInt();

            PrintHandler.showUserInput(operation);

            if (operation == 1) {
                System.out.println("Add name: ");
                String name = scanner.next();
                System.out.println("Add surname: ");
                String surname = scanner.next();
                System.out.println("Add age: ");
                int age = scanner.nextInt();
                System.out.println("Add address: ");
                String address = scanner.next();
                System.out.println("Add phoneNumber: ");
                String phoneNumber = scanner.next();
                Kontakt newKontakt = new Kontakt(name, surname, age, address, phoneNumber);
                telefonbok.addContact(newKontakt);
            } else if (operation == 2) {
                System.out.println("Contact list");
                telefonbok.viewContacts();
            } else if (operation == 3) {
                System.out.println("Update contact");
                System.out.println("Enter the name of the contact you want to update: ");
                String name = scanner.next();
                Kontakt contactToUpdate = telefonbok.findContactBySurname(name);

                System.out.println("Edit name: ");
                String nameEdited = scanner.next();
                System.out.println("Edit surname: ");
                String surnameEdited = scanner.next();
                System.out.println("Edit age: ");
                int ageEdited = scanner.nextInt();
                System.out.println("Edit address: ");
                String addressEdited = scanner.next();
                System.out.println("Edit phoneNumber: ");
                String phoneNumberEdited = scanner.next();

                telefonbok.updateContact(contactToUpdate, nameEdited, surnameEdited, ageEdited, addressEdited, phoneNumberEdited);
            } else if (operation == 4) {
                System.out.println("Remove contact");
                System.out.println("Enter the name of the contact you want to delete: ");
                String name = scanner.next();
                telefonbok.deleteContactByName(name);
            } else if (operation == 5) {
                exit = true;
            }
        }
    }

    private static void createDefaultUsers() {
        // create default users
        Guest guest = new Guest("guest");
        Admin admin = new Admin("admin", "admin");
        users.add(guest);
        users.add(admin);
    }

    private static User loginAsAdmin(String username, String password) {
        for (User user : users) {
            if (user instanceof Admin && user.loginAsAdmin(username, password) != null) {
                return user;
            }
        }
        return null;
    }
}

