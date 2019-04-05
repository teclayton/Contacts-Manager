

import java.util.List;


public class ProgramInterface {
    private static final String contactsFormat = "| %-10s | %10s |\n";

    public static void error(String message) {
        System.err.println("An error occured!");
        System.out.println("ERROR: " + message);
    }


    public static void welcome() {
        System.out.println("--------------------------------");
        System.out.println("Welcome to the Contacts Manager!");
        System.out.println("--------------------------------");
        System.out.println("");
    }

    public static void showMenu() {
        System.out.println("");
        System.out.println("0 - Exit");
        System.out.println("1 - View Contacts");
        System.out.println("2 - Add A Contact");
        System.out.println("3 - Search Contacts");
        System.out.println("4 - Remove A Contact");
        System.out.println();
        System.out.print("Choose an option: ");

    }

    public static void showContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("Could not find any contacts");
            return;
        }
        System.out.printf(contactsFormat, "Name", "Number");
        System.out.printf(contactsFormat, "---------", "--------");
        for (Contact contact : contacts) {
            System.out.printf(contactsFormat, contact.getName(), contact.getNumber());
        }
    }

    public static void closeProgram() {
        System.out.println("----------------------------------------");
        System.out.println("Thank you for using my Contacts Manager!");
        System.out.println("----------------------------------------");
        System.out.println();
    }

}