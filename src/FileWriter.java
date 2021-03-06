import java.util.ArrayList;
import java.util.List;


public class FileWriter implements ContactsInterface {

    private static final String contactsFile = "contacts.txt";

    private Contact fromLine(String line) {
        String[] section = line.split("\\|");
        return new Contact(section[0], section[1]);
    }

    private String toLine(Contact contact) {
        return String.format("%s|%s", contact.getName(), contact.getNumber());
    }

    private void writeToFile(List<Contact> contacts) {
        List<String> lines = new ArrayList<>();
        for (Contact contact : contacts) {
            lines.add(toLine(contact));
        }
        FileManager.place(contactsFile, lines);
    }


    @Override
    public void add(Contact contact) {
        List<Contact> contacts = all();
        contacts.add(contact);
        writeToFile(contacts);

    }

    @Override
    public void remove(Contact contact) {
        List<Contact> contacts = all();
        contacts.remove(contact);
        writeToFile(contacts);
    }

    @Override
    public List<Contact> search(String searchTerm) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : all()) {
            boolean isMatch = contact.getName().toLowerCase().contains(searchTerm.toLowerCase());
            if (isMatch) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    @Override
    public List<Contact> all() {
        List<String> lines = FileManager.pull(contactsFile);
        List<Contact> contacts = new ArrayList<>();
        for (String line : lines) {
            contacts.add(fromLine(line));
        }
        return contacts;
    }
}