import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ContactsManager {
    private final Scanner scanner;
    private final ContactsInterface data;

    public ContactsManager(Scanner scanner, ContactsInterface data) {
        this.scanner = scanner;
        this.data = data;
    }

    public void start() {
        ProgramInterface.welcome();
        showMenu();
    }

    private void showMenu() {
        ProgramInterface.showMenu();
        String choice = scanner.nextLine();

        switch(choice) {
            case "0":
                exit();
                break;
            case "1":
                viewAllContacts();
                break;
            case "2":
                addContact();
                break;
            case "3":
                searchContacts();
                break;
            case "4":
                removeContact();
                break;
            default:
                ProgramInterface.error("Unknown Option: " + choice);
                showMenu();
                return;
        }
        showMenu();
    }

    private void viewAllContacts() {
        ProgramInterface.showContacts(data.all());
    }

    private void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String number = scanner.nextLine();

        data.add(new Contact(name, number));
        System.out.println("Contact Added!");
    }

    private void searchContacts() {
        System.out.print("Search Term? ");
        String searchTerm = scanner.nextLine();
        List<Contact> results = data.search(searchTerm);
        ProgramInterface.showContacts(results);
    }


    private void removeContact() {
        System.out.print("Contact name to remove? ");
        String name = scanner.nextLine();
        List<Contact> results = data.search(name);
        for (Contact contact : results) {
            System.out.printf("Are you sure you want to remove %s? [y/N]", contact.getName());
            String confirmation = scanner.nextLine();
            if (confirmation.toLowerCase().startsWith("y")) {
                data.remove(contact);
                System.out.println("Contact Removed!");
            } else {
                System.out.println("Contact not removed.");
            }
        }
    }

    private void exit() {
        ProgramInterface.closeProgram();
        System.exit(0);
    }
}
